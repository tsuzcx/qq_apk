package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class FileUploadController
{
  Context a;
  QQAppInterface b;
  FileUploadController.FileUploadListener c;
  
  public FileUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.c = paramFileUploadListener;
  }
  
  public void a() {}
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.FileUploadController
 * JD-Core Version:    0.7.0.1
 */