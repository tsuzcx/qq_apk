package com.tencent.mobileqq.guild.setting;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;

class QQGuildMemberFragment$5
  implements Observer<List<IGProUserInfo>>
{
  QQGuildMemberFragment$5(QQGuildMemberFragment paramQQGuildMemberFragment) {}
  
  public void a(List<IGProUserInfo> paramList)
  {
    if (paramList != null)
    {
      QQGuildMemberFragment.b(this.a).a(paramList);
    }
    else
    {
      QQGuildUtil.a(BaseApplication.getContext(), 2, this.a.getString(2131890505));
      QQGuildMemberFragment.b(this.a).a(new ArrayList());
    }
    QQGuildMemberFragment.c(this.a).removeMessages(15);
    if ((QQGuildMemberFragment.d(this.a) != null) && (QQGuildMemberFragment.d(this.a).isShowing())) {
      QQGuildMemberFragment.d(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.5
 * JD-Core Version:    0.7.0.1
 */