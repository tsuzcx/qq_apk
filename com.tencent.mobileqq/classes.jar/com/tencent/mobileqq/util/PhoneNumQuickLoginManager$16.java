package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

final class PhoneNumQuickLoginManager$16
  implements AdapterView.OnItemClickListener
{
  PhoneNumQuickLoginManager$16(PhoneNumQuickLoginManager.OnUinClickListener paramOnUinClickListener, List paramList, Dialog paramDialog, Map paramMap) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QLog.d("PhoneNumQuickLoginManager", 1, "setSelectAccountView onItemClick");
    if (this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$OnUinClickListener != null)
    {
      PhoneNumQuickLoginManager.AccountInfo localAccountInfo = (PhoneNumQuickLoginManager.AccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqUtilPhoneNumQuickLoginManager$OnUinClickListener.a(this.jdField_a_of_type_AndroidAppDialog, this.jdField_a_of_type_JavaUtilMap, localAccountInfo);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.16
 * JD-Core Version:    0.7.0.1
 */