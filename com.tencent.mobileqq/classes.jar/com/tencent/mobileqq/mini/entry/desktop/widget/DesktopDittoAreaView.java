package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import baip;
import bgqw;
import bgqx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
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
    String str1 = "";
    label51:
    Object localObject4;
    Object localObject6;
    String str2;
    String str3;
    Object localObject5;
    int i;
    label223:
    Object localObject7;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject4 = ((DittoArea)localIterator.next()).getLayoutAttr().getAttr("extendString", "");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = str1;
          try
          {
            localObject4 = new JSONObject((String)localObject4);
            localObject1 = str1;
            QLog.e("DesktopDittoAreaView", 1, "handleExposureReport: data" + ((JSONObject)localObject4).toString());
            localObject1 = str1;
            str1 = ((JSONObject)localObject4).optString("refer");
            localObject1 = str1;
            localObject6 = ((JSONObject)localObject4).optString("actionType");
            localObject1 = str1;
            str2 = ((JSONObject)localObject4).optString("subAction");
            localObject1 = str1;
            str3 = ((JSONObject)localObject4).optString("reservesAction");
            localObject1 = str1;
            localObject5 = ((JSONObject)localObject4).getJSONArray("report");
            if (localObject5 != null)
            {
              localObject1 = str1;
              if (((JSONArray)localObject5).length() > 0)
              {
                i = 0;
                localObject1 = str1;
                if (i >= ((JSONArray)localObject5).length()) {
                  break label600;
                }
                localObject1 = str1;
                localObject6 = ((JSONArray)localObject5).optJSONObject(i);
                localObject1 = str1;
                localObject7 = ((JSONObject)localObject6).optString("appId");
                localObject1 = str1;
                localObject6 = ((JSONObject)localObject6).optString("reserves2");
                localObject1 = str1;
                MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData;
                if (this.dittoInfo != null)
                {
                  localObject1 = str1;
                  localObject7 = (MiniAppInfo)this.dittoInfo.appInfoMap.get(localObject7);
                  if (localObject7 != null)
                  {
                    localObject1 = str1;
                    localObject7 = new MiniAppConfig((MiniAppInfo)localObject7);
                    localObject1 = str1;
                    ((MiniAppConfig)localObject7).launchParam.scene = Integer.valueOf(str1).intValue();
                    localObject1 = str1;
                    localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject7, "page_view", "expo");
                    localObject1 = str1;
                    if (localMiniAppExposureManager.getDesktopPullDownState() != 3) {
                      break label439;
                    }
                    localObject1 = str1;
                    localMiniAppExposureManager.addReportItem(localMiniAppModuleExposureData);
                  }
                }
                for (;;)
                {
                  localObject1 = str1;
                  localObject6 = new MiniAppExposureManager.CardModuleExposureData("desktop", str2, str3, (String)localObject6);
                  localObject1 = str1;
                  if (localMiniAppExposureManager.getDesktopPullDownState() != 3) {
                    break;
                  }
                  localObject1 = str1;
                  localMiniAppExposureManager.addReportItem((MiniAppExposureManager.BaseExposureReport)localObject6);
                  break label1045;
                  label439:
                  localObject1 = str1;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localObject1 = str1;
                  localStringBuilder.append(((MiniAppConfig)localObject7).config.appId).append("_").append(((MiniAppConfig)localObject7).config.verType).append("_").append(this.dittoInfo.getModuleType());
                  localObject1 = str1;
                  localMiniAppExposureManager.putReportDataToMap(localStringBuilder.toString(), localMiniAppModuleExposureData);
                }
                localObject3 = localObject1;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e("DesktopDittoAreaView", 1, "handleExposureReport exception: " + Log.getStackTraceString(localException2));
          }
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      break label51;
      localObject1 = localObject3;
      localMiniAppExposureManager.putReportDataToMap(str2, (MiniAppExposureManager.BaseExposureReport)localObject6);
      break label1045;
      localObject1 = localObject3;
      if (baip.a((String)localObject6))
      {
        localObject1 = localObject3;
        MiniProgramLpReportDC04239.reportAsync("desktop", str2, str3, null);
      }
      for (;;)
      {
        label600:
        localObject1 = localObject3;
        if (!((JSONObject)localObject4).has("dubheReportData")) {
          break;
        }
        localObject1 = localObject3;
        localObject4 = ((JSONObject)localObject4).getJSONObject("dubheReportData");
        localObject1 = localObject3;
        str2 = ((JSONObject)localObject4).optString("appId");
        localObject1 = localObject3;
        str3 = ((JSONObject)localObject4).optString("pageId");
        localObject1 = localObject3;
        localObject5 = ((JSONObject)localObject4).optString("itemId");
        localObject1 = localObject3;
        localObject6 = new bgqx();
        localObject1 = localObject3;
        localObject7 = BaseApplicationImpl.getApplication().getRuntime();
        localObject4 = "";
        if (localObject7 != null)
        {
          localObject1 = localObject3;
          localObject4 = ((AppRuntime)localObject7).getAccount();
        }
        localObject1 = localObject3;
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        localObject1 = localObject3;
        ((bgqx)localObject6).b = ((String)localObject4 + "_" + l);
        localObject1 = localObject3;
        ((bgqx)localObject6).jdField_a_of_type_Int = 1;
        localObject1 = localObject3;
        ((bgqx)localObject6).e = str2;
        localObject1 = localObject3;
        ((bgqx)localObject6).f = str3;
        localObject1 = localObject3;
        ((bgqx)localObject6).g = ((String)localObject5);
        localObject1 = localObject3;
        ((bgqx)localObject6).h = "";
        localObject1 = localObject3;
        ((bgqx)localObject6).jdField_a_of_type_Long = l;
        localObject1 = localObject3;
        bgqw.a().a((bgqx)localObject6);
        break;
        localObject1 = localObject3;
        MiniProgramLpReportDC04239.reportAsync((String)localObject6, str2, str3, null);
      }
      if ((this.dittoInfo == null) || (this.dittoInfo.jumpMoreInfo == null) || (TextUtils.isEmpty((CharSequence)localObject3))) {
        break;
      }
      try
      {
        localObject1 = new MiniAppConfig(this.dittoInfo.jumpMoreInfo);
        ((MiniAppConfig)localObject1).launchParam.scene = Integer.valueOf((String)localObject3).intValue();
        localObject3 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject1, "page_view", "expo");
        if (localMiniAppExposureManager.getDesktopPullDownState() == 3)
        {
          localMiniAppExposureManager.addReportItem((MiniAppExposureManager.BaseExposureReport)localObject3);
          return;
        }
      }
      catch (Exception localException1)
      {
        QLog.e("DesktopDittoAreaView", 1, "handleExposureReport, app store, exception: " + Log.getStackTraceString(localException1));
        return;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(localException1.config.appId).append("_").append(localException1.config.verType).append("_").append(this.dittoInfo.getModuleType());
      localMiniAppExposureManager.putReportDataToMap(((StringBuilder)localObject4).toString(), (MiniAppExposureManager.BaseExposureReport)localObject3);
      return;
      label1045:
      i += 1;
      break label223;
      Object localObject2 = localObject3;
    }
  }
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("appId"))
        {
          paramMotionEvent = paramString.optString("appId");
          paramDittoArea = paramString.optString("refer");
          if (this.dittoInfo == null) {
            return;
          }
          if ("jump_app_store".equals(paramMotionEvent))
          {
            if (this.activityWeakReference == null) {
              return;
            }
            MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), this.dittoInfo.jumpMoreInfo, Integer.valueOf(paramDittoArea).intValue());
            return;
          }
          paramMotionEvent = (MiniAppInfo)this.dittoInfo.appInfoMap.get(paramMotionEvent);
          if ((paramMotionEvent != null) && (this.activityWeakReference != null)) {
            MiniAppController.launchMiniAppByAppInfo((Activity)this.activityWeakReference.get(), paramMotionEvent, Integer.valueOf(paramDittoArea).intValue());
          }
          MiniProgramLpReportDC04239.reportAsync("desktop", paramString.optString("subAction"), paramString.optString("reservesAction"), paramString.optString("reserves2"));
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("DesktopDittoAreaView", 1, "handleUri, exception: " + Log.getStackTraceString(paramString));
        return;
      }
      if (!paramString.has("scheme")) {
        return;
      }
      paramDittoArea = paramString.optString("scheme");
      paramMotionEvent = paramString.optString("refer");
      int i = 3011;
      try
      {
        int j = Integer.valueOf(paramMotionEvent).intValue();
        i = j;
      }
      catch (NumberFormatException paramMotionEvent)
      {
        for (;;)
        {
          QLog.e("DesktopDittoAreaView", 1, "handleUri, get scene failed: NumberFormatException: " + Log.getStackTraceString(paramMotionEvent));
        }
      }
      MiniAppLauncher.startMiniApp((Context)this.activityWeakReference.get(), paramDittoArea, i, null);
      MiniProgramLpReportDC04239.reportAsync(paramString.optString("actionType"), paramString.optString("subAction"), paramString.optString("reservesAction"), null);
      return;
    }
    QLog.e("DesktopDittoAreaView", 1, "handleUri, uri is null.");
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