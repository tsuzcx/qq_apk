package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class DoutuMsgUtil
{
  @NotNull
  public static DoutuMsgItem a(ChatMessage paramChatMessage)
  {
    DoutuMsgItem localDoutuMsgItem = new DoutuMsgItem();
    localDoutuMsgItem.jdField_a_of_type_Long = paramChatMessage.time;
    localDoutuMsgItem.jdField_a_of_type_Boolean = paramChatMessage.isSend();
    localDoutuMsgItem.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
    localDoutuMsgItem.jdField_b_of_type_Boolean = paramChatMessage.isFlowMessage;
    localDoutuMsgItem.jdField_c_of_type_JavaLangString = paramChatMessage.senderuin;
    localDoutuMsgItem.e = paramChatMessage.hasPlayedDui;
    a(paramChatMessage, localDoutuMsgItem);
    return localDoutuMsgItem;
  }
  
  private static List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (ChatMessage)paramList.next();
      if (a((MessageRecord)localObject)) {
        localArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("filterDoutuMsg , doutuList: \n");
      int i = 0;
      while (i < localArrayList.size())
      {
        paramList.append("[Doutu]");
        paramList.append(" index = ");
        paramList.append(i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", time = ");
        ((StringBuilder)localObject).append(((ChatMessage)localArrayList.get(i)).time);
        paramList.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", isSend = ");
        ((StringBuilder)localObject).append(((ChatMessage)localArrayList.get(i)).isSend());
        paramList.append(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", shmsgseq = ");
        ((StringBuilder)localObject).append(((ChatMessage)localArrayList.get(i)).shmsgseq);
        paramList.append(((StringBuilder)localObject).toString());
        paramList.append(" ; \n");
        i += 1;
      }
      QLog.d("DoutuMsgUtil", 2, paramList.toString());
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (a(paramList, paramSessionInfo, paramBaseChatPie)) {
      return;
    }
    paramList = a(paramList);
    if (paramList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(a((ChatMessage)((Iterator)localObject).next()));
    }
    localObject = (DoutuHelper)paramBaseChatPie.a(115);
    if (((DoutuHelper)localObject).a == null)
    {
      ((DoutuHelper)localObject).a = ((IDoutuService)paramQQAppInterface.getRuntimeService(IDoutuService.class, ""));
      AIODoutuListenerImpl localAIODoutuListenerImpl = new AIODoutuListenerImpl(paramQQAppInterface, paramBaseChatPie);
      String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramSessionInfo.jdField_a_of_type_Int;
      paramSessionInfo = paramSessionInfo.jdField_b_of_type_JavaLangString;
      ((DoutuHelper)localObject).a.init(paramBaseChatPie.a(), paramQQAppInterface, paramBaseChatPie.a(), localAIODoutuListenerImpl, str, String.valueOf(i), paramSessionInfo);
    }
    paramInt = ((DoutuHelper)localObject).a.handleAioMsgForDoutu(localArrayList, paramInt);
    if (paramInt != -1) {
      ((ChatMessage)paramList.get(paramInt)).isDui = true;
    }
  }
  
  private static void a(ChatMessage paramChatMessage, DoutuMsgItem paramDoutuMsgItem)
  {
    boolean bool = paramChatMessage instanceof MessageForMarketFace;
    int i = 4;
    if (bool)
    {
      paramDoutuMsgItem.jdField_c_of_type_Boolean = true;
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = paramChatMessage.mMarkFaceMessage;
        paramDoutuMsgItem.jdField_a_of_type_JavaLangString = EmosmUtils.a(paramChatMessage.sbufID, paramChatMessage.mediaType);
      }
      i = 1;
    }
    else
    {
      if ((paramChatMessage instanceof MessageForPic))
      {
        paramDoutuMsgItem.d = true;
        paramChatMessage = (MessageForPic)paramChatMessage;
        paramDoutuMsgItem.jdField_b_of_type_JavaLangString = paramChatMessage.md5;
        PicMessageExtraData localPicMessageExtraData = paramChatMessage.picExtraData;
        if ((localPicMessageExtraData != null) && (localPicMessageExtraData.imageBizType == 1))
        {
          i = 2;
          break label172;
        }
        if ((localPicMessageExtraData != null) && (localPicMessageExtraData.imageBizType == 3))
        {
          i = 3;
          break label172;
        }
        if ((localPicMessageExtraData != null) && (localPicMessageExtraData.isHotPics())) {
          break label172;
        }
        if ((paramChatMessage.imageType == 2000) || (paramChatMessage.imageType == 3) || (paramChatMessage.imageType == 4))
        {
          i = 5;
          break label172;
        }
      }
      i = 6;
    }
    label172:
    paramDoutuMsgItem.jdField_a_of_type_Int = i;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (b(paramMessageRecord)) || (c(paramMessageRecord));
  }
  
  private static boolean a(List<ChatMessage> paramList, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramSessionInfo == null) {
        return true;
      }
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        localChatMessage.isDui = false;
        if (localChatMessage.isMultiMsg) {
          i = 1;
        }
      }
      if (Utils.b(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      if (paramBaseChatPie.z) {
        return true;
      }
      return i != 0;
    }
    return true;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      return true;
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      PicMessageExtraData localPicMessageExtraData = paramMessageRecord.picExtraData;
      if ((paramMessageRecord.imageType != 2000) && (paramMessageRecord.imageType != 3))
      {
        if (paramMessageRecord.imageType == 4) {
          return true;
        }
        return (localPicMessageExtraData != null) && ((localPicMessageExtraData.imageBizType == 1) || (localPicMessageExtraData.imageBizType == 3) || (localPicMessageExtraData.isHotPics()));
      }
      return true;
    }
    return ((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).isHotPicsStruct());
  }
  
  private static boolean c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.size > 0L) && (paramMessageRecord.size < 512000L) && (paramMessageRecord.width > 0L) && (paramMessageRecord.width < 500L) && (paramMessageRecord.height > 0L) && (paramMessageRecord.height < 500L)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuMsgUtil
 * JD-Core Version:    0.7.0.1
 */