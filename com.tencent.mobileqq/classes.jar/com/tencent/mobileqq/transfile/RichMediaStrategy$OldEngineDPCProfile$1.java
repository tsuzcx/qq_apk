package com.tencent.mobileqq.transfile;

import ante;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;

class RichMediaStrategy$OldEngineDPCProfile$1
  implements ante
{
  RichMediaStrategy$OldEngineDPCProfile$1(RichMediaStrategy.OldEngineDPCProfile paramOldEngineDPCProfile) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name());
      this.this$0.updateFromDPC(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.1
 * JD-Core Version:    0.7.0.1
 */