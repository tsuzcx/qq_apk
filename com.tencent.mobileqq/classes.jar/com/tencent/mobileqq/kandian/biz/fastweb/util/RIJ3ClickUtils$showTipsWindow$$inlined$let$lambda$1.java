package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onDismiss", "com/tencent/mobileqq/kandian/biz/fastweb/util/RIJ3ClickUtils$showTipsWindow$1$1"}, k=3, mv={1, 1, 16})
final class RIJ3ClickUtils$showTipsWindow$$inlined$let$lambda$1
  implements PopupWindow.OnDismissListener
{
  RIJ3ClickUtils$showTipsWindow$$inlined$let$lambda$1(Runnable paramRunnable, BaseApplication paramBaseApplication, View paramView) {}
  
  public final void onDismiss()
  {
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils.showTipsWindow..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */