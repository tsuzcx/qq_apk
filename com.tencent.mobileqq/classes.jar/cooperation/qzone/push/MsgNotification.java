package cooperation.qzone.push;

import android.app.PendingIntent;
import android.content.Context;
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
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.NotificationClickReceiver;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.LocalMultiProcConfig;
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
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class MsgNotification
{
  public static final String QCIRCLE_UNREADCOUND = "qzone_unreadcount";
  public static final int RING_TYPE_MSG_SOUND = 1;
  public static final int RING_TYPE_NO_SOUND = 0;
  public static final int RING_TYPE_SYSTEM_SOUND = 2;
  public static final String TAG = "MsgNotification";
  private static MsgNotification manager;
  
  public static void cleanQCirclePush()
  {
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null)
    {
      localQQNotificationManager.cancel("MsgNotification", 3000532);
      localQQNotificationManager.cancel("MsgNotification", 3000533);
      localQQNotificationManager.cancel("MsgNotification", 3000534);
      localQQNotificationManager.cancel("MsgNotification", 3000535);
      localQQNotificationManager.cancel("MsgNotification", 3000536);
    }
    clearQCircleUnreadCount();
  }
  
  public static void clearQCircleUnreadCount()
  {
    LocalMultiProcConfig.putInt("qzone_unreadcount3000532", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000533", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000534", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000535", 0);
    LocalMultiProcConfig.putInt("qzone_unreadcount3000536", 0);
  }
  
  private Intent getBrowserIntent(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", paramString);
    paramQQAppInterface.putExtra("injectrecommend", true);
    paramQQAppInterface.setData(Uri.parse(paramString));
    QZoneHelper.addSource(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static MsgNotification getInstance()
  {
    if (manager == null) {
      manager = new MsgNotification();
    }
    return manager;
  }
  
  private Intent getMyFeedIntent(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.getQzoneMyFeedActivity(paramQQAppInterface.getApp());
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
  
  private Intent getQZoneDetailIntent(String paramString)
  {
    Bundle localBundle = new Bundle();
    label303:
    for (;;)
    {
      try
      {
        Uri localUri = Uri.parse(paramString);
        localBundle.putString("cellid", localUri.getQueryParameter("uid"));
        Object localObject = localUri.getQueryParameter("subid");
        if (!paramString.contains("photonum")) {
          break label303;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put(Integer.valueOf(7), localUri.getQueryParameter("photonum"));
        int i = Integer.valueOf(localUri.getQueryParameter("photonum")).intValue();
        String str;
        if (i > 1)
        {
          str = localUri.getQueryParameter("bid");
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
        }
        else
        {
          str = "";
          localObject = str;
          if (paramString.contains("bid"))
          {
            localHashMap.put(Integer.valueOf(2), localUri.getQueryParameter("bid"));
            localHashMap.put(Integer.valueOf(1), localUri.getQueryParameter("bid"));
            localObject = str;
          }
        }
        localBundle.putParcelable("businessparam", new MapParcelable(localHashMap));
        localBundle.putString("subid", (String)localObject);
        localBundle.putLong("targetuin", Long.parseLong(localUri.getQueryParameter("uin")));
        localBundle.putInt("appid", Integer.parseInt(localUri.getQueryParameter("appid")));
      }
      catch (Exception paramString)
      {
        QLog.e("MsgNotification", 1, "getQZoneDetailIntent", paramString);
      }
      paramString = QZoneHelper.getQZoneDetailActivity();
      paramString.putExtras(localBundle);
      return paramString;
    }
  }
  
  private String getTitle(String paramString, int paramInt)
  {
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
    } else {
      str = BaseApplication.getContext().getString(2131916998);
    }
    if (paramInt == 0) {
      return str;
    }
    int i = getUnreadCount(paramInt);
    if (i <= 1) {
      return str;
    }
    if (paramInt == 3000532)
    {
      paramString = BaseApplication.getContext().getString(2131917749);
    }
    else if (paramInt == 3000533)
    {
      paramString = BaseApplication.getContext().getString(2131917750);
    }
    else if (paramInt == 3000534)
    {
      paramString = BaseApplication.getContext().getString(2131917751);
    }
    else
    {
      paramString = str;
      if (paramInt != 3000535) {
        return paramString;
      }
      paramString = BaseApplication.getContext().getString(2131917752);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("(");
    localStringBuilder.append(BaseApplication.getContext().getString(2131890818));
    localStringBuilder.append(i);
    localStringBuilder.append(BaseApplication.getContext().getString(2131916809));
    localStringBuilder.append(paramString);
    localStringBuilder.append(")");
    paramString = localStringBuilder.toString();
    return paramString;
  }
  
  private Intent getTranslucentActivity(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramQQAppInterface, "com.qzone.misc.web.QZoneTranslucentActivity");
    paramQQAppInterface.setAction("action_js2qzone");
    paramQQAppInterface.putExtra("cmd", "Schema");
    paramQQAppInterface.putExtra("schema", paramString);
    return paramQQAppInterface;
  }
  
  private int getUnreadCount(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qzone_unreadcount");
    ((StringBuilder)localObject).append(paramInt);
    int i = LocalMultiProcConfig.getInt(((StringBuilder)localObject).toString(), 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qzone_unreadcount");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    paramInt = i + 1;
    LocalMultiProcConfig.putInt((String)localObject, paramInt);
    return paramInt;
  }
  
  private Intent getUserHomeIntent(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(paramQQAppInterface, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramQQAppInterface.putExtra("qqid", Long.parseLong(paramString));
    paramQQAppInterface.putExtra("qzone_entry", 0);
    return paramQQAppInterface;
  }
  
  private Intent getVipReminderIntent(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = QZoneHelper.getQzoneFriendFeedActivity(paramQQAppInterface.getApp());
    localIntent.putExtra("qzone_uin", paramQQAppInterface.getAccount());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("FromNotification", true);
    localIntent.putExtras(paramQQAppInterface);
    localIntent.addFlags(67108864);
    localIntent.putExtra("vipReminderFlag", true);
    return localIntent;
  }
  
  private void playSound(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      try
      {
        paramQQAppInterface.vibratorAndAudio();
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("MsgNotification", 1, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  private void pushArriveReport(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      localObject = Uri.parse(paramString1);
      if (TextUtils.isEmpty(((Uri)localObject).getQueryParameter("from")))
      {
        if (((Uri)localObject).getPathSegments().size() > 0)
        {
          localObject = (String)((Uri)localObject).getPathSegments().get(0);
          break label73;
        }
      }
      else
      {
        localObject = ((Uri)localObject).getQueryParameter("from");
        break label73;
      }
    }
    Object localObject = "";
    label73:
    if (paramBoolean) {
      LpReportInfo_dc00420.report(10, 0, (String)localObject, paramString2, 1);
    } else {
      LpReportInfo_dc00420.report(2, 0, (String)localObject, paramString2, 1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EXPOSE: uin: ");
      ((StringBuilder)localObject).append(paramQQAppInterface.getAccount());
      ((StringBuilder)localObject).append(" schema: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" pushstatkey: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" fake:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("pushReport", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int pushTypeConvertToNotifyId(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 8)
          {
            if (paramInt1 != 300)
            {
              if (paramInt1 != 366) {
                return 0;
              }
              if (paramInt2 != 1)
              {
                if (paramInt2 != 2)
                {
                  if (paramInt2 != 3)
                  {
                    if (paramInt2 != 4) {
                      return 3000536;
                    }
                    return 3000535;
                  }
                  return 3000534;
                }
                return 3000533;
              }
              return 3000532;
            }
          }
          else {
            return 243;
          }
        }
        else {
          return 242;
        }
      }
      else {
        return 244;
      }
    }
    return 241;
  }
  
  private Intent wrapPluginIntent(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    paramQQAppInterface = new Intent(paramQQAppInterface.getApp(), TranslucentActivity.class);
    paramQQAppInterface.addFlags(268435456);
    if (paramIntent != null) {
      paramQQAppInterface.putExtras(paramIntent);
    }
    return paramQQAppInterface;
  }
  
  public void showNewLocalPhotoNotification(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, "com.qzone.misc.web.QZoneTranslucentActivity");
    ((Intent)localObject).setAction("action_js2qzone");
    ((Intent)localObject).putExtra("cmd", "Schema");
    ((Intent)localObject).putExtra("schema", paramString3);
    paramString3 = new Intent(paramContext, TranslucentActivity.class);
    paramString3.addFlags(268435456);
    paramString3.putExtras((Intent)localObject);
    paramString3.putExtra("param_notifyid", 245);
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 245, paramString3, 134217728);
    try
    {
      localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2130850438);
    }
    catch (OutOfMemoryError paramString3)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception:");
        ((StringBuilder)localObject).append(paramString3.toString());
        QLog.e("MsgNotification", 2, ((StringBuilder)localObject).toString());
      }
      localObject = null;
    }
    paramString3 = (String)localObject;
    if (localObject != null)
    {
      paramString3 = (String)localObject;
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          int i = paramContext.getResources().getDimensionPixelSize(17104901);
          int j = paramContext.getResources().getDimensionPixelSize(17104902);
          if (i == ((Bitmap)localObject).getWidth())
          {
            paramString3 = (String)localObject;
            if (j == ((Bitmap)localObject).getHeight()) {}
          }
          else
          {
            paramString3 = Bitmap.createScaledBitmap((Bitmap)localObject, i, j, false);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramString3 = BitmapFactory.decodeResource(paramContext.getResources(), 2130850307);
          localObject = paramString3;
          QLog.e("MsgNotification", 1, "use small icon ,exp:", localThrowable);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          paramString3 = (String)localObject;
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("Exception:");
            paramString3.append(localOutOfMemoryError.toString());
            QLog.e("MsgNotification", 2, paramString3.toString());
            paramString3 = (String)localObject;
          }
        }
      }
    }
    if (!MobileIssueSettings.e) {
      paramString1 = QZoneNotificationAdapter.getInstance().newNotificationForMz(localPendingIntent, paramContext, paramString3, paramString1, paramString2, 2130849413);
    } else if ("oppo".equalsIgnoreCase(DeviceInfoUtil.w())) {
      paramString1 = QZoneNotificationAdapter.getInstance().newNotificationForOppo(localPendingIntent, paramContext, paramString3, paramString1, paramString2, 2130849413);
    } else {
      paramString1 = QZoneNotificationAdapter.getInstance().buildNotification(localPendingIntent, paramContext, paramString3, paramString1, paramString2, 2130849413);
    }
    BadgeUtils.a(paramContext, 0, paramString1);
    try
    {
      paramContext = QQNotificationManager.getInstance();
      if (paramContext != null)
      {
        paramContext.notify("MsgNotification.showQZoneMsgNotification", 245, paramString1);
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("MsgNotification", 1, "MsgNotification.showQZoneMsgNotification notify exception ", paramContext);
    }
  }
  
  public void showQZoneMsgNotification(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, String paramString5, String paramString6, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    AppRuntime.Status localStatus = ((IOnlineStatusService)paramQQAppInterface.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    if (localStatus != AppRuntime.Status.dnd) {
      playSound(paramInt1, paramQQAppInterface);
    } else if (QLog.isColorLevel()) {
      QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield sound");
    }
    if (FriendsStatusUtil.a(paramQQAppInterface.getApp())) {
      return;
    }
    playSound(paramInt1, paramQQAppInterface);
    Object localObject4 = (QZoneManagerImp)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    Object localObject1;
    if (paramInt2 != 1)
    {
      if (paramInt2 == 2) {
        break label480;
      }
      if (paramInt2 == 4) {
        break label247;
      }
      if (paramInt2 == 8) {
        break label157;
      }
      if (paramInt2 != 300)
      {
        if (paramInt2 != 366) {
          localObject1 = null;
        }
        for (;;)
        {
          paramInt1 = 1;
          break;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("type", 2);
        }
      }
    }
    break label496;
    label157:
    if ((paramString5 != null) && (paramString5.startsWith("mqzonev2://arouse/openhomepage"))) {
      try
      {
        localObject1 = getUserHomeIntent(paramQQAppInterface, Uri.parse(paramString5).getQueryParameter("uin"));
        try
        {
          Intent localIntent = wrapPluginIntent(paramQQAppInterface, (Intent)localObject1);
          localObject1 = localIntent;
        }
        catch (Exception localException1) {}
        QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_SCHEMA error", localException2);
      }
      catch (Exception localException2)
      {
        localObject1 = null;
      }
    } else {
      localObject1 = wrapPluginIntent(paramQQAppInterface, getTranslucentActivity(paramQQAppInterface, paramString5));
    }
    label1561:
    for (;;)
    {
      try
      {
        for (;;)
        {
          label247:
          localObject4 = getTranslucentActivity(paramQQAppInterface, paramString5);
          try
          {
            localObject1 = wrapPluginIntent(paramQQAppInterface, (Intent)localObject4);
            if (!paramBoolean2) {
              break label1561;
            }
          }
          catch (Exception localException6)
          {
            try
            {
              for (;;)
              {
                Object localObject2 = new QZoneClickReport.ReportInfo();
                ((QZoneClickReport.ReportInfo)localObject2).actionType = String.valueOf(322);
                try
                {
                  for (;;)
                  {
                    ((QZoneClickReport.ReportInfo)localObject2).subactionType = String.valueOf(2);
                    ((QZoneClickReport.ReportInfo)localObject2).reserves = String.valueOf(6);
                    QZoneClickReport.report(paramQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject2, true);
                    localObject2 = Uri.parse(paramString5);
                    localObject4 = ((Uri)localObject2).getQueryParameter("room");
                    try
                    {
                      localObject4 = new QzNotificationStruct((String)localObject4, paramString2, paramBoolean1, paramInt2, paramString5, paramString6);
                      if (CliNotifyPush.b == null) {
                        CliNotifyPush.b = Collections.synchronizedList(new ArrayList());
                      }
                      if (paramBoolean2)
                      {
                        CliNotifyPush.b.add(localObject4);
                        try
                        {
                          LpReportInfo_dc01245.report(Long.parseLong(((Uri)localObject2).getQueryParameter("uin")), Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount()), 11, 0);
                        }
                        catch (Exception localException3)
                        {
                          QLog.e("MsgNotification", 1, localException3.getStackTrace());
                        }
                      }
                    }
                    catch (Exception localException4) {}
                  }
                }
                catch (Exception localException5) {}
              }
            }
            catch (Exception localException8)
            {
              label449:
              Object localObject3;
              int i;
              break label449;
            }
            localException6 = localException6;
            localObject1 = localObject4;
          }
        }
        QLog.e("MsgNotification", 2, "QZONE_PUSH_TYPE_LIVE error", localException7);
      }
      catch (Exception localException7)
      {
        localObject1 = null;
      }
      break label600;
      label480:
      localObject1 = wrapPluginIntent(paramQQAppInterface, getQZoneDetailIntent(paramString5));
      break label600;
      label496:
      localObject1 = getMyFeedIntent(paramQQAppInterface);
      ((Intent)localObject1).putExtra("launch_time", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("refer", "msg_notification");
      ((Intent)localObject1).putExtra("fling_action_key", 2);
      ((Intent)localObject1).putExtra("fling_code_key", hashCode());
      localObject3 = wrapPluginIntent(paramQQAppInterface, (Intent)localObject1);
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        paramInt1 = ((QZoneManagerImp)localObject4).d(1);
        ((QZoneManagerImp)localObject4).a(1, paramInt1);
        if (paramInt1 <= 0)
        {
          localObject1 = localObject3;
        }
        else
        {
          localObject1 = localObject3;
          break label602;
        }
      }
      label600:
      paramInt1 = 1;
      label602:
      i = pushTypeConvertToNotifyId(paramInt2, paramInt3);
      localObject3 = new Intent();
      ((Intent)localObject3).setClass(paramQQAppInterface.getApp(), NotificationClickReceiver.class);
      ((Intent)localObject3).putExtra("realIntent", (Parcelable)localObject1);
      ((Intent)localObject3).putExtra("hostuin", paramQQAppInterface.getAccount());
      ((Intent)localObject3).putExtra("pushschema", paramString5);
      ((Intent)localObject3).putExtra("pushstatkey", paramString6);
      ((Intent)localObject3).putExtra("param_notifyid", i);
      localObject4 = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, (Intent)localObject3, 134217728);
      if (paramInt2 == 366)
      {
        localObject1 = getTitle(paramString1, i);
      }
      else if ((!TextUtils.isEmpty(paramString1)) && (paramInt2 == 8))
      {
        localObject1 = paramString1;
      }
      else
      {
        if (paramBoolean1)
        {
          if ((paramInt2 != 2) && (paramInt2 != 8) && (paramInt2 != 4))
          {
            paramString1 = new StringBuilder();
            paramString1.append(BaseApplication.getContext().getString(2131915895));
            paramString1.append("(");
            paramString1.append(BaseApplication.getContext().getString(2131890818));
            paramString1.append(paramInt1);
            paramString1.append(BaseApplication.getContext().getString(2131916809));
            paramString1.append(BaseApplication.getContext().getString(2131917748));
            paramString1.append(")");
            paramString1 = paramString1.toString();
          }
          else
          {
            paramString1 = BaseApplication.getContext().getString(2131915895);
          }
        }
        else {
          paramString1 = BaseApplication.getContext().getString(2131915895);
        }
        localObject1 = paramString1;
      }
      if (paramInt2 == 8)
      {
        paramString1 = NewMsgNotificationManager.a(paramQQAppInterface);
        if (paramString1.a(paramString3, paramString4)) {
          paramString1 = paramString1.a(paramString3, paramString4, null);
        } else {
          paramString1 = null;
        }
      }
      for (;;)
      {
        paramInt3 = 2130849413;
        break;
        if (paramInt2 == 366)
        {
          localObject3 = BitmapManager.a(paramQQAppInterface.getApp().getResources(), 2130845121);
          NewMsgNotificationManager localNewMsgNotificationManager = NewMsgNotificationManager.a(paramQQAppInterface);
          paramString1 = (String)localObject3;
          if (localNewMsgNotificationManager.a(paramString3, paramString4)) {
            paramString1 = localNewMsgNotificationManager.a(paramString3, paramString4, (Bitmap)localObject3);
          }
          paramInt3 = 2130842313;
          break;
        }
        try
        {
          paramString3 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130850438);
        }
        catch (OutOfMemoryError paramString1)
        {
          if (QLog.isColorLevel())
          {
            paramString3 = new StringBuilder();
            paramString3.append("Exception:");
            paramString3.append(paramString1.toString());
            QLog.e("MsgNotification", 2, paramString3.toString());
          }
          paramString3 = null;
        }
        paramString1 = paramString3;
        if (paramString3 != null)
        {
          paramString1 = paramString3;
          try
          {
            if (Build.VERSION.SDK_INT >= 11)
            {
              paramInt3 = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104901);
              int j = paramQQAppInterface.getApp().getResources().getDimensionPixelSize(17104902);
              if (paramInt3 == paramString3.getWidth())
              {
                paramString1 = paramString3;
                if (j == paramString3.getHeight()) {}
              }
              else
              {
                paramString1 = Bitmap.createScaledBitmap(paramString3, paramInt3, j, false);
              }
            }
          }
          catch (Throwable paramString4)
          {
            try
            {
              paramString1 = BitmapFactory.decodeResource(paramQQAppInterface.getApp().getResources(), 2130850307);
              paramString3 = paramString1;
              QLog.e("MsgNotification", 1, "use small icon ,exp:", paramString4);
            }
            catch (OutOfMemoryError paramString4)
            {
              paramString1 = paramString3;
              if (QLog.isColorLevel())
              {
                paramString1 = new StringBuilder();
                paramString1.append("Exception:");
                paramString1.append(paramString4.toString());
                QLog.e("MsgNotification", 2, paramString1.toString());
                paramString1 = paramString3;
              }
            }
          }
        }
      }
      if (!MobileIssueSettings.e) {
        paramString1 = QZoneNotificationAdapter.getInstance().newNotificationForMz((PendingIntent)localObject4, paramQQAppInterface.getApp(), paramString1, (String)localObject1, paramString2, paramInt3);
      }
      for (;;)
      {
        break;
        if ("oppo".equalsIgnoreCase(DeviceInfoUtil.w())) {
          paramString1 = QZoneNotificationAdapter.getInstance().newNotificationForOppo((PendingIntent)localObject4, paramQQAppInterface.getApp(), paramString1, (String)localObject1, paramString2, paramInt3);
        } else {
          paramString1 = QZoneNotificationAdapter.getInstance().buildNotification((PendingIntent)localObject4, paramQQAppInterface.getApp(), paramString1, (String)localObject1, paramString2, paramInt3);
        }
      }
      if ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 300))
      {
        paramString2 = new Intent("com.qzone.action.SYSTEM_CLEAR_PUSH");
        paramString2.setPackage(MobileQQ.getContext().getPackageName());
        paramString2.putExtra("pushstatkey", paramString6);
        paramString2.putExtra("mergenum", paramInt1);
        paramString2.putExtra("pushtype", paramInt2);
        paramString1.deleteIntent = PendingIntent.getBroadcast(paramQQAppInterface.getApp(), i, paramString2, 134217728);
      }
      BadgeUtils.a(paramQQAppInterface.getApp(), 0, paramString1);
      if (localStatus == AppRuntime.Status.dnd)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgNotification", 2, "showQZoneMsgNotification, dnd shield hide notify");
        }
        return;
      }
      if (paramBoolean3) {}
      try
      {
        pushArriveReport(paramQQAppInterface, paramString5, paramString6, true);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("MsgNotification", 1, "MsgNotification.showQZoneMsgNotification notify exception ", paramString1);
      }
      paramString2 = QQNotificationManager.getInstance();
      if (paramString2 != null) {
        paramString2.notify("MsgNotification.showQZoneMsgNotification", i, paramString1);
      }
      if (paramQQAppInterface != null)
      {
        QZoneHelper.preloadQzone(paramQQAppInterface, getClass().getSimpleName());
        if (GuardManager.sInstance != null) {
          GuardManager.sInstance.onEvent(0, null);
        }
      }
      if (paramBoolean2) {
        pushArriveReport(paramQQAppInterface, paramString5, paramString6, false);
      }
      return;
    }
  }
  
  public void updateUnreadcount(int paramInt1, int paramInt2)
  {
    paramInt1 = pushTypeConvertToNotifyId(paramInt1, paramInt2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qzone_unreadcount");
    ((StringBuilder)localObject).append(paramInt1);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone_unreadcount");
    localStringBuilder.append(paramInt1);
    LocalMultiProcConfig.putInt((String)localObject, LocalMultiProcConfig.getInt(localStringBuilder.toString(), 0) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.push.MsgNotification
 * JD-Core Version:    0.7.0.1
 */