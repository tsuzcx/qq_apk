package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;

class SingleViewPresentation$FakeWindowViewGroup
  extends ViewGroup
{
  private final Rect childRect = new Rect();
  private final Rect viewBounds = new Rect();
  
  public SingleViewPresentation$FakeWindowViewGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int atMost(int paramInt)
  {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt), -2147483648);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
      this.viewBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      Gravity.apply(localLayoutParams.gravity, localView.getMeasuredWidth(), localView.getMeasuredHeight(), this.viewBounds, localLayoutParams.x, localLayoutParams.y, this.childRect);
      localView.layout(this.childRect.left, this.childRect.top, this.childRect.right, this.childRect.bottom);
      i += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).measure(atMost(paramInt1), atMost(paramInt2));
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.FakeWindowViewGroup
 * JD-Core Version:    0.7.0.1
 */