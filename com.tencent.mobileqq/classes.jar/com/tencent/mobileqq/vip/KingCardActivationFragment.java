package com.tencent.mobileqq.vip;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;

public class KingCardActivationFragment
  extends IphoneTitleBarFragment
{
  protected int getContentLayoutId()
  {
    return 2131561924;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setTitle(HardCodeUtil.a(2131706029));
    TMSManager.a().a((ViewGroup)paramView.findViewById(2131365167));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KingCardActivationFragment
 * JD-Core Version:    0.7.0.1
 */