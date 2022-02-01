package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import mqq.app.AppRuntime;

class ReadinjoyTabFrame$12
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 2;
    if (j == 2131432566)
    {
      ((IKandianSubscribeManager)this.b.aF.getRuntimeService(IKandianSubscribeManager.class, "")).lanuchKandianSubscribeActivity(this.b.P(), 2);
      i = 1;
    }
    ReadinjoyTabFrame.i(this.b).setAnimation(AnimationUtils.loadAnimation(this.b.P(), 2130772462));
    ReadinjoyTabFrame.i(this.b).setVisibility(8);
    SharedPreUtils.bs(this.b.P(), this.b.t().getCurrentAccountUin());
    paramView = this.b.t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    PublicAccountReportUtils.a(paramView, "", "0X80093FE", "0X80093FE", 0, 0, localStringBuilder.toString(), "", "", this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.12
 * JD-Core Version:    0.7.0.1
 */