package com.tencent.open.appstore.cookie;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;

public class CookieUtils
{
  public static void a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      paramString = Uri.parse(paramString);
      if ((paramString != null) && (paramString.getHost() != null))
      {
        bool = b(paramString.getHost().toLowerCase());
        if (!bool) {
          return;
        }
        paramString = new CookieSyncManagerImpl(CommonDataAdapter.a().b());
        CookieManagerImpl localCookieManagerImpl = new CookieManagerImpl();
        localCookieManagerImpl.a(true);
        long l = CommonDataAdapter.a().c();
        String str = MobileInfoUtil.getImei();
        Object localObject = CommonDataAdapter.a().e();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin=");
        localStringBuilder.append(l);
        localStringBuilder.append("; path=/; domain=.");
        localStringBuilder.append("qq.com");
        localStringBuilder.append(";");
        localCookieManagerImpl.a("qq.com/", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("skey=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("; path=/; domain=.");
        localStringBuilder.append("qq.com");
        localStringBuilder.append(";");
        localCookieManagerImpl.a("qq.com/", localStringBuilder.toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("imei=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("; path=/; domain=.");
        ((StringBuilder)localObject).append("qq.com");
        ((StringBuilder)localObject).append(";");
        localCookieManagerImpl.a("qq.com/", ((StringBuilder)localObject).toString());
        paramString.a();
        return;
      }
      return;
    }
    finally {}
  }
  
  public static boolean b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.endsWith(".qq.com")) || (paramString.endsWith(".myapp.com")) || (paramString.endsWith(".3gqq.com")) || (paramString.endsWith(".qzone.com"))))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("host:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isAuthedDomain:true");
      LogUtility.c("CookieUtils", localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("host:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isAuthedDomain:false");
    LogUtility.c("CookieUtils", localStringBuilder.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieUtils
 * JD-Core Version:    0.7.0.1
 */