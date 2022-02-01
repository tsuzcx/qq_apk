package com.tencent.mobileqq.filemanager.widget;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;

class QfileEditBottomBar$6
  implements FMDialogUtil.FMDialogInterface
{
  QfileEditBottomBar$6(QfileEditBottomBar paramQfileEditBottomBar) {}
  
  public void a()
  {
    ((IQQFileEngine)((BaseQQAppInterface)QfileEditBottomBar.a(this.a)).getRuntimeService(IQQFileEngine.class)).downLoadAllSelectFiles(QfileEditBottomBar.d(this.a));
    if (this.a.a != null) {
      this.a.a.b();
    }
    FMDataCache.d();
    QfileEditBottomBar.b(this.a).m();
    QfileEditBottomBar.b(this.a).f(false);
    QfileEditBottomBar.b(this.a).c();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.6
 * JD-Core Version:    0.7.0.1
 */