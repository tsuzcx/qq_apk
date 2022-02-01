package com.tencent.mobileqq.filemanageraux.link;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

abstract interface IShareRouter
{
  public abstract int a();
  
  public abstract long a();
  
  public abstract FileManagerEntity a();
  
  public abstract IShareRouter.ShareOptions a();
  
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract boolean a(Bitmap paramBitmap, int paramInt, String paramString);
  
  public abstract String b();
  
  public abstract void b();
  
  public abstract String c();
  
  public abstract BaseActivity getBaseActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.IShareRouter
 * JD-Core Version:    0.7.0.1
 */