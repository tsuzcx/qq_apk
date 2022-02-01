import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class mud
{
  private static Intent a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      }
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
      {
        Intent localIntent = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.b);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
        localIntent.putExtra("uinname", paramQQAppInterface.getTroopDisscussMemberNick(paramMessageRecord.frienduin, paramString, paramMessageRecord.istroop, true));
        return localIntent;
      }
      return a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
    }
    paramMessageRecord = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
    paramMessageRecord.putExtra("tab_index", MainFragment.b);
    paramMessageRecord.putExtra("conversation_index", 1);
    paramMessageRecord.setFlags(335544320);
    paramMessageRecord.putExtra("uinname", paramQQAppInterface.getApp().getString(2131694350));
    return paramMessageRecord;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString))
    {
      paramString = paramContext.getString(2131693029);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
      paramQQAppInterface = AppConstants.LBS_HELLO_UIN;
      if (!aryo.b(paramMessageRecord)) {
        paramQQAppInterface = AppConstants.NEARBY_LBS_HELLO_UIN;
      }
      paramContext.putExtra("uin", paramQQAppInterface);
      paramContext.putExtra("uintype", 1001);
      paramQQAppInterface = paramContext;
      paramContext = paramString;
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("uinname", paramContext);
      return paramQQAppInterface;
      if (String.valueOf(AppConstants.FRIEND_SYSTEM_MSG_UIN).equals(paramString))
      {
        paramString = paramContext.getString(2131719141);
        paramQQAppInterface = new Intent(paramContext, NewFriendActivity.class);
        paramQQAppInterface.putExtra("from", "from_notification");
        paramQQAppInterface.putExtra("EntranceId", 1);
        paramContext = paramString;
      }
      else if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(paramString))
      {
        paramString = paramContext.getString(2131719141);
        paramQQAppInterface = new Intent(paramContext, TroopActivity.class);
        paramQQAppInterface.putExtra("_key_mode", 1);
        paramQQAppInterface.putExtra("key_tab_mode", 2);
        paramContext = paramString;
      }
      else if (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString))
      {
        paramQQAppInterface = new Intent(paramContext, QQBroadcastActivity.class);
        paramContext = paramContext.getString(2131719140);
      }
      else if (String.valueOf(AppConstants.VOTE_MSG_UIN).equals(paramString))
      {
        paramString = paramContext.getString(2131719141);
        paramContext = new Intent(paramContext, VisitorsActivity.class);
        paramContext.putExtra("votersOnly", true);
        paramContext.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
        paramQQAppInterface = paramContext;
        paramContext = paramString;
      }
      else if (String.valueOf(AppConstants.DATALINE_PC_UIN).equals(paramString))
      {
        paramQQAppInterface = new Intent(paramContext, LiteActivity.class);
        paramQQAppInterface.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
        paramContext = paramContext.getString(2131693667);
      }
      else
      {
        if (!String.valueOf(AppConstants.DATALINE_IPAD_UIN).equals(paramString)) {
          break;
        }
        paramQQAppInterface = new Intent(paramContext, LiteActivity.class);
        paramQQAppInterface.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
        paramContext = paramContext.getString(2131693668);
      }
    }
    Object localObject = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.b);
    ((Intent)localObject).putExtra("conversation_index", 1);
    ((Intent)localObject).setFlags(335544320);
    if (paramInt == 7000)
    {
      paramMessageRecord = paramContext.getString(2131719045);
      ((Intent)localObject).setClass(paramContext, AssociatedAccountActivity.class);
      ((Intent)localObject).putExtra("subAccount", paramString);
      paramQQAppInterface = (bdxs)paramQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (paramQQAppInterface == null) {
        break label747;
      }
    }
    label747:
    for (paramQQAppInterface = paramQQAppInterface.b(paramString);; paramQQAppInterface = paramString)
    {
      ((Intent)localObject).putExtra("subAccountLatestNick", paramQQAppInterface);
      ((Intent)localObject).putExtra("finishAIO", true);
      paramQQAppInterface = (QQAppInterface)localObject;
      paramContext = paramMessageRecord;
      for (;;)
      {
        paramQQAppInterface.putExtra("uin", paramString);
        paramQQAppInterface.putExtra("uintype", paramInt);
        break;
        if (paramInt == 1009)
        {
          paramContext = paramContext.getString(2131718143);
          paramQQAppInterface = (QQAppInterface)localObject;
        }
        else if (String.valueOf(1787740092L).equals(paramString))
        {
          paramContext = paramContext.getString(2131690114);
          paramQQAppInterface = (QQAppInterface)localObject;
        }
        else if (paramInt == 1024)
        {
          ((Intent)localObject).setClass(paramContext, SplashActivity.class);
          paramContext = AIOUtils.setOpenAIOIntent((Intent)localObject, null);
          paramContext.putExtra("chat_subType", 1);
          paramMessageRecord = ContactUtils.getNickName(paramQQAppInterface, paramString, paramInt);
          paramQQAppInterface = paramContext;
          paramContext = paramMessageRecord;
        }
        else if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
        {
          localObject = paramContext.getString(2131698656);
          paramContext = new Intent(paramContext, MsgBoxListActivity.class);
          paramQQAppInterface = AppConstants.LBS_HELLO_UIN;
          if (!aryo.b(paramMessageRecord)) {
            paramQQAppInterface = AppConstants.NEARBY_LBS_HELLO_UIN;
          }
          paramContext.putExtra("uin", paramQQAppInterface);
          paramContext.putExtra("uintype", paramInt);
          paramQQAppInterface = paramContext;
          paramContext = (Context)localObject;
        }
        else if (paramInt == 1032)
        {
          paramString = paramContext.getString(2131698360);
          paramQQAppInterface = new Intent(paramContext, MsgBoxListActivity.class);
          paramMessageRecord = AppConstants.CONFESS_UIN;
          paramQQAppInterface.putExtra("uin", paramMessageRecord);
          paramQQAppInterface.putExtra("uintype", paramInt);
          paramContext = paramString;
          paramString = paramMessageRecord;
        }
        else
        {
          paramContext = ContactUtils.getNickName(paramQQAppInterface, paramString, paramInt);
          paramQQAppInterface = (QQAppInterface)localObject;
        }
      }
    }
  }
  
  private static Bitmap a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramInt == 1)
    {
      if (paramBoolean)
      {
        paramQQAppInterface = (antl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.a(paramMessageRecord.frienduin, true);
        }
      }
      else
      {
        if (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessageRecord.frienduin)) {
          return paramQQAppInterface.getFaceBitmap(paramString, true);
        }
        if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002) || (paramMessageRecord.istroop == 1010)) {
          return paramQQAppInterface.getStrangerFaceBitmap(paramMessageRecord.frienduin, 200);
        }
        return paramQQAppInterface.getFaceBitmap(paramMessageRecord.frienduin, true);
      }
    }
    else {
      return null;
    }
    return null;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, bapk parambapk, String paramString, int paramInt)
  {
    int i = parambapk.a();
    parambapk = paramString;
    if (i > 1)
    {
      parambapk = paramString;
      if (paramInt == 1)
      {
        if (i <= 100) {
          break label70;
        }
        parambapk = paramString + " (" + paramQQAppInterface.getApp().getString(2131694341) + ")";
      }
    }
    return parambapk;
    label70:
    return paramString + " (" + i + paramQQAppInterface.getApp().getString(2131694279) + ")";
  }
  
  private static String a(MessageRecord paramMessageRecord, bapk parambapk)
  {
    String str2 = paramMessageRecord.senderuin;
    String str1;
    if (paramMessageRecord.msgtype != -2016)
    {
      str1 = str2;
      if (paramMessageRecord.msgtype != -4008) {}
    }
    else
    {
      paramMessageRecord = parambapk.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      str1 = str2;
      if (paramMessageRecord != null) {
        str1 = paramMessageRecord.senderUin;
      }
    }
    return str1;
  }
  
  @Nullable
  private static String a(MessageRecord paramMessageRecord, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramMessageRecord.istroop == 1008) {
      paramMessageRecord = paramString2 + paramString3;
    }
    for (;;)
    {
      if (!paramBoolean) {
        paramMessageRecord = null;
      }
      return paramMessageRecord;
      if (paramMessageRecord.istroop == 7000) {
        paramMessageRecord = paramString2;
      } else {
        paramMessageRecord = paramString2 + paramString1;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if ((paramInt == 0) || (paramMessageRecord == null)) {}
    label52:
    boolean bool;
    do
    {
      do
      {
        do
        {
          break label52;
          do
          {
            return;
          } while ((a(paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord)) || (b(paramQQAppInterface, paramMessageRecord)) || (a(paramQQAppInterface, paramMessageRecord)));
          if (!UserguideActivity.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , showUserGuide");
        return;
        if (GuardManager.a != null) {
          GuardManager.a.b(0, null);
        }
        bool = ((KeyguardManager)paramQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      } while (b(paramMessageRecord));
      if (QLog.isColorLevel())
      {
        QLog.d("QavMsgNotificationUtil", 2, "isBackground_Pause:" + paramQQAppInterface.isBackgroundPause);
        QLog.d("QavMsgNotificationUtil", 2, "isBackground_Stop:" + paramQQAppInterface.isBackgroundStop);
        QLog.d("QavMsgNotificationUtil", 2, "isScreenLocked:" + bool);
      }
    } while (((!paramQQAppInterface.isBackgroundPause) && (!paramQQAppInterface.isBackgroundStop) && (!bool)) || ((paramMessageRecord.istroop != 6000) && (paramQQAppInterface.userActiveStatus != 0) && (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype != -3001) && (paramMessageRecord.istroop != 1008)))));
    a(paramQQAppInterface, paramMessageRecord, paramBoolean1, paramBoolean2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    bapk localbapk;
    Object localObject1;
    Object localObject3;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          bool = bgzw.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d("QavMsgNotificationUtil", 2, "showInComingMsg ,isFinished=" + paramQQAppInterface.isFinished + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessageRecord);
          }
        } while ((paramQQAppInterface.isFinished) || (!bool));
        localbapk = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      } while (localbapk == null);
      localObject1 = "";
      localObject3 = a(paramMessageRecord, localbapk);
      i = localbapk.b();
    } while (i == 0);
    boolean bool = a(paramMessageRecord);
    Intent localIntent = a(paramQQAppInterface, i, bool, paramMessageRecord, (String)localObject3);
    Object localObject6 = a(paramQQAppInterface, i, bool, paramMessageRecord, (String)localObject3);
    Object localObject2 = localObject1;
    if (i == 1)
    {
      localObject2 = localObject1;
      if (bool) {
        localObject2 = ContactUtils.getNick(paramQQAppInterface, (String)localObject3, 0);
      }
    }
    localIntent.putExtra("key_notification_click_action", true);
    Object localObject4 = localIntent.getStringExtra("uinname");
    if (localObject4 != null)
    {
      localObject1 = localObject4;
      if (!"".equals(localObject4)) {}
    }
    else
    {
      localObject1 = localIntent.getStringExtra("uin");
    }
    if (localObject2 != null)
    {
      localObject4 = localObject2;
      if (!"".equals(localObject2)) {}
    }
    else
    {
      localObject4 = localObject3;
    }
    localObject4 = localbapk.a((String)localObject4, bool);
    Object localObject5;
    switch (paramMessageRecord.istroop)
    {
    default: 
      String str = (String)localObject1 + ": ";
      localObject3 = localObject4;
      localObject5 = localObject6;
      localObject2 = localObject1;
      localObject1 = str;
    case 3000: 
      for (;;)
      {
        localObject1 = a(paramMessageRecord, paramBoolean, (String)localObject4, (String)localObject1, (String)localObject3);
        localObject2 = a(paramQQAppInterface, localbapk, (String)localObject2, i);
        a(paramMessageRecord, localIntent);
        a(paramQQAppInterface, paramMessageRecord, paramBoolean, localIntent, bool);
        anyy.a(paramQQAppInterface, paramMessageRecord, new aosm(localIntent, (String)localObject1, (String)localObject2, (String)localObject3, (Bitmap)localObject5), "CMD_SHOW_NOTIFIYCATION");
        return;
        localObject2 = ContactUtils.getNick(paramQQAppInterface, (String)localObject3, 0);
        localObject5 = (String)localObject2 + "(" + (String)localObject1 + "):";
        localObject2 = localObject1;
        localObject3 = localObject4;
        localObject1 = localObject5;
        localObject5 = localObject6;
      }
    case 7000: 
      localObject5 = localIntent.getStringExtra("subAccountLatestNick");
      localObject2 = localObject3;
      if (localObject5 != null) {
        if (((String)localObject5).length() != 0) {
          break label906;
        }
      }
      break;
    }
    label906:
    for (localObject2 = localObject3;; localObject2 = localObject5)
    {
      localObject6 = (String)localObject1 + "-" + (String)localObject2 + ":" + (String)localObject4;
      localObject3 = (String)localObject2 + ":" + (String)localObject4;
      localObject5 = null;
      localObject2 = localObject1;
      localObject1 = localObject6;
      break;
      if (i > 1)
      {
        localObject5 = (String)localObject1 + ": ";
        localObject2 = localObject1;
        localObject3 = localObject4;
        localObject1 = localObject5;
        localObject5 = localObject6;
        break;
      }
      localObject3 = ContactUtils.getDateNickName(paramQQAppInterface, paramMessageRecord.frienduin);
      localObject2 = (String)localObject3 + "(" + (String)localObject1 + "):";
      localObject5 = (String)localObject3 + ": " + (String)localObject4;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject5;
      localObject5 = localObject6;
      break;
      localObject5 = bhbd.a(paramQQAppInterface.getApp().getResources().getDrawable(2130840440));
      localObject3 = afuo.a(paramMessageRecord);
      if ((localObject3 != null) && (!((PAMessage)localObject3).items.isEmpty()))
      {
        localObject2 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
          localObject1 = (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
        }
        for (;;)
        {
          localObject3 = localObject1;
          localObject1 = "";
          break;
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      localObject2 = localObject1;
      localObject1 = "";
      localObject3 = localObject4;
      break;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (paramMessageRecord.istroop == 6000) || (paramMessageRecord.istroop == 1009) || (paramMessageRecord.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN))) {}
    awto localawto;
    do
    {
      do
      {
        return;
      } while (!bhgy.a(paramQQAppInterface.getApp()));
      localawto = (awto)paramQQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
      paramBoolean1 = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getApp().getString(2131693714), "qqsetting_lock_screen_whenexit_key", true);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, String.format("videochatting start lsActivity from appinterface  showInComingMsgForQAV, lockScreenMsgWhenExit[%s]", new Object[] { Boolean.valueOf(paramBoolean1) }));
      }
    } while (!paramBoolean1);
    if (paramBoolean2)
    {
      localawto.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, true, awtk.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramIntent));
      return;
    }
    localawto.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, false, awtk.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQQAppInterface.isShowMsgContent()) {
      a(paramQQAppInterface, paramMessageRecord, true);
    }
    for (;;)
    {
      int j = 0;
      int i = j;
      if (paramQQAppInterface.userActiveStatus == 0)
      {
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
      }
      if (paramMessageRecord.istroop != 1001)
      {
        j = i;
        if (paramMessageRecord.istroop != 10002) {}
      }
      else
      {
        j = i;
        if (paramMessageRecord.msgtype == -3001) {
          j = 1;
        }
      }
      i = j;
      if (paramMessageRecord.istroop == 1008) {
        if ((paramMessageRecord.extStr == null) || ((paramMessageRecord.extLong & 0x1) != 0) || (!paramMessageRecord.extStr.contains("lockDisplay")))
        {
          i = j;
          if (paramMessageRecord.extStr != null)
          {
            i = j;
            if ((paramMessageRecord.extLong & 0x1) == 1)
            {
              i = j;
              if (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i = j;
          if (paramBoolean1) {
            i = 1;
          }
        }
      }
      j = i;
      if (paramMessageRecord.istroop == 1008)
      {
        j = i;
        if (AppConstants.REMINDER_UIN.equals(paramMessageRecord.senderuin)) {
          j = 1;
        }
      }
      if (j != 0) {
        paramQQAppInterface.vibratorAndAudio(paramMessageRecord, paramBoolean2, true);
      }
      return;
      b(paramQQAppInterface, paramMessageRecord, true);
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, Intent paramIntent)
  {
    if ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QavMsgNotificationUtil", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
      }
      if (paramMessageRecord.istroop == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavMsgNotificationUtil", 2, "AVNotify:UIN_TYPE_DISCUSSION");
        }
        paramIntent.putExtra("qav_notify_flag", true);
      }
    }
    while (paramMessageRecord.msgtype != -2009) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QavMsgNotificationUtil", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
    }
    paramIntent.putExtra("qav_notify_flag", true);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((String.valueOf(AppConstants.NEW_KANDIAN_UIN).equals(paramMessageRecord.frienduin)) && (1008 == paramMessageRecord.istroop)) {}
    while ((String.valueOf(AppConstants.KANDIAN_MERGE_UIN).equals(paramMessageRecord.frienduin)) && (7220 == paramMessageRecord.istroop) && (!pkh.a(paramQQAppInterface, paramMessageRecord))) {
      return true;
    }
    return false;
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000);
  }
  
  private static boolean a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((1000 == paramMessageRecord.istroop) || (1020 == paramMessageRecord.istroop))
    {
      if ((paramMessageRecord.frienduin == null) || (!paramMessageRecord.frienduin.equalsIgnoreCase(paramString))) {
        break label102;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , stranger  self message");
      }
    }
    do
    {
      return true;
      if ((paramMessageRecord.senderuin == null) || (!paramMessageRecord.senderuin.equalsIgnoreCase(paramString)) || (paramMessageRecord.msgtype == -4008)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification ,self message");
    return true;
    label102:
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramQQAppInterface.isFinished) || (!bgzw.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("notification", 4, String.format("showQavNotificationNoPreview fail 1, message:%s", new Object[] { paramMessageRecord }));
      }
    }
    Object localObject;
    int i;
    Intent localIntent;
    StringBuffer localStringBuffer;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
          if (localObject != null) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.d("notification", 4, String.format("showQavNotificationNoPreview fail 2, message:%s", new Object[] { paramMessageRecord }));
        return;
        i = ((bapk)localObject).b();
      } while (i == 0);
      if (i != 1) {
        break label475;
      }
      if (((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008)) || (paramMessageRecord.istroop != 3000)) {
        break;
      }
      localIntent = a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramQQAppInterface.getApp().getString(2131694354));
      j = ((bapk)localObject).a();
    } while (j == 0);
    if (j > 1000)
    {
      localStringBuffer.append(paramQQAppInterface.getApp().getString(2131694339));
      label229:
      localObject = null;
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      }
      if (paramMessageRecord.msgtype != -2016) {
        break label545;
      }
      if (QLog.isColorLevel()) {
        QLog.e("notification", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO, count:" + i);
      }
      if (paramMessageRecord.istroop == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.e("notification", 2, "AVNotify:UIN_TYPE_DISCUSSION, count:" + i);
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
    for (;;)
    {
      anyy.a(paramQQAppInterface, paramMessageRecord, new aosm(localIntent, (String)localObject, paramQQAppInterface.getApp().getResources().getString(2131694350), localStringBuffer.toString(), null), "CMD_SHOW_NOTIFIYCATION");
      return;
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
      {
        localIntent = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", MainFragment.b);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
        break;
      }
      localIntent = a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      break;
      label475:
      localIntent = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("conversation_index", 1);
      localIntent.setFlags(335544320);
      break;
      localStringBuffer.append(j).append(paramQQAppInterface.getApp().getString(2131694342));
      break label229;
      label545:
      if (paramMessageRecord.msgtype == -2009)
      {
        if (QLog.isColorLevel()) {
          QLog.e("notification", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO, count:" + i);
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (1008 == paramMessageRecord.istroop) && (uqx.a().a(paramQQAppInterface, paramMessageRecord.senderuin, paramMessageRecord.istroop))) {}
    while ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 0) && (!paramMessageRecord.extStr.contains("lockDisplay"))) || (paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 1) && (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true"))))) {
      return true;
    }
    return false;
  }
  
  private static boolean b(MessageRecord paramMessageRecord)
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("QavMsgNotificationUtil", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((paramMessageRecord.msgtype == -2016) && (paramMessageRecord.istroop == 3000)) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0))
        {
          return true;
          i = 0;
          break;
        }
        return false;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mud
 * JD-Core Version:    0.7.0.1
 */