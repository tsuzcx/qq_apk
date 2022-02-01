package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.os.Bundle;
import auvw;
import bagc;
import bagd;
import bage;
import bhzw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProfileColorScreenComponent$ColorScreenLoader
  implements bhzw<auvw>, Runnable
{
  private int jdField_a_of_type_Int;
  private auvw jdField_a_of_type_Auvw;
  private LottieComposition jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition;
  
  ProfileColorScreenComponent$ColorScreenLoader(ProfileColorScreenComponent paramProfileColorScreenComponent, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(auvw paramauvw, Object paramObject)
  {
    if ((paramauvw == null) || (!ProfileColorScreenComponent.a(this.this$0)) || (ProfileColorScreenComponent.a(this.this$0) == null))
    {
      QLog.e("ColorScreenManager", 1, "early return, config is " + paramauvw);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onComplete, anim file is " + paramauvw.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Auvw = paramauvw;
    try
    {
      paramauvw = new FileInputStream(paramauvw.jdField_a_of_type_JavaLangString);
      paramObject = new Bundle();
      paramObject.putString("key", "lottie_colorscreen_" + String.valueOf(this.jdField_a_of_type_Int) + "unzip");
      paramObject.putString("path", ProfileColorScreenComponent.b(this.this$0).getFilesDir().getAbsolutePath() + "/" + "color_screen" + "/" + this.jdField_a_of_type_Int + "/" + "unzip" + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(ProfileColorScreenComponent.c(this.this$0), paramauvw, ProfileColorScreenComponent.a(this.this$0).getLottieDrawable(), new bagc(this), paramObject, BaseApplicationImpl.sImageCache);
      return;
    }
    catch (FileNotFoundException paramauvw)
    {
      QLog.e("ColorScreenManager", 1, "colorScreen", paramauvw);
    }
  }
  
  public void run()
  {
    if (!ProfileColorScreenComponent.a(this.this$0)) {
      QLog.e("ColorScreenManager", 1, "early return, invalid before setComposition");
    }
    do
    {
      return;
      if (ProfileColorScreenComponent.a(this.this$0) == this.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorScreenManager", 2, "play : " + this.jdField_a_of_type_Int);
        }
        ProfileColorScreenComponent.a(this.this$0).cancelAnimation();
        ProfileColorScreenComponent.a(this.this$0).setImageAssetDelegate(new bagd(this));
        try
        {
          bage localbage = new bage(this, this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition.getDuration());
          ProfileColorScreenComponent.a(this.this$0).setComposition(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieComposition);
          ProfileColorScreenComponent.a(this.this$0).setProgress(0.0F);
          ProfileColorScreenComponent.a(this.this$0).setRepeatCount(this.jdField_a_of_type_Auvw.jdField_a_of_type_Int);
          ProfileColorScreenComponent.a(this.this$0).addAnimatorListener(localbage);
          ProfileColorScreenComponent.a(this.this$0).addAnimatorUpdateListener(localbage);
          ProfileColorScreenComponent.a(this.this$0).setVisibility(0);
          ProfileColorScreenComponent.a(this.this$0).playAnimation();
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ColorScreenManager", 1, "", localException);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ColorScreenManager", 2, "won't play old anim: " + this.jdField_a_of_type_Int + " because have new anim: " + ProfileColorScreenComponent.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader
 * JD-Core Version:    0.7.0.1
 */