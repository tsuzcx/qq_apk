package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.util.SparseArray;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerPropertyID;
import com.tencent.thumbplayer.utils.TPEnumUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;

public class TPThumbPlayerUtils
{
  public static final int OPTIONAL_ID_TYPE_BOOL = 3;
  public static final int OPTIONAL_ID_TYPE_INT = 4;
  public static final int OPTIONAL_ID_TYPE_LONG = 1;
  public static final int OPTIONAL_ID_TYPE_QUEUE_INT = 5;
  public static final int OPTIONAL_ID_TYPE_QUEUE_STRING = 6;
  public static final int OPTIONAL_ID_TYPE_STRING = 2;
  private static String TAG = "TPThumbPlayerUtils";
  private static HashMap<Integer, Integer> sErrorTypeMap;
  private static HashMap<Integer, Integer> sNativePlayerMsgInfoMap;
  private static SparseArray<TPThumbPlayerUtils.OptionIdMapping> sOptionIdMappingArray = new SparseArray();
  private static HashMap<Integer, Integer> sPropertyIdMap;
  private static HashMap<Integer, Integer> sSeekModeMap = new HashMap();
  
  static
  {
    sNativePlayerMsgInfoMap = new HashMap();
    sPropertyIdMap = new HashMap();
    sErrorTypeMap = new HashMap();
    sOptionIdMappingArray.append(100, new TPThumbPlayerUtils.OptionIdMapping(1, 100));
    sOptionIdMappingArray.append(101, new TPThumbPlayerUtils.OptionIdMapping(3, 101));
    sOptionIdMappingArray.append(104, new TPThumbPlayerUtils.OptionIdMapping(1, 104));
    sOptionIdMappingArray.append(103, new TPThumbPlayerUtils.OptionIdMapping(1, 103));
    sOptionIdMappingArray.append(102, new TPThumbPlayerUtils.OptionIdMapping(1, 102));
    sOptionIdMappingArray.append(105, new TPThumbPlayerUtils.OptionIdMapping(1, 105));
    sOptionIdMappingArray.append(106, new TPThumbPlayerUtils.OptionIdMapping(1, 106));
    sOptionIdMappingArray.append(107, new TPThumbPlayerUtils.OptionIdMapping(1, 107));
    sOptionIdMappingArray.append(108, new TPThumbPlayerUtils.OptionIdMapping(1, 108));
    sOptionIdMappingArray.append(109, new TPThumbPlayerUtils.OptionIdMapping(4, 109));
    sOptionIdMappingArray.append(110, new TPThumbPlayerUtils.OptionIdMapping(3, 110));
    sOptionIdMappingArray.append(111, new TPThumbPlayerUtils.OptionIdMapping(3, 111));
    sOptionIdMappingArray.append(112, new TPThumbPlayerUtils.OptionIdMapping(3, 112));
    sOptionIdMappingArray.append(115, new TPThumbPlayerUtils.OptionIdMapping(3, 115));
    sOptionIdMappingArray.append(200, new TPThumbPlayerUtils.OptionIdMapping(4, 200));
    sOptionIdMappingArray.append(117, new TPThumbPlayerUtils.OptionIdMapping(1, 117));
    sOptionIdMappingArray.append(118, new TPThumbPlayerUtils.OptionIdMapping(6, 113));
    sOptionIdMappingArray.append(119, new TPThumbPlayerUtils.OptionIdMapping(3, 403));
    sOptionIdMappingArray.append(120, new TPThumbPlayerUtils.OptionIdMapping(3, 402));
    sOptionIdMappingArray.append(121, new TPThumbPlayerUtils.OptionIdMapping(4, 310));
    sOptionIdMappingArray.append(201, new TPThumbPlayerUtils.OptionIdMapping(3, 201));
    sOptionIdMappingArray.append(400, new TPThumbPlayerUtils.OptionIdMapping(3, 400));
    sOptionIdMappingArray.append(300, new TPThumbPlayerUtils.OptionIdMapping(4, 404));
    sOptionIdMappingArray.append(301, new TPThumbPlayerUtils.OptionIdMapping(4, 405));
    sOptionIdMappingArray.append(401, new TPThumbPlayerUtils.OptionIdMapping(3, 401));
    sOptionIdMappingArray.append(204, new TPThumbPlayerUtils.OptionIdMapping(5, 203));
    sOptionIdMappingArray.append(500, new TPThumbPlayerUtils.OptionIdMapping(1, 500));
    sOptionIdMappingArray.append(502, new TPThumbPlayerUtils.OptionIdMapping(4, 100));
    sOptionIdMappingArray.append(206, new TPThumbPlayerUtils.OptionIdMapping(1, 107));
    sSeekModeMap.put(Integer.valueOf(1), Integer.valueOf(1));
    sSeekModeMap.put(Integer.valueOf(2), Integer.valueOf(2));
    sSeekModeMap.put(Integer.valueOf(3), Integer.valueOf(3));
    sSeekModeMap.put(Integer.valueOf(4), Integer.valueOf(4));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(101), Integer.valueOf(101));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(102), Integer.valueOf(102));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(103), Integer.valueOf(103));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(104), Integer.valueOf(104));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(105), Integer.valueOf(105));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(106), Integer.valueOf(106));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(107), Integer.valueOf(107));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(150), Integer.valueOf(150));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(151), Integer.valueOf(151));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(152), Integer.valueOf(152));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(153), Integer.valueOf(154));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(200), Integer.valueOf(200));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(201), Integer.valueOf(201));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(203), Integer.valueOf(203));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(204), Integer.valueOf(204));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(205), Integer.valueOf(205));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(206), Integer.valueOf(206));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(207), Integer.valueOf(207));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(208), Integer.valueOf(208));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(500), Integer.valueOf(500));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(501), Integer.valueOf(501));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(3), Integer.valueOf(3));
    sNativePlayerMsgInfoMap.put(Integer.valueOf(4), Integer.valueOf(4));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.STRING_MEDIA_INFO), Integer.valueOf(TPNativePlayerPropertyID.STRING_MEDIA_INFO));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_AUDIO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CODEC_ID));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_AUDIO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_BIT_RATE));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_AUDIO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_PROFILE));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_AUDIO_CHANNEL_NUM), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CHANNEL_NUM));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_VIDEO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_CODEC_ID));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_VIDEO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_BIT_RATE));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_VIDEO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_PROFILE));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_VIDEO_LEVEL), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_LEVEL));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_VIDEO_ROTATION), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_ROTATION));
    sPropertyIdMap.put(Integer.valueOf(TPPropertyID.LONG_VIDEO_FRAME_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_FRAME_RATE));
    sErrorTypeMap.put(Integer.valueOf(1001), Integer.valueOf(1001));
    sErrorTypeMap.put(Integer.valueOf(1100), Integer.valueOf(1100));
    sErrorTypeMap.put(Integer.valueOf(1101), Integer.valueOf(1101));
    sErrorTypeMap.put(Integer.valueOf(1102), Integer.valueOf(1102));
    sErrorTypeMap.put(Integer.valueOf(1103), Integer.valueOf(1103));
    sErrorTypeMap.put(Integer.valueOf(1200), Integer.valueOf(1200));
    sErrorTypeMap.put(Integer.valueOf(1210), Integer.valueOf(1210));
    sErrorTypeMap.put(Integer.valueOf(1211), Integer.valueOf(1211));
    sErrorTypeMap.put(Integer.valueOf(1220), Integer.valueOf(1220));
    sErrorTypeMap.put(Integer.valueOf(1221), Integer.valueOf(1221));
    sErrorTypeMap.put(Integer.valueOf(1230), Integer.valueOf(1230));
    sErrorTypeMap.put(Integer.valueOf(1231), Integer.valueOf(1231));
    sErrorTypeMap.put(Integer.valueOf(1300), Integer.valueOf(1300));
    sErrorTypeMap.put(Integer.valueOf(1500), Integer.valueOf(1500));
    sErrorTypeMap.put(Integer.valueOf(1600), Integer.valueOf(1600));
  }
  
  public static TPThumbPlayerUtils.OptionIdMapping convert2NativeOptionaID(int paramInt)
  {
    return (TPThumbPlayerUtils.OptionIdMapping)sOptionIdMappingArray.get(paramInt);
  }
  
  public static int convert2NativePropertyID(int paramInt)
  {
    if (!sPropertyIdMap.containsKey(Integer.valueOf(paramInt)))
    {
      TPLogUtil.e(TAG, "tpPropertyID: " + paramInt + " not recognition, return -1");
      return -1;
    }
    return ((Integer)sPropertyIdMap.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public static int convert2NativeSeekMode(int paramInt)
  {
    if (!sSeekModeMap.containsKey(Integer.valueOf(paramInt)))
    {
      TPLogUtil.e(TAG, "player seek mode is invalid, return next frame mode instead");
      return 2;
    }
    return ((Integer)sSeekModeMap.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public static TPAudioFrameBuffer convert2TPAudioFrameBuffer(TPAudioFrame paramTPAudioFrame)
  {
    TPAudioFrameBuffer localTPAudioFrameBuffer = new TPAudioFrameBuffer();
    localTPAudioFrameBuffer.data = paramTPAudioFrame.data;
    localTPAudioFrameBuffer.size = paramTPAudioFrame.size;
    localTPAudioFrameBuffer.sampleRate = paramTPAudioFrame.sampleRate;
    localTPAudioFrameBuffer.channelLayout = paramTPAudioFrame.channelLayout;
    localTPAudioFrameBuffer.ptsMs = (paramTPAudioFrame.ptsUs / 1000L);
    localTPAudioFrameBuffer.flags = paramTPAudioFrame.exFlags;
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
  
  public static int convert2TPErrorType(int paramInt)
  {
    if (!sErrorTypeMap.containsKey(Integer.valueOf(paramInt)))
    {
      TPLogUtil.e(TAG, "nativeErrorType: " + paramInt + " not recognition, return 1001");
      return 1001;
    }
    return ((Integer)sErrorTypeMap.get(Integer.valueOf(paramInt))).intValue();
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
    localTPVideoFrameBuffer.rotation = paramTPVideoFrame.rotation;
    localTPVideoFrameBuffer.ptsMs = (paramTPVideoFrame.ptsUs / 1000L);
    return localTPVideoFrameBuffer;
  }
  
  public static int convert2ThumbPlayerInfo(int paramInt)
  {
    if (!sNativePlayerMsgInfoMap.containsKey(Integer.valueOf(paramInt)))
    {
      TPLogUtil.e(TAG, "nativePlayerMsgInfo: " + paramInt + " not recognition, return -1");
      return -1;
    }
    return ((Integer)sNativePlayerMsgInfoMap.get(Integer.valueOf(paramInt))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils
 * JD-Core Version:    0.7.0.1
 */