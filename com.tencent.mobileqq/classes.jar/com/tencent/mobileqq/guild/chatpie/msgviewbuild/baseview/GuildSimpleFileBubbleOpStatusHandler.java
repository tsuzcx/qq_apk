package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

public class GuildSimpleFileBubbleOpStatusHandler
{
  protected Context a;
  protected QQAppInterface b;
  protected ActionSheet c;
  
  public GuildSimpleFileBubbleOpStatusHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = paramQQAppInterface;
    this.a = paramContext;
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramImageView.setVisibility(8);
              return;
            }
            paramImageView.setImageResource(2130840806);
            paramImageView.setVisibility(0);
            return;
          }
          paramImageView.setImageResource(2130840807);
          paramImageView.setVisibility(0);
          return;
        }
        paramImageView.setImageResource(2130840805);
        paramImageView.setVisibility(0);
        return;
      }
      paramImageView.setImageResource(2130838271);
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setImageResource(2130838287);
    paramImageView.setVisibility(0);
  }
  
  private int b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType == 52) {
      return a(paramFileManagerEntity);
    }
    if (paramFileManagerEntity.nOpType == 53) {
      return c(paramFileManagerEntity);
    }
    return -1;
  }
  
  private int c(FileManagerEntity paramFileManagerEntity)
  {
    int j = paramFileManagerEntity.status;
    int i = 3;
    if (j != -1)
    {
      if (j != 0)
      {
        if (j == 2) {
          break label38;
        }
        if (j != 3)
        {
          i = -1;
          break label38;
        }
      }
      i = 4;
    }
    else
    {
      i = 2;
    }
    label38:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOpUploadStatusType sessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append(" entity.status = ");
    localStringBuilder.append(paramFileManagerEntity.status);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    return i;
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDownloadFile nSessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    this.b.getFileManagerEngine().h(paramFileManagerEntity);
  }
  
  private void e(FileManagerEntity paramFileManagerEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUploadFilePause nSessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    this.b.getFileManagerEngine().a(paramFileManagerEntity.nSessionId);
  }
  
  private void f(FileManagerEntity paramFileManagerEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUploadFileResume nSessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    a(new GuildSimpleFileBubbleOpStatusHandler.1(this, paramFileManagerEntity), 2131915708);
  }
  
  private void g(FileManagerEntity paramFileManagerEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDownloadFilePause nSessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    this.b.getFileManagerEngine().a(paramFileManagerEntity.nSessionId);
  }
  
  private void h(FileManagerEntity paramFileManagerEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDownloadFileResume nSessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    a(new GuildSimpleFileBubbleOpStatusHandler.2(this, paramFileManagerEntity), 2131915647);
  }
  
  protected int a(FileManagerEntity paramFileManagerEntity)
  {
    int j = paramFileManagerEntity.status;
    int i = -1;
    if (j != -1)
    {
      if (j != 0) {
        if (j != 2)
        {
          if (j != 3) {
            break label41;
          }
        }
        else
        {
          i = 0;
          break label41;
        }
      }
      i = 1;
    }
    else
    {
      i = 2;
    }
    label41:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOpUploadStatusType sessionId = ");
    localStringBuilder.append(paramFileManagerEntity.nSessionId);
    localStringBuilder.append(" entity.status = ");
    localStringBuilder.append(paramFileManagerEntity.status);
    QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
    return i;
  }
  
  protected void a()
  {
    ActionSheet localActionSheet = this.c;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      ActionSheetHelper.b((Activity)this.a, this.c);
    }
  }
  
  public void a(ImageView paramImageView, ChatMessage paramChatMessage)
  {
    QQAppInterface localQQAppInterface = this.b;
    if ((localQQAppInterface != null) && (this.a != null) && (paramImageView != null) && ((paramChatMessage instanceof MessageForFile)))
    {
      paramImageView = FileManagerUtil.a(localQQAppInterface, (MessageForFile)paramChatMessage);
      if (paramImageView == null)
      {
        QLog.e("GuildSimpleFileBubblePauseHandler", 2, "handleClick entity error!");
        return;
      }
      int i = b(paramImageView);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4) {
                h(paramImageView);
              }
            }
            else {
              g(paramImageView);
            }
          }
          else {
            d(paramImageView);
          }
        }
        else {
          f(paramImageView);
        }
      }
      else {
        e(paramImageView);
      }
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("handleClick mCurShowOpStatusType = ");
      paramChatMessage.append(i);
      paramChatMessage.append(" sessionId = ");
      paramChatMessage.append(paramImageView.nSessionId);
      QLog.d("GuildSimpleFileBubblePauseHandler", 2, paramChatMessage.toString());
      return;
    }
    QLog.e("GuildSimpleFileBubblePauseHandler", 2, "handleClick args error!");
  }
  
  public void a(GuildSimpleFileBuilder.SimpleFileHolder paramSimpleFileHolder, FileManagerEntity paramFileManagerEntity)
  {
    if ((this.b != null) && (this.a != null) && (paramSimpleFileHolder != null) && (paramSimpleFileHolder.e != null) && (paramFileManagerEntity != null))
    {
      int i = b(paramFileManagerEntity);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getOpUploadStatusType sessionId = ");
      localStringBuilder.append(paramFileManagerEntity.nSessionId);
      localStringBuilder.append(" curShowOpStatusType = ");
      localStringBuilder.append(i);
      QLog.d("GuildSimpleFileBubblePauseHandler", 2, localStringBuilder.toString());
      a(paramSimpleFileHolder.e, i);
      return;
    }
    QLog.e("GuildSimpleFileBubblePauseHandler", 2, "handlePauseIcon args error!");
  }
  
  protected void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ActionMenuItem(0, ActionSheetHelper.a(this.a, paramInt), 0, 0, 2));
    this.c = ActionSheetHelper.b(this.a, localArrayList, paramOnButtonClickListener);
    paramOnButtonClickListener = this.c;
    if (paramOnButtonClickListener != null)
    {
      paramOnButtonClickListener.addCancelButton(2131887648);
      ActionSheetHelper.a((Activity)this.a, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildSimpleFileBubbleOpStatusHandler
 * JD-Core Version:    0.7.0.1
 */