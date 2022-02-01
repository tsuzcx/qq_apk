package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.PushReportController;
import com.tencent.mobileqq.statistics.PushReportController.PushReportItem;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x935.FriendRecommendPushExtData.LockScreenPushExtData;
import tencent.im.pushsvr.pushsvrExt.ExtData;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.ClientReport;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.PushPlatform;

public class PushNoticeManager
  implements Handler.Callback, Manager
{
  final SparseArray<Integer> a;
  private AtomicBoolean b = new AtomicBoolean(false);
  private AtomicInteger c = new AtomicInteger(0);
  private QQAppInterface d;
  private RecentItemNoticeData e;
  private MessageForText f;
  private long g;
  private short h;
  private long i;
  private WeakReferenceHandler j = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
  
  public PushNoticeManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.a = new SparseArray();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    PushReportController.PushReportItem localPushReportItem = new PushReportController.PushReportItem();
    localPushReportItem.e = paramString4;
    localPushReportItem.d = paramString5;
    localPushReportItem.f = paramString1;
    localPushReportItem.i = paramString2;
    PushReportController.a(paramString3, localPushReportItem);
    PushReportController.a(paramQQAppInterface, localPushReportItem);
  }
  
  private boolean a(SubMsgType0x27.PushPlatform paramPushPlatform, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    boolean bool1;
    if (paramInt != 1041)
    {
      if (paramInt != 1042) {
        return true;
      }
      localObject = (CTEntryMng)this.d.getManager(QQManagerFactory.CTENTRY_MNG);
      if (localObject != null)
      {
        bool2 = ((CTEntryMng)localObject).d();
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("PushNoticeManager", 2, "getSPSwitchState user closed");
            bool1 = bool2;
          }
        }
      }
      else
      {
        bool1 = false;
      }
      if (!bool1)
      {
        paramPushPlatform = a(paramPushPlatform);
        localObject = new FriendRecommendPushExtData.LockScreenPushExtData();
        if ((paramPushPlatform != null) && (paramPushPlatform.length > 0))
        {
          try
          {
            ((FriendRecommendPushExtData.LockScreenPushExtData)localObject).mergeFrom(paramPushPlatform);
          }
          catch (Exception paramPushPlatform)
          {
            paramPushPlatform.printStackTrace();
          }
          if (((FriendRecommendPushExtData.LockScreenPushExtData)localObject).rpt_msg_persons.has()) {
            paramPushPlatform = ((FriendRecommendPushExtData.LockScreenPushExtData)localObject).rpt_msg_persons.get();
          } else {
            paramPushPlatform = null;
          }
          int k;
          if (((FriendRecommendPushExtData.LockScreenPushExtData)localObject).uint32_push_timestamp.has()) {
            k = ((FriendRecommendPushExtData.LockScreenPushExtData)localObject).uint32_push_timestamp.get();
          } else {
            k = 0;
          }
          localObject = MayKnowRecommend.covServerDataToLocal(paramPushPlatform, k);
          if (((ArrayList)localObject).size() > 0)
          {
            paramBundle.putSerializable("may_know_recmmds", (Serializable)localObject);
            paramBundle.putInt("param_push_uinType", paramInt);
            bool1 = true;
          }
          else
          {
            bool1 = false;
          }
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break label523;
          }
          paramPushPlatform = new StringBuilder("handleExtData pushfrds:");
          paramBundle = ((ArrayList)localObject).iterator();
          while (paramBundle.hasNext())
          {
            localObject = (MayKnowRecommend)paramBundle.next();
            paramPushPlatform.append(" ");
            paramPushPlatform.append(((MayKnowRecommend)localObject).uin);
          }
          QLog.i("PushNoticeManager", 2, paramPushPlatform.toString());
          bool2 = bool1;
          break label523;
        }
      }
    }
    do
    {
      bool2 = false;
      break;
      localObject = a(paramPushPlatform);
      paramPushPlatform = new pushsvrExt.ExtData();
    } while ((localObject == null) || (localObject.length <= 0));
    try
    {
      paramPushPlatform.mergeFrom((byte[])localObject);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    long l;
    if (paramPushPlatform.uint64_to_uin.has()) {
      l = paramPushPlatform.uint64_to_uin.get();
    } else {
      l = 0L;
    }
    if ((l > 0L) && (paramPushPlatform.str_remark.has()))
    {
      paramBundle.putString("uinname", paramPushPlatform.str_remark.get().toStringUtf8());
      paramBundle.putString("param_fromuin", String.valueOf(l));
      paramBundle.putString("param_push_fromuin", String.valueOf(l));
      paramBundle.putInt("param_push_uinType", paramInt);
      paramBundle.putString("param_push_fromuin", String.valueOf(l));
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      if (paramPushPlatform.str_remark.has()) {
        paramPushPlatform = paramPushPlatform.str_remark.get().toStringUtf8();
      } else {
        paramPushPlatform = "";
      }
      QLog.i("PushNoticeManager", 2, String.format("handleExtData uin=%d nick=%s", new Object[] { Long.valueOf(l), paramPushPlatform }));
    }
    boolean bool2 = bool1;
    label523:
    if (QLog.isColorLevel()) {
      QLog.i("PushNoticeManager", 2, String.format("handleExtData uinType=%d valid=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool2) }));
    }
    return bool2;
  }
  
  private byte[] a(SubMsgType0x27.PushPlatform paramPushPlatform)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (paramPushPlatform.bytes_ext_data.has()) {
        localObject1 = paramPushPlatform.bytes_ext_data.get().toByteArray();
      }
    }
    catch (Exception paramPushPlatform)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("PushNoticeManager", 2, paramPushPlatform.getMessage(), paramPushPlatform);
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PushNoticeManager", 2, String.format("getExtBytes extBytes=%s", new Object[] { Arrays.toString((byte[])localObject1) }));
    }
    return localObject1;
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("push_notice_unlock", false)) {
      paramContext.startActivity(new Intent(paramContext, QQLSUnlockActivity.class));
    }
  }
  
  public void a()
  {
    if (!this.b.get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushNoticeManager", 2, "nothing to show");
      }
      return;
    }
    if (this.e == null)
    {
      QLog.w("PushNoticeManager", 1, "recent data is null");
      return;
    }
    this.j.sendEmptyMessageDelayed(1, 30000L);
  }
  
  public void a(long paramLong, String arg3, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, Bundle paramBundle)
  {
    if (!QQNotificationManager.getInstance().areNotificationsEnabled(this.d.getApp()))
    {
      QLog.i("PushNoticeManager", 1, "notifications are disabled");
      return;
    }
    if (!SettingCloneUtil.readValue(this.d.getApp(), this.d.getCurrentUin(), null, "qqsetting_show_push_message", true))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushNoticeManager", 2, "show push notice switch off");
      }
      return;
    }
    if (FriendsStatusUtil.a(this.d.getApp()))
    {
      QLog.i("PushNoticeManager", 1, "do not disturb");
      return;
    }
    Intent localIntent = new Intent(this.d.getApp(), SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("main_tab_id", 4);
    localIntent.setFlags(603979776);
    localIntent.putExtra("forward", paramInt1);
    paramInt1 = (Integer.valueOf(paramString4).intValue() - 1000) % 30;
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    paramInt1 += 482;
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("from", "push_notice");
    localIntent.putExtra("uintype", paramInt2);
    localIntent.putExtra("param_fromuin", String.valueOf(paramLong));
    localIntent.putExtra("param_uinType", paramInt2);
    localIntent.putExtra("param_notifyid", paramInt1);
    localIntent.putExtra("push_notice_tag", "push_notification_tag");
    localIntent.putExtra("param_push_notifyid", paramInt1);
    localIntent.putExtra("push_notice_service_id", paramString4);
    localIntent.putExtra("push_notice_content_id", paramString5);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder();
      paramString4.append("onReceiveNotice notifyid");
      paramString4.append(paramInt1);
      paramString4.append("notifyUI url:");
      QLog.d("PushNoticeManager", 2, new Object[] { paramString4.toString(), paramString2 });
    }
    paramString2 = BaseApplicationImpl.getContext();
    boolean bool = QQUtils.a(paramString2);
    if ((!this.d.isBackgroundPause) && (!this.d.isBackgroundStop) && (!bool))
    {
      if (this.c.incrementAndGet() > 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PushNoticeManager", 2, "delay push notice reach the max retry");
        }
        return;
      }
      ??? = this.e;
      if (??? != null) {
        ???.a(localIntent);
      }
      this.b.set(true);
      return;
    }
    this.b.set(false);
    this.c.set(0);
    paramString4 = this.e;
    if (paramString4 != null) {
      paramString4.a(localIntent);
    }
    paramString4 = new ToServiceMsg("mobileqq.service", this.d.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
    paramString4.extraData.putStringArray("cmds", new String[] { ???, paramString3, ??? });
    paramString4.extraData.putParcelable("intent", localIntent);
    paramString4.extraData.putParcelable("bitmap", null);
    this.d.sendToService(paramString4);
    synchronized (this.a)
    {
      this.a.put(paramInt1, Integer.valueOf(paramInt2));
      if (bool)
      {
        ??? = (QQLSRecentManager)this.d.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        if (SettingCloneUtil.readValue(paramString2, this.d.getCurrentAccountUin(), paramString2.getString(2131891413), "qqsetting_lock_screen_whenexit_key", true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PushNoticeManager", 2, "push notice start lsActivity from appinterface ");
          }
          paramString2 = this.d;
          paramString3 = new StringBuilder();
          paramString3.append(paramLong);
          paramString3.append("");
          ???.a(paramString2, paramString3.toString(), paramInt2, false, paramInt1);
        }
        this.d.getMessageFacade().notifyObservers(b());
      }
      PushNoticeUtil.a(paramInt2, 1);
      return;
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    int m = paramIntent.getIntExtra("forward", -1);
    int k = paramIntent.getIntExtra("param_push_uinType", -1);
    int n = paramIntent.getIntExtra("param_push_notifyid", -1);
    String str1 = paramIntent.getStringExtra("param_push_fromuin");
    a(null, k);
    Intent localIntent;
    if (m != 3)
    {
      if (m == 4)
      {
        if (k == 1041)
        {
          localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), null);
          localIntent.putExtra("uin", str1);
          localIntent.putExtra("uintype", 0);
          localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
          localIntent.putExtra("param_notifyid", n);
          localIntent.putExtra("enterchatwin", true);
          paramContext.startActivity(localIntent);
        }
        else if (k == 1042)
        {
          localIntent = new Intent(paramContext, RecommendFriendActivity.class);
          localIntent.putExtra("EntranceId", 9);
          localIntent.putExtra("param_notifyid", n);
          localIntent.putExtra("may_know_recmmds", paramIntent.getSerializableExtra("may_know_recmmds"));
          paramContext.startActivity(localIntent);
        }
        b(paramContext, paramIntent);
        paramIntent.removeExtra("forward");
        if (QLog.isColorLevel()) {
          QLog.i("PushNoticeManager", 2, String.format("forward [uinType,notifyId,uin]=[%d,%d,%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), str1 }));
        }
      }
    }
    else
    {
      str1 = paramIntent.getStringExtra("url");
      localIntent = new Intent(paramContext, QQBrowserActivity.class);
      k = paramIntent.getIntExtra("uintype", -1);
      localIntent.putExtra("uintype", k);
      String str2 = paramIntent.getStringExtra("push_notice_service_id");
      String str3 = paramIntent.getStringExtra("push_notice_content_id");
      a(this.d, str2, str3, str1, "0X8009241", "点击业务Push");
      localIntent.putExtra("push_notice_service_id", str2);
      localIntent.putExtra("push_notice_content_id", str3);
      if (QLog.isColorLevel()) {
        QLog.d("PushNoticeManager", 2, "remove push notice");
      }
      localIntent.putExtra("url", str1);
      paramContext.startActivity(localIntent);
      b(paramContext, paramIntent);
      paramIntent.removeExtra("forward");
    }
    ThreadManager.post(new PushNoticeManager.1(this, k), 5, null, true);
  }
  
  public void a(QQNotificationManager paramQQNotificationManager, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setRead ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PushNoticeManager", 2, ((StringBuilder)localObject1).toString());
    }
    this.j.removeMessages(1);
    this.b.set(false);
    this.e = null;
    Object localObject1 = paramQQNotificationManager;
    if (paramQQNotificationManager == null) {}
    for (;;)
    {
      try
      {
        localObject1 = QQNotificationManager.getInstance();
        paramQQNotificationManager = this.a;
        int k = 0;
        try
        {
          if (k < this.a.size())
          {
            Integer localInteger1 = Integer.valueOf(this.a.keyAt(k));
            Integer localInteger2 = (Integer)this.a.valueAt(k);
            if ((localInteger1 != null) && ((paramInt < 0) || (localInteger2 == null) || (localInteger2.intValue() == paramInt)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("PushNoticeManager", 2, String.format(Locale.getDefault(), "cancel push_notice [%d, %s]", new Object[] { Integer.valueOf(localInteger1.intValue()), "push_notification_tag" }));
              }
              ((QQNotificationManager)localObject1).cancelUseTag("PushNoticeManager_removeNotification", "push_notification_tag", localInteger1.intValue());
            }
          }
          else
          {
            this.a.clear();
            return;
          }
        }
        finally {}
        k += 1;
      }
      catch (Exception paramQQNotificationManager)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, "setRead", paramQQNotificationManager);
        }
        return;
      }
    }
  }
  
  public void a(SubMsgType0x27.MsgBody paramMsgBody, short paramShort, long paramLong)
  {
    if (paramMsgBody != null)
    {
      if (paramMsgBody.msg_push_platform == null) {
        return;
      }
      if ((paramShort == this.h) && (paramLong == this.i))
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("skip duplicated msg: ");
        paramMsgBody.append(paramShort);
        paramMsgBody.append(", ");
        paramMsgBody.append(paramLong);
        QLog.w("PushNoticeManager", 1, paramMsgBody.toString());
        return;
      }
      this.h = paramShort;
      this.i = paramLong;
      SubMsgType0x27.PushPlatform localPushPlatform = paramMsgBody.msg_push_platform;
      int k = localPushPlatform.uint32_forward_type.get();
      if (k == 0) {
        k = 3;
      } else if (k == 1) {
        k = 4;
      } else {
        k = 0;
      }
      if (k == 0)
      {
        paramMsgBody = new StringBuilder();
        paramMsgBody.append("unknown forward type: ");
        paramMsgBody.append(k);
        QLog.w("PushNoticeManager", 1, paramMsgBody.toString());
        return;
      }
      Object localObject3 = paramMsgBody.msg_client_report;
      paramLong = localPushPlatform.uint64_from_uin.get();
      this.g = paramLong;
      boolean bool = localPushPlatform.str_desc.has();
      Object localObject1 = null;
      String str;
      if (bool) {
        str = localPushPlatform.str_desc.get();
      } else {
        str = null;
      }
      if (localPushPlatform.str_target_url.has())
      {
        paramMsgBody = localPushPlatform.str_target_url.get();
        if (!TextUtils.isEmpty(paramMsgBody)) {
          try
          {
            paramMsgBody = new String(Base64.b(paramMsgBody), "UTF-8");
          }
          catch (Exception paramMsgBody)
          {
            QLog.e("PushNoticeManager", 1, paramMsgBody, new Object[0]);
            break label284;
          }
        } else {
          break label286;
        }
      }
      label284:
      paramMsgBody = null;
      label286:
      if (localPushPlatform.str_title.has()) {
        localObject1 = localPushPlatform.str_title.get();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.i("PushNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [uin: %d wording: %s url: %s from: %s oriUrl:%s", new Object[] { Long.valueOf(paramLong), str, paramMsgBody, localObject2, localPushPlatform.str_target_url.get() }));
      }
      if (!TextUtils.isEmpty(str))
      {
        if (TextUtils.isEmpty(paramMsgBody)) {
          return;
        }
        int m = 1035;
        if (4 == k)
        {
          if (TextUtils.equals(paramMsgBody, "newfrd_add")) {
            m = 1041;
          }
          if (TextUtils.equals(paramMsgBody, "newfrd_recommand")) {
            m = 1042;
          }
        }
        else
        {
          m = 1035;
        }
        PushNoticeUtil.a(m, 0);
        localObject1 = new Bundle();
        try
        {
          bool = a(localPushPlatform, (Bundle)localObject1, m);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PushNoticeManager", 2, localException.getMessage(), localException);
          }
          bool = false;
        }
        if (!bool) {
          return;
        }
        if (m == 1041)
        {
          paramLong = Long.valueOf(((Bundle)localObject1).getString("param_fromuin")).longValue();
          this.g = paramLong;
        }
        if (QLog.isColorLevel()) {
          QLog.i("PushNoticeManager", 2, String.format("onReceiveNotice [uinType,uin]=[%d,%d]", new Object[] { Integer.valueOf(m), Long.valueOf(paramLong) }));
        }
        this.j.removeMessages(1);
        PushReportController.PushReportItem localPushReportItem = new PushReportController.PushReportItem();
        localPushReportItem.e = "0X800923D";
        localPushReportItem.d = "收到Push协议";
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((SubMsgType0x27.ClientReport)localObject3).uint32_service_id.get());
        ((StringBuilder)localObject4).append("");
        localPushReportItem.f = ((StringBuilder)localObject4).toString();
        localPushReportItem.i = ((SubMsgType0x27.ClientReport)localObject3).str_content_id.get();
        PushReportController.a(paramMsgBody, localPushReportItem);
        PushReportController.a(this.d, localPushReportItem);
        long l = MessageCache.c();
        localObject3 = new RecentUser();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramLong);
        ((StringBuilder)localObject4).append("");
        ((RecentUser)localObject3).uin = ((StringBuilder)localObject4).toString();
        ((RecentUser)localObject3).msgType = m;
        ((RecentUser)localObject3).setType(m);
        localObject4 = this.e;
        if (localObject4 == null)
        {
          this.e = new RecentItemNoticeData((RecentUser)localObject3);
          this.e.a(m, paramLong, str, paramMsgBody, (String)localObject2, l);
          a(paramLong, str, paramMsgBody, (String)localObject2, k, m, localPushReportItem.f, localPushReportItem.i, (Bundle)localObject1);
          return;
        }
        if (!((RecentItemNoticeData)localObject4).b(m, paramLong, str, paramMsgBody, (String)localObject2, l))
        {
          this.e.a(m, paramLong, str, paramMsgBody, (String)localObject2, l);
          a(paramLong, str, paramMsgBody, (String)localObject2, k, m, localPushReportItem.f, localPushReportItem.i, (Bundle)localObject1);
        }
      }
    }
  }
  
  public RecentBaseData b()
  {
    return this.e;
  }
  
  public MessageForText c()
  {
    RecentItemNoticeData localRecentItemNoticeData = this.e;
    if (localRecentItemNoticeData == null) {
      return null;
    }
    Object localObject;
    if (this.f == null)
    {
      this.f = ((MessageForText)MessageRecordFactory.a(-1000));
      localObject = this.f;
      ((MessageForText)localObject).msgtype = -1000;
      ((MessageForText)localObject).istroop = this.e.type;
      localObject = this.f;
      ((MessageForText)localObject).isread = false;
      ((MessageForText)localObject).selfuin = this.d.getCurrentAccountUin();
      localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("");
      ((MessageForText)localObject).senderuin = localStringBuilder.toString();
      localObject = this.f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("");
      ((MessageForText)localObject).frienduin = localStringBuilder.toString();
      this.f.msg = localRecentItemNoticeData.wording;
      this.f.time = localRecentItemNoticeData.time;
    }
    if (localRecentItemNoticeData.type == 1035) {
      localObject = localRecentItemNoticeData.mTitleName;
    } else {
      localObject = localRecentItemNoticeData.wording;
    }
    if ((this.f.msg == null) || (!this.f.msg.equals(localObject))) {
      this.f.msg = ((String)localObject);
    }
    if (this.f.time != localRecentItemNoticeData.time) {
      this.f.time = localRecentItemNoticeData.time;
    }
    return this.f;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = this.e;
    if (paramMessage == null)
    {
      QLog.e("PushNoticeManager", 1, "recent data is null");
      return true;
    }
    a(paramMessage.uin, this.e.wording, this.e.url, this.e.from, this.e.intent.getIntExtra("forward", -1), 0, this.e.intent.getStringExtra("push_notice_service_id"), this.e.intent.getStringExtra("push_notice_content_id"), null);
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PushNoticeManager", 2, "onDestroy");
    }
    a(null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.PushNoticeManager
 * JD-Core Version:    0.7.0.1
 */