package com.tencent.mobileqq.webview.swift.component;

import akxp;
import akxq;
import akxr;
import akxs;
import akxt;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SwiftBrowserStatistics
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public static long A;
  public static long B;
  public static long C;
  public static long D;
  public static long E;
  public static long F;
  public static int d;
  public static volatile boolean n;
  public static volatile boolean o;
  public static volatile boolean p;
  public static long z;
  public long G;
  public long H;
  public long I;
  public long J;
  public int a;
  public long a;
  Activity a;
  public SwiftBrowserStatistics.CrashStepStatsEntry a;
  public Runnable a;
  public String a;
  public List a;
  public JSONObject a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public long k;
  public boolean k;
  public long l;
  boolean l;
  public long m;
  public boolean m;
  public long n = -1L;
  public long o;
  public long p;
  public long q = -1L;
  public boolean q;
  public long r;
  public boolean r;
  public long s;
  public boolean s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  
  static
  {
    jdField_d_of_type_Int = 10;
  }
  
  public SwiftBrowserStatistics()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry = new SwiftBrowserStatistics.CrashStepStatsEntry();
  }
  
  private void c()
  {
    if (!PushReportController.jdField_a_of_type_Boolean)
    {
      PushReportController.PushReportItem localPushReportItem = new PushReportController.PushReportItem();
      localPushReportItem.e = "0X8009242";
      localPushReportItem.d = "离开点击Push";
      PushReportController.a(this.jdField_b_of_type_JavaLangString, localPushReportItem);
      PushReportController.a(null, localPushReportItem);
      PushReportController.jdField_a_of_type_Boolean = true;
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface == null) || (paramAppInterface.getApplication() == null)) {}
    for (;;)
    {
      return null;
      Object localObject = paramAppInterface.getApplication().getFilesDir();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      paramAppInterface = new File((File)localObject, "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface);
      if (!paramAppInterface.exists()) {}
      try
      {
        paramAppInterface.createNewFile();
        paramAppInterface = FileUtils.a(paramAppInterface);
        if (paramAppInterface != null) {
          localObject = new BusinessInfoCheckUpdate.TimeRspBody();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom(paramAppInterface);
            return localObject;
          }
          catch (Exception paramAppInterface)
          {
            paramAppInterface.printStackTrace();
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public String a(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (!paramBoolean) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAppRuntime instanceof AppInterface)) {}
    for (paramAppRuntime = (AppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (paramAppRuntime == null) {
        return "";
      }
      String str = paramAppRuntime.getApp().getSharedPreferences("redTouchPref", 4).getString("lastClickPath", "");
      if (!"".equals(str))
      {
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null) {
          break label209;
        }
        paramAppRuntime = paramAppRuntime.rptMsgAppInfo.get();
        if (paramAppRuntime == null) {
          break label209;
        }
        Iterator localIterator = paramAppRuntime.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramAppRuntime = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        } while (!paramAppRuntime.path.get().equals(str));
      }
      for (;;)
      {
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.missions.get();
          if (paramAppRuntime != null)
          {
            int i1 = 0;
            while (i1 < paramAppRuntime.size())
            {
              localStringBuilder.append((String)paramAppRuntime.get(i1));
              if (i1 != paramAppRuntime.size() - 1) {
                localStringBuilder.append("_");
              }
              i1 += 1;
            }
          }
        }
        return localStringBuilder.toString();
        label209:
        paramAppRuntime = null;
      }
    }
  }
  
  public void a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + localAppRuntime.getLongAccountUin(), 4);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_d_of_type_Long;
      ReportController.b(null, "dc00899", "grp_lbs", "", this.jdField_a_of_type_JavaLangString, "visit_time", 0, 1, 0, "" + localSharedPreferences.getInt("charm_level", 0), "" + localSharedPreferences.getInt("gender", 0), "" + (l1 - l2), "");
    }
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_g_of_type_Boolean) && (!PushReportController.jdField_a_of_type_Boolean)) {
      ThreadManager.getFileThreadHandler().postDelayed(new akxq(this, localAppRuntime), 1000L);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      label73:
      long l1;
      long l2;
      int i1;
      if (this.jdField_h_of_type_Long > 0L)
      {
        paramInt = (int)((this.jdField_f_of_type_Long - this.jdField_h_of_type_Long) / 1000000L);
        if (this.jdField_e_of_type_Boolean)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_create", 0, 1, paramInt, HttpUtil.a() + "", "", "", "" + this.jdField_c_of_type_Int);
          paramBundle = HttpUtil.a() + "";
          l1 = System.currentTimeMillis();
          l2 = this.jdField_i_of_type_Long;
          if (!WebProcessManager.b()) {
            break label348;
          }
          i1 = 1;
          label189:
          if (!this.jdField_s_of_type_Boolean) {
            break label353;
          }
        }
      }
      label348:
      label353:
      for (int i2 = 1;; i2 = 0)
      {
        ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, paramBundle, String.valueOf(l1 - l2), String.valueOf(i1), String.valueOf(i2));
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("web_report", 4, "web_before_create, cost = " + paramInt + ", url = " + Util.b(this.jdField_b_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean + ", isProgressCreate = " + o + ", flag=" + this.jdField_c_of_type_Int);
        return;
        paramInt = 0;
        break label73;
        i1 = 0;
        break label189;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
      a();
      return;
      if ((paramBundle != null) && (paramBundle.containsKey("url")))
      {
        b(paramBundle.getString("url"));
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("url")))
        {
          a(paramBundle.getString("url"));
          return;
          if ((paramBundle != null) && (paramBundle.containsKey("url"))) {}
          for (paramBundle = paramBundle.getString("url"); !TextUtils.isEmpty(paramBundle); paramBundle = "")
          {
            a((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), paramBundle);
            return;
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, SwiftBrowserStatistics.CrashStepStatsEntry paramCrashStepStatsEntry)
  {
    paramContext = new File(paramContext.getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = FileUtils.a(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i1 = paramContext.getInt("sample_rate");
        SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i1));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int i2 = localJSONArray.length();
        i1 = 0;
        while (i1 < i2)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i1 += 1;
        }
        paramCrashStepStatsEntry.jdField_c_of_type_Int = paramContext.getInt("tail_number");
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQBrowser", 2, "" + paramContext);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("WebView_Report_Step", 0);
    }
    String str3 = "UNKNOWN";
    try
    {
      int i1 = NetworkUtil.a(paramContext);
      str1 = str3;
      if (i1 != -1)
      {
        str1 = str3;
        if (i1 < AppConstants.c.length) {
          str1 = AppConstants.c[i1];
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2 = "UNKNOWN";
      }
    }
    ThreadManager.post(new akxs(this, paramString, paramContext, System.currentTimeMillis(), str1), 5, null, false);
  }
  
  public void a(Intent paramIntent)
  {
    int i3 = 1;
    this.jdField_f_of_type_Long = System.nanoTime();
    this.jdField_c_of_type_Long = paramIntent.getLongExtra("qqBrowserActivityCreateTime", -1L);
    if (this.jdField_c_of_type_Long < 0L) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    this.jdField_b_of_type_Long = paramIntent.getLongExtra("startOpenPageTime", -1L);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("op_type");
    this.l = paramIntent.getBooleanExtra("reportMsfLog", false);
    this.j = paramIntent.getBooleanExtra("fromAio", false);
    paramIntent.getBooleanExtra("fromPublicAccount", false);
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
    }
    this.jdField_h_of_type_Long = paramIntent.getLongExtra("plugin_start_time", 0L);
    this.jdField_i_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    this.m = paramIntent.getBooleanExtra("FORCE_BLANK_SCREEN_REPORTE", false);
    if (this.jdField_h_of_type_Long > 0L) {
      paramIntent.putExtra("plugin_start_time", 0L);
    }
    if (this.jdField_i_of_type_Long > 0L) {
      paramIntent.putExtra("click_start_time", 0L);
    }
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("is_from_leba", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    boolean bool;
    int i1;
    label338:
    int i2;
    if (paramIntent.getIntExtra("uintype", -1) == 1030)
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (this.jdField_c_of_type_Boolean) {
        PushReportController.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.jdField_f_of_type_Long);
      }
      if (WebAccelerateHelper.isWebViewCache)
      {
        this.jdField_s_of_type_Boolean = true;
        QLog.d("SwiftBrowserStatistics", 1, "onCreate, isWebViewCache = true");
      }
      this.jdField_s_of_type_Long = System.currentTimeMillis();
      if (!o) {
        break label375;
      }
      i1 = 1;
      if (!this.jdField_a_of_type_Boolean) {
        break label380;
      }
      i2 = 1;
      label347:
      if (!this.jdField_b_of_type_Boolean) {
        break label385;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = ((i2 << 1) + (i1 << 2) + i3);
      return;
      bool = false;
      break;
      label375:
      i1 = 0;
      break label338;
      label380:
      i2 = 0;
      break label347;
      label385:
      i3 = 0;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramTouchWebView.a();
    if (localObject != null)
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject == null) || (!(localObject instanceof OfflinePlugin))) {}
    }
    for (localObject = (OfflinePlugin)localObject;; localObject = null)
    {
      if ((localObject != null) && (((OfflinePlugin)localObject).a() != null)) {}
      for (localObject = ((OfflinePlugin)localObject).a();; localObject = "")
      {
        int i1;
        label134:
        int i2;
        if (this.jdField_e_of_type_Boolean)
        {
          i1 = (int)((System.nanoTime() - this.jdField_g_of_type_Long) / 1000000L);
          String str = HttpUtil.a();
          if (paramString2 != null) {
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url_error", 0, 1, i1, str, paramString2, String.valueOf(paramInt), paramString1);
          }
        }
        else
        {
          if (paramTouchWebView.getX5WebViewExtension() == null) {
            break label298;
          }
          i1 = 3;
          i2 = 0;
          label137:
          if (i2 >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label318;
          }
          paramString2 = (String)this.jdField_a_of_type_JavaUtilList.get(i2);
          if (i2 != this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break label304;
          }
          paramTouchWebView = String.valueOf(paramInt);
          label188:
          if (paramString2 == null) {
            break label311;
          }
        }
        label298:
        label304:
        label311:
        for (paramString1 = paramString2;; paramString1 = "unknown")
        {
          VasWebviewUtil.reportQBWebInfo((String)localObject, "qbweb_load_redirect", "", paramString1.replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.a(), 0, 0, "", paramTouchWebView);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 2, "url=" + paramString2 + ", rlt=" + paramTouchWebView);
          }
          i2 += 1;
          break label137;
          paramString2 = "unknown";
          break;
          i1 = 1;
          break label134;
          paramTouchWebView = "10001";
          break label188;
        }
        label318:
        this.jdField_a_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    if (paramTouchWebView == null) {
      return;
    }
    Object localObject3 = "";
    Object localObject1 = paramTouchWebView.a();
    if (localObject1 != null)
    {
      localObject1 = ((WebViewPluginEngine)localObject1).a("offline");
      if ((localObject1 == null) || (!(localObject1 instanceof OfflinePlugin))) {}
    }
    for (Object localObject2 = (OfflinePlugin)localObject1;; localObject2 = null)
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (((OfflinePlugin)localObject2).a() != null) {
          localObject1 = ((OfflinePlugin)localObject2).a();
        }
      }
      int i1;
      label219:
      int i2;
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
      {
        i1 = (int)((System.nanoTime() - this.jdField_g_of_type_Long) / 1000000L);
        localObject3 = HttpUtil.a();
        if (paramString == null) {
          break label550;
        }
        localObject2 = paramString;
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url", 0, 1, i1, (String)localObject3, (String)localObject2, (String)localObject1, "" + this.jdField_c_of_type_Int);
        localObject2 = HttpUtil.a() + "";
        long l1 = (System.nanoTime() - this.jdField_g_of_type_Long) / 1000000L;
        if (!WebProcessManager.b()) {
          break label558;
        }
        i1 = 1;
        localObject3 = new StringBuilder();
        if (!this.jdField_s_of_type_Boolean) {
          break label563;
        }
        i2 = 1;
        label238:
        ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, (String)localObject2, String.valueOf(l1), String.valueOf(i1), String.valueOf(i2) + ", " + (String)localObject1);
        if (QLog.isDevelopLevel()) {
          QLog.d("web_report", 4, "web_load_url, cost = " + (System.nanoTime() - this.jdField_g_of_type_Long) / 1000000L + ", url = " + Util.b(this.jdField_b_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean + ", " + (String)localObject1);
        }
      }
      if ((this.jdField_g_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
      {
        if (paramTouchWebView.getX5WebViewExtension() != null)
        {
          i1 = 3;
          label418:
          localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
          label429:
          if (!((Iterator)localObject3).hasNext()) {
            break label581;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          if (localObject2 == null) {
            break label574;
          }
        }
        label550:
        label558:
        label563:
        label574:
        for (paramTouchWebView = (TouchWebView)localObject2;; paramTouchWebView = "unknown")
        {
          VasWebviewUtil.reportQBWebInfo((String)localObject1, "qbweb_load_redirect", "", paramTouchWebView.replace("|", "%7C"), i1, 0, "0", String.valueOf(this.jdField_c_of_type_Int), HttpUtil.a(), 0, 0, "", "10000");
          if (!QLog.isColorLevel()) {
            break label429;
          }
          QLog.d("SwiftBrowserStatistics", 2, "url=" + (String)localObject2 + ", rlt=" + "10000");
          break label429;
          localObject2 = "unknown";
          break;
          i1 = 0;
          break label219;
          i2 = 0;
          break label238;
          i1 = 1;
          break label418;
        }
        label581:
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if ((!this.jdField_f_of_type_Boolean) || (!this.j) || (this.k)) {
        break;
      }
      this.k = true;
      if (paramString != null) {}
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, Util.b(URLEncoder.encode(paramString), new String[0]), "", "", "" + this.jdField_c_of_type_Int);
        return;
        paramString = "unknown";
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String... paramVarArgs)
  {
    ThreadManager.post(new akxt(this, paramTouchWebView, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVarArgs), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if ("about:blank".equalsIgnoreCase(paramString)) {}
    while (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_g_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = System.currentTimeMillis();
    this.G = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long - this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser_report", 2, "try report web status, onPageStarted,  step: " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int + ", asyncMode: " + this.jdField_b_of_type_Int + ", stepTime: " + this.G + ", totalTime: " + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + "\n" + paramString);
    }
    int i3;
    String str2;
    String str1;
    int i1;
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_h_of_type_Boolean))
    {
      i3 = (int)((this.jdField_g_of_type_Long - this.jdField_f_of_type_Long) / 1000000L);
      str2 = HttpUtil.a();
      if (paramString == null) {
        break label484;
      }
      str1 = paramString;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_load_url", 0, 1, i3, str2, str1, "", "" + this.jdField_c_of_type_Int);
      str1 = HttpUtil.a() + "";
      str2 = "" + i3;
      if (!WebProcessManager.b()) {
        break label492;
      }
      i1 = 1;
      label296:
      if (!this.jdField_s_of_type_Boolean) {
        break label497;
      }
    }
    label484:
    label492:
    label497:
    for (int i2 = 1;; i2 = 0)
    {
      ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, str1, str2, String.valueOf(i1), String.valueOf(i2));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_load_url, cost = " + i3 + ", url = " + Util.b(this.jdField_b_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean);
      }
      if (!this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      if ((this.l) && (this.jdField_a_of_type_JavaLangRunnable == null))
      {
        this.jdField_a_of_type_JavaLangRunnable = new akxp(this);
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      return;
      str1 = "unknown";
      break;
      i1 = 0;
      break label296;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while ((!this.jdField_e_of_type_Boolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new akxr(this, paramString, paramInt), 5, null, false);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.jdField_i_of_type_Boolean) {
        ReportController.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", paramString.getQueryParameter("appid"), (int)((System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L) + "", paramString.getQueryParameter("group_openid"));
      }
    }
    int i1;
    String str;
    if (this.jdField_e_of_type_Boolean)
    {
      i1 = (int)((System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L);
      str = HttpUtil.a() + "";
      if (this.jdField_b_of_type_JavaLangString == null) {
        break label318;
      }
    }
    label318:
    for (paramString = this.jdField_b_of_type_JavaLangString;; paramString = "unknown")
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_stay_in_url", 0, 1, i1, str, URLEncoder.encode(paramString), "", "" + this.jdField_c_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_stay_in_url, cost = " + (System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L + ", url = " + Util.b(this.jdField_b_of_type_JavaLangString, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_c_of_type_Boolean) && (!this.jdField_g_of_type_Boolean)) {
        c();
      }
      return;
    }
  }
  
  public void c(String paramString)
  {
    QLog.i("SwiftBrowserStatistics", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
    this.q = System.currentTimeMillis();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics
 * JD-Core Version:    0.7.0.1
 */