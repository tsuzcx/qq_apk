package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class HorizontalBallLoadingView
  extends MetaballView
{
  private float a;
  
  public HorizontalBallLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalBallLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalBallLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int a()
  {
    return (int)(((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 6.0F) * this.a);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, ((IResourceUtil)QRoute.api(IResourceUtil.class)).getBallLoadingView());
    this.a = paramContext.getFloat(((IResourceUtil)QRoute.api(IResourceUtil.class)).getBallLoadingViewBallScale(), 1.0F);
    paramContext.recycle();
  }
  
  protected int b()
  {
    return (int)(((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 10.0F) * this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView
 * JD-Core Version:    0.7.0.1
 */