package com.tencent.mobileqq.portal;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class RedPacketShowerFragment$2
  implements View.OnClickListener
{
  RedPacketShowerFragment$2(RedPacketShowerFragment paramRedPacketShowerFragment) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131429983)
    {
      if (i == 2131436547)
      {
        if (this.a.h.containsKey("ext2")) {
          this.a.h.remove("ext2");
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI close", this.a.h });
        }
        SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.a.h, "close", true);
        this.a.getActivity().finish();
      }
    }
    else if (this.a.a())
    {
      if (this.a.h.containsKey("ext2")) {
        this.a.h.remove("ext2");
      }
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI click", this.a.h });
      }
      SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.a.h, "clk", true);
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.a.i == 1)
      {
        localStringBuilder.append(this.a.q);
        localStringBuilder.append("&from=");
        localStringBuilder.append(25);
      }
      else
      {
        localStringBuilder.append("https://ti.qq.com/hb2021/packresult?_wv=16777219");
        localStringBuilder.append("&pack_id=");
        localStringBuilder.append(this.a.r);
        localStringBuilder.append("&business_id=");
        localStringBuilder.append(this.a.k);
        localStringBuilder.append("&type=");
        localStringBuilder.append(this.a.i);
        localStringBuilder.append("&state=");
        localStringBuilder.append(this.a.j);
        localStringBuilder.append("&from=");
        localStringBuilder.append(1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jumpUrl ");
        ((StringBuilder)localObject).append(localStringBuilder);
        QLog.d("RedPacketShowerFragment", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(this.a.s, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", localStringBuilder.toString());
      this.a.s.startActivity((Intent)localObject);
      this.a.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment.2
 * JD-Core Version:    0.7.0.1
 */