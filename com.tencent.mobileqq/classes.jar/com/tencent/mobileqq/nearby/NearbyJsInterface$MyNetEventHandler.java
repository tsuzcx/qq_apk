package com.tencent.mobileqq.nearby;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

class NearbyJsInterface$MyNetEventHandler
  implements INetEventHandler
{
  private int jdField_a_of_type_Int = -1;
  
  NearbyJsInterface$MyNetEventHandler(NearbyJsInterface paramNearbyJsInterface) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    NearbyJsInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface, this.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.MyNetEventHandler
 * JD-Core Version:    0.7.0.1
 */