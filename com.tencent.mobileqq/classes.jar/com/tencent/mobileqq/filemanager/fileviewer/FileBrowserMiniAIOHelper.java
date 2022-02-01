package com.tencent.mobileqq.filemanager.fileviewer;

import android.os.Handler;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class FileBrowserMiniAIOHelper
  implements Observer
{
  private QQAppInterface a;
  private String b;
  private View c;
  
  public FileBrowserMiniAIOHelper(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramString;
  }
  
  public void a()
  {
    View localView = this.c;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    this.c = paramView;
  }
  
  public void b()
  {
    if (this.a.getMessageFacade() != null) {
      this.a.getMessageFacade().addObserver(this);
    }
  }
  
  public void c()
  {
    if (this.a.getMessageFacade() != null) {
      this.a.getMessageFacade().deleteObserver(this);
    }
  }
  
  public void d()
  {
    if (this.a.getMessageFacade() != null) {
      this.a.getMessageFacade().deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("recv: msgseq[");
        paramObject.append(paramObservable.msgseq);
        paramObject.append("] uin[");
        paramObject.append(paramObservable.frienduin);
        paramObject.append("]");
        QLog.d("FileBrowserMiniAIOHelper<QFile>", 2, paramObject.toString());
        if (paramObservable.frienduin.equals(this.b)) {
          ThreadManagerV2.getUIHandlerV2().post(new FileBrowserMiniAIOHelper.1(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserMiniAIOHelper
 * JD-Core Version:    0.7.0.1
 */