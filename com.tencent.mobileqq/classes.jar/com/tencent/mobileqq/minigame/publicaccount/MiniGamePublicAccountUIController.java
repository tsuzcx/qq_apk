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
    if (MiniGamePublicAccountHelper.shouldUseWebStrategy2()) {}
    for (int i = 2;; i = 1)
    {
      this.mUiStrategy = i;
      QLog.d("MiniGamePublicAccountUIController", 1, "init, uiStrategy = " + this.mUiStrategy);
      return;
    }
  }
  
  public BaseHeaderAdapter createAdapter(Activity paramActivity)
  {
    switch (this.mUiStrategy)
    {
    default: 
      return new WebUiStrategy2HeaderAdapter(paramActivity);
    }
    return new WebUiStrategy1HeaderAdapter(paramActivity);
  }
  
  public MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig getIndicatorViewConfig()
  {
    MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig localIndicatorViewConfig = new MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig();
    switch (this.mUiStrategy)
    {
    default: 
      if (ThemeUtil.a(null, false, null)) {
        localIndicatorViewConfig.normalColor = Color.parseColor("#303030");
      }
      break;
    }
    for (localIndicatorViewConfig.selectedColor = Color.parseColor("#0983FF");; localIndicatorViewConfig.selectedColor = Color.parseColor("#3EAFFF"))
    {
      localIndicatorViewConfig.normalWidth = ViewUtils.b(14.0F);
      localIndicatorViewConfig.selectedWidth = ViewUtils.b(14.0F);
      return localIndicatorViewConfig;
      localIndicatorViewConfig.normalColor = Color.parseColor("#D0D8F2");
      localIndicatorViewConfig.selectedColor = Color.parseColor("#3857FF");
      localIndicatorViewConfig.normalWidth = ViewUtils.b(14.0F);
      localIndicatorViewConfig.selectedWidth = ViewUtils.b(32.0F);
      return localIndicatorViewConfig;
      localIndicatorViewConfig.normalColor = Color.parseColor("#D0D8F2");
    }
  }
  
  public void initGameCenter(Activity paramActivity, View paramView, MiniGamePublicAccountWebView paramMiniGamePublicAccountWebView)
  {
    switch (this.mUiStrategy)
    {
    default: 
      new WebUiStrategy2GameCenter().initView(paramActivity, paramView, paramMiniGamePublicAccountWebView);
      return;
    }
    new WebUiStrategy1GameCenter().initView(paramActivity, paramView);
  }
  
  public void setupStrategy()
  {
    switch (this.mUiStrategy)
    {
    }
    for (Object localObject = new WebUiStrategy2();; localObject = new WebUiStrategy1())
    {
      ((MiniGameUiStrategy)localObject).setup(this.mFragment);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountUIController
 * JD-Core Version:    0.7.0.1
 */