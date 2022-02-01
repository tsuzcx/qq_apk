package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.teamwork.api.ITempGetProfileDetailProcessorProxy;

public class TempGetProfileDetailProcessorProxyImpl
  implements ITempGetProfileDetailProcessorProxy
{
  public void getTencentDocSwitch(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(paramAppInterface, TempGetProfileDetailProcessor.class);
      if (paramAppInterface != null) {
        paramAppInterface.getTencentDocSwitch();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TempGetProfileDetailProcessorProxyImpl
 * JD-Core Version:    0.7.0.1
 */