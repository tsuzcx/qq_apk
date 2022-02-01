package com.tencent.mobileqq.filemanager.aioitem;

import android.content.Context;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QFileItemBuilder.QFileBaseHolder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DatalineFileBubbleDownloadHandler
  extends QFileBubbleDownloadHandler
{
  public DatalineFileBubbleDownloadHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private DataLineMsgRecord a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    long l;
    do
    {
      return null;
      paramChatMessage = (MessageForDLFile)paramChatMessage;
      int i = paramChatMessage.deviceType;
      l = paramChatMessage.associatedId;
      paramChatMessage = this.a.getMessageFacade().a(i);
    } while (paramChatMessage == null);
    return paramChatMessage.a(l);
  }
  
  protected CircleFileStateView a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {}
    while (!(paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return null;
    }
    return ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a;
  }
  
  protected void a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("OfflineFileBubbleDownloadHandler", 1, "handleDownloadClick: type[" + paramInt + "]");
        } while (paramInt == -1);
        paramView = a(paramChatMessage);
      } while (paramView == null);
      paramViewHolder = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (paramInt == 0)
      {
        paramViewHolder.a(paramView.groupId, paramView.sessionid, false);
        return;
      }
    } while (paramInt != 1);
    paramChatMessage = new ArrayList();
    paramChatMessage.add(Long.valueOf(paramView.sessionid));
    paramViewHolder.a(paramChatMessage);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, CircleFileStateView paramCircleFileStateView)
  {
    if (paramViewHolder == null) {}
    while (!(paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return;
    }
    ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a = paramCircleFileStateView;
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = true;
    if (paramChatMessage == null) {}
    int i;
    do
    {
      do
      {
        return false;
        paramChatMessage = a(paramChatMessage);
      } while (paramChatMessage == null);
      i = FileManagerUtil.a(paramChatMessage.filename);
    } while ((i == 0) || (i == 2));
    boolean bool1;
    if (paramChatMessage.fileMsgStatus == 2L) {
      bool1 = true;
    }
    for (;;)
    {
      if (bool1) {
        if (!FileUtil.b(paramChatMessage.path)) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        if (paramChatMessage.fileMsgStatus == 1L)
        {
          bool1 = true;
          break;
        }
        if (paramChatMessage.issuc) {
          break label102;
        }
        bool1 = true;
        break;
        bool1 = false;
      }
      label102:
      bool1 = false;
    }
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    int i;
    do
    {
      do
      {
        return false;
        paramChatMessage = a(paramChatMessage);
      } while (paramChatMessage == null);
      i = FileManagerUtil.a(paramChatMessage.filename);
    } while ((i == 0) || (i == 2) || (!paramChatMessage.bIsTransfering));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.DatalineFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */