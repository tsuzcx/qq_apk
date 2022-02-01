package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;

class NearbyProfileFragment$2
  extends FaceScoreCallBack
{
  NearbyProfileFragment$2(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(Object paramObject)
  {
    ThreadManager.post(new NearbyProfileFragment.2.1(this, paramObject), 8, null, false);
    NearbyProfileFragment localNearbyProfileFragment = this.a;
    paramObject = (FaceScoreConfig)paramObject;
    localNearbyProfileFragment.a = paramObject;
    localNearbyProfileFragment.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.2
 * JD-Core Version:    0.7.0.1
 */