package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
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
    if ((paramColorScreenConfig == null) || (!ProfileColorScreenComponent.access$000(this.this$0)) || (ProfileColorScreenComponent.access$100(this.this$0) == null))
    {
      QLog.e("ColorScreenManager", 1, "early return, config is " + paramColorScreenConfig);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onComplete, anim file is " + paramColorScreenConfig.jdField_a_of_type_JavaLangString);
    }
    this.mConfig = paramColorScreenConfig;
    try
    {
      paramColorScreenConfig = new FileInputStream(paramColorScreenConfig.jdField_a_of_type_JavaLangString);
      paramObject = new Bundle();
      paramObject.putString("key", "lottie_colorscreen_" + String.valueOf(this.colorScreenId) + "unzip");
      paramObject.putString("path", ProfileColorScreenComponent.access$200(this.this$0).getFilesDir().getAbsolutePath() + "/" + "color_screen" + "/" + this.colorScreenId + "/" + "unzip" + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(ProfileColorScreenComponent.access$300(this.this$0), paramColorScreenConfig, ProfileColorScreenComponent.access$400(this.this$0).getLottieDrawable(), new ProfileColorScreenComponent.ColorScreenLoader.1(this), paramObject, GlobalImageCache.a);
      return;
    }
    catch (FileNotFoundException paramColorScreenConfig)
    {
      QLog.e("ColorScreenManager", 1, "colorScreen", paramColorScreenConfig);
    }
  }
  
  public void run()
  {
    if (!ProfileColorScreenComponent.access$000(this.this$0)) {
      QLog.e("ColorScreenManager", 1, "early return, invalid before setComposition");
    }
    do
    {
      return;
      if (ProfileColorScreenComponent.access$900(this.this$0) == this.colorScreenId)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorScreenManager", 2, "play : " + this.colorScreenId);
        }
        ProfileColorScreenComponent.access$400(this.this$0).cancelAnimation();
        ProfileColorScreenComponent.access$400(this.this$0).setImageAssetDelegate(new ProfileColorScreenComponent.ColorScreenLoader.2(this));
        try
        {
          ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener localColorScreenListener = new ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener(this, this.mComposition.getDuration());
          ProfileColorScreenComponent.access$400(this.this$0).setComposition(this.mComposition);
          ProfileColorScreenComponent.access$400(this.this$0).setProgress(0.0F);
          ProfileColorScreenComponent.access$400(this.this$0).setRepeatCount(this.mConfig.jdField_a_of_type_Int);
          ProfileColorScreenComponent.access$400(this.this$0).addAnimatorListener(localColorScreenListener);
          ProfileColorScreenComponent.access$400(this.this$0).addAnimatorUpdateListener(localColorScreenListener);
          ProfileColorScreenComponent.access$400(this.this$0).setVisibility(0);
          ProfileColorScreenComponent.access$400(this.this$0).playAnimation();
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ColorScreenManager", 1, "", localException);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ColorScreenManager", 2, "won't play old anim: " + this.colorScreenId + " because have new anim: " + ProfileColorScreenComponent.access$900(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader
 * JD-Core Version:    0.7.0.1
 */