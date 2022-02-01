package com.tencent.mobileqq.haoliyou;

import android.net.Uri;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class JumpForwardSecurityCheck$1
  implements UriParserPathHelper.IOnFileCopyFinishListener
{
  JumpForwardSecurityCheck$1(JumpForwardSecurityCheck paramJumpForwardSecurityCheck, int paramInt, String paramString) {}
  
  public void a(Uri paramUri)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("system share.prepareFileInfoAndReq : onFaild= ");
    localStringBuilder.append(paramUri);
    QLog.e("CheckForward.Security", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqHaoliyouJumpForwardSecurityCheck.a.finish();
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    paramString2 = new StringBuilder();
    paramString2.append("system share.prepareFileInfoAndReq : onFinish= ");
    paramString2.append(paramString1);
    QLog.d("CheckForward.Security", 1, paramString2.toString());
    try
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.jdField_a_of_type_ComTencentMobileqqHaoliyouJumpForwardSecurityCheck.a(paramString2, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_Int == 4)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.jdField_a_of_type_ComTencentMobileqqHaoliyouJumpForwardSecurityCheck.b(paramString2, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqHaoliyouJumpForwardSecurityCheck.a(paramString1, this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("CheckForward.Security", 1, "system share.prepareFileInfoAndReq exception=", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck.1
 * JD-Core Version:    0.7.0.1
 */