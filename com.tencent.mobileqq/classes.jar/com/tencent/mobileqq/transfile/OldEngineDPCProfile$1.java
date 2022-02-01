package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;

class OldEngineDPCProfile$1
  implements DPCObserver
{
  OldEngineDPCProfile$1(OldEngineDPCProfile paramOldEngineDPCProfile) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.HttpTimeoutParam.name());
      this.this$0.updateFromDPC(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldEngineDPCProfile.1
 * JD-Core Version:    0.7.0.1
 */