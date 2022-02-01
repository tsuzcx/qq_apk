package com.tencent.mobileqq.profile.like;

import com.tencent.qphone.base.util.QLog;

class PraiseManager$1
  implements Runnable
{
  PraiseManager$1(PraiseManager paramPraiseManager, int paramInt, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createPraiseInfo failed, id=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.e("PraiseManager", 1, localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager.1
 * JD-Core Version:    0.7.0.1
 */