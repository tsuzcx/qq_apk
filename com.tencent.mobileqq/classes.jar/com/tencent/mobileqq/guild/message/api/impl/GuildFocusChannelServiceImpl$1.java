package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;

class GuildFocusChannelServiceImpl$1
  implements IResultCallback
{
  GuildFocusChannelServiceImpl$1(GuildFocusChannelServiceImpl paramGuildFocusChannelServiceImpl) {}
  
  public void onResult(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFocusChannel, result = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errMsg = ");
      localStringBuilder.append(paramString);
      QLog.d("GuildFocusChannelServiceImpl", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildFocusChannelServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */