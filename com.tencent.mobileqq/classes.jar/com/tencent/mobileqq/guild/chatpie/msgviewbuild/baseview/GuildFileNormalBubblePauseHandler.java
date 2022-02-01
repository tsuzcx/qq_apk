package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.ViewHolder;
import com.tencent.qphone.base.util.QLog;

public class GuildFileNormalBubblePauseHandler
  extends GuildFileBaseBubblePauseHandler
{
  public GuildFileNormalBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a(long paramLong)
  {
    this.b.getFileManagerEngine().a(paramLong);
  }
  
  private void b(long paramLong)
  {
    a(new GuildFileNormalBubblePauseHandler.1(this, paramLong));
  }
  
  protected ImageView a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof BaseGuildFileHolder)) {
      return ((BaseGuildFileHolder)paramViewHolder).a;
    }
    return null;
  }
  
  protected void a(View paramView, ChatItemBuilder.BaseHolder paramBaseHolder, ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramChatMessage instanceof MessageForFile))
    {
      if (paramInt == -1) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("handlePauseClick: type[");
      paramView.append(paramInt);
      paramView.append("]");
      QLog.i("GuildFileBubblePauseHandler", 1, paramView.toString());
      paramView = (MessageForFile)paramChatMessage;
      paramView = FileManagerUtil.a(this.b, paramView);
      if (paramView == null)
      {
        paramView = new StringBuilder();
        paramView.append("handlePauseClick: type[");
        paramView.append(paramInt);
        paramView.append("] entity == null");
        QLog.i("GuildFileBubblePauseHandler", 1, paramView.toString());
        return;
      }
      if (paramInt == 0)
      {
        a(paramView.nSessionId);
        return;
      }
      if (paramInt == 1) {
        b(paramView.nSessionId);
      }
    }
  }
  
  protected void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, ImageView paramImageView)
  {
    if (paramViewHolder == null) {
      return;
    }
    if ((paramViewHolder instanceof BaseGuildFileHolder)) {
      ((BaseGuildFileHolder)paramViewHolder).a = paramImageView;
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    boolean bool1 = paramChatMessage instanceof MessageForFile;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
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
      QLog.i("GuildFileBubblePauseHandler", 1, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (paramChatMessage.nOpType == 52)
    {
      bool1 = bool2;
      if (paramChatMessage.status == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    boolean bool1 = paramChatMessage instanceof MessageForFile;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
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
      QLog.i("GuildFileBubblePauseHandler", 1, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (paramChatMessage.nOpType == 52) {
      if (paramChatMessage.status != 0)
      {
        bool1 = bool2;
        if (paramChatMessage.status != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileNormalBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */