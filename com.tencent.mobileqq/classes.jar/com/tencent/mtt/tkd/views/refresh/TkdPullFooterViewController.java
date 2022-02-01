package com.tencent.mtt.tkd.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterViewController;

@HippyController(isLazyLoad=true, name="tkdPullFooterView")
public class TkdPullFooterViewController
  extends HippyPullFooterViewController
{
  public static final String CLASS_NAME = "tkdPullFooterView";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdPullFooterView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.refresh.TkdPullFooterViewController
 * JD-Core Version:    0.7.0.1
 */