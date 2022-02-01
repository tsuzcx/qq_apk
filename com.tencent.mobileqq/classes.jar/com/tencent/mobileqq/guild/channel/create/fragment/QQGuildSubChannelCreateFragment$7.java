package com.tencent.mobileqq.guild.channel.create.fragment;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;

class QQGuildSubChannelCreateFragment$7
  implements IResultCallback
{
  QQGuildSubChannelCreateFragment$7(QQGuildSubChannelCreateFragment paramQQGuildSubChannelCreateFragment) {}
  
  public void onResult(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("setLiveChannelAnchorList res:");
    paramString.append(paramInt);
    QLog.d("QQGuildSubChannelCreateFragment", 4, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateFragment.7
 * JD-Core Version:    0.7.0.1
 */