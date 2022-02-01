package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.qqemoticon.api.IChatTextSizeApi;

public class ChatTextSizeApiImpl
  implements IChatTextSizeApi
{
  public int getChatTextSizeWithDP()
  {
    return ChatTextSizeSettingActivity.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.ChatTextSizeApiImpl
 * JD-Core Version:    0.7.0.1
 */