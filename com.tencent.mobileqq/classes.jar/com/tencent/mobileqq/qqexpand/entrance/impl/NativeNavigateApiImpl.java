package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qqexpand.entrance.INativeNavigateApi;
import com.tencent.mobileqq.qqexpand.flutter.router.BaseRouter;
import com.tencent.mobileqq.qqexpand.flutter.router.RouterManager;
import com.tencent.mobileqq.qqexpand.utils.NativeNavigateUtils;
import java.util.Map;
import mqq.app.MobileQQ;

public class NativeNavigateApiImpl
  implements INativeNavigateApi
{
  public void navigateBySchema(String paramString)
  {
    NativeNavigateUtils.a.c(MobileQQ.sMobileQQ, paramString);
  }
  
  public void navigateMiniApp(String paramString)
  {
    NativeNavigateUtils.a.a(MobileQQ.sMobileQQ, paramString);
  }
  
  public void navigateWebView(String paramString)
  {
    NativeNavigateUtils.a.b(MobileQQ.sMobileQQ, paramString);
  }
  
  public void navigateWithoutSchema(String paramString, Map<Object, Object> paramMap1, Map<Object, Object> paramMap2)
  {
    if (!RouterManager.d().b()) {
      RouterManager.d().a();
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = Uri.parse(paramString);
    if (paramString != null)
    {
      if (!TextUtils.equals(paramString.getScheme(), "mqqapi")) {
        return;
      }
      BaseRouter localBaseRouter = RouterManager.d().a(paramString.getAuthority());
      if (localBaseRouter != null) {
        localBaseRouter.a(paramString, paramMap1, paramMap2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.NativeNavigateApiImpl
 * JD-Core Version:    0.7.0.1
 */