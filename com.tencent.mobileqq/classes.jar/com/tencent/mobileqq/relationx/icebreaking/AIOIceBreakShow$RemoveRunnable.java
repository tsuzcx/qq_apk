package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class AIOIceBreakShow$RemoveRunnable
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  
  public AIOIceBreakShow$RemoveRunnable(AIOIceBreakShow paramAIOIceBreakShow, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    IceBreakingMng localIceBreakingMng = (IceBreakingMng)AIOIceBreakShow.a(this.this$0).a.getManager(QQManagerFactory.ICE_BREAKING_MNG);
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label75;
      }
      localIceBreakingMng.g(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("removeDelay, type = %s, uin = %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
      return;
      label75:
      if (IceBreakingUtil.d(this.jdField_a_of_type_Int)) {
        localIceBreakingMng.h(this.jdField_a_of_type_JavaLangString);
      } else if (IceBreakingUtil.e(this.jdField_a_of_type_Int)) {
        localIceBreakingMng.i(this.jdField_a_of_type_JavaLangString);
      } else {
        localIceBreakingMng.e(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.RemoveRunnable
 * JD-Core Version:    0.7.0.1
 */