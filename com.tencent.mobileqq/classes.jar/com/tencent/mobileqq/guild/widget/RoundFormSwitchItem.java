package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class RoundFormSwitchItem
  extends FormSwitchItem
{
  public RoundFormSwitchItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundFormSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    setBackgroundDrawable(getResources().getDrawable(2130841019));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.RoundFormSwitchItem
 * JD-Core Version:    0.7.0.1
 */