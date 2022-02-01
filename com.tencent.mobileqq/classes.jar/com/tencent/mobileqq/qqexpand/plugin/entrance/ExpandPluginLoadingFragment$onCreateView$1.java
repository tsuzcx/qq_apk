package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$onCreateView$1
  implements View.OnClickListener
{
  ExpandPluginLoadingFragment$onCreateView$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.getActivity();
    if (paramView != null) {
      paramView.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.onCreateView.1
 * JD-Core Version:    0.7.0.1
 */