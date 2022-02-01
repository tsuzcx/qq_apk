package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInJoySkinAnimManager$InitResourceRunnable
  implements Runnable
{
  private WeakReference<ReadInJoySkinAnimManager> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoySkinAnimManager$InitResourceRunnable(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoySkinAnimManager);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localReadInJoySkinAnimManager != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("InitResourceRunnable folder = ");
        localStringBuilder.append(ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager));
        QLog.d("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
      }
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager.InitResourceRunnable
 * JD-Core Version:    0.7.0.1
 */