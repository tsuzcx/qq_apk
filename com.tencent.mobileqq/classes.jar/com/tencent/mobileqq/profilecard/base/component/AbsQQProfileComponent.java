package com.tencent.mobileqq.profilecard.base.component;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

public abstract class AbsQQProfileComponent<VIEW>
  extends AbsProfileComponent<VIEW>
{
  @Deprecated
  protected QQAppInterface mQQAppInterface;
  
  public AbsQQProfileComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mQQAppInterface = ((QQAppInterface)this.mApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent
 * JD-Core Version:    0.7.0.1
 */