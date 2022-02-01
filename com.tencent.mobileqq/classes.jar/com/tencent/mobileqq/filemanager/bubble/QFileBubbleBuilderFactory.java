package com.tencent.mobileqq.filemanager.bubble;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.QFileImageItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QFileItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QFileSimpleItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QFileVideoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class QFileBubbleBuilderFactory
{
  public static int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int j = -1;
    int i;
    if (paramChatMessage.isMultiMsg) {
      i = FileManagerUtil.a(paramChatMessage);
    }
    while ((paramChatMessage instanceof MessageForFile)) {
      if (i == 0)
      {
        return 61;
        if ((paramChatMessage instanceof MessageForFile))
        {
          paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
          i = j;
          if (paramQQAppInterface != null)
          {
            i = j;
            if (paramQQAppInterface.cloudType != 0) {
              i = FileManagerUtil.a(paramQQAppInterface.fileName);
            }
          }
        }
        else if ((paramChatMessage instanceof MessageForTroopFile))
        {
          i = FileManagerUtil.a(((MessageForTroopFile)paramChatMessage).fileName);
        }
        else
        {
          i = j;
          if ((paramChatMessage instanceof MessageForDLFile)) {
            i = FileManagerUtil.a(((MessageForDLFile)paramChatMessage).fileName);
          }
        }
      }
      else
      {
        if (i == 2) {
          return 65;
        }
        return 3;
      }
    }
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      if (i == 0) {
        return 61;
      }
      if (i == 2) {
        return 65;
      }
      return 3;
    }
    if ((paramChatMessage instanceof MessageForDLFile))
    {
      if (i == 0) {
        return 121;
      }
      if (i == 2) {
        return 122;
      }
      return 120;
    }
    return 3;
  }
  
  public static QFileItemBuilder a(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, ChatMessage paramChatMessage)
  {
    if ((paramInt == 3) || (paramInt == 120)) {
      paramBaseAdapter = new QFileSimpleItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    }
    for (;;)
    {
      paramChatMessage = a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage);
      paramAIOAnimationConatiner = paramChatMessage;
      if (paramChatMessage == null)
      {
        QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleItemBuilder error, bubbleModel is not.");
        paramAIOAnimationConatiner = new DefaultBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
      }
      paramBaseAdapter.a(paramAIOAnimationConatiner);
      return paramBaseAdapter;
      if ((paramInt == 61) || (paramInt == 121))
      {
        paramBaseAdapter = new QFileImageItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
      else if ((paramInt == 65) || (paramInt == 122))
      {
        paramBaseAdapter = new QFileVideoItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
      else
      {
        QLog.e("QFileBubbleBuilderFactory", 1, "");
        paramBaseAdapter = new QFileSimpleItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
    }
  }
  
  public static QFileBubbleModel a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty(str))
      {
        QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel, fileType[" + str + "] extInfo[" + paramChatMessage.extStr + "]");
        int i = Integer.parseInt(str);
        if (i == 3) {
          return new TroopFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        if (i == 1) {
          return new OfflineFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        if (i == 2) {
          return new OfflineFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel error, not support fileType. fileType[" + str + "] extInfo[" + paramChatMessage.extStr + "]");
        return new DefaultBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
      }
      QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel error,multi file not exist fileType. extInfo[" + paramChatMessage.extStr + "]");
      return new DefaultBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return new OfflineFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    if ((paramChatMessage instanceof MessageForTroopFile)) {
      return new TroopFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    if ((paramChatMessage instanceof MessageForDLFile)) {
      return new DatalineFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel error, is not file msg.");
    return new DefaultBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.QFileBubbleBuilderFactory
 * JD-Core Version:    0.7.0.1
 */