package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;

class BridgeModule$14
  implements Runnable
{
  BridgeModule$14(BridgeModule paramBridgeModule, int paramInt, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null) {
      BridgeModule.access$1400(this.this$0, localQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.14
 * JD-Core Version:    0.7.0.1
 */