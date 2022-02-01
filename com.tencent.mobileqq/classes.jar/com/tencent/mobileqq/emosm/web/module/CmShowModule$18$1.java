package com.tencent.mobileqq.emosm.web.module;

import ammy;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$18$1
  implements ammy
{
  CmShowModule$18$1(CmShowModule.18 param18) {}
  
  public void onFailed()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 1);
    this.this$1.val$reqbundle.putBundle("response", localBundle);
    this.this$1.val$service.a(this.this$1.val$reqbundle);
  }
  
  public void onSuccess(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    localBundle.putString("faceUrl", paramString);
    this.this$1.val$reqbundle.putBundle("response", localBundle);
    this.this$1.val$service.a(this.this$1.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.18.1
 * JD-Core Version:    0.7.0.1
 */