package com.tencent.mobileqq.filemanager.widget;

import atqx;
import aupl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QfileEditBottomBar$1$1
  implements Runnable
{
  public QfileEditBottomBar$1$1(aupl paramaupl) {}
  
  public void run()
  {
    QfileEditBottomBar.a(this.a.a).a().a(false);
    ThreadManager.getUIHandler().post(new QfileEditBottomBar.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.1.1
 * JD-Core Version:    0.7.0.1
 */