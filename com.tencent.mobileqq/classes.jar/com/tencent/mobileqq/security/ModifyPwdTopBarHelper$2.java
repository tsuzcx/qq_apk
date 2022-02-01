package com.tencent.mobileqq.security;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.security.business.ModifyPwdTopBarObserver;
import com.tencent.mobileqq.security.business.ModifyPwdTopBarObserver.ModifyPwdTopBarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ModifyPwdTopBarHelper$2
  extends ModifyPwdTopBarObserver
{
  ModifyPwdTopBarHelper$2(ModifyPwdTopBarHelper paramModifyPwdTopBarHelper, long paramLong, Map paramMap, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void a(boolean paramBoolean, ModifyPwdTopBarObserver.ModifyPwdTopBarInfo paramModifyPwdTopBarInfo)
  {
    long l = paramModifyPwdTopBarInfo.a();
    boolean bool = paramModifyPwdTopBarInfo.a();
    String str1 = paramModifyPwdTopBarInfo.a();
    String str2 = paramModifyPwdTopBarInfo.b();
    int i = paramModifyPwdTopBarInfo.a();
    if (l != this.jdField_a_of_type_Long) {
      QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not match");
    }
    do
    {
      return;
      paramModifyPwdTopBarInfo = (ModifyPwdTopBarObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (paramModifyPwdTopBarInfo == null)
      {
        QLog.e("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(paramModifyPwdTopBarInfo);
      QLog.d("ModifyPwdTopBarObserver", 1, "onUpdateBarDisplayInfo isSuccess: " + paramBoolean + " shouldDisplay: " + bool + " content: " + str1 + " barUrl: " + str2 + " nextAccessTime: " + i);
    } while (!paramBoolean);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "key_show_status", true);
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "time_fetch_next_time", i * 1000L);
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "bar_url", str2);
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "bar_content_string", str1);
      this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "key_verify_for_dlg_or_clk", false);
    this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_JavaLangString, "key_show_status", false);
    this.jdField_a_of_type_ComTencentMobileqqSecurityModifyPwdTopBarHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.security.ModifyPwdTopBarHelper.2
 * JD-Core Version:    0.7.0.1
 */