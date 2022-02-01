package com.wifisdk.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragmentImpl
{
  protected Fragment tn;
  protected Activity to;
  
  protected Bundle getArguments()
  {
    if (this.tn != null) {
      return this.tn.getArguments();
    }
    return null;
  }
  
  public Fragment getFragment()
  {
    return this.tn;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle) {}
  
  public void onAttachToFragment(Fragment paramFragment)
  {
    this.tn = paramFragment;
  }
  
  public void onBackPressed() {}
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    this.to = this.tn.getActivity();
  }
  
  public abstract View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle);
  
  public void onDestroy() {}
  
  public void onFinish() {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.fragments.BaseFragmentImpl
 * JD-Core Version:    0.7.0.1
 */