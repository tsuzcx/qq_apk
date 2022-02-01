package com.tencent.mobileqq.guild.notice;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class GuildNoticeViewModel$2
  implements IInitGetNoticeListCallback
{
  GuildNoticeViewModel$2(GuildNoticeViewModel paramGuildNoticeViewModel) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, List<GuildNotice> paramList)
  {
    if (paramInt1 != 0)
    {
      GuildNoticeViewModel.a(this.a).setValue(new BaseGuildViewModel.ToastEvent(paramInt1, paramString));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onInitGetGuildNoticeList error=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append(paramString);
        QLog.e("GuildNoticeViewModel", 1, localStringBuilder.toString());
      }
    }
    paramString = paramList;
    if (paramList == null) {
      paramString = new ArrayList();
    }
    paramList = GuildNoticeViewModel.a(this.a, paramString);
    GuildNoticeViewModel.b(this.a).setValue(paramList);
    GuildNoticeViewModel.c(this.a).setValue(Boolean.valueOf(paramBoolean));
    GuildNoticeViewModel.a(this.a, paramInt2);
    GuildNoticeViewModel.d(this.a).setValue(Boolean.valueOf(paramList.isEmpty()));
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onInitGetGuildNoticeList listOffset=");
      paramList.append(paramInt2);
      paramList.append(" isEnd=");
      paramList.append(paramBoolean);
      paramList.append(" data size=");
      paramList.append(paramString.size());
      QLog.d("GuildNoticeViewModel", 1, paramList.toString());
    }
    GuildNoticeViewModel.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeViewModel.2
 * JD-Core Version:    0.7.0.1
 */