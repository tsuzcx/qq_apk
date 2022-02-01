package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.qphone.base.util.QLog;

class IdentificationActivityHelper$3
  implements Runnable
{
  IdentificationActivityHelper$3(IdentificationActivityHelper paramIdentificationActivityHelper, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (IdentificationActivityHelper.a(this.this$0))
    {
      QLog.e("qq_Identification.Helper", 1, "postResult2UI, context invalid");
      return;
    }
    IdentificationActivityHelper.b(this.this$0).showYTInitFinish(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationActivityHelper.3
 * JD-Core Version:    0.7.0.1
 */