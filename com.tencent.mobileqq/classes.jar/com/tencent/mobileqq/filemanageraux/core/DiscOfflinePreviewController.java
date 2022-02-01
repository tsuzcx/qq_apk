package com.tencent.mobileqq.filemanageraux.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class DiscOfflinePreviewController
  extends FilePreViewControllerBase
{
  String b = "DiscOfflinePreviewController<FileAssistant>";
  QQAppInterface c;
  String d;
  String e;
  FMObserver f = null;
  
  public DiscOfflinePreviewController(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.c = paramQQAppInterface;
    this.d = paramString1;
    this.e = paramString2;
    d();
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.d))
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" init OfflinePreviewController error,uuid is null,stack:");
      localStringBuilder.append(FileManagerUtil.d());
      QLog.e(str, 1, localStringBuilder.toString());
      if (this.a != null) {
        this.a.a(false, "", "", -100005L, "", "", null, this.d, null);
      }
      return false;
    }
    this.c.getFileManagerEngine().c(this.e, this.d);
    return true;
  }
  
  public void b()
  {
    if (this.f != null) {
      this.c.getFileManagerNotifyCenter().deleteObserver(this.f);
    }
  }
  
  public int c()
  {
    return 2;
  }
  
  public void d()
  {
    this.f = new DiscOfflinePreviewController.1(this);
    this.c.getFileManagerNotifyCenter().addObserver(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController
 * JD-Core Version:    0.7.0.1
 */