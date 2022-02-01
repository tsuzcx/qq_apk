package com.tencent.mobileqq.haoliyou;

import auxo;
import com.tencent.mobileqq.bigbrother.WeakOuterRefRunnable;
import com.tencent.qphone.base.util.QLog;

public class JefsClass$CancelableRunnable
  implements Runnable
{
  WeakOuterRefRunnable a;
  public boolean a;
  
  JefsClass$CancelableRunnable(WeakOuterRefRunnable paramWeakOuterRefRunnable)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqBigbrotherWeakOuterRefRunnable = paramWeakOuterRefRunnable;
  }
  
  public auxo a()
  {
    return new auxo(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqBigbrotherWeakOuterRefRunnable.a(paramInt);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqBigbrotherWeakOuterRefRunnable.a(paramString);
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      JefsClass.a(JefsClass.getInstance(), this.jdField_a_of_type_ComTencentMobileqqBigbrotherWeakOuterRefRunnable);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TeleScreen|JefsClass", 2, "canceled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.CancelableRunnable
 * JD-Core Version:    0.7.0.1
 */