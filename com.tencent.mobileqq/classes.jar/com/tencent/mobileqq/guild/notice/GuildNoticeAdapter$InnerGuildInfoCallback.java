package com.tencent.mobileqq.guild.notice;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

class GuildNoticeAdapter$InnerGuildInfoCallback
  implements IFetchGuildInfoCallback
{
  private WeakReference<GuildNoticeAdapter.ViewHolder> a;
  private WeakReference<GuildMainViewContext> b;
  private String c;
  
  public GuildNoticeAdapter$InnerGuildInfoCallback(GuildNoticeAdapter.ViewHolder paramViewHolder, GuildMainViewContext paramGuildMainViewContext, String paramString)
  {
    this.a = new WeakReference(paramViewHolder);
    this.b = new WeakReference(paramGuildMainViewContext);
    this.c = paramString;
  }
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    if ((paramInt == 0) && (paramIGProGuildInfo != null))
    {
      paramString = (GuildNoticeAdapter.ViewHolder)this.a.get();
      GuildMainViewContext localGuildMainViewContext = (GuildMainViewContext)this.b.get();
      if (paramString != null)
      {
        if (localGuildMainViewContext == null) {
          return;
        }
        paramString = ((IQQGuildAvatarApi)((GuildMainViewContext)this.b.get()).b().getAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(paramIGProGuildInfo.getAvatarUrl(0), 0, true);
        paramIGProGuildInfo = paramIGProGuildInfo.getGuildName();
        GuildNoticeAdapter.ViewHolder.b((GuildNoticeAdapter.ViewHolder)this.a.get()).setImageDrawable(paramString);
        if (TextUtils.isEmpty(paramIGProGuildInfo))
        {
          GuildNoticeAdapter.ViewHolder.c((GuildNoticeAdapter.ViewHolder)this.a.get()).setText(2131890525);
          return;
        }
        GuildNoticeAdapter.ViewHolder.c((GuildNoticeAdapter.ViewHolder)this.a.get()).setText(paramIGProGuildInfo);
        return;
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIGProGuildInfo = new StringBuilder();
      paramIGProGuildInfo.append("onFetchGuestGuild error=");
      paramIGProGuildInfo.append(paramInt);
      paramIGProGuildInfo.append(" guildId=");
      paramIGProGuildInfo.append(this.c);
      paramIGProGuildInfo.append(" errMsg=");
      paramIGProGuildInfo.append(paramString);
      QLog.e("GuildNoticeAdapter", 1, paramIGProGuildInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeAdapter.InnerGuildInfoCallback
 * JD-Core Version:    0.7.0.1
 */