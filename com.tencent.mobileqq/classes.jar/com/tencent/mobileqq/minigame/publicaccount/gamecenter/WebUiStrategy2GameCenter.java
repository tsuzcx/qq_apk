package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.app.Activity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.CustomWebView.ScrollInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebView;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.UiThreadUtil;
import common.config.service.QzoneConfig;

public class WebUiStrategy2GameCenter
  implements CustomWebView.ScrollInterface
{
  private static final float ANIMATION_X_DELTA = 0.6754386F;
  private static final int IDLE_TIME_TO_SHRINK = 10000;
  private static final float SHRINK_LENGTH = 77.0F;
  private static final float TOTAL_LENGTH = 114.0F;
  private TranslateAnimation mExtendAnimation;
  private URLImageView mGameCenterBtn;
  private boolean mIsExtendStatus = false;
  private TranslateAnimation mShrinkAnimation;
  private Runnable mShrinkRunnable = new WebUiStrategy2GameCenter.4(this);
  
  private void extendBtn()
  {
    if (this.mGameCenterBtn != null)
    {
      if (this.mIsExtendStatus) {
        return;
      }
      this.mIsExtendStatus = true;
      if (this.mExtendAnimation == null)
      {
        this.mExtendAnimation = new TranslateAnimation(1.0F, 1.675439F, 1.0F, 1.0F);
        this.mExtendAnimation.setDuration(300L);
        this.mExtendAnimation.setFillAfter(true);
        this.mExtendAnimation.setAnimationListener(new WebUiStrategy2GameCenter.2(this));
      }
      this.mGameCenterBtn.clearAnimation();
      this.mGameCenterBtn.startAnimation(this.mExtendAnimation);
      UiThreadUtil.a(this.mShrinkRunnable, 10000L);
    }
  }
  
  private void gotoGameCenter(Activity paramActivity)
  {
    String str = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePublicAccountGameStoreUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list%3Fmode%3Dchengzaiye&_vt=3&via=2015_5_11&_sig=1248527088");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramActivity, str, 4011, null);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_minigame", "click", null, null, null);
  }
  
  private void shrinkBtn()
  {
    if (this.mGameCenterBtn != null)
    {
      if (!this.mIsExtendStatus) {
        return;
      }
      this.mIsExtendStatus = false;
      UiThreadUtil.b(this.mShrinkRunnable);
      if (this.mShrinkAnimation == null)
      {
        this.mShrinkAnimation = new TranslateAnimation(1.0F, 0.3245614F, 1.0F, 1.0F);
        this.mShrinkAnimation.setDuration(300L);
        this.mShrinkAnimation.setFillAfter(true);
        this.mShrinkAnimation.setAnimationListener(new WebUiStrategy2GameCenter.3(this));
      }
      this.mGameCenterBtn.clearAnimation();
      this.mGameCenterBtn.startAnimation(this.mShrinkAnimation);
    }
  }
  
  public void initView(Activity paramActivity, View paramView, MiniGamePublicAccountWebView paramMiniGamePublicAccountWebView)
  {
    this.mGameCenterBtn = ((URLImageView)paramView.findViewById(2030305303));
    this.mGameCenterBtn.setVisibility(0);
    this.mGameCenterBtn.setBackgroundURL(GameWnsUtils.getMiniGamePublicAccountGameStoreButtonUrl());
    this.mGameCenterBtn.setOnClickListener(new WebUiStrategy2GameCenter.1(this, paramActivity));
    paramMiniGamePublicAccountWebView.setScrollInterface(this);
  }
  
  public void onSChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    shrinkBtn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter
 * JD-Core Version:    0.7.0.1
 */