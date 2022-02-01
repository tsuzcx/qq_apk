package com.tencent.mobileqq.vip;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import anvx;
import bhzh;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;

public class KingCardActivationFragment
  extends IphoneTitleBarFragment
{
  public int getContentLayoutId()
  {
    return 2131561952;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setTitle(anvx.a(2131705434));
    bhzh.a().a((ViewGroup)paramView.findViewById(2131365155));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KingCardActivationFragment
 * JD-Core Version:    0.7.0.1
 */