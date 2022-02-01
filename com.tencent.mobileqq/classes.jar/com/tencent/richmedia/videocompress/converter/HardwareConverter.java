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
    if ((this.mCopyAudio) && (HardwareConverter.ConverterContext.access$100(this.context) == null)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((this.mCopyVideo) && (HardwareConverter.ConverterContext.access$400(this.context) == null)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((i != 0) && (j != 0))
    {
      HardwareConverter.ConverterContext localConverterContext;
      if (this.mCopyAudio)
      {
        localConverterContext = this.context;
        HardwareConverter.ConverterContext.access$502(localConverterContext, this.mMuxer.addTrack(HardwareConverter.ConverterContext.access$100(localConverterContext)));
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d("HardwareConverter", 2, new Object[] { "muxer: adding audio track." });
        }
      }
      if (this.mCopyVideo)
      {
        localConverterContext = this.context;
        HardwareConverter.ConverterContext.access$602(localConverterContext, this.mMuxer.addTrack(HardwareConverter.ConverterContext.access$400(localConverterContext)));
        if (ConvertLog.isColorLevel()) {
          ConvertLog.d("HardwareConverter", 2, new Object[] { "muxer: adding video track." });
        }
      }
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("HardwareConverter", 2, new Object[] { "muxer: starting" });
      }
      this.mMuxer.start();
      return true;
    }
    return false;
  }
  
  private boolean decodeVideoToEncode(boolean paramBoolean)
  {
    MediaCodecWrapper.BufferData localBufferData = this.mVideoDecoder.dequeueOutputBuffer();
    if (localBufferData == null) {
      return paramBoolean;
    }
    MediaCodec.BufferInfo localBufferInfo = localBufferData.info;
    int j = localBufferData.index;
    boolean bool2 = false;
    if (j != -1) {
      HardwareConverter.ConverterContext.access$702(this.context, 0);
    }
    if (j == -1)
    {
      HardwareConverter.ConverterContext.access$708(this.context);
      if (HardwareConverter.ConverterContext.access$700(this.context) <= 20) {
        return paramBoolean;
      }
      throw new Exception("TooManyDecodeTimeOut");
    }
    if (j == -3) {
      return paramBoolean;
    }
    if (j == -2) {
      return paramBoolean;
    }
    if ((localBufferInfo.flags & 0x2) != 0)
    {
      this.mVideoDecoder.releaseOutputBuffer(localBufferData.index);
      return paramBoolean;
    }
    int i;
    if ((this.mAccurateSeek) && (localBufferInfo.presentationTimeUs < this.mBeginTimeUs)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (localBufferInfo.size != 0)
    {
      bool1 = bool2;
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
    if ((localBufferInfo.flags & 0x4) != 0)
    {
      this.mVideoEncoder.getInnerMediaCodec().signalEndOfInputStream();
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private void doExtractDecodeEditEncodeMux()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(262144);
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    while (((this.mCopyVideo) && (!bool5)) || ((this.mCopyAudio) && (!bool3)))
    {
      this.isInterrupted = Thread.interrupted();
      boolean bool6 = this.isInterrupted;
      int j = 1;
      if (bool6)
      {
        ConvertLog.e("HardwareConverter", 1, new Object[] { "doExtractDecodeEditEncodeMux Interrupted" });
        return;
      }
      bool6 = bool3;
      if (this.mCopyAudio)
      {
        bool6 = bool3;
        if (!bool3) {
          if (HardwareConverter.ConverterContext.access$100(this.context) != null)
          {
            bool6 = bool3;
            if (!bool4) {}
          }
          else if (HardwareConverter.ConverterContext.access$100(this.context) != null)
          {
            bool6 = processAudio(localByteBuffer);
          }
          else
          {
            HardwareConverter.ConverterContext localConverterContext = this.context;
            MediaExtractor localMediaExtractor = this.mAudioExtractor;
            HardwareConverter.ConverterContext.access$102(localConverterContext, localMediaExtractor.getTrackFormat(localMediaExtractor.getSampleTrackIndex()));
            bool6 = bool3;
          }
        }
      }
      int i = j;
      if (HardwareConverter.ConverterContext.access$200(this.context) - HardwareConverter.ConverterContext.access$300(this.context) > 0L)
      {
        i = j;
        if (!bool6) {
          if (!this.mCopyAudio) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      boolean bool9 = bool5;
      boolean bool7 = bool2;
      boolean bool8 = bool1;
      if (this.mCopyVideo)
      {
        bool9 = bool5;
        bool7 = bool2;
        bool8 = bool1;
        if (i != 0) {
          if (HardwareConverter.ConverterContext.access$400(this.context) != null)
          {
            bool9 = bool5;
            bool7 = bool2;
            bool8 = bool1;
            if (!bool4) {}
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
            bool9 = bool5;
            bool7 = bool3;
            bool8 = bool2;
            if (!bool5)
            {
              bool9 = writeEncodeVideoData();
              bool8 = bool2;
              bool7 = bool3;
            }
          }
        }
      }
      bool5 = bool9;
      bool3 = bool6;
      bool2 = bool7;
      bool1 = bool8;
      if (!bool4)
      {
        bool4 = addMuxerTrack();
        bool5 = bool9;
        bool3 = bool6;
        bool2 = bool7;
        bool1 = bool8;
      }
    }
  }
  
  private boolean extractorVideoDataToDecode(boolean paramBoolean)
  {
    MediaCodecWrapper.BufferData localBufferData = this.mVideoDecoder.getInputBuffer();
    if (localBufferData != null)
    {
      if (localBufferData.index == -1) {
        return paramBoolean;
      }
      int k = this.mVideoExtractor.readSampleData(localBufferData.buffer, 0);
      long l1 = this.mVideoExtractor.getSampleTime();
      long l2 = this.mEndTimeUs;
      if ((l2 > 0L) && (l1 >= l2)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject;
      if (k >= 0)
      {
        localObject = this.mVideoDecoder;
        int m = localBufferData.index;
        int j;
        if (i != 0) {
          j = 4;
        } else {
          j = this.mVideoExtractor.getSampleFlags();
        }
        ((MediaCodecWrapper)localObject).queueInputBuffer(m, k, l1, j);
      }
      paramBoolean = this.mVideoExtractor.advance() ^ true;
      if ((i == 0) && (!paramBoolean)) {
        return paramBoolean;
      }
      if (ConvertLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("video extractor: EOS, size = ");
        ((StringBuilder)localObject).append(k);
        ConvertLog.d("HardwareConverter", 2, new Object[] { ((StringBuilder)localObject).toString() });
      }
      int i = localBufferData.index;
      if (k >= 0)
      {
        localBufferData = this.mVideoDecoder.getInputBuffer();
        if ((localBufferData != null) && (localBufferData.index != -1))
        {
          i = localBufferData.index;
        }
        else
        {
          if (ConvertLog.isColorLevel()) {
            ConvertLog.d("HardwareConverter", 2, new Object[] { "no video decoder input buffer 1" });
          }
          return true;
        }
      }
      this.mVideoDecoder.queueInputBuffer(i, 0, 0L, 4);
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("HardwareConverter", 2, new Object[] { "videoDecoder.queueInputBuffer, MediaCodec.BUFFER_FLAG_END_OF_STREAM " });
      }
      return true;
    }
    return paramBoolean;
  }
  
  private long[] getVideoParam(MediaFormat paramMediaFormat, String paramString)
  {
    int j = paramMediaFormat.getInteger("width");
    int k = paramMediaFormat.getInteger("height");
    long l = paramMediaFormat.getLong("durationUs");
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramMediaFormat = localMediaMetadataRetriever.extractMetadata(24);
    }
    catch (IllegalArgumentException paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
      paramMediaFormat = null;
    }
    int i;
    if (paramMediaFormat != null) {
      try
      {
        i = Integer.parseInt(paramMediaFormat);
      }
      catch (NumberFormatException paramString)
      {
        ConvertLog.e("HardwareConverter", 1, "Video rotation format error ", paramString);
      }
    } else {
      i = 0;
    }
    localMediaMetadataRetriever.release();
    if (ConvertLog.isColorLevel()) {
      ConvertLog.d("HardwareConverter", 2, new Object[] { "Video size is ", Integer.valueOf(j), "x", Integer.valueOf(k), ", rotation: ", paramMediaFormat });
    }
    return new long[] { j, k, i, l };
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
    if (ConvertLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Found video codec: ");
      localStringBuilder.append(((MediaCodecInfo)localObject).getName());
      ConvertLog.d("HardwareConverter", 2, new Object[] { localStringBuilder.toString() });
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
      long l1 = this.mEndTimeUs;
      long l2 = this.mBeginTimeUs;
      this.mDurationUs = (l1 - l2);
      this.mVideoExtractor.seekTo(l2, 2);
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
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No video track found in ");
    localStringBuilder.append(paramString);
    throw new IOException(localStringBuilder.toString());
  }
  
  private void prepareVideoEncoder(VideoConverterConfig paramVideoConverterConfig, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    int i = paramInt2;
    if (!paramVideoConverterConfig.setRotation) {
      if (paramInt3 != 90)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt3 != 270) {}
      }
      else
      {
        i = paramInt1;
        j = paramInt2;
      }
    }
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
  }
  
  private boolean processAudio(ByteBuffer paramByteBuffer)
  {
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    localBufferInfo.size = this.mAudioExtractor.readSampleData(paramByteBuffer, 0);
    if (localBufferInfo.size < 0) {
      return true;
    }
    localBufferInfo.presentationTimeUs = this.mAudioExtractor.getSampleTime();
    localBufferInfo.flags = this.mAudioExtractor.getSampleFlags();
    this.mMuxer.writeSampleData(HardwareConverter.ConverterContext.access$500(this.context), paramByteBuffer, localBufferInfo);
    boolean bool = this.mAudioExtractor.advance();
    HardwareConverter.ConverterContext.access$302(this.context, localBufferInfo.presentationTimeUs);
    if ((this.mEndTimeUs > 0L) && (localBufferInfo.presentationTimeUs >= this.mEndTimeUs)) {
      return true;
    }
    return bool ^ true;
  }
  
  private boolean writeEncodeVideoData()
  {
    MediaCodecWrapper.BufferData localBufferData = this.mVideoEncoder.dequeueOutputBuffer();
    boolean bool = false;
    if (localBufferData == null) {
      return false;
    }
    MediaCodec.BufferInfo localBufferInfo = localBufferData.info;
    int i = localBufferData.index;
    if (i == -1) {
      return false;
    }
    if (i == -3) {
      return false;
    }
    if (i == -2)
    {
      if (HardwareConverter.ConverterContext.access$600(this.context) < 0)
      {
        HardwareConverter.ConverterContext.access$402(this.context, this.mVideoEncoder.getInnerMediaCodec().getOutputFormat());
        return false;
      }
      throw new IOException("video encoder changed its output format again?");
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
    Object localObject = this.mOutputSurface;
    if (localObject != null) {
      ((OutputSurface)localObject).release();
    }
    localObject = this.mInputSurface;
    if (localObject != null) {
      ((InputSurface)localObject).release();
    }
    localObject = this.mVideoEncoder;
    if (localObject != null)
    {
      ((MediaCodecWrapper)localObject).stop();
      this.mVideoEncoder.release();
    }
    localObject = this.mVideoDecoder;
    if (localObject != null)
    {
      ((MediaCodecWrapper)localObject).stop();
      this.mVideoDecoder.release();
    }
    localObject = this.mMuxer;
    if (localObject != null)
    {
      ((MediaMuxer)localObject).release();
      this.mMuxer = null;
    }
    localObject = this.mVideoExtractor;
    if (localObject != null)
    {
      ((MediaExtractor)localObject).release();
      this.mVideoExtractor = null;
    }
    localObject = this.mAudioExtractor;
    if (localObject != null)
    {
      ((MediaExtractor)localObject).release();
      this.mAudioExtractor = null;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   4: iconst_0
    //   5: invokeinterface 224 2 0
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 80	com/tencent/richmedia/videocompress/converter/HardwareConverter:originalVideoPath	Ljava/lang/String;
    //   15: aload_0
    //   16: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   19: invokespecial 606	com/tencent/richmedia/videocompress/converter/HardwareConverter:prepareCodec	(Ljava/lang/String;Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;)Z
    //   22: ifne +49 -> 71
    //   25: aload_0
    //   26: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   29: new 156	java/lang/Exception
    //   32: dup
    //   33: ldc_w 608
    //   36: invokespecial 161	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   39: invokeinterface 612 2 0
    //   44: aload_0
    //   45: invokevirtual 613	com/tencent/richmedia/videocompress/converter/HardwareConverter:release	()V
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   54: aload_1
    //   55: invokeinterface 612 2 0
    //   60: ldc 27
    //   62: iconst_1
    //   63: ldc_w 615
    //   66: aload_1
    //   67: invokestatic 376	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   70: return
    //   71: aload_0
    //   72: invokespecial 617	com/tencent/richmedia/videocompress/converter/HardwareConverter:doExtractDecodeEditEncodeMux	()V
    //   75: aload_0
    //   76: getfield 243	com/tencent/richmedia/videocompress/converter/HardwareConverter:isInterrupted	Z
    //   79: ifeq +20 -> 99
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 243	com/tencent/richmedia/videocompress/converter/HardwareConverter:isInterrupted	Z
    //   87: aload_0
    //   88: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   91: invokeinterface 620 1 0
    //   96: goto +24 -> 120
    //   99: aload_0
    //   100: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   103: sipush 10000
    //   106: invokeinterface 224 2 0
    //   111: aload_0
    //   112: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   115: invokeinterface 623 1 0
    //   120: aload_0
    //   121: invokevirtual 613	com/tencent/richmedia/videocompress/converter/HardwareConverter:release	()V
    //   124: return
    //   125: astore_1
    //   126: goto +51 -> 177
    //   129: astore_1
    //   130: ldc 27
    //   132: iconst_1
    //   133: ldc_w 625
    //   136: aload_1
    //   137: invokestatic 376	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   144: aload_1
    //   145: invokeinterface 612 2 0
    //   150: aload_0
    //   151: invokevirtual 613	com/tencent/richmedia/videocompress/converter/HardwareConverter:release	()V
    //   154: return
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   160: aload_1
    //   161: invokeinterface 612 2 0
    //   166: ldc 27
    //   168: iconst_1
    //   169: ldc_w 615
    //   172: aload_1
    //   173: invokestatic 376	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: return
    //   177: aload_0
    //   178: invokevirtual 613	com/tencent/richmedia/videocompress/converter/HardwareConverter:release	()V
    //   181: goto +24 -> 205
    //   184: astore_2
    //   185: aload_0
    //   186: getfield 82	com/tencent/richmedia/videocompress/converter/HardwareConverter:processor	Lcom/tencent/richmedia/videocompress/VideoConverter$Processor;
    //   189: aload_2
    //   190: invokeinterface 612 2 0
    //   195: ldc 27
    //   197: iconst_1
    //   198: ldc_w 615
    //   201: aload_2
    //   202: invokestatic 376	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	HardwareConverter
    //   49	18	1	localException1	Exception
    //   125	1	1	localObject	Object
    //   129	16	1	localException2	Exception
    //   155	51	1	localException3	Exception
    //   184	18	2	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	49	java/lang/Exception
    //   0	44	125	finally
    //   71	96	125	finally
    //   99	120	125	finally
    //   130	150	125	finally
    //   0	44	129	java/lang/Exception
    //   71	96	129	java/lang/Exception
    //   99	120	129	java/lang/Exception
    //   120	124	155	java/lang/Exception
    //   150	154	155	java/lang/Exception
    //   177	181	184	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.converter.HardwareConverter
 * JD-Core Version:    0.7.0.1
 */