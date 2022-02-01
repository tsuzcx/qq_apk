package com.tencent.mobileqq.profilecard.vas.component.background;

import android.widget.FrameLayout;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsQQProfileComponent;", "Landroid/widget/FrameLayout;", "TAG", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Ljava/lang/String;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "getTAG", "()Ljava/lang/String;", "isBackgroundShow", "", "()Z", "setBackgroundShow", "(Z)V", "buildVasProfileData", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "info", "getComponentName", "getComponentType", "", "getContainerView", "getDefaultResourceID", "onDataUpdate", "data", "onVasDataUpdate", "setAbFactor", "", "type", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class AbsVasProfileBackgroundComponent
  extends AbsQQProfileComponent<FrameLayout>
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
    if (paramProfileCardInfo != null) {
      localObject1 = paramProfileCardInfo.card;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return new VasProfileData(0L, 0L, null, null, null, null, 63, null);
    }
    Card localCard = paramProfileCardInfo.card;
    long l1 = localCard.lCurrentStyleId;
    long l2 = localCard.lCurrentBgId;
    String str1 = localCard.backgroundUrl;
    Intrinsics.checkExpressionValueIsNotNull(str1, "backgroundUrl");
    long l3 = localCard.backgroundColor;
    int i = localCard.dynamicCardFlag;
    Object localObject1 = localCard.strZipUrl;
    if (localObject1 == null) {
      localObject1 = "";
    }
    Object localObject2 = localCard.strActiveUrl;
    if (localObject2 == null) {
      localObject2 = "";
    }
    Object localObject3 = localCard.strDrawerCardUrl;
    if (localObject3 == null) {
      localObject3 = "";
    }
    String str2 = localCard.strWzryHeroUrl;
    Intrinsics.checkExpressionValueIsNotNull(str2, "strWzryHeroUrl");
    localObject1 = new VasCardData(l1, l2, str1, l3, i, (String)localObject1, (String)localObject2, (String)localObject3, str2, localCard.wzryHonorInfo, localCard.strExtInfo, localCard.strCurrentBgUrl);
    localObject2 = paramProfileCardInfo.card;
    localObject2 = new VasDiyTextData(((Card)localObject2).diyText, ((Card)localObject2).diyTextFontId, ((Card)localObject2).diyTextWidth, ((Card)localObject2).diyTextHeight, ((Card)localObject2).diyTextLocX, ((Card)localObject2).diyTextLocY, ((Card)localObject2).diyTextDegree, ((Card)localObject2).diyTextScale, ((Card)localObject2).diyTextTransparency, ((Card)localObject2).diyDefaultText);
    localObject3 = (VasDiyData)paramProfileCardInfo.getBusinessInfo(VasDiyData.class);
    return new VasProfileData(paramProfileCardInfo.curUseStyleId, paramProfileCardInfo.curUseTemplateVersion, paramProfileCardInfo.currentTemplate, (VasCardData)localObject1, (VasDiyData)localObject3, (VasDiyTextData)localObject2);
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
    return 2130847424;
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
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vasdata = ");
      localStringBuilder.append(localVasProfileData);
      QLog.d(str, 4, localStringBuilder.toString());
    }
    boolean bool = onVasDataUpdate(localVasProfileData);
    return super.onDataUpdate(paramProfileCardInfo) | bool;
  }
  
  public abstract boolean onVasDataUpdate(@NotNull VasProfileData paramVasProfileData);
  
  public final void setAbFactor(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    AbProxy.Companion.setAbFactor("资料卡背景", paramString, AbFactorProfileCardBg.class);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTheme cardType=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AbsVasProfileBackgroundComponent", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public final void setBackgroundShow(boolean paramBoolean)
  {
    this.isBackgroundShow = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */