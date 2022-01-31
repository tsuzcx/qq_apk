package com.tencent.mobileqq.vip;

import ajya;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import bbxl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;

public class KingCardActivationFragment
  extends IphoneTitleBarFragment
{
  public int getContentLayoutId()
  {
    return 2131561519;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setTitle(ajya.a(2131705961));
    bbxl.a().a((ViewGroup)paramView.findViewById(2131364689));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KingCardActivationFragment
 * JD-Core Version:    0.7.0.1
 */