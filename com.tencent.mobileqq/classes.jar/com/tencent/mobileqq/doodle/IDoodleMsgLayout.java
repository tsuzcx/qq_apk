package com.tencent.mobileqq.doodle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayoutListener;

public abstract interface IDoodleMsgLayout
{
  public abstract int a();
  
  public abstract void a();
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean a(View paramView);
  
  public abstract boolean a(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void setOperateListener(View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener, View.OnLongClickListener paramOnLongClickListener, DoodleMsgLayoutListener paramDoodleMsgLayoutListener);
  
  public abstract void setTalkBack(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.IDoodleMsgLayout
 * JD-Core Version:    0.7.0.1
 */