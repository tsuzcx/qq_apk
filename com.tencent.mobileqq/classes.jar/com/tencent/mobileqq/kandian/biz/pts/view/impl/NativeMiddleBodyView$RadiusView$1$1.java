package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class NativeMiddleBodyView$RadiusView$1$1
  implements Runnable
{
  NativeMiddleBodyView$RadiusView$1$1(NativeMiddleBodyView.RadiusView.1 param1, int paramInt1, int paramInt2, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    String str = NativeMiddleBodyView.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLayoutParams width:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" old: ");
    localStringBuilder.append(this.c.width);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.height);
    QLog.i(str, 1, localStringBuilder.toString());
    this.d.a.setLayoutParams(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView.RadiusView.1.1
 * JD-Core Version:    0.7.0.1
 */