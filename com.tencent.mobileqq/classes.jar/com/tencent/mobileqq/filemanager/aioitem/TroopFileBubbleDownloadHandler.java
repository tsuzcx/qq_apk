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
    paramView.append("handlePauseClick: type[");
    paramView.append(paramInt);
    paramView.append("]");
    QLog.i("TroopFileBubbleDownloadHandler", 1, paramView.toString());
    if (paramInt == -1) {
      return;
    }
    paramView = (MessageForTroopFile)paramChatMessage;
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramChatMessage.frienduin));
    if (localTroopFileTransferManager == null) {
      return;
    }
    paramViewHolder = a(paramChatMessage);
    if (paramViewHolder == null) {
      return;
    }
    int i = NetworkUtil.getSystemNetwork((Activity)this.jdField_a_of_type_AndroidContentContext);
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
      if (i == 0)
      {
        TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697616));
        return;
      }
      if (paramViewHolder.b != 8) {
        return;
      }
      localTroopFileTransferManager.d(paramViewHolder.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    if (paramInt == 1)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
      paramChatMessage = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      if ((paramViewHolder.b != 10) && (paramViewHolder.b != 9))
      {
        if (paramViewHolder.b == 7)
        {
          paramChatMessage.a(paramView.url, paramViewHolder.g, paramViewHolder.c, paramViewHolder.h);
          return;
        }
        if ((paramViewHolder.b == 6) && (!FileUtils.fileExistsAndNotEmpty(paramViewHolder.jdField_a_of_type_JavaLangString))) {
          paramChatMessage.a(paramView.url, paramViewHolder.g, paramViewHolder.c, paramViewHolder.h);
        }
      }
      else if (paramViewHolder.jdField_a_of_type_JavaUtilUUID != null)
      {
        paramChatMessage.b(paramViewHolder.jdField_a_of_type_JavaUtilUUID);
      }
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
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForTroopFile)) {
        return false;
      }
      Object localObject = (MessageForTroopFile)paramChatMessage;
      paramChatMessage = a(paramChatMessage);
      if (paramChatMessage == null) {
        return false;
      }
      if ((((MessageForTroopFile)localObject).lastTime != 0L) && (((MessageForTroopFile)localObject).lastTime <= NetConnInfoCenter.getServerTime())) {
        return false;
      }
      int i = FileManagerUtil.a(paramChatMessage.g);
      if (i != 0)
      {
        if (i == 2) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("needShowDownloadIcon: current file status[");
          ((StringBuilder)localObject).append(paramChatMessage.b);
          ((StringBuilder)localObject).append("]");
          QLog.i("TroopFileBubbleDownloadHandler", 1, ((StringBuilder)localObject).toString());
        }
        if ((paramChatMessage.b != 10) && (paramChatMessage.b != 9) && (paramChatMessage.b != 7)) {
          return (paramChatMessage.b == 6) && (!FileUtils.fileExistsAndNotEmpty(paramChatMessage.jdField_a_of_type_JavaLangString));
        }
        return !FileUtils.fileExistsAndNotEmpty(paramChatMessage.jdField_a_of_type_JavaLangString);
      }
    }
    return false;
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
    int i = FileManagerUtil.a(paramChatMessage.g);
    boolean bool1 = bool2;
    if (i != 0)
    {
      if (i == 2) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needShowPauseIcon: current file status[");
        localStringBuilder.append(paramChatMessage.b);
        localStringBuilder.append("]");
        QLog.i("TroopFileBubbleDownloadHandler", 1, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (paramChatMessage.b == 8) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */