package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.notification.modularize.PushUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserStatisticInjector;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SwiftBrowserStatisticInjectorImpl
  implements ISwiftBrowserStatisticInjector
{
  private int a;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public SwiftBrowserStatisticInjectorImpl()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void a(String paramString)
  {
    if (!PushReportController.jdField_a_of_type_Boolean)
    {
      PushReportController.PushReportItem localPushReportItem = new PushReportController.PushReportItem();
      localPushReportItem.e = "0X8009242";
      localPushReportItem.jdField_d_of_type_JavaLangString = "离开点击Push";
      PushReportController.a(paramString, localPushReportItem);
      PushReportController.a(null, localPushReportItem);
      PushReportController.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void b(String paramString)
  {
    if (!PushReportController.jdField_a_of_type_Boolean) {
      PushNoticeManager.a(null, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramString, "0X8009242", "离开点击Push");
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      if (paramAppInterface.getApplication() == null) {
        return null;
      }
      File localFile = paramAppInterface.getApplication().getFilesDir();
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BusinessInfoCheckUpdateItem_new_1_");
      localStringBuilder.append(paramAppInterface);
      paramAppInterface = new File(localFile, localStringBuilder.toString());
      if (!paramAppInterface.exists()) {
        try
        {
          paramAppInterface.createNewFile();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
      paramAppInterface = FileUtils.fileToBytes(paramAppInterface);
      if (paramAppInterface == null) {
        return null;
      }
      BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
      try
      {
        localTimeRspBody.mergeFrom(paramAppInterface);
        return localTimeRspBody;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
      }
    }
    return null;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAppRuntime instanceof AppInterface)) {
      paramAppRuntime = (AppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    if (paramAppRuntime == null) {
      return "";
    }
    String str = paramAppRuntime.getApp().getSharedPreferences("redTouchPref", 4).getString("lastClickPath", "");
    if (!"".equals(str))
    {
      paramAppRuntime = a(paramAppRuntime);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.rptMsgAppInfo.get();
        if (paramAppRuntime != null)
        {
          Iterator localIterator = paramAppRuntime.iterator();
          while (localIterator.hasNext())
          {
            paramAppRuntime = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
            if (paramAppRuntime.path.get().equals(str)) {
              break label134;
            }
          }
        }
      }
      paramAppRuntime = null;
      label134:
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.missions.get();
        if (paramAppRuntime != null)
        {
          int i = 0;
          while (i < paramAppRuntime.size())
          {
            localStringBuilder.append((String)paramAppRuntime.get(i));
            if (i != paramAppRuntime.size() - 1) {
              localStringBuilder.append("_");
            }
            i += 1;
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = true;
    GameCenterActivity.reportStep(paramString, 1, false, false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("fromAio", false);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("op_type");
    boolean bool1;
    if (paramIntent.getIntExtra("uintype", -1) == 1030) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (paramIntent.getIntExtra("uintype", -1) == 1035) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("push_notice_service_id");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("push_notice_content_id");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("KEY_MAIN_BUSINESS_ID", -1);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("KEY_SUB_BUSINESS_ID", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("KEY_PUSH_ID", 0);
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("KEY_PUSH_TRIGGER_INFO");
    PushUtil.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      PushReportController.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    if (TenDocLogReportHelper.a(paramString2))
    {
      paramTouchWebView = TenDocLogReportHelper.c(paramString2);
      String str = TenDocLogReportHelper.d(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err=");
      localStringBuilder.append(paramInt);
      TenDocLogReportHelper.a(null, paramTouchWebView, "0X8009E9F", "fail", str, localStringBuilder.toString());
    }
    paramTouchWebView = new StringBuilder();
    paramTouchWebView.append("errorCode = ");
    paramTouchWebView.append(paramInt);
    paramTouchWebView.append(" description = ");
    paramTouchWebView.append(paramString1);
    TenDocLogReportHelper.b(paramString2, "SwiftBrowserStatistics", "web_loaded_url_err", paramTouchWebView.toString());
    TenDocLogReportHelper.b(paramString2, "SwiftBrowserStatistics", "failingUrl", paramString2);
    TenDocLogReportHelper.b(paramString2, "SwiftBrowserStatistics", "cookie");
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((paramBoolean) && (this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (paramString != null) {
        paramTouchWebView = paramString;
      } else {
        paramTouchWebView = "unknown";
      }
      paramTouchWebView = Util.b(URLEncoder.encode(paramTouchWebView), new String[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, paramTouchWebView, "", "", localStringBuilder.toString());
    }
    if (TenDocLogReportHelper.a(paramString))
    {
      paramLong = TenDocLogReportHelper.a(String.valueOf(paramLong));
      paramTouchWebView = TenDocLogReportHelper.d(paramString);
      paramString = TenDocLogReportHelper.c(paramString);
      if (paramLong != 0L)
      {
        TenDocLogReportHelper.a(null, paramString, "0X8009E9F", "success", paramTouchWebView, "");
        TenDocLogReportHelper.a(null, paramString, "0X8009E9E", String.valueOf(paramLong), paramTouchWebView, "");
      }
      if (TextUtils.isEmpty(paramString))
      {
        TenDocLogReportHelper.a("SwiftBrowserStatistics", "url_load_time", String.valueOf(paramLong));
        return;
      }
      TenDocLogReportHelper.a("SwiftBrowserStatistics", "url_load_time", String.valueOf(paramLong), paramString);
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider, String paramString1, long paramLong, AppRuntime paramAppRuntime, String paramString2)
  {
    if (!GameCenterActivity.isContainsGameUrl(paramString1)) {
      return;
    }
    paramWebViewProvider = (SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2);
    GameCenterActivity.reportStep(paramString1, paramWebViewProvider.a.jdField_a_of_type_Int, true, paramWebViewProvider.a.jdField_a_of_type_Boolean);
    paramWebViewProvider.a(paramString1, paramLong, paramAppRuntime, paramString2, "WebStatusReportV2");
  }
  
  public void a(String paramString, int paramInt)
  {
    GameCenterActivity.reportDetectedBlankScreen(paramString, paramInt);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TenDocLogReportHelper.a(paramString))
    {
      TenDocLogReportHelper.a("SwiftBrowserStatistics", "onPageStarted_url", paramString);
      TenDocLogReportHelper.a(String.valueOf(paramLong));
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((TenDocLogReportHelper.a(paramString3)) && (TextUtils.equals(paramString1, "webview_init")))
    {
      String str1 = TenDocLogReportHelper.c(paramString3);
      String str2 = TenDocLogReportHelper.d(paramString3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("err=");
      localStringBuilder.append(paramString2);
      TenDocLogReportHelper.a(null, str1, "0X8009E9D", String.valueOf(paramLong), str2, localStringBuilder.toString());
    }
    TenDocLogReportHelper.b(paramString3, "SwiftBrowserStatistics", paramString1, String.valueOf(paramLong));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (!paramBoolean)) {
      a(paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("self_info");
    ((StringBuilder)localObject2).append(localAppRuntime.getLongAccountUin());
    Object localObject3 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    if ((localObject3 != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      long l = System.currentTimeMillis();
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(((SharedPreferences)localObject3).getInt("charm_level", 0));
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((SharedPreferences)localObject3).getInt("gender", 0));
      localObject3 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l - paramLong);
      ReportController.b(null, "dc00899", "grp_lbs", "", (String)localObject1, "visit_time", 0, 1, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
    }
    if (((this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) && (!paramBoolean) && (!PushReportController.jdField_a_of_type_Boolean)) {
      ThreadManager.getFileThreadHandler().postDelayed(new SwiftBrowserStatisticInjectorImpl.1(this, localAppRuntime, paramString), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticInjectorImpl
 * JD-Core Version:    0.7.0.1
 */