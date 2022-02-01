package com.tencent.mobileqq.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NotifyLightUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import com.tencent.util.notification.NotifyIdManager;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import org.jetbrains.annotations.Nullable;

public class MobileQQServiceExtend
  extends MobileQQService
{
  public static HashMap<String, UniPacket> a;
  private int jdField_a_of_type_Int = 0;
  private QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  public boolean a;
  boolean b = true;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public MobileQQServiceExtend(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private int a(int paramInt1, QQMessageFacade paramQQMessageFacade, int paramInt2)
  {
    int i = paramInt2;
    if (CommonBadgeUtilImpl.isMIUI6())
    {
      if (paramQQMessageFacade == null) {
        return paramInt2;
      }
      paramQQMessageFacade = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
      i = paramInt2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (paramQQMessageFacade == null) {
          return paramInt2;
        }
        paramQQMessageFacade = paramQQMessageFacade.getActiveNotifications();
        i = 0;
        while ((paramQQMessageFacade != null) && (i < paramQQMessageFacade.length))
        {
          Object localObject = paramQQMessageFacade[i];
          Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localObject.getId()));
          if (localInteger != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getUnreadMIUI() minus activeUnRead with: id = [");
            localStringBuilder.append(localObject.getId());
            localStringBuilder.append("], activeUnRead = [");
            localStringBuilder.append(localInteger);
            localStringBuilder.append("], unread = [");
            localStringBuilder.append(paramInt2);
            localStringBuilder.append("]");
            QLog.i("MobileQQServiceWrapper", 1, localStringBuilder.toString());
            paramInt2 -= localInteger.intValue();
          }
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        i = paramInt2;
      }
    }
    return i;
  }
  
  private int a(Intent paramIntent, int paramInt)
  {
    if (paramInt == -1) {
      return paramIntent.getIntExtra("param_uinType", -1);
    }
    return paramInt;
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    paramIntent.putExtra("param_notifyid", 275);
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_HIDE_BADGE").setSmallIcon(2130841470).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
    localBuilder.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramIntent);
    if (paramBitmap != null) {
      localBuilder.setLargeIcon(paramBitmap);
    }
    return localBuilder.build();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isOpenNoClearNotification();
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    if ((i >= 512) && (i <= 522)) {
      localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 134217728);
    } else {
      localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildNotification by getActivity. contentIntent=");
      ((StringBuilder)localObject).append(localPendingIntent);
      QLog.i("MobileQQServiceWrapper", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification url :", paramIntent.getStringExtra("url") });
    }
    int k = paramIntent.getIntExtra("uintype", -1);
    i = 2130841470;
    Object localObject = "CHANNEL_ID_SHOW_BADGE";
    if (k == 1008)
    {
      if ((!AppConstants.REMINDER_UIN.equals(paramIntent.getStringExtra("uin"))) && (!paramIntent.getBooleanExtra("activepull_push_flag", false)))
      {
        i = 2130841838;
        break label386;
      }
    }
    else
    {
      if (k == 1030)
      {
        j = paramIntent.getIntExtra("campus_notice_id", 100);
        paramBitmap = BitmapManager.a(BaseApplication.getContext().getResources(), 2130840405);
        localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), j, paramIntent, 268435456);
        if (QLog.isColorLevel()) {
          QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_CAMPUS_NOTICE url :", paramIntent.getStringExtra("url") });
        }
        break label386;
      }
      if ((k == 1035) || (k == 1041) || (k == 1042)) {
        break label310;
      }
    }
    i = 2130841471;
    break label386;
    label310:
    int j = paramIntent.getIntExtra("param_notifyid", 100);
    paramBitmap = BitmapManager.a(BaseApplication.getContext().getResources(), 2130840405);
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), j, paramIntent, 268435456);
    if (QLog.isColorLevel()) {
      QLog.d("PushNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_PUSH_NOTICE url :", paramIntent.getStringExtra("url") });
    }
    localObject = "CHANNEL_ID_OTHER";
    label386:
    boolean bool2 = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    j = i;
    if (bool2)
    {
      j = i;
      if (k == 1010) {
        j = 2130845602;
      }
    }
    if ((bool2) && ((k == 1001) || (k == 10002))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      j = 2130840422;
    }
    if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
      j = 2130842201;
    }
    if ((k != 1045) && (k != 1044))
    {
      paramIntent = (Intent)localObject;
      if (k == 1)
      {
        SdkInfoUtil.isAndroidQ();
        paramIntent = (Intent)localObject;
      }
    }
    else
    {
      paramIntent = "CHANNEL_ID_LIMIT_CHAT";
    }
    paramIntent = NotificationFactory.createNotificationCompatBuilder(paramIntent).setSmallIcon(j).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
    if ((k != 1030) && (k != 1035) && (k != 1041) && (k != 1042) && (bool1)) {
      paramIntent.setOngoing(true);
    }
    if (NotifyLightUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      Calendar.getInstance().get(11);
      paramIntent.setLights(-16711936, 2000, 2000);
    }
    if (this.c)
    {
      if (paramBitmap != null) {
        paramIntent.setLargeIcon(paramBitmap);
      }
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
    }
    else
    {
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent);
      if (paramBitmap != null) {
        paramIntent.setLargeIcon(paramBitmap);
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      paramBitmap = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      paramString1.append("_");
      paramString1.append("heads_up_notify_switch");
      this.b = paramBitmap.getBoolean(paramString1.toString(), true);
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("notify init priority flag, ");
        paramBitmap.append(this.b);
        QLog.i("MobileQQServiceWrapper", 2, paramBitmap.toString());
      }
    }
    if ((Build.VERSION.SDK_INT >= 24) || (this.b)) {
      paramIntent.setPriority(1).setVibrate(new long[0]);
    }
    return paramIntent.build();
  }
  
  private void a(Intent paramIntent, Notification paramNotification)
  {
    Object localObject = paramIntent.getStringExtra("param_fromuin");
    int i = paramIntent.getIntExtra("uintype", -1);
    int j = a(paramIntent, i);
    if (paramIntent.getBooleanExtra("qav_notify_flag", false))
    {
      a(paramIntent, paramNotification, 236);
      return;
    }
    if (i == 1030)
    {
      a(paramIntent, paramNotification, (String)localObject, j);
      return;
    }
    if ((i != 1035) && (i != 1041) && (i != 1042))
    {
      a(paramIntent, i);
      localObject = this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
      if (localObject != null) {
        ((QQNotificationManager)localObject).cancel("MobileQQServiceWrapper.showMsgNotification", 275);
      }
      a(paramIntent, paramNotification, 265);
      return;
    }
    c(paramIntent, paramNotification);
  }
  
  private void a(Intent paramIntent, Notification paramNotification, String paramString, int paramInt)
  {
    paramIntent.getStringExtra("campus_notice_tag");
    a(paramIntent, paramNotification, paramIntent.getIntExtra("campus_notice_id", 0));
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("CMD_SHOW_NOTIFIYCATION".equals(str))
    {
      if (!((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).shouldBlockMessageTips())
      {
        c(paramToServiceMsg);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceWrapper", 2, "pcm blocked msg notification");
      }
      return true;
    }
    if ("CMD_IDLE_NOTIFIYCATION".equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearMsgCounter();
      b(paramToServiceMsg);
      return true;
    }
    if ("CMD_STOP_NOTIFIYCATION".equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearMsgCounter();
      a(275);
      return true;
    }
    if ("CMD_CANCLE_NOTIFIYCATION".equals(str))
    {
      b(275);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) && (this.jdField_a_of_type_Int < 3))
    {
      try
      {
        this.c = DeviceInfoUtil.a();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("e = ");
          localStringBuilder2.append(localException.toString());
          QLog.d("MobileQQServiceWrapper", 2, localStringBuilder2.toString());
        }
      }
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      }
      seq = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("MobileQQService has created. mNM=");
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager);
        QLog.i("MobileQQServiceWrapper", 2, localStringBuilder1.toString());
      }
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  private void b(Intent paramIntent, Notification paramNotification)
  {
    Object localObject = paramIntent.getStringExtra("param_fromuin");
    int i = paramIntent.getIntExtra("uintype", -1);
    String str = paramIntent.getStringExtra("KEY_FRIEND_UIN");
    int j = a(paramIntent, i);
    boolean bool = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    if ((bool) && (i == 1010))
    {
      a(paramIntent, paramNotification, 272);
      return;
    }
    if (((bool) && (i == 1001)) || (i == 10002))
    {
      a(paramIntent, paramNotification, 268);
      return;
    }
    if (i == 1030)
    {
      a(paramIntent, paramNotification, (String)localObject, j);
      paramNotification = new PushReportController.PushReportItem();
      paramNotification.e = "0X800923F";
      paramNotification.d = "Android系统通知曝光";
      PushReportController.a(paramIntent.getStringExtra("url"), paramNotification);
      PushReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNotification);
      return;
    }
    if ((i != 1035) && (i != 1041) && (i != 1042))
    {
      if (paramIntent.getBooleanExtra("activepull_push_flag", false))
      {
        a(paramIntent, paramNotification, 269);
        return;
      }
      if (i == 3001)
      {
        a(paramIntent, paramNotification, 271);
        return;
      }
      if (paramIntent.getBooleanExtra("qav_notify_flag", false))
      {
        a(paramIntent, paramNotification, 236);
        return;
      }
      a(paramIntent, i);
      if (!NotifyIdManager.a(i, str))
      {
        localObject = this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
        if (localObject != null) {
          ((QQNotificationManager)localObject).cancel("MobileQQServiceWrapper.showMsgNotification", 275);
        }
        a(paramIntent, paramNotification, 265);
      }
    }
    else
    {
      c(paramIntent, paramNotification);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = paramToServiceMsg.extraData.getStringArray("cmds");
    if (localObject.length != 3) {
      return;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    paramToServiceMsg = a((Intent)paramToServiceMsg.extraData.getParcelable("intent"), localBitmap, localObject[1], localObject[2]);
    paramToServiceMsg.flags = 34;
    b();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showNotCancelNotification nf=");
    ((StringBuilder)localObject).append(paramToServiceMsg);
    QLog.i("MobileQQServiceWrapper", 1, ((StringBuilder)localObject).toString());
    a(275, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
  }
  
  private void c(Intent paramIntent, Notification paramNotification)
  {
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    PushNoticeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("push_notice_service_id"), paramIntent.getStringExtra("push_notice_content_id"), paramIntent.getStringExtra("url"), "0X800923F", "Android系统通知曝光");
    a(paramIntent, paramNotification, i);
    if (Build.VERSION.SDK_INT >= 19) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudio();
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    Intent localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
    paramToServiceMsg = a(paramToServiceMsg, localIntent);
    if (paramToServiceMsg == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent())
    {
      b(localIntent, paramToServiceMsg);
      return;
    }
    a(localIntent, paramToServiceMsg);
  }
  
  @Nullable
  Notification a(ToServiceMsg paramToServiceMsg, Intent paramIntent)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return null;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    if (!MobileIssueSettings.e)
    {
      paramToServiceMsg = KapalaiAdapterUtil.a();
      localObject = arrayOfString[0];
      String str1 = arrayOfString[1];
      String str2 = arrayOfString[2];
      bool = this.c;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramToServiceMsg = paramToServiceMsg.a(paramIntent, localBitmap, (String)localObject, str1, str2, bool, localQQAppInterface, localQQAppInterface.isOpenNoClearNotification());
    }
    else if (MobileIssueSettings.m)
    {
      localObject = a(paramIntent, null, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAndroidInternalId("icon");
      paramToServiceMsg = (ToServiceMsg)localObject;
      if (i > 0)
      {
        paramToServiceMsg = (ToServiceMsg)localObject;
        if (((Notification)localObject).contentView != null)
        {
          ((Notification)localObject).contentView.setImageViewBitmap(i, localBitmap);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
      }
    }
    else
    {
      paramToServiceMsg = a(paramIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
    }
    paramToServiceMsg.deleteIntent = a(paramIntent);
    b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
    Object localObject = new Intent("com.tencent.msg.newmessage");
    ((Intent)localObject).setPackage("com.tencent.mobileqq");
    ((Intent)localObject).putExtra("cmds", arrayOfString);
    ((Intent)localObject).putExtra("intent", paramIntent);
    ((Intent)localObject).putExtra("type", 0);
    ((Intent)localObject).putExtra("bitmap", localBitmap);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
    OfficialAccountReporter.a.a(bool, paramIntent);
    return paramToServiceMsg;
  }
  
  public PendingIntent a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("param_notifyid", 0);
      paramIntent = new Intent(BaseApplication.getContext(), NotificationDeleteReceiver.class);
      paramIntent.putExtra("uin", str);
      paramIntent.putExtra("param_notifyid", i);
      return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, paramIntent, 268435456);
    }
    return null;
  }
  
  QQNotificationManager a()
  {
    return this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  }
  
  public void a()
  {
    a(true);
  }
  
  void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQServiceWrapper.stopForegroundCompat", paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void a(int paramInt1, Notification paramNotification, String paramString, int paramInt2)
  {
    a(null, paramInt1, paramNotification, paramString, paramInt2);
  }
  
  void a(Intent paramIntent, int paramInt)
  {
    if ((paramInt == 0) && (paramIntent.getBooleanExtra("key_reactive_push_tip", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
    }
  }
  
  public void a(Intent paramIntent, Notification paramNotification, int paramInt)
  {
    String str = paramIntent.getStringExtra("param_fromuin");
    int i = paramIntent.getIntExtra("uintype", -1);
    int j = a(paramIntent, i);
    paramIntent = this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
    if (paramIntent != null) {
      paramIntent.cancel("MobileQQServiceWrapper.showMsgNotification", paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] MobileQQServiceWrapper", 2, new Object[] { "[notify] generateNotificationAfterCancel: invoked. ", " reportUinType: ", Integer.valueOf(j), " uinType: ", Integer.valueOf(i), " notifyId: ", Integer.valueOf(paramInt) });
    }
    a(paramInt, paramNotification, str, j);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (!((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).shouldBlockMessageTips())
    {
      Intent localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
      paramToServiceMsg = a(paramToServiceMsg, localIntent);
      if (localIntent != null)
      {
        if (paramToServiceMsg == null) {
          return;
        }
        int j = localIntent.getIntExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", -113);
        int i;
        if (j != -113) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          a(localIntent, paramToServiceMsg, j);
          return;
        }
        QQNotificationManager localQQNotificationManager = a();
        if (localQQNotificationManager != null) {
          localQQNotificationManager.cancel("MobileQQServiceWrapper.showMsgNotification", 275);
        }
        a(localIntent, localIntent.getIntExtra("uintype", -1));
        a(localIntent, paramToServiceMsg, 265);
        return;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MobileQQServiceWrapper", 2, "pcm blocked msg notification");
    }
  }
  
  void a(String paramString1, int paramInt1, Notification paramNotification, String paramString2, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        QCallFacade localQCallFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCallFacade();
        if (localQCallFacade == null) {
          break label339;
        }
        i = localQCallFacade.a();
        if (localObject == null) {
          break label345;
        }
        j = ((QQMessageFacade)localObject).b();
        if (!TextUtils.isEmpty(paramString1)) {
          break label361;
        }
        if (paramInt1 != 265) {
          if ((paramInt1 < 512) || (paramInt1 > 522)) {
            break label351;
          }
        }
        i = a(paramInt1, (QQMessageFacade)localObject, j);
      }
      catch (Throwable paramString1)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          break label338;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startForegroundCompat changeMI6Badge count=");
        ((StringBuilder)localObject).append(j);
        QLog.i("BadgeUtilImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (BadgeUtils.a(BaseApplicationImpl.getApplication().getApplicationContext())) {
        BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), j, paramNotification);
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notifyUseTag("MobileQQServiceWrapper.startForegroundCompat", paramString1, paramNotification, this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.createNotifyBundle(paramInt1, paramString2, paramInt2));
        return;
      }
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("MobileQQServiceWrapper.startForegroundCompat", paramNotification, this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.createNotifyBundle(paramInt1, paramString2, paramInt2));
      return;
      paramNotification = new StringBuilder();
      paramNotification.append("startForegroundCompat exception. id=");
      paramNotification.append(paramInt1);
      paramNotification.append(", mNM=");
      paramNotification.append(this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager);
      QLog.i("MobileQQServiceWrapper", 2, paramNotification.toString(), paramString1);
      return;
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("startForegroundCompat. id=");
        paramString1.append(paramInt1);
        paramString1.append(", mNM=");
        paramString1.append(this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager);
        QLog.i("MobileQQServiceWrapper", 2, paramString1.toString());
      }
      label338:
      return;
      label339:
      int i = 0;
      continue;
      label345:
      int j = 0;
      continue;
      label351:
      if (paramInt1 != 236) {
        label361:
        i = 1;
      }
      j = i;
      if (paramInt1 >= 482)
      {
        j = i;
        if (paramInt1 <= 511) {
          j = 0;
        }
      }
      if (paramInt1 == 266) {
        j = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  void b(int paramInt)
  {
    QQNotificationManager localQQNotificationManager = this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
    if (localQQNotificationManager != null) {
      localQQNotificationManager.cancel("MobileQQServiceWrapper.cancelNotification", paramInt);
    }
  }
  
  public void destroy()
  {
    a(false);
    a(275);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQServiceWrapper", 2, "MobileQQServiceWrapper has destroyed.");
    }
    super.destroy();
  }
  
  public AppInterface getAppInterface()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return TempServlet.class;
  }
  
  public UniPacket getUniPacketClient(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MobileQQServiceWrapper", 2, "stream ptt");
      }
      String str = paramToServiceMsg.extraData.getString("filepath");
      UniPacket localUniPacket = (UniPacket)jdField_a_of_type_JavaUtilHashMap.get(str);
      Object localObject;
      if (localUniPacket == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("no saved packet, new one ");
          ((StringBuilder)localObject).append(str);
          QLog.d("MobileQQServiceWrapper", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new PttUniPacket(true);
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
      }
      else
      {
        localObject = localUniPacket;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("got last packet, reuse it ");
          ((StringBuilder)localObject).append(str);
          QLog.d("MobileQQServiceWrapper", 2, ((StringBuilder)localObject).toString());
          localObject = localUniPacket;
        }
      }
      int i = paramToServiceMsg.extraData.getShort("PackSeq");
      int j = StreamDataManager.b(str);
      if (i <= j)
      {
        jdField_a_of_type_JavaUtilHashMap.remove(str);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("last stream, remove ");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(", ");
          paramToServiceMsg.append(i);
          QLog.d("MobileQQServiceWrapper", 2, paramToServiceMsg.toString());
        }
      }
      return localObject;
    }
    return super.getUniPacketClient(paramToServiceMsg);
  }
  
  public void handleNoProtocolCoder(ToServiceMsg paramToServiceMsg)
  {
    if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd()))
    {
      QLog.i("MobileQQServiceWrapper", 1, "infoSync error! lookupCoder is null!");
      paramToServiceMsg = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.notifyUI(4004, false, null);
        QLog.i("MobileQQServiceWrapper", 1, "handleNoProtocolCoder, notifyUI");
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if ((this.coderMap != null) && (this.coderMap.keySet().size() > 0)) {
        paramToServiceMsg.put("param_coderMap", this.coderMap.keySet().toString());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "prxyLookupCoderNull", true, 0L, 0L, paramToServiceMsg, null);
    }
  }
  
  public void handleResponse(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    LoadingStateManager.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    super.handleResponse(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public void realHandleRequest(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (a(paramToServiceMsg)) {
      return;
    }
    super.realHandleRequest(paramToServiceMsg, TempServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQServiceExtend
 * JD-Core Version:    0.7.0.1
 */