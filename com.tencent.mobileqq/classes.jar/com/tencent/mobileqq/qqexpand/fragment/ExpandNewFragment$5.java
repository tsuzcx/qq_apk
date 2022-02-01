package com.tencent.mobileqq.qqexpand.fragment;

import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;

class ExpandNewFragment$5
  implements Runnable
{
  ExpandNewFragment$5(ExpandNewFragment paramExpandNewFragment) {}
  
  public void run()
  {
    try
    {
      FragmentActivity localFragmentActivity = this.this$0.getActivity();
      QzonePluginProxyActivity.getQZonePluginClassLoader(localFragmentActivity);
      QZoneApiProxy.initServlet(localFragmentActivity, ExpandNewFragment.c(this.this$0));
      QZoneApiProxy.initEnv(localFragmentActivity, ExpandNewFragment.c(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ExtendFriendNewFragment", 1, "preLoadData: failed to load qzone plugin ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment.5
 * JD-Core Version:    0.7.0.1
 */