package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;

public class NavigationModule
  extends BaseModule
{
  @JSMethod(uiThread=true)
  public void hide(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
    {
      ((ViolaFragment)localFragment).hideTitleBar();
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, "", true);
    }
  }
  
  @JSMethod(uiThread=true)
  public void reloadPage()
  {
    if (ViolaEnvironment.isDebugable())
    {
      Object localObject = getViolaInstance().getFragment();
      if ((localObject != null) && ((localObject instanceof ViolaFragment)))
      {
        FragmentActivity localFragmentActivity = ((Fragment)localObject).getActivity();
        localObject = ((Fragment)localObject).getActivity().getIntent();
        localFragmentActivity.overridePendingTransition(0, 0);
        ((Intent)localObject).addFlags(65536);
        localFragmentActivity.finish();
        localFragmentActivity.overridePendingTransition(0, 0);
        localFragmentActivity.startActivity((Intent)localObject);
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void setTitle(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment))) {
      new Handler(localFragment.getActivity().getMainLooper()).postDelayed(new NavigationModule.1(this, localFragment, paramString), 0L);
    }
  }
  
  @JSMethod(uiThread=true)
  public void show(String paramString)
  {
    Fragment localFragment = getViolaInstance().getFragment();
    if ((localFragment != null) && ((localFragment instanceof ViolaFragment)))
    {
      ((ViolaFragment)localFragment).showTitleBar();
      ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), getModuleName(), "callback", paramString, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.NavigationModule
 * JD-Core Version:    0.7.0.1
 */