package com.tencent.mobileqq.troop.navigatebar;

import android.view.MotionEvent;

public abstract class AioTips
  extends AioAgent
{
  public boolean g = false;
  public long h = 0L;
  public long i = 0L;
  public boolean j = false;
  public boolean k = false;
  
  protected void a() {}
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public abstract void a(MotionEvent paramMotionEvent);
  
  protected void b() {}
  
  public abstract void b(int paramInt);
  
  public abstract boolean c(int paramInt);
  
  public abstract boolean cB_();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract boolean g();
  
  public abstract boolean h();
  
  public abstract int i();
  
  public abstract void j();
  
  public abstract BaseAioMsgNavigateBar k();
  
  public void x()
  {
    this.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.AioTips
 * JD-Core Version:    0.7.0.1
 */