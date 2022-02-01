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
    PanelData localPanelData = this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a(paramInt);
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
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).sendRedPkg(this.a.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, localPanelData, this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.a(), 3);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService != null) && (localPanelData != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqQwalletRedIQWalletRedService.doClick(localPanelData.a);
      ReportUtils.a(this.a.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "aio.lucky.click", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, localPanelData.b);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$HongBaoAdapter.notifyItemChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.5
 * JD-Core Version:    0.7.0.1
 */