package com.tencent.mobileqq.profilecard.base.container;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

public abstract class AbsQQProfileContainer
  extends AbsProfileContainer<FrameLayout>
{
  @Deprecated
  protected QQAppInterface mQQAppInterface;
  
  public AbsQQProfileContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mQQAppInterface = ((QQAppInterface)this.mApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer
 * JD-Core Version:    0.7.0.1
 */