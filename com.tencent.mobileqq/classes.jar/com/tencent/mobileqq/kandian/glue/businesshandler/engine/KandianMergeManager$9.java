package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Parcel;
import com.tencent.mobileqq.kandian.glue.report.task.TaskManager;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AladdinListener;

class KandianMergeManager$9
  implements AladdinListener
{
  KandianMergeManager$9(KandianMergeManager paramKandianMergeManager) {}
  
  public void a()
  {
    if (TaskManager.a())
    {
      TaskManager.a().a();
      return;
    }
    TaskManager.a().c();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.9
 * JD-Core Version:    0.7.0.1
 */