package com.tencent.mobileqq.profilecard.base.view;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import java.lang.ref.WeakReference;
import java.util.Set;

class AbsProfileHeaderView$AvatarUpdateObserver
  implements BusinessObserver
{
  private WeakReference<AbsProfileHeaderView> mViewRef;
  
  public AbsProfileHeaderView$AvatarUpdateObserver(AbsProfileHeaderView paramAbsProfileHeaderView)
  {
    this.mViewRef = new WeakReference(paramAbsProfileHeaderView);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 66) && ((paramObject instanceof Set)))
    {
      paramObject = (Set)paramObject;
      AbsProfileHeaderView localAbsProfileHeaderView = (AbsProfileHeaderView)this.mViewRef.get();
      if ((localAbsProfileHeaderView != null) && (paramObject.contains(localAbsProfileHeaderView.mCardInfo.a.a)))
      {
        localAbsProfileHeaderView.updateAvatarPendantImage(localAbsProfileHeaderView.mCardInfo, false);
        localAbsProfileHeaderView.mApp.removeObserver(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.AvatarUpdateObserver
 * JD-Core Version:    0.7.0.1
 */