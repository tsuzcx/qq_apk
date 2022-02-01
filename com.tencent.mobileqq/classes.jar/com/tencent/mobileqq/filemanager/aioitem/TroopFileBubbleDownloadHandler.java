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
  
  protected CircleFileStateView a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return null;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      return ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).v;
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
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b, Long.parseLong(paramChatMessage.frienduin));
    if (localTroopFileTransferManager == null) {
      return;
    }
    paramViewHolder = c(paramChatMessage);
    if (paramViewHolder == null) {
      return;
    }
    int i = NetworkUtil.getSystemNetwork((Activity)this.a);
    if (paramInt == 0)
    {
      ReportController.b(this.b, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
      if (i == 0)
      {
        TroopFileError.a(this.a, this.a.getString(2131895389));
        return;
      }
      if (paramViewHolder.e != 8) {
        return;
      }
      localTroopFileTransferManager.e(paramViewHolder.a);
      return;
    }
    if (paramInt == 1)
    {
      ReportController.b(this.b, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
      paramChatMessage = new TroopFileItemOperation(Long.parseLong(paramChatMessage.frienduin), this.b, (Activity)this.a);
      if ((paramViewHolder.e != 10) && (paramViewHolder.e != 9))
      {
        if (paramViewHolder.e == 7)
        {
          paramChatMessage.a(paramView.url, paramViewHolder.t, paramViewHolder.i, paramViewHolder.u);
          return;
        }
        if ((paramViewHolder.e == 6) && (!FileUtils.fileExistsAndNotEmpty(paramViewHolder.k))) {
          paramChatMessage.a(paramView.url, paramViewHolder.t, paramViewHolder.i, paramViewHolder.u);
        }
      }
      else if (paramViewHolder.a != null)
      {
        paramChatMessage.b(paramViewHolder.a);
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, CircleFileStateView paramCircleFileStateView)
  {
    if (paramViewHolder == null) {
      return;
    }
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder)) {
      ((QFileItemBuilder.QFileBaseHolder)paramViewHolder).v = paramCircleFileStateView;
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
      paramChatMessage = c(paramChatMessage);
      if (paramChatMessage == null) {
        return false;
      }
      if ((((MessageForTroopFile)localObject).lastTime != 0L) && (((MessageForTroopFile)localObject).lastTime <= NetConnInfoCenter.getServerTime())) {
        return false;
      }
      int i = FileManagerUtil.c(paramChatMessage.t);
      if (i != 0)
      {
        if (i == 2) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("needShowDownloadIcon: current file status[");
          ((StringBuilder)localObject).append(paramChatMessage.e);
          ((StringBuilder)localObject).append("]");
          QLog.i("TroopFileBubbleDownloadHandler", 1, ((StringBuilder)localObject).toString());
        }
        if ((paramChatMessage.e != 10) && (paramChatMessage.e != 9) && (paramChatMessage.e != 7)) {
          return (paramChatMessage.e == 6) && (!FileUtils.fileExistsAndNotEmpty(paramChatMessage.k));
        }
        return !FileUtils.fileExistsAndNotEmpty(paramChatMessage.k);
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
    paramChatMessage = c(paramChatMessage);
    if (paramChatMessage == null) {
      return false;
    }
    int i = FileManagerUtil.c(paramChatMessage.t);
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
        localStringBuilder.append(paramChatMessage.e);
        localStringBuilder.append("]");
        QLog.i("TroopFileBubbleDownloadHandler", 1, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (paramChatMessage.e == 8) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected TroopFileStatusInfo c(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      paramChatMessage = (MessageForTroopFile)paramChatMessage;
      return TroopFileUtils.a(this.b, paramChatMessage);
    }
    QLog.i("TroopFileBubbleDownloadHandler", 1, "getTroopFileStatusInfoByMsg:  msg is not message for troop file.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */