package com.tencent.mobileqq.flashshow.widgets.fault;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;

public class FSCommentPanelHintView
  extends FSFaultHintView
{
  public FSCommentPanelHintView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSCommentPanelHintView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.a.setPadding(0, 0, 0, ViewUtils.dpToPx(40.0F));
    this.a.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.fault.FSCommentPanelHintView
 * JD-Core Version:    0.7.0.1
 */