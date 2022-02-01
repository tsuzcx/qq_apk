package com.tencent.mobileqq.ecshop.keep;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomTabView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
      localStringBuilder.append("");
      ReportUtil.a("gouwu.tab.click", (String)localObject, localStringBuilder.toString(), "", this.e.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
      localStringBuilder.append("");
      ReportUtil.b("gouwu_tab_click", (String)localObject, localStringBuilder.toString(), "", this.e.a);
      int i;
      if (this.b.getTag() == null) {
        i = 0;
      } else {
        i = ((Integer)this.b.getTag()).intValue();
      }
      localObject = Integer.valueOf(i);
      if (((Integer)localObject).intValue() != 0)
      {
        this.b.setVisibility(8);
        QQShopRedPointUtil.b(this.a.b, ((Integer)localObject).intValue());
      }
      if (this.a.b != this.e.a) {
        CustomTabView.a(this.e, this.a, this.c, this.d);
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localThrowable));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.CustomTabView.2
 * JD-Core Version:    0.7.0.1
 */