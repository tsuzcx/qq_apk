package com.tencent.mobileqq.qqgamepub.hippy.module;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

@HippyNativeModule(name="QQWadlModule")
public class QQWadlModule
  extends QQBaseModule
{
  static final String NAME = "QQWadlModule";
  private static final String TAG = "QQGamePub_QQWadlModule";
  private volatile WadlProxyServiceCallBackInterface mWadlCallback;
  
  public QQWadlModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void sendEvent(String paramString, Object paramObject)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramObject);
  }
  
  public static HippyMap toHippyMap(WadlResult paramWadlResult)
  {
    HippyMap localHippyMap = new HippyMap();
    if ((paramWadlResult != null) && (paramWadlResult.a != null))
    {
      WadlParams localWadlParams = paramWadlResult.a;
      localHippyMap.pushString("appid", localWadlParams.e);
      localHippyMap.pushInt("state", GameCenterUtil.a(paramWadlResult.d));
      localHippyMap.pushInt("pro", paramWadlResult.k);
      localHippyMap.pushString("packagename", localWadlParams.m);
      localHippyMap.pushString("via", localWadlParams.w);
      localHippyMap.pushInt("writecodestate", 0);
      localHippyMap.pushString("extraInfo", localWadlParams.z);
      localHippyMap.pushBoolean("isAutoInstallBySDK", localWadlParams.a(1));
      localHippyMap.pushBoolean("isRes", localWadlParams.b);
      int i = GameCenterUtil.b(paramWadlResult.j);
      localHippyMap.pushInt("errorCode", i);
      localHippyMap.pushString("errorMsg", GameCenterUtil.c(i));
    }
    return localHippyMap;
  }
  
  @HippyMethod(name="deleteDownload")
  public void deleteDownload(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteDownload appid=");
    localStringBuilder.append(paramString);
    QLog.i("QQGamePub_QQWadlModule", 1, localStringBuilder.toString());
    WadlProxyServiceUtil.a().c(0, paramString);
  }
  
  public void destroy()
  {
    super.destroy();
    unregisterListener();
  }
  
  @HippyMethod(name="doDownloadAction")
  public void doDownloadAction(String paramString, Promise paramPromise)
  {
    Object localObject = new WadlParams(paramString);
    ((WadlParams)localObject).h = 0;
    WadlProxyServiceUtil.a().a((WadlParams)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doDownloadAction jsonParams=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("QQGamePub_QQWadlModule", 1, ((StringBuilder)localObject).toString());
    if (paramPromise != null) {
      paramPromise.resolve(Integer.valueOf(0));
    }
  }
  
  @HippyMethod(name="getAvailableBytes")
  public void getAvailableBytes(Promise paramPromise)
  {
    if (paramPromise != null) {}
    try
    {
      paramPromise.resolve(Long.valueOf(Utils.c()));
      return;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    paramPromise.resolve(Integer.valueOf(0));
  }
  
  @HippyMethod(name="getInstalledAppVersionCode")
  public void getInstalledAppVersionCode(String paramString1, String paramString2, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQWadlModule", 2, new Object[] { "getInstalledAppVersionCode packageNameJsonStr=", paramString1, ",guid=", paramString2 });
    }
    String str1 = paramString2;
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString1);
        paramString1 = paramString2;
        str1 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          str1 = paramString2;
          paramString1 = ((JSONObject)localObject).optString("guid");
        }
        str1 = paramString1;
        JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("packageNames");
        str1 = paramString1;
        localJSONArray1 = new JSONArray();
        if (localJSONArray2 == null) {
          continue;
        }
        i = 0;
        str1 = paramString1;
        if (i >= localJSONArray2.length()) {
          continue;
        }
        str1 = paramString1;
        str3 = localJSONArray2.getString(i);
        str1 = paramString1;
        paramString2 = GameCenterUtil.d(str3);
        localObject = "";
        if (paramString2 == null) {
          continue;
        }
        str1 = paramString1;
        localObject = String.valueOf(paramString2.versionCode);
        str1 = paramString1;
        paramString2 = paramString2.versionName;
        str1 = paramString1;
        str2 = GameCenterUtil.e(GameCenterUtil.c(str3));
      }
      catch (Exception paramString1)
      {
        Object localObject;
        JSONArray localJSONArray1;
        int i;
        String str3;
        JSONObject localJSONObject;
        continue;
        paramString2 = "";
        String str2 = paramString2;
        continue;
      }
      str1 = paramString1;
      localJSONObject = new JSONObject();
      str1 = paramString1;
      localJSONObject.put("packageName", str3);
      str1 = paramString1;
      localJSONObject.put("versionCode", localObject);
      str1 = paramString1;
      localJSONObject.put("versionName", paramString2);
      str1 = paramString1;
      localJSONObject.put("channel", str2);
      str1 = paramString1;
      localJSONArray1.put(localJSONObject);
      i += 1;
    }
    str1 = paramString1;
    paramString2 = new HippyMap();
    str1 = paramString1;
    paramString2.pushString("guid", paramString1);
    str1 = paramString1;
    paramString2.pushInt("r", 0);
    str1 = paramString1;
    paramString2.pushString("data", localJSONArray1.toString());
    str1 = paramString1;
    paramPromise.resolve(paramString2);
    return;
    paramString1 = new HippyMap();
    paramString1.pushString("guid", str1);
    paramString1.pushInt("r", -1);
    paramPromise.resolve(paramString1);
  }
  
  @HippyMethod(name="getQueryDownloadAction")
  public void getQueryDownloadAction(String paramString, Promise paramPromise)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("QQGamePub_QQWadlModule", 2, new Object[] { "getQueryDownloadAction, jsonParams=", paramString });
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("infolist");
        int j = paramString.length();
        paramPromise = new ArrayList();
        if (i < j)
        {
          String str = paramString.getJSONObject(i).optString("appid");
          if (TextUtils.isEmpty(str)) {
            break label127;
          }
          paramPromise.add(str);
          break label127;
        }
        if (paramPromise.size() > 0)
        {
          WadlProxyServiceUtil.a().a(paramPromise);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QQGamePub_QQWadlModule", 1, "query getQueryDownloadAction>>>", paramString);
      }
      return;
      label127:
      i += 1;
    }
  }
  
  @HippyMethod(name="openFloatingSetting")
  public void openFloatingSetting(String paramString, Promise paramPromise)
  {
    Object localObject;
    int i;
    if (Build.VERSION.SDK_INT <= 28)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sdk version lower android10,version is ");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        QLog.d("QQGamePub_QQWadlModule", 1, ((StringBuilder)localObject).toString());
      }
      i = 0;
    }
    else
    {
      localObject = Foreground.getTopActivity();
      if (localObject != null)
      {
        ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission((Context)localObject);
        i = 1;
      }
      else
      {
        i = -1;
      }
      new WadlReportBuilder().a("dc00087").h("558").b(paramString).c("202473").a(i).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openFloatingSetting appid=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",result=");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQGamePub_QQWadlModule", 1, ((StringBuilder)localObject).toString());
    }
    if (paramPromise != null) {
      paramPromise.resolve(Integer.valueOf(i));
    }
  }
  
  @HippyMethod(name="queryAllDownloadTask")
  public void queryAllDownloadTask()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQWadlModule", 2, "queryAllDownloadTask");
    }
    WadlProxyServiceUtil.a().a();
  }
  
  @HippyMethod(name="queryFloatingPermission")
  public void queryFloatingPermission(String paramString, Promise paramPromise)
  {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    StringBuilder localStringBuilder;
    boolean bool1;
    if (j <= 28)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sdk version lower android10,version is ");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        QLog.d("QQGamePub_QQWadlModule", 1, localStringBuilder.toString());
      }
      bool1 = true;
    }
    else
    {
      boolean bool2 = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.getContext());
      bool1 = bool2;
      if (!bool2)
      {
        new WadlReportBuilder().a("dc00087").h("558").b(paramString).c("202473").a(0).a();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryFloatingPermission appid=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",floatPermission=");
      localStringBuilder.append(bool1);
      QLog.d("QQGamePub_QQWadlModule", 1, localStringBuilder.toString());
    }
    if (paramPromise != null)
    {
      if (bool1) {
        i = 1;
      }
      paramPromise.resolve(Integer.valueOf(i));
    }
  }
  
  @HippyMethod(name="registerListener")
  public void registerListener()
  {
    if (this.mWadlCallback == null)
    {
      this.mWadlCallback = new QQWadlModule.1(this);
      WadlProxyServiceUtil.a().a(this.mWadlCallback);
    }
  }
  
  @HippyMethod(name="requestFloatingPermission")
  public void requestFloatingPermission(String paramString, Promise paramPromise)
  {
    QLog.d("QQGamePub_QQWadlModule", 1, "hippy api call requestFloatingPermission");
    GameCenterUtil.f(paramString);
    if (paramPromise != null) {
      paramPromise.resolve(Integer.valueOf(0));
    }
  }
  
  @HippyMethod(name="unregisterListener")
  public void unregisterListener()
  {
    if (this.mWadlCallback != null)
    {
      WadlProxyServiceUtil.a().b(this.mWadlCallback);
      this.mWadlCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.module.QQWadlModule
 * JD-Core Version:    0.7.0.1
 */