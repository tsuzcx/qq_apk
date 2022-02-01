package com.tencent.mobileqq.qqexpand.plugin.entrance;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$finish$1
  implements Runnable
{
  ExpandPluginLoadingFragment$finish$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment) {}
  
  public final void run()
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.finish.1
 * JD-Core Version:    0.7.0.1
 */