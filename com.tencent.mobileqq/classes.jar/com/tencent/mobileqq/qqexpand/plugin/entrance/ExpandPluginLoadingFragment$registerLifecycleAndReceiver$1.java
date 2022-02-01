package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.os.Build.VERSION;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qqexpand.utils.OnApplicationBackgroundListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment$registerLifecycleAndReceiver$1", "Lcom/tencent/mobileqq/qqexpand/utils/OnApplicationBackgroundListener;", "onBackground", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLoadingFragment$registerLifecycleAndReceiver$1
  implements OnApplicationBackgroundListener
{
  public void a()
  {
    QLog.d("ExpandPluginLoadingFragment", 2, "onBackground");
    this.a.c(4);
    if (Build.VERSION.SDK_INT > 28)
    {
      QLog.e("ExpandPluginLoadingFragment", 1, "sdk api above 28, dismiss");
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if (localFragmentActivity != null) {
        localFragmentActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.registerLifecycleAndReceiver.1
 * JD-Core Version:    0.7.0.1
 */