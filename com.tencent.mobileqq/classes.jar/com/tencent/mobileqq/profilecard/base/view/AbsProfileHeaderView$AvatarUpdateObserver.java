package com.tencent.mobileqq.profilecard.base.view;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
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
    if ((paramBoolean) && (paramInt == 65) && ((paramObject instanceof Set)))
    {
      paramObject = (Set)paramObject;
      AbsProfileHeaderView localAbsProfileHeaderView = (AbsProfileHeaderView)this.mViewRef.get();
      if ((localAbsProfileHeaderView != null) && (paramObject.contains(localAbsProfileHeaderView.mCardInfo.allInOne.uin)))
      {
        localAbsProfileHeaderView.updateAvatarPendantImage(localAbsProfileHeaderView.mCardInfo, false);
        localAbsProfileHeaderView.mApp.removeObserver(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.AvatarUpdateObserver
 * JD-Core Version:    0.7.0.1
 */