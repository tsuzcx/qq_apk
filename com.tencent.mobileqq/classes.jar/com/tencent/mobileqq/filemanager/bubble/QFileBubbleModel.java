package com.tencent.mobileqq.filemanager.bubble;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class QFileBubbleModel
{
  private ChatMessage a;
  protected QQAppInterface b;
  protected Context c;
  protected SessionInfo d;
  protected boolean e = true;
  private ChatMessage f;
  private MessageForTroopFile g;
  private MessageForFile h;
  
  public QFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.d = paramSessionInfo;
  }
  
  private ChatMessage d(ChatMessage paramChatMessage)
  {
    Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    boolean bool = paramChatMessage.isMultiMsg;
    int i = -2005;
    if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRealChatMessage log, fileType[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.i("QFileBubbleModel", 1, localStringBuilder.toString());
      int j = Integer.parseInt((String)localObject);
      if (j == 3)
      {
        if (this.g == null) {
          this.g = ((MessageForTroopFile)MessageRecordFactory.a(-2017));
        }
        FileManagerUtil.c(this.g);
        localObject = this.g;
        ((ChatMessage)localObject).isMultiMsg = paramChatMessage.isMultiMsg;
        ((ChatMessage)localObject).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        ((ChatMessage)localObject).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        FileManagerUtil.a(paramChatMessage, this.g);
        ((ChatMessage)localObject).istroop = 1;
      }
      for (;;)
      {
        break;
        if ((j != 1) && (j != 2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getRealChatMessage error, not support fileType. fileType[");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("] extInfo[");
          localStringBuilder.append(paramChatMessage.extStr);
          localStringBuilder.append("]");
          QLog.e("QFileBubbleModel", 1, localStringBuilder.toString());
          return (ChatMessage)MessageRecordFactory.a(-2005);
        }
        if (j != 1) {
          i = -2014;
        }
        if (this.h == null) {
          this.h = ((MessageForFile)MessageRecordFactory.a(i));
        }
        FileManagerUtil.c(this.h);
        localObject = this.h;
        ((ChatMessage)localObject).isMultiMsg = paramChatMessage.isMultiMsg;
        ((ChatMessage)localObject).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        ((ChatMessage)localObject).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        QFileUtils.a(this.b, (MessageRecord)localObject, paramChatMessage);
        FileManagerUtil.a(paramChatMessage, this.h);
      }
      if ((j == 1) || (j == 2)) {
        FileManagerUtil.a(this.b, ((ChatMessage)localObject).uniseq, ((ChatMessage)localObject).frienduin, ((ChatMessage)localObject).istroop, paramChatMessage);
      }
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRealChatMessage error, not exist fileType. isMultiMsg[");
    ((StringBuilder)localObject).append(paramChatMessage.isMultiMsg);
    ((StringBuilder)localObject).append("] extInfo[");
    ((StringBuilder)localObject).append(paramChatMessage.extStr);
    ((StringBuilder)localObject).append("]");
    QLog.e("QFileBubbleModel", 1, ((StringBuilder)localObject).toString());
    return (ChatMessage)MessageRecordFactory.a(-2005);
  }
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2) {}
  
  public abstract void a(int paramInt, View paramView);
  
  protected abstract void a(ChatMessage paramChatMessage);
  
  public abstract boolean a();
  
  public abstract QFileBubblePauseHandler b();
  
  public abstract List<Integer> b(int paramInt);
  
  public void b(ChatMessage paramChatMessage)
  {
    this.a = paramChatMessage;
    if (this.a.isMultiMsg) {
      this.f = d(paramChatMessage);
    } else {
      this.f = paramChatMessage;
    }
    a(this.f);
  }
  
  public abstract QFileBubbleDownloadHandler c();
  
  public abstract List<Integer> c(int paramInt);
  
  protected void c(ChatMessage paramChatMessage)
  {
    this.b.getMessageFacade().h(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq);
      ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).removeProcessor(paramChatMessage);
    }
  }
  
  public abstract int d();
  
  public abstract int e();
  
  public abstract String f();
  
  public abstract long g();
  
  public abstract String h();
  
  public abstract int i();
  
  public abstract int j();
  
  public abstract int k();
  
  public abstract void l();
  
  public void m() {}
  
  public boolean n()
  {
    return false;
  }
  
  public void o() {}
  
  public long p()
  {
    return 0L;
  }
  
  public int q()
  {
    return 0;
  }
  
  public String r()
  {
    return "";
  }
  
  public boolean s()
  {
    return false;
  }
  
  public String t()
  {
    return "";
  }
  
  public void u() {}
  
  public ChatMessage v()
  {
    return this.f;
  }
  
  protected void w()
  {
    this.e = false;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QFileBubbleModel.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */