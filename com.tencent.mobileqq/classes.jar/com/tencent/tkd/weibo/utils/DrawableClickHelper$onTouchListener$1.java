package com.tencent.tkd.weibo.utils;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/utils/DrawableClickHelper$onTouchListener$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class DrawableClickHelper$onTouchListener$1
  implements View.OnTouchListener
{
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(@Nullable View paramView, @Nullable MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (paramMotionEvent != null) {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return false;
    }
    if (((Integer)localObject).intValue() == 1)
    {
      localObject = this.a.a().getCompoundDrawables()[0];
      if ((localObject != null) && (paramMotionEvent.getRawX() <= this.a.a().getLeft() + ((Drawable)localObject).getBounds().width() - this.a.a().getPaddingLeft()))
      {
        paramMotionEvent = DrawableClickHelper.a(this.a);
        if (paramMotionEvent != null) {
          paramMotionEvent.a(paramView, (Drawable)localObject);
        }
        return true;
      }
      localObject = this.a.a().getCompoundDrawables()[2];
      if ((localObject != null) && (paramMotionEvent.getRawX() >= this.a.a().getRight() - ((Drawable)localObject).getBounds().width() - this.a.a().getPaddingRight()))
      {
        paramMotionEvent = DrawableClickHelper.a(this.a);
        if (paramMotionEvent != null) {
          paramMotionEvent.b(paramView, (Drawable)localObject);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.DrawableClickHelper.onTouchListener.1
 * JD-Core Version:    0.7.0.1
 */