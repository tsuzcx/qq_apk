package com.tencent.widget;

import android.content.Context;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.util.ReflectionUtil;

public class ListView$OverscrollViewContainer
  extends FrameLayout
{
  public ListView$OverscrollViewContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  private void setParent(ViewParent paramViewParent)
  {
    ReflectionUtil.b(this, "android.view.View", "mParent", paramViewParent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ListView.OverscrollViewContainer
 * JD-Core Version:    0.7.0.1
 */