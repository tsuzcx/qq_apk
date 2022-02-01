package com.tencent.mobileqq.emosm.web.module;

import android.os.Bundle;
import anfg;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$4
  implements anfg
{
  CmShowModule$4(CmShowModule paramCmShowModule, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    if (paramBoolean)
    {
      paramString.putInt("apollo_result", 0);
      paramString.putIntArray("apollo_dressIds", paramArrayOfInt);
      this.val$reqbundle.putBundle("response", paramString);
      this.val$service.a(this.val$reqbundle);
      return;
    }
    paramString.putInt("apollo_result", 1);
    this.val$reqbundle.putBundle("response", paramString);
    this.val$service.a(this.val$reqbundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.4
 * JD-Core Version:    0.7.0.1
 */