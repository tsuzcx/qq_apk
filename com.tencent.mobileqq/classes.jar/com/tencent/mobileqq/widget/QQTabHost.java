package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;

public class QQTabHost
  extends TabHost
{
  private OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener;
  private QQTabHost.OnTabSelectionListener jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof OnDrawCompleteListener)) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = ((OnDrawCompleteListener)paramContext);
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
      StartupTracker.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      StartupTracker.a("Recent_Draw", null);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener.b();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      StartupTracker.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean) {
      StartupTracker.a("Recent_OnLayout", null);
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.QQTabHost", 2, " QQTabHost onTouchModeChanged isInTouchMode:" + paramBoolean);
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener.a(i, paramInt, this);
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
  
  public void setOnDrawCompleteListener(OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = paramOnDrawCompleteListener;
  }
  
  public void setOnTabSelectionListener(QQTabHost.OnTabSelectionListener paramOnTabSelectionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost$OnTabSelectionListener = paramOnTabSelectionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */