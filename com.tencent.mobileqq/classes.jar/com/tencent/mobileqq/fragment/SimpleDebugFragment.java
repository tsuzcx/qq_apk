package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import avfz;
import avga;
import bdgb;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class SimpleDebugFragment
  extends IphoneTitleBarFragment
{
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 2131381361;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RadioGroup)this.mContentView.findViewById(2131369769);
    int i = j;
    switch (bdgb.e())
    {
    }
    for (i = j;; i = 2131367655)
    {
      paramLayoutInflater.check(i);
      this.vg.setRightButton("");
      paramLayoutInflater.setOnCheckedChangeListener(new avfz(this, paramLayoutInflater));
      this.vg.setOnItemSelectListener(new avga(this, paramLayoutInflater));
      return;
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131558461;
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