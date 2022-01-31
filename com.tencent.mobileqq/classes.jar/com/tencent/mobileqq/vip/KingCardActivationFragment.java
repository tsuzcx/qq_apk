package com.tencent.mobileqq.vip;

import alpo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import bdwm;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;

public class KingCardActivationFragment
  extends IphoneTitleBarFragment
{
  public int getContentLayoutId()
  {
    return 2131561710;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setTitle(alpo.a(2131706333));
    bdwm.a().a((ViewGroup)paramView.findViewById(2131364768));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KingCardActivationFragment
 * JD-Core Version:    0.7.0.1
 */