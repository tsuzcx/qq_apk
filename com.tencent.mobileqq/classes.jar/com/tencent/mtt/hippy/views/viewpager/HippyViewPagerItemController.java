package com.tencent.mtt.hippy.views.viewpager;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="ViewPagerItem")
public class HippyViewPagerItemController
  extends HippyViewController<HippyViewPagerItem>
{
  public static final String CLASS_NAME = "ViewPagerItem";
  private static final String TAG = "ViewPagerItem";
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyViewPagerItem(paramContext);
  }
  
  protected boolean shouldInterceptLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPagerItemController
 * JD-Core Version:    0.7.0.1
 */