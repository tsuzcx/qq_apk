package com.tencent.mobileqq.troop.askanonymously;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class AskAnonymousUtil
{
  /* Error */
  public static long a(MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 17
    //   4: ifne +220 -> 224
    //   7: aload_0
    //   8: getfield 23	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   11: sipush -5008
    //   14: if_icmpne +55 -> 69
    //   17: new 17	com/tencent/mobileqq/data/MessageForArkApp
    //   20: dup
    //   21: invokespecial 24	com/tencent/mobileqq/data/MessageForArkApp:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: aload_0
    //   29: getfield 28	com/tencent/mobileqq/data/MessageRecord:msgData	[B
    //   32: putfield 29	com/tencent/mobileqq/data/MessageForArkApp:msgData	[B
    //   35: aload 5
    //   37: invokevirtual 32	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   40: aload 5
    //   42: astore_0
    //   43: aload_0
    //   44: checkcast 17	com/tencent/mobileqq/data/MessageForArkApp
    //   47: getfield 36	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +10 -> 64
    //   57: aload_0
    //   58: checkcast 17	com/tencent/mobileqq/data/MessageForArkApp
    //   61: invokevirtual 32	com/tencent/mobileqq/data/MessageForArkApp:doParse	()V
    //   64: aload 5
    //   66: ifnonnull +5 -> 71
    //   69: lconst_0
    //   70: lreturn
    //   71: ldc 38
    //   73: aload 5
    //   75: getfield 44	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   78: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +138 -> 219
    //   84: aload 5
    //   86: getfield 53	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   89: astore_0
    //   90: new 55	org/json/JSONObject
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 58	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   98: ldc 60
    //   100: invokevirtual 64	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   103: astore 5
    //   105: aload 5
    //   107: ldc 66
    //   109: invokevirtual 70	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_0
    //   113: aload 5
    //   115: ldc 72
    //   117: invokevirtual 70	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 5
    //   122: aload_0
    //   123: invokestatic 78	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   126: invokevirtual 82	java/lang/Long:longValue	()J
    //   129: lstore_1
    //   130: lload_1
    //   131: lstore_3
    //   132: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +29 -> 164
    //   138: ldc 90
    //   140: iconst_2
    //   141: ldc 92
    //   143: iconst_2
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_0
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload 5
    //   155: aastore
    //   156: invokestatic 96	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   159: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: lload_1
    //   163: lstore_3
    //   164: lload_3
    //   165: lreturn
    //   166: astore_0
    //   167: lconst_0
    //   168: lstore_1
    //   169: ldc 90
    //   171: iconst_1
    //   172: aload_0
    //   173: invokevirtual 104	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   176: aload_0
    //   177: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: lload_1
    //   181: lstore_3
    //   182: goto -18 -> 164
    //   185: astore_0
    //   186: lconst_0
    //   187: lstore_1
    //   188: ldc 90
    //   190: iconst_1
    //   191: aload_0
    //   192: invokevirtual 109	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   195: aload_0
    //   196: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: lload_1
    //   200: lstore_3
    //   201: goto -37 -> 164
    //   204: astore_0
    //   205: aload 5
    //   207: astore_0
    //   208: goto -165 -> 43
    //   211: astore_0
    //   212: goto -24 -> 188
    //   215: astore_0
    //   216: goto -47 -> 169
    //   219: lconst_0
    //   220: lstore_3
    //   221: goto -57 -> 164
    //   224: goto -181 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramMessageRecord	MessageRecord
    //   129	71	1	l1	long
    //   131	90	3	l2	long
    //   24	182	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   90	130	166	org/json/JSONException
    //   90	130	185	java/lang/Exception
    //   35	40	204	java/lang/Exception
    //   132	162	211	java/lang/Exception
    //   132	162	215	org/json/JSONException
  }
  
  protected static Activity a()
  {
    if (BaseActivity.sTopActivity != null) {
      return BaseActivity.sTopActivity;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QzoneMainRuntime))
    {
      localObject = ((AppRuntime)localObject).getApplication().getResumeActivity();
      if (localObject != null) {
        return (Activity)((WeakReference)localObject).get();
      }
    }
    return null;
  }
  
  public static String a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AskAnonymousUtil", 2, String.format("appendAskAnonymousParamIfNeed mr is arkMsg?=%b", new Object[] { Boolean.valueOf(paramMessageRecord instanceof MessageForArkApp) }));
    }
    if (!(paramMessageRecord instanceof MessageForArkApp)) {}
    while (!a((MessageForArkApp)paramMessageRecord)) {
      return paramString;
    }
    return paramString + "&busi=ask_anonymously=1";
  }
  
  public static void a(MessageForArkApp paramMessageForArkApp)
  {
    AskAnonymousUtil.1 local1 = new AskAnonymousUtil.1(paramMessageForArkApp);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      local1.run();
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "clk_askark_ans", 0, 0, paramMessageForArkApp.frienduin, "0", "", "");
      return;
      ThreadManager.getUIHandlerV2().post(local1);
    }
  }
  
  public static boolean a(long paramLong)
  {
    return (0x40000000 & paramLong) != 0L;
  }
  
  protected static boolean a(TroopChatPie paramTroopChatPie)
  {
    if (paramTroopChatPie == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return true;
      localQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if (((TroopGagMgr)localQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true).a) {
      QQToast.a(localQQAppInterface.getApp(), 2131697388, 0).b(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299166));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord) > 0L;
  }
  
  public static void b(MessageForArkApp paramMessageForArkApp)
  {
    Object localObject = a();
    if (localObject == null) {
      QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: activity is null");
    }
    if ((localObject instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if ((localObject instanceof TroopChatPie))
        {
          if ((!a((TroopChatPie)localObject)) && (!b((TroopChatPie)localObject))) {
            ((BaseChatPie)localObject).d(paramMessageForArkApp);
          }
          return;
        }
        QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: no troop chatPie");
        return;
      }
      QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: no chatPie");
      return;
    }
    QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: activity is wrong");
  }
  
  protected static boolean b(TroopChatPie paramTroopChatPie)
  {
    if (paramTroopChatPie == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return true;
      localQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    if (paramTroopChatPie.G())
    {
      QQToast.a(localQQAppInterface.getApp(), 2131696031, 0).b(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299166));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil
 * JD-Core Version:    0.7.0.1
 */