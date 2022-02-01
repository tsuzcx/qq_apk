package com.tencent.mobileqq.guild.notice;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class GuildNoticeViewModel$5
  implements IDealNoticeCallback
{
  GuildNoticeViewModel$5(GuildNoticeViewModel paramGuildNoticeViewModel, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {
        QQToast.makeText(BaseApplication.getContext(), 2, paramString, 0).show();
      }
      if (paramBoolean) {
        GuildNoticeViewModel.a(this.b, this.a);
      }
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), 1, paramString, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.notice.GuildNoticeViewModel.5
 * JD-Core Version:    0.7.0.1
 */