package com.tencent.mobileqq.filemanager.aioitem;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QFileItemBuilder.QFileBaseHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopFileBubblePauseHandler
  extends QFileBubblePauseHandler
{
  public TroopFileBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
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
    if (paramChatMessage == null) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append("handlePauseClick: type[");
    paramView.append(paramInt);
    paramView.append("]");
    QLog.i("TroopFileBubblePauseHandler", 1, paramView.toString());
    if (paramInt == -1) {
      return;
    }
    paramViewHolder = (MessageForTroopFile)paramChatMessage;
    paramView = TroopFileTransferManager.a(this.b, Long.parseLong(paramChatMessage.frienduin));
    if (paramView == null) {
      return;
    }
    paramViewHolder = TroopFileUtils.a(this.b, paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    if (paramInt == 0)
    {
      if ((paramViewHolder.e != 0) && (paramViewHolder.e != 1)) {
        return;
      }
      ReportController.b(this.b, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.b(paramViewHolder.a);
      return;
    }
    if (paramInt == 1)
    {
      if ((paramViewHolder.e != 2) && (paramViewHolder.e != 3)) {
        return;
      }
      ReportController.b(this.b, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
      a(new TroopFileBubblePauseHandler.1(this, paramChatMessage.frienduin, paramViewHolder));
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
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
      paramChatMessage = TroopFileUtils.a(this.b, paramChatMessage);
      if (paramChatMessage == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowPauseIcon: current file status[");
        localStringBuilder.append(paramChatMessage.e);
        localStringBuilder.append("]");
        QLog.i("TroopFileBubblePauseHandler", 1, localStringBuilder.toString());
      }
      if ((paramChatMessage.e == 0) || (paramChatMessage.e == 1)) {
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
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
      paramChatMessage = TroopFileUtils.a(this.b, paramChatMessage);
      if (paramChatMessage == null) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowResumeIcon: current file status[");
        localStringBuilder.append(paramChatMessage.e);
        localStringBuilder.append("]");
        QLog.i("TroopFileBubblePauseHandler", 1, localStringBuilder.toString());
      }
      if ((paramChatMessage.e == 3) || (paramChatMessage.e == 2)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */