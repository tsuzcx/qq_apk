package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import com.qwallet.temp.ISpriteVideoViewTemp.OnFrameEndListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg.OnAnimEndListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class SpecifyRedPacketAnimMsg$1
  implements ISpriteVideoViewTemp.OnFrameEndListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  SpecifyRedPacketAnimMsg$1(SpecifyRedPacketAnimMsg paramSpecifyRedPacketAnimMsg, ISpecifyRedPacketAnimMsg.OnAnimEndListener paramOnAnimEndListener) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyRedPacketAnimMsg)) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyRedPacketAnimMsg) != null) {
        ThreadManager.getUIHandler().removeCallbacks(SpecifyRedPacketAnimMsg.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyRedPacketAnimMsg));
      }
      ISpecifyRedPacketAnimMsg.OnAnimEndListener localOnAnimEndListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyISpecifyRedPacketAnimMsg$OnAnimEndListener;
      if (localOnAnimEndListener != null) {
        localOnAnimEndListener.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyRedPacketAnimMsg.1
 * JD-Core Version:    0.7.0.1
 */