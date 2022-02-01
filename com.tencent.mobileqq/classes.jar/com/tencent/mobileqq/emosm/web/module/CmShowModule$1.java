package com.tencent.mobileqq.emosm.web.module;

import amtp;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$1
  implements amtp
{
  CmShowModule$1(CmShowModule paramCmShowModule, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void onStartError(int paramInt)
  {
    this.val$responseBundle.putInt("result", paramInt);
    this.val$reqbundle.putBundle("response", this.val$responseBundle);
    this.val$service.a(this.val$reqbundle);
  }
  
  public void onStartSucc()
  {
    this.val$responseBundle.putInt("result", 0);
    this.val$reqbundle.putBundle("response", this.val$responseBundle);
    this.val$service.a(this.val$reqbundle);
  }
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.1
 * JD-Core Version:    0.7.0.1
 */