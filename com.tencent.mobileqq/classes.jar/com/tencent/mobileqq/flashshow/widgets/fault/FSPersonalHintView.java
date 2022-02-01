package com.tencent.mobileqq.flashshow.widgets.fault;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;

public class FSPersonalHintView
  extends FSFaultHintView
{
  public FSPersonalHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSPersonalHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.gravity = 49;
    localLayoutParams.topMargin = ViewUtils.dpToPx(288.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.fault.FSPersonalHintView
 * JD-Core Version:    0.7.0.1
 */