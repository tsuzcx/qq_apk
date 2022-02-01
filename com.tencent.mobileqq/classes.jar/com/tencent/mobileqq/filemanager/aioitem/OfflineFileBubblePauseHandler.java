package com.tencent.mobileqq.filemanager.aioitem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QFileItemBuilder.QFileBaseHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class OfflineFileBubblePauseHandler
  extends QFileBubblePauseHandler
{
  public OfflineFileBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 51)) && ((paramFileManagerEntity.status == 0) || (paramFileManagerEntity.status == 3));
  }
  
  protected ImageView a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {}
    while (!(paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return null;
    }
    return ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a;
  }
  
  protected void a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage == null) || (paramChatMessage.isMultiMsg)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("OfflineFileBubblePauseHandler", 1, "handlePauseClick: type[" + paramInt + "]");
        } while ((paramInt == -1) || (!(paramChatMessage instanceof MessageForFile)));
        paramView = (MessageForFile)paramChatMessage;
        paramViewHolder = FileManagerUtil.a(this.a, paramView);
      } while (paramViewHolder == null);
      if (paramView.istroop == 3000) {}
      for (i = 3; paramInt == 0; i = 1)
      {
        ReportController.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", i, 0, "", "", "", "");
        this.a.getFileManagerEngine().a(paramViewHolder.nSessionId);
        return;
      }
    } while (paramInt != 1);
    ReportController.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", i, 0, "", "", "", "");
    a(new OfflineFileBubblePauseHandler.1(this, i, paramViewHolder));
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ImageView paramImageView)
  {
    if (paramViewHolder == null) {}
    while (!(paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return;
    }
    ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).a = paramImageView;
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramChatMessage.isMultiMsg) || (!(paramChatMessage instanceof MessageForFile)));
        paramChatMessage = (MessageForFile)paramChatMessage;
        paramChatMessage = FileManagerUtil.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubblePauseHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
      if (((paramChatMessage.nOpType == 0) || (paramChatMessage.nOpType == 51)) && (paramChatMessage.status == 2)) {
        return true;
      }
    } while ((paramChatMessage.nOpType != 3) || (paramChatMessage.status != 2));
    return true;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramChatMessage.isMultiMsg) || (!(paramChatMessage instanceof MessageForFile)));
        paramChatMessage = (MessageForFile)paramChatMessage;
        paramChatMessage = FileManagerUtil.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubblePauseHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
      if (a(paramChatMessage)) {
        return true;
      }
    } while ((paramChatMessage.nOpType != 3) || (paramChatMessage.status != 3));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */