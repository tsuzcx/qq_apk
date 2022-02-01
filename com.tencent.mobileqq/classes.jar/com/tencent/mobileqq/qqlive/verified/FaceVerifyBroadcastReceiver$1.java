package com.tencent.mobileqq.qqlive.verified;

import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;

class FaceVerifyBroadcastReceiver$1
  implements Runnable
{
  FaceVerifyBroadcastReceiver$1(FaceVerifyBroadcastReceiver paramFaceVerifyBroadcastReceiver, IQQLiveVerifyService paramIQQLiveVerifyService, int paramInt) {}
  
  public void run()
  {
    this.a.notifyVerifyResult(this.b, false, -1, "fragment destroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.FaceVerifyBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */