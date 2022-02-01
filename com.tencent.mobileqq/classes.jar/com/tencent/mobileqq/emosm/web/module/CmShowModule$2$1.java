package com.tencent.mobileqq.emosm.web.module;

import amtr;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$2$1
  implements amtr
{
  CmShowModule$2$1(CmShowModule.2 param2) {}
  
  public void onUploadError(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt);
    this.this$1.val$reqbundle.putBundle("response", localBundle);
    this.this$1.val$service.a(this.this$1.val$reqbundle);
  }
  
  public void onUploadSucc()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    this.this$1.val$reqbundle.putBundle("response", localBundle);
    this.this$1.val$service.a(this.this$1.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.2.1
 * JD-Core Version:    0.7.0.1
 */