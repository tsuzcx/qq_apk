package com.tencent.mobileqq.ecshop.view.controller;

import com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView;
import com.tencent.mobileqq.ecshop.view.hippy.QQShopHeaderView.OnPageChangeListener;
import com.tencent.mobileqq.ecshop.widget.JumpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onPageSelected"}, k=3, mv={1, 1, 16})
final class AdHeaderController$1
  implements QQShopHeaderView.OnPageChangeListener
{
  AdHeaderController$1(AdHeaderController paramAdHeaderController) {}
  
  public final void a(int paramInt)
  {
    if (paramInt >= AdHeaderController.b(this.a).size() - 1)
    {
      JumpUtil.b(AdHeaderController.c(this.a).getContext());
      AdHeaderController.c(this.a).postDelayed((Runnable)new AdHeaderController.1.1(this), 200L);
    }
    else if (paramInt != AdHeaderController.d(this.a))
    {
      AdHeaderController.b(this.a, paramInt);
      AdHeaderController.a(this.a, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected position = ");
    localStringBuilder.append(paramInt);
    QLog.d("AdHeaderController", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdHeaderController.1
 * JD-Core Version:    0.7.0.1
 */