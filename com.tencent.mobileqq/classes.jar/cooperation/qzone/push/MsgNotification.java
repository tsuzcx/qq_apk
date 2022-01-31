package cooperation.qzone.push;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.NotificationClickReceiver;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class MsgNotification
{
  private static MsgNotification a;
  
  private Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.a(paramQQAppInterface.getApp());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("src_type", "app");
    localIntent.putExtra("isFromQQ", "true");
    localIntent.putExtra("page", "tab_remind");
    localIntent.putExtra("version", "1");
    return localIntent;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), TranslucentActivity.class);
    paramQQAppInterface.addFlags(268435456);
    if (paramIntent != null) {
      paramQQAppInterface.putExtras(paramIntent);
    }
    return paramQQAppInterface;
  }
  
  private Intent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.a(paramQQAppInterface, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramQQAppInterface.putExtra("qqid", Long.parseLong(paramString));
    paramQQAppInterface.putExtra("qzone_entry", 0);
    return paramQQAppInterface;
  }
  
  private Intent a(String paramString)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localUri = Uri.parse(paramString);
        localBundle.putString("cellid", localUri.getQueryParameter("uid"));
        localObject = localUri.getQueryParameter("subid");
        if (paramString.contains("photonum"))
        {
          localHashMap = new HashMap();
          localHashMap.put(Integer.valueOf(7), localUri.getQueryParameter("photonum"));
          if (Integer.valueOf(localUri.getQueryParameter("photonum")).intValue() <= 1) {
            continue;
          }
          str = localUri.getQueryParameter("bid");
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
          localBundle.putParcelable("businessparam", new MapParcelable(localHashMap));
        }
        localBundle.putString("subid", (String)localObject);
        localBundle.putLong("targetuin", Long.parseLong(localUri.getQueryParameter("uin")));
        localBundle.putInt("appid", Integer.parseInt(localUri.getQueryParameter("appid")));
      }
      catch (Exception paramString)
      {
        Uri localUri;
        Object localObject;
        HashMap localHashMap;
        String str;
        QLog.e("MsgNotification", 1, "getQZoneDetailIntent", paramString);
        continue;
      }
      paramString = QZoneHelper.a();
      paramString.putExtras(localBundle);
      return paramString;
      str = "";
      localObject = str;
      if (paramString.contains("bid"))
      {
        localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
        localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
        localObject = str;
      }
    }
  }
  
  public static MsgNotification a()
  {
    if (a == null) {
      a = new MsgNotification();
    }
    return a;
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      paramQQAppInterface.r();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    Uri localUri;
    if (paramString1 != null)
    {
      localUri = Uri.parse(paramString1);
      if (!TextUtils.isEmpty(localUri.getQueryParameter("from"))) {
        break label127;
      }
      str1 = str2;
      if (localUri.getPathSegments().size() <= 0) {}
    }
    label127:
    for (str1 = (String)localUri.getPathSegments().get(0);; str1 = localUri.getQueryParameter("from"))
    {
      LpReportInfo_dc00420.report(2, 0, str1, paramString2, 1);
      if (QLog.isColorLevel()) {
        QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " schema: " + paramString1 + " pushstatkey: " + paramString2);
      }
      return;
    }
  }
  
  private Intent b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.a(paramQQAppInterface, "com.qzone.web.QZoneTranslucentActivity");
    paramQQAppInterface.setAction("action_js2qzone");
    paramQQAppInterface.putExtra("cmd", "Schema");
    paramQQAppInterface.putExtra("schema", paramString);
    return paramQQAppInterface;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, boolean paramBoolean1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean2)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramInt1, paramQQAppInterface);
    Object localObject3 = (QZoneManagerImp)paramQQAppInterface.getManager(9);
    Object localObject1;
    int i;
    switch (paramInt2)
    {
    default: 
      paramInt1 = 1;
      localObject1 = null;
      i = 0;
    }
    for (;;)
    {
      label84:
      PendingIntent localPendingIntent;
      for (;;)
      {
        localObject3 = new Intent();
        ((Intent)localObject3).setClass(paramQQAppInterface.getApp(), NotificationClickReceiver.class);
        ((Intent)localObject3).putExtra("realIntent", (Parcelable)localObject1);
        ((Intent)localObject3).putExtra("hostuin", paramQQAppInterface.getAccount());
        ((Intent)localObject3).putExtra("pushschema", paramString2);
        ((Intent)localObject3).putExtra("pushstatkey", paramString3);
        localPendingIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, (Intent)localObject3, 134217728);
        if (paramBoolean1) {
          if ((paramInt2 == 2) || (paramInt2 == 8) || (paramInt2 == 4)) {
            localObject3 = BaseApplication.getContext().getString(2131434067);
          }
        }
        try
        {
          for (;;)
          {
            localObject1 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130844782);
            Object localObject4 = localObject1;
            if (localObject1 != null) {
              localObject4 = localObject1;
            }
            try
            {
              if (Build.VERSION.SDK_INT >= 11)
              {
                int j = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104901);
                int k = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104902);
                if (j == ((Bitmap)localObject1).getWidth())
                {
                  localObject4 = localObject1;
                  if (k == ((Bitmap)localObject1).getHeight()) {}
                }
                else
                {
                  localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, k, false);
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                try
                {
                  localObject5 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130844747);
                  localObject2 = localObject5;
                  try
                  {
                    QLog.e("MsgNotification", 1, "use small icon ,exp:", localThrowable);
                    localObject5 = localObject2;
                  }
                  catch (OutOfMemoryError localOutOfMemoryError2) {}
                }
                catch (OutOfMemoryError localOutOfMemoryError3)
                {
                  continue;
                }
                localObject5 = localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.e("MsgNotification", 2, "Exception:" + localOutOfMemoryError2.toString());
                  localObject5 = localObject2;
                  continue;
                  if ("oppo".equalsIgnoreCase(DeviceInfoUtil.l())) {
                    paramString1 = QZoneNotificationAdapter.a().b(localPendingIntent, paramQQAppInterface.getApp(), (Bitmap)localObject5, str, paramString1, 2130844747);
                  } else {
                    paramString1 = QZoneNotificationAdapter.a().c(localPendingIntent, paramQQAppInterface.getApp(), (Bitmap)localObject5, str, paramString1, 2130844747);
                  }
                }
              }
            }
            if (MobileIssueSettings.e) {
              break label1193;
            }
            paramString1 = QZoneNotificationAdapter.a().a(localPendingIntent, paramQQAppInterface.getApp(), (Bitmap)localObject4, (String)localObject3, paramString1, 2130844747);
            if ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 300))
            {
              localObject1 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
              ((Intent)localObject1).putExtra("pushstatkey", paramString3);
              ((Intent)localObject1).putExtra("mergenum", paramInt1);
              ((Intent)localObject1).putExtra("pushtype", paramInt2);
              paramString1.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, (Intent)localObject1, 134217728);
            }
            BadgeUtils.a(paramQQAppInterface.getApp(), 0, paramString1);
            try
            {
              localObject1 = new QNotificationManager(paramQQAppInterface.getApp());
              if (localObject1 != null) {
                ((QNotificationManager)localObject1).notify("MsgNotification.showQZoneMsgNotification", i, paramString1);
              }
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                QLog.e("MsgNotification", 1, "MsgNotification.showQZoneMsgNotification notify exception ", paramString1);
              }
              i = 120;
            }
            if (paramQQAppInterface != null)
            {
              QZoneHelper.a(paramQQAppInterface, getClass().getSimpleName());
              if (GuardManager.a != null) {
                GuardManager.a.b(0, null);
              }
            }
            if (!paramBoolean2) {
              break;
            }
            a(paramQQAppInterface, paramString2, paramString3);
            return;
            localObject1 = a(paramQQAppInterface);
            ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
            ((Intent)localObject1).putExtra("refer", "msg_notification");
            ((Intent)localObject1).putExtra("fling_action_key", 2);
            ((Intent)localObject1).putExtra("fling_code_key", hashCode());
            localObject1 = a(paramQQAppInterface, (Intent)localObject1);
            if (localObject3 == null) {
              break label1292;
            }
            paramInt1 = ((QZoneManagerImp)localObject3).a(1);
            ((QZoneManagerImp)localObject3).a(1, paramInt1);
            if (paramInt1 > 0) {
              break label1285;
            }
            paramInt1 = 1;
            i = 120;
            break label84;
            localObject1 = a(paramQQAppInterface, a(paramString2));
            paramInt1 = 1;
            i = 143;
            break label84;
            for (;;)
            {
              try
              {
                for (;;)
                {
                  localObject3 = b(paramQQAppInterface, paramString2);
                  localObject1 = localObject3;
                  try
                  {
                    for (;;)
                    {
                      localObject3 = a(paramQQAppInterface, (Intent)localObject3);
                      if (paramBoolean2)
                      {
                        localObject1 = localObject3;
                        localObject4 = new QZoneClickReport.ReportInfo();
                        localObject1 = localObject3;
                        ((QZoneClickReport.ReportInfo)localObject4).c = String.valueOf(322);
                        localObject1 = localObject3;
                        ((QZoneClickReport.ReportInfo)localObject4).d = String.valueOf(2);
                        localObject1 = localObject3;
                        ((QZoneClickReport.ReportInfo)localObject4).e = String.valueOf(6);
                        localObject1 = localObject3;
                        QZoneClickReport.report(paramQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject4, true);
                      }
                      localObject1 = localObject3;
                      localObject4 = Uri.parse(paramString2);
                      localObject1 = localObject3;
                      QzNotificationStruct localQzNotificationStruct = new QzNotificationStruct(((Uri)localObject4).getQueryParameter("room"), paramString1, paramBoolean1, paramInt2, paramString2, paramString3);
                      localObject1 = localObject3;
                      if (CliNotifyPush.a == null)
                      {
                        localObject1 = localObject3;
                        CliNotifyPush.a = Collections.synchronizedList(new ArrayList());
                      }
                      if (paramBoolean2)
                      {
                        localObject1 = localObject3;
                        CliNotifyPush.a.add(localQzNotificationStruct);
                      }
                      try
                      {
                        LpReportInfo_dc01245.report(Long.parseLong(((Uri)localObject4).getQueryParameter("uin")), Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount()), 11, 0);
                        localObject1 = localObject3;
                        paramInt1 = 1;
                        i = 141;
                      }
                      catch (Exception localException5)
                      {
                        for (;;)
                        {
                          localObject1 = localObject3;
                          QLog.e("MsgNotification", 1, localException5.getStackTrace());
                        }
                      }
                    }
                    QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SPECIAL2 error", localException1);
                  }
                  catch (Exception localException1) {}
                }
              }
              catch (Exception localException4)
              {
                Object localObject2 = null;
              }
            }
            if ((paramString2 != null) && (paramString2.startsWith("mqzonev2://arouse/openhomepage"))) {}
            for (;;)
            {
              try
              {
                localObject1 = a(paramQQAppInterface, Uri.parse(paramString2).getQueryParameter("uin"));
              }
              catch (Exception localException2)
              {
                try
                {
                  Intent localIntent = a(paramQQAppInterface, (Intent)localObject1);
                  localObject1 = localIntent;
                  paramInt1 = 1;
                  i = 142;
                }
                catch (Exception localException3)
                {
                  String str;
                  Object localObject5;
                  break label937;
                }
                localException2 = localException2;
                localObject1 = null;
              }
              label937:
              QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SCHEMA error", localException2);
              continue;
              localObject1 = a(paramQQAppInterface, b(paramQQAppInterface, paramString2));
            }
            str = BaseApplication.getContext().getString(2131434067) + "(" + BaseApplication.getContext().getString(2131433691) + paramInt1 + BaseApplication.getContext().getString(2131433692) + BaseApplication.getContext().getString(2131434822) + ")";
            continue;
            str = BaseApplication.getContext().getString(2131434067);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MsgNotification", 2, "Exception:" + localOutOfMemoryError1.toString());
            }
            localObject2 = null;
          }
        }
      }
      label1193:
      continue;
      label1285:
      label1292:
      paramInt1 = 1;
      i = 120;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.push.MsgNotification
 * JD-Core Version:    0.7.0.1
 */