package com.tencent.mobileqq.guild.channel;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QQGuildVoiceChannelMemberLimitFragment$6
  extends GPServiceObserver
{
  QQGuildVoiceChannelMemberLimitFragment$6(QQGuildVoiceChannelMemberLimitFragment paramQQGuildVoiceChannelMemberLimitFragment) {}
  
  protected void b(String paramString, List<String> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (paramList.size() > 0))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        if ((QQGuildVoiceChannelMemberLimitFragment.d(this.a) != null) && (paramList.equals(QQGuildVoiceChannelMemberLimitFragment.d(this.a).getChannelUin())))
        {
          paramString = ((IGPSService)this.a.l().getRuntimeService(IGPSService.class, "")).getAudioChannelSimpleInfo(paramList);
          if (paramString != null)
          {
            QQGuildVoiceChannelMemberLimitFragment.a(this.a, paramString.c());
            QLog.d("QQGuildVoiceChannelMemberLimitFragment", 1, new Object[] { "onAudioChannelSimpleInfoUpdate, =mChannelMemberCount=", Integer.valueOf(QQGuildVoiceChannelMemberLimitFragment.e(this.a)) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildVoiceChannelMemberLimitFragment.6
 * JD-Core Version:    0.7.0.1
 */