package com.wifisdk.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.wifisdk.ui.view.a;
import wf7.hk;
import wf7.hv;

public class WifiSDKMainFragImpl
  extends BaseFragmentImpl
{
  private static final String TAG = WifiSDKMainFragImpl.class.getSimpleName();
  private static final int tu;
  private TMSDKWifiManager ts;
  private a tt;
  
  static
  {
    if ("qq".equals("qq")) {}
    for (int i = 10;; i = 2147483647)
    {
      tu = i;
      return;
    }
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("uiapi_k101", 0);
      hv.fD().aB(i);
    }
    this.ts = TMSDKWifiManager.getInstance();
    this.ts.registerListUpdateListener(this.tt.fK());
    this.ts.registerWifiEventListener(this.tt.fK());
    this.ts.registerWifiEventListener(this.tt.fL());
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    this.tt.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((Build.VERSION.SDK_INT >= 23) && (this.to.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) && (this.to != null)) {
      this.to.requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 111);
    }
    hk.az(398505);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.tt = new a(this.to, new WifiSDKMainFragImpl.1(this));
    this.tt.onCreate();
    return this.tt.getContentView();
  }
  
  public void onDestroy()
  {
    this.ts.stopUpdateTask(true);
    hv.fD().onDestroy();
    this.ts.unregisterAll();
    this.tt.onDestroy();
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("uiapi_k101", 0);
      if (i != 0) {
        hv.fD().aB(i);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.ts.setFgUpdateTaskSwitch(false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.ts.setUpdateTaskMaxLoopCount(tu);
    this.ts.startUpdateTask(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.wifisdk.ui.fragments.WifiSDKMainFragImpl
 * JD-Core Version:    0.7.0.1
 */