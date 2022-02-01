package com.tencent.mobileqq.jsp;

import android.content.Context;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

@Deprecated
public class AppShareJavaScript
  extends JsBridge.JsHandler
{
  Context a;
  private QQApiPlugin b;
  private boolean c = false;
  
  public AppShareJavaScript(Context paramContext)
  {
    this.a = paramContext;
    this.b = new QQApiPlugin();
    try
    {
      localObject = QQApiPlugin.class.getDeclaredField("a");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(this.b, paramContext);
      this.c = true;
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQApi init error: ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.d("QQApi", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void call(String paramString, List<String> paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    if (!this.c)
    {
      QLog.d("QQApi", 2, "QQApi not ready");
      return;
    }
    int i = paramList.size();
    label524:
    for (;;)
    {
      try
      {
        boolean bool = "isAppInstalled".equals(paramString);
        Object localObject = null;
        if ((bool) && (i == 1))
        {
          paramList = Boolean.valueOf(PackageUtil.a(this.a, (String)paramList.get(0)));
        }
        else if (("checkAppInstalled".equals(paramString)) && (i == 1))
        {
          paramList = PackageUtil.b(this.a, (String)paramList.get(0));
        }
        else if (("checkAppInstalledBatch".equals(paramString)) && (i == 1))
        {
          paramList = PackageUtil.c(this.a, (String)paramList.get(0));
        }
        else if (("isAppInstalledBatch".equals(paramString)) && (i == 1))
        {
          paramList = PackageUtil.d(this.a, (String)paramList.get(0));
        }
        else if (("startAppWithPkgName".equals(paramString)) && (i == 1))
        {
          paramList = Boolean.valueOf(PackageUtil.a(this.a, (String)paramList.get(0), null));
        }
        else if (("startAppWithPkgNameAndOpenId".equals(paramString)) && (i == 2))
        {
          paramList = Boolean.valueOf(PackageUtil.a(this.a, (String)paramList.get(0), (String)paramList.get(1)));
        }
        else if (("getOpenidBatch".equals(paramString)) && (i == 1))
        {
          paramList = "";
        }
        else if (("launchAppWithTokens".equals(paramString)) && (i == 4))
        {
          this.b.a((String)paramList.get(0), (String)paramList.get(1), (String)paramList.get(2), (String)paramList.get(3), null, "");
          paramList = localObject;
        }
        else if (("getAppsVerionCodeBatch".equals(paramString)) && (i == 1))
        {
          paramList = PackageUtil.e(this.a, (String)paramList.get(0));
        }
        else if (("setShareURL".equals(paramString)) && (i == 1))
        {
          paramList = Boolean.valueOf(false);
        }
        else if (("setShareInfo".equals(paramString)) && (i == 1))
        {
          paramList = Boolean.valueOf(false);
        }
        else if (("sendDocToChat".equals(paramString)) && (i == 1))
        {
          paramList = Boolean.valueOf(false);
          break label524;
          paramJsBridgeListener.a(paramList);
        }
        else
        {
          paramJsBridgeListener.a();
          return;
        }
      }
      catch (Exception paramList)
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("error in QQApi.");
        paramJsBridgeListener.append(paramString);
        paramJsBridgeListener.append(": ");
        paramJsBridgeListener.append(paramList.getMessage());
        QLog.d("QQApi", 2, paramJsBridgeListener.toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AppShareJavaScript
 * JD-Core Version:    0.7.0.1
 */