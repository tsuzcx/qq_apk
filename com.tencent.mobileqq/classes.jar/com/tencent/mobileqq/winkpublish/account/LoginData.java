package com.tencent.mobileqq.winkpublish.account;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.util.HexUtil;
import com.tencent.qphone.base.util.QLog;

public class LoginData
{
  private static final String a;
  private static volatile LoginData c = null;
  private static final Object d = new Object();
  private String b = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("LoginData");
    a = localStringBuilder.toString();
  }
  
  public static LoginData a()
  {
    if (c == null) {
      synchronized (d)
      {
        if (c == null) {
          c = new LoginData();
        }
      }
    }
    return c;
  }
  
  public long b()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        long l = Long.parseLong(str);
        return l;
      }
      catch (Exception localException)
      {
        QLog.w(a, 1, localException.getMessage());
      }
    }
    return 0L;
  }
  
  public String c()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
  }
  
  public String d()
  {
    return ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getA2();
  }
  
  public byte[] e()
  {
    String str = d();
    if (!TextUtils.isEmpty(str)) {
      return HexUtil.a(str);
    }
    QLog.e(a, 1, "getA2Bytes null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.account.LoginData
 * JD-Core Version:    0.7.0.1
 */