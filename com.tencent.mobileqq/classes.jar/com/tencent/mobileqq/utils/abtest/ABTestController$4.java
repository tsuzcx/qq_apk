package com.tencent.mobileqq.utils.abtest;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import java.util.List;

class ABTestController$4
  implements GetExperimentListener
{
  ABTestController$4(ABTestController paramABTestController) {}
  
  public void getExperimentFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("abtest api load exp failed. i:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(". s:");
    localStringBuilder.append(paramString);
    ABTestUtil.a("ABTestController", localStringBuilder.toString());
  }
  
  public void getExperimentSucceed(List<ExpEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        synchronized (ABTestController.e(this.a))
        {
          ABTestController.a(this.a, paramList);
          return;
        }
      }
      ThreadManagerV2.excute(new ABTestController.4.1(this, paramList), 16, null, false);
      return;
    }
    ABTestUtil.a("ABTestController", "load exp failed. list empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController.4
 * JD-Core Version:    0.7.0.1
 */