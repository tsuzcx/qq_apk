package com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingOutlineProvider;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenContainer;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenViewClickListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class FloatingBaseWrapper
  implements View.OnClickListener
{
  public Context mContext;
  public ImageView mFloatingCloseBtn;
  public FloatingScreenContainer mFloatingContainer;
  public FrameLayout mFloatingWidgetWrapper;
  public RelativeLayout mRootLayout;
  public FloatingScreenStatusReceiver mStatusReceiver;
  public IWindowClickListener mWindowClickListener;
  
  public FloatingBaseWrapper(Context paramContext)
  {
    this.mContext = paramContext;
    a(paramContext);
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.mContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setCanZoom(true).build();
      }
    }
    else
    {
      a(paramView);
      a(localFloatingScreenParams.getInnerRoundCorner(), localFloatingScreenParams.getOuterRoundCorner());
      b(this.mFloatingWidgetWrapper);
      this.mFloatingContainer.a(this.mFloatingWidgetWrapper, localFloatingScreenParams);
      c();
      d();
      return 0;
    }
    return 2;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return null;
  }
  
  public void a(float paramFloat)
  {
    this.mFloatingContainer.b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.mFloatingContainer.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.mFloatingContainer != null)
      {
        this.mFloatingContainer.setOutlineProvider(new FloatingOutlineProvider(paramInt2));
        this.mFloatingContainer.setClipToOutline(true);
        this.mFloatingContainer.setElevation(15.0F);
        this.mFloatingContainer.setBackground(this.mContext.getResources().getDrawable(2130846588));
      }
      if (this.mFloatingWidgetWrapper != null)
      {
        this.mFloatingWidgetWrapper.setOutlineProvider(new FloatingOutlineProvider(paramInt1));
        this.mFloatingWidgetWrapper.setClipToOutline(true);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mFloatingContainer = new FloatingScreenContainer(paramContext);
    this.mFloatingContainer.setBackgroundColor(paramContext.getResources().getColor(2131167305));
    this.mFloatingWidgetWrapper = new FrameLayout(paramContext);
    this.mFloatingWidgetWrapper.setId(2131374881);
    this.mFloatingWidgetWrapper.setBackgroundColor(paramContext.getResources().getColor(2131167305));
    this.mRootLayout = ((RelativeLayout)View.inflate(paramContext, 2131561748, null));
    this.mFloatingCloseBtn = ((ImageView)this.mRootLayout.findViewById(2131374867));
    this.mFloatingCloseBtn.setContentDescription(this.mContext.getResources().getString(2131699653));
    a(new View[] { this.mRootLayout, this.mFloatingCloseBtn });
  }
  
  public void a(View paramView)
  {
    this.mFloatingWidgetWrapper.removeAllViews();
    b(paramView);
    paramView.setId(2131374883);
    this.mFloatingWidgetWrapper.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    b(this.mRootLayout);
    this.mFloatingWidgetWrapper.addView(this.mRootLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams) {}
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener) {}
  
  public void a(IFullScreenViewClickListener paramIFullScreenViewClickListener) {}
  
  public void a(IWindowClickListener paramIWindowClickListener)
  {
    this.mWindowClickListener = paramIWindowClickListener;
  }
  
  public void a(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    label11:
    View localView;
    if (i < j)
    {
      localView = paramVarArgs[i];
      if (localView != null)
      {
        if (!paramBoolean) {
          break label44;
        }
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      i += 1;
      break label11;
      break;
      label44:
      localView.setVisibility(4);
    }
  }
  
  public void a(View... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        View localView = paramVarArgs[i];
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        i += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 1) || (this.mWindowClickListener == null) || (!this.mWindowClickListener.a()))
    {
      this.mWindowClickListener = null;
      if ((this.mFloatingContainer != null) && (this.mFloatingContainer.d()))
      {
        b(this.mFloatingWidgetWrapper);
        if (this.mFloatingWidgetWrapper != null) {
          this.mFloatingWidgetWrapper.removeAllViews();
        }
        a(false, new View[] { this.mFloatingCloseBtn });
        this.mWindowClickListener = null;
      }
      if (this.mStatusReceiver != null)
      {
        this.mStatusReceiver.a();
        this.mStatusReceiver = null;
      }
    }
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
      return;
    }
    catch (ClassCastException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
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
  }
  
  public void c()
  {
    a(true, new View[] { this.mFloatingContainer, this.mFloatingCloseBtn });
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131374867) {
      b(1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131374874) && (this.mWindowClickListener != null)) {
        this.mWindowClickListener.a(this.mFloatingContainer.a(), this.mFloatingContainer.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingBaseWrapper
 * JD-Core Version:    0.7.0.1
 */