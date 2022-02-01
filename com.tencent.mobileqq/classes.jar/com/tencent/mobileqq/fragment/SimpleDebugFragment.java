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
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RadioGroup)this.mContentView.findViewById(2131369865);
    int k = SimpleUIProtocolUtil.a();
    int j = 2131381110;
    int i = j;
    if (k != 0) {
      if (k != 1) {
        i = j;
      } else {
        i = 2131367785;
      }
    }
    paramLayoutInflater.check(i);
    this.vg.setRightButton("");
    paramLayoutInflater.setOnCheckedChangeListener(new SimpleDebugFragment.1(this, paramLayoutInflater));
    this.vg.setOnItemSelectListener(new SimpleDebugFragment.2(this, paramLayoutInflater));
  }
  
  protected int getContentLayoutId()
  {
    return 2131558492;
  }
  
  public boolean onBackEvent()
  {
    super.onBackEvent();
    Process.killProcess(Process.myPid());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment
 * JD-Core Version:    0.7.0.1
 */