package com.tencent.mobileqq.emoticon;

public abstract interface IEPRecommendTask
{
  public static final String PROMOTION_IMAGE_URL_PREFIX = "https://gxh.vip.qq.com/xydata/";
  public static final String PROMOTION_PUSH_EMOTION = "3";
  public static final String PROMOTION_PUSH_EMOTION_URL = "https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json";
  
  public abstract void runTask();
  
  public abstract IEPRecommendTask setParam(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.IEPRecommendTask
 * JD-Core Version:    0.7.0.1
 */