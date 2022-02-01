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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
        switch (i)
        {
        default: 
          paramString = ObjectAnimator.ofFloat(localView, "translationX", new float[] { 0.0F, getWidth() });
        }
        break;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.addListener(this);
          paramString.start();
        }
        return;
        if (!str.equals("top")) {
          break;
        }
        i = 0;
        break;
        if (!str.equals("bottom")) {
          break;
        }
        i = 1;
        break;
        if (!str.equals("left")) {
          break;
        }
        i = 2;
        break;
        if (!str.equals("right")) {
          break;
        }
        i = 3;
        break;
        paramString = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, -getHeight() });
        continue;
        paramString = ObjectAnimator.ofFloat(localView, "translationY", new float[] { 0.0F, getHeight() });
        continue;
        paramString = ObjectAnimator.ofFloat(localView, "translationX", new float[] { 0.0F, -getWidth() });
      }
    }
    NavigatorController.destroyInstance(localView);
    removeView(localView);
  }
  
  public void push(HippyRootView paramHippyRootView, boolean paramBoolean, String paramString)
  {
    addView(paramHippyRootView);
    paramHippyRootView.layout(0, 0, getWidth(), getHeight());
    String str;
    int i;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      i = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationX", new float[] { getWidth(), 0.0F });
        }
        break;
      }
    }
    for (;;)
    {
      if (paramHippyRootView != null) {
        paramHippyRootView.start();
      }
      return;
      if (!str.equals("top")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("bottom")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("left")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("right")) {
        break;
      }
      i = 3;
      break;
      paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationY", new float[] { -getHeight(), 0.0F });
      continue;
      paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationY", new float[] { getHeight(), 0.0F });
      continue;
      paramHippyRootView = ObjectAnimator.ofFloat(paramHippyRootView, "translationX", new float[] { -getWidth(), 0.0F });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.navigator.Navigator
 * JD-Core Version:    0.7.0.1
 */