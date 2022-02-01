package com.tencent.mobileqq.filemanager.widget;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;

class QfileEditBottomBar$6
  implements FMDialogUtil.FMDialogInterface
{
  QfileEditBottomBar$6(QfileEditBottomBar paramQfileEditBottomBar) {}
  
  public void a()
  {
    QfileEditBottomBar.a(this.a).getFileManagerEngine().a(QfileEditBottomBar.a(this.a));
    if (this.a.a != null) {
      this.a.a.b();
    }
    FMDataCache.b();
    QfileEditBottomBar.a(this.a).h();
    QfileEditBottomBar.a(this.a).f(false);
    QfileEditBottomBar.a(this.a).b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.6
 * JD-Core Version:    0.7.0.1
 */