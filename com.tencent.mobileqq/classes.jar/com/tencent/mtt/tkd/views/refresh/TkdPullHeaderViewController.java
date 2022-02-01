package com.tencent.mtt.tkd.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderViewController;

@HippyController(isLazyLoad=true, name="tkdPullHeaderView")
public class TkdPullHeaderViewController
  extends HippyPullHeaderViewController
{
  public static final String CLASS_NAME = "tkdPullHeaderView";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdPullHeaderView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.refresh.TkdPullHeaderViewController
 * JD-Core Version:    0.7.0.1
 */