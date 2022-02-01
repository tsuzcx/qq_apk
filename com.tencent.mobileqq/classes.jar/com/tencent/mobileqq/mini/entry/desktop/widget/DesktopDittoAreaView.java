package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDittoInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
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
    Object localObject = this.dittoInfo;
    if (localObject == null) {
      return 0;
    }
    int i = ((DesktopDittoInfo)localObject).appInfoMap.size();
    if (i <= 0) {
      i = 1;
    }
    int j = this.dittoInfo.currentIndex.get();
    localObject = (MiniAppInfo)new ArrayList(this.dittoInfo.appInfoMap.values()).get(j % i);
    if ((localObject != null) && (((MiniAppInfo)localObject).tianshuAdId > 0)) {
      return ((MiniAppInfo)localObject).tianshuAdId;
    }
    return 0;
  }
  
  public void handleExposureReport()
  {
    Object localObject3 = "position";
    if (this.exposureReportingAreas.size() <= 0) {
      return;
    }
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      return;
    }
    MiniAppExposureManager localMiniAppExposureManager = (MiniAppExposureManager)((AppInterface)localObject1).getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
    Iterator localIterator = this.exposureReportingAreas.iterator();
    String str1 = "";
    localObject1 = "";
    Object localObject6;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject6 = ((DittoArea)localIterator.next()).getLayoutAttr().getAttr("extendString", str1);
    } while (TextUtils.isEmpty((CharSequence)localObject6));
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject6);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("handleExposureReport: data");
        ((StringBuilder)localObject6).append(localJSONObject.toString());
        QLog.e("DesktopDittoAreaView", 1, ((StringBuilder)localObject6).toString());
        localObject6 = localJSONObject.optString("refer");
        try
        {
          localObject10 = localJSONObject.optString("actionType");
          String str2 = localJSONObject.optString("subAction");
          String str3 = localJSONObject.optString("reservesAction");
          localObject11 = localJSONObject.optJSONArray("report");
          localObject9 = "appId";
          if (localObject11 != null) {}
          String str4;
          int j;
          MiniAppConfig localMiniAppConfig;
          MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData;
          StringBuilder localStringBuilder;
          Object localObject12;
          boolean bool;
          localObject8 = localException5;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              i = ((JSONArray)localObject11).length();
              if (i > 0)
              {
                i = 0;
                localObject1 = localObject6;
              }
            }
            catch (Exception localException4)
            {
              Object localObject10;
              Object localObject11;
              Object localObject9;
              int i;
              Object localObject8;
              Object localObject4;
              Object localObject7;
              Object localObject2;
              Exception localException3;
              Object localObject5;
              continue;
            }
            try
            {
              if (i >= ((JSONArray)localObject11).length()) {
                continue;
              }
              localObject8 = ((JSONArray)localObject11).optJSONObject(i);
              localObject6 = ((JSONObject)localObject8).optString((String)localObject9);
              str4 = ((JSONObject)localObject8).optString("reserves2");
              if (this.dittoInfo == null) {
                continue;
              }
              localObject8 = (MiniAppInfo)this.dittoInfo.appInfoMap.get(localObject6);
              localObject6 = localObject8;
              if (localObject8 == null)
              {
                localObject6 = localObject8;
                if (localJSONObject.has((String)localObject3))
                {
                  j = localJSONObject.getInt((String)localObject3);
                  localObject6 = (MiniAppInfo)this.dittoInfo.appInfoList.get(j);
                }
              }
              if (localObject6 == null) {
                continue;
              }
              localMiniAppConfig = new MiniAppConfig((MiniAppInfo)localObject6);
              localObject6 = localMiniAppConfig.launchParam;
              localObject8 = Integer.valueOf((String)localObject1);
              localObject10 = localObject3;
            }
            catch (Exception localException8)
            {
              localObject8 = localObject5;
              localObject5 = localException8;
              continue;
            }
            try
            {
              ((LaunchParam)localObject6).scene = ((Integer)localObject8).intValue();
              localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(localMiniAppConfig, "page_view", "expo");
              localStringBuilder = new StringBuilder();
              localObject12 = localObject1;
              localObject8 = localObject10;
              localObject6 = localObject12;
              try
              {
                localStringBuilder.append(localMiniAppConfig.config.appId);
                localObject8 = localObject10;
                localObject6 = localObject12;
                localStringBuilder.append("_");
                localObject8 = localObject10;
                localObject6 = localObject12;
                localStringBuilder.append(localMiniAppConfig.config.verType);
                localObject8 = localObject10;
                localObject6 = localObject12;
                localStringBuilder.append("_");
                localObject8 = localObject10;
                localObject6 = localObject12;
                localStringBuilder.append(this.dittoInfo.getModuleType());
                localObject8 = localObject10;
                localObject6 = localObject12;
                localMiniAppExposureManager.putReportDataToMap(localStringBuilder.toString(), localMiniAppModuleExposureData);
                localObject8 = localObject3;
                localObject6 = localObject1;
                if (TextUtils.isEmpty(str2)) {
                  continue;
                }
                localObject8 = localObject3;
                localObject6 = localObject1;
                localMiniAppExposureManager.putReportDataToMap(str2, new MiniAppExposureManager.CardModuleExposureData("desktop", str2, str3, str4));
              }
              catch (Exception localException5)
              {
                continue;
              }
              localObject1 = localObject3;
              localObject11 = "appId";
              localObject3 = localObject6;
              localObject8 = localObject1;
              localObject6 = localObject3;
              localObject12 = localJSONObject.optString("reserves2");
              localObject8 = localObject1;
              localObject6 = localObject3;
              localObject9 = localJSONObject.optString("reserves3");
              localObject8 = localObject1;
              localObject6 = localObject3;
              str4 = localJSONObject.optString("reserves4");
              localObject8 = localObject1;
              localObject6 = localObject3;
              if (StringUtil.a((String)localObject10))
              {
                localObject8 = localObject1;
                localObject6 = localObject3;
                localObject9 = new MiniAppExposureManager.CardModuleExposureData("desktop", str2, str3, (String)localObject12, (String)localObject9, str4);
              }
              else
              {
                localObject8 = localObject1;
                localObject6 = localObject3;
                localObject9 = new MiniAppExposureManager.CardModuleExposureData((String)localObject10, str2, str3, (String)localObject12, (String)localObject9, str4);
              }
              localObject10 = str2;
              localObject8 = localObject1;
              localObject6 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject12))
              {
                localObject8 = localObject1;
                localObject6 = localObject3;
                localObject10 = new StringBuilder();
                localObject8 = localObject1;
                localObject6 = localObject3;
                ((StringBuilder)localObject10).append(str2);
                localObject8 = localObject1;
                localObject6 = localObject3;
                ((StringBuilder)localObject10).append("_");
                localObject8 = localObject1;
                localObject6 = localObject3;
                ((StringBuilder)localObject10).append((String)localObject12);
                localObject8 = localObject1;
                localObject6 = localObject3;
                localObject10 = ((StringBuilder)localObject10).toString();
              }
              localObject8 = localObject1;
              localObject6 = localObject3;
              localMiniAppExposureManager.putReportDataToMap((String)localObject10, (MiniAppExposureManager.BaseExposureReport)localObject9);
              localObject8 = localObject1;
              localObject6 = localObject3;
              localObject9 = localObject1;
              localObject10 = localObject3;
              if (!localJSONObject.has("dubheReportData")) {
                continue;
              }
              localObject8 = localObject1;
              localObject6 = localObject3;
              localObject9 = localJSONObject.optJSONObject("dubheReportData");
              localObject8 = localObject1;
              localObject6 = localObject3;
              localObject10 = ((JSONObject)localObject9).optString((String)localObject11);
              localObject8 = localObject1;
              localObject6 = localObject3;
              localObject11 = ((JSONObject)localObject9).optString("pageId");
              localObject8 = localObject1;
              localObject6 = localObject3;
              bool = ((JSONObject)localObject9).has("useMiniAppInfoTianShuId");
              if (bool)
              {
                localObject8 = localObject1;
                localObject6 = localObject3;
                i = getTianShuAdId();
                if (i != 0)
                {
                  localObject8 = localObject1;
                  localObject6 = localObject3;
                  localObject9 = String.valueOf(i);
                }
                else
                {
                  localObject8 = localObject1;
                  localObject6 = localObject3;
                  localObject9 = ((JSONObject)localObject9).optString("itemId");
                }
              }
              else
              {
                localObject8 = localObject1;
                localObject6 = localObject3;
                localObject9 = ((JSONObject)localObject9).optString("itemId");
              }
              localObject8 = localObject1;
              localObject6 = localObject3;
              localMiniAppExposureManager.putReportDataToMap((String)localObject9, new MiniAppExposureManager.TianShuExposureData((String)localObject10, (String)localObject11, (String)localObject9, 101));
              localObject9 = localObject1;
              localObject10 = localObject3;
            }
            catch (Exception localException6)
            {
              localObject8 = localObject10;
            }
          }
          localException1 = localException1;
        }
        localObject4 = localException1;
      }
      catch (Exception localException7)
      {
        localObject8 = localObject4;
        localObject4 = localException7;
      }
      localObject7 = localException1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleExposureReport exception: ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString((Throwable)localObject4));
      QLog.e("DesktopDittoAreaView", 1, ((StringBuilder)localObject2).toString());
      localObject10 = localObject7;
      localObject9 = localObject8;
      localObject2 = localObject10;
      localObject4 = localObject9;
      break;
      localObject4 = this.dittoInfo;
      if ((localObject4 != null) && (((DesktopDittoInfo)localObject4).jumpMoreInfo != null) && (!TextUtils.isEmpty(this.dittoInfo.jumpMoreInfo.appId)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        try
        {
          localObject4 = new MiniAppConfig(this.dittoInfo.jumpMoreInfo);
          ((MiniAppConfig)localObject4).launchParam.scene = Integer.valueOf((String)localObject2).intValue();
          localObject2 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject4, "page_view", "expo");
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(((MiniAppConfig)localObject4).config.appId);
          ((StringBuilder)localObject7).append("_");
          ((StringBuilder)localObject7).append(((MiniAppConfig)localObject4).config.verType);
          ((StringBuilder)localObject7).append("_");
          ((StringBuilder)localObject7).append(this.dittoInfo.getModuleType());
          localMiniAppExposureManager.putReportDataToMap(((StringBuilder)localObject7).toString(), (MiniAppExposureManager.BaseExposureReport)localObject2);
          return;
        }
        catch (Exception localException2)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleExposureReport, app store, exception: ");
          ((StringBuilder)localObject4).append(Log.getStackTraceString(localException2));
          QLog.e("DesktopDittoAreaView", 1, ((StringBuilder)localObject4).toString());
        }
      }
      return;
      continue;
      i += 1;
      continue;
      localObject7 = localException2;
      localObject11 = localObject9;
      localException3 = localException6;
      localObject5 = localObject7;
    }
  }
  
  public void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramMotionEvent = new JSONObject(paramString);
        boolean bool = paramMotionEvent.has("dubheReportData");
        Object localObject4;
        if (bool)
        {
          paramString = paramMotionEvent.optJSONObject("dubheReportData");
          localObject1 = paramString.optString("appId");
          localObject2 = paramString.optString("pageId");
          bool = paramString.has("useMiniAppInfoTianShuId");
          if (bool)
          {
            i = getTianShuAdId();
            if (i != 0) {
              paramString = String.valueOf(i);
            } else {
              paramString = paramString.optString("itemId");
            }
          }
          else
          {
            paramString = paramString.optString("itemId");
          }
          localObject3 = new TianShuReportData();
          localObject4 = BaseApplicationImpl.getApplication().getRuntime();
          paramDittoArea = "";
          if (localObject4 != null) {
            paramDittoArea = ((AppRuntime)localObject4).getAccount();
          }
          long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramDittoArea);
          ((StringBuilder)localObject4).append("_");
          ((StringBuilder)localObject4).append(l);
          ((TianShuReportData)localObject3).b = ((StringBuilder)localObject4).toString();
          ((TianShuReportData)localObject3).jdField_a_of_type_Int = 1;
          ((TianShuReportData)localObject3).jdField_e_of_type_JavaLangString = ((String)localObject1);
          ((TianShuReportData)localObject3).f = ((String)localObject2);
          ((TianShuReportData)localObject3).g = paramString;
          ((TianShuReportData)localObject3).d = 102;
          ((TianShuReportData)localObject3).jdField_e_of_type_Int = 1;
          ((TianShuReportData)localObject3).jdField_a_of_type_Long = l;
          TianShuManager.getInstance().report((TianShuReportData)localObject3);
        }
        bool = paramMotionEvent.has("appId");
        paramString = null;
        if (bool)
        {
          paramDittoArea = paramMotionEvent.optString("appId");
          localObject1 = paramMotionEvent.optString("refer");
          if (this.dittoInfo == null) {
            break label1387;
          }
          localObject2 = paramMotionEvent.optString("report");
          if ("jump_app_store".equals(paramDittoArea))
          {
            if (this.activityWeakReference != null)
            {
              MiniAppDesktopAdapter.startMiniApp((Activity)this.activityWeakReference.get(), this.dittoInfo.jumpMoreInfo, Integer.valueOf((String)localObject1).intValue());
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label1388;
              }
              if ("yes".equals(localObject2)) {}
            }
          }
          else
          {
            if (this.dittoInfo.appInfoMap != null) {
              paramString = (MiniAppInfo)this.dittoInfo.appInfoMap.get(paramDittoArea);
            }
            paramDittoArea = paramString;
            if (paramString == null)
            {
              paramDittoArea = paramString;
              if (paramMotionEvent.has("position"))
              {
                i = paramMotionEvent.getInt("position");
                paramDittoArea = (MiniAppInfo)this.dittoInfo.appInfoList.get(i);
              }
            }
            if ((paramDittoArea != null) && (this.activityWeakReference != null)) {
              MiniAppDesktopAdapter.startMiniApp((Activity)this.activityWeakReference.get(), paramDittoArea, Integer.valueOf((String)localObject1).intValue());
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ("no".equals(localObject2))) {
              return;
            }
          }
          MiniProgramLpReportDC04239.reportAsync("desktop", paramMotionEvent.optString("subAction"), paramMotionEvent.optString("reservesAction"), paramMotionEvent.optString("reserves2"), paramMotionEvent.optString("reserves3"), paramMotionEvent.optString("reserves4"));
          return;
        }
        bool = paramMotionEvent.has("scheme");
        int j;
        if (bool)
        {
          paramString = paramMotionEvent.optString("scheme");
          paramDittoArea = paramMotionEvent.optString("refer");
          i = 3011;
          try
          {
            j = Integer.valueOf(paramDittoArea).intValue();
            i = j;
          }
          catch (NumberFormatException paramDittoArea)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleUri, get scene failed: NumberFormatException: ");
            ((StringBuilder)localObject1).append(Log.getStackTraceString(paramDittoArea));
            QLog.e("DesktopDittoAreaView", 1, ((StringBuilder)localObject1).toString());
          }
          if (this.activityWeakReference.get() != null)
          {
            if (MiniAppLauncher.isMiniAppUrl(paramString))
            {
              MiniAppLauncher.startMiniApp((Context)this.activityWeakReference.get(), paramString, i, null);
            }
            else if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
            {
              if (paramString.startsWith("mqqapi"))
              {
                paramDittoArea = new Intent((Context)this.activityWeakReference.get(), JumpActivity.class);
                paramDittoArea.setData(Uri.parse(paramString));
                ((Activity)this.activityWeakReference.get()).startActivity(paramDittoArea);
              }
            }
            else
            {
              paramDittoArea = new Intent((Context)this.activityWeakReference.get(), QQBrowserActivity.class);
              paramDittoArea.putExtra("url", paramString);
              paramDittoArea.putExtra("webStyle", "noBottomBar");
              paramDittoArea.putExtra("startOpenPageTime", System.currentTimeMillis());
              ((Activity)this.activityWeakReference.get()).startActivity(paramDittoArea);
            }
          }
          else {
            QLog.e("DesktopDittoAreaView", 1, "object.has(scheme), activityWeakReference.get() is null ?!");
          }
          MiniProgramLpReportDC04239.reportAsync(paramMotionEvent.optString("actionType"), paramMotionEvent.optString("subAction"), paramMotionEvent.optString("reservesAction"), null);
          return;
        }
        if (paramMotionEvent.has("quickMatch"))
        {
          paramString = paramMotionEvent.optString("refer");
          j = this.dittoInfo.appInfoMap.size();
          if (j <= 0) {
            break label1389;
          }
          i = j;
          i = this.dittoInfo.currentIndex.get() % i;
          paramDittoArea = (MiniAppInfo)new ArrayList(this.dittoInfo.appInfoMap.values()).get(i);
          if (paramDittoArea != null)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("handleUri, name: ");
            paramMotionEvent.append(paramDittoArea.name);
            paramMotionEvent.append(", appId: ");
            paramMotionEvent.append(paramDittoArea.appId);
            paramMotionEvent.append(", index: ");
            paramMotionEvent.append(i);
            paramMotionEvent.append(", currentIndex: ");
            paramMotionEvent.append(this.dittoInfo.currentIndex);
            paramMotionEvent.append(", size: ");
            paramMotionEvent.append(j);
            QLog.d("DesktopDittoAreaView", 1, paramMotionEvent.toString());
            MiniAppDesktopAdapter.startMiniApp((Activity)this.activityWeakReference.get(), paramDittoArea, Integer.valueOf(paramString).intValue());
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("handleUri, index = ");
            paramString.append(i);
            paramString.append(", currentIndex: ");
            paramString.append(this.dittoInfo.currentIndex);
            paramString.append(", size: ");
            paramString.append(j);
            paramString.append(", appInfo is null.");
            QLog.e("DesktopDittoAreaView", 1, paramString.toString());
          }
          this.dittoInfo.incrementIndex();
          return;
        }
        if (!paramMotionEvent.has("refresh")) {
          break label1387;
        }
        i = paramMotionEvent.optInt("refresh");
        paramDittoArea = (DesktopDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
        Object localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(Integer.valueOf(7));
        Object localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Integer.valueOf(i));
        paramString = new ArrayList();
        Object localObject3 = paramMotionEvent.optJSONArray("itemIds");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          j = ((JSONArray)localObject3).length();
          i = 0;
          if (i < j)
          {
            localObject4 = ((JSONArray)localObject3).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              break label1395;
            }
            paramString.add(localObject4);
            break label1395;
          }
        }
        paramDittoArea.sendModuleRequest((ArrayList)localObject1, (ArrayList)localObject2, paramString);
        MiniProgramLpReportDC04239.reportAsync(paramMotionEvent.optString("actionType"), paramMotionEvent.optString("subAction"), paramMotionEvent.optString("reservesAction"), null);
        paramDittoArea = new StringBuilder();
        paramDittoArea.append("refresh, itemIds: ");
        paramDittoArea.append(paramString.toString());
        QLog.d("DesktopDittoAreaView", 1, paramDittoArea.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramDittoArea = new StringBuilder();
        paramDittoArea.append("handleUri, exception: ");
        paramDittoArea.append(Log.getStackTraceString(paramString));
        QLog.e("DesktopDittoAreaView", 1, paramDittoArea.toString());
        return;
      }
      QLog.e("DesktopDittoAreaView", 1, "handleUri, uri is null.");
      label1387:
      return;
      label1388:
      return;
      label1389:
      int i = 1;
      continue;
      label1395:
      i += 1;
    }
  }
  
  public void setDittoData(DesktopDittoInfo paramDesktopDittoInfo)
  {
    this.dittoInfo = paramDesktopDittoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoAreaView
 * JD-Core Version:    0.7.0.1
 */