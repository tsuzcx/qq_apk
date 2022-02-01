package com.tencent.mobileqq.qqfloatingwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.qqfloatingwindow.callback.IAddReceiverStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.callback.IUpdateUICallbackListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IContainerBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IDragListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatingBaseProxyWrapper
  implements View.OnClickListener, IAddReceiverStatusListener, IUpdateUICallbackListener
{
  private IFloatingWrapperManager a = (IFloatingWrapperManager)QRoute.api(IFloatingWrapperManager.class);
  
  public FloatingBaseProxyWrapper(Context paramContext)
  {
    a(paramContext);
  }
  
  public void A()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setRootLayoutVisible();
    }
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.enterWindowFloat(paramFloatingScreenParams, paramView, this, this);
    }
    return 3;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.setDuplexVideoStatusListener(paramIVideoInnerStatusListener);
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.updateRatio(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.quitWindowFloat(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setRoundCorners(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingContainerPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(int paramInt, IWindowStatusListener paramIWindowStatusListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.addScreenStatusReceiver(paramInt, paramIWindowStatusListener);
    }
  }
  
  public void a(Context paramContext)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.initViews(paramContext, this);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingWidgetBackground(paramDrawable);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener, View... paramVarArgs)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setViewsClick(paramOnClickListener, paramVarArgs);
    }
  }
  
  public void a(View paramView)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.initWidgetWrapper(paramView);
    }
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.addViewToFloatingWidgetWrapper(paramView, paramLayoutParams);
    }
  }
  
  public void a(ViewGroup.LayoutParams paramLayoutParams)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.addRootLayoutToFloatingWidgetWrapper(paramLayoutParams);
    }
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.restoreLastCenterPosition(paramFloatingScreenParams);
    }
  }
  
  public void a(IContainerBackPressListener paramIContainerBackPressListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingContainerBackPressListener(paramIContainerBackPressListener);
    }
  }
  
  public void a(IDragListener paramIDragListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingContainerDragListener(paramIDragListener);
    }
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFullScreenEnterListener(paramIFullScreenEnterListener);
    }
  }
  
  public void a(IFullScreenViewClickListener paramIFullScreenViewClickListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFullScreenViewClickListener(paramIFullScreenViewClickListener);
    }
  }
  
  public void a(IWindowClickListener paramIWindowClickListener)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setWindowClickListener(paramIWindowClickListener);
    }
  }
  
  public void a(String paramString)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setCloseBtnContentDescription(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingContainerVisibility(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.changeContainerLayoutParams(paramBoolean1, paramInt1, paramInt2, paramBoolean2);
    }
  }
  
  public void a(boolean paramBoolean, View... paramVarArgs)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setViewsVisibility(paramBoolean, paramVarArgs);
    }
  }
  
  public void b(float paramFloat)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setRootLayoutAlpha(paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.updateShapeType(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.updateLocation(paramInt1, paramInt2);
    }
  }
  
  public void b(View paramView)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.removeParent(paramView);
    }
  }
  
  public void b(FloatingScreenParams paramFloatingScreenParams)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.enterWindowFloatWithWidgetWrapper(paramFloatingScreenParams);
    }
  }
  
  public void b(String paramString)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setRootLayoutContentDescription(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingCloseBtnVisibility(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean, View... paramVarArgs)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setViewEnabled(paramBoolean, paramVarArgs);
    }
  }
  
  public void c(int paramInt)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingContainerBackgroundRes(paramInt);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.updateSize(paramInt1, paramInt2);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingContainerOrientation(paramBoolean);
    }
  }
  
  public View d(int paramInt)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getViewById(paramInt);
    }
    return null;
  }
  
  public void d(boolean paramBoolean)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setContainerClipToOutline(paramBoolean);
    }
  }
  
  public boolean d(int paramInt1, int paramInt2)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getIsInterceptWindowClick(paramInt1, paramInt2);
    }
    return false;
  }
  
  public void dz_()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.updateFloatingView();
    }
  }
  
  public void e(int paramInt)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setRootLayoutBackgroundColor(paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setFloatingWidgetClipToOutLine(paramBoolean);
    }
  }
  
  public void f()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.resetWindowSize();
    }
  }
  
  public void f(int paramInt)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setRootLayoutBackgroundRes(paramInt);
    }
  }
  
  public void g()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.resetFloatWindowScale();
    }
  }
  
  public boolean h()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.isFloatWindowHasZoomed();
    }
    return false;
  }
  
  public int i()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatWindowShapeType();
    }
    return 1;
  }
  
  public void j()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.initStatusReceiver();
    }
  }
  
  public int k()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatingContainerVisibility();
    }
    return 4;
  }
  
  public View l()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getRootLayout();
    }
    return null;
  }
  
  public Context m()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatingContext();
    }
    return null;
  }
  
  public boolean n()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatingContainerIsNull();
    }
    return true;
  }
  
  public boolean o()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getContainerIsSmallFloating();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.onViewClick(paramView, this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean p()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatingIsFullScreen();
    }
    return false;
  }
  
  public int q()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatingContainerCenterX();
    }
    return 0;
  }
  
  public int r()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getFloatingContainerCenterY();
    }
    return 0;
  }
  
  public void s()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.removeWidgetWrapperParent();
    }
  }
  
  public void t()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.removeRootLayoutParent();
    }
  }
  
  public void u()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.removeFloatingWidgetWrapperViews();
    }
  }
  
  public void v()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.setVideoWrapperBackground();
    }
  }
  
  public boolean w()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getContainerIsFloating();
    }
    return false;
  }
  
  public boolean x()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      return localIFloatingWrapperManager.getIsWindowClickListenerNull();
    }
    return true;
  }
  
  public void y()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.floatingContainerEnterFullScreen();
    }
  }
  
  public void z()
  {
    IFloatingWrapperManager localIFloatingWrapperManager = this.a;
    if (localIFloatingWrapperManager != null) {
      localIFloatingWrapperManager.floatingContainerQuitFullScreen();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper
 * JD-Core Version:    0.7.0.1
 */