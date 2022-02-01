package com.tencent.mobileqq.filemanageraux.link;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

abstract interface IShareRouter
{
  public abstract IShareRouter.ShareOptions a();
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract boolean a(Bitmap paramBitmap, int paramInt, String paramString);
  
  public abstract void b();
  
  public abstract FileManagerEntity c();
  
  public abstract String d();
  
  public abstract long e();
  
  public abstract int f();
  
  public abstract String g();
  
  public abstract BaseActivity getBaseActivity();
  
  public abstract void h();
  
  public abstract String i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.IShareRouter
 * JD-Core Version:    0.7.0.1
 */