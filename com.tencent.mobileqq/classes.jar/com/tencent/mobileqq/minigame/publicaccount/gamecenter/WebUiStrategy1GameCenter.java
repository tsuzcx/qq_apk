package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.app.Activity;
import android.view.View;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;

public class WebUiStrategy1GameCenter
{
  public void initView(Activity paramActivity, View paramView)
  {
    paramView = (URLImageView)paramView.findViewById(2030239749);
    paramView.setVisibility(0);
    paramView.setBackgroundURL(GameWnsUtils.getMiniGamePublicAccountGameStoreButtonUrl());
    paramView.setOnClickListener(new WebUiStrategy1GameCenter.1(this, paramActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy1GameCenter
 * JD-Core Version:    0.7.0.1
 */