package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.flutter.channel.model.SCFSwitchs;
import io.flutter.plugin.common.MethodChannel.Result;

class SCFChannel$1$3$1
  implements Runnable
{
  SCFChannel$1$3$1(SCFChannel.1.3 param3, SpecialCareInfo paramSpecialCareInfo, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new SCFSwitchs();
    SpecialCareInfo localSpecialCareInfo = this.a;
    if (localSpecialCareInfo != null)
    {
      int i = localSpecialCareInfo.qzoneSwitch;
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SCFSwitchs)localObject).isQzoneNotify = Boolean.valueOf(bool1);
      boolean bool1 = bool2;
      if (this.a.globalSwitch == 1) {
        bool1 = true;
      }
      ((SCFSwitchs)localObject).isSpecialCare = Boolean.valueOf(bool1);
    }
    ((SCFSwitchs)localObject).isVoiceNewFlag = Boolean.valueOf(this.b);
    localObject = SCFSwitchs.toMap((SCFSwitchs)localObject);
    this.c.b.success(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3.1
 * JD-Core Version:    0.7.0.1
 */