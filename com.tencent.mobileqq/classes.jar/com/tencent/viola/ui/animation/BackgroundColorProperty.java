package com.tencent.viola.ui.animation;

import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import android.view.View;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.dom.style.BorderDrawable;
import com.tencent.viola.ui.view.IVView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;

public class BackgroundColorProperty
  extends Property<View, Integer>
{
  private static final String TAG = "BackgroundColorAnimation";
  
  public BackgroundColorProperty()
  {
    super(Integer.class, "backgroundColor");
  }
  
  public Integer get(View paramView)
  {
    BorderDrawable localBorderDrawable = ViolaUtils.getBorderDrawable(paramView);
    int i;
    if (localBorderDrawable != null) {
      i = localBorderDrawable.getColor();
    }
    for (;;)
    {
      return Integer.valueOf(i);
      if ((paramView.getBackground() instanceof ColorDrawable))
      {
        i = ((ColorDrawable)paramView.getBackground()).getColor();
      }
      else
      {
        i = 0;
        ViolaLogUtils.e("BackgroundColorAnimation", "Unsupported background type");
      }
    }
  }
  
  public void set(View paramView, Integer paramInteger)
  {
    Object localObject = ViolaUtils.getBorderDrawable(paramView);
    if (localObject != null) {
      ((BorderDrawable)localObject).setColor(paramInteger.intValue());
    }
    for (;;)
    {
      if ((paramView instanceof IVView))
      {
        localObject = ((IVView)paramView).getComponent();
        if (localObject != null) {
          ((VComponent)localObject).notifyNativeBgColorChanged(paramInteger.intValue());
        }
      }
      paramView.requestLayout();
      return;
      if ((paramView.getBackground() instanceof ColorDrawable)) {
        ((ColorDrawable)paramView.getBackground()).setColor(paramInteger.intValue());
      } else {
        ViolaLogUtils.e("BackgroundColorAnimation", "Unsupported background type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.animation.BackgroundColorProperty
 * JD-Core Version:    0.7.0.1
 */