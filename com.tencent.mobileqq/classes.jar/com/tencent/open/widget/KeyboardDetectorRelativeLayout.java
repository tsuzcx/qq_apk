package com.tencent.open.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class KeyboardDetectorRelativeLayout
  extends RelativeLayout
{
  protected Rect a = null;
  protected IKeyboardChanged b = null;
  
  public KeyboardDetectorRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (this.a == null) {
      this.a = new Rect();
    }
  }
  
  public void a(IKeyboardChanged paramIKeyboardChanged)
  {
    this.b = paramIKeyboardChanged;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    Object localObject = (Activity)super.getContext();
    ((Activity)localObject).getWindow().getDecorView().getWindowVisibleDisplayFrame(this.a);
    int j = this.a.top;
    int k = ((Activity)localObject).getWindowManager().getDefaultDisplay().getHeight();
    localObject = this.b;
    if ((localObject != null) && (i != 0)) {
      if (k - j - i > 100) {
        ((IKeyboardChanged)localObject).a(Math.abs(this.a.height()) - getPaddingBottom() - getPaddingTop());
      } else {
        ((IKeyboardChanged)localObject).b();
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.widget.KeyboardDetectorRelativeLayout
 * JD-Core Version:    0.7.0.1
 */