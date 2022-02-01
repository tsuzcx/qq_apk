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
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

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
    this.imageView = ((ImageView)paramView.findViewById(2131438721));
    ImageView localImageView = this.imageView;
    if ((localImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    this.textView = ((TextView)paramView.findViewById(2131438724));
    this.versionTypeMark = ((TextView)paramView.findViewById(2131438725));
    this.dividerLine = ((ViewGroup)paramView.findViewById(2131438708));
    this.recommendBadge = ((ImageView)paramView.findViewById(2131438536));
    this.viewFlipper = ((ViewFlipper)paramView.findViewById(2131438583));
    this.redDot = ((TextView)paramView.findViewById(2131438541));
  }
  
  private void startSwitchAnimation()
  {
    long l = this.picCount * 2200;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[mini_app_anim].startSwitchAnimation, picCount = ");
    ((StringBuilder)localObject).append(this.picCount);
    ((StringBuilder)localObject).append(", isPlayAnim: ");
    ((StringBuilder)localObject).append(this.isPlayAnim);
    ((StringBuilder)localObject).append(", duration: ");
    ((StringBuilder)localObject).append(l);
    QLog.d("MiniAppEntryAdapter", 1, ((StringBuilder)localObject).toString());
    this.viewFlipper.setVisibility(0);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(700L);
    ((Animation)localObject).setInterpolator(new MiniAppEntryAdapter.SpringTranslationInterpolator(0.4F));
    ((Animation)localObject).setFillAfter(true);
    this.viewFlipper.setInAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    ((Animation)localObject).setDuration(700L);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    ((Animation)localObject).setFillAfter(false);
    this.viewFlipper.setOutAnimation((Animation)localObject);
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
    Drawable localDrawable = MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.appStoreAnimPicUrl, true, 2130841857, 48);
    this.imageView.setImageDrawable(localDrawable);
    this.imageView.invalidate();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mini_app_anim].startAnimation, picCount = ");
    localStringBuilder.append(this.picCount);
    localStringBuilder.append(", pic Url = ");
    localStringBuilder.append(this.miniAppInfo.appStoreAnimPicUrl);
    localStringBuilder.append(", drawable = ");
    localStringBuilder.append(localDrawable);
    QLog.d("MiniAppEntryAdapter", 1, localStringBuilder.toString());
    startSwitchAnimation();
  }
  
  public void stopAnimation()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[mini_app_anim].stopAnimation, isPlayAnim: ");
    ((StringBuilder)localObject).append(this.isPlayAnim);
    QLog.d("MiniAppEntryAdapter", 1, ((StringBuilder)localObject).toString());
    this.isPlayAnim = false;
    this.viewFlipper.stopFlipping();
    localObject = this.imageView;
    ((ImageView)localObject).setImageDrawable(MiniAppUtils.getIcon(((ImageView)localObject).getContext(), this.miniAppInfo.iconUrl, true));
    this.viewFlipper.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.MicroAppViewHolder
 * JD-Core Version:    0.7.0.1
 */