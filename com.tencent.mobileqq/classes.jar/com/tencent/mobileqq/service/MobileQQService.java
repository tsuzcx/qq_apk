package com.tencent.mobileqq.service;

import ahiz;
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
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.biz.bmqq.protocol.BmqqBusinessService;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.compatible.ActionListener;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.now.NowProtocolCoder;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService;
import com.tencent.mobileqq.service.cardpay.CardPayService;
import com.tencent.mobileqq.service.config.ConfigService;
import com.tencent.mobileqq.service.discussion.DiscussionService;
import com.tencent.mobileqq.service.friendlist.FriendListService;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.message.MessageService;
import com.tencent.mobileqq.service.profile.ProfileService;
import com.tencent.mobileqq.service.push.PushService;
import com.tencent.mobileqq.service.qwallet.QWalletAuthService;
import com.tencent.mobileqq.service.qwallet.UniPayService;
import com.tencent.mobileqq.service.qwallet.VIPRecommendService;
import com.tencent.mobileqq.service.qzone.QZoneService;
import com.tencent.mobileqq.service.report.ReportService;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
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
import com.tencent.util.notification.NotificationFactory;
import com.tencent.util.notification.QQNotificationManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class MobileQQService
  extends MobileQQServiceBase
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActionListener jdField_a_of_type_ComTencentMobileqqCompatibleActionListener = new ahiz(this);
  private QQNotificationManager jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  public boolean a;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public MobileQQService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    Notification localNotification;
    int i;
    if (!MobileIssueSettings.e)
    {
      localNotification = KapalaiAdapterUtil.a().a(BaseApplication.getContext(), 2130839532);
      paramIntent = localNotification;
      if (QLog.isColorLevel())
      {
        QLog.i("MobileQQService", 2, "buildIdleNotification by newNotificationForMeizu. nf=" + localNotification);
        paramIntent = localNotification;
      }
      paramIntent.icon = 2130839532;
      if (!this.c) {
        break label193;
      }
      if (paramBitmap != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        if ((i > 0) && (paramIntent.contentView != null)) {
          paramIntent.contentView.setImageViewBitmap(i, paramBitmap);
        }
      }
      paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
    }
    label193:
    do
    {
      do
      {
        return paramIntent;
        localNotification = NotificationFactory.a("CHANNEL_ID_HIDE_BADGE", 2130839532, null, System.currentTimeMillis());
        localNotification.contentView = null;
        paramIntent = localNotification;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MobileQQService", 2, "buildIdleNotification by default. nf=" + localNotification);
        paramIntent = localNotification;
        break;
        paramIntent.setLatestEventInfo(BaseApplication.getContext(), paramString1, paramString2, localPendingIntent);
      } while (paramBitmap == null);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
    } while ((i <= 0) || (paramIntent.contentView == null));
    paramIntent.contentView.setImageViewBitmap(i, paramBitmap);
    return paramIntent;
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    PendingIntent localPendingIntent2 = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "buildNotification by getActivity. contentIntent=" + localPendingIntent2);
    }
    int j = 2130839533;
    int i;
    PendingIntent localPendingIntent1;
    Bitmap localBitmap;
    if (paramIntent.getIntExtra("uintype", -1) == 1008)
    {
      i = j;
      localPendingIntent1 = localPendingIntent2;
      localBitmap = paramBitmap;
      if (!AppConstants.t.equals(paramIntent.getStringExtra("uin")))
      {
        if (paramIntent.getBooleanExtra("activepull_push_flag", false))
        {
          localBitmap = paramBitmap;
          localPendingIntent1 = localPendingIntent2;
          i = j;
        }
      }
      else
      {
        boolean bool2 = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
        j = i;
        if (bool2)
        {
          j = i;
          if (paramIntent.getIntExtra("uintype", -1) == 1010) {
            j = 2130842665;
          }
        }
        if ((!bool2) || ((paramIntent.getIntExtra("uintype", -1) != 1001) && (paramIntent.getIntExtra("uintype", -1) != 10002))) {
          break label538;
        }
        i = 1;
        label190:
        if (i != 0) {
          j = 2130839198;
        }
        if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
          j = 2130840216;
        }
        paramIntent = NotificationFactory.a("").setSmallIcon(j).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
        if (bool1) {
          paramIntent.setOngoing(true);
        }
        if (NotifyLightUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          Calendar.getInstance().get(11);
          paramIntent.setLights(-16711936, 2000, 2000);
        }
        if (!this.c) {
          break label544;
        }
        if (localBitmap != null) {
          paramIntent.setLargeIcon(localBitmap);
        }
        paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent1);
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Boolean = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_" + "heads_up_notify_switch", true);
        if (QLog.isColorLevel()) {
          QLog.i("MobileQQService", 2, "notify init priority flag, " + this.jdField_b_of_type_Boolean);
        }
      }
      if ((Build.VERSION.SDK_INT >= 24) || (this.jdField_b_of_type_Boolean)) {
        paramIntent.setPriority(1).setVibrate(new long[0]);
      }
      return paramIntent.build();
      i = 2130839745;
      localPendingIntent1 = localPendingIntent2;
      localBitmap = paramBitmap;
      break;
      i = j;
      localPendingIntent1 = localPendingIntent2;
      localBitmap = paramBitmap;
      if (paramIntent.getIntExtra("uintype", -1) != 1030) {
        break;
      }
      j = paramIntent.getIntExtra("campus_notice_id", 100);
      paramBitmap = BaseApplication.getContext();
      i = 2130839532;
      localBitmap = BitmapManager.a(paramBitmap.getResources(), 2130839189);
      localPendingIntent1 = PendingIntent.getActivity(BaseApplication.getContext(), j, paramIntent, 1073741824);
      break;
      label538:
      i = 0;
      break label190;
      label544:
      paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent(localPendingIntent1);
      if (localBitmap != null) {
        paramIntent.setLargeIcon(localBitmap);
      }
    }
  }
  
  private PendingIntent a()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), NotificationDeleteReceiver.class);
    return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 268435456);
  }
  
  private void a(boolean paramBoolean) {}
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    paramToServiceMsg = a((Intent)paramToServiceMsg.extraData.getParcelable("intent"), localBitmap, arrayOfString[1], arrayOfString[2]);
    paramToServiceMsg.flags = 34;
    b();
    a(119, paramToServiceMsg);
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Intent localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    boolean bool = localIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    if (!MobileIssueSettings.e)
    {
      paramToServiceMsg = KapalaiAdapterUtil.a().a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2], this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramToServiceMsg.deleteIntent = a();
      b();
      if (!SettingCloneUtil.readValue(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), BaseApplication.getContext().getString(2131434185), "qqsetting_notify_showcontent_key", true)) {
        break label842;
      }
      if (localIntent.getIntExtra("uintype", -1) != 1008) {
        break label331;
      }
      if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
        this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 122);
      }
      a(122, paramToServiceMsg);
    }
    label842:
    for (;;)
    {
      paramToServiceMsg = new Intent("com.tencent.msg.newmessage");
      paramToServiceMsg.setPackage("com.tencent.mobileqq");
      paramToServiceMsg.putExtra("cmds", arrayOfString);
      paramToServiceMsg.putExtra("intent", localIntent);
      paramToServiceMsg.putExtra("type", 0);
      paramToServiceMsg.putExtra("bitmap", localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramToServiceMsg);
      return;
      int i;
      if (MobileIssueSettings.m)
      {
        paramToServiceMsg = a(localIntent, null, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        if ((i > 0) && (paramToServiceMsg.contentView != null)) {
          paramToServiceMsg.contentView.setImageViewBitmap(i, localBitmap);
        }
        break;
      }
      paramToServiceMsg = a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      break;
      label331:
      if ((bool) && (localIntent.getIntExtra("uintype", -1) == 1010))
      {
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 140);
        }
        a(140, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_DATE_UNREAD notify");
        }
      }
      else if (((bool) && (localIntent.getIntExtra("uintype", -1) == 1001)) || (localIntent.getIntExtra("uintype", -1) == 10002))
      {
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 135);
        }
        a(135, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_LBS_FRIEND_UNREAD notify");
        }
      }
      else if (localIntent.getBooleanExtra("qav_notify_flag", false))
      {
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 129);
        }
        a(129, paramToServiceMsg);
      }
      else if (localIntent.getIntExtra("uintype", -1) == 3001)
      {
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 144);
        }
        a(144, paramToServiceMsg);
      }
      else if (localIntent.getBooleanExtra("_dingdong_notification_schedule_has_flag_", false))
      {
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 193);
        }
        paramToServiceMsg.flags |= 0x20;
        a(193, paramToServiceMsg);
      }
      else if (localIntent.getBooleanExtra("activepull_push_flag", false))
      {
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 194);
        }
        a(194, paramToServiceMsg);
      }
      else
      {
        String str;
        if (localIntent.getIntExtra("uintype", -1) == 1030)
        {
          str = localIntent.getStringExtra("campus_notice_tag");
          i = localIntent.getIntExtra("campus_notice_id", 0);
          Object localObject = new PushReportController.PushReportItem();
          ((PushReportController.PushReportItem)localObject).e = "0X800923F";
          ((PushReportController.PushReportItem)localObject).d = "Android系统通知曝光";
          PushReportController.a(localIntent.getStringExtra("url"), (PushReportController.PushReportItem)localObject);
          PushReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PushReportController.PushReportItem)localObject);
          localObject = (CampusNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(239);
          a(str, i, paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "show campus_notice [%d, %s]", new Object[] { Integer.valueOf(i), str }));
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null)
          {
            this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 121);
            this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 119);
          }
          a(121, paramToServiceMsg);
          continue;
          if (localIntent.getBooleanExtra("qav_notify_flag", false))
          {
            if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
              this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 129);
            }
            a(129, paramToServiceMsg);
          }
          else if (localIntent.getBooleanExtra("_dingdong_notification_schedule_has_flag_", false))
          {
            if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
              this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 193);
            }
            paramToServiceMsg.flags |= 0x20;
            a(193, paramToServiceMsg);
          }
          else if (localIntent.getIntExtra("uintype", -1) == 1030)
          {
            str = localIntent.getStringExtra("campus_notice_tag");
            i = localIntent.getIntExtra("campus_notice_id", 0);
            if (QLog.isColorLevel()) {
              QLog.d("MobileQQService", 2, String.format(Locale.getDefault(), "show campus_notice [%d, %s]", new Object[] { Integer.valueOf(i), str }));
            }
            a(str, i, paramToServiceMsg);
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null)
            {
              this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 121);
              this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.showMsgNotification", 119);
            }
            a(121, paramToServiceMsg);
          }
        }
      }
    }
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      a(new ProfileService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new FriendListService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new MessageService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new LBSService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new QZoneService());
      PushService localPushService = new PushService();
      a(localPushService);
      localPushService.a(this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener);
      a(new ConfigService());
      a(new ReportService());
      a(new DiscussionService());
      a(new RegisterProxySvcPackService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new VIPService());
      a(new CardPayService());
      a(new NowProtocolCoder());
      a(new BmqqBusinessService(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new UniPayService());
      a(new VIPRecommendService());
      a(new VIPAioSendService());
      a(new QWalletAuthService());
      super.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.stopForegroundCompat", paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void a(int paramInt, Notification paramNotification)
  {
    a(null, paramInt, paramNotification);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg)
  {
    LoadingStateManager.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    b(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener, TempServlet.class);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, ActionListener paramActionListener, Class paramClass)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return;
      paramClass = paramToServiceMsg.getServiceCmd();
      if (!"CMD_SHOW_NOTIFIYCATION".equals(paramClass)) {
        break;
      }
      if (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a())
      {
        c(paramToServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MobileQQService", 2, "pcm blocked msg notification");
    return;
    if ("CMD_IDLE_NOTIFIYCATION".equals(paramClass))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.B();
      b(paramToServiceMsg);
      return;
    }
    if ("CMD_STOP_NOTIFIYCATION".equals(paramClass))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.B();
      a(119);
      return;
    }
    if ("CMD_CANCLE_NOTIFIYCATION".equals(paramClass))
    {
      b(119);
      return;
    }
    super.a(paramToServiceMsg, paramActionListener, TempServlet.class);
  }
  
  void a(String paramString, int paramInt, Notification paramNotification)
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {}
    for (;;)
    {
      int i;
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        QCallFacade localQCallFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localQCallFacade == null) {
          break label258;
        }
        i = localQCallFacade.a();
        if (localQQMessageFacade != null) {
          j = localQQMessageFacade.b();
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label252;
        }
        if (paramInt != 121) {
          break label265;
        }
        label65:
        if (QLog.isColorLevel()) {
          QLog.i("BadgeUtilImpl", 2, "startForegroundCompat changeMI6Badge count=" + j);
        }
        if (BadgeUtils.a(BaseApplicationImpl.getApplication().getApplicationContext())) {
          BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), j, paramNotification);
        }
        if (!TextUtils.isEmpty(paramString))
        {
          this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.startForegroundCompat", paramString, paramInt, paramNotification);
          return;
        }
        this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.startForegroundCompat", paramInt, paramNotification);
        return;
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label264;
        }
      }
      QLog.i("MobileQQService", 2, "startForegroundCompat exception. id=" + paramInt + ", mNM=" + this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager, paramString);
      return;
      if (QLog.isColorLevel())
      {
        QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt + ", mNM=" + this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager);
        return;
      }
      label252:
      do
      {
        j = 1;
        break label65;
        i = 0;
        break;
        return;
      } while (paramInt != 129);
      label258:
      label264:
      label265:
      j = i;
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if ((paramException == null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && ("ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
      }
    }
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public void b()
  {
    NotificationManager localNotificationManager = null;
    if ((this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager == null) && (this.jdField_b_of_type_Int < 3)) {}
    try
    {
      this.c = DeviceInfoUtil.a();
      a(true);
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager = QQNotificationManager.a();
      if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a() == null) {
        this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager = null;
      }
      jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("MobileQQService has created. mNM=");
        if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
          localNotificationManager = this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a();
        }
        QLog.i("MobileQQService", 2, localNotificationManager);
      }
      this.jdField_b_of_type_Int += 1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "e = " + localException.toString());
        }
      }
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager.a("MobileQQService.cancelNotification", paramInt);
    }
  }
  
  public void c()
  {
    a(false);
    a(119);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    this.jdField_a_of_type_ComTencentMobileqqCompatibleActionListener = null;
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQService
 * JD-Core Version:    0.7.0.1
 */