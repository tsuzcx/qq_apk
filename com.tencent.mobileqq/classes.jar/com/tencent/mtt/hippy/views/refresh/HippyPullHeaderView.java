package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class HippyPullHeaderView
  extends HippyViewGroup
{
  private View mParentView;
  
  public HippyPullHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getParentView()
  {
    return this.mParentView;
  }
  
  public void setParentView(View paramView)
  {
    this.mParentView = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView
 * JD-Core Version:    0.7.0.1
 */