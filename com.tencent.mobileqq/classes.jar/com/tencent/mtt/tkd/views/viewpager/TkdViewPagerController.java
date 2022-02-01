package com.tencent.mtt.tkd.views.viewpager;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController;

@HippyController(name="tkdViewPager")
public class TkdViewPagerController
  extends HippyViewPagerController
{
  public static final String CLASS_NAME = "tkdViewPager";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdViewPager(paramContext);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramHippyMap != null) {
      if ((!paramHippyMap.containsKey("direction")) || (!paramHippyMap.getString("direction").equals("vertical")))
      {
        bool1 = bool2;
        if (!paramHippyMap.containsKey("vertical")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return new TkdViewPager(paramContext, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.viewpager.TkdViewPagerController
 * JD-Core Version:    0.7.0.1
 */