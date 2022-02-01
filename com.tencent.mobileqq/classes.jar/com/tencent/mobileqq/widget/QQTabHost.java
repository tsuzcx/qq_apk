package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabWidget;
import avdk;
import bhsq;
import bjbw;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import pfs;

public class QQTabHost
  extends TabHost
{
  private avdk jdField_a_of_type_Avdk;
  private bjbw jdField_a_of_type_Bjbw;
  private boolean jdField_a_of_type_Boolean;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof avdk)) {
      this.jdField_a_of_type_Avdk = ((avdk)paramContext);
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
      bhsq.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      bhsq.a("Recent_Draw", null);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Avdk != null) {
        this.jdField_a_of_type_Avdk.a();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      bhsq.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean) {
      bhsq.a("Recent_OnLayout", null);
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
      if (this.jdField_a_of_type_Bjbw != null) {
        this.jdField_a_of_type_Bjbw.a(i, paramInt, this);
      }
      if (paramInt == 0) {
        pfs.a().a(1, false);
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
  
  public void setOnDrawCompleteListener(avdk paramavdk)
  {
    this.jdField_a_of_type_Avdk = paramavdk;
  }
  
  public void setOnTabSelectionListener(bjbw parambjbw)
  {
    this.jdField_a_of_type_Bjbw = parambjbw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */