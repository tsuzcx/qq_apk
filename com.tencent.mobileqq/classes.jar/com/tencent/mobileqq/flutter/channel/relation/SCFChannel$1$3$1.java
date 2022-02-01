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
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
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
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch == 1) {
        bool1 = true;
      }
      ((SCFSwitchs)localObject).isSpecialCare = Boolean.valueOf(bool1);
    }
    ((SCFSwitchs)localObject).isVoiceNewFlag = Boolean.valueOf(this.jdField_a_of_type_Boolean);
    localObject = SCFSwitchs.toMap((SCFSwitchs)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelRelationSCFChannel$1$3.a.success(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3.1
 * JD-Core Version:    0.7.0.1
 */