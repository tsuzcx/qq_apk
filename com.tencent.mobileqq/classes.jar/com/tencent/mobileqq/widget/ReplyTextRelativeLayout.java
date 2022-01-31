package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class ReplyTextRelativeLayout
  extends RelativeLayout
{
  public ReplyTextRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReplyTextRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReplyTextRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ReplyTextRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt4 = getChildCount();
    paramInt2 = 0;
    while (paramInt2 < paramInt4)
    {
      View localView = getChildAt(paramInt2);
      if ((localView.getVisibility() != 8) && (localView.getId() == 2131302983)) {
        localView.layout(paramInt3 - paramInt1 + 0 - localView.getMeasuredWidth(), 0, paramInt3 - paramInt1 + 0, localView.getMeasuredHeight() + 0);
      }
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ReplyTextRelativeLayout
 * JD-Core Version:    0.7.0.1
 */