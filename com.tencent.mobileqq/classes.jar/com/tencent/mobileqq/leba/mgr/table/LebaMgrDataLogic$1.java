package com.tencent.mobileqq.leba.mgr.table;

import com.tencent.mobileqq.leba.core.LebaSettingHandlerApi;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class LebaMgrDataLogic$1
  implements Runnable
{
  LebaMgrDataLogic$1(LebaMgrDataLogic paramLebaMgrDataLogic, LebaViewItem paramLebaViewItem, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      QLog.i("LebaMgrDataLogic", 1, "handleData AppRuntime error ");
      return;
    }
    QLog.i("LebaMgrDataLogic", 1, "handlePluginItem name: " + this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName + "  cCurFlag:" + this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Byte);
    long l = NetConnInfoCenter.getServerTimeMillis();
    LebaShowListManager.a().a(this.this$0.a, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, this.jdField_a_of_type_Boolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    LebaSettingHandlerApi.a(this.this$0.a, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), this.jdField_a_of_type_Boolean, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaMgrDataLogic.1
 * JD-Core Version:    0.7.0.1
 */