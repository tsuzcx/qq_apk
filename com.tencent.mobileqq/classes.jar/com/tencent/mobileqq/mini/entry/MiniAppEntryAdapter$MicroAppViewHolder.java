package com.tencent.mobileqq.mini.entry;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import blfw;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

class MiniAppEntryAdapter$MicroAppViewHolder
  extends RecyclerView.ViewHolder
  implements MiniAppEntryAdapter.OnAnimationListener
{
  ViewGroup dividerLine;
  ImageView imageView;
  boolean isPlayAnim;
  MiniAppInfo miniAppInfo;
  int picCount;
  ImageView recommendBadge;
  TextView redDot;
  TextView textView;
  TextView versionTypeMark;
  ViewFlipper viewFlipper;
  
  public MiniAppEntryAdapter$MicroAppViewHolder(View paramView)
  {
    super(paramView);
    this.imageView = ((ImageView)paramView.findViewById(2131371441));
    if ((this.imageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.imageView).setMaskShape(blfw.c);
    }
    this.textView = ((TextView)paramView.findViewById(2131371442));
    this.versionTypeMark = ((TextView)paramView.findViewById(2131371443));
    this.dividerLine = ((ViewGroup)paramView.findViewById(2131371436));
    this.recommendBadge = ((ImageView)paramView.findViewById(2131371294));
    this.viewFlipper = ((ViewFlipper)paramView.findViewById(2131371341));
    this.redDot = ((TextView)paramView.findViewById(2131371299));
  }
  
  private void startSwitchAnimation()
  {
    long l = this.picCount * 2200;
    QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].startSwitchAnimation, picCount = " + this.picCount + ", isPlayAnim: " + this.isPlayAnim + ", duration: " + l);
    this.viewFlipper.setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setInterpolator(new MiniAppEntryAdapter.SpringTranslationInterpolator(0.4F));
    localTranslateAnimation.setFillAfter(true);
    this.viewFlipper.setInAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    localTranslateAnimation.setFillAfter(false);
    this.viewFlipper.setOutAnimation(localTranslateAnimation);
    this.viewFlipper.setFlipInterval(2200);
    this.viewFlipper.setAnimateFirstView(true);
    this.viewFlipper.startFlipping();
    AppBrandTask.runTaskOnUiThreadDelay(new MiniAppEntryAdapter.MicroAppViewHolder.1(this), l);
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfo = paramMiniAppInfo;
  }
  
  public void startAnimation()
  {
    this.isPlayAnim = true;
    Drawable localDrawable = MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.appStoreAnimPicUrl, true, 2130841057, 48);
    this.imageView.setImageDrawable(localDrawable);
    this.imageView.invalidate();
    QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].startAnimation, picCount = " + this.picCount + ", pic Url = " + this.miniAppInfo.appStoreAnimPicUrl + ", drawable = " + localDrawable);
    startSwitchAnimation();
  }
  
  public void stopAnimation()
  {
    QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].stopAnimation, isPlayAnim: " + this.isPlayAnim);
    this.isPlayAnim = false;
    this.viewFlipper.stopFlipping();
    this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.iconUrl, true));
    this.viewFlipper.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.MicroAppViewHolder
 * JD-Core Version:    0.7.0.1
 */