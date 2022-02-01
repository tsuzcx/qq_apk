package com.tencent.mobileqq.simpleui;

import QC.UniSetRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class SimpleUIHandler$1
  implements BusinessObserver
{
  SimpleUIHandler$1(SimpleUIHandler paramSimpleUIHandler, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "sendSwitchBubbleUnread onObserver update: ", Boolean.valueOf(paramBoolean), "type: ", Integer.valueOf(paramInt) });
      if ((paramObject instanceof UniSetRsp)) {
        QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "ret: ", Integer.valueOf(((UniSetRsp)paramObject).ret) });
      }
    }
    boolean bool;
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret == 0))
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler;
      if (SimpleUIHandler.a(paramObject).get() == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramInt = SimpleUIHandler.b(this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler).get();
      if (SimpleUIHandler.c(this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler).get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramObject.a(paramBoolean, paramInt, false, bool, this.jdField_a_of_type_Long);
      return;
    }
    paramObject = this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler;
    if (SimpleUIHandler.a(paramObject).get() == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    paramInt = SimpleUIHandler.b(this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler).get();
    if (SimpleUIHandler.c(this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler).get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramObject.a(false, paramBoolean, paramInt, bool, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler.1
 * JD-Core Version:    0.7.0.1
 */