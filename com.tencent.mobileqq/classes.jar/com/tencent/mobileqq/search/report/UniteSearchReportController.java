package com.tencent.mobileqq.search.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class UniteSearchReportController
{
  public static final String a = "UniteSearchReportController";
  public static String b = "";
  
  public static String a()
  {
    return "old_search";
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "message";
    }
    if (paramInt == 2) {
      return "contact";
    }
    if ((paramInt != 21) && (paramInt != 3))
    {
      if ((paramInt != 25) && (paramInt != 10)) {
        return "unknown";
      }
      return "kandian";
    }
    return "dongtai";
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    int i = 1;
    if (paramAppInterface == null)
    {
      paramAppInterface = MobileQQ.sMobileQQ.peekAppRuntime();
      if (!(paramAppInterface instanceof AppInterface))
      {
        QLog.e(a, 1, "app is null");
        return;
      }
      paramAppInterface = (AppInterface)paramAppInterface;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1) {
        break label92;
      }
      if (paramInt1 == 2) {
        break label89;
      }
      if (paramInt1 == 3) {
        break label83;
      }
    }
    else
    {
      if (paramInt2 == 1) {
        break label92;
      }
      if (paramInt2 == 2) {
        break label89;
      }
      if (paramInt2 == 21) {
        break label83;
      }
    }
    i = 0;
    break label92;
    label83:
    i = 3;
    break label92;
    label89:
    i = 2;
    label92:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt4);
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      Integer.valueOf((String)localObject1);
      ReportController.b(paramAppInterface, "dc00898", "", "", "qqsearch", paramString1, i, 0, (String)localObject1, (String)localObject2, paramString2, b());
      return;
    }
    catch (Exception localException)
    {
      label188:
      break label188;
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", "qqsearch", paramString1, i, 0, "0", (String)localObject2, paramString2, b());
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    int i = 3;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            i = 0;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else
    {
      if (paramInt2 != 0) {
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 != 21)
            {
              if (paramInt2 == 25)
              {
                i = 4;
                break label96;
              }
            }
            else
            {
              i = 3;
              break label96;
            }
          }
          else
          {
            i = 2;
            break label96;
          }
        }
        else
        {
          i = 1;
          break label96;
        }
      }
      i = 0;
    }
    label96:
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = b();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("");
    ReportController.b(paramAppInterface, "dc00898", "", "", "qqsearch", paramString1, i, 0, (String)localObject, localStringBuilder.toString(), paramString2, paramString3);
    paramAppInterface = new StringBuilder();
    paramAppInterface.append(" source: ");
    paramAppInterface.append(paramInt1);
    paramAppInterface.append(" from: ");
    paramAppInterface.append(paramInt2);
    paramAppInterface.append("  sopName: ");
    paramAppInterface.append(paramString1);
    paramAppInterface.append(" r1: ");
    paramAppInterface.append(paramInt3);
    paramAppInterface.append(" r2: ");
    paramAppInterface.append(paramInt4);
    paramAppInterface.append(" r3: ");
    paramAppInterface.append(paramString2);
    paramAppInterface.append(" r4: ");
    paramAppInterface.append(paramString3);
    QLog.d("searchReportClick898", 2, paramAppInterface.toString());
  }
  
  public static void a(AppInterface paramAppInterface, ReportModelDC02528 paramReportModelDC02528)
  {
    a("dc02528", paramAppInterface, paramReportModelDC02528);
    QLog.isColorLevel();
  }
  
  public static void a(String paramString, AppInterface paramAppInterface, ReportModel paramReportModel)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.isColorLevel();
      return;
    }
    if (paramReportModel == null)
    {
      QLog.isColorLevel();
      return;
    }
    AppInterface localAppInterface = paramAppInterface;
    if (paramAppInterface == null)
    {
      localAppInterface = paramAppInterface;
      if (MobileQQ.sProcessId == 1)
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        localAppInterface = paramAppInterface;
        if (localAppRuntime != null)
        {
          localAppInterface = paramAppInterface;
          if ((localAppRuntime instanceof AppInterface)) {
            localAppInterface = (AppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localAppInterface == null)
    {
      paramAppInterface = new Intent();
      paramAppInterface.setClassName(MobileQQ.sMobileQQ, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramAppInterface.putExtra("reporting_tag", paramString);
      paramAppInterface.putExtra("reporting_detail", paramReportModel);
      paramAppInterface.putExtra("reporting_count", paramReportModel.report_count);
      paramAppInterface.putExtra("is_runtime", 1);
      MobileQQ.sMobileQQ.sendBroadcast(paramAppInterface);
      return;
    }
    b(paramString, localAppInterface, paramReportModel);
  }
  
  public static String b()
  {
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2131897021;
    } else if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      i = 2131897022;
    } else {
      i = 2131897020;
    }
    return BaseApplication.getContext().getString(i);
  }
  
  protected static void b(String paramString, AppInterface paramAppInterface, ReportModel paramReportModel)
  {
    if ((paramReportModel != null) && (paramAppInterface != null))
    {
      paramReportModel.uin = paramAppInterface.getCurrentAccountUin();
      paramReportModel.version = "8.8.17";
      Object localObject = new NewIntent(paramAppInterface.getApplication(), ReportServlet.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString);
      ((NewIntent)localObject).putExtra("content", paramReportModel.toReportString());
      ((NewIntent)localObject).setWithouLogin(true);
      paramAppInterface.startServlet((NewIntent)localObject);
      if (QLog.isColorLevel())
      {
        paramAppInterface = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportEventRuntime, tag = ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", model = ");
        ((StringBuilder)localObject).append(paramReportModel);
        QLog.d(paramAppInterface, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    QLog.isColorLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.report.UniteSearchReportController
 * JD-Core Version:    0.7.0.1
 */