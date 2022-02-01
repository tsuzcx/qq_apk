package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class ProfileColorScreenComponent$ColorScreenLoader
  implements VasManager.CompleteListener<ColorScreenConfig>, Runnable
{
  private int colorScreenId;
  private LottieComposition mComposition;
  private ColorScreenConfig mConfig;
  
  ProfileColorScreenComponent$ColorScreenLoader(ProfileColorScreenComponent paramProfileColorScreenComponent, int paramInt)
  {
    this.colorScreenId = paramInt;
  }
  
  public void onComplete(ColorScreenConfig paramColorScreenConfig, Object paramObject)
  {
    if ((paramColorScreenConfig != null) && (ProfileColorScreenComponent.access$000(this.this$0)) && (ProfileColorScreenComponent.access$100(this.this$0) != null))
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onComplete, anim file is ");
        paramObject.append(paramColorScreenConfig.a);
        QLog.d("ProfileColorScreenComponent", 2, paramObject.toString());
      }
      this.mConfig = paramColorScreenConfig;
      try
      {
        paramColorScreenConfig = new FileInputStream(paramColorScreenConfig.a);
        paramObject = new Bundle();
        StringBuilder localStringBuilder = AIOUtils.a();
        localStringBuilder.append("lottie_colorscreen_");
        localStringBuilder.append(String.valueOf(this.colorScreenId));
        localStringBuilder.append("unzip");
        paramObject.putString("key", localStringBuilder.toString());
        localStringBuilder = AIOUtils.a();
        localStringBuilder.append(ProfileColorScreenComponent.access$200(this.this$0).getFilesDir().getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("color_screen");
        localStringBuilder.append("/");
        localStringBuilder.append(this.colorScreenId);
        localStringBuilder.append("/");
        localStringBuilder.append("unzip");
        localStringBuilder.append("/images/");
        paramObject.putString("path", localStringBuilder.toString());
        LottieComposition.Factory.fromInputStreamWithCacheBitmap(ProfileColorScreenComponent.access$300(this.this$0), paramColorScreenConfig, ProfileColorScreenComponent.access$400(this.this$0).getLottieDrawable(), new ProfileColorScreenComponent.ColorScreenLoader.1(this), paramObject, GlobalImageCache.a);
        return;
      }
      catch (FileNotFoundException paramColorScreenConfig)
      {
        QLog.e("ProfileColorScreenComponent", 1, "colorScreen", paramColorScreenConfig);
        return;
      }
    }
    paramObject = new StringBuilder();
    paramObject.append("early return, config is ");
    paramObject.append(paramColorScreenConfig);
    QLog.e("ProfileColorScreenComponent", 1, paramObject.toString());
  }
  
  public void run()
  {
    if (!ProfileColorScreenComponent.access$000(this.this$0))
    {
      QLog.e("ProfileColorScreenComponent", 1, "early return, invalid before setComposition");
      return;
    }
    if (ProfileColorScreenComponent.access$900(this.this$0) == this.colorScreenId)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("play : ");
        ((StringBuilder)localObject).append(this.colorScreenId);
        QLog.d("ProfileColorScreenComponent", 2, ((StringBuilder)localObject).toString());
      }
      ProfileColorScreenComponent.access$400(this.this$0).cancelAnimation();
      ProfileColorScreenComponent.access$400(this.this$0).setImageAssetDelegate(new ProfileColorScreenComponent.ColorScreenLoader.2(this));
      try
      {
        localObject = new ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener(this, this.mComposition.getDuration());
        ProfileColorScreenComponent.access$400(this.this$0).setComposition(this.mComposition);
        ProfileColorScreenComponent.access$400(this.this$0).setProgress(0.0F);
        ProfileColorScreenComponent.access$400(this.this$0).setRepeatCount(this.mConfig.c);
        ProfileColorScreenComponent.access$400(this.this$0).addAnimatorListener((Animator.AnimatorListener)localObject);
        ProfileColorScreenComponent.access$400(this.this$0).addAnimatorUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject);
        ProfileColorScreenComponent.access$400(this.this$0).setVisibility(0);
        ProfileColorScreenComponent.access$400(this.this$0).playAnimation();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ProfileColorScreenComponent", 1, "", localException);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("won't play old anim: ");
      localStringBuilder.append(this.colorScreenId);
      localStringBuilder.append(" because have new anim: ");
      localStringBuilder.append(ProfileColorScreenComponent.access$900(this.this$0));
      QLog.d("ProfileColorScreenComponent", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader
 * JD-Core Version:    0.7.0.1
 */