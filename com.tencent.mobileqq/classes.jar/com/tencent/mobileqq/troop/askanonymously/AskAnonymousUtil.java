package com.tencent.mobileqq.troop.askanonymously;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class AskAnonymousUtil
{
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
    if (!(paramMessageRecord instanceof MessageForArkApp)) {
      return paramString;
    }
    String str = paramString;
    if (a((MessageForArkApp)paramMessageRecord))
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(paramString);
      paramMessageRecord.append("&busi=ask_anonymously=1");
      str = paramMessageRecord.toString();
    }
    return str;
  }
  
  public static void a(MessageForArkApp paramMessageForArkApp)
  {
    AskAnonymousUtil.1 local1 = new AskAnonymousUtil.1(paramMessageForArkApp);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      local1.run();
    } else {
      ThreadManager.getUIHandlerV2().post(local1);
    }
    ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "clk_askark_ans", 0, 0, paramMessageForArkApp.frienduin, "0", "", "");
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong & 0x40000000) != 0L;
  }
  
  protected static boolean a(TroopChatPie paramTroopChatPie)
  {
    if (paramTroopChatPie == null) {
      return true;
    }
    QQAppInterface localQQAppInterface = paramTroopChatPie.d;
    if (localQQAppInterface == null) {
      return true;
    }
    if (((TroopGagMgr)localQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramTroopChatPie.ah.b, true).b)
    {
      QQToast.makeText(localQQAppInterface.getApp(), 2131895180, 0).show(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299920));
      return true;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return b(paramMessageRecord) > 0L;
  }
  
  public static long b(MessageRecord paramMessageRecord)
  {
    boolean bool = paramMessageRecord instanceof MessageForArkApp;
    long l3 = 0L;
    Object localObject = paramMessageRecord;
    if (!bool) {
      if (paramMessageRecord.msgtype == -5008)
      {
        localObject = new MessageForArkApp();
        ((MessageForArkApp)localObject).msgData = paramMessageRecord.msgData;
      }
    }
    try
    {
      ((MessageForArkApp)localObject).doParse();
      label48:
      break label53;
      return 0L;
      label53:
      paramMessageRecord = (MessageForArkApp)localObject;
      localObject = paramMessageRecord.ark_app_message;
      if (localObject == null) {
        paramMessageRecord.doParse();
      }
      if (localObject == null) {
        return 0L;
      }
      long l2 = l3;
      if ("com.tencent.anonymousqa".equals(((ArkAppMessage)localObject).appName))
      {
        paramMessageRecord = ((ArkAppMessage)localObject).metaList;
        long l4 = l3;
        long l1 = l3;
        try
        {
          localObject = new JSONObject(paramMessageRecord).optJSONObject("questionData");
          l4 = l3;
          l1 = l3;
          paramMessageRecord = ((JSONObject)localObject).optString("questionId");
          l4 = l3;
          l1 = l3;
          localObject = ((JSONObject)localObject).optString("questionName");
          l4 = l3;
          l1 = l3;
          l3 = Long.valueOf(paramMessageRecord).longValue();
          l4 = l3;
          l1 = l3;
          l2 = l3;
          if (QLog.isColorLevel())
          {
            l4 = l3;
            l1 = l3;
            QLog.i("AskAnonymousUtil", 2, String.format("getQuestionId parse id=%s name=%s", new Object[] { paramMessageRecord, localObject }));
            return l3;
          }
        }
        catch (Exception paramMessageRecord)
        {
          QLog.d("AskAnonymousUtil", 1, paramMessageRecord.getMessage(), paramMessageRecord);
          return l4;
        }
        catch (JSONException paramMessageRecord)
        {
          QLog.d("AskAnonymousUtil", 1, paramMessageRecord.getMessage(), paramMessageRecord);
          l2 = l1;
        }
      }
      return l2;
    }
    catch (Exception paramMessageRecord)
    {
      break label48;
    }
  }
  
  public static void b(MessageForArkApp paramMessageForArkApp)
  {
    Object localObject = a();
    if (localObject == null) {
      QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: activity is null");
    }
    if ((localObject instanceof BaseActivity))
    {
      localObject = (BaseActivity)localObject;
      if (((BaseActivity)localObject).getChatFragment() != null)
      {
        localObject = ((BaseActivity)localObject).getChatFragment().k();
        if ((localObject instanceof TroopChatPie))
        {
          TroopChatPie localTroopChatPie = (TroopChatPie)localObject;
          if ((!a(localTroopChatPie)) && (!b(localTroopChatPie))) {
            ((ReplyHelper)((BaseChatPie)localObject).q(119)).a(paramMessageForArkApp, 0, 0L, null);
          }
        }
        else
        {
          QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: no troop chatPie");
        }
      }
      else
      {
        QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: no chatPie");
      }
    }
    else
    {
      QLog.e("AskAnonymousUtil", 2, "replyTroopAskAnonymously: activity is wrong");
    }
  }
  
  protected static boolean b(TroopChatPie paramTroopChatPie)
  {
    if (paramTroopChatPie == null) {
      return true;
    }
    QQAppInterface localQQAppInterface = paramTroopChatPie.d;
    if (localQQAppInterface == null) {
      return true;
    }
    if (paramTroopChatPie.bG())
    {
      QQToast.makeText(localQQAppInterface.getApp(), 2131893808, 0).show(localQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299920));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil
 * JD-Core Version:    0.7.0.1
 */