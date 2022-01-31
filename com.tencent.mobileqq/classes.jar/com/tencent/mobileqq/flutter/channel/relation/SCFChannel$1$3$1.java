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
    boolean bool2 = true;
    Object localObject = new SCFSwitchs();
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch != 1) {
        break label89;
      }
      bool1 = true;
      ((SCFSwitchs)localObject).isQzoneNotify = Boolean.valueOf(bool1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch != 1) {
        break label94;
      }
    }
    label89:
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SCFSwitchs)localObject).isSpecialCare = Boolean.valueOf(bool1);
      ((SCFSwitchs)localObject).isVoiceNewFlag = Boolean.valueOf(this.jdField_a_of_type_Boolean);
      localObject = SCFSwitchs.toMap((SCFSwitchs)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelRelationSCFChannel$1$3.a.success(localObject);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3.1
 * JD-Core Version:    0.7.0.1
 */