package com.tencent.mobileqq.servlet;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.util.HashMap;
import java.util.List;

public class NotificationClickReceiver
  extends BroadcastReceiver
{
  private static final String[] a = { "com.tencent.mobileqq.activity.SplashActivity", "com.tencent.mobileqq.activity.NearbyActivity", "com.tencent.mobileqq.activity.ChatActivity" };
  
  public static boolean a()
  {
    Object localObject1 = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningTasks(100);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int k = ((List)localObject1).size();
      int i = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i >= k) {
          break;
        }
        String str = ((ActivityManager.RunningTaskInfo)((List)localObject1).get(i)).topActivity.getClassName();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("---------");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(":topActivity:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" --baseActivity:");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningTaskInfo)((List)localObject1).get(i)).baseActivity.getClassName());
        QLog.i("pushReport", 4, ((StringBuilder)localObject2).toString());
        localObject2 = a;
        int m = localObject2.length;
        int j = 0;
        for (;;)
        {
          bool2 = bool1;
          if (j >= m) {
            break;
          }
          if (str.equals(localObject2[j]))
          {
            bool2 = true;
            break;
          }
          j += 1;
        }
        if (bool2) {
          break;
        }
        i += 1;
      }
    }
    boolean bool2 = false;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("---------isNeedToJumpFriendFeed:");
    ((StringBuilder)localObject1).append(bool2);
    QLog.i("pushReport", 4, ((StringBuilder)localObject1).toString());
    return bool2;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = (Intent)paramIntent.getParcelableExtra("realIntent");
    ((Intent)localObject).setExtrasClassLoader(getClass().getClassLoader());
    String str1 = ((Intent)localObject).getStringExtra("qzone_plugin_activity_name");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals("com.qzone.detail.ui.activity.QzoneDetailActivity"))) {
      ((Intent)localObject).putExtra("isNeedBackToFriendFeed", a());
    }
    int i = ((Intent)localObject).getIntExtra("type", 1);
    str1 = paramIntent.getStringExtra("pushschema");
    if ((i == 2) && (!TextUtils.isEmpty(str1)))
    {
      if (str1.startsWith("https://"))
      {
        paramContext = new HashMap();
        paramContext.put("url", str1);
        QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.getContext(), "openwebview", paramContext);
      }
      else if (str1.startsWith("mqqapi://"))
      {
        localObject = new Intent(paramContext, JumpActivity.class);
        ((Intent)localObject).setData(Uri.parse(str1));
        paramContext.startActivity((Intent)localObject);
      }
    }
    else {
      paramContext.startActivity((Intent)localObject);
    }
    try
    {
      localObject = paramIntent.getStringExtra("hostuin");
      String str2 = paramIntent.getStringExtra("pushstatkey");
      paramIntent = "";
      paramContext = paramIntent;
      if (str1 != null)
      {
        if (str1.startsWith("mqzone://arouse/livevideo"))
        {
          paramContext = new QZoneClickReport.ReportInfo();
          paramContext.actionType = String.valueOf(322);
          paramContext.subactionType = String.valueOf(3);
          paramContext.reserves = String.valueOf(7);
          QZoneClickReport.report((String)localObject, paramContext, true);
          CliNotifyPush.a.clear();
        }
        Uri localUri = Uri.parse(str1);
        if (TextUtils.isEmpty(localUri.getQueryParameter("from")))
        {
          paramContext = paramIntent;
          if (localUri.getPathSegments().size() > 0) {
            paramContext = (String)localUri.getPathSegments().get(0);
          }
        }
        else
        {
          paramContext = localUri.getQueryParameter("from");
        }
      }
      LpReportInfo_dc00420.report(3, 0, paramContext, str2, 1);
      QZoneLoginReportHelper.reportLoginFromMQQPush();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("CLICK: uin: ");
        paramContext.append((String)localObject);
        paramContext.append(" schema: ");
        paramContext.append(str1);
        paramContext.append(" pushstatkey: ");
        paramContext.append(str2);
        QLog.d("pushReport", 2, paramContext.toString());
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("NotificationClickReceiver", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.NotificationClickReceiver
 * JD-Core Version:    0.7.0.1
 */