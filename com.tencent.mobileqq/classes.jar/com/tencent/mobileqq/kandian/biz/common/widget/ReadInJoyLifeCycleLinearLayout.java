package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.base.view.api.IReadInJoyLifeCycleView;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyListItemLifeCycle;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell;

public class ReadInJoyLifeCycleLinearLayout
  extends LinearLayout
  implements IReadInJoyLifeCycleView
{
  private boolean a = false;
  
  public ReadInJoyLifeCycleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Object localObject = getTag();
    if ((localObject instanceof FeedItemCell))
    {
      localObject = ((FeedItemCell)localObject).a();
      if ((localObject instanceof IReadInJoyListItemLifeCycle)) {
        ((IReadInJoyListItemLifeCycle)localObject).a();
      }
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b()
  {
    Object localObject = getTag();
    if ((localObject instanceof FeedItemCell))
    {
      localObject = ((FeedItemCell)localObject).a();
      if ((localObject instanceof IReadInJoyListItemLifeCycle)) {
        ((IReadInJoyListItemLifeCycle)localObject).b();
      }
    }
  }
  
  public void setIsResume(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyLifeCycleLinearLayout
 * JD-Core Version:    0.7.0.1
 */