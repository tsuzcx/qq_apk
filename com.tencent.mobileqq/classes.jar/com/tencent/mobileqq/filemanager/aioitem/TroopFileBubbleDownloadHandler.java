package com.tencent.mobileqq.filemanager.aioitem;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QFileItemBuilder.QFileBaseHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class TroopFileBubbleDownloadHandler
  extends QFileBubbleDownloadHandler
{
  public TroopFileBubbleDownloadHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected TroopFileStatusInfo a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
      return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    QLog.i("TroopFileBubbleDownloadHandler", 1, "getTroopFileStatusInfoByMsg:  msg is not message for troop file.");
    return null;
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
          TroopFileTransferManager localTroopFileTransferManager;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  QLog.i("TroopFileBubbleDownloadHandler", 1, "handlePauseClick: type[" + paramInt + "]");
                } while (paramInt == -1);
                paramView = (MessageForTroopFile)paramChatMessage;
                localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
              } while (localTroopFileTransferManager == null);
              paramViewHolder = a(paramChatMessage);
            } while (paramViewHolder == null);
            int i = NetworkUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext);
            if (paramInt != 0) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697610));
              return;
            }
          } while (paramViewHolder.b != 8);
          localTroopFileTransferManager.d(paramViewHolder.jdField_a_of_type_JavaUtilUUID);
          return;
        } while (paramInt != 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if ((paramViewHolder.b != 10) && (paramViewHolder.b != 9)) {
          break;
        }
      } while (paramViewHolder.jdField_a_of_type_JavaUtilUUID == null);
      paramChatMessage.b(paramViewHolder.jdField_a_of_type_JavaUtilUUID);
      return;
      if (paramViewHolder.b == 7)
      {
        paramChatMessage.a(paramView.url, paramViewHolder.g, paramViewHolder.c, paramViewHolder.h);
        return;
      }
    } while ((paramViewHolder.b != 6) || (FileUtils.b(paramViewHolder.jdField_a_of_type_JavaLangString)));
    paramChatMessage.a(paramView.url, paramViewHolder.g, paramViewHolder.c, paramViewHolder.h);
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
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopFile))) {
      return false;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    paramChatMessage = a(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    if ((localMessageForTroopFile.lastTime != 0L) && (localMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return false;
    }
    int i = FileManagerUtil.a(paramChatMessage.g);
    if ((i == 0) || (i == 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + paramChatMessage.b + "]");
    }
    if ((paramChatMessage.b == 10) || (paramChatMessage.b == 9) || (paramChatMessage.b == 7)) {
      return !FileUtils.b(paramChatMessage.jdField_a_of_type_JavaLangString);
    }
    return (paramChatMessage.b == 6) && (!FileUtils.b(paramChatMessage.jdField_a_of_type_JavaLangString));
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    boolean bool = true;
    if (paramChatMessage == null) {}
    int i;
    do
    {
      do
      {
        return false;
        paramChatMessage = a(paramChatMessage);
      } while (paramChatMessage == null);
      i = FileManagerUtil.a(paramChatMessage.g);
    } while ((i == 0) || (i == 2));
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowPauseIcon: current file status[" + paramChatMessage.b + "]");
    }
    if (paramChatMessage.b == 8) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */