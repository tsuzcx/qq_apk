package com.tencent.mobileqq.simpleui;

import QC.UniSetRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

class SimpleUIHandler$2
  implements BusinessObserver
{
  SimpleUIHandler$2(SimpleUIHandler paramSimpleUIHandler, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SimpleUILog.SimpleUIHandler", 2, new Object[] { "type:", Integer.valueOf(paramInt), " success:", Boolean.valueOf(paramBoolean), " data:", paramObject });
      if ((paramObject instanceof UniSetRsp)) {
        QLog.d("SimpleUILog.SimpleUIHandler", 1, new Object[] { "ret: ", Integer.valueOf(((UniSetRsp)paramObject).ret) });
      }
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_Long);
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret != 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler.a(false, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.c, this.b, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler.2
 * JD-Core Version:    0.7.0.1
 */