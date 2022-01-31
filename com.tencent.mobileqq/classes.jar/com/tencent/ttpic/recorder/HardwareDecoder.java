package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.filter.Frame;
import com.tencent.filter.SurfaceTextrueFilter;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.LogUtil;
import com.tencent.view.RendererUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HardwareDecoder
  implements IVideoDecoder
{
  private static final String TAG = HardwareDecoder.class.getSimpleName();
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private ByteBuffer[] inputBuffers;
  private boolean isEOS = false;
  private MediaCodec mDecoder;
  private Surface mDecoderSurface;
  private int mDstTex;
  private long mDuration;
  private MediaExtractor mExtractor;
  private String mFilename;
  private Frame mFrame = new Frame();
  private boolean mHasNewFrame;
  private int mHeight;
  private long mLastFramestamp = -1L;
  private long mLastMaskstamp = -1L;
  private SurfaceTextrueFilter mSurfaceTexFilter = new SurfaceTextrueFilter();
  private SurfaceTexture mSurfaceTexture;
  private int mTempTex;
  private final float[] mTransformMatrix = new float[16];
  private int mWidth;
  
  public HardwareDecoder(String paramString, int paramInt)
    throws IOException
  {
    this.mFilename = paramString;
    this.mDstTex = paramInt;
    this.mTempTex = RendererUtils.createTexture();
    this.mSurfaceTexFilter.ApplyGLSLFilter();
    this.mSurfaceTexture = new SurfaceTexture(this.mTempTex);
    this.mSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        HardwareDecoder.access$002(HardwareDecoder.this, true);
        HardwareDecoder.this.mSurfaceTexture.updateTexImage();
        HardwareDecoder.this.mSurfaceTexture.getTransformMatrix(HardwareDecoder.this.mTransformMatrix);
        HardwareDecoder.this.mSurfaceTexFilter.nativeUpdateMatrix(HardwareDecoder.this.mTransformMatrix);
      }
    });
    this.mDecoderSurface = new Surface(this.mSurfaceTexture);
    this.mExtractor = new MediaExtractor();
    setExtractorDataSource(this.mExtractor, this.mFilename);
    prepare();
  }
  
  private int decodeNext(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      if (!Thread.interrupted()) {
        if (!this.isEOS)
        {
          j = this.mDecoder.dequeueInputBuffer(10000L);
          if (j >= 0)
          {
            ByteBuffer localByteBuffer = this.inputBuffers[j];
            k = this.mExtractor.readSampleData(localByteBuffer, 0);
            if (k >= 0) {
              break label115;
            }
            LogUtil.d(TAG, "extractor read sample to EOS");
            this.mDecoder.queueInputBuffer(j, 0, 0, 0L, 4);
            this.isEOS = true;
          }
        }
      }
      for (;;)
      {
        j = this.mDecoder.dequeueOutputBuffer(this.info, 10000L);
        if ((this.info.flags & 0x4) == 0) {
          break;
        }
        return 0;
        label115:
        this.mDecoder.queueInputBuffer(j, 0, k, this.mExtractor.getSampleTime(), 0);
        this.mExtractor.advance();
      }
      switch (j)
      {
      case -3: 
      case -2: 
      default: 
        if (this.info.presentationTimeUs / 1000L >= paramLong)
        {
          this.mDecoder.releaseOutputBuffer(j, true);
          this.mLastMaskstamp = (this.info.presentationTimeUs / 1000L);
          return 0;
        }
        break;
      case -1: 
        j = i + 1;
        i = j;
        if (j <= 10) {
          continue;
        }
        LogUtil.e(TAG, "dequeueOutputBuffer timed out! eos = " + this.isEOS);
        return -1;
      }
      this.mDecoder.releaseOutputBuffer(j, false);
    }
  }
  
  private void prepare()
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mExtractor.getTrackCount())
      {
        MediaFormat localMediaFormat = this.mExtractor.getTrackFormat(i);
        String str = localMediaFormat.getString("mime");
        if (str.startsWith("video/"))
        {
          this.mExtractor.selectTrack(i);
          LogUtil.d(TAG, "extractor video track selected");
          this.mWidth = localMediaFormat.getInteger("width");
          this.mHeight = localMediaFormat.getInteger("height");
          this.mDuration = (localMediaFormat.getLong("durationUs") / 1000L);
          LogUtil.d(TAG, "width = " + this.mWidth + ", height = " + this.mHeight + ", mDuration = " + this.mDuration);
          this.mDecoder = MediaCodec.createDecoderByType(str);
          localMediaFormat.setInteger("max-input-size", 0);
          this.mDecoder.configure(localMediaFormat, this.mDecoderSurface, null, 0);
        }
      }
      else
      {
        if (this.mDecoder != null) {
          break;
        }
        LogUtil.e(TAG, "Can't find video info!");
        return;
      }
      i += 1;
    }
    this.mDecoder.start();
    this.inputBuffers = this.mDecoder.getInputBuffers();
    this.isEOS = false;
  }
  
  private static void setExtractorDataSource(MediaExtractor paramMediaExtractor, String paramString)
    throws IOException
  {
    if (paramString.startsWith("assets://"))
    {
      paramString = paramString.substring("assets://".length());
      paramString = VideoGlobalContext.getContext().getAssets().openFd(paramString);
      paramMediaExtractor.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      paramString.close();
      return;
    }
    paramMediaExtractor.setDataSource(paramString);
  }
  
  public void decodeFrame(long paramLong)
  {
    if (this.mDecoderSurface == null) {
      throw new RuntimeException("You haven't set surfaceTexture?!");
    }
    paramLong %= this.mDuration;
    if (paramLong < this.mLastFramestamp) {
      reset();
    }
    this.mLastFramestamp = paramLong;
    if (paramLong < this.mLastMaskstamp) {
      return;
    }
    try
    {
      decodeNext(paramLong);
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "decodeNext error: ", localException);
      throw localException;
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isLive()
  {
    return this.mDecoder != null;
  }
  
  public void release()
  {
    RendererUtils.clearTexture(this.mTempTex);
    this.mSurfaceTexFilter.clearGLSLSelf();
    this.mFrame.clear();
    if (this.mDecoderSurface != null) {
      this.mDecoderSurface.release();
    }
    if (this.mSurfaceTexture != null) {
      this.mSurfaceTexture.release();
    }
    if (this.mExtractor != null) {
      this.mExtractor.release();
    }
    if (this.mDecoder != null)
    {
      this.mDecoder.stop();
      this.mDecoder.release();
      LogUtil.i(TAG, "taa mDecoder stop and release");
      this.mDecoder = null;
    }
  }
  
  public void reset()
  {
    if (this.mExtractor != null) {
      this.mExtractor.seekTo(0L, 0);
    }
    this.isEOS = false;
    this.mLastMaskstamp = -1L;
    this.mLastFramestamp = -1L;
  }
  
  public void updateFrame()
  {
    if (this.mHasNewFrame)
    {
      this.mSurfaceTexFilter.RenderProcess(this.mTempTex, getWidth(), getHeight(), this.mDstTex, 0.0D, this.mFrame);
      this.mHasNewFrame = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.HardwareDecoder
 * JD-Core Version:    0.7.0.1
 */