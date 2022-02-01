package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInJoySkinAnimManager$InitResourceRunnable
  implements Runnable
{
  private WeakReference<ReadInJoySkinAnimManager> a;
  private boolean b = false;
  
  public ReadInJoySkinAnimManager$InitResourceRunnable(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager, boolean paramBoolean)
  {
    this.a = new WeakReference(paramReadInJoySkinAnimManager);
    this.b = paramBoolean;
  }
  
  public void run()
  {
    ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.a.get();
    if (localReadInJoySkinAnimManager != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("InitResourceRunnable folder = ");
        localStringBuilder.append(ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager));
        QLog.d("ReadInJoySkinAnimManager", 1, localStringBuilder.toString());
      }
      ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager.InitResourceRunnable
 * JD-Core Version:    0.7.0.1
 */