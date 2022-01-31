package dov.com.qq.im.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import dov.com.tencent.mobileqq.activity.richmedia.FlowPanel;

public abstract interface IQIMCameraLifeCallback
{
  public abstract View a();
  
  public abstract FlowPanel a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean);
  
  public abstract boolean a(MotionEvent paramMotionEvent, boolean paramBoolean);
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void d();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void i();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract void q();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.setting.IQIMCameraLifeCallback
 * JD-Core Version:    0.7.0.1
 */