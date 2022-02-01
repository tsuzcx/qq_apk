package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

final class BridgeModuleHelper$16
  extends LbsManagerServiceOnLocationChangeListener
{
  BridgeModuleHelper$16(String paramString1, BridgeModule paramBridgeModule, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      BridgeModuleHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, paramSosoLbsInfo, this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramSosoLbsInfo = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorCode: ");
    localStringBuilder.append(paramInt);
    BridgeModuleHelper.a(paramSosoLbsInfo, str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper.16
 * JD-Core Version:    0.7.0.1
 */