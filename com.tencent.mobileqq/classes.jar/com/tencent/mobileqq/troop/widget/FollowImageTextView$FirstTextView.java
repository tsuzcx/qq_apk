package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.widget.TextView;

class FollowImageTextView$FirstTextView
  extends TextView
{
  public FollowImageTextView$FirstTextView(FollowImageTextView paramFollowImageTextView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (FollowImageTextView.a(this.a))
    {
      super.onDraw(paramCanvas);
      return;
    }
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = FollowImageTextView.b(this.a);
    ((FollowImageTextView.TextLineHelper)localObject).a(FollowImageTextView.c(this.a) - 1);
    ((FollowImageTextView.TextLineHelper)localObject).a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FollowImageTextView.FirstTextView
 * JD-Core Version:    0.7.0.1
 */