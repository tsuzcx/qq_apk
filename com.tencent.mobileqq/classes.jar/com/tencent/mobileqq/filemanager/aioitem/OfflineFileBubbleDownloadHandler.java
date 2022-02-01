package com.tencent.mobileqq.filemanager.aioitem;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QFileItemBuilder.QFileBaseHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class OfflineFileBubbleDownloadHandler
  extends QFileBubbleDownloadHandler
{
  public OfflineFileBubbleDownloadHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.nOpType == 7) || (paramFileManagerEntity.nOpType == 28) || (paramFileManagerEntity.nOpType == 21) || (paramFileManagerEntity.nOpType == 22) || (paramFileManagerEntity.nOpType == 3) || (paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25))
    {
      if (paramFileManagerEntity.status == 1) {
        break label82;
      }
      if (paramFileManagerEntity.status == -1) {
        return true;
      }
    }
    return false;
    label82:
    return true;
  }
  
  private boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType != 1) {
      return false;
    }
    if ((paramFileManagerEntity.status != -1) && (paramFileManagerEntity.status != 3) && (paramFileManagerEntity.status != 0)) {
      return paramFileManagerEntity.status == 13;
    }
    return true;
  }
  
  private boolean c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType != 0) {
      return false;
    }
    if ((paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1)) {
      return false;
    }
    return FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()) ^ true;
  }
  
  protected FileManagerEntity a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForFile))
    {
      paramChatMessage = (MessageForFile)paramChatMessage;
      return FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    QLog.i("OfflineFileBubbleDownloadHandler", 1, "getFileManagerEntityByMsg:  msg is not message for file.");
    return null;
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
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
      if (paramView.getCloudType() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineFileSessionCenter().a(paramView.nSessionId);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(paramView.nSessionId);
      return;
    }
    if (paramInt == 1)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
      FileModel.a(paramView).a(false, this.jdField_a_of_type_AndroidContentContext, new OfflineFileBubbleDownloadHandler.1(this, paramView));
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
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    paramChatMessage = a(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    int i = FileManagerUtil.a(paramChatMessage.fileName);
    if (i != 0)
    {
      if (i == 2) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowDownloadIcon: current file nOpType[");
        localStringBuilder.append(paramChatMessage.nOpType);
        localStringBuilder.append("] status[");
        localStringBuilder.append(paramChatMessage.status);
        localStringBuilder.append("] fileName[");
        localStringBuilder.append(paramChatMessage.fileName);
        localStringBuilder.append("] uniseq[");
        localStringBuilder.append(paramChatMessage.uniseq);
        localStringBuilder.append("]");
        QLog.i("OfflineFileBubbleDownloadHandler", 1, localStringBuilder.toString());
      }
      if (16 == paramChatMessage.status) {
        return false;
      }
      if ((paramChatMessage.nOpType == -1) && (paramChatMessage.status == -1)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool1;
      if (paramChatMessage.nOpType != 0)
      {
        bool1 = bool2;
        if (paramChatMessage.nOpType != 11) {}
      }
      else
      {
        bool1 = bool2;
        if (paramChatMessage.getCloudType() == 1)
        {
          bool1 = bool2;
          if (paramChatMessage.status == 1) {
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if (paramChatMessage.nOpType == 11)
      {
        bool2 = bool1;
        if (paramChatMessage.getCloudType() == 1)
        {
          bool2 = bool1;
          if (paramChatMessage.status == 13) {
            bool2 = true;
          }
        }
      }
      if (a(paramChatMessage)) {
        bool2 = true;
      }
      if (b(paramChatMessage)) {
        bool2 = true;
      }
      if (c(paramChatMessage)) {
        bool2 = true;
      }
      if ((bool2) && (FileUtils.fileExistsAndNotEmpty(paramChatMessage.getFilePath()))) {
        return false;
      }
    }
    return bool2;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    paramChatMessage = a(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    int i = FileManagerUtil.a(paramChatMessage.fileName);
    boolean bool1 = bool2;
    if (i != 0)
    {
      if (i == 2) {
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
        QLog.i("OfflineFileBubbleDownloadHandler", 1, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (paramChatMessage.nOpType == 1) {
        if (paramChatMessage.status != 2)
        {
          bool1 = bool2;
          if (paramChatMessage.status != 18) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */