package com.tencent.mobileqq.minigame.publicaccount.strategy;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHeadLayout;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountNavBar;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebView;
import com.tencent.mobileqq.minigame.publicaccount.view.MiniGamePubViewpager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WebUiStrategy2
  implements MiniGameUiStrategy
{
  private static final boolean ENABLE_DARK_THEME = false;
  
  private Resources getResources(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment)
  {
    return paramMiniGamePublicAccountWebFragment.getResources();
  }
  
  private void setupDarkTheme(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment)
  {
    setupStatusBar(paramMiniGamePublicAccountWebFragment, true);
    paramMiniGamePublicAccountWebFragment.rootView.setBackgroundColor(-16777216);
    paramMiniGamePublicAccountWebFragment.titleBar.changeBg(false);
    paramMiniGamePublicAccountWebFragment.navTitle.setTextColor(-1);
    paramMiniGamePublicAccountWebFragment.titleBar.setRightImage(getResources(paramMiniGamePublicAccountWebFragment).getDrawable(2130850548), null);
    paramMiniGamePublicAccountWebFragment.moreMsgText.setTextColor(-1);
    paramMiniGamePublicAccountWebFragment.moreMsgBtn.setTextColor(Color.parseColor("#7C7B82"));
    paramMiniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources(paramMiniGamePublicAccountWebFragment).getDrawable(2063728642), null);
    paramMiniGamePublicAccountWebFragment.headLayout.setBackgroundColor(-16777216);
    paramMiniGamePublicAccountWebFragment.webView.setBackgroundColor(-16777216);
  }
  
  private void setupLightTheme(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment)
  {
    setupStatusBar(paramMiniGamePublicAccountWebFragment, false);
    paramMiniGamePublicAccountWebFragment.rootView.setBackgroundColor(-1);
    paramMiniGamePublicAccountWebFragment.titleBar.changeBg(true);
    paramMiniGamePublicAccountWebFragment.navTitle.setTextColor(-16777216);
    paramMiniGamePublicAccountWebFragment.titleBar.setRightImage(getResources(paramMiniGamePublicAccountWebFragment).getDrawable(2130848681), null);
    paramMiniGamePublicAccountWebFragment.moreMsgText.setTextColor(-16777216);
    paramMiniGamePublicAccountWebFragment.moreMsgBtn.setTextColor(Color.parseColor("#878B99"));
    paramMiniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources(paramMiniGamePublicAccountWebFragment).getDrawable(2063728641), null);
    paramMiniGamePublicAccountWebFragment.headLayout.setBackgroundColor(-1);
    paramMiniGamePublicAccountWebFragment.webView.setBackgroundColor(-1);
  }
  
  private void setupStatusBar(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = -16777216;
      if (!SimpleUIUtil.a())
      {
        paramMiniGamePublicAccountWebFragment.getActivity().mSystemBarComp = null;
        paramMiniGamePublicAccountWebFragment.getActivity().setImmersiveStatus(i);
      }
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if (paramBoolean) {
          break label60;
        }
      }
    }
    label60:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ImmersiveUtils.setStatusTextColor(paramBoolean, paramMiniGamePublicAccountWebFragment.getActivity().getWindow());
      return;
      i = -1;
      break;
    }
  }
  
  public void setup(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment)
  {
    WebUiStrategy2.Strategy2Config.init(paramMiniGamePublicAccountWebFragment.getActivity());
    if (ThemeUtil.a(null, false, null)) {}
    setupLightTheme(paramMiniGamePublicAccountWebFragment);
    paramMiniGamePublicAccountWebFragment.viewPager.setClipToPadding(false);
    paramMiniGamePublicAccountWebFragment.viewPager.setPadding(0, 0, DisplayUtil.a(paramMiniGamePublicAccountWebFragment.getActivity(), 30.0F), 0);
    paramMiniGamePublicAccountWebFragment.viewPager.getLayoutParams().height = WebUiStrategy2.Strategy2Config.viewPagerItemHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy2
 * JD-Core Version:    0.7.0.1
 */