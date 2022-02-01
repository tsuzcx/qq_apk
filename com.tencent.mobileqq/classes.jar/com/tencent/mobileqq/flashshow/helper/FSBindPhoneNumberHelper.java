package com.tencent.mobileqq.flashshow.helper;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.widgets.common.FSCustomDialog;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class FSBindPhoneNumberHelper
{
  private static boolean a = false;
  
  public static void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshAccountState  isBackFromH5 : ");
    localStringBuilder.append(paramBoolean);
    QLog.i("QCircleBindPhoneNumberHelper", 1, localStringBuilder.toString());
    FSStaticInvokeHelper.sendAccountIdentityRequest(new FSBindPhoneNumberHelper.1());
  }
  
  public static boolean a()
  {
    boolean bool2 = QCircleConfigHelper.u();
    boolean bool1 = true;
    if (bool2)
    {
      int i = FSConfig.o();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkIsBindPhoneNumber  isAuthenticated : ");
      localStringBuilder.append(i);
      QLog.i("QCircleBindPhoneNumberHelper", 1, localStringBuilder.toString());
      if (i == 0)
      {
        a(false);
        return true;
      }
      if (i == 2)
      {
        a(false);
        return false;
      }
      if (i == 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      if (a) {
        return false;
      }
      if (paramContext.getResources() != null)
      {
        String str1 = paramContext.getResources().getString(2131889702);
        String str2 = paramContext.getResources().getString(2131889700);
        FSBindPhoneNumberHelper.3 local3 = new FSBindPhoneNumberHelper.3(paramContext);
        paramContext = FSCustomDialog.a(paramContext, str1, str2, 2131889699, 2131889701, local3, local3);
        paramContext.setCancelable(false);
        a = true;
        paramContext.show();
        QLog.i("QCircleBindPhoneNumberHelper", 1, "handleBindPhoneNumber  dialog show");
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSBindPhoneNumberHelper
 * JD-Core Version:    0.7.0.1
 */