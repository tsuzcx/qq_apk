package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import java.util.List;

public class NotificationClickReceiver
  extends BroadcastReceiver
{
  private static final String[] a = { "com.tencent.mobileqq.activity.SplashActivity", "com.tencent.mobileqq.activity.NearbyActivity", "com.tencent.mobileqq.activity.ChatActivity" };
  
  public static boolean a()
  {
    List localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningTasks(100);
    int i;
    boolean bool;
    int j;
    if ((localList != null) && (localList.size() > 0))
    {
      int k = localList.size();
      i = 0;
      bool = false;
      if (i < k)
      {
        String str = ((ActivityManager.RunningTaskInfo)localList.get(i)).topActivity.getClassName();
        QLog.i("pushReport", 4, "---------" + i + ":topActivity:" + str + " --baseActivity:" + ((ActivityManager.RunningTaskInfo)localList.get(i)).baseActivity.getClassName());
        String[] arrayOfString = a;
        int m = arrayOfString.length;
        j = 0;
        label141:
        if (j < m) {
          if (str.equals(arrayOfString[j]))
          {
            bool = true;
            label161:
            if (!bool) {
              break label202;
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.i("pushReport", 4, "---------isNeedToJumpFriendFeed:" + bool);
      return bool;
      j += 1;
      break label141;
      label202:
      i += 1;
      break;
      break label161;
      continue;
      bool = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = (Intent)paramIntent.getParcelableExtra("realIntent");
    ((Intent)localObject).setExtrasClassLoader(getClass().getClassLoader());
    String str1 = ((Intent)localObject).getStringExtra("qzone_plugin_activity_name");
    if ((!TextUtils.isEmpty(str1)) && (str1.equals("com.qzone.detail.ui.activity.QzoneDetailActivity"))) {
      ((Intent)localObject).putExtra("isNeedBackToFriendFeed", a());
    }
    try
    {
      paramContext.startActivity((Intent)localObject);
      localObject = paramIntent.getStringExtra("hostuin");
      str1 = paramIntent.getStringExtra("pushschema");
      String str2 = paramIntent.getStringExtra("pushstatkey");
      paramIntent = "";
      paramContext = paramIntent;
      Uri localUri;
      if (str1 != null)
      {
        if (str1.startsWith("mqzone://arouse/livevideo"))
        {
          paramContext = new QZoneClickReport.ReportInfo();
          paramContext.c = String.valueOf(322);
          paramContext.d = String.valueOf(3);
          paramContext.e = String.valueOf(7);
          QZoneClickReport.report((String)localObject, paramContext, true);
          CliNotifyPush.a.clear();
        }
        localUri = Uri.parse(str1);
        if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
          break label265;
        }
        paramContext = paramIntent;
        if (localUri.getPathSegments().size() <= 0) {}
      }
      label265:
      for (paramContext = (String)localUri.getPathSegments().get(0);; paramContext = localUri.getQueryParameter("from"))
      {
        LpReportInfo_dc00420.report(3, 0, paramContext, str2, 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("pushReport", 2, "CLICK: uin: " + (String)localObject + " schema: " + str1 + " pushstatkey: " + str2);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("NotificationClickReceiver", 1, paramContext, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.NotificationClickReceiver
 * JD-Core Version:    0.7.0.1
 */