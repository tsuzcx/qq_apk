package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.MobileQQ;

public abstract class AbsNewTroopBaseView
  extends FrameLayout
{
  public QBaseActivity a;
  protected AppInterface b;
  
  public AbsNewTroopBaseView(Context paramContext)
  {
    super(paramContext);
    this.b = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
  
  public AbsNewTroopBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsNewTroopBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    this.a = paramQBaseActivity;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public boolean f()
  {
    return false;
  }
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView
 * JD-Core Version:    0.7.0.1
 */