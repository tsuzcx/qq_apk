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
          do
          {
            do
            {
              return;
              QLog.i("TroopFileBubblePauseHandler", 1, "handlePauseClick: type[" + paramInt + "]");
            } while (paramInt == -1);
            paramViewHolder = (MessageForTroopFile)paramChatMessage;
            paramView = TroopFileTransferManager.a(this.a, Long.parseLong(paramChatMessage.frienduin));
          } while (paramView == null);
          paramViewHolder = TroopFileUtils.a(this.a, paramViewHolder);
        } while (paramViewHolder == null);
        if (paramInt != 0) {
          break;
        }
      } while ((paramViewHolder.b != 0) && (paramViewHolder.b != 1));
      ReportController.b(this.a, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.a(paramViewHolder.a);
      return;
    } while ((paramInt != 1) || ((paramViewHolder.b != 2) && (paramViewHolder.b != 3)));
    ReportController.b(this.a, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
    a(new TroopFileBubblePauseHandler.1(this, paramChatMessage.frienduin, paramViewHolder));
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
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = TroopFileUtils.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowPauseIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 0) && (paramChatMessage.b != 1));
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
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = TroopFileUtils.a(this.a, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowResumeIcon: current file status[" + paramChatMessage.b + "]");
      }
    } while ((paramChatMessage.b != 3) && (paramChatMessage.b != 2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */