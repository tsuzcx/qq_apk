package com.tencent.mobileqq.security;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.security.business.ModifyPwdTopBarObserver;
import com.tencent.mobileqq.security.business.ModifyPwdTopBarObserver.ModifyPwdTopBarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ModifyPwdTopBarHelper$2
  extends ModifyPwdTopBarObserver
{
  ModifyPwdTopBarHelper$2(ModifyPwdTopBarHelper paramModifyPwdTopBarHelper, long paramLong, Map paramMap, BaseQQAppInterface paramBaseQQAppInterface, String paramString) {}
  
  public void a(boolean paramBoolean, ModifyPwdTopBarObserver.ModifyPwdTopBarInfo paramModifyPwdTopBarInfo)
  {
    long l1 = paramModifyPwdTopBarInfo.a();
    boolean bool = paramModifyPwdTopBarInfo.a();
    String str1 = paramModifyPwdTopBarInfo.a();
    String str2 = paramModifyPwdTopBarInfo.b();
    int i = paramModifyPwdTopBarInfo.a();
    long l2 = this.jdField_a_of_type_Long;
    if (l1 != l2)
    {
      QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not match");
      return;
    }
    paramModifyPwdTopBarInfo = (ModifyPwdTopBarObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l2));
    if (paramModifyPwdTopBarInfo == null)
    {
      QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not exist");
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver(paramModifyPwdTopBarInfo);
    paramModifyPwdTopBarInfo = new StringBuilder();
    paramModifyPwdTopBarInfo.append("onUpdateBarDisplayInfo isSuccess: ");
    paramModifyPwdTopBarInfo.append(paramBoolean);
    paramModifyPwdTopBarInfo.append(" shouldDisplay: ");
    paramModifyPwdTopBarInfo.append(bool);
    paramModifyPwdTopBarInfo.append(" content: ");
    paramModifyPwdTopBarInfo.append(str1);
    paramModifyPwdTopBarInfo.append(" barUrl: ");
    paramModifyPwdTopBarInfo.append(str2);
    paramModifyPwdTopBarInfo.append(" nextAccessTime: ");
    paramModifyPwdTopBarInfo.append(i);
    QLog.d("ModifyPwdTopBarObserver", 1, paramModifyPwdTopBarInfo.toString());
    if (paramBoolean)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "key_show_status", true);
        this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "time_fetch_next_time", i * 1000L);
        this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "bar_url", str2);
        this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "bar_content_string", str1);
        this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "key_verify_for_dlg_or_clk", false);
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "key_show_status", false);
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.security.ModifyPwdTopBarHelper.2
 * JD-Core Version:    0.7.0.1
 */