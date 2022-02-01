package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.send.PanelData;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.qphone.base.util.QLog;

class HongBaoPanel$5
  implements HongBaoPanel.OnHolderItemClickListener
{
  HongBaoPanel$5(HongBaoPanel paramHongBaoPanel) {}
  
  public void a(View paramView, int paramInt)
  {
    PanelData localPanelData = this.a.e.a(paramInt);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("OnHolderItemClickListener onItemClick  panelData=");
      paramView.append(localPanelData);
      if (paramView.toString() == null)
      {
        paramView = "null";
      }
      else
      {
        paramView = new StringBuilder();
        paramView.append(localPanelData);
        paramView.append(",p=");
        paramView.append(paramInt);
        paramView = paramView.toString();
      }
      QLog.d("HongBaoPanel", 2, paramView);
    }
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).sendRedPkg(this.a.a, this.a.c, this.a.h, localPanelData, this.a.e.a(), 3);
    if ((this.a.k != null) && (localPanelData != null))
    {
      this.a.k.doClick(localPanelData.a);
      ReportUtils.a(this.a.a, "aio.lucky.click", this.a.h, localPanelData.c);
    }
    this.a.e.notifyItemChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.5
 * JD-Core Version:    0.7.0.1
 */