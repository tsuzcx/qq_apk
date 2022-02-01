package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;

class NearbyProfileFragment$2
  extends FaceScoreCallBack
{
  NearbyProfileFragment$2(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    ThreadManager.post(new NearbyProfileFragment.2.1(this, paramFaceScoreConfig), 8, null, false);
    this.a.a = paramFaceScoreConfig;
    this.a.a(paramFaceScoreConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.2
 * JD-Core Version:    0.7.0.1
 */