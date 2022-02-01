package com.tencent.mtt.tkd.views.viewpager;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerItemController;

@HippyController(name="tkdViewPagerItem")
public class TkdViewPagerItemController
  extends HippyViewPagerItemController
{
  public static final String CLASS_NAME = "tkdViewPagerItem";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdViewPagerItem(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.viewpager.TkdViewPagerItemController
 * JD-Core Version:    0.7.0.1
 */