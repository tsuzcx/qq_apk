package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.widget.EditText;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;

class QQGuildVoiceChannelMemberLimitFragment$5
  implements IResultWithSecurityCallback
{
  QQGuildVoiceChannelMemberLimitFragment$5(QQGuildVoiceChannelMemberLimitFragment paramQQGuildVoiceChannelMemberLimitFragment, Context paramContext) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt == 0)
    {
      QQToast.makeText(this.a, 2131890594, 0).show();
      InputMethodUtil.b(QQGuildVoiceChannelMemberLimitFragment.a(this.b));
      VideoReport.setPageId(QQGuildVoiceChannelMemberLimitFragment.b(this.b), "pg_sgrp_channel_set");
      paramString = new HashMap();
      paramString.put("sgrp_sub_channel_capacity", Integer.valueOf(Integer.parseInt(QQGuildVoiceChannelMemberLimitFragment.a(this.b).getText().toString())));
      VideoReport.reportEvent("clck", QQGuildVoiceChannelMemberLimitFragment.a(this.b), paramString);
      this.b.onBackEvent();
      return;
    }
    if (QQGuildVoiceChannelMemberLimitFragment.a(this.b) != null) {
      QQGuildVoiceChannelMemberLimitFragment.a(this.b).setText(QQGuildVoiceChannelMemberLimitFragment.c(this.b));
    }
    QLog.d("QQGuildVoiceChannelMemberLimitFragment", 1, new Object[] { "setAudioChannelUserLimit result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    int i = 2131890578;
    if (paramInt == 30002) {
      i = 2131890503;
    } else if (paramInt == 30003) {
      i = 2131890502;
    }
    QQToast.makeText(this.a, 1, i, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildVoiceChannelMemberLimitFragment.5
 * JD-Core Version:    0.7.0.1
 */