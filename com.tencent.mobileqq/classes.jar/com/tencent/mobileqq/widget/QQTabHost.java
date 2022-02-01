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
  private QQTabHost.OnTabSelectionListener a;
  private OnDrawCompleteListener b;
  private boolean c = false;
  
  public QQTabHost(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    if ((paramContext instanceof OnDrawCompleteListener)) {
      this.b = ((OnDrawCompleteListener)paramContext);
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
    if (this.c) {
      StartupTracker.a(null, "Recent_Draw");
    }
    super.draw(paramCanvas);
    if (this.c)
    {
      StartupTracker.a("Recent_Draw", null);
      this.c = false;
      paramCanvas = this.b;
      if (paramCanvas != null) {
        paramCanvas.d();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c) {
      StartupTracker.a(null, "Recent_OnLayout");
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c) {
      StartupTracker.a("Recent_OnLayout", null);
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" QQTabHost onTouchModeChanged isInTouchMode:");
        localStringBuilder.append(paramBoolean);
        QLog.d("Q.aio.QQTabHost", 2, localStringBuilder.toString());
      }
      return;
    }
    super.onTouchModeChanged(paramBoolean);
  }
  
  public void setCurrentTab(int paramInt)
  {
    int i = getTabWidget().getTabCount();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return;
      }
      i = getCurrentTab();
      super.setCurrentTab(paramInt);
      QQTabHost.OnTabSelectionListener localOnTabSelectionListener = this.a;
      if (localOnTabSelectionListener != null) {
        localOnTabSelectionListener.a(i, paramInt, this);
      }
      if (!QLog.isColorLevel()) {
        return;
      }
      try
      {
        throw new RuntimeException();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QQTabHost setCurrentTab, index=");
        localStringBuilder.append(paramInt);
        QLog.d("QQTabHost", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  public void setFirstDrawTrue()
  {
    this.c = true;
  }
  
  public void setOnDrawCompleteListener(OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.b = paramOnDrawCompleteListener;
  }
  
  public void setOnTabSelectionListener(QQTabHost.OnTabSelectionListener paramOnTabSelectionListener)
  {
    this.a = paramOnTabSelectionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQTabHost
 * JD-Core Version:    0.7.0.1
 */