package com.tencent.mobileqq.profilecard.vas.component.background;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.vip.diy.QVipBackgroundCreator;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileDiyBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "mQVipBackgroundCreator", "Lcom/tencent/mobileqq/vip/diy/QVipBackgroundCreator;", "onDestroy", "", "onVasDataUpdate", "", "data", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasProfileDiyBackgroundComponent
  extends AbsVasProfileBackgroundComponent
{
  private QVipBackgroundCreator mQVipBackgroundCreator;
  
  public VasProfileDiyBackgroundComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super("VasProfileDiyBackgroundComponent", paramIComponentCenter, paramProfileCardInfo);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QVipBackgroundCreator localQVipBackgroundCreator = this.mQVipBackgroundCreator;
    if (localQVipBackgroundCreator != null) {
      localQVipBackgroundCreator.a();
    }
    this.mQVipBackgroundCreator = ((QVipBackgroundCreator)null);
  }
  
  public boolean onVasDataUpdate(@NotNull VasProfileData paramVasProfileData)
  {
    Intrinsics.checkParameterIsNotNull(paramVasProfileData, "data");
    if (this.mQVipBackgroundCreator != null) {
      return true;
    }
    label149:
    for (;;)
    {
      try
      {
        paramVasProfileData = paramVasProfileData.getDiyData();
        if (paramVasProfileData != null)
        {
          if ((paramVasProfileData.getBgJson() instanceof JSONObject))
          {
            this.mQVipBackgroundCreator = QVipBackgroundCreator.a((Activity)this.mActivity).a((ViewGroup)getContainerView()).a((JSONObject)paramVasProfileData.getBgJson());
            break label149;
          }
        }
        else
        {
          setAbFactor("card-diy");
          return true;
        }
      }
      catch (Exception paramVasProfileData)
      {
        QLog.e(getTAG(), 1, (Throwable)paramVasProfileData, new Object[0]);
        getContainerView().removeAllViews();
        return true;
      }
      if ((paramVasProfileData.getBgJson() instanceof JSONArray)) {
        this.mQVipBackgroundCreator = QVipBackgroundCreator.a((Activity)this.mActivity).a((ViewGroup)getContainerView()).a((JSONArray)paramVasProfileData.getBgJson());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileDiyBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */