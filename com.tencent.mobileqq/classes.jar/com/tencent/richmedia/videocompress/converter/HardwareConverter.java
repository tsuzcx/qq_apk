package com.tencent.richmedia.videocompress.converter;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.mediacodec.InputSurface;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecUtil;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper.BufferData;
import com.tencent.richmedia.videocompress.mediacodec.OutputSurface;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(api=18)
public class HardwareConverter
  implements Runnable
{
  private static final int MAX_DECODE_TIME_OUT_COUNT = 20;
  private static final int MAX_SAMPLE_SIZE = 262144;
  private static final long MAX_VA_OFFSET = 0L;
  private static final int OUTPUT_VIDEO_COLOR_FORMAT = 2130708361;
  private static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
  private static final String TAG = "HardwareConverter";
  private static final boolean VERBOSE_MODE = false;
  private HardwareConverter.ConverterContext context = new HardwareConverter.ConverterContext(null);
  private boolean isInterrupted;
  private boolean mAccurateSeek;
  private MediaExtractor mAudioExtractor;
  private long mBeginTimeUs = -1L;
  private boolean mCopyAudio = true;
  private boolean mCopyVideo = true;
  private long mDurationUs = -1L;
  private long mEndTimeUs = -1L;
  private InputSurface mInputSurface;
  private MediaMuxer mMuxer;
  private OutputSurface mOutputSurface;
  private MediaCodecWrapper mVideoDecoder;
  private MediaCodecWrapper mVideoEncoder;
  private MediaExtractor mVideoExtractor;
  private String originalVideoPath;
  private VideoConverter.Processor processor;
  
  public HardwareConverter(String paramString, VideoConverter.Processor paramProcessor)
  {
    this.originalVideoPath = paramString;
    this.processor = paramProcessor;
  }
  
  private boolean addMuxerTrack()
  {
    int i;
    if ((!this.mCopyAudio) || (HardwareConverter.ConverterContext.access$100(this.context) != null))
    {
      i = 1;
      if ((this.mCopyVideo) && (HardwareConverter.ConverterContext.access$400(this.context) == null)) {
        break label181;
      }
    }
    label181:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label186;
      }
      if (this.mCopyAudio)
      {
        HardwareConverter.ConverterContext.access$502(this.context, this.mMuxer.addTrack(HardwareConverter.ConverterContext.access$100(this.context)));
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d("HardwareConverter", 2, new Object[] { "muxer: adding audio track." });
        }
      }
      if (this.mCopyVideo)
      {
        HardwareConverter.ConverterContext.access$602(this.context, this.mMuxer.addTrack(HardwareConverter.ConverterContext.access$400(this.context)));
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d("HardwareConverter", 2, new Object[] { "muxer: adding video track." });
        }
      }
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("HardwareConverter", 2, new Object[] { "muxer: starting" });
      }
      this.mMuxer.start();
      return true;
      i = 0;
      break;
    }
    label186:
    return false;
  }
  
  private boolean decodeVideoToEncode(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    MediaCodecWrapper.BufferData localBufferData = this.mVideoDecoder.dequeueOutputBuffer();
    if (localBufferData == null) {}
    MediaCodec.BufferInfo localBufferInfo;
    int j;
    do
    {
      do
      {
        return paramBoolean;
        localBufferInfo = localBufferData.info;
        j = localBufferData.index;
        if (j != -1) {
          HardwareConverter.ConverterContext.access$702(this.context, 0);
        }
        if (j != -1) {
          break;
        }
        HardwareConverter.ConverterContext.access$708(this.context);
      } while (HardwareConverter.ConverterContext.access$700(this.context) <= 20);
      throw new Exception("TooManyDecodeTimeOut");
    } while ((j == -3) || (j == -2));
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      this.mVideoDecoder.releaseOutputBuffer(localBufferData.index);
      return paramBoolean;
    }
    int i;
    if ((this.mAccurateSeek) && (localBufferInfo.presentationTimeUs < this.mBeginTimeUs))
    {
      i = 1;
      boolean bool1 = bool3;
      if (localBufferInfo.size != 0)
      {
        bool1 = bool3;
        if (i == 0) {
          bool1 = true;
        }
      }
      this.mVideoDecoder.getInnerMediaCodec().releaseOutputBuffer(j, bool1);
      if (bool1)
      {
        this.mOutputSurface.awaitNewImage();
        this.mOutputSurface.drawImage();
        this.mInputSurface.setPresentationTime(localBufferInfo.presentationTimeUs * 1000L);
        this.mInputSurface.swapBuffers();
        if (HardwareConverter.ConverterContext.access$800(this.context) < 0L) {
          HardwareConverter.ConverterContext.access$802(this.context, localBufferInfo.presentationTimeUs);
        }
        float f = (float)(localBufferInfo.presentationTimeUs - HardwareConverter.ConverterContext.access$800(this.context)) / (float)this.mDurationUs;
        this.processor.onProgress((int)(f * 10000.0F));
      }
      if ((localBufferInfo.flags & 0x4) == 0) {
        break label317;
      }
      this.mVideoEncoder.getInnerMediaCodec().signalEndOfInputStream();
      paramBoolean = bool2;
    }
    label317:
    for (;;)
    {
      return paramBoolean;
      i = 0;
      break;
    }
  }
  
  private void doExtractDecodeEditEncodeMux()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if (((this.mCopyVideo) && (!bool4)) || ((this.mCopyAudio) && (!bool3)))
    {
      this.isInterrupted = Thread.interrupted();
      if (this.isInterrupted) {
        ConvertLog.e("HardwareConverter", 1, new Object[] { "doExtractDecodeEditEncodeMux Interrupted" });
      }
    }
    else
    {
      return;
    }
    boolean bool6 = bool3;
    if (this.mCopyAudio)
    {
      bool6 = bool3;
      if (!bool3) {
        if (HardwareConverter.ConverterContext.access$100(this.context) != null)
        {
          bool6 = bool3;
          if (!bool5) {}
        }
        else
        {
          if (HardwareConverter.ConverterContext.access$100(this.context) == null) {
            break label318;
          }
          bool6 = processAudio(localByteBuffer);
        }
      }
    }
    label131:
    if ((HardwareConverter.ConverterContext.access$200(this.context) - HardwareConverter.ConverterContext.access$300(this.context) <= 0L) || (bool6) || (!this.mCopyAudio)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool9 = bool4;
      boolean bool7 = bool1;
      boolean bool8 = bool2;
      if (this.mCopyVideo)
      {
        bool9 = bool4;
        bool7 = bool1;
        bool8 = bool2;
        if (i != 0) {
          if (HardwareConverter.ConverterContext.access$400(this.context) != null)
          {
            bool9 = bool4;
            bool7 = bool1;
            bool8 = bool2;
            if (!bool5) {}
          }
          else
          {
            bool3 = bool2;
            if (!bool2) {
              bool3 = extractorVideoDataToDecode(bool2);
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = decodeVideoToEncode(bool1);
            }
            bool9 = bool4;
            bool7 = bool2;
            bool8 = bool3;
            if (!bool4)
            {
              bool9 = writeEncodeVideoData();
              bool8 = bool3;
              bool7 = bool2;
            }
          }
        }
      }
      bool3 = bool6;
      bool4 = bool9;
      bool1 = bool7;
      bool2 = bool8;
      if (bool5) {
        break;
      }
      bool5 = addMuxerTrack();
      bool3 = bool6;
      bool4 = bool9;
      bool1 = bool7;
      bool2 = bool8;
      break;
      label318:
      HardwareConverter.ConverterContext.access$102(this.context, this.mAudioExtractor.getTrackFormat(this.mAudioExtractor.getSampleTrackIndex()));
      bool6 = bool3;
      break label131;
    }
  }
  
  private boolean extractorVideoDataToDecode(boolean paramBoolean)
  {
    MediaCodecWrapper.BufferData localBufferData = this.mVideoDecoder.getInputBuffer();
    if ((localBufferData == null) || (localBufferData.index == -1)) {}
    label70:
    label94:
    label236:
    label247:
    label253:
    do
    {
      return paramBoolean;
      int k = this.mVideoExtractor.readSampleData(localBufferData.buffer, 0);
      long l = this.mVideoExtractor.getSampleTime();
      int j;
      if ((this.mEndTimeUs > 0L) && (l >= this.mEndTimeUs))
      {
        i = 1;
        if (k >= 0)
        {
          MediaCodecWrapper localMediaCodecWrapper = this.mVideoDecoder;
          int m = localBufferData.index;
          if (i == 0) {
            break label236;
          }
          j = 4;
          localMediaCodecWrapper.queueInputBuffer(m, k, l, j);
        }
        if (this.mVideoExtractor.advance()) {
          break label247;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (i == 0)
        {
          paramBoolean = bool;
          if (!bool) {
            break;
          }
        }
        paramBoolean = true;
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d("HardwareConverter", 2, new Object[] { "video extractor: EOS, size = " + k });
        }
        i = localBufferData.index;
        if (k < 0) {
          break label259;
        }
        localBufferData = this.mVideoDecoder.getInputBuffer();
        if ((localBufferData != null) && (localBufferData.index != -1)) {
          break label253;
        }
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d("HardwareConverter", 2, new Object[] { "no video decoder input buffer 1" });
        }
        return true;
        i = 0;
        break label70;
        j = this.mVideoExtractor.getSampleFlags();
        break label94;
      }
      int i = localBufferData.index;
      this.mVideoDecoder.queueInputBuffer(i, 0, 0L, 4);
    } while (!ConvertLog.isColorLevel());
    label259:
    ConvertLog.d("HardwareConverter", 2, new Object[] { "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM " });
    return true;
  }
  
  private long[] getVideoParam(MediaFormat paramMediaFormat, String paramString)
  {
    int k = paramMediaFormat.getInteger("width");
    int m = paramMediaFormat.getInteger("height");
    long l = paramMediaFormat.getLong("durationUs");
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    paramMediaFormat = null;
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(24);
      paramMediaFormat = paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        int i;
        paramString.printStackTrace();
        continue;
        try
        {
          int j = Integer.parseInt(paramMediaFormat);
          i = j;
        }
        catch (NumberFormatException paramString)
        {
          ConvertLog.e("HardwareConverter", 1, "Video rotation format error ", paramString);
        }
      }
    }
    i = 0;
    if (paramMediaFormat == null)
    {
      i = 0;
      localMediaMetadataRetriever.release();
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("HardwareConverter", 2, new Object[] { "Video size is ", Integer.valueOf(k), "x", Integer.valueOf(m), ", rotation: ", paramMediaFormat });
      }
      return new long[] { k, m, i, l };
    }
  }
  
  private boolean prepareCodec(String paramString, VideoConverter.Processor paramProcessor)
  {
    Object localObject = MediaCodecUtil.selectCodec("video/avc");
    if (localObject == null)
    {
      if (ConvertLog.isColorLevel()) {
        ConvertLog.e("HardwareConverter", 2, new Object[] { "Unable to find an appropriate codec for video/avc" });
      }
      throw new IOException("Unable to find an appropriate codec for video/avc");
    }
    if (ConvertLog.isColorLevel()) {
      ConvertLog.d("HardwareConverter", 2, new Object[] { "Found video codec: " + ((MediaCodecInfo)localObject).getName() });
    }
    int i = prepareExtractor(paramString);
    localObject = this.mVideoExtractor.getTrackFormat(i);
    paramString = getVideoParam((MediaFormat)localObject, paramString);
    i = (int)paramString[0];
    int j = (int)paramString[1];
    int k = (int)paramString[2];
    this.mDurationUs = paramString[3];
    paramString = paramProcessor.getEncodeConfig(i, j);
    if (!paramString.isNeedCompress)
    {
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("HardwareConverter", 2, new Object[] { "compressVideo error, isNeedCompress is false" });
      }
      return false;
    }
    paramProcessor = new File(paramString.output);
    if (paramProcessor.exists()) {
      paramProcessor.delete();
    }
    if ((paramString.beginTime >= 0L) && (paramString.endTime > 0L) && (paramString.endTime - paramString.beginTime >= 1000L))
    {
      this.mEndTimeUs = (paramString.endTime * 1000L);
      this.mBeginTimeUs = (paramString.beginTime * 1000L);
      this.mDurationUs = (this.mEndTimeUs - this.mBeginTimeUs);
      this.mVideoExtractor.seekTo(this.mBeginTimeUs, 2);
      this.mAudioExtractor.seekTo(this.mBeginTimeUs, 2);
    }
    if (paramString.isMute) {
      this.mCopyAudio = false;
    }
    if (paramString.accurateSeek) {
      this.mAccurateSeek = true;
    }
    if (this.mCopyVideo)
    {
      prepareVideoEncoder(paramString, i, j, k);
      this.mOutputSurface = new OutputSurface();
      this.mVideoDecoder = MediaCodecUtil.createVideoDecoder((MediaFormat)localObject, this.mOutputSurface.getSurface());
    }
    this.mMuxer = new MediaMuxer(paramString.output, 0);
    if ((this.mCopyVideo) && (paramString.setRotation)) {
      this.mMuxer.setOrientationHint(k);
    }
    return true;
  }
  
  private int prepareExtractor(String paramString)
  {
    this.mAudioExtractor = new MediaExtractor();
    this.mAudioExtractor.setDataSource(paramString);
    if (MediaCodecUtil.getAndSelectAudioTrackIndex(this.mAudioExtractor) < 0) {
      this.mCopyAudio = false;
    }
    this.mVideoExtractor = new MediaExtractor();
    this.mVideoExtractor.setDataSource(paramString);
    int i = MediaCodecUtil.getAndSelectVideoTrackIndex(this.mVideoExtractor);
    if (i < 0) {
      throw new IOException("No video track found in " + paramString);
    }
    return i;
  }
  
  private void prepareVideoEncoder(VideoConverterConfig paramVideoConverterConfig, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    int j;
    if (!paramVideoConverterConfig.setRotation)
    {
      i = paramInt1;
      j = paramInt2;
      if (paramInt3 != 90)
      {
        if (paramInt3 != 270) {
          break label254;
        }
        j = paramInt2;
        i = paramInt1;
      }
    }
    for (;;)
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", Math.round(j * paramVideoConverterConfig.scaleRate / 16.0F) * 16, Math.round(i * paramVideoConverterConfig.scaleRate / 16.0F) * 16);
      localMediaFormat.setInteger("color-format", 2130708361);
      localMediaFormat.setInteger("bitrate", paramVideoConverterConfig.videoBitRate);
      localMediaFormat.setFloat("frame-rate", paramVideoConverterConfig.videoFrameRate);
      localMediaFormat.setInteger("i-frame-interval", paramVideoConverterConfig.iFrameInterval);
      if (paramVideoConverterConfig.setProfileLevel)
      {
        localMediaFormat.setInteger("profile", paramVideoConverterConfig.profile);
        localMediaFormat.setInteger("level", paramVideoConverterConfig.level);
      }
      if ((paramVideoConverterConfig.bitrateMode != -1) && (Build.VERSION.SDK_INT >= 21)) {
        localMediaFormat.setInteger("bitrate-mode", paramVideoConverterConfig.bitrateMode);
      }
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("HardwareConverter", 2, new Object[] { "video format: ", localMediaFormat });
      }
      paramVideoConverterConfig = new AtomicReference();
      this.mVideoEncoder = MediaCodecUtil.createVideoEncoder(localMediaFormat, paramVideoConverterConfig);
      this.mInputSurface = new InputSurface((Surface)paramVideoConverterConfig.get());
      this.mInputSurface.makeCurrent();
      return;
      label254:
      i = paramInt2;
      j = paramInt1;
    }
  }
  
  private boolean processAudio(ByteBuffer paramByteBuffer)
  {
    boolean bool = false;
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    localBufferInfo.size = this.mAudioExtractor.readSampleData(paramByteBuffer, 0);
    if (localBufferInfo.size < 0) {}
    do
    {
      return true;
      localBufferInfo.presentationTimeUs = this.mAudioExtractor.getSampleTime();
      localBufferInfo.flags = this.mAudioExtractor.getSampleFlags();
      this.mMuxer.writeSampleData(HardwareConverter.ConverterContext.access$500(this.context), paramByteBuffer, localBufferInfo);
      if (!this.mAudioExtractor.advance()) {
        bool = true;
      }
      HardwareConverter.ConverterContext.access$302(this.context, localBufferInfo.presentationTimeUs);
    } while ((this.mEndTimeUs > 0L) && (localBufferInfo.presentationTimeUs >= this.mEndTimeUs));
    return bool;
  }
  
  private boolean writeEncodeVideoData()
  {
    boolean bool = false;
    MediaCodecWrapper.BufferData localBufferData = this.mVideoEncoder.dequeueOutputBuffer();
    if (localBufferData == null) {}
    MediaCodec.BufferInfo localBufferInfo;
    int i;
    do
    {
      return false;
      localBufferInfo = localBufferData.info;
      i = localBufferData.index;
    } while ((i == -1) || (i == -3));
    if (i == -2)
    {
      if (HardwareConverter.ConverterContext.access$600(this.context) >= 0) {
        throw new IOException("video encoder changed its output format again?");
      }
      HardwareConverter.ConverterContext.access$402(this.context, this.mVideoEncoder.getInnerMediaCodec().getOutputFormat());
      return false;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      this.mVideoEncoder.releaseOutputBuffer(localBufferData.index);
      return false;
    }
    if (localBufferInfo.size != 0)
    {
      this.mMuxer.writeSampleData(HardwareConverter.ConverterContext.access$600(this.context), localBufferData.buffer, localBufferInfo);
      HardwareConverter.ConverterContext.access$202(this.context, localBufferInfo.presentationTimeUs);
      float f = (float)(localBufferInfo.presentationTimeUs - HardwareConverter.ConverterContext.access$800(this.context)) / (float)this.mDurationUs;
      this.processor.onProgress((int)(f * 10000.0F));
    }
    if ((localBufferInfo.flags & 0x4) != 0) {
      bool = true;
    }
    this.mVideoEncoder.releaseOutputBuffer(localBufferData.index);
    return bool;
  }
  
  protected void release()
  {
    if (ConvertLog.isColorLevel()) {
      ConvertLog.d("HardwareConverter", 2, new Object[] { "shutting down encoder, decoder" });
    }
    if (this.mOutputSurface != null) {
      this.mOutputSurface.release();
    }
    if (this.mInputSurface != null) {
      this.mInputSurface.release();
    }
    if (this.mVideoEncoder != null)
    {
      this.mVideoEncoder.stop();
      this.mVideoEncoder.release();
    }
    if (this.mVideoDecoder != null)
    {
      this.mVideoDecoder.stop();
      this.mVideoDecoder.release();
    }
    if (this.mMuxer != null)
    {
      this.mMuxer.release();
      this.mMuxer = null;
    }
    if (this.mVideoExtractor != null)
    {
      this.mVideoExtractor.release();
      this.mVideoExtractor = null;
    }
    if (this.mAudioExtractor != null)
    {
      this.mAudioExtractor.release();
      this.mAudioExtractor = null;
    }
  }
  
  public void run()
  {
    try
    {
      this.processor.onProgress(0);
      if (!prepareCodec(this.originalVideoPath, this.processor))
      {
        this.processor.onFail(new Exception("noNeedCompress"));
        try
        {
          release();
          return;
        }
        catch (Exception localException1)
        {
          this.processor.onFail(localException1);
          ConvertLog.e("HardwareConverter", 1, "release Hw Resource error", localException1);
          return;
        }
      }
      doExtractDecodeEditEncodeMux();
      if (this.isInterrupted)
      {
        this.isInterrupted = false;
        this.processor.onCancel();
      }
      for (;;)
      {
        try
        {
          release();
          return;
        }
        catch (Exception localException2)
        {
          this.processor.onFail(localException2);
          ConvertLog.e("HardwareConverter", 1, "release Hw Resource error", localException2);
          return;
        }
        this.processor.onProgress(10000);
        this.processor.onSuccess();
      }
      try
      {
        release();
        throw localObject;
      }
      catch (Exception localException5)
      {
        for (;;)
        {
          this.processor.onFail(localException5);
          ConvertLog.e("HardwareConverter", 1, "release Hw Resource error", localException5);
        }
      }
    }
    catch (Exception localException3)
    {
      localException3 = localException3;
      ConvertLog.e("HardwareConverter", 1, "Converter run error", localException3);
      this.processor.onFail(localException3);
      try
      {
        release();
        return;
      }
      catch (Exception localException4)
      {
        this.processor.onFail(localException4);
        ConvertLog.e("HardwareConverter", 1, "release Hw Resource error", localException4);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.converter.HardwareConverter
 * JD-Core Version:    0.7.0.1
 */