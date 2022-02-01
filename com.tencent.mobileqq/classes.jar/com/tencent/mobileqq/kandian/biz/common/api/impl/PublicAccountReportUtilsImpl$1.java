package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class PublicAccountReportUtilsImpl$1
  implements Runnable
{
  PublicAccountReportUtilsImpl$1(PublicAccountReportUtilsImpl paramPublicAccountReportUtilsImpl, String paramString1, String paramString2, AppInterface paramAppInterface, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject = str;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
        localObject = null;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject = (QQAppInterface)localAppRuntime;
        }
        if (localObject != null)
        {
          if (!((IPublicAccountDataManager)((AppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(this.jdField_b_of_type_JavaLangString))) {
            break label199;
          }
          localObject = "1";
          localJSONObject.put("fans", localObject);
        }
        localObject = localJSONObject.toString();
      }
      catch (Exception localException)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doVideoDataReportWithFansInfoInR5() error exception = ");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.e("PublicAccountReportUtils", 2, ((StringBuilder)localObject).toString());
          localObject = str;
        }
      }
      this.this$0.publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.e, this.f, this.g, (String)localObject, this.jdField_a_of_type_Boolean);
      return;
      label199:
      localObject = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */