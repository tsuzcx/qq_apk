package com.tencent.mobileqq.troop.essencemsg;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
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
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemKey;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgItemValue;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem.TroopEssenceMsgPushItem;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
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
  private static int a;
  
  static
  {
    jdField_a_of_type_Int = 10;
  }
  
  public static int a(SessionInfo paramSessionInfo, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    long l1;
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception paramSessionInfo)
    {
      for (;;)
      {
        paramSessionInfo.printStackTrace();
      }
    }
    i = a(paramQQAppInterface, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage);
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int i = 0;
    if (paramChatMessage == null) {
      return 0;
    }
    if (((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForLongTextMsg))) {
      return 1;
    }
    if ((paramChatMessage instanceof MessageForMixedMsg)) {
      return 2;
    }
    if ((paramChatMessage instanceof MessageForPic)) {
      return 3;
    }
    if (((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForTroopFile)))
    {
      switch (ItemBuilderFactory.a(paramQQAppInterface, paramChatMessage))
      {
      default: 
        return 6;
      case 61: 
      case 121: 
        return 4;
      }
      return 5;
    }
    if ((c(paramChatMessage)) || (d(paramChatMessage))) {
      i = 1;
    }
    if (i != 0) {
      return 7;
    }
    if ((a(paramChatMessage)) || (b(paramChatMessage))) {
      return 8;
    }
    return 9;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, TroopEssenceMsgItem.TroopEssenceMsgItemKey paramTroopEssenceMsgItemKey, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface == null) || (paramTroopEssenceMsgItemKey == null) || (paramChatMessage == null)) {}
    label130:
    label262:
    for (;;)
    {
      return 0;
      if ((!AnonymousChatHelper.a(paramChatMessage)) && ((!paramChatMessage.isSendFromLocal()) || ((paramChatMessage.extraflag != 32768) && (paramChatMessage.extraflag != 32772))))
      {
        paramChatMessage = (TroopEssenceMsgEntryConfig)QConfigManager.a().a(668);
        if ((paramChatMessage != null) && (paramChatMessage.a(Long.toString(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long))) && (paramChatMessage.a() != 0))
        {
          boolean bool1 = TroopUtils.b(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long), paramQQAppInterface.getCurrentUin());
          boolean bool2 = TroopUtils.a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long), paramQQAppInterface.getCurrentUin());
          int i;
          Object localObject;
          if ((bool1) || (bool2))
          {
            i = 1;
            localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (localObject == null) {
              break label258;
            }
            localObject = ((TroopManager)localObject).c(String.valueOf(paramTroopEssenceMsgItemKey.jdField_a_of_type_Long));
            if (localObject == null) {
              break label258;
            }
          }
          for (int j = ((TroopInfo)localObject).wMemberNum;; j = 0)
          {
            if ((i == 0) && (j > paramChatMessage.a())) {
              break label262;
            }
            paramChatMessage = (TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
            paramChatMessage.b(paramTroopEssenceMsgItemKey);
            paramTroopEssenceMsgItemKey = paramChatMessage.a(paramTroopEssenceMsgItemKey);
            if ((paramTroopEssenceMsgItemKey == null) || (paramTroopEssenceMsgItemKey.jdField_a_of_type_Int == 2))
            {
              return 1;
              i = 0;
              break label130;
            }
            if ((i == 0) && (!TextUtils.isEmpty(paramTroopEssenceMsgItemKey.b)) && (!paramTroopEssenceMsgItemKey.b.equals(paramQQAppInterface.getCurrentUin()))) {
              break;
            }
            return 2;
          }
        }
      }
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.dwGroupClassExt;
      }
    }
    return 0L;
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem paramTroopBatchEssenceMsgPushItem)
  {
    if ((paramQQAppInterface == null) || (paramTroopBatchEssenceMsgPushItem == null) || (paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList == null) || (paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    String str2 = String.valueOf(paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_Long);
    String str1 = BaseApplicationImpl.getContext().getResources().getString(2131720101);
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131720100).replace("$COUNT", String.valueOf(paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList.size()));
    String str3 = paramTroopBatchEssenceMsgPushItem.b + (String)localObject + str1;
    localObject = new UniteGrayTipParam(str2, str2, str3, 1, -5040, 131090, MessageCache.a());
    long l = 0L;
    paramTroopBatchEssenceMsgPushItem = paramTroopBatchEssenceMsgPushItem.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (paramTroopBatchEssenceMsgPushItem.hasNext())
    {
      TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)paramTroopBatchEssenceMsgPushItem.next();
      if (localTroopEssenceMsgItem.msgSeq <= l) {
        break label274;
      }
      l = localTroopEssenceMsgItem.msgSeq;
      i = localTroopEssenceMsgItem.msgRandom;
    }
    label274:
    for (;;)
    {
      break;
      paramTroopBatchEssenceMsgPushItem = new Bundle();
      str2 = a(str2, l, i);
      paramTroopBatchEssenceMsgPushItem.putInt("key_action", 1);
      paramTroopBatchEssenceMsgPushItem.putString("textColor", "#40A0FF");
      paramTroopBatchEssenceMsgPushItem.putString("key_action_DATA", str2);
      ((UniteGrayTipParam)localObject).a(str3.length() - str1.length(), str3.length(), paramTroopBatchEssenceMsgPushItem);
      paramTroopBatchEssenceMsgPushItem = new MessageForUniteGrayTip();
      paramTroopBatchEssenceMsgPushItem.createMessageUniseq();
      paramTroopBatchEssenceMsgPushItem.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
      return paramTroopBatchEssenceMsgPushItem;
    }
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, TroopEssenceMsgItem.TroopEssenceMsgPushItem paramTroopEssenceMsgPushItem)
  {
    if ((paramQQAppInterface == null) || (paramTroopEssenceMsgPushItem == null) || (paramTroopEssenceMsgPushItem.a == null)) {
      return null;
    }
    Object localObject2 = String.valueOf(paramTroopEssenceMsgPushItem.a.troopUin);
    Object localObject1 = BaseApplicationImpl.getContext().getResources().getString(2131720102);
    String str1 = BaseApplicationImpl.getContext().getResources().getString(2131720101);
    String str3 = ((String)localObject1).replace("$MSGSENDERNAME", paramTroopEssenceMsgPushItem.b);
    String str2 = str3 + BaseApplicationImpl.getContext().getResources().getString(2131720104) + str1;
    localObject1 = new UniteGrayTipParam((String)localObject2, (String)localObject2, str2, 1, -5040, 131090, MessageCache.a());
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
  
  @Nullable
  public static TroopEssenceMsgItem.TroopBatchEssenceMsgPushItem a(long paramLong, TroopTips0x857.QQGroupDigestMsgSummary paramQQGroupDigestMsgSummary)
  {
    if ((paramQQGroupDigestMsgSummary == null) || (paramQQGroupDigestMsgSummary.succ_cnt.get() == 0) || (!paramQQGroupDigestMsgSummary.summary_info.has()) || (paramQQGroupDigestMsgSummary.summary_info.size() == 0)) {
      return null;
    }
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
  
  public static TroopEssenceMsgItem.TroopEssenceMsgPushItem a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg)
  {
    if (paramQQGroupDigestMsg == null) {
      return null;
    }
    TroopEssenceMsgItem.TroopEssenceMsgItemKey localTroopEssenceMsgItemKey = new TroopEssenceMsgItem.TroopEssenceMsgItemKey(paramQQGroupDigestMsg.group_code.get(), paramQQGroupDigestMsg.msg_seq.get(), paramQQGroupDigestMsg.msg_random.get());
    TroopEssenceMsgItem.TroopEssenceMsgItemValue localTroopEssenceMsgItemValue = new TroopEssenceMsgItem.TroopEssenceMsgItemValue(paramQQGroupDigestMsg.op_type.get(), String.valueOf(paramQQGroupDigestMsg.msg_sender.get()), String.valueOf(paramQQGroupDigestMsg.digest_oper.get()), paramQQGroupDigestMsg.op_time.get(), 0L);
    String str1 = "";
    String str2 = "";
    if (paramQQGroupDigestMsg.oper_nick.has()) {
      str1 = paramQQGroupDigestMsg.oper_nick.get().toStringUtf8();
    }
    if (paramQQGroupDigestMsg.sender_nick.has()) {
      str2 = paramQQGroupDigestMsg.sender_nick.get().toStringUtf8();
    }
    return new TroopEssenceMsgItem.TroopEssenceMsgPushItem(new TroopEssenceMsgItem(localTroopEssenceMsgItemKey, localTroopEssenceMsgItemValue), paramQQGroupDigestMsg.lastest_msg_seq.get(), str1, str2);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      if (paramString2.equals(paramQQAppInterface.getCurrentUin())) {
        return BaseApplicationImpl.getContext().getResources().getString(2131720103);
      }
      paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramString2, paramString1, ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).d(paramString1), true, null);
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramQQAppInterface = paramString3;
    } while (!TextUtils.isEmpty(paramString3));
    return paramString2;
    return paramQQAppInterface;
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
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      long l = Long.parseLong(paramString2);
      if ((paramContext instanceof FragmentActivity))
      {
        paramContext = ((FragmentActivity)paramContext).getChatFragment();
        if ((paramContext != null) && (paramContext.a() != null) && ((paramContext.a() instanceof BaseTroopChatPie))) {
          paramContext.a().a(103, l, 0, null);
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
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramTroopEssenceMsgItem == null)) {}
    long l;
    int i;
    label134:
    do
    {
      return;
      l = a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin));
      if ((TroopUtils.b(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.getCurrentUin())) || (TroopUtils.a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.getCurrentUin())))
      {
        i = 1;
        if (paramTroopEssenceMsgItem.opType != 1) {
          continue;
        }
        paramTroopEssenceMsgItem = Long.toString(paramTroopEssenceMsgItem.troopUin);
        j = a(paramQQAppInterface, paramChatMessage);
        if (i == 0) {
          break label134;
        }
      }
      for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
      {
        ReportController.b(null, "dc00898", "", paramTroopEssenceMsgItem, "0X800B34B", "0X800B34B", 0, 0, String.valueOf(l), String.valueOf(j), paramQQAppInterface, "");
        return;
        i = 0;
        break;
      }
    } while (paramTroopEssenceMsgItem.opType != 2);
    String str2 = Long.toString(paramTroopEssenceMsgItem.troopUin);
    int j = a(paramQQAppInterface, paramChatMessage);
    if (i != 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      ReportController.b(null, "dc00898", "", str2, "0X800B34D", "0X800B34D", 0, 0, String.valueOf(l), String.valueOf(j), str1, "");
      TroopEssenceReportUtil.a(paramQQAppInterface, paramTroopEssenceMsgItem.troopUin, a(paramQQAppInterface, paramChatMessage), true, 2);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ReportController.b(null, "dc00898", "", paramString, "0X800B34F", "0X800B34F", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, Context paramContext, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    do
    {
      return;
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
    } while (paramInt2 != 2);
    TroopEssenceReportUtil.a(paramQQAppInterface, paramString, false);
    TroopEssenceReportUtil.b(paramQQAppInterface, paramString, false);
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
      localTroopEssenceMsgItem.troopUin = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      localTroopEssenceMsgItem.msgSeq = paramChatMessage.shmsgseq;
      localTroopEssenceMsgItem.msgRandom = MessageUtils.b(paramChatMessage.msgUid);
      localTroopEssenceMsgItem.opUin = paramQQAppInterface.getCurrentUin();
      localTroopEssenceMsgItem.msgSenderUin = paramChatMessage.senderuin;
      localTroopEssenceMsgItem.opType = paramInt;
      localTroopEssenceMsgItem.msgType = a(paramQQAppInterface, paramChatMessage);
      ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(localTroopEssenceMsgItem, 1);
      a(paramQQAppInterface, paramChatMessage, localTroopEssenceMsgItem);
      return;
    }
    catch (Exception paramSessionInfo)
    {
      for (;;)
      {
        paramSessionInfo.printStackTrace();
      }
    }
  }
  
  public static void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu, @Nonnull SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    long l1;
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception paramSessionInfo)
    {
      int i;
      do
      {
        for (;;)
        {
          paramSessionInfo.printStackTrace();
        }
      } while (i != 1);
      paramQQCustomMenu.a(2131366427, paramContext.getString(2131720114), 0);
    }
    i = a(paramQQAppInterface, new TroopEssenceMsgItem.TroopEssenceMsgItemKey(l1, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage);
    if (i == 2)
    {
      paramQQCustomMenu.a(2131366428, paramContext.getString(2131720115), 0);
      return;
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
    if ((paramList == null) || (paramList.isEmpty()) || (paramList.size() > jdField_a_of_type_Int)) {
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, "shouldShouldEssenchEntry: app == null || troopUin is invalid");
      }
    }
    Object localObject1;
    do
    {
      return false;
      localObject1 = (TroopEssenceMsgEntryConfig)QConfigManager.a().a(668);
      if ((localObject1 != null) && (((TroopEssenceMsgEntryConfig)localObject1).a(paramString)) && (((TroopEssenceMsgEntryConfig)localObject1).a() != 0)) {
        break;
      }
    } while (!com.tencent.TMG.utils.QLog.isColorLevel());
    paramQQAppInterface = new StringBuilder().append("shouldShouldEssenchEntry, config = null: ");
    boolean bool1;
    if (localObject1 == null)
    {
      bool1 = true;
      label92:
      paramQQAppInterface = bool1;
      if (localObject1 == null) {
        break label453;
      }
      paramQQAppInterface = paramQQAppInterface + ", isGrayTroop: " + ((TroopEssenceMsgEntryConfig)localObject1).a(paramString) + ", limit mem num: " + ((TroopEssenceMsgEntryConfig)localObject1).a();
    }
    label448:
    label453:
    for (;;)
    {
      com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, paramQQAppInterface);
      return false;
      bool1 = false;
      break label92;
      bool1 = TroopUtils.b(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentUin());
      boolean bool2 = TroopUtils.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentUin());
      label197:
      Object localObject2;
      if ((bool1) || (bool2))
      {
        bool1 = true;
        localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject2 == null) {
          break label448;
        }
        localObject2 = ((TroopManager)localObject2).c(paramString);
        if (localObject2 == null) {
          break label448;
        }
      }
      for (int i = ((TroopInfo)localObject2).wMemberNum;; i = 0)
      {
        if ((!bool1) && (i > ((TroopEssenceMsgEntryConfig)localObject1).a()))
        {
          if (!com.tencent.TMG.utils.QLog.isColorLevel()) {
            break;
          }
          com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, "shouldShouldEssenchEntry: troopMemberNum = " + i + ", LimitMemberNum = " + ((TroopEssenceMsgEntryConfig)localObject1).a());
          return false;
          bool1 = false;
          break label197;
        }
        localObject1 = (TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        boolean bool3 = ((TroopGagMgr)localObject1).a(paramString, paramQQAppInterface.getCurrentUin());
        paramQQAppInterface = ((TroopGagMgr)localObject1).a(paramString);
        if (((!bool2) && (bool3)) || ((!bool1) && (paramQQAppInterface != null) && (paramQQAppInterface.jdField_a_of_type_Long > 0L)))
        {
          if (!com.tencent.TMG.utils.QLog.isColorLevel()) {
            break;
          }
          paramString = new StringBuilder().append("shouldShouldEssenchEntry: isOwner = ").append(bool2).append(", isMemberGaged = ").append(bool3).append(", isAdminOrOwner = ").append(bool1).append(", gagTimeStamp = ");
          if (paramQQAppInterface != null) {}
          for (long l = paramQQAppInterface.jdField_a_of_type_Long;; l = -1L)
          {
            com.tencent.TMG.utils.QLog.i("TroopEssenceUtil", 1, l);
            return false;
          }
        }
        return true;
      }
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
      return false;
    }
    paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    if (paramChatMessage == null) {
      return false;
    }
    return (paramChatMessage.mMsgServiceID == 1) || (paramChatMessage.mMsgServiceID == 33) || (paramChatMessage.mMsgServiceID == 95) || (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == TeamWorkUtils.jdField_a_of_type_Long));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ReportController.b(null, "dc00898", "", paramString, "0X800B34E", "0X800B34E", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null)) {
      return false;
    }
    if ("com.tencent.structmsg".equals(localMessageForArkApp.ark_app_message.appName)) {
      return true;
    }
    return d(paramChatMessage);
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
        if (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == TeamWorkUtils.jdField_a_of_type_Long)) {
          return true;
        }
        if ((!TextUtils.isEmpty(paramChatMessage.mMsgUrl)) && (FMConstants.a(paramChatMessage.mMsgUrl))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        paramChatMessage = (MessageForArkApp)paramChatMessage;
        if (paramChatMessage.ark_app_message != null) {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramChatMessage.ark_app_message.metaList);
            if ("com.tencent.miniapp_01".equals(paramChatMessage.ark_app_message.appName))
            {
              if (!localJSONObject.has("detail_1")) {
                continue;
              }
              paramChatMessage = localJSONObject.optJSONObject("detail_1");
              if (paramChatMessage == null) {
                continue;
              }
              paramChatMessage = paramChatMessage.optString("appid");
              if (!paramChatMessage.equals("1108338344")) {
                if (!paramChatMessage.equals("1108961705")) {
                  continue;
                }
              }
            }
            else
            {
              if ("com.tencent.miniapp".equals(paramChatMessage.ark_app_message.appName))
              {
                if (!localJSONObject.has("detail")) {
                  continue;
                }
                paramChatMessage = localJSONObject.optJSONObject("detail");
                if (paramChatMessage == null) {
                  continue;
                }
                paramChatMessage = paramChatMessage.optString("appid");
                if (paramChatMessage.equals("1108338344")) {
                  break label258;
                }
                if (!paramChatMessage.equals("1108961705")) {
                  continue;
                }
                break label258;
              }
              if ((!"com.tencent.structmsg".equals(paramChatMessage.ark_app_message.appName)) || (!localJSONObject.has("news"))) {
                continue;
              }
              paramChatMessage = localJSONObject.getJSONObject("news");
              if (paramChatMessage == null) {
                continue;
              }
              long l1 = Long.valueOf(paramChatMessage.getLong("appid")).longValue();
              long l2 = TeamWorkUtils.jdField_a_of_type_Long;
              if (l1 != l2) {
                continue;
              }
              return true;
            }
          }
          catch (JSONException paramChatMessage)
          {
            paramChatMessage.printStackTrace();
            return false;
          }
        }
      }
    }
    return true;
    label258:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil
 * JD-Core Version:    0.7.0.1
 */