package com.tencent.thumbplayer.adapter.player.thumbplayer;

import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo;
import com.tencent.thumbplayer.utils.TPEnumUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPThumbPlayerUtils
{
  public static final int OPTIONAL_ID_TYPE_BOOL = 3;
  public static final int OPTIONAL_ID_TYPE_FLOAT = 7;
  public static final int OPTIONAL_ID_TYPE_INT = 4;
  public static final int OPTIONAL_ID_TYPE_LONG = 1;
  public static final int OPTIONAL_ID_TYPE_QUEUE_INT = 5;
  public static final int OPTIONAL_ID_TYPE_QUEUE_STRING = 6;
  public static final int OPTIONAL_ID_TYPE_STRING = 2;
  private static String TAG = "TPThumbPlayerUtils";
  
  public static TPAudioFrameBuffer convert2TPAudioFrameBuffer(TPAudioFrame paramTPAudioFrame)
  {
    if (paramTPAudioFrame == null) {
      return null;
    }
    TPAudioFrameBuffer localTPAudioFrameBuffer = new TPAudioFrameBuffer();
    localTPAudioFrameBuffer.format = TPEnumUtils.convertAudioFrameFormat2Outter(paramTPAudioFrame.format);
    localTPAudioFrameBuffer.data = paramTPAudioFrame.data;
    localTPAudioFrameBuffer.size = paramTPAudioFrame.linesize;
    localTPAudioFrameBuffer.sampleRate = paramTPAudioFrame.sampleRate;
    localTPAudioFrameBuffer.channelLayout = paramTPAudioFrame.channelLayout;
    localTPAudioFrameBuffer.ptsMs = (paramTPAudioFrame.ptsUs / 1000L);
    localTPAudioFrameBuffer.nbSamples = paramTPAudioFrame.nbSamples;
    localTPAudioFrameBuffer.channels = paramTPAudioFrame.channels;
    return localTPAudioFrameBuffer;
  }
  
  public static int convert2TPDecoderType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      TPLogUtil.e(TAG, "decoderType: " + paramInt + " not recognition, return -1");
      return -1;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 101: 
      return 101;
    }
    return 102;
  }
  
  public static TPPlayerMsg.TPMediaCodecInfo convert2TPMediaCodecInfo(ITPNativePlayerMessageCallback.MediaCodecInfo paramMediaCodecInfo)
  {
    if (paramMediaCodecInfo == null) {
      return null;
    }
    TPPlayerMsg.TPMediaCodecInfo localTPMediaCodecInfo = new TPPlayerMsg.TPMediaCodecInfo();
    switch (paramMediaCodecInfo.mediaType)
    {
    default: 
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_UNKNOWN;
      switch (paramMediaCodecInfo.infoType)
      {
      default: 
        localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_UNKNOWN;
      }
      break;
    }
    for (;;)
    {
      localTPMediaCodecInfo.msg = paramMediaCodecInfo.msg;
      return localTPMediaCodecInfo;
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO;
      break;
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_AUDIO;
      break;
      localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY;
      continue;
      localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION;
    }
  }
  
  public static TPSurfaceRenderInfo convert2TPPlayerSurfaceRenderInfo(TPNativePlayerSurfaceRenderInfo paramTPNativePlayerSurfaceRenderInfo)
  {
    if (paramTPNativePlayerSurfaceRenderInfo == null) {
      return null;
    }
    TPSurfaceRenderInfo localTPSurfaceRenderInfo = new TPSurfaceRenderInfo();
    localTPSurfaceRenderInfo.displayWidth = paramTPNativePlayerSurfaceRenderInfo.displayWidth;
    localTPSurfaceRenderInfo.displayHeight = paramTPNativePlayerSurfaceRenderInfo.displayHeight;
    localTPSurfaceRenderInfo.videoCropInfo = convert2TPVideoCropInfo(paramTPNativePlayerSurfaceRenderInfo.videoCropInfo);
    return localTPSurfaceRenderInfo;
  }
  
  public static TPPostProcessFrame convert2TPPostProcessFrame(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    if (paramTPPostProcessFrameBuffer == null) {
      return null;
    }
    TPPostProcessFrame localTPPostProcessFrame = new TPPostProcessFrame();
    localTPPostProcessFrame.mediaType = TPEnumUtils.convertMediaType2Inner(paramTPPostProcessFrameBuffer.mediaType);
    if (localTPPostProcessFrame.mediaType == 0) {
      localTPPostProcessFrame.format = TPEnumUtils.convertVideoFrameFormat2Inner(paramTPPostProcessFrameBuffer.format);
    }
    for (;;)
    {
      localTPPostProcessFrame.data = paramTPPostProcessFrameBuffer.data;
      localTPPostProcessFrame.linesize = paramTPPostProcessFrameBuffer.size;
      localTPPostProcessFrame.sampleRate = paramTPPostProcessFrameBuffer.sampleRate;
      localTPPostProcessFrame.channelLayout = paramTPPostProcessFrameBuffer.channelLayout;
      localTPPostProcessFrame.ptsUs = (paramTPPostProcessFrameBuffer.ptsMs * 1000L);
      localTPPostProcessFrame.nbSamples = paramTPPostProcessFrameBuffer.nbSamples;
      localTPPostProcessFrame.channels = paramTPPostProcessFrameBuffer.channels;
      localTPPostProcessFrame.width = paramTPPostProcessFrameBuffer.width;
      localTPPostProcessFrame.height = paramTPPostProcessFrameBuffer.height;
      localTPPostProcessFrame.sampleAspectRatioNum = paramTPPostProcessFrameBuffer.sampleAspectRatioNum;
      localTPPostProcessFrame.sampleAspectRatioDen = paramTPPostProcessFrameBuffer.sampleAspectRatioDen;
      localTPPostProcessFrame.rotation = paramTPPostProcessFrameBuffer.rotation;
      localTPPostProcessFrame.perfData = paramTPPostProcessFrameBuffer.perfData;
      return localTPPostProcessFrame;
      if (localTPPostProcessFrame.mediaType == 1) {
        localTPPostProcessFrame.format = TPEnumUtils.convertAudioFrameFormat2Inner(paramTPPostProcessFrameBuffer.format);
      }
    }
  }
  
  public static TPPostProcessFrameBuffer convert2TPPostProcessFrameBuffer(TPPostProcessFrame paramTPPostProcessFrame)
  {
    if (paramTPPostProcessFrame == null) {
      return null;
    }
    TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = new TPPostProcessFrameBuffer();
    localTPPostProcessFrameBuffer.mediaType = TPEnumUtils.convertMediaType2Outer(paramTPPostProcessFrame.mediaType);
    if (localTPPostProcessFrameBuffer.mediaType == 0) {
      localTPPostProcessFrameBuffer.format = TPEnumUtils.convertVideoFrameFormat2Outter(paramTPPostProcessFrame.format);
    }
    for (;;)
    {
      localTPPostProcessFrameBuffer.data = paramTPPostProcessFrame.data;
      localTPPostProcessFrameBuffer.size = paramTPPostProcessFrame.linesize;
      localTPPostProcessFrameBuffer.sampleRate = paramTPPostProcessFrame.sampleRate;
      localTPPostProcessFrameBuffer.channelLayout = paramTPPostProcessFrame.channelLayout;
      localTPPostProcessFrameBuffer.ptsMs = (paramTPPostProcessFrame.ptsUs / 1000L);
      localTPPostProcessFrameBuffer.nbSamples = paramTPPostProcessFrame.nbSamples;
      localTPPostProcessFrameBuffer.channels = paramTPPostProcessFrame.channels;
      localTPPostProcessFrameBuffer.width = paramTPPostProcessFrame.width;
      localTPPostProcessFrameBuffer.height = paramTPPostProcessFrame.height;
      localTPPostProcessFrameBuffer.sampleAspectRatioNum = paramTPPostProcessFrame.sampleAspectRatioNum;
      localTPPostProcessFrameBuffer.sampleAspectRatioDen = paramTPPostProcessFrame.sampleAspectRatioDen;
      localTPPostProcessFrameBuffer.rotation = paramTPPostProcessFrame.rotation;
      localTPPostProcessFrameBuffer.perfData = paramTPPostProcessFrame.perfData;
      return localTPPostProcessFrameBuffer;
      if (localTPPostProcessFrameBuffer.mediaType == 1) {
        localTPPostProcessFrameBuffer.format = TPEnumUtils.convertAudioFrameFormat2Outter(paramTPPostProcessFrame.format);
      }
    }
  }
  
  public static TPSubtitleFrameBuffer convert2TPSubtitleFrameBuffer(TPSubtitleFrame paramTPSubtitleFrame)
  {
    if (paramTPSubtitleFrame == null) {
      return null;
    }
    TPSubtitleFrameBuffer localTPSubtitleFrameBuffer = new TPSubtitleFrameBuffer();
    localTPSubtitleFrameBuffer.data = paramTPSubtitleFrame.data;
    localTPSubtitleFrameBuffer.lineSize = paramTPSubtitleFrame.linesize;
    localTPSubtitleFrameBuffer.format = TPEnumUtils.convertSubtitleFrameFormat2Outer(paramTPSubtitleFrame.format);
    localTPSubtitleFrameBuffer.srcHeight = paramTPSubtitleFrame.height;
    localTPSubtitleFrameBuffer.srcWidth = paramTPSubtitleFrame.width;
    localTPSubtitleFrameBuffer.dstHeight = paramTPSubtitleFrame.height;
    localTPSubtitleFrameBuffer.dstWidth = paramTPSubtitleFrame.width;
    localTPSubtitleFrameBuffer.rotation = paramTPSubtitleFrame.rotation;
    localTPSubtitleFrameBuffer.ptsMs = (paramTPSubtitleFrame.ptsUs / 1000L);
    return localTPSubtitleFrameBuffer;
  }
  
  public static TPPlayerMsg.TPVideoCropInfo convert2TPVideoCropInfo(ITPNativePlayerMessageCallback.VideoCropInfo paramVideoCropInfo)
  {
    if (paramVideoCropInfo == null) {
      return null;
    }
    TPPlayerMsg.TPVideoCropInfo localTPVideoCropInfo = new TPPlayerMsg.TPVideoCropInfo();
    localTPVideoCropInfo.width = paramVideoCropInfo.width;
    localTPVideoCropInfo.height = paramVideoCropInfo.height;
    localTPVideoCropInfo.cropLeft = paramVideoCropInfo.cropLeft;
    localTPVideoCropInfo.cropRight = paramVideoCropInfo.cropRight;
    localTPVideoCropInfo.cropTop = paramVideoCropInfo.cropTop;
    localTPVideoCropInfo.cropBottom = paramVideoCropInfo.cropBottom;
    return localTPVideoCropInfo;
  }
  
  private static TPSurfaceRenderInfo.TPVideoCropInfo convert2TPVideoCropInfo(TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo paramTPVideoCropInfo)
  {
    if (paramTPVideoCropInfo == null) {
      return null;
    }
    TPSurfaceRenderInfo.TPVideoCropInfo localTPVideoCropInfo = new TPSurfaceRenderInfo.TPVideoCropInfo();
    localTPVideoCropInfo.cropLeft = paramTPVideoCropInfo.cropLeft;
    localTPVideoCropInfo.cropRight = paramTPVideoCropInfo.cropRight;
    localTPVideoCropInfo.cropTop = paramTPVideoCropInfo.cropTop;
    localTPVideoCropInfo.cropBottom = paramTPVideoCropInfo.cropBottom;
    localTPVideoCropInfo.width = paramTPVideoCropInfo.width;
    localTPVideoCropInfo.height = paramTPVideoCropInfo.height;
    return localTPVideoCropInfo;
  }
  
  public static TPVideoFrameBuffer convert2TPVideoFrameBuffer(TPVideoFrame paramTPVideoFrame)
  {
    TPVideoFrameBuffer localTPVideoFrameBuffer = new TPVideoFrameBuffer();
    localTPVideoFrameBuffer.data = paramTPVideoFrame.data;
    localTPVideoFrameBuffer.lineSize = paramTPVideoFrame.linesize;
    localTPVideoFrameBuffer.format = TPEnumUtils.convertVideoFrameFormat2Outter(paramTPVideoFrame.format);
    localTPVideoFrameBuffer.srcHeight = paramTPVideoFrame.height;
    localTPVideoFrameBuffer.srcWidth = paramTPVideoFrame.width;
    localTPVideoFrameBuffer.dstHeight = paramTPVideoFrame.height;
    localTPVideoFrameBuffer.dstWidth = paramTPVideoFrame.width;
    if ((paramTPVideoFrame.sampleAspectRatioDen > 0) && (paramTPVideoFrame.sampleAspectRatioNum > 0)) {
      localTPVideoFrameBuffer.dstWidth = Math.round(paramTPVideoFrame.sampleAspectRatioNum / paramTPVideoFrame.sampleAspectRatioDen * localTPVideoFrameBuffer.dstWidth);
    }
    localTPVideoFrameBuffer.rotation = paramTPVideoFrame.rotation;
    localTPVideoFrameBuffer.ptsMs = (paramTPVideoFrame.ptsUs / 1000L);
    return localTPVideoFrameBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils
 * JD-Core Version:    0.7.0.1
 */