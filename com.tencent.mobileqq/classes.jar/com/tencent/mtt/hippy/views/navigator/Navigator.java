package com.tencent.mtt.hippy.views.navigator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class Navigator
  extends HippyViewGroup
{
  private static final String DIRECTION_BOTTOM = "bottom";
  private static final String DIRECTION_LEFT = "left";
  private static final String DIRECTION_RIGHT = "right";
  private static final String DIRECTION_TOP = "top";
  
  public Navigator(Context paramContext)
  {
    super(paramContext);
  }
  
  public void init(HippyRootView paramHippyRootView)
  {
    addView(paramHippyRootView);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    View localView = (View)((ObjectAnimator)paramAnimator).getTarget();
    NavigatorController.destroyInstance(localView);
    paramAnimator.removeAllListeners();
    post(new Navigator.1(this, localView));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).layout(0, 0, getWidth(), getHeight());
      paramInt1 += 1;
    }
  }
  
  public void pop(boolean paramBoolean, String paramString)
  {
    View localView = getChildAt(getChildCount() - 1);
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 108511772: 
        if (str.equals("right")) {
          i = 3;
        }
        break;
      case 3317767: 
        if (str.equals("left")) {
          i = 2;
        }
        break;
      case 115029: 
        if (str.equals("top")) {
          i = 0;
        }
        break;
      case -1383228885: 
        if (str.equals("bottom")) {
          i = 1;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            paramString = ObjectAnimator.ofFloat(localView, "translationX", new float[] { 0.0F, getWidth() });
          } else {
            paramString = ObjectAnimator.ofFloat(localView, "translationX", new float[] { 0.0F, -getWidth() });
          }
        }
        else {
          paramString = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, getHeight() });
        }
      }
      else {
        paramString = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, -getHeight() });
      }
      if (paramString != null)
      {
        paramString.addListener(this);
        paramString.start();
      }
    }
    else
    {
      NavigatorController.destroyInstance(localView);
      removeView(localView);
    }
  }
  
  public void push(HippyRootView paramHippyRootView, boolean paramBoolean, String paramString)
  {
    addView(paramHippyRootView);
    paramHippyRootView.layout(0, 0, getWidth(), getHeight());
    if (paramBoolean)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        break;
      case 108511772: 
        if (str.equals("right")) {
          i = 3;
        }
        break;
      case 3317767: 
        if (str.equals("left")) {
          i = 2;
        }
        break;
      case 115029: 
        if (str.equals("top")) {
          i = 0;
        }
        break;
      case -1383228885: 
        if (str.equals("bottom")) {
          i = 1;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationX", new float[] { getWidth(), 0.0F });
          } else {
            paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationX", new float[] { -getWidth(), 0.0F });
          }
        }
        else {
          paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationY", new float[] { getHeight(), 0.0F });
        }
      }
      else {
        paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationY", new float[] { -getHeight(), 0.0F });
      }
      if (paramHippyRootView != null) {
        paramHippyRootView.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.navigator.Navigator
 * JD-Core Version:    0.7.0.1
 */