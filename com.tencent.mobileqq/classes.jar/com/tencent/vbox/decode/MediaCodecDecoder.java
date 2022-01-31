package com.tencent.vbox.decode;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(18)
public class MediaCodecDecoder
{
  private static final String TAG = MediaCodecDecoder.class.getSimpleName();
  private MediaCodec decoder;
  private MediaExtractor extractor = new MediaExtractor();
  private long framestamp;
  private int height;
  private int index = -1;
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private ByteBuffer[] inputBuffers;
  private boolean isEOS = false;
  private Surface mDecoderSurface;
  private int rotation;
  private MediaFormat videoFormat;
  private int width;
  
  public MediaCodecDecoder(String paramString)
  {
    for (;;)
    {
      try
      {
        this.extractor.setDataSource(paramString);
        if (i < this.extractor.getTrackCount())
        {
          paramString = this.extractor.getTrackFormat(i);
          if (paramString.getString("mime").startsWith("video/"))
          {
            this.extractor.selectTrack(i);
            this.videoFormat = paramString;
          }
        }
        else
        {
          this.width = this.videoFormat.getInteger("width");
          this.height = this.videoFormat.getInteger("height");
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        try
        {
          this.rotation = this.videoFormat.getInteger("rotation-degrees");
          return;
        }
        catch (Exception paramString) {}
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  private void internalStart()
  {
    this.videoFormat.setInteger("rotation-degrees", 0);
    this.decoder = MediaCodec.createDecoderByType(this.videoFormat.getString("mime"));
    this.decoder.configure(this.videoFormat, this.mDecoderSurface, null, 0);
    if (this.decoder == null)
    {
      Log.e(TAG, "Can't find video info!");
      return;
    }
    this.decoder.start();
    this.inputBuffers = this.decoder.getInputBuffers();
    this.index = -1;
  }
  
  public int decodeNext(int paramInt)
  {
    while (!Thread.interrupted())
    {
      int i;
      int j;
      if (!this.isEOS)
      {
        i = this.decoder.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          ByteBuffer localByteBuffer = this.inputBuffers[i];
          j = this.extractor.readSampleData(localByteBuffer, 0);
          if (j >= 0) {
            break label151;
          }
          Log.d(TAG, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
          this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
          this.isEOS = true;
        }
      }
      for (;;)
      {
        i = this.decoder.dequeueOutputBuffer(this.info, 10000L);
        if ((this.info.flags & 0x4) == 0) {
          break;
        }
        Log.i(TAG, "total decode " + (this.index + 1) + " frames");
        Log.d(TAG, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        return -1;
        label151:
        this.decoder.queueInputBuffer(i, 0, j, this.extractor.getSampleTime(), 0);
        this.extractor.advance();
      }
      switch (i)
      {
      default: 
        this.index += 1;
        if (this.index < paramInt) {
          break label316;
        }
        this.decoder.releaseOutputBuffer(i, true);
        Log.d(TAG, "decode one frame!");
        this.framestamp = this.info.presentationTimeUs;
        return 0;
      case -3: 
        Log.d(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
        break;
      case -2: 
        Log.d(TAG, "New format " + this.decoder.getOutputFormat());
        break;
      }
      Log.d(TAG, "dequeueOutputBuffer timed out!");
      continue;
      label316:
      this.decoder.releaseOutputBuffer(i, false);
    }
    return -1;
  }
  
  public long getFramestamp()
  {
    return this.framestamp;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getRotation()
  {
    return this.rotation;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void release()
  {
    if (this.mDecoderSurface != null)
    {
      this.mDecoderSurface.release();
      this.mDecoderSurface = null;
    }
    if (this.extractor != null)
    {
      this.extractor.release();
      this.extractor = null;
    }
    if (this.decoder != null)
    {
      this.decoder.stop();
      this.decoder.release();
      this.decoder = null;
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mDecoderSurface = paramSurface;
  }
  
  public void start()
  {
    try
    {
      internalStart();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.decode.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */