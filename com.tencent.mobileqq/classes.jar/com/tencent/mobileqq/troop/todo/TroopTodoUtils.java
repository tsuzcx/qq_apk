package com.tencent.mobileqq.troop.todo;

import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.TodoInfoPresenter;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel.RawInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;

public class TroopTodoUtils
{
  private static TroopToDoBannerModel a;
  private static boolean b = false;
  
  public static int a(SessionInfo paramSessionInfo, ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface)
  {
    if (paramSessionInfo.a == 1) {
      try
      {
        long l = Long.parseLong(paramSessionInfo.b);
        return a(paramQQAppInterface, new TroopTodoUtils.TroopTodoMsgItemKey(l, paramChatMessage.shmsgseq, MessageUtils.b(paramChatMessage.msgUid)), paramChatMessage, l);
      }
      catch (Exception paramSessionInfo)
      {
        paramSessionInfo.printStackTrace();
      }
    }
    return 0;
  }
  
  public static int a(AIOContext paramAIOContext, int paramInt)
  {
    return ContextCompat.getColor(paramAIOContext.b(), paramInt);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, TroopTodoUtils.TroopTodoMsgItemKey paramTroopTodoMsgItemKey, ChatMessage paramChatMessage, long paramLong)
  {
    if ((paramQQAppInterface != null) && (paramTroopTodoMsgItemKey != null))
    {
      if (paramChatMessage == null) {
        return 0;
      }
      if (b(paramChatMessage)) {
        return 0;
      }
      if (!a(paramQQAppInterface, paramTroopTodoMsgItemKey.a)) {
        return 0;
      }
      boolean bool1 = TodoInfoPresenter.a().a(paramTroopTodoMsgItemKey.a, paramChatMessage.shmsgseq);
      boolean bool2 = a(paramChatMessage, paramLong);
      if ((!bool1) && (!bool2)) {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static long a(AIOContext paramAIOContext)
  {
    paramAIOContext = (SessionInfo)paramAIOContext.O();
    try
    {
      long l = Long.parseLong(paramAIOContext.b);
      return l;
    }
    catch (NumberFormatException paramAIOContext)
    {
      QLog.e("TroopTodoUtils", 2, paramAIOContext.getMessage());
    }
    return 0L;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, AIOContext paramAIOContext, long paramLong)
  {
    paramAIOContext = (SessionInfo)paramAIOContext.O();
    return paramQQAppInterface.getMessageFacade().c(paramAIOContext.b, paramAIOContext.a, paramLong);
  }
  
  public static void a(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    a = paramTroopToDoBannerModel;
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin());
    boolean bool2 = TroopUtils.a(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin());
    return (bool1) || (bool2);
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool1 = paramChatMessage instanceof MessageForStructing;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    if (paramChatMessage == null) {
      return false;
    }
    if ((paramChatMessage.mMsgServiceID != 1) && (paramChatMessage.mMsgServiceID != 33) && (paramChatMessage.mMsgServiceID != 95))
    {
      bool1 = bool2;
      if ((paramChatMessage instanceof StructMsgForGeneralShare))
      {
        bool1 = bool2;
        if (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid != 101458937L) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  @VisibleForTesting
  public static boolean a(ChatMessage paramChatMessage, long paramLong)
  {
    TroopToDoBannerModel localTroopToDoBannerModel = a;
    boolean bool2 = false;
    if (localTroopToDoBannerModel == null) {
      return false;
    }
    long l = localTroopToDoBannerModel.e().a;
    boolean bool1 = bool2;
    if (a.e().b == paramChatMessage.shmsgseq)
    {
      bool1 = bool2;
      if (paramLong == l) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = TroopTodoReportUtils.b(paramMessageRecord);
    boolean bool2 = paramMessageRecord.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (("com.tencent.mannounce".equals(paramMessageRecord)) || ("com.tencent.qzone.albumShare".equals(paramMessageRecord)) || ("com.tencent.groupphoto".equals(paramMessageRecord)) || ("com.tencent.weishi.ark".equals(paramMessageRecord)) || (paramMessageRecord.contains("com.tencent.miniapp"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void b()
  {
    a = null;
  }
  
  @VisibleForTesting
  public static boolean b(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.extraflag == 32768) || (paramChatMessage.extraflag == 32772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.todo.TroopTodoUtils
 * JD-Core Version:    0.7.0.1
 */