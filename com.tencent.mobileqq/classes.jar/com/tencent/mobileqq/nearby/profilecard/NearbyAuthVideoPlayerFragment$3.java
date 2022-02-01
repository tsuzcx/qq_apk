package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class NearbyAuthVideoPlayerFragment$3
  extends NearbyCardObserver
{
  NearbyAuthVideoPlayerFragment$3(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDeleteNearbyPeopleAuthVideo isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("NearbyAuthVideoPlayerFragment", 2, localStringBuilder.toString());
    }
    ((INearbyCardManager)this.a.getBaseActivity().app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.a.getBaseActivity().app.getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean) {
      this.a.getBaseActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.3
 * JD-Core Version:    0.7.0.1
 */