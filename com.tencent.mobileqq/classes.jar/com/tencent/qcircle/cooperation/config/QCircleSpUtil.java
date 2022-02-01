package com.tencent.qcircle.cooperation.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleSpUtil
{
  public static SharedPreferences a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "sp_qqcircle";
    if (paramBoolean1)
    {
      str = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
      str = "sp_qqcircle" + "_" + str;
    }
    int j = 0;
    int i = j;
    if (paramBoolean2)
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 11) {
        i = 4;
      }
    }
    if (RFApplication.getApplication() != null) {
      return RFApplication.getApplication().getSharedPreferences(str, i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleSpUtil
 * JD-Core Version:    0.7.0.1
 */