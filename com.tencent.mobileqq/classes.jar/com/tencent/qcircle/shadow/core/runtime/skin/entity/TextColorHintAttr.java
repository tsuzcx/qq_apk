package com.tencent.qcircle.shadow.core.runtime.skin.entity;

import android.view.View;
import android.widget.TextView;

public class TextColorHintAttr
  extends SkinAttr
{
  public boolean applyInner(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (isColorAttr())
      {
        paramView.setHintTextColor(getColorStateList());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.skin.entity.TextColorHintAttr
 * JD-Core Version:    0.7.0.1
 */