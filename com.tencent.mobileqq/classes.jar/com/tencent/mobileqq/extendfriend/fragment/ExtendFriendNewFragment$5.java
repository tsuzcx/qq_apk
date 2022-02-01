package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;

class ExtendFriendNewFragment$5
  implements Runnable
{
  ExtendFriendNewFragment$5(ExtendFriendNewFragment paramExtendFriendNewFragment) {}
  
  public void run()
  {
    try
    {
      FragmentActivity localFragmentActivity = this.this$0.getActivity();
      QzonePluginProxyActivity.getQZonePluginClassLoader(localFragmentActivity);
      QZoneApiProxy.initServlet(localFragmentActivity, ExtendFriendNewFragment.a(this.this$0));
      QZoneApiProxy.initEnv(localFragmentActivity, ExtendFriendNewFragment.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      QLog.w("ExtendFriendNewFragment", 1, "preLoadData: failed to load qzone plugin ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendNewFragment.5
 * JD-Core Version:    0.7.0.1
 */