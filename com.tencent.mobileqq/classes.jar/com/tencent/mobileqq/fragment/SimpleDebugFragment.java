package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import asdd;
import asde;
import azib;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class SimpleDebugFragment
  extends IphoneTitleBarFragment
{
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 2131380152;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RadioGroup)this.mContentView.findViewById(2131369267);
    int i = j;
    switch (azib.e())
    {
    }
    for (i = j;; i = 2131367276)
    {
      paramLayoutInflater.check(i);
      this.vg.setRightButton("");
      paramLayoutInflater.setOnCheckedChangeListener(new asdd(this, paramLayoutInflater));
      this.vg.setOnItemSelectListener(new asde(this, paramLayoutInflater));
      return;
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131558455;
  }
  
  public boolean onBackEvent()
  {
    super.onBackEvent();
    Process.killProcess(Process.myPid());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment
 * JD-Core Version:    0.7.0.1
 */