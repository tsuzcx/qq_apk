package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import bbjw;
import bhzv;
import bhzw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class DesktopDittoAreaView
  extends DittoAreaView
{
  public static final String TAG = "DesktopDittoAreaView";
  private WeakReference<Activity> activityWeakReference;
  private DesktopDittoInfo dittoInfo;
  
  public DesktopDittoAreaView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.activityWeakReference = new WeakReference((Activity)paramContext);
  }
  
  public DesktopDittoAreaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getTianShuAdId()
  {
    if (this.dittoInfo == null) {
      return 0;
    }
    int i = this.dittoInfo.appInfoMap.size();
    if (i > 0) {}
    for (;;)
    {
      int j = this.dittoInfo.currentIndex;
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)new ArrayList(this.dittoInfo.appInfoMap.values()).get(j % i);
      if ((localMiniAppInfo == null) || (localMiniAppInfo.tianshuAdId <= 0)) {
        break;
      }
      return localMiniAppInfo.tianshuAdId;
      i = 1;
    }
    return 0;
  }
  
  public void handleExposureReport()
  {
    if (this.exposureReportingAreas.size() <= 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = MiniAppUtils.getAppInterface();
    } while (localObject1 == null);
    MiniAppExposureManager localMiniAppExposureManager = (MiniAppExposureManager)((AppInterface)localObject1).getManager(322);
    Iterator localIterator = this.exposureReportingAreas.iterator();
    Object localObject3 = "";
    for (;;)
    {
      Object localObject5;
      if (localIterator.hasNext())
      {
        localObject5 = ((DittoArea)localIterator.next()).getLayoutAttr().getAttr("extendString", "");
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          localObject1 = localObject3;
        }
      }
      else
      {
        for (;;)
        {
          int i;
          try
          {
            Object localObject6 = new JSONObject((String)localObject5);
            localObject1 = localObject3;
            QLog.e("DesktopDittoAreaView", 1, "handleExposureReport: data" + ((JSONObject)localObject6).toString());
            localObject1 = localObject3;
            localObject5 = ((JSONObject)localObject6).optString("refer");
            localObject1 = localObject5;
            Object localObject7 = ((JSONObject)localObject6).optString("actionType");
            localObject1 = localObject5;
            String str = ((JSONObject)localObject6).optString("subAction");
            localObject1 = localObject5;
            localObject3 = ((JSONObject)localObject6).optString("reservesAction");
            localObject1 = localObject5;
            JSONArray localJSONArray = ((JSONObject)localObject6).optJSONArray("report");
            if (localJSONArray != null)
            {
              localObject1 = localObject5;
              if (localJSONArray.length() > 0)
              {
                i = 0;
                localObject1 = localObject5;
                if (i >= localJSONArray.length()) {
                  continue;
                }
                localObject1 = localObject5;
                localObject7 = localJSONArray.optJSONObject(i);
                localObject1 = localObject5;
                Object localObject8 = ((JSONObject)localObject7).optString("appId");
                localObject1 = localObject5;
                localObject7 = ((JSONObject)localObject7).optString("reserves2");
                localObject1 = localObject5;
                if (this.dittoInfo != null)
                {
                  localObject1 = localObject5;
                  localObject8 = (MiniAppInfo)this.dittoInfo.appInfoMap.get(localObject8);
                  if (localObject8 != null)
                  {
                    localObject1 = localObject5;
                    localObject8 = new MiniAppConfig((MiniAppInfo)localObject8);
                    localObject1 = localObject5;
                    ((MiniAppConfig)localObject8).launchParam.scene = Integer.valueOf((String)localObject5).intValue();
                    localObject1 = localObject5;
                    MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject8, "page_view", "expo");
                    localObject1 = localObject5;
                    StringBuilder localStringBuilder = new StringBuilder();
                    localObject1 = localObject5;
                    localStringBuilder.append(((MiniAppConfig)localObject8).config.appId).append("_").append(((MiniAppConfig)localObject8).config.verType).append("_").append(this.dittoInfo.getModuleType());
                    localObject1 = localObject5;
                    localMiniAppExposureManager.putReportDataToMap(localStringBuilder.toString(), localMiniAppModuleExposureData);
                  }
                }
                localObject1 = localObject5;
                if (TextUtils.isEmpty(str)) {
                  break label860;
                }
                localObject1 = localObject5;
                localMiniAppExposureManager.putReportDataToMap(str, new MiniAppExposureManager.CardModuleExposureData("desktop", str, (String)localObject3, (String)localObject7));
                break label860;
              }
            }
            localObject1 = localObject5;
            if (bbjw.a((String)localObject7))
            {
              localObject1 = localObject5;
              localObject3 = new MiniAppExposureManager.CardModuleExposureData("desktop", str, (String)localObject3, null);
              localObject1 = localObject5;
              localMiniAppExposureManager.putReportDataToMap(str, (MiniAppExposureManager.BaseExposureReport)localObject3);
              localObject1 = localObject5;
              if (!((JSONObject)localObject6).has("dubheReportData")) {
                break label867;
              }
              localObject1 = localObject5;
              localObject3 = ((JSONObject)localObject6).optJSONObject("dubheReportData");
              localObject1 = localObject5;
              localObject6 = ((JSONObject)localObject3).optString("appId");
              localObject1 = localObject5;
              str = ((JSONObject)localObject3).optString("pageId");
              localObject1 = localObject5;
              if (!((JSONObject)localObject3).has("useMiniAppInfoTianShuId")) {
                break label669;
              }
              localObject1 = localObject5;
              i = getTianShuAdId();
              if (i != 0)
              {
                localObject1 = localObject5;
                localObject3 = String.valueOf(i);
                localObject1 = localObject5;
                localMiniAppExposureManager.putReportDataToMap((String)localObject3, new MiniAppExposureManager.TianShuExposureData((String)localObject6, str, (String)localObject3, 101));
                break label867;
              }
            }
            else
            {
              localObject1 = localObject5;
              localObject3 = new MiniAppExposureManager.CardModuleExposureData((String)localObject7, str, (String)localObject3, null);
              continue;
            }
            localObject1 = localObject5;
          }
          catch (Exception localException2)
          {
            QLog.e("DesktopDittoAreaView", 1, "handleExposureReport exception: " + Log.getStackTraceString(localException2));
          }
          localObject4 = localException2.optString("itemId");
          continue;
          label669:
          localObject1 = localObject5;
          localObject4 = ((JSONObject)localObject4).optString("itemId");
          continue;
          if ((this.dittoInfo == null) || (this.dittoInfo.jumpMoreInfo == null) || (TextUtils.isEmpty(this.dittoInfo.jumpMoreInfo.appId)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
            break;
          }
          try
          {
            localObject1 = new MiniAppConfig(this.dittoInfo.jumpMoreInfo);
            ((MiniAppConfig)localObject1).launchParam.scene = Integer.valueOf((String)localObject4).intValue();
            localObject4 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject1, "page_view", "expo");
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(((MiniAppConfig)localObject1).config.appId).append("_").append(((MiniAppConfig)localObject1).config.verType).append("_").append(this.dittoInfo.getModuleType());
            localMiniAppExposureManager.putReportDataToMap(((StringBuilder)localObject5).toString(), (MiniAppExposureManager.BaseExposureReport)localObject4);
            return;
          }
          catch (Exception localException1)
          {
            QLog.e("DesktopDittoAreaView", 1, "handleExposureReport, app store, exception: " + Log.getStackTraceString(localException1));
            return;
          }
          label860:
          i += 1;
        }
        label867:
        Object localObject2 = localObject5;
        Object localObject4 = localObject2;
      }
    }
  }
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = null;
    label289:
    label300:
    label456:
    int j;
    if (!TextUtils.isEmpty(paramString))
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject(paramString);
        String str1;
        String str2;
        if (localJSONObject.has("dubheReportData"))
        {
          paramString = localJSONObject.optJSONObject("dubheReportData");
          str1 = paramString.optString("appId");
          str2 = paramString.optString("pageId");
          if (!paramString.has("useMiniAppInfoTianShuId")) {
            break label300;
          }
          i = getTianShuAdId();
          if (i == 0) {
            break label289;
          }
          paramString = String.valueOf(i);
          break label1024;
        }
        for (;;)
        {
          bhzw localbhzw = new bhzw();
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          paramDittoArea = "";
          if (localAppRuntime != null) {
            paramDittoArea = localAppRuntime.getAccount();
          }
          long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          localbhzw.b = (paramDittoArea + "_" + l);
          localbhzw.jdField_a_of_type_Int = 1;
          localbhzw.jdField_e_of_type_JavaLangString = str1;
          localbhzw.f = str2;
          localbhzw.g = paramString;
          localbhzw.d = 102;
          localbhzw.jdField_e_of_type_Int = 1;
          localbhzw.jdField_a_of_type_Long = l;
          bhzv.a().a(localbhzw);
          if (!localJSONObject.has("appId")) {
            break label456;
          }
          str1 = localJSONObject.optString("appId");
          paramDittoArea = localJSONObject.optString("refer");
          if (this.dittoInfo == null) {
            break label1027;
          }
          if (!"jump_app_store".equals(str1)) {
            break;
          }
          if (this.activityWeakReference == null) {
            break label1027;
          }
          MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), this.dittoInfo.jumpMoreInfo, Integer.valueOf(paramDittoArea).intValue());
          return;
          paramString = paramString.optString("itemId");
          break label1024;
          paramString = paramString.optString("itemId");
        }
        paramString = paramMotionEvent;
        if (this.dittoInfo.appInfoMap != null) {
          paramString = (MiniAppInfo)this.dittoInfo.appInfoMap.get(str1);
        }
        if ((paramString != null) && (this.activityWeakReference != null)) {
          MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), paramString, Integer.valueOf(paramDittoArea).intValue());
        }
        paramString = localJSONObject.optString("report");
        if ((!TextUtils.isEmpty(paramString)) && ("no".equals(paramString))) {
          break label1027;
        }
        MiniProgramLpReportDC04239.reportAsync("desktop", localJSONObject.optString("subAction"), localJSONObject.optString("reservesAction"), localJSONObject.optString("reserves2"));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("DesktopDittoAreaView", 1, "handleUri, exception: " + Log.getStackTraceString(paramString));
        return;
      }
      if (localJSONObject.has("scheme"))
      {
        paramString = localJSONObject.optString("scheme");
        paramDittoArea = localJSONObject.optString("refer");
        i = 3011;
        try
        {
          j = Integer.valueOf(paramDittoArea).intValue();
          i = j;
        }
        catch (NumberFormatException paramDittoArea)
        {
          for (;;)
          {
            QLog.e("DesktopDittoAreaView", 1, "handleUri, get scene failed: NumberFormatException: " + Log.getStackTraceString(paramDittoArea));
            continue;
            if ((paramString.startsWith("http")) || (paramString.startsWith("https")))
            {
              paramDittoArea = new Intent((Context)this.activityWeakReference.get(), QQBrowserActivity.class);
              paramDittoArea.putExtra("url", paramString);
              paramDittoArea.putExtra("webStyle", "noBottomBar");
              paramDittoArea.putExtra("startOpenPageTime", System.currentTimeMillis());
              ((Activity)this.activityWeakReference.get()).startActivity(paramDittoArea);
            }
            else if (paramString.startsWith("mqqapi"))
            {
              paramDittoArea = new Intent((Context)this.activityWeakReference.get(), JumpActivity.class);
              paramDittoArea.setData(Uri.parse(paramString));
              ((Activity)this.activityWeakReference.get()).startActivity(paramDittoArea);
              continue;
              QLog.e("DesktopDittoAreaView", 1, "object.has(scheme), activityWeakReference.get() is null ?!");
            }
          }
        }
        if (this.activityWeakReference.get() != null) {
          if (MiniAppLauncher.isMiniAppUrl(paramString))
          {
            MiniAppLauncher.startMiniApp((Context)this.activityWeakReference.get(), paramString, i, null);
            MiniProgramLpReportDC04239.reportAsync(localJSONObject.optString("actionType"), localJSONObject.optString("subAction"), localJSONObject.optString("reservesAction"), null);
            return;
          }
        }
      }
      if (!localJSONObject.has("quickMatch")) {
        break label1027;
      }
      paramString = localJSONObject.optString("refer");
      j = this.dittoInfo.appInfoMap.size();
      if (j <= 0) {
        break label1028;
      }
    }
    label1024:
    label1027:
    label1028:
    for (int i = j;; i = 1)
    {
      i = this.dittoInfo.currentIndex % i;
      paramDittoArea = (MiniAppInfo)new ArrayList(this.dittoInfo.appInfoMap.values()).get(i);
      if (paramDittoArea != null)
      {
        QLog.d("DesktopDittoAreaView", 1, "handleUri, name: " + paramDittoArea.name + ", appId: " + paramDittoArea.appId + ", index: " + i + ", currentIndex: " + this.dittoInfo.currentIndex + ", size: " + j);
        MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), paramDittoArea, Integer.valueOf(paramString).intValue());
      }
      for (;;)
      {
        this.dittoInfo.incrementIndex();
        return;
        QLog.e("DesktopDittoAreaView", 1, "handleUri, index = " + i + ", currentIndex: " + this.dittoInfo.currentIndex + ", size: " + j + ", appInfo is null.");
      }
      QLog.e("DesktopDittoAreaView", 1, "handleUri, uri is null.");
      return;
      break;
      return;
    }
  }
  
  public void setDittoData(DesktopDittoInfo paramDesktopDittoInfo)
  {
    this.dittoInfo = paramDesktopDittoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView
 * JD-Core Version:    0.7.0.1
 */