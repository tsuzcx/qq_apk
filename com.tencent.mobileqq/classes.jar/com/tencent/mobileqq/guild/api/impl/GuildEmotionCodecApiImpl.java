package com.tencent.mobileqq.guild.api.impl;

import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;

public class GuildEmotionCodecApiImpl
  implements IGuildEmotionCodecApi
{
  public String decodeQQEmotion(String paramString)
  {
    return EmotionCodecUtils.c(paramString);
  }
  
  public String encodeQQEmotion(String paramString)
  {
    return EmotionCodecUtils.a(paramString);
  }
  
  public String fromQQTextBuilder(QQTextBuilder paramQQTextBuilder)
  {
    return ChatRoomUtil.a(paramQQTextBuilder);
  }
  
  public QQText toQQText(String paramString, int paramInt)
  {
    return ChatRoomUtil.a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildEmotionCodecApiImpl
 * JD-Core Version:    0.7.0.1
 */