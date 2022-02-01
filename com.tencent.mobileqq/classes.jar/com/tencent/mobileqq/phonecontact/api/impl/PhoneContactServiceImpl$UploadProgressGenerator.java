package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PhoneContactServiceImpl$UploadProgressGenerator
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  volatile boolean jdField_a_of_type_Boolean;
  volatile int jdField_b_of_type_Int = 0;
  volatile boolean jdField_b_of_type_Boolean = false;
  volatile int c = 5;
  
  private PhoneContactServiceImpl$UploadProgressGenerator(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().postDelayed(this, 100L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set progress, actual = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", expected = ");
      localStringBuilder.append(paramInt2);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    ThreadManager.getUIHandler().removeCallbacks(this);
    ThreadManager.getUIHandler().postDelayed(this, 20L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.getUIHandler().removeCallbacks(this);
  }
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("run progress, isCanceled = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", bindState = ");
      ((StringBuilder)localObject).append(PhoneContactServiceImpl.access$1400(this.this$0));
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.jdField_a_of_type_Boolean) && ((PhoneContactServiceImpl.access$1400(this.this$0) == 8) || (PhoneContactServiceImpl.access$1400(this.this$0) == 4)) && (this.jdField_a_of_type_Int + 1 < this.c))
    {
      localObject = this.this$0;
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      PhoneContactServiceImpl.access$3500((PhoneContactServiceImpl)localObject, i);
      if (this.jdField_b_of_type_Boolean)
      {
        PhoneContactServiceImpl.access$2000(this.this$0, 7);
        this.jdField_b_of_type_Boolean = false;
      }
      localObject = ThreadManager.getUIHandler();
      long l;
      if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
        l = 20L;
      } else {
        l = 100L;
      }
      ((MqqHandler)localObject).postDelayed(this, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.UploadProgressGenerator
 * JD-Core Version:    0.7.0.1
 */