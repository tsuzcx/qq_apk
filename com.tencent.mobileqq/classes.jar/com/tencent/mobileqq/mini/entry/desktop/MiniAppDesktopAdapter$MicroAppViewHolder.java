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
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
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
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131438469);
      int i = (int)((ViewUtils.getScreenWidth() - ViewUtils.dip2px(10.0F)) / 4.5F);
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
      QLog.e("MiniAppDesktopAdapter", 1, localThrowable, new Object[0]);
    }
    this.imageView = ((ImageView)paramView.findViewById(2131438721));
    ImageView localImageView = this.imageView;
    if ((localImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }
    this.textView = ((TextView)paramView.findViewById(2131438724));
    this.versionTypeMark = ((TextView)paramView.findViewById(2131438725));
    this.recommendBadge = ((ImageView)paramView.findViewById(2131438536));
    this.viewFlipper = ((ViewFlipper)paramView.findViewById(2131438583));
    this.anpgImagView = ((ImageView)paramView.findViewById(2131438581));
    this.redDot = ((TextView)paramView.findViewById(2131438541));
  }
  
  private void startSwitchAnimation()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[mini_app_anim].startSwitchAnimation, picCount = ");
    ((StringBuilder)localObject).append(this.picCount);
    ((StringBuilder)localObject).append(", isPlayAnim: ");
    ((StringBuilder)localObject).append(this.isPlayAnim);
    QLog.d("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
    this.viewFlipper.setVisibility(0);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(700L);
    ((Animation)localObject).setInterpolator(new MiniAppDesktopAdapter.SpringTranslationInterpolator(0.4F));
    this.viewFlipper.setInAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setInterpolator(new AccelerateInterpolator());
    this.viewFlipper.setOutAnimation((Animation)localObject);
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
      localStringBuilder.append(", appId: ");
      localStringBuilder.append(this.miniAppInfo.appId);
      QLog.d("MiniAppDesktopAdapter", 1, localStringBuilder.toString());
      startSwitchAnimation();
    }
  }
  
  public void stopAnimation()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[mini_app_anim].stopAnimation, isPlayAnim: ");
    ((StringBuilder)localObject).append(this.isPlayAnim);
    QLog.d("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
    if (!this.isPlayAnim) {
      return;
    }
    this.isPlayAnim = false;
    this.viewFlipper.stopFlipping();
    localObject = this.imageView;
    ((ImageView)localObject).setImageDrawable(MiniAppUtils.getIcon(((ImageView)localObject).getContext(), this.miniAppInfo.iconUrl, true));
    this.viewFlipper.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.MicroAppViewHolder
 * JD-Core Version:    0.7.0.1
 */