package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import java.util.HashMap;

final class FilterCreateFactory
{
  private static final HashMap<Integer, String> sTag = new HashMap();
  
  static
  {
    sTag.put(Integer.valueOf(40), "2D_PTV");
    sTag.put(Integer.valueOf(90), "ART_FILTER");
    sTag.put(Integer.valueOf(70), "AV_FILTER");
    sTag.put(Integer.valueOf(25), "PT_BEAUTY");
    sTag.put(Integer.valueOf(20), "BEAUTY");
    sTag.put(Integer.valueOf(1000), "SCREEN");
    sTag.put(Integer.valueOf(80), "EFFTECT_FILTER");
    sTag.put(Integer.valueOf(10), "LOW_LIGHT");
    sTag.put(Integer.valueOf(100), "2D_MOVIE");
    sTag.put(Integer.valueOf(120), "DYNAMIC_STICKER");
    sTag.put(Integer.valueOf(110), "TRACKER_STICKER");
    sTag.put(Integer.valueOf(130), "DANCE_GAME");
    sTag.put(Integer.valueOf(13), "IMG_FILTER");
    sTag.put(Integer.valueOf(140), "FACE_GAME");
    sTag.put(Integer.valueOf(160), "VIDEO_TRANSFER");
    sTag.put(Integer.valueOf(180), "MTV_EFFECT");
    sTag.put(Integer.valueOf(182), "GAME_EJECTA");
    sTag.put(Integer.valueOf(145), "PIC_GAUSSIAN");
    sTag.put(Integer.valueOf(150), "PIC_SCALE");
    sTag.put(Integer.valueOf(181), "TEXT_EJECTA");
    sTag.put(Integer.valueOf(170), "IMAGE_2_FRAME");
    sTag.put(Integer.valueOf(183), "GAME_PK");
    sTag.put(Integer.valueOf(999), "FACE_DETECT");
    sTag.put(Integer.valueOf(185), "EMOJI_RED_PACK");
  }
  
  static QQBaseFilter createFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 40: 
      return new QQPtvVideoFilter(40, paramQQFilterRenderManager);
    case 90: 
      return new QQSVArtFilterNew(90, paramQQFilterRenderManager);
    case 70: 
      return new QQAVFilter(70, paramQQFilterRenderManager);
    case 25: 
      return new QQPtNewBeautyFilter(25, paramQQFilterRenderManager);
    case 20: 
      return new QQBeautyFilter(20, paramQQFilterRenderManager);
    case 1000: 
      return new QQDrawScreenFilter(1000, paramQQFilterRenderManager);
    case 80: 
      return new QQSpecialAVFilter(80, paramQQFilterRenderManager);
    case 10: 
      return new QQLowLightFilter(paramQQFilterRenderManager);
    case 100: 
      return new QQMovieFilter(paramQQFilterRenderManager);
    case 120: 
      return new QQDynamicStickersFilter(120, paramQQFilterRenderManager);
    case 110: 
      return new QQTrackerStickersFilter(110, paramQQFilterRenderManager);
    case 130: 
      return new QQDanceGameFilter(130, paramQQFilterRenderManager);
    case 13: 
      return new QQImgHazeRmoveFilter(13, paramQQFilterRenderManager);
    case 140: 
      return new QQFaceDanceMechineFilter(140, paramQQFilterRenderManager);
    case 160: 
      return new QQTransferFilter(paramQQFilterRenderManager);
    case 180: 
      return new QQMTVFilter(180, paramQQFilterRenderManager);
    case 182: 
      return new QQEjectaGameFilter(182, paramQQFilterRenderManager);
    case 145: 
      return new QQGaussianBlurFilter(145, paramQQFilterRenderManager);
    case 150: 
      return new QQScaleFilter(150, paramQQFilterRenderManager);
    case 181: 
      return new QQTextEjectaFilter(181, paramQQFilterRenderManager);
    case 170: 
      return new QQImage2FrameFilter(paramQQFilterRenderManager);
    case 183: 
      return new PKFilter(paramQQFilterRenderManager);
    case 999: 
      return new QQFaceDetect(paramQQFilterRenderManager);
    case 184: 
      return new QQPtColorFilter(paramQQFilterRenderManager);
    case 185: 
      return new QQEmojiRedPackFilter(paramQQFilterRenderManager);
    }
    return new QQPtvLipFilter(paramQQFilterRenderManager);
  }
  
  static String getFilterTag(int paramInt)
  {
    return (String)sTag.get(Integer.valueOf(paramInt));
  }
  
  static String getLogInfo(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return "space";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      localStringBuilder.append((String)sTag.get(Integer.valueOf(k)));
      localStringBuilder.append('|');
      i += 1;
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterCreateFactory
 * JD-Core Version:    0.7.0.1
 */