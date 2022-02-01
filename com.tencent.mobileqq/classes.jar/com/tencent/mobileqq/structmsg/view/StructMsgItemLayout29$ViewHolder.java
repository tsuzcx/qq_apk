package com.tencent.mobileqq.structmsg.view;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;

class StructMsgItemLayout29$ViewHolder
  implements BaseBubbleBuilder.TouchDelegate
{
  View a;
  TextView b;
  TextView c;
  ImageView d;
  boolean e;
  int f;
  
  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = this.a.getBackground();
    if (localDrawable != null)
    {
      ColorFilter localColorFilter;
      if (paramBoolean) {
        localColorFilter = null;
      } else {
        localColorFilter = BaseBubbleBuilder.n;
      }
      localDrawable.setColorFilter(localColorFilter);
      localDrawable.invalidateSelf();
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      paramView = this.a.getBackground();
      if (paramView != null)
      {
        paramView.setColorFilter(null);
        paramView.invalidateSelf();
      }
    }
    else
    {
      a(false);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29.ViewHolder
 * JD-Core Version:    0.7.0.1
 */