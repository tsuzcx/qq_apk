package com.tencent.mobileqq.jubao;

import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JubaoHelper
{
  public static List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if ((!MsgProxyUtils.e(localChatMessage.msgtype)) && (!BeancurdManager.a(localChatMessage))) {
          localArrayList.add(localChatMessage);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("filterMsgSize = ");
      paramList.append(localArrayList.size());
      QLog.d("jubaoApiPlugin", 0, paramList.toString());
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    MultiMsgManager.a().e = 7;
    Object localObject2 = paramIntent.getStringExtra("uin");
    int j = paramIntent.getIntExtra("uintype", 0);
    paramIntent = paramIntent.getSerializableExtra("msgs");
    if (paramIntent != null)
    {
      Object localObject3 = (ArrayList)paramIntent;
      if (((ArrayList)localObject3).size() == 0) {
        return;
      }
      paramIntent = (JubaoMsgData)((ArrayList)localObject3).get(0);
      int i = 1;
      JubaoMsgData localJubaoMsgData;
      Object localObject1;
      while (i < ((ArrayList)localObject3).size())
      {
        localJubaoMsgData = (JubaoMsgData)((ArrayList)localObject3).get(i);
        if ((j != 3000) && (j != 1))
        {
          localObject1 = paramIntent;
          if (paramIntent.msgTime <= localJubaoMsgData.msgTime) {
            break label134;
          }
        }
        else
        {
          localObject1 = paramIntent;
          if (paramIntent.msgSeq <= localJubaoMsgData.msgSeq) {
            break label134;
          }
        }
        localObject1 = localJubaoMsgData;
        label134:
        i += 1;
        paramIntent = (Intent)localObject1;
      }
      if ((j != 3000) && (j != 1)) {
        i = paramIntent.msgTime;
      } else {
        i = paramIntent.msgSeq;
      }
      long l = i;
      paramIntent = new ArrayList();
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().i((String)localObject2, j, l);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        localObject1 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label358;
          }
          localJubaoMsgData = (JubaoMsgData)((Iterator)localObject1).next();
          localObject2 = paramQQAppInterface.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ChatMessage)((Iterator)localObject2).next();
            i = (int)((ChatMessage)localObject3).time;
            if ((j != 3000) && (j != 1))
            {
              int k = (short)(int)((ChatMessage)localObject3).shmsgseq;
              if ((localJubaoMsgData.msgSeq != (0xFFFF & k)) || (localJubaoMsgData.msgTime != i)) {
                break;
              }
              paramIntent.add(localObject3);
              continue;
            }
            i = (int)((ChatMessage)localObject3).shmsgseq;
            if (localJubaoMsgData.msgSeq != i) {
              break;
            }
            paramIntent.add(localObject3);
          }
        }
      }
      label358:
      if (paramIntent.size() > 0)
      {
        paramQQAppInterface = paramIntent.iterator();
        while (paramQQAppInterface.hasNext())
        {
          localObject1 = (ChatMessage)paramQQAppInterface.next();
          MultiMsgManager.a().b.put(localObject1, Boolean.valueOf(true));
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleOpenAIO = ");
        paramQQAppInterface.append(paramIntent.size());
        QLog.d("jubaoApiPlugin", 0, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoHelper
 * JD-Core Version:    0.7.0.1
 */