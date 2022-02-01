package com.tencent.shadow.core.runtime.skin.entity;

import android.view.View;
import android.widget.ImageView;

public class SrcAttr
  extends SkinAttr
{
  public boolean applyInner(View paramView)
  {
    if ((paramView instanceof ImageView))
    {
      paramView = (ImageView)paramView;
      if (isColorAttr())
      {
        paramView.setImageResource(getColor());
        return true;
      }
      if (isDrawableAttr())
      {
        paramView.setImageDrawable(getDrawable());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.skin.entity.SrcAttr
 * JD-Core Version:    0.7.0.1
 */