package com.tencent.mobileqq.emosm.web.module;

import android.os.Bundle;
import anht;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$16$1
  implements anht
{
  CmShowModule$16$1(CmShowModule.16 param16) {}
  
  public void onAddOrDeleGame(long paramLong, String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramLong == 0L) {}
    for (int i = 0;; i = 1)
    {
      localBundle.putInt("result", i);
      localBundle.putString("message", paramString);
      this.this$1.val$reqbundle.putBundle("response", localBundle);
      this.this$1.val$service.a(this.this$1.val$reqbundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.16.1
 * JD-Core Version:    0.7.0.1
 */