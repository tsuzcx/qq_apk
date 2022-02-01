package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PhoneContactServiceImpl$UploadProgressGenerator
  implements Runnable
{
  int a = 0;
  volatile int b = 0;
  volatile int c = 5;
  volatile boolean d;
  volatile boolean e = false;
  
  private PhoneContactServiceImpl$UploadProgressGenerator(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public void a()
  {
    this.d = false;
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
    this.e = true;
    this.b = paramInt1;
    this.c = paramInt2;
    ThreadManager.getUIHandler().removeCallbacks(this);
    ThreadManager.getUIHandler().postDelayed(this, 20L);
  }
  
  public void b()
  {
    this.d = true;
    ThreadManager.getUIHandler().removeCallbacks(this);
  }
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("run progress, isCanceled = ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", bindState = ");
      ((StringBuilder)localObject).append(PhoneContactServiceImpl.access$1400(this.this$0));
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.d) && ((PhoneContactServiceImpl.access$1400(this.this$0) == 8) || (PhoneContactServiceImpl.access$1400(this.this$0) == 4)) && (this.a + 1 < this.c))
    {
      localObject = this.this$0;
      int i = this.a;
      this.a = (i + 1);
      PhoneContactServiceImpl.access$3500((PhoneContactServiceImpl)localObject, i);
      if (this.e)
      {
        PhoneContactServiceImpl.access$2000(this.this$0, 7);
        this.e = false;
      }
      localObject = ThreadManager.getUIHandler();
      long l;
      if (this.a < this.b) {
        l = 20L;
      } else {
        l = 100L;
      }
      ((MqqHandler)localObject).postDelayed(this, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.UploadProgressGenerator
 * JD-Core Version:    0.7.0.1
 */