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
    boolean bool = true;
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      if (localObject != null) {
        break label30;
      }
      label20:
      bool = false;
    }
    label30:
    label120:
    do
    {
      do
      {
        return bool;
        localObject = null;
        break;
        if (((Integer)localObject).intValue() != 1) {
          break label20;
        }
        localObject = this.a.a().getCompoundDrawables()[0];
        if ((localObject == null) || (paramMotionEvent.getRawX() > this.a.a().getLeft() + ((Drawable)localObject).getBounds().width() - this.a.a().getPaddingLeft())) {
          break label120;
        }
        paramMotionEvent = DrawableClickHelper.a(this.a);
      } while (paramMotionEvent == null);
      paramMotionEvent.a(paramView, (Drawable)localObject);
      return true;
      localObject = this.a.a().getCompoundDrawables()[2];
      if ((localObject == null) || (paramMotionEvent.getRawX() < this.a.a().getRight() - ((Drawable)localObject).getBounds().width() - this.a.a().getPaddingRight())) {
        break label20;
      }
      paramMotionEvent = DrawableClickHelper.a(this.a);
    } while (paramMotionEvent == null);
    paramMotionEvent.b(paramView, (Drawable)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.DrawableClickHelper.onTouchListener.1
 * JD-Core Version:    0.7.0.1
 */