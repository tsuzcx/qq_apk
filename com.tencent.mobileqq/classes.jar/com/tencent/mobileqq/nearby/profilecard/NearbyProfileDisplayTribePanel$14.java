package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.FaceScoreCallBack;
import com.tencent.mobileqq.nearby.FaceScoreConfig;

class NearbyProfileDisplayTribePanel$14
  extends FaceScoreCallBack
{
  NearbyProfileDisplayTribePanel$14(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void a(Object paramObject)
  {
    ThreadManager.post(new NearbyProfileDisplayTribePanel.14.1(this, paramObject), 8, null, false);
    this.a.t = ((FaceScoreConfig)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.14
 * JD-Core Version:    0.7.0.1
 */