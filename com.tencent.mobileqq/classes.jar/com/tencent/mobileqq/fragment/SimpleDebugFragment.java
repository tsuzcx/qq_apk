package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import auyf;
import auyg;
import bdfk;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class SimpleDebugFragment
  extends IphoneTitleBarFragment
{
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 2131381438;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RadioGroup)this.mContentView.findViewById(2131369927);
    int i = j;
    switch (bdfk.e())
    {
    }
    for (i = j;; i = 2131367823)
    {
      paramLayoutInflater.check(i);
      this.vg.setRightButton("");
      paramLayoutInflater.setOnCheckedChangeListener(new auyf(this, paramLayoutInflater));
      this.vg.setOnItemSelectListener(new auyg(this, paramLayoutInflater));
      return;
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131558462;
  }
  
  public boolean onBackEvent()
  {
    super.onBackEvent();
    Process.killProcess(Process.myPid());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment
 * JD-Core Version:    0.7.0.1
 */