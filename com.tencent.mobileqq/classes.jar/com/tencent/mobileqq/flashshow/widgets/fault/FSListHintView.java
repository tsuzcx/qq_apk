package com.tencent.mobileqq.flashshow.widgets.fault;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FSListHintView
  extends FSFaultHintView
{
  public FSListHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSListHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.gravity = 17;
    this.b.setLayoutParams(localLayoutParams);
    this.a.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.fault.FSListHintView
 * JD-Core Version:    0.7.0.1
 */