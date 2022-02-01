package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IProfileGuideApi
  extends QRouteApi
{
  public abstract void jumpLabelEdit(IComponentCenter paramIComponentCenter);
  
  public abstract void jumpPhotoEdit(Activity paramActivity, String paramString, boolean paramBoolean);
  
  public abstract void jumpProfileEdit(AppInterface paramAppInterface, Activity paramActivity, ProfileCardInfo paramProfileCardInfo);
  
  public abstract void jumpSignEdit(Activity paramActivity, ProfileCardInfo paramProfileCardInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileGuideApi
 * JD-Core Version:    0.7.0.1
 */