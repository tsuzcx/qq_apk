package com.tencent.mobileqq.profilecard.vas.component.background;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileWzBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "mCardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "mDefaultBackgroundView", "Landroid/widget/ImageView;", "mWzBg", "Landroid/graphics/Bitmap;", "mWzBgView", "Lcom/tencent/mobileqq/profile/view/ShakeImageView;", "mWzCharacter", "mWzCharacterView", "initWzryDynamicBgAndHero", "", "data", "onCreate", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onVasDataUpdate", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "updateImage", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasProfileWzBackgroundComponent
  extends AbsVasProfileBackgroundComponent
{
  private VasCardData mCardData;
  private ImageView mDefaultBackgroundView;
  private Bitmap mWzBg;
  private ShakeImageView mWzBgView;
  private Bitmap mWzCharacter;
  private ShakeImageView mWzCharacterView;
  
  public VasProfileWzBackgroundComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super("VasProfileWzryBackgroundComponent", paramIComponentCenter, paramProfileCardInfo);
  }
  
  private final boolean initWzryDynamicBgAndHero(VasCardData paramVasCardData)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = getTAG();
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[3];
      localObject2[0] = Long.valueOf(paramVasCardData.getLCurrentBgId());
      localObject2[1] = paramVasCardData.getBackgroundUrl();
      localObject2[2] = paramVasCardData.getStrWzryHeroUrl();
      localObject2 = String.format("initWzryDynamicBgAndHero bgId=%s bgUrl=%s heroUrl=%s", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      QLog.d((String)localObject1, 2, (String)localObject2);
    }
    if ((!TextUtils.isEmpty((CharSequence)paramVasCardData.getBackgroundUrl())) || (!TextUtils.isEmpty((CharSequence)paramVasCardData.getStrWzryHeroUrl()))) {
      try
      {
        paramVasCardData = ProfileCardManager.a((Context)this.mActivity, paramVasCardData.getLCurrentBgId());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVasCardData);
        ((StringBuilder)localObject1).append("wzBgImage.png");
        String str = ((StringBuilder)localObject1).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVasCardData);
        ((StringBuilder)localObject1).append("wzMainImage.png");
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = GlobalImageCache.a.get(str);
        paramVasCardData = (VasCardData)localObject1;
        if (!(localObject1 instanceof Bitmap)) {
          paramVasCardData = null;
        }
        localObject1 = (Bitmap)paramVasCardData;
        if (localObject1 != null)
        {
          paramVasCardData = (VasCardData)localObject1;
          if (!((Bitmap)localObject1).isRecycled()) {}
        }
        else
        {
          paramVasCardData = BitmapManager.a(str);
        }
        if ((paramVasCardData != null) && ((Intrinsics.areEqual(this.mWzBg, paramVasCardData) ^ true)))
        {
          this.mWzBg = paramVasCardData;
          GlobalImageCache.a.put(str, paramVasCardData);
        }
        localObject1 = GlobalImageCache.a.get(localObject2);
        paramVasCardData = (VasCardData)localObject1;
        if (!(localObject1 instanceof Bitmap)) {
          paramVasCardData = null;
        }
        localObject1 = (Bitmap)paramVasCardData;
        if (localObject1 != null)
        {
          paramVasCardData = (VasCardData)localObject1;
          if (!((Bitmap)localObject1).isRecycled()) {}
        }
        else
        {
          paramVasCardData = BitmapManager.a((String)localObject2);
        }
        if ((paramVasCardData != null) && ((Intrinsics.areEqual(this.mWzCharacter, paramVasCardData) ^ true)))
        {
          this.mWzCharacter = paramVasCardData;
          GlobalImageCache.a.put(localObject2, paramVasCardData);
        }
        return true;
      }
      catch (Throwable paramVasCardData)
      {
        QLog.e(getTAG(), 1, "initWzryDynamicBgAndHero fail.", paramVasCardData);
      }
    }
    return false;
  }
  
  private final void updateImage()
  {
    Object localObject = this.mWzBg;
    ShakeImageView localShakeImageView;
    double d;
    int i;
    if (localObject != null)
    {
      localShakeImageView = this.mWzBgView;
      if (localShakeImageView != null)
      {
        d = getContainerView().getWidth();
        Double.isNaN(d);
        i = (int)(d * 1.1D);
        d = getContainerView().getHeight();
        Double.isNaN(d);
        localShakeImageView.setImage((Bitmap)localObject, i, (int)(d * 1.1D), 1.0F);
      }
    }
    localObject = this.mWzCharacter;
    if (localObject != null)
    {
      localShakeImageView = this.mWzCharacterView;
      if (localShakeImageView != null)
      {
        d = getContainerView().getWidth();
        Double.isNaN(d);
        i = (int)(d * 1.1D);
        d = getContainerView().getHeight();
        Double.isNaN(d);
        localShakeImageView.setImage((Bitmap)localObject, i, (int)(d * 1.1D), -1.0F);
      }
    }
    if ((this.mWzBg == null) && (this.mWzCharacter == null))
    {
      localObject = this.mDefaultBackgroundView;
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(getDefaultResourceID());
      }
      setBackgroundShow(false);
      return;
    }
    setAbFactor("card-wzry");
    localObject = this.mDefaultBackgroundView;
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(null);
    }
    setBackgroundShow(true);
  }
  
  public void onCreate(@NotNull QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = (Context)paramQBaseActivity;
    paramBundle = new ImageView(paramQBaseActivity);
    paramBundle.setContentDescription((CharSequence)"qqvip_bg");
    getContainerView().addView((View)paramBundle);
    this.mDefaultBackgroundView = paramBundle;
    paramBundle = new ShakeImageView(paramQBaseActivity);
    paramBundle.setContentDescription((CharSequence)"qqvip_wzry_bg");
    getContainerView().addView((View)paramBundle);
    this.mWzBgView = paramBundle;
    paramQBaseActivity = new ShakeImageView(paramQBaseActivity);
    paramQBaseActivity.setContentDescription((CharSequence)"qqvip_wzry_character");
    getContainerView().addView((View)paramQBaseActivity);
    this.mWzCharacterView = paramQBaseActivity;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getContainerView().removeView((View)this.mDefaultBackgroundView);
    getContainerView().removeView((View)this.mWzBgView);
    getContainerView().removeView((View)this.mWzCharacterView);
    this.mDefaultBackgroundView = ((ImageView)null);
    ShakeImageView localShakeImageView = (ShakeImageView)null;
    this.mWzBgView = localShakeImageView;
    this.mWzCharacterView = localShakeImageView;
  }
  
  public boolean onVasDataUpdate(@NotNull VasProfileData paramVasProfileData)
  {
    Intrinsics.checkParameterIsNotNull(paramVasProfileData, "data");
    if (paramVasProfileData.getCurrentTemplate() == null)
    {
      paramVasProfileData = this.mDefaultBackgroundView;
      if (paramVasProfileData != null) {
        paramVasProfileData.setBackgroundResource(getDefaultResourceID());
      }
      return true;
    }
    if ((paramVasProfileData.getCardData().equals(this.mCardData)) && (isBackgroundShow())) {
      return true;
    }
    this.mCardData = paramVasProfileData.getCardData();
    initWzryDynamicBgAndHero(paramVasProfileData.getCardData());
    getContainerView().post((Runnable)new VasProfileWzBackgroundComponent.onVasDataUpdate.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileWzBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */