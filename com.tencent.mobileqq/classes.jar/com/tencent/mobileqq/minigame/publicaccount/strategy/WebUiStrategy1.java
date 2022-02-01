package com.tencent.mobileqq.minigame.publicaccount.strategy;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountNavBar;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WebUiStrategy1
  implements MiniGameUiStrategy
{
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void setup(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment)
  {
    if (!SimpleUIUtil.e())
    {
      paramMiniGamePublicAccountWebFragment.getBaseActivity().mSystemBarComp = null;
      paramMiniGamePublicAccountWebFragment.getBaseActivity().setImmersiveStatus(0);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setStatusTextColor(true, paramMiniGamePublicAccountWebFragment.getActivity().getWindow());
    }
    paramMiniGamePublicAccountWebFragment.rootView.setBackgroundColor(-1);
    paramMiniGamePublicAccountWebFragment.headerLayoutBg.setBackgroundResource(2030239752);
    paramMiniGamePublicAccountWebFragment.layoutTitleBar.setBackgroundResource(2030108672);
    paramMiniGamePublicAccountWebFragment.titleBar.setTitleBarTransparent();
    paramMiniGamePublicAccountWebFragment.titleBar.getLeftBackIcon().setBackgroundResource(2130851104);
    paramMiniGamePublicAccountWebFragment.titleBar.setRightImage(paramMiniGamePublicAccountWebFragment.getResources().getDrawable(2130850222), null);
    paramMiniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablesWithIntrinsicBounds(null, null, paramMiniGamePublicAccountWebFragment.getResources().getDrawable(2130839650), null);
    paramMiniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablePadding(DisplayUtil.a(paramMiniGamePublicAccountWebFragment.getActivity(), 5.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy1
 * JD-Core Version:    0.7.0.1
 */