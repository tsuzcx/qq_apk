package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class SimpleDebugFragment
  extends IphoneTitleBarFragment
{
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 2131381899;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RadioGroup)this.mContentView.findViewById(2131370196);
    int i = j;
    switch (SimpleUIProtocolUtil.a())
    {
    }
    for (i = j;; i = 2131368031)
    {
      paramLayoutInflater.check(i);
      this.vg.setRightButton("");
      paramLayoutInflater.setOnCheckedChangeListener(new SimpleDebugFragment.1(this, paramLayoutInflater));
      this.vg.setOnItemSelectListener(new SimpleDebugFragment.2(this, paramLayoutInflater));
      return;
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131558463;
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