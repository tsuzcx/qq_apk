package com.tencent.mobileqq.receipt;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.widget.LayerImageView;

public class ReceiptBubbleLayerImageView
  extends LayerImageView
  implements BaseBubbleBuilder.TouchDelegate
{
  public ReceiptBubbleLayerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 1) && (i != 3)) {
      return;
    }
    paramView = getDrawable();
    if (paramView != null)
    {
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      if (paramBoolean) {
        paramView = null;
      } else {
        paramView = BaseBubbleBuilder.a;
      }
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptBubbleLayerImageView
 * JD-Core Version:    0.7.0.1
 */