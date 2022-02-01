package com.tencent.mobileqq.webview.sonic;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.sonic.sdk.SonicRuntime;
import com.tencent.sonic.sdk.SonicSessionClient;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SonicRuntimeImpl
  extends SonicRuntime
{
  public static final String TAG = "SonicSdkImpl_SonicRuntimeImpl";
  
  public SonicRuntimeImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean enableQuicForSonic()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i = QbSdk.getTbsVersion(BaseApplication.getContext().getApplicationContext());
      if (i >= 44401)
      {
        localObject = ((AppRuntime)localObject).getAccount();
        BaseApplication localBaseApplication = BaseApplication.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_x5_config_");
        localStringBuilder.append((String)localObject);
        bool1 = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("key_x5_enable_quic", false);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableQuicForSonic, x5 version is too low ");
        ((StringBuilder)localObject).append(i);
        QLog.w("SonicSdkImpl_SonicRuntimeImpl", 1, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableQuicForSonic: ");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("SonicSdkImpl_SonicRuntimeImpl", 1, ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  public Object createWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream, Map<String, String> paramMap)
  {
    paramString1 = new WebResourceResponse(paramString1, paramString2, paramInputStream);
    paramString1.setResponseHeaders(paramMap);
    return paramString1;
  }
  
  public String getCookie(String paramString)
  {
    return SwiftBrowserCookieMonster.c(paramString);
  }
  
  public String getCurrentUserAccount()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
  }
  
  public String getHostDirectAddress(String paramString)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = localObject3;
    try
    {
      long l = System.currentTimeMillis();
      localObject2 = localObject3;
      Object localObject5 = BaseInnerDns.queryInstance();
      Object localObject1 = localObject4;
      if (localObject5 != null)
      {
        localObject2 = localObject3;
        localObject5 = Uri.parse(paramString);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (((Uri)localObject5).isHierarchical())
        {
          localObject2 = localObject3;
          String str = ((Uri)localObject5).getQueryParameter("_sonic_xv");
          localObject1 = localObject4;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str))
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (1L == (Long.parseLong(str) & 1L))
            {
              localObject2 = localObject3;
              if (((Uri)localObject5).getScheme().equalsIgnoreCase("https"))
              {
                localObject2 = localObject3;
                localObject1 = WebAccelerateHelper.getInstance().queryWebViewFeatureParams();
                if (localObject1 != null)
                {
                  localObject2 = localObject3;
                  if (1 == localObject1[10].intValue())
                  {
                    localObject2 = localObject3;
                    localObject1 = new StringBuilder();
                    localObject2 = localObject3;
                    ((StringBuilder)localObject1).append("getHostDirectAddress(");
                    localObject2 = localObject3;
                    ((StringBuilder)localObject1).append(paramString);
                    localObject2 = localObject3;
                    ((StringBuilder)localObject1).append(") fail:SW_ENABLE_SONIC_HTTPS_DNS_PREFETCH is not enable!");
                    localObject2 = localObject3;
                    QLog.i("SonicSdkImpl_SonicRuntimeImpl", 1, ((StringBuilder)localObject1).toString());
                    return null;
                  }
                }
              }
              localObject2 = localObject3;
              localObject1 = BaseInnerDns.getInstance().reqDns(((Uri)localObject5).getHost(), 1013, false);
            }
          }
        }
      }
      localObject2 = localObject1;
      localObject3 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        localObject3 = new StringBuilder();
        localObject2 = localObject1;
        ((StringBuilder)localObject3).append("getHostDirectAddress(");
        localObject2 = localObject1;
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject2 = localObject1;
        ((StringBuilder)localObject3).append("), cost ");
        localObject2 = localObject1;
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
        localObject2 = localObject1;
        ((StringBuilder)localObject3).append(" ms.");
        localObject2 = localObject1;
        QLog.i("SonicSdkImpl_SonicRuntimeImpl", 2, ((StringBuilder)localObject3).toString());
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getHostDirectAddress error:");
      ((StringBuilder)localObject3).append(localException.getMessage());
      ((StringBuilder)localObject3).append(", url=");
      ((StringBuilder)localObject3).append(paramString);
      QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, ((StringBuilder)localObject3).toString());
      localObject3 = localObject2;
    }
    return localObject3;
  }
  
  public String getUserAgent()
  {
    return WebSoUtils.a();
  }
  
  public boolean isNetworkValid()
  {
    return NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0;
  }
  
  public boolean isSonicUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localObject1 = WebAccelerateHelper.getInstance().queryWebViewFeatureParams();
        if (localObject1 != null)
        {
          int j = localObject1[8].intValue();
          i = j;
          if (-1 == j)
          {
            i = j;
            if (QbSdk.getTbsVersion(BaseApplication.getContext().getApplicationContext()) != 0) {
              break label503;
            }
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT < 24) || (QbSdk.getTbsVersion(BaseApplication.getContext().getApplicationContext()) != 0)) {
            break label503;
          }
          i = -1;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isSonicUrl:check sonic enable cost ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
          ((StringBuilder)localObject1).append(" ms.");
          QLog.d("SonicSdkImpl_SonicRuntimeImpl", 2, ((StringBuilder)localObject1).toString());
        }
        if (1 != i)
        {
          paramString = new StringBuilder();
          paramString.append("isSonicUrl: dpc disable sonic, enableSonic = ");
          paramString.append(i);
          QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, paramString.toString());
          return false;
        }
        localObject1 = paramString.trim();
        Object localObject2 = SwiftWebViewUtils.b((String)localObject1);
        if (("http".equals(localObject2)) || ("https".equals(localObject2)))
        {
          localObject2 = Uri.parse((String)localObject1);
          if ((localObject2 != null) && (((Uri)localObject2).isHierarchical()) && (("3".equals(((Uri)localObject2).getQueryParameter("asyncMode"))) || ("1".equals(((Uri)localObject2).getQueryParameter("sonic")))))
          {
            localObject2 = ((Uri)localObject2).getHost();
            AuthorizeConfig localAuthorizeConfig = AuthorizeConfig.a();
            if ((!((String)localObject2).endsWith(".qq.com")) && (!((String)localObject2).endsWith(".tencent.com")))
            {
              if ((!localAuthorizeConfig.b(paramString)) && (!localAuthorizeConfig.g((String)localObject1)))
              {
                paramString = new StringBuilder();
                paramString.append("isSonicUrl return false! ");
                paramString.append(Util.c((String)localObject1, new String[0]));
                QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, paramString.toString());
                return false;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              paramString = new StringBuilder();
              paramString.append("isSonicUrl from white list, return true! ");
              paramString.append(Util.c((String)localObject1, new String[0]));
              QLog.d("SonicSdkImpl_SonicRuntimeImpl", 2, paramString.toString());
              return true;
            }
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("isSonicUrl return true! ");
              paramString.append(Util.c((String)localObject1, new String[0]));
              QLog.d("SonicSdkImpl_SonicRuntimeImpl", 2, paramString.toString());
            }
            return true;
          }
        }
      }
      catch (Throwable paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isSonicUrl error:");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, ((StringBuilder)localObject1).toString());
      }
      return false;
      label503:
      int i = 1;
    }
    return true;
  }
  
  public void log(String paramString1, int paramInt, String paramString2)
  {
    if (3 == paramInt)
    {
      QLog.d(paramString1, 1, paramString2);
      return;
    }
    if (4 == paramInt)
    {
      QLog.i(paramString1, 1, paramString2);
      return;
    }
    if (5 == paramInt)
    {
      QLog.w(paramString1, 1, paramString2);
      return;
    }
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void notifyError(SonicSessionClient paramSonicSessionClient, String paramString, int paramInt)
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (i == 0) {
      i = -1;
    }
    VasBaseWebviewUtil.doSonicErrorCodeReport("SonicReport", "SonicErrorCode", paramString, paramInt, i, 0, "", "");
  }
  
  public void postTaskToMainThread(Runnable paramRunnable, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public void postTaskToThread(Runnable paramRunnable, long paramLong)
  {
    ThreadManager.getSubThreadHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public boolean setCookie(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      try
      {
        String[] arrayOfString = new String[paramList.size()];
        paramList.toArray(arrayOfString);
        paramList = new HashMap(1);
        paramList.put(paramString, arrayOfString);
        CookieManager.getInstance().setCookies(paramList);
        return true;
      }
      catch (Throwable paramString)
      {
        paramList = new StringBuilder();
        paramList.append("setCookies error:");
        paramList.append(paramString.getMessage());
        QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, paramList.toString());
      }
    }
    return false;
  }
  
  public boolean shouldLog(int paramInt)
  {
    if ((paramInt != 6) && (paramInt != 4)) {
      return QLog.isColorLevel();
    }
    return true;
  }
  
  public void showToast(CharSequence paramCharSequence, int paramInt)
  {
    try
    {
      QQToast.a(BaseApplication.getContext().getApplicationContext(), 1, paramCharSequence, 0).a();
      return;
    }
    catch (Exception paramCharSequence)
    {
      QLog.e("SonicSdkImpl_SonicRuntimeImpl", 1, "showToast exception e =", paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */