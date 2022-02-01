package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class HippyPullFooterView
  extends HippyViewGroup
{
  private View mParentView;
  private boolean mStickEnabled = false;
  
  public HippyPullFooterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getParentView()
  {
    return this.mParentView;
  }
  
  public boolean getStickEnabled()
  {
    return this.mStickEnabled;
  }
  
  public void setParentView(View paramView)
  {
    this.mParentView = paramView;
  }
  
  public void setStickEnabled(boolean paramBoolean)
  {
    this.mStickEnabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.refresh.HippyPullFooterView
 * JD-Core Version:    0.7.0.1
 */