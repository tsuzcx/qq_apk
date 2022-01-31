package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import bhib;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.log.QMLog;

public class ShareTransitiveFragment
  extends MiniBaseFragment
{
  private static String jdField_a_of_type_JavaLangString = "key_origin_task_id";
  private static String b = "key_share_data";
  private int jdField_a_of_type_Int;
  private ShareProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy = (ShareProxy)ProxyManager.get(ShareProxy.class);
  private ShareData jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareData;
  private boolean jdField_a_of_type_Boolean;
  
  private Intent a()
  {
    if (getActivity() == null) {
      return null;
    }
    return getActivity().getIntent();
  }
  
  private void a()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramInt == -1))
    {
      QMLog.w("ShareTransitiveFragment", "Invalid task id, restart mini app");
      MiniSDK.startMiniApp(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareData.getMiniAppId());
      return;
    }
    try
    {
      ((ActivityManager)getActivity().getSystemService("activity")).moveTaskToFront(paramInt, 1);
      return;
    }
    catch (Exception localException)
    {
      QMLog.w("ShareTransitiveFragment", "Failed to moveTaskToFront", localException);
      QMLog.i("ShareTransitiveFragment", "Restart mini app");
      MiniSDK.startMiniApp(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareData.getMiniAppId());
    }
  }
  
  public static void a(Activity paramActivity, ShareData paramShareData)
  {
    if (paramActivity == null)
    {
      QMLog.e("ShareTransitiveFragment", "Failed to launch. activity is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(jdField_a_of_type_JavaLangString, paramActivity.getTaskId());
    localIntent.putExtra(b, paramShareData);
    localIntent.setFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    bhib.a(paramActivity, localIntent, MiniTranslucentFragmentActivity.class, ShareTransitiveFragment.class);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.i("ShareTransitiveFragment", "onActivityResult() requestCode=" + paramInt1 + " ,resultCode=" + paramInt2);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy.onShareActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      a(this.jdField_a_of_type_Int, true);
    }
    for (;;)
    {
      a();
      return;
      if ((paramInt1 == 10104) && (paramInt2 == 0)) {
        a(this.jdField_a_of_type_Int, true);
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QMLog.i("ShareTransitiveFragment", "onCreate()");
    paramBundle = a();
    if (paramBundle == null) {
      a();
    }
    this.jdField_a_of_type_Int = paramBundle.getIntExtra(jdField_a_of_type_JavaLangString, -1);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareData = ((ShareData)paramBundle.getParcelableExtra(b));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyShareProxy.share(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelShareData);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    QMLog.i("ShareTransitiveFragment", "Finish self when second time onResume");
    a(this.jdField_a_of_type_Int, true);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.ShareTransitiveFragment
 * JD-Core Version:    0.7.0.1
 */