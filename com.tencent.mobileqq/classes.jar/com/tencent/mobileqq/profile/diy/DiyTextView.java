package com.tencent.mobileqq.profile.diy;

import acfj;
import android.content.Context;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class DiyTextView
  extends HiBoomTextView
{
  acfj a;
  
  public DiyTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2);
    }
  }
  
  public void setOnMeasuredListener(acfj paramacfj)
  {
    this.a = paramacfj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.diy.DiyTextView
 * JD-Core Version:    0.7.0.1
 */