package com.tencent.mobileqq.filemanager.aioitem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.dataline.core.DirectForwarder;
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
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class DatalineFileBubblePauseHandler
  extends QFileBubblePauseHandler
{
  public DatalineFileBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
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
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    paramDataLineMsgRecord.bIsResendOrRecvFile = true;
    long l = paramDataLineMsgRecord.sessionid;
    int i = FileManagerUtil.a(paramDataLineMsgRecord.filename);
    if (i == 0)
    {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 1, l, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
      return;
    }
    if (i == 2)
    {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 2, l, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
      return;
    }
    i = DataLineMsgRecord.getDevTypeBySeId(l);
    if (FileUtils.fileExists(paramDataLineMsgRecord.path)) {
      localDataLineHandler.a(paramDataLineMsgRecord.path, paramDataLineMsgRecord.thumbPath, 0, l, paramDataLineMsgRecord.groupId, paramDataLineMsgRecord.groupSize, paramDataLineMsgRecord.groupIndex, true);
    }
    if (paramDataLineMsgRecord.nOpType == 35)
    {
      localDataLineHandler.b(paramDataLineMsgRecord);
      return;
    }
    localDataLineHandler.a().a(paramDataLineMsgRecord, i, 2);
  }
  
  protected ImageView a(BaseBubbleBuilder.ViewHolder paramViewHolder)
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
    if (paramChatMessage != null)
    {
      if (paramChatMessage.isMultiMsg) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("handlePauseClick: type[");
      paramView.append(paramInt);
      paramView.append("]");
      QLog.i("QFileBubblePauseHandler", 1, paramView.toString());
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
      if (paramInt == 1) {
        a(paramView);
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ImageView paramImageView)
  {
    if (paramViewHolder == null) {
      return;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a = paramImageView;
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    return super.a(paramChatMessage);
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    return super.b(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.DatalineFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */