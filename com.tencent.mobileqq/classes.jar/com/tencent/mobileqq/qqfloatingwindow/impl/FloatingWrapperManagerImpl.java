package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qqfloatingwindow.callback.IAddReceiverStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.callback.IUpdateUICallbackListener;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper;
import com.tencent.mobileqq.qqfloatingwindow.listener.IContainerBackPressListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IDragListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowStatusListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class FloatingWrapperManagerImpl
  implements IFloatingWrapperManager
{
  private static final String TAG = "FloatingWrapperManagerImpl";
  public Context mContext = MobileQQ.sMobileQQ;
  public ImageView mFloatingCloseBtn;
  public FloatingScreenContainer mFloatingContainer;
  public FrameLayout mFloatingWidgetWrapper;
  public RelativeLayout mRootLayout;
  public FloatingScreenStatusReceiver mStatusReceiver;
  public IWindowClickListener mWindowClickListener;
  
  public void addRootLayoutToFloatingWidgetWrapper(ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = this.mFloatingWidgetWrapper;
    if (localFrameLayout != null) {
      localFrameLayout.addView(this.mRootLayout, paramLayoutParams);
    }
  }
  
  public void addScreenStatusReceiver(int paramInt, IWindowStatusListener paramIWindowStatusListener)
  {
    if (this.mStatusReceiver == null)
    {
      this.mStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
      this.mStatusReceiver.a(paramInt, paramIWindowStatusListener);
    }
  }
  
  public void addViewToFloatingWidgetWrapper(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = this.mFloatingWidgetWrapper;
    if (localFrameLayout != null) {
      localFrameLayout.addView(paramView, paramLayoutParams);
    }
  }
  
  public void changeContainerLayoutParams(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.a(paramBoolean1, paramInt1, paramInt2, paramBoolean2);
    }
  }
  
  public boolean checkPermission(Context paramContext)
  {
    return FloatingScreenPermission.checkPermission(paramContext);
  }
  
  public int enterWindowFloat(FloatingScreenParams paramFloatingScreenParams, View paramView, IUpdateUICallbackListener paramIUpdateUICallbackListener, IAddReceiverStatusListener paramIAddReceiverStatusListener)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null) {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setCanZoom(true).build();
      } else {
        return 2;
      }
    }
    if (paramIUpdateUICallbackListener != null)
    {
      paramIUpdateUICallbackListener.a(paramView);
      paramIUpdateUICallbackListener.a(localFloatingScreenParams.getInnerRoundCorner(), localFloatingScreenParams.getOuterRoundCorner());
    }
    removeParent(this.mFloatingWidgetWrapper);
    this.mFloatingContainer.a(this.mFloatingWidgetWrapper, localFloatingScreenParams);
    if (paramIUpdateUICallbackListener != null) {
      paramIUpdateUICallbackListener.dz_();
    }
    if (paramIAddReceiverStatusListener != null) {
      paramIAddReceiverStatusListener.j();
    }
    return 0;
  }
  
  public void enterWindowFloatWithWidgetWrapper(FloatingScreenParams paramFloatingScreenParams)
  {
    this.mFloatingContainer.a(this.mFloatingWidgetWrapper, paramFloatingScreenParams);
  }
  
  public void floatingContainerEnterFullScreen()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.f();
    }
  }
  
  public void floatingContainerQuitFullScreen()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.g();
    }
  }
  
  public boolean getContainerIsFloating()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      return localFloatingScreenContainer.getIsFloating();
    }
    return false;
  }
  
  public boolean getContainerIsSmallFloating()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      return localFloatingScreenContainer.getIsSmallFloating();
    }
    return true;
  }
  
  public int getFloatWindowShapeType()
  {
    return this.mFloatingContainer.getShapeType();
  }
  
  public int getFloatingContainerCenterX()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      return localFloatingScreenContainer.getFloatingCenterX();
    }
    return 0;
  }
  
  public int getFloatingContainerCenterY()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      return localFloatingScreenContainer.getFloatingCenterY();
    }
    return 0;
  }
  
  public boolean getFloatingContainerIsNull()
  {
    return this.mFloatingContainer == null;
  }
  
  public int getFloatingContainerVisibility()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      return localFloatingScreenContainer.getVisibility();
    }
    return 8;
  }
  
  public Context getFloatingContext()
  {
    return this.mContext;
  }
  
  public boolean getFloatingIsFullScreen()
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      return localFloatingScreenContainer.getIsFullScreenFloating();
    }
    return false;
  }
  
  public String getFloatingVideoWrapperName()
  {
    return FloatingVideoWrapper.CLASS_NAME;
  }
  
  public boolean getIsInterceptWindowClick(int paramInt1, int paramInt2)
  {
    IWindowClickListener localIWindowClickListener = this.mWindowClickListener;
    if (localIWindowClickListener != null) {
      return localIWindowClickListener.a(paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean getIsWindowClickListenerNull()
  {
    return this.mWindowClickListener == null;
  }
  
  public View getRootLayout()
  {
    return this.mRootLayout;
  }
  
  public View getViewById(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.mRootLayout;
    if (localRelativeLayout != null) {
      return localRelativeLayout.findViewById(paramInt);
    }
    return null;
  }
  
  public void initStatusReceiver() {}
  
  public void initViews(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramContext == null) {
      return;
    }
    this.mFloatingContainer = new FloatingScreenContainer(paramContext);
    this.mFloatingContainer.setBackgroundColor(paramContext.getResources().getColor(2131168376));
    this.mFloatingWidgetWrapper = new FrameLayout(paramContext);
    this.mFloatingWidgetWrapper.setId(2131442583);
    this.mFloatingWidgetWrapper.setBackgroundColor(paramContext.getResources().getColor(2131168376));
    this.mRootLayout = ((RelativeLayout)View.inflate(paramContext, 2131627973, null));
    this.mFloatingCloseBtn = ((ImageView)this.mRootLayout.findViewById(2131442568));
    this.mFloatingCloseBtn.setContentDescription(this.mContext.getResources().getString(2131897816));
    setViewsClick(paramOnClickListener, new View[] { this.mRootLayout, this.mFloatingCloseBtn });
  }
  
  public void initWidgetWrapper(View paramView)
  {
    this.mFloatingWidgetWrapper.removeAllViews();
    removeParent(paramView);
    paramView.setId(2131442585);
    this.mFloatingWidgetWrapper.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    removeParent(this.mRootLayout);
    this.mFloatingWidgetWrapper.addView(this.mRootLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public boolean isFloatWindowHasZoomed()
  {
    return this.mFloatingContainer.k();
  }
  
  public void onViewClick(View paramView, IUpdateUICallbackListener paramIUpdateUICallbackListener)
  {
    int i = paramView.getId();
    if (i == 2131442568)
    {
      if (paramIUpdateUICallbackListener != null) {
        paramIUpdateUICallbackListener.a(1);
      }
    }
    else if (i == 2131442576)
    {
      paramView = this.mWindowClickListener;
      if (paramView != null) {
        paramView.a(this.mFloatingContainer.getFloatingCenterX(), this.mFloatingContainer.getFloatingCenterY());
      }
    }
  }
  
  public void quitWindowFloat(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.mWindowClickListener;
      if ((localObject != null) && (((IWindowClickListener)localObject).a())) {}
    }
    else
    {
      this.mWindowClickListener = null;
      localObject = this.mFloatingContainer;
      if ((localObject != null) && (((FloatingScreenContainer)localObject).i()))
      {
        removeParent(this.mFloatingWidgetWrapper);
        localObject = this.mFloatingWidgetWrapper;
        if (localObject != null) {
          ((FrameLayout)localObject).removeAllViews();
        }
        setViewsVisibility(false, new View[] { this.mFloatingCloseBtn });
        this.mWindowClickListener = null;
      }
      localObject = this.mStatusReceiver;
      if (localObject != null)
      {
        ((FloatingScreenStatusReceiver)localObject).a();
        this.mStatusReceiver = null;
      }
    }
  }
  
  public void removeFloatingWidgetWrapperViews()
  {
    FrameLayout localFrameLayout = this.mFloatingWidgetWrapper;
    if (localFrameLayout != null) {
      localFrameLayout.removeAllViews();
    }
  }
  
  public void removeParent(View paramView)
  {
    if (paramView != null) {
      try
      {
        ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
        if (localViewGroup != null)
        {
          localViewGroup.removeView(paramView);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      catch (ClassCastException paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void removeRootLayoutParent()
  {
    removeParent(this.mRootLayout);
  }
  
  public void removeWidgetWrapperParent()
  {
    removeParent(this.mFloatingWidgetWrapper);
  }
  
  public void resetFloatWindowScale()
  {
    this.mFloatingContainer.j();
  }
  
  public void resetWindowSize()
  {
    this.mFloatingContainer.h();
  }
  
  public void restoreLastCenterPosition(FloatingScreenParams paramFloatingScreenParams) {}
  
  public void setCloseBtnContentDescription(String paramString)
  {
    paramString = this.mFloatingCloseBtn;
    if (paramString != null) {
      paramString.setContentDescription("关闭位置共享悬浮窗");
    }
  }
  
  public void setContainerClipToOutline(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
      if (localFloatingScreenContainer != null) {
        localFloatingScreenContainer.setClipToOutline(paramBoolean);
      }
    }
  }
  
  public IVideoOuterStatusListener setDuplexVideoStatusListener(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return null;
  }
  
  public void setFloatingCloseBtnVisibility(boolean paramBoolean)
  {
    setViewsVisibility(paramBoolean, new View[] { this.mFloatingCloseBtn });
  }
  
  public void setFloatingContainerBackPressListener(IContainerBackPressListener paramIContainerBackPressListener)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.setOnBackPressListener(paramIContainerBackPressListener);
    }
  }
  
  public void setFloatingContainerBackground(Drawable paramDrawable)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setFloatingContainerBackgroundRes(int paramInt)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.setOutCornerBackgroundDrawable(paramInt);
    }
  }
  
  public void setFloatingContainerDragListener(IDragListener paramIDragListener)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.setOnDragListener(paramIDragListener);
    }
  }
  
  public void setFloatingContainerOrientation(boolean paramBoolean)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if ((localFloatingScreenContainer != null) && (localFloatingScreenContainer.getIsFloating())) {
      this.mFloatingContainer.a(paramBoolean);
    }
  }
  
  public void setFloatingContainerPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FloatingScreenContainer localFloatingScreenContainer = this.mFloatingContainer;
    if (localFloatingScreenContainer != null) {
      localFloatingScreenContainer.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setFloatingContainerVisibility(boolean paramBoolean)
  {
    setViewsVisibility(paramBoolean, new View[] { this.mFloatingContainer });
  }
  
  public void setFloatingWidgetBackground(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      FrameLayout localFrameLayout = this.mFloatingWidgetWrapper;
      if (localFrameLayout != null) {
        localFrameLayout.setBackground(paramDrawable);
      }
    }
  }
  
  public void setFloatingWidgetClipToOutLine(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      FrameLayout localFrameLayout = this.mFloatingWidgetWrapper;
      if (localFrameLayout != null) {
        localFrameLayout.setClipToOutline(paramBoolean);
      }
    }
  }
  
  public void setFullScreenEnterListener(IFullScreenEnterListener paramIFullScreenEnterListener) {}
  
  public void setFullScreenViewClickListener(IFullScreenViewClickListener paramIFullScreenViewClickListener) {}
  
  public void setRootLayoutAlpha(float paramFloat)
  {
    RelativeLayout localRelativeLayout = this.mRootLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getAlpha() != paramFloat)) {
      this.mRootLayout.setAlpha(paramFloat);
    }
  }
  
  public void setRootLayoutBackgroundColor(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.mRootLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setBackgroundColor(paramInt);
    }
  }
  
  public void setRootLayoutBackgroundRes(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.mRootLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setBackgroundResource(paramInt);
    }
  }
  
  public void setRootLayoutContentDescription(String paramString)
  {
    RelativeLayout localRelativeLayout = this.mRootLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setContentDescription(paramString);
    }
  }
  
  public void setRootLayoutVisible()
  {
    RelativeLayout localRelativeLayout = this.mRootLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() != 0)) {
      this.mRootLayout.setVisibility(0);
    }
  }
  
  public void setRoundCorners(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = this.mFloatingContainer;
      if (localObject != null)
      {
        ((FloatingScreenContainer)localObject).setOutlineProvider(new FloatingOutlineProvider(paramInt2));
        this.mFloatingContainer.setClipToOutline(true);
        this.mFloatingContainer.setElevation(15.0F);
        int i = this.mFloatingContainer.getOutCornerBackgroundDrawable();
        this.mFloatingContainer.setBackground(this.mContext.getResources().getDrawable(i));
        localObject = (FrameLayout)this.mFloatingContainer.findViewById(2131442582);
        if (localObject != null)
        {
          ((FrameLayout)localObject).setOutlineProvider(new FloatingOutlineProvider(paramInt1));
          ((FrameLayout)localObject).setClipToOutline(true);
        }
        View localView = this.mFloatingContainer.findViewById(2131442585);
        if (localView != null)
        {
          localView.setOutlineProvider(new FloatingOutlineProvider(paramInt1));
          localView.setClipToOutline(true);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setRoundCorners() videoCoverContainer == null: ");
          boolean bool2 = false;
          if (localObject == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localStringBuilder.append(bool1);
          localStringBuilder.append(" customView == null: ");
          boolean bool1 = bool2;
          if (localView == null) {
            bool1 = true;
          }
          localStringBuilder.append(bool1);
          QLog.d("FloatingWrapperManagerImpl", 2, localStringBuilder.toString());
        }
      }
      localObject = this.mFloatingWidgetWrapper;
      if (localObject != null)
      {
        ((FrameLayout)localObject).setOutlineProvider(new FloatingOutlineProvider(paramInt1));
        this.mFloatingWidgetWrapper.setClipToOutline(true);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setRoundCorners() innerRoundCorners = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" outerRoundCorners = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("FloatingWrapperManagerImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setVideoWrapperBackground()
  {
    if (this.mRootLayout != null)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.mFloatingContainer;
        if ((localObject != null) && (((FloatingScreenContainer)localObject).getIsFullScreenFloating()))
        {
          this.mRootLayout.setBackgroundResource(2130847947);
          return;
        }
      }
      Object localObject = this.mContext;
      if ((localObject != null) && (((Context)localObject).getResources() != null)) {
        this.mRootLayout.setBackgroundColor(this.mContext.getResources().getColor(2131168376));
      }
    }
  }
  
  public void setViewEnabled(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setViewsClick(View.OnClickListener paramOnClickListener, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setOnClickListener(paramOnClickListener);
      }
      i += 1;
    }
  }
  
  public void setViewsVisibility(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        if (paramBoolean) {
          localView.setVisibility(0);
        } else {
          localView.setVisibility(4);
        }
      }
      i += 1;
    }
  }
  
  public void setWindowClickListener(IWindowClickListener paramIWindowClickListener)
  {
    this.mWindowClickListener = paramIWindowClickListener;
  }
  
  public void updateFloatingView()
  {
    setViewsVisibility(true, new View[] { this.mFloatingContainer, this.mFloatingCloseBtn });
  }
  
  public void updateLocation(int paramInt1, int paramInt2)
  {
    this.mFloatingContainer.a(paramInt1, paramInt2);
  }
  
  public void updateRatio(float paramFloat)
  {
    this.mFloatingContainer.a(paramFloat);
  }
  
  public void updateShapeType(int paramInt)
  {
    this.mFloatingContainer.a(paramInt);
  }
  
  public void updateSize(int paramInt1, int paramInt2)
  {
    this.mFloatingContainer.b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.FloatingWrapperManagerImpl
 * JD-Core Version:    0.7.0.1
 */