package com.tencent.mobileqq.qqexpand.flutter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandFlutterContainerFragment$getSplashView$1
  implements View.OnClickListener
{
  ExpandFlutterContainerFragment$getSplashView$1(ExpandFlutterContainerFragment paramExpandFlutterContainerFragment) {}
  
  public final void onClick(View paramView)
  {
    if (!ExpandFlutterContainerFragment.c(this.a))
    {
      paramView = new StringBuilder();
      paramView.append("close splash ");
      paramView.append(ExpandFlutterContainerFragment.c(this.a));
      QLog.d("ExpandFlutterContainerFragment", 1, paramView.toString());
      ReportHelper.a(ExpandFlutterContainerFragment.d(this.a), 1, ExpandFlutterUtils.a.f());
    }
    paramView = this.a.getQBaseActivity();
    if (paramView != null) {
      paramView.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment.getSplashView.1
 * JD-Core Version:    0.7.0.1
 */