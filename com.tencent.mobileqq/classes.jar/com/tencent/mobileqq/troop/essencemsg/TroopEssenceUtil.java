package com.tencent.mobileqq.troop.essencemsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsgSummary;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestSummaryInfo;

public class TroopEssenceUtil
{
  private static int a = 10;
  
  public static int a(SessionInfo paramSessionInfo, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    if (paramSessionInfo.a == 1)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramSessionInfo.b);
        l1 = l2;
      }
      catch (Exception paramSessionInfo)
      {
        paramSessionInfo.printStackTrace();
      }
      return a(paramQQAppInterface, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage);
    }
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (paramChatMessage == null) {
      return 0;
    }
    if (!(paramChatMessage instanceof MessageForText))
    {
      if ((paramChatMessage instanceof MessageForLongTextMsg)) {
        return 1;
      }
      if ((paramChatMessage instanceof MessageForMixedMsg)) {
        return 2;
      }
      if ((paramChatMessage instanceof MessageForPic)) {
        return 3;
      }
      if ((!(paramChatMessage instanceof MessageForFile)) && (!(paramChatMessage instanceof MessageForTroopFile)))
      {
        if ((c(paramChatMessage)) || (d(paramChatMessage))) {
          i = 1;
        }
        if (i != 0) {
          return 7;
        }
        if ((!a(paramChatMessage)) && (!b(paramChatMessage))) {
          return 9;
        }
        return 8;
      }
      i = ItemBuilderFactory.a(paramQQAppInterface, paramChatMessage);
      if (i != 61)
      {
        if (i != 65)
        {
          if (i == 121) {
            break label140;
          }
          if (i != 122) {
            return 6;
          }
        }
        return 5;
      }
      label140:
      return 4;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface != null) && (paramTroopEssenceMsgItemKey != null))
    {
      if (paramChatMessage == null) {
        return 0;
      }
      if (AnonymousChatHelper.c(paramChatMessage)) {
        return 0;
      }
      if ((paramChatMessage.isSendFromLocal()) && ((paramChatMessage.extraflag == 32768) || (paramChatMessage.extraflag == 32772))) {
        return 0;
      }
      paramChatMessage = (TroopEssenceMsgEntryConfig)QConfigManager.b().b(668);
      if ((paramChatMessage != null) && (paramChatMessage.a(Long.toString(paramTroopEssenceMsgItemKey.a))))
      {
        if (paramChatMessage.a() == 0) {
          return 0;
        }
        boolean bool1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItemKey.a), paramQQAppInterface.getCurrentUin());
        boolean bool2 = TroopUtils.a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItemKey.a), paramQQAppInterface.getCurrentUin());
        int i;
        if ((!bool1) && (!bool2)) {
          i = 0;
        } else {
          i = 1;
        }
        Object localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).g(String.valueOf(paramTroopEssenceMsgItemKey.a));
          if (localObject != null)
          {
            j = ((TroopInfo)localObject).wMemberNum;
            break label203;
          }
        }
        int j = 0;
        label203:
        if ((i == 0) && (j > paramChatMessage.a())) {
          return 0;
        }
        paramChatMessage = (TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
        paramChatMessage.b(paramTroopEssenceMsgItemKey);
        paramTroopEssenceMsgItemKey = paramChatMessage.c(paramTroopEssenceMsgItemKey);
        if (paramTroopEssenceMsgItemKey != null)
        {
          if (paramTroopEssenceMsgItemKey.a == 2) {
            return 1;
          }
          if ((i == 0) && (!TextUtils.isEmpty(paramTroopEssenceMsgItemKey.c)) && (!paramTroopEssenceMsgItemKey.c.equals(paramQQAppInterface.getCurrentUin()))) {
            return 0;
          }
          return 2;
        }
        return 1;
      }
    }
    return 0;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.g(paramString);
        l1 = l2;
        if (paramQQAppInterface != null) {
          l1 = paramQQAppInterface.dwGroupClassExt;
        }
      }
    }
    return l1;
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem paramTroopBatchEssenceMsgPushItem)
  {
    if ((paramQQAppInterface != null) && (paramTroopBatchEssenceMsgPushItem != null) && (paramTroopBatchEssenceMsgPushItem.b != null) && (!paramTroopBatchEssenceMsgPushItem.b.isEmpty()))
    {
      String str2 = String.valueOf(paramTroopBatchEssenceMsgPushItem.a);
      String str1 = BaseApplicationImpl.getContext().getResources().getString(2131917438);
      Object localObject1 = BaseApplicationImpl.getContext().getResources().getString(2131917437).replace("$COUNT", String.valueOf(paramTroopBatchEssenceMsgPushItem.b.size()));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramTroopBatchEssenceMsgPushItem.d);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(str1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new UniteGrayTipParam(str2, str2, (String)localObject2, 1, -5040, 131090, MessageCache.c());
      long l = 0L;
      int i = 0;
      paramTroopBatchEssenceMsgPushItem = paramTroopBatchEssenceMsgPushItem.b.iterator();
      while (paramTroopBatchEssenceMsgPushItem.hasNext())
      {
        TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)paramTroopBatchEssenceMsgPushItem.next();
        if (localTroopEssenceMsgItem.msgSeq > l)
        {
          l = localTroopEssenceMsgItem.msgSeq;
          i = localTroopEssenceMsgItem.msgRandom;
        }
      }
      paramTroopBatchEssenceMsgPushItem = new Bundle();
      str2 = a(str2, l, i);
      paramTroopBatchEssenceMsgPushItem.putInt("key_action", 1);
      paramTroopBatchEssenceMsgPushItem.putString("textColor", "#40A0FF");
      paramTroopBatchEssenceMsgPushItem.putString("key_action_DATA", str2);
      ((UniteGrayTipParam)localObject1).a(((String)localObject2).length() - str1.length(), ((String)localObject2).length(), paramTroopBatchEssenceMsgPushItem);
      paramTroopBatchEssenceMsgPushItem = new MessageForUniteGrayTip();
      paramTroopBatchEssenceMsgPushItem.createMessageUniseq();
      paramTroopBatchEssenceMsgPushItem.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      return paramTroopBatchEssenceMsgPushItem;
    }
    return null;
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem)
  {
    if ((paramQQAppInterface != null) && (paramTroopEssenceMsgPushItem != null) && (paramTroopEssenceMsgPushItem.a != null))
    {
      Object localObject2 = String.valueOf(paramTroopEssenceMsgPushItem.a.troopUin);
      Object localObject1 = BaseApplicationImpl.getContext().getResources().getString(2131917439);
      String str1 = BaseApplicationImpl.getContext().getResources().getString(2131917438);
      String str3 = ((String)localObject1).replace("$MSGSENDERNAME", paramTroopEssenceMsgPushItem.d);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str3);
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getResources().getString(2131917441));
      ((StringBuilder)localObject1).append(str1);
      String str2 = ((StringBuilder)localObject1).toString();
      localObject1 = new UniteGrayTipParam((String)localObject2, (String)localObject2, str2, 1, -5040, 131090, MessageCache.c());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 58);
      localBundle.putString("textColor", "#40A0FF");
      localBundle.putString("key_action_DATA", String.valueOf(paramTroopEssenceMsgPushItem.a.msgSeq));
      ((UniteGrayTipParam)localObject1).a(0, str3.length(), localBundle);
      paramTroopEssenceMsgPushItem = a((String)localObject2, paramTroopEssenceMsgPushItem.a.msgSeq, paramTroopEssenceMsgPushItem.a.msgRandom);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 1);
      ((Bundle)localObject2).putString("textColor", "#40A0FF");
      ((Bundle)localObject2).putString("key_action_DATA", paramTroopEssenceMsgPushItem);
      ((UniteGrayTipParam)localObject1).a(str2.length() - str1.length(), str2.length(), (Bundle)localObject2);
      paramTroopEssenceMsgPushItem = new MessageForUniteGrayTip();
      paramTroopEssenceMsgPushItem.createMessageUniseq();
      paramTroopEssenceMsgPushItem.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      return paramTroopEssenceMsgPushItem;
    }
    return null;
  }
  
  @Nullable
  public static TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem a(long paramLong, TroopTips0x857.QQGroupDigestMsgSummary paramQQGroupDigestMsgSummary)
  {
    if ((paramQQGroupDigestMsgSummary != null) && (paramQQGroupDigestMsgSummary.succ_cnt.get() != 0) && (paramQQGroupDigestMsgSummary.summary_info.has()) && (paramQQGroupDigestMsgSummary.summary_info.size() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramQQGroupDigestMsgSummary.summary_info.size());
      Iterator localIterator = paramQQGroupDigestMsgSummary.summary_info.get().iterator();
      while (localIterator.hasNext())
      {
        TroopTips0x857.QQGroupDigestSummaryInfo localQQGroupDigestSummaryInfo = (TroopTips0x857.QQGroupDigestSummaryInfo)localIterator.next();
        if ((localQQGroupDigestSummaryInfo != null) && (localQQGroupDigestSummaryInfo.error_code.get() == 0))
        {
          TroopEssenceMsgItem localTroopEssenceMsgItem = new TroopEssenceMsgItem();
          localTroopEssenceMsgItem.troopUin = paramLong;
          localTroopEssenceMsgItem.msgSeq = localQQGroupDigestSummaryInfo.msg_seq.get();
          localTroopEssenceMsgItem.msgRandom = localQQGroupDigestSummaryInfo.msg_random.get();
          if (paramQQGroupDigestMsgSummary.op_time.has()) {
            localTroopEssenceMsgItem.opTime = paramQQGroupDigestMsgSummary.op_time.get();
          }
          localTroopEssenceMsgItem.opType = 1;
          localArrayList.add(localTroopEssenceMsgItem);
        }
      }
      return new TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem(paramLong, localArrayList, String.valueOf(paramQQGroupDigestMsgSummary.digest_oper.get()), paramQQGroupDigestMsgSummary.digest_nick.get().toStringUtf8());
    }
    return null;
  }
  
  public static TroopEssenceMsgItem.TroopEssenceMsgPushItem a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg)
  {
    if (paramQQGroupDigestMsg == null) {
      return null;
    }
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramQQGroupDigestMsg.group_code.get(), paramQQGroupDigestMsg.msg_seq.get(), paramQQGroupDigestMsg.msg_random.get());
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(paramQQGroupDigestMsg.op_type.get(), String.valueOf(paramQQGroupDigestMsg.msg_sender.get()), String.valueOf(paramQQGroupDigestMsg.digest_oper.get()), paramQQGroupDigestMsg.op_time.get(), 0L);
    boolean bool = paramQQGroupDigestMsg.oper_nick.has();
    String str2 = "";
    String str1;
    if (bool) {
      str1 = paramQQGroupDigestMsg.oper_nick.get().toStringUtf8();
    } else {
      str1 = "";
    }
    if (paramQQGroupDigestMsg.sender_nick.has()) {
      str2 = paramQQGroupDigestMsg.sender_nick.get().toStringUtf8();
    }
    return new TroopEssenceMsgItem.TroopEssenceMsgPushItem(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue), paramQQGroupDigestMsg.lastest_msg_seq.get(), str1, str2);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.equals(paramQQAppInterface.getCurrentUin())) {
        return BaseApplicationImpl.getContext().getResources().getString(2131917440);
      }
      paramString1 = ContactUtils.a(paramQQAppInterface, paramString2, paramString1, ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).v(paramString1), true, null);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramQQAppInterface = paramString1;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        if (!TextUtils.isEmpty(paramString3)) {
          return paramString3;
        }
        paramQQAppInterface = paramString2;
      }
      return paramQQAppInterface;
    }
    return "";
  }
  
  private static String a(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    return "https://qun.qq.com/essence/index?gc=$GC&seq=$SEQ&random=$RANDOM&_wv=3&_wwv=128&_wvx=2&_wvxBclr=f5f6fa".replace("$GC", paramString).replace("$SEQ", String.valueOf(paramLong)).replace("$RANDOM", String.valueOf(paramInt));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
    }
    try
    {
      long l = Long.parseLong(paramString2);
      if ((paramContext instanceof BaseActivity))
      {
        paramContext = ((BaseActivity)paramContext).getChatFragment();
        if ((paramContext != null) && (paramContext.k() != null) && ((paramContext.k() instanceof BaseTroopChatPie))) {
          paramContext.k().bv().e().d().a(103, l, 0);
        }
      }
      ReportController.b(null, "dc00898", "", paramString1, "0X800B34C", "0X800B34C", 0, 0, String.valueOf(a(paramQQAppInterface, paramString1)), "", "", "");
      TroopEssenceReportUtil.c(paramQQAppInterface, paramString1);
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, TroopEssenceMsgItem paramTroopEssenceMsgItem)
  {
    if ((paramQQAppInterface != null) && (paramChatMessage != null))
    {
      if (paramTroopEssenceMsgItem == null) {
        return;
      }
      long l = a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin));
      int i;
      if ((!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.getCurrentUin())) && (!TroopUtils.a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.getCurrentUin()))) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if (paramTroopEssenceMsgItem.opType == 1)
      {
        paramTroopEssenceMsgItem = Long.toString(paramTroopEssenceMsgItem.troopUin);
        j = a(paramQQAppInterface, paramChatMessage);
        if (i != 0) {
          paramQQAppInterface = "1";
        } else {
          paramQQAppInterface = "2";
        }
        ReportController.b(null, "dc00898", "", paramTroopEssenceMsgItem, "0X800B34B", "0X800B34B", 0, 0, String.valueOf(l), String.valueOf(j), paramQQAppInterface, "");
        return;
      }
      if (paramTroopEssenceMsgItem.opType == 2)
      {
        String str2 = Long.toString(paramTroopEssenceMsgItem.troopUin);
        j = a(paramQQAppInterface, paramChatMessage);
        String str1;
        if (i != 0) {
          str1 = "1";
        } else {
          str1 = "2";
        }
        ReportController.b(null, "dc00898", "", str2, "0X800B34D", "0X800B34D", 0, 0, String.valueOf(l), String.valueOf(j), str1, "");
        TroopEssenceReportUtil.a(paramQQAppInterface, paramTroopEssenceMsgItem.troopUin, a(paramQQAppInterface, paramChatMessage), true, 2);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, Context paramContext, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramContext == null) {
        return;
      }
      String str = a(paramString, paramLong, paramInt1);
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if ((paramContext instanceof BaseActivity)) {
        ((BaseActivity)paramContext).startActivityForResult(localIntent, 20008);
      }
      if (paramInt2 == 1)
      {
        ReportController.b(null, "dc00898", "", paramString, "0X800B34A", "0X800B34A", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
        TroopEssenceReportUtil.d(paramQQAppInterface, paramString);
        return;
      }
      if (paramInt2 == 2)
      {
        TroopEssenceReportUtil.a(paramQQAppInterface, paramString, false);
        TroopEssenceReportUtil.b(paramQQAppInterface, paramString, false);
      }
    }
  }
  
  public static void a(ChatMessage paramChatMessage, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramChatMessage == null)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("TroopEssenceUtil", 2, "chatMessage is null");
      }
      return;
    }
    TroopEssenceMsgItem localTroopEssenceMsgItem = new TroopEssenceMsgItem();
    try
    {
      localTroopEssenceMsgItem.troopUin = Long.parseLong(paramSessionInfo.b);
    }
    catch (Exception paramSessionInfo)
    {
      paramSessionInfo.printStackTrace();
    }
    localTroopEssenceMsgItem.msgSeq = paramChatMessage.shmsgseq;
    localTroopEssenceMsgItem.msgRandom = MessageUtils.b(paramChatMessage.msgUid);
    localTroopEssenceMsgItem.opUin = paramQQAppInterface.getCurrentUin();
    localTroopEssenceMsgItem.msgSenderUin = paramChatMessage.senderuin;
    localTroopEssenceMsgItem.opType = paramInt;
    localTroopEssenceMsgItem.msgType = a(paramQQAppInterface, paramChatMessage);
    ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(localTroopEssenceMsgItem, 1);
    a(paramQQAppInterface, paramChatMessage, localTroopEssenceMsgItem);
  }
  
  public static void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu, @Nonnull SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramSessionInfo.a == 1)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramSessionInfo.b);
        l1 = l2;
      }
      catch (Exception paramSessionInfo)
      {
        paramSessionInfo.printStackTrace();
      }
      int i = a(paramQQAppInterface, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage);
      if (i == 2)
      {
        paramQQCustomMenu.a(2131432608, paramContext.getString(2131917452), 0);
        return;
      }
      if (i == 1) {
        paramQQCustomMenu.a(2131432607, paramContext.getString(2131917451), 0);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
    return (paramQQAppInterface != null) && (paramQQAppInterface.a(new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramLong1, paramLong2, paramInt)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() > a) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if (localChatMessage != null)
        {
          int i = a(paramQQAppInterface, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramLong, localChatMessage.shmsgseq, MessageUtils.b(localChatMessage.msgUid)), localChatMessage);
          if ((a(paramQQAppInterface, localChatMessage, String.valueOf(paramLong))) || (i != 1) || ((!d(localChatMessage)) && (!c(localChatMessage)) && (!a(localChatMessage)) && (!b(localChatMessage)) && (!(localChatMessage instanceof MessageForLongTextMsg)) && (!(localChatMessage instanceof MessageForText)) && (!(localChatMessage instanceof MessageForFile)) && (!(localChatMessage instanceof MessageForTroopFile)) && (!(localChatMessage instanceof MessageForMixedMsg)) && (!(localChatMessage instanceof MessageForPic)))) {
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return a(paramQQAppInterface, l, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid));
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForStructing)) {
        return false;
      }
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage == null) {
        return false;
      }
      if ((paramChatMessage.mMsgServiceID != 1) && (paramChatMessage.mMsgServiceID != 33) && (paramChatMessage.mMsgServiceID != 95)) {
        return ((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == 101458937L);
      }
      return true;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ReportController.b(null, "dc00898", "", paramString, "0X800B34F", "0X800B34F", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForArkApp)) {
        return false;
      }
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      if (localMessageForArkApp != null)
      {
        if (localMessageForArkApp.ark_app_message == null) {
          return false;
        }
        if ("com.tencent.structmsg".equals(localMessageForArkApp.ark_app_message.appName)) {
          return true;
        }
        if (d(paramChatMessage)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    ReportController.b(null, "dc00898", "", paramString, "0X800B34E", "0X800B34E", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage != null)
      {
        if (paramChatMessage.mMsgServiceID == 95) {
          return true;
        }
        if (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == 101458937L)) {
          return true;
        }
        if ((!TextUtils.isEmpty(paramChatMessage.mMsgUrl)) && (FMConstants.a(paramChatMessage.mMsgUrl))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      TroopEssenceMsgEntryConfig localTroopEssenceMsgEntryConfig = (TroopEssenceMsgEntryConfig)QConfigManager.b().b(668);
      boolean bool1;
      Object localObject;
      if ((localTroopEssenceMsgEntryConfig != null) && (localTroopEssenceMsgEntryConfig.a(paramString)) && (localTroopEssenceMsgEntryConfig.a() != 0))
      {
        bool1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentUin());
        boolean bool2 = TroopUtils.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentUin());
        if ((!bool1) && (!bool2)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).g(paramString);
          if (localObject != null)
          {
            i = ((TroopInfo)localObject).wMemberNum;
            break label144;
          }
        }
        int i = 0;
        label144:
        if ((!bool1) && (i > localTroopEssenceMsgEntryConfig.a()))
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("shouldShouldEssenchEntry: troopMemberNum = ");
            paramQQAppInterface.append(i);
            paramQQAppInterface.append(", LimitMemberNum = ");
            paramQQAppInterface.append(localTroopEssenceMsgEntryConfig.a());
            com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, paramQQAppInterface.toString());
          }
          return false;
        }
        localObject = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        boolean bool3 = ((TroopGagMgr)localObject).a(paramString, paramQQAppInterface.getCurrentUin());
        paramQQAppInterface = ((TroopGagMgr)localObject).b(paramString);
        if (((!bool2) && (bool3)) || ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.b > 0L)))
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("shouldShouldEssenchEntry: isOwner = ");
            paramString.append(bool2);
            paramString.append(", isMemberGaged = ");
            paramString.append(bool3);
            paramString.append(", isAdminOrOwner = ");
            paramString.append(bool1);
            paramString.append(", gagTimeStamp = ");
            long l;
            if (paramQQAppInterface != null) {
              l = paramQQAppInterface.b;
            } else {
              l = -1L;
            }
            paramString.append(l);
            com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, paramString.toString());
          }
          return false;
        }
        return true;
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("shouldShouldEssenchEntry, config = null: ");
        if (localTroopEssenceMsgEntryConfig == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramQQAppInterface.append(bool1);
        localObject = paramQQAppInterface.toString();
        paramQQAppInterface = (QQAppInterface)localObject;
        if (localTroopEssenceMsgEntryConfig != null)
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append((String)localObject);
          paramQQAppInterface.append(", isGrayTroop: ");
          paramQQAppInterface.append(localTroopEssenceMsgEntryConfig.a(paramString));
          paramQQAppInterface.append(", limit mem num: ");
          paramQQAppInterface.append(localTroopEssenceMsgEntryConfig.a());
          paramQQAppInterface = paramQQAppInterface.toString();
        }
        com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, paramQQAppInterface);
      }
      return false;
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, "shouldShouldEssenchEntry: app == null || troopUin is invalid");
    }
    return false;
  }
  
  public static boolean d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      if (paramChatMessage.ark_app_message != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramChatMessage.ark_app_message.metaList);
          boolean bool = "com.tencent.miniapp_01".equals(paramChatMessage.ark_app_message.appName);
          if (bool)
          {
            if (localJSONObject.has("detail_1"))
            {
              paramChatMessage = localJSONObject.optJSONObject("detail_1");
              if (paramChatMessage != null)
              {
                paramChatMessage = paramChatMessage.optString("appid");
                if (paramChatMessage.equals("1108338344")) {
                  break label254;
                }
                if (paramChatMessage.equals("1108961705")) {
                  return true;
                }
              }
            }
          }
          else if ("com.tencent.miniapp".equals(paramChatMessage.ark_app_message.appName))
          {
            if (localJSONObject.has("detail"))
            {
              paramChatMessage = localJSONObject.optJSONObject("detail");
              if (paramChatMessage != null)
              {
                paramChatMessage = paramChatMessage.optString("appid");
                if (paramChatMessage.equals("1108338344")) {
                  break label256;
                }
                if (paramChatMessage.equals("1108961705")) {
                  return true;
                }
              }
            }
          }
          else if (("com.tencent.structmsg".equals(paramChatMessage.ark_app_message.appName)) && (localJSONObject.has("news")))
          {
            paramChatMessage = localJSONObject.getJSONObject("news");
            if (paramChatMessage != null)
            {
              long l = Long.valueOf(paramChatMessage.getLong("appid")).longValue();
              if (l == 101458937L) {
                return true;
              }
            }
          }
        }
        catch (JSONException paramChatMessage)
        {
          paramChatMessage.printStackTrace();
        }
      }
    }
    return false;
    label254:
    return true;
    label256:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil
 * JD-Core Version:    0.7.0.1
 */