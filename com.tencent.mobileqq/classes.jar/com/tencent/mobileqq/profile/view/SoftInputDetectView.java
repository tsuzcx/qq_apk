package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class SoftInputDetectView
  extends RelativeLayout
{
  private Rect a = new Rect();
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = -1;
  private boolean f = true;
  private SoftInputDetectView.OnImStateChangedListener g = null;
  
  public SoftInputDetectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SoftInputDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getScreenHeight()
  {
    return this.c;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    getWindowVisibleDisplayFrame(this.a);
    int i = this.d;
    if (this.f) {
      paramInt2 = this.a.bottom - this.a.top;
    } else {
      paramInt2 = this.a.bottom;
    }
    if (this.c == 0) {
      this.c = paramInt2;
    }
    if (this.e < 0) {
      this.e = this.a.top;
    }
    this.d = paramInt2;
    if ((paramInt2 != 0) && (i != 0) && (paramInt2 != i))
    {
      if (this.e != this.a.top)
      {
        if (this.f) {
          this.c -= this.a.top - this.e;
        }
        this.e = this.a.top;
      }
      boolean bool;
      if (paramInt2 < this.c) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        this.b = (this.c - paramInt2);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Detected layout change. Input Method is showing? ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(" Input Method Height is ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("SoftInputDetectView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.g;
      if (localObject != null) {
        ((SoftInputDetectView.OnImStateChangedListener)localObject).a(bool, this.b);
      }
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
  }
  
  public void setExcludeStatusBar(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setOnImStateChangedListener(SoftInputDetectView.OnImStateChangedListener paramOnImStateChangedListener)
  {
    this.g = paramOnImStateChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.SoftInputDetectView
 * JD-Core Version:    0.7.0.1
 */