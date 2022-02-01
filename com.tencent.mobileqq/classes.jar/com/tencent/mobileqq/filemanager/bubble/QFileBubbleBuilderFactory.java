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
    boolean bool = paramChatMessage.isMultiMsg;
    int j = -1;
    int i;
    if (bool)
    {
      i = FileManagerUtil.d(paramChatMessage);
    }
    else if ((paramChatMessage instanceof MessageForFile))
    {
      paramQQAppInterface = paramQQAppInterface.getFileManagerDataCenter().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      i = j;
      if (paramQQAppInterface != null)
      {
        i = j;
        if (paramQQAppInterface.cloudType != 0) {
          i = FileManagerUtil.c(paramQQAppInterface.fileName);
        }
      }
    }
    else if ((paramChatMessage instanceof MessageForTroopFile))
    {
      i = FileManagerUtil.c(((MessageForTroopFile)paramChatMessage).fileName);
    }
    else
    {
      i = j;
      if ((paramChatMessage instanceof MessageForDLFile)) {
        i = FileManagerUtil.c(((MessageForDLFile)paramChatMessage).fileName);
      }
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      if (i != 0) {}
    }
    do
    {
      return 61;
      if (i != 2) {
        break label184;
      }
      return 65;
      if (!(paramChatMessage instanceof MessageForTroopFile)) {
        break;
      }
    } while (i == 0);
    if (i == 2)
    {
      return 65;
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
    }
    label184:
    return 3;
  }
  
  public static QFileItemBuilder a(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, ChatMessage paramChatMessage)
  {
    if ((paramInt != 3) && (paramInt != 120))
    {
      if ((paramInt != 61) && (paramInt != 121))
      {
        if ((paramInt != 65) && (paramInt != 122))
        {
          QLog.e("QFileBubbleBuilderFactory", 1, "");
          paramBaseAdapter = new QFileSimpleItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
        }
        else
        {
          paramBaseAdapter = new QFileVideoItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
        }
      }
      else {
        paramBaseAdapter = new QFileImageItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
    }
    else {
      paramBaseAdapter = new QFileSimpleItemBuilder(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    }
    paramChatMessage = a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage);
    paramAIOAnimationConatiner = paramChatMessage;
    if (paramChatMessage == null)
    {
      QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleItemBuilder error, bubbleModel is not.");
      paramAIOAnimationConatiner = new DefaultBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    paramBaseAdapter.a(paramAIOAnimationConatiner);
    return paramBaseAdapter;
  }
  
  public static QFileBubbleModel a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFileBubbleModel, fileType[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("] extInfo[");
        localStringBuilder.append(paramChatMessage.extStr);
        localStringBuilder.append("]");
        QLog.e("QFileBubbleBuilderFactory", 1, localStringBuilder.toString());
        int i = Integer.parseInt((String)localObject);
        if (i == 3) {
          return new TroopFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        if (i == 1) {
          return new OfflineFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        if (i == 2) {
          return new OfflineFileBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFileBubbleModel error, not support fileType. fileType[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("] extInfo[");
        localStringBuilder.append(paramChatMessage.extStr);
        localStringBuilder.append("]");
        QLog.e("QFileBubbleBuilderFactory", 1, localStringBuilder.toString());
        return new DefaultBubbleModel(paramQQAppInterface, paramContext, paramSessionInfo);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFileBubbleModel error,multi file not exist fileType. extInfo[");
      ((StringBuilder)localObject).append(paramChatMessage.extStr);
      ((StringBuilder)localObject).append("]");
      QLog.e("QFileBubbleBuilderFactory", 1, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.QFileBubbleBuilderFactory
 * JD-Core Version:    0.7.0.1
 */