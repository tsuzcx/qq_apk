package com.tencent.mobileqq.filemanager.widget;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import mqq.os.MqqHandler;

class QfileEditBottomBar$1$1
  implements Runnable
{
  QfileEditBottomBar$1$1(QfileEditBottomBar.1 param1) {}
  
  public void run()
  {
    QfileEditBottomBar.a(this.a.a).getFileManagerEngine().a(false);
    ThreadManager.getUIHandler().post(new QfileEditBottomBar.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.1.1
 * JD-Core Version:    0.7.0.1
 */