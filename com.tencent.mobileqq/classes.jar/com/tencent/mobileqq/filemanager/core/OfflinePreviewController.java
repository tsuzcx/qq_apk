package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class OfflinePreviewController
  extends FilePreViewControllerBase
{
  QQAppInterface b;
  String c;
  String d;
  FMObserver e = null;
  
  public OfflinePreviewController(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.b = paramQQAppInterface;
    this.c = paramString1;
    this.d = paramString2;
    if (TextUtils.isEmpty(paramString1))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(" init OfflinePreviewController error,uuid is null,stack:");
      paramQQAppInterface.append(FileManagerUtil.d());
      QLog.e("OfflinePreviewController<FileAssistant>", 1, paramQQAppInterface.toString());
    }
    d();
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" init OfflinePreviewController error,uuid is null,stack:");
      localStringBuilder.append(FileManagerUtil.d());
      QLog.e("OfflinePreviewController<FileAssistant>", 1, localStringBuilder.toString());
      if (this.a != null) {
        this.a.a(false, "", "", -100005L, "", "", null, this.c, null);
      }
      return false;
    }
    this.b.getFileManagerEngine().b(this.c, this.d);
    return true;
  }
  
  public void b()
  {
    if (this.e != null) {
      this.b.getFileManagerNotifyCenter().deleteObserver(this.e);
    }
  }
  
  public int c()
  {
    return 1;
  }
  
  public void d()
  {
    this.e = new OfflinePreviewController.1(this);
    this.b.getFileManagerNotifyCenter().addObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflinePreviewController
 * JD-Core Version:    0.7.0.1
 */