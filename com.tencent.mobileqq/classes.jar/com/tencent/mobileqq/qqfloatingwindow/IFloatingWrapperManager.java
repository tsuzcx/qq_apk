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
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IFloatingWrapperManager
  extends QRouteApi
{
  public abstract void addRootLayoutToFloatingWidgetWrapper(ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void addScreenStatusReceiver(int paramInt, IWindowStatusListener paramIWindowStatusListener);
  
  public abstract void addViewToFloatingWidgetWrapper(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void changeContainerLayoutParams(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2);
  
  public abstract boolean checkPermission(Context paramContext);
  
  public abstract int enterWindowFloat(FloatingScreenParams paramFloatingScreenParams, View paramView, IUpdateUICallbackListener paramIUpdateUICallbackListener, IAddReceiverStatusListener paramIAddReceiverStatusListener);
  
  public abstract void enterWindowFloatWithWidgetWrapper(FloatingScreenParams paramFloatingScreenParams);
  
  public abstract void floatingContainerEnterFullScreen();
  
  public abstract void floatingContainerQuitFullScreen();
  
  public abstract boolean getContainerIsFloating();
  
  public abstract boolean getContainerIsSmallFloating();
  
  public abstract int getFloatWindowShapeType();
  
  public abstract int getFloatingContainerCenterX();
  
  public abstract int getFloatingContainerCenterY();
  
  public abstract boolean getFloatingContainerIsNull();
  
  public abstract int getFloatingContainerVisibility();
  
  public abstract Context getFloatingContext();
  
  public abstract boolean getFloatingIsFullScreen();
  
  public abstract String getFloatingVideoWrapperName();
  
  public abstract boolean getIsInterceptWindowClick(int paramInt1, int paramInt2);
  
  public abstract boolean getIsWindowClickListenerNull();
  
  public abstract View getRootLayout();
  
  public abstract View getViewById(int paramInt);
  
  public abstract void initStatusReceiver();
  
  public abstract void initViews(Context paramContext, View.OnClickListener paramOnClickListener);
  
  public abstract void initWidgetWrapper(View paramView);
  
  public abstract boolean isFloatWindowHasZoomed();
  
  public abstract void onViewClick(View paramView, IUpdateUICallbackListener paramIUpdateUICallbackListener);
  
  public abstract void quitWindowFloat(int paramInt);
  
  public abstract void removeFloatingWidgetWrapperViews();
  
  public abstract void removeParent(View paramView);
  
  public abstract void removeRootLayoutParent();
  
  public abstract void removeWidgetWrapperParent();
  
  public abstract void resetFloatWindowScale();
  
  public abstract void resetWindowSize();
  
  public abstract void restoreLastCenterPosition(FloatingScreenParams paramFloatingScreenParams);
  
  public abstract void setCloseBtnContentDescription(String paramString);
  
  public abstract void setContainerClipToOutline(boolean paramBoolean);
  
  public abstract IVideoOuterStatusListener setDuplexVideoStatusListener(IVideoInnerStatusListener paramIVideoInnerStatusListener);
  
  public abstract void setFloatingCloseBtnVisibility(boolean paramBoolean);
  
  public abstract void setFloatingContainerBackPressListener(IContainerBackPressListener paramIContainerBackPressListener);
  
  public abstract void setFloatingContainerBackground(Drawable paramDrawable);
  
  public abstract void setFloatingContainerBackgroundRes(int paramInt);
  
  public abstract void setFloatingContainerDragListener(IDragListener paramIDragListener);
  
  public abstract void setFloatingContainerOrientation(boolean paramBoolean);
  
  public abstract void setFloatingContainerPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setFloatingContainerVisibility(boolean paramBoolean);
  
  public abstract void setFloatingWidgetBackground(Drawable paramDrawable);
  
  public abstract void setFloatingWidgetClipToOutLine(boolean paramBoolean);
  
  public abstract void setFullScreenEnterListener(IFullScreenEnterListener paramIFullScreenEnterListener);
  
  public abstract void setFullScreenViewClickListener(IFullScreenViewClickListener paramIFullScreenViewClickListener);
  
  public abstract void setRootLayoutAlpha(float paramFloat);
  
  public abstract void setRootLayoutBackgroundColor(int paramInt);
  
  public abstract void setRootLayoutBackgroundRes(int paramInt);
  
  public abstract void setRootLayoutContentDescription(String paramString);
  
  public abstract void setRootLayoutVisible();
  
  public abstract void setRoundCorners(int paramInt1, int paramInt2);
  
  public abstract void setVideoWrapperBackground();
  
  public abstract void setViewEnabled(boolean paramBoolean, View... paramVarArgs);
  
  public abstract void setViewsClick(View.OnClickListener paramOnClickListener, View... paramVarArgs);
  
  public abstract void setViewsVisibility(boolean paramBoolean, View... paramVarArgs);
  
  public abstract void setWindowClickListener(IWindowClickListener paramIWindowClickListener);
  
  public abstract void updateFloatingView();
  
  public abstract void updateLocation(int paramInt1, int paramInt2);
  
  public abstract void updateRatio(float paramFloat);
  
  public abstract void updateShapeType(int paramInt);
  
  public abstract void updateSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
 * JD-Core Version:    0.7.0.1
 */