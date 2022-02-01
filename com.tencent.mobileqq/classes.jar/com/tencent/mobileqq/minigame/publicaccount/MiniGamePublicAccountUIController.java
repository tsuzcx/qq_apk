package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy1HeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy2HeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy1GameCenter;
import com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter;
import com.tencent.mobileqq.minigame.publicaccount.strategy.MiniGameUiStrategy;
import com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy1;
import com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class MiniGamePublicAccountUIController
{
  private static final String TAG = "MiniGamePublicAccountUIController";
  public static final int UI_STRATEGY_WEB_1 = 1;
  public static final int UI_STRATEGY_WEB_2 = 2;
  private MiniGamePublicAccountWebFragment mFragment;
  private int mUiStrategy;
  
  public MiniGamePublicAccountUIController(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment)
  {
    this.mFragment = paramMiniGamePublicAccountWebFragment;
    int i;
    if (MiniGamePublicAccountHelper.shouldUseWebStrategy2()) {
      i = 2;
    } else {
      i = 1;
    }
    this.mUiStrategy = i;
    paramMiniGamePublicAccountWebFragment = new StringBuilder();
    paramMiniGamePublicAccountWebFragment.append("init, uiStrategy = ");
    paramMiniGamePublicAccountWebFragment.append(this.mUiStrategy);
    QLog.d("MiniGamePublicAccountUIController", 1, paramMiniGamePublicAccountWebFragment.toString());
  }
  
  public BaseHeaderAdapter createAdapter(Activity paramActivity)
  {
    if (this.mUiStrategy != 1) {
      return new WebUiStrategy2HeaderAdapter(paramActivity);
    }
    return new WebUiStrategy1HeaderAdapter(paramActivity);
  }
  
  public MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig getIndicatorViewConfig()
  {
    MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig localIndicatorViewConfig = new MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig();
    if (this.mUiStrategy != 1)
    {
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        localIndicatorViewConfig.normalColor = Color.parseColor("#303030");
        localIndicatorViewConfig.selectedColor = Color.parseColor("#0983FF");
      }
      else
      {
        localIndicatorViewConfig.normalColor = Color.parseColor("#D0D8F2");
        localIndicatorViewConfig.selectedColor = Color.parseColor("#3EAFFF");
      }
      localIndicatorViewConfig.normalWidth = ViewUtils.b(14.0F);
      localIndicatorViewConfig.selectedWidth = ViewUtils.b(14.0F);
      return localIndicatorViewConfig;
    }
    localIndicatorViewConfig.normalColor = Color.parseColor("#D0D8F2");
    localIndicatorViewConfig.selectedColor = Color.parseColor("#3857FF");
    localIndicatorViewConfig.normalWidth = ViewUtils.b(14.0F);
    localIndicatorViewConfig.selectedWidth = ViewUtils.b(32.0F);
    return localIndicatorViewConfig;
  }
  
  public void initGameCenter(Activity paramActivity, View paramView, MiniGamePublicAccountWebView paramMiniGamePublicAccountWebView)
  {
    if (this.mUiStrategy != 1)
    {
      new WebUiStrategy2GameCenter().initView(paramActivity, paramView, paramMiniGamePublicAccountWebView);
      return;
    }
    new WebUiStrategy1GameCenter().initView(paramActivity, paramView);
  }
  
  public void setupStrategy()
  {
    Object localObject;
    if (this.mUiStrategy != 1) {
      localObject = new WebUiStrategy2();
    } else {
      localObject = new WebUiStrategy1();
    }
    ((MiniGameUiStrategy)localObject).setup(this.mFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountUIController
 * JD-Core Version:    0.7.0.1
 */