package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class JoinGuildSettingFragment$7
  implements Observer<BaseGuildViewModel.ToastEvent>
{
  JoinGuildSettingFragment$7(JoinGuildSettingFragment paramJoinGuildSettingFragment) {}
  
  public void a(BaseGuildViewModel.ToastEvent paramToastEvent)
  {
    if ((paramToastEvent != null) && (paramToastEvent.b == 0))
    {
      QQGuildUtil.c(this.a.getContext(), paramToastEvent.a);
      return;
    }
    if (paramToastEvent != null)
    {
      String str;
      if (TextUtils.isEmpty(paramToastEvent.a)) {
        str = this.a.getContext().getResources().getString(2131890394);
      } else {
        str = paramToastEvent.a;
      }
      QQGuildUtil.a(this.a.getContext(), paramToastEvent.b, str, paramToastEvent.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.JoinGuildSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */