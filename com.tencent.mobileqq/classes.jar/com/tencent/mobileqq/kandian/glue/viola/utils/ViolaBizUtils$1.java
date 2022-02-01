package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;

final class ViolaBizUtils$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ViolaBizUtils$1(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeErrorCallJS(this.jdField_a_of_type_JavaLangString, paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, paramReadInJoyUserInfo, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.1
 * JD-Core Version:    0.7.0.1
 */