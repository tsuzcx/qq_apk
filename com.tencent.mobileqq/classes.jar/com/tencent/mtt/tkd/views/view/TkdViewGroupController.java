package com.tencent.mtt.tkd.views.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

@HippyController(name="tkdView")
public class TkdViewGroupController
  extends HippyViewGroupController
{
  public static final String CLASS_NAME = "tkdView";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdViewGroup(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.view.TkdViewGroupController
 * JD-Core Version:    0.7.0.1
 */