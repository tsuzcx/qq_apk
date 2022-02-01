package com.tencent.mtt.tkd.views.list;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.list.HippyListItemViewController;

@HippyController(isLazyLoad=true, name="tkdCell")
public class TkdListItemViewController
  extends HippyListItemViewController
{
  public static final String CLASS_NAME = "tkdCell";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdListItemView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.list.TkdListItemViewController
 * JD-Core Version:    0.7.0.1
 */