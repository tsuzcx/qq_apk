package com.tencent.mobileqq.wifi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.wifisdk.ui.WifiSDKUIApi;
import com.wifisdk.ui.api.BaseFragImplManager;
import com.wifisdk.ui.fragments.BaseFragmentImpl;

public abstract class QWifiBaseFragment
  extends PublicBaseFragment
{
  protected BaseFragmentImpl a = WifiSDKUIApi.getFragImplManager().newFragImpl(a());
  
  public abstract int a();
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a.onActivityCreated(paramBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.a.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    this.a.onFinish();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.a.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.QWifiBaseFragment
 * JD-Core Version:    0.7.0.1
 */