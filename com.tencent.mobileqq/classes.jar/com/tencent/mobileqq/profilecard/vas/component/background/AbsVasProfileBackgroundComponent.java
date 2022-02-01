package com.tencent.mobileqq.profilecard.vas.component.background;

import android.widget.FrameLayout;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasDiyTextData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy;
import com.tencent.qapmsdk.base.reporter.ab.AbProxy.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.abfactor.AbFactorProfileCardBg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileComponent;", "Landroid/widget/FrameLayout;", "TAG", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Ljava/lang/String;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "getTAG", "()Ljava/lang/String;", "isBackgroundShow", "", "()Z", "setBackgroundShow", "(Z)V", "buildVasProfileData", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "info", "getComponentName", "getComponentType", "", "getContainerView", "getDefaultResourceID", "onDataUpdate", "data", "onVasDataUpdate", "setAbFactor", "", "type", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class AbsVasProfileBackgroundComponent
  extends AbsProfileComponent<FrameLayout>
{
  @NotNull
  private final String TAG;
  private boolean isBackgroundShow;
  
  public AbsVasProfileBackgroundComponent(@NotNull String paramString, @Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
    this.TAG = paramString;
  }
  
  @NotNull
  public final VasProfileData buildVasProfileData(@Nullable ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo != null) {}
    for (Object localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard; localObject1 == null; localObject1 = null) {
      return new VasProfileData(0L, 0L, null, null, null, null, 63, null);
    }
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    long l1 = localCard.lCurrentStyleId;
    long l2 = localCard.lCurrentBgId;
    String str2 = localCard.backgroundUrl;
    Intrinsics.checkExpressionValueIsNotNull(str2, "backgroundUrl");
    long l3 = localCard.backgroundColor;
    int i = localCard.dynamicCardFlag;
    localObject1 = localCard.strZipUrl;
    Object localObject2;
    label108:
    String str1;
    if (localObject1 != null)
    {
      localObject2 = localCard.strActiveUrl;
      if (localObject2 == null) {
        break label274;
      }
      str1 = localCard.strDrawerCardUrl;
      if (str1 == null) {
        break label281;
      }
    }
    for (;;)
    {
      String str3 = localCard.strWzryHeroUrl;
      Intrinsics.checkExpressionValueIsNotNull(str3, "strWzryHeroUrl");
      localObject1 = new VasCardData(l1, l2, str2, l3, i, (String)localObject1, (String)localObject2, str1, str3, localCard.wzryHonorInfo, localCard.strExtInfo, localCard.strCurrentBgUrl);
      localObject2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      localObject2 = new VasDiyTextData(((Card)localObject2).diyText, ((Card)localObject2).diyTextFontId, ((Card)localObject2).diyTextWidth, ((Card)localObject2).diyTextHeight, ((Card)localObject2).diyTextLocX, ((Card)localObject2).diyTextLocY, ((Card)localObject2).diyTextDegree, ((Card)localObject2).diyTextScale, ((Card)localObject2).diyTextTransparency, ((Card)localObject2).diyDefaultText);
      return new VasProfileData(paramProfileCardInfo.jdField_a_of_type_Long, paramProfileCardInfo.b, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, (VasCardData)localObject1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData, (VasDiyTextData)localObject2);
      localObject1 = "";
      break;
      label274:
      localObject2 = "";
      break label108;
      label281:
      str1 = "";
    }
  }
  
  @NotNull
  public final String getComponentName()
  {
    return this.TAG;
  }
  
  public final int getComponentType()
  {
    return 1003;
  }
  
  @NotNull
  public FrameLayout getContainerView()
  {
    Object localObject = super.getContainerView();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return (FrameLayout)localObject;
  }
  
  public final int getDefaultResourceID()
  {
    return 2130846077;
  }
  
  @NotNull
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isBackgroundShow()
  {
    return this.isBackgroundShow;
  }
  
  public final boolean onDataUpdate(@Nullable ProfileCardInfo paramProfileCardInfo)
  {
    VasProfileData localVasProfileData = buildVasProfileData(paramProfileCardInfo);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 4, "vasdata = " + localVasProfileData);
    }
    return onVasDataUpdate(localVasProfileData) | super.onDataUpdate(paramProfileCardInfo);
  }
  
  public abstract boolean onVasDataUpdate(@NotNull VasProfileData paramVasProfileData);
  
  public final void setAbFactor(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label30;
      }
    }
    label30:
    do
    {
      return;
      i = 0;
      break;
      AbProxy.Companion.setAbFactor("资料卡背景", paramString, AbFactorProfileCardBg.class);
    } while (!QLog.isColorLevel());
    QLog.d("AbsVasProfileBackgroundComponent", 2, "updateTheme cardType=" + paramString);
  }
  
  public final void setBackgroundShow(boolean paramBoolean)
  {
    this.isBackgroundShow = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */