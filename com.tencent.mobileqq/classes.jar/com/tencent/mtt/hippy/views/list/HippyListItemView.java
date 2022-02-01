package com.tencent.mtt.hippy.views.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class HippyListItemView
  extends HippyViewGroup
{
  public static final String EXPOSURE_EVENT_APPEAR = "onAppear";
  public static final String EXPOSURE_EVENT_DISAPPEAR = "onDisAppear";
  public static final String EXPOSURE_EVENT_WILL_APPEAR = "onWillAppear";
  public static final String EXPOSURE_EVENT_WILL_DISAPPEAR = "onWillDisappear";
  public static final int EXPOSURE_STATE_APPEAR = 1;
  public static final int EXPOSURE_STATE_DISAPPEAR = 2;
  public static final int EXPOSURE_STATE_WILL_APPEAR = 0;
  public static final int EXPOSURE_STATE_WILL_DISAPPEAR = 3;
  private static final boolean VIEW_LEVEL_MONITOR_ENABLE = false;
  private int mExposureState = 2;
  private Paint mPaint;
  
  public HippyListItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private int calculateChildLevel(View paramView)
  {
    boolean bool = paramView instanceof ViewGroup;
    int j = 1;
    int i = j;
    if (bool)
    {
      int k = getChildCount();
      i = j;
      if (k != 0)
      {
        i = 0;
        j = 0;
        while (i < k)
        {
          j = Math.max(j, calculateChildLevel(((ViewGroup)paramView).getChildAt(i)));
          i += 1;
        }
        i = 1 + j;
      }
    }
    return i;
  }
  
  private int calculateHippyLevel()
  {
    int i = 0;
    Object localObject = this;
    while ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof View)) && (!(((View)localObject).getParent() instanceof HippyRootView)))
    {
      localObject = (View)((View)localObject).getParent();
      i += 1;
    }
    int j = i;
    if ((((View)localObject).getParent() instanceof HippyRootView)) {
      j = i + 1;
    }
    return j;
  }
  
  private int calculateSelfLevel()
  {
    int i = 0;
    Object localObject = this;
    while ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof View)))
    {
      localObject = (View)((View)localObject).getParent();
      i += 1;
    }
    return i;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public int getExposureState()
  {
    return this.mExposureState;
  }
  
  public void setExposureState(int paramInt)
  {
    this.mExposureState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListItemView
 * JD-Core Version:    0.7.0.1
 */