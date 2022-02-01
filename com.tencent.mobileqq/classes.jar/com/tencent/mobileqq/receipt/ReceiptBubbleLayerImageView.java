package com.tencent.mobileqq.receipt;

import afwq;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.widget.LayerImageView;

public class ReceiptBubbleLayerImageView
  extends LayerImageView
  implements afwq
{
  public ReceiptBubbleLayerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = getDrawable();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = BaseBubbleBuilder.a)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptBubbleLayerImageView
 * JD-Core Version:    0.7.0.1
 */