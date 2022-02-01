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
    if (paramChatMessage == null) {
      return null;
    }
    paramChatMessage = (MessageForDLFile)paramChatMessage;
    int i = paramChatMessage.deviceType;
    long l = paramChatMessage.associatedId;
    paramChatMessage = this.a.getMessageFacade().a(i);
    if (paramChatMessage == null) {
      return null;
    }
    return paramChatMessage.a(l);
  }
  
  protected CircleFileStateView a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return null;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a;
    }
    return null;
  }
  
  protected void a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append("handleDownloadClick: type[");
    paramView.append(paramInt);
    paramView.append("]");
    QLog.i("OfflineFileBubbleDownloadHandler", 1, paramView.toString());
    if (paramInt == -1) {
      return;
    }
    paramView = a(paramChatMessage);
    if (paramView == null) {
      return;
    }
    paramViewHolder = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramInt == 0)
    {
      paramViewHolder.a(paramView.groupId, paramView.sessionid, false);
      return;
    }
    if (paramInt == 1)
    {
      paramChatMessage = new ArrayList();
      paramChatMessage.add(Long.valueOf(paramView.sessionid));
      paramViewHolder.a(paramChatMessage);
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, CircleFileStateView paramCircleFileStateView)
  {
    if (paramViewHolder == null) {
      return;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a = paramCircleFileStateView;
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    paramChatMessage = a(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    int i = FileManagerUtil.a(paramChatMessage.filename);
    if (i != 0)
    {
      if (i == 2) {
        return false;
      }
      if (paramChatMessage.fileMsgStatus == 2L) {}
      while ((paramChatMessage.fileMsgStatus == 1L) || (!paramChatMessage.issuc))
      {
        bool2 = true;
        break;
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = FileUtil.a(paramChatMessage.path) ^ true;
      }
    }
    return bool1;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    paramChatMessage = a(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    int i = FileManagerUtil.a(paramChatMessage.filename);
    if (i != 0)
    {
      if (i == 2) {
        return false;
      }
      return paramChatMessage.bIsTransfering;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.DatalineFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */