package dov.com.qq.im.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public abstract interface IQIMCameraLifeCallback
{
  public abstract View a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean);
  
  public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(Bundle paramBundle);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.setting.IQIMCameraLifeCallback
 * JD-Core Version:    0.7.0.1
 */