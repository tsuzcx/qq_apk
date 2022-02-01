package com.tencent.mobileqq.flashshow.widgets.fault;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;

public class FSFullScreenHintView
  extends FSFaultHintView
{
  public FSFullScreenHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSFullScreenHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.gravity = 49;
    localLayoutParams.topMargin = ViewUtils.dpToPx(288.0F);
    this.b.setLayoutParams(localLayoutParams);
    this.a.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.fault.FSFullScreenHintView
 * JD-Core Version:    0.7.0.1
 */