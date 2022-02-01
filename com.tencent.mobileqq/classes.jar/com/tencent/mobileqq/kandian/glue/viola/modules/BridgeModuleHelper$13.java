package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.biz.common.offline.AsyncBack;

final class BridgeModuleHelper$13
  implements AsyncBack
{
  BridgeModuleHelper$13(BridgeModule paramBridgeModule, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.13
 * JD-Core Version:    0.7.0.1
 */