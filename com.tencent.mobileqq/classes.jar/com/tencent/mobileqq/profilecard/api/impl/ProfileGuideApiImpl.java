package com.tencent.mobileqq.profilecard.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class ProfileGuideApiImpl
  implements IProfileGuideApi
{
  public void jumpLabelEdit(IComponentCenter paramIComponentCenter)
  {
    paramIComponentCenter = paramIComponentCenter.getComponent(1010);
    if ((paramIComponentCenter instanceof ProfilePersonalityLabelComponent))
    {
      paramIComponentCenter = paramIComponentCenter.getContainerView();
      if ((paramIComponentCenter instanceof ProfileCardFavorShowView))
      {
        paramIComponentCenter = ((ProfileCardFavorShowView)paramIComponentCenter).getViewInContainer(0);
        if ((paramIComponentCenter instanceof PersonalityLabelBoard)) {
          ((PersonalityLabelBoard)paramIComponentCenter).a(false);
        }
      }
    }
  }
  
  public void jumpPhotoEdit(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    PhotoWallView.jumpToPhotoWall(paramActivity, paramString, paramBoolean);
  }
  
  public void jumpProfileEdit(AppInterface paramAppInterface, Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    ProfileCardUtils.openProfileEdit(paramAppInterface, paramActivity, paramProfileCardInfo);
  }
  
  public void jumpSignEdit(Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    SignTextEditFragment.a(paramActivity, RichStatusUtils.Companion.getRichStatus(paramProfileCardInfo.card), null, null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileGuideApiImpl
 * JD-Core Version:    0.7.0.1
 */