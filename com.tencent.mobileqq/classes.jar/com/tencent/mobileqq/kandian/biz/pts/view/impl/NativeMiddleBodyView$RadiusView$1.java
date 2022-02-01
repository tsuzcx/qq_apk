package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class NativeMiddleBodyView$RadiusView$1
  implements View.OnLayoutChangeListener
{
  NativeMiddleBodyView$RadiusView$1(NativeMiddleBodyView.RadiusView paramRadiusView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramView.width != paramInt1) || (paramView.height != paramInt2))
    {
      paramView.width = paramInt1;
      paramView.height = paramInt2;
      this.a.post(new NativeMiddleBodyView.RadiusView.1.1(this, paramInt1, paramInt2, paramView));
    }
    String str = NativeMiddleBodyView.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" old: ");
    localStringBuilder.append(paramView.width);
    localStringBuilder.append(":");
    localStringBuilder.append(paramView.height);
    QLog.i(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView.RadiusView.1
 * JD-Core Version:    0.7.0.1
 */