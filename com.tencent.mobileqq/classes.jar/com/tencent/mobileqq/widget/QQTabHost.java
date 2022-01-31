package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabWidget;
import aqhc;
import bbkj;
import bcqj;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import osx;

public class QQTabHost
  extends TabHost
{
  private aqhc jdField_a_of_type_Aqhc;
  private bcqj jdField_a_of_type_Bcqj;
  private boolean jdField_a_of_type_Boolean;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof aqhc)) {
      this.jdField_a_of_type_Aqhc = ((aqhc)paramContext);
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
      bbkj.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      bbkj.a("Recent_Draw", null);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Aqhc != null) {
        this.jdField_a_of_type_Aqhc.a();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      bbkj.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean) {
      bbkj.a("Recent_OnLayout", null);
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
      if (this.jdField_a_of_type_Bcqj != null) {
        this.jdField_a_of_type_Bcqj.a(i, paramInt, this);
      }
      if (paramInt == 0) {
        osx.a().a(1, false);
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
  
  public void setOnDrawCompleteListener(aqhc paramaqhc)
  {
    this.jdField_a_of_type_Aqhc = paramaqhc;
  }
  
  public void setOnTabSelectionListener(bcqj parambcqj)
  {
    this.jdField_a_of_type_Bcqj = parambcqj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */