package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;

@QAPI(process={"all"})
public abstract interface IGuildEmotionCodecApi
  extends QRouteApi
{
  public abstract String decodeQQEmotion(String paramString);
  
  public abstract String encodeQQEmotion(String paramString);
  
  public abstract String fromQQTextBuilder(QQTextBuilder paramQQTextBuilder);
  
  public abstract QQText toQQText(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi
 * JD-Core Version:    0.7.0.1
 */