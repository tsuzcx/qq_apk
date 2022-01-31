package com.tencent.mobileqq.mini.entry.desktop;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewFlipper;
import bdkf;
import bhxo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;

public class MiniAppDesktopAdapter$MicroAppViewHolder
  extends RecyclerView.ViewHolder
  implements MiniAppDesktopAdapter.OnAnimationListener
{
  ImageView anpgImagView;
  DesktopAppInfo desktopAppInfo;
  ImageView imageView;
  boolean isPlayAnim;
  MiniAppInfo miniAppInfo;
  int moduleType;
  int picCount;
  ImageView recommendBadge;
  TextView redDot;
  TextView textView;
  TextView versionTypeMark;
  ViewFlipper viewFlipper;
  
  public MiniAppDesktopAdapter$MicroAppViewHolder(View paramView)
  {
    super(paramView);
    try
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131370477);
      int i = (int)((bdkf.a() - bdkf.a(10.0F)) / 4.5F);
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localViewGroup.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new LinearLayout.LayoutParams(i, -2);
      }
      localLayoutParams1.width = i;
      localViewGroup.setLayoutParams(localLayoutParams1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniAppDesktopAdapter", 1, localThrowable, new Object[0]);
      }
    }
    this.imageView = ((ImageView)paramView.findViewById(2131370606));
    if ((this.imageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.imageView).setMaskShape(bhxo.c);
    }
    this.textView = ((TextView)paramView.findViewById(2131370607));
    this.versionTypeMark = ((TextView)paramView.findViewById(2131370608));
    this.recommendBadge = ((ImageView)paramView.findViewById(2131370510));
    this.viewFlipper = ((ViewFlipper)paramView.findViewById(2131370549));
    this.anpgImagView = ((ImageView)paramView.findViewById(2131370547));
    this.redDot = ((TextView)paramView.findViewById(2131370515));
  }
  
  private void startSwitchAnimation()
  {
    QLog.d("MiniAppDesktopAdapter", 1, "[mini_app_anim].startSwitchAnimation, picCount = " + this.picCount + ", isPlayAnim: " + this.isPlayAnim);
    this.viewFlipper.setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(700L);
    localTranslateAnimation.setInterpolator(new MiniAppDesktopAdapter.SpringTranslationInterpolator(0.4F));
    this.viewFlipper.setInAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    localTranslateAnimation.setDuration(100L);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    this.viewFlipper.setOutAnimation(localTranslateAnimation);
    this.viewFlipper.setFlipInterval(2200);
    this.viewFlipper.startFlipping();
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfo = paramMiniAppInfo;
  }
  
  public void setModuleType(int paramInt)
  {
    this.moduleType = paramInt;
  }
  
  public void startAnimation()
  {
    if ((this.miniAppInfo.motionPics != null) && (this.miniAppInfo.motionPics.size() > 0))
    {
      this.isPlayAnim = true;
      Drawable localDrawable = MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.appStoreAnimPicUrl, true, 2130840770, 48);
      this.imageView.setImageDrawable(localDrawable);
      this.imageView.invalidate();
      QLog.d("MiniAppDesktopAdapter", 1, "[mini_app_anim].startAnimation, picCount = " + this.picCount + ", pic Url = " + this.miniAppInfo.appStoreAnimPicUrl + ", drawable = " + localDrawable + ", appId: " + this.miniAppInfo.appId);
      startSwitchAnimation();
    }
  }
  
  public void stopAnimation()
  {
    QLog.d("MiniAppDesktopAdapter", 1, "[mini_app_anim].stopAnimation, isPlayAnim: " + this.isPlayAnim);
    if (!this.isPlayAnim) {
      return;
    }
    this.isPlayAnim = false;
    this.viewFlipper.stopFlipping();
    this.imageView.setImageDrawable(MiniAppUtils.getIcon(this.imageView.getContext(), this.miniAppInfo.iconUrl, true));
    this.viewFlipper.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.MicroAppViewHolder
 * JD-Core Version:    0.7.0.1
 */