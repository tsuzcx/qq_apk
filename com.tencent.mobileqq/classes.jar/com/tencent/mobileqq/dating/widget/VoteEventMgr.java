package com.tencent.mobileqq.dating.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;

public class VoteEventMgr
{
  QQAppInterface a;
  RecentItemVoteData b;
  MessageForText c;
  
  public VoteEventMgr(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private Intent a(Context paramContext)
  {
    String str = String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10002&from_type=0&mode=2&source_id=1001&uid=%s&PUSH_CONTENT=%s", new Object[] { this.a.getCurrentAccountUin(), this.b.mTitleName });
    paramContext = new Intent(paramContext, JumpActivity.class);
    paramContext.setData(Uri.parse(str));
    return paramContext;
  }
  
  private void e()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    boolean bool = QQUtils.a(localBaseApplication);
    Object localObject1;
    if ((this.a.isBackgroundPause) || (this.a.isBackgroundStop) || (bool))
    {
      Object localObject2 = BitmapManager.a(localBaseApplication.getResources(), 2130846962);
      localObject1 = new NotificationCompat.Builder(localBaseApplication).setContentTitle(this.b.mTitleName).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker(this.b.mTitleName).setWhen(System.currentTimeMillis());
      if (localObject2 != null) {
        ((NotificationCompat.Builder)localObject1).setLargeIcon((Bitmap)localObject2);
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject1).setSmallIcon(2130846962);
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject2 = new RemoteViews(localBaseApplication.getPackageName(), 2131627382);
        ((NotificationCompat.Builder)localObject1).setContent((RemoteViews)localObject2);
        ((RemoteViews)localObject2).setCharSequence(2131447463, "setText", this.b.mTitleName);
        ((RemoteViews)localObject2).setCharSequence(2131447345, "setText", TimeFormatterUtils.a(System.currentTimeMillis(), true, "yyyy-MM-dd"));
      }
      localObject2 = a(localBaseApplication);
      ((Intent)localObject2).putExtra("param_notifyid", 240);
      ((NotificationCompat.Builder)localObject1).setContentIntent(PendingIntent.getActivity(localBaseApplication, 0, (Intent)localObject2, 134217728));
      localObject1 = ((NotificationCompat.Builder)localObject1).build();
      ((Notification)localObject1).flags |= 0x10;
      ((Notification)localObject1).defaults |= 0x1;
      ((Notification)localObject1).defaults |= 0x4;
      ((Notification)localObject1).icon = 2130846962;
      localObject2 = QQNotificationManager.getInstance();
      if (localObject2 != null)
      {
        ((QQNotificationManager)localObject2).cancel("nearby_like_notification_tag", 240);
        ((QQNotificationManager)localObject2).notify("nearby_like_notification_tag", 240, (Notification)localObject1);
      }
      ReportController.b(this.a, "CliOper", "", "", "0X80053CD", "0X80053CD", 0, 0, "", "", "", "");
    }
    if (bool)
    {
      localObject1 = (QQLSRecentManager)this.a.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
      if (SettingCloneUtil.readValue(localBaseApplication, this.a.getCurrentAccountUin(), localBaseApplication.getString(2131891413), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface VoteEventMgr.notifyVoteEvent");
        }
        ((QQLSRecentManager)localObject1).a(this.a, AppConstants.VOTE_UIN, 1012, false, MsgPushReportHelper.a(AppConstants.VOTE_UIN, 1012, null));
      }
      this.a.getMessageFacade().notifyObservers(a());
    }
  }
  
  public RecentBaseData a()
  {
    return this.b;
  }
  
  public MessageForText a(RecentBaseData paramRecentBaseData)
  {
    paramRecentBaseData = (RecentItemVoteData)paramRecentBaseData;
    if (this.c == null)
    {
      this.c = ((MessageForText)MessageRecordFactory.a(-1000));
      MessageForText localMessageForText = this.c;
      localMessageForText.msgtype = -1000;
      localMessageForText.istroop = 1012;
      localMessageForText.isread = false;
      localMessageForText.selfuin = this.a.getCurrentAccountUin();
      this.c.senderuin = AppConstants.DATE_UIN;
      this.c.frienduin = AppConstants.DATE_UIN;
      this.c.msg = paramRecentBaseData.mTitleName;
      this.c.time = paramRecentBaseData.time;
    }
    if ((this.c.msg == null) || (!this.c.msg.equals(paramRecentBaseData.mTitleName))) {
      this.c.msg = paramRecentBaseData.mTitleName;
    }
    if (this.c.time != paramRecentBaseData.time) {
      this.c.time = paramRecentBaseData.time;
    }
    return this.c;
  }
  
  public void a(SubMsgType0x6f.MCardNotificationLike paramMCardNotificationLike)
  {
    if ((paramMCardNotificationLike != null) && (paramMCardNotificationLike.str_wording.has())) {
      paramMCardNotificationLike = paramMCardNotificationLike.str_wording.get();
    } else {
      paramMCardNotificationLike = "";
    }
    if (TextUtils.isEmpty(paramMCardNotificationLike)) {
      return;
    }
    long l = MessageCache.c();
    Object localObject = this.b;
    if (localObject == null)
    {
      localObject = new RecentUser(AppConstants.VOTE_UIN, 1012);
      ((RecentUser)localObject).msgType = 1012;
      this.b = new RecentItemVoteData((RecentUser)localObject);
      this.b.a(paramMCardNotificationLike, l);
      e();
      return;
    }
    if ((!((RecentItemVoteData)localObject).mTitleName.equals(paramMCardNotificationLike)) || (this.b.time != l))
    {
      this.b.a(paramMCardNotificationLike, l);
      e();
    }
  }
  
  public void b()
  {
    this.b = null;
    BaseApplicationImpl.getContext();
    QQNotificationManager.getInstance().cancel("nearby_like_notification_tag", 240);
  }
  
  public int c()
  {
    if (this.b == null) {
      return 0;
    }
    return 1;
  }
  
  public void d()
  {
    BaseApplicationImpl.getContext();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null) {
      localQQNotificationManager.cancel("nearby_like_notification_tag", 240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.VoteEventMgr
 * JD-Core Version:    0.7.0.1
 */