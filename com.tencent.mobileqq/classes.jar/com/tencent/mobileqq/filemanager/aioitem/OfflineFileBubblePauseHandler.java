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
    if (paramViewHolder == null) {
      return null;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).u;
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
      QLog.i("OfflineFileBubblePauseHandler", 1, paramView.toString());
      if (paramInt == -1) {
        return;
      }
      if ((paramChatMessage instanceof MessageForFile))
      {
        paramView = (MessageForFile)paramChatMessage;
        paramViewHolder = FileManagerUtil.a(this.b, paramView);
        if (paramViewHolder == null) {
          return;
        }
        int i;
        if (paramView.istroop == 3000) {
          i = 3;
        } else {
          i = 1;
        }
        if (paramInt == 0)
        {
          ReportController.b(this.b, "dc00898", "", "", "0X800A7F1", "0X800A7F1", i, 0, "", "", "", "");
          this.b.getFileManagerEngine().a(paramViewHolder.nSessionId);
          return;
        }
        if (paramInt == 1)
        {
          ReportController.b(this.b, "dc00898", "", "", "0X800A7F2", "0X800A7F2", i, 0, "", "", "", "");
          a(new OfflineFileBubblePauseHandler.1(this, i, paramViewHolder));
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ImageView paramImageView)
  {
    if (paramViewHolder == null) {
      return;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).u = paramImageView;
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
    if ((paramChatMessage instanceof MessageForFile))
    {
      paramChatMessage = (MessageForFile)paramChatMessage;
      paramChatMessage = FileManagerUtil.a(this.b, paramChatMessage);
      if (paramChatMessage == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowPauseIcon: current file nOpType[");
        localStringBuilder.append(paramChatMessage.nOpType);
        localStringBuilder.append("] status[");
        localStringBuilder.append(paramChatMessage.status);
        localStringBuilder.append("]");
        QLog.i("OfflineFileBubblePauseHandler", 1, localStringBuilder.toString());
      }
      if (((paramChatMessage.nOpType == 0) || (paramChatMessage.nOpType == 51)) && (paramChatMessage.status == 2)) {
        return true;
      }
      if ((paramChatMessage.nOpType == 3) && (paramChatMessage.status == 2)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    if (paramChatMessage.isMultiMsg) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForFile))
    {
      paramChatMessage = (MessageForFile)paramChatMessage;
      paramChatMessage = FileManagerUtil.a(this.b, paramChatMessage);
      if (paramChatMessage == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowPauseIcon: current file nOpType[");
        localStringBuilder.append(paramChatMessage.nOpType);
        localStringBuilder.append("] status[");
        localStringBuilder.append(paramChatMessage.status);
        localStringBuilder.append("]");
        QLog.i("OfflineFileBubblePauseHandler", 1, localStringBuilder.toString());
      }
      if (a(paramChatMessage)) {
        return true;
      }
      if ((paramChatMessage.nOpType == 3) && (paramChatMessage.status == 3)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */