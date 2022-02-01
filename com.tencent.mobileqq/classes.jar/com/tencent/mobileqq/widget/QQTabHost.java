package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabWidget;
import auvj;
import bhhy;
import bisp;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import pwb;

public class QQTabHost
  extends TabHost
{
  private auvj jdField_a_of_type_Auvj;
  private bisp jdField_a_of_type_Bisp;
  private boolean jdField_a_of_type_Boolean;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof auvj)) {
      this.jdField_a_of_type_Auvj = ((auvj)paramContext);
    }
  }
  
  public QQTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
  }
  
  public void clearAllTabs()
  {
    if (Build.VERSION.SDK_INT < 14) {
      setCurrentTab(0);
    }
    super.clearAllTabs();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      bhhy.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      bhhy.a("Recent_Draw", null);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Auvj != null) {
        this.jdField_a_of_type_Auvj.b();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      bhhy.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean) {
      bhhy.a("Recent_OnLayout", null);
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (SplashActivity.a != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.QQTabHost", 2, " QQTabHost onTouchModeChanged isInTouchMode:" + paramBoolean + " currentFragment = " + SplashActivity.a);
      }
      return;
    }
    super.onTouchModeChanged(paramBoolean);
  }
  
  public void setCurrentTab(int paramInt)
  {
    int i = getTabWidget().getTabCount();
    if ((paramInt < 0) || (paramInt >= i)) {}
    do
    {
      return;
      i = getCurrentTab();
      super.setCurrentTab(paramInt);
      if (this.jdField_a_of_type_Bisp != null) {
        this.jdField_a_of_type_Bisp.a(i, paramInt, this);
      }
      if (paramInt == 0) {
        pwb.a().a(1, false);
      }
    } while (!QLog.isColorLevel());
    try
    {
      throw new RuntimeException();
    }
    catch (Exception localException)
    {
      QLog.d("QQTabHost", 2, "QQTabHost setCurrentTab, index=" + paramInt, localException);
    }
  }
  
  public void setFirstDrawTrue()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setOnDrawCompleteListener(auvj paramauvj)
  {
    this.jdField_a_of_type_Auvj = paramauvj;
  }
  
  public void setOnTabSelectionListener(bisp parambisp)
  {
    this.jdField_a_of_type_Bisp = parambisp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */