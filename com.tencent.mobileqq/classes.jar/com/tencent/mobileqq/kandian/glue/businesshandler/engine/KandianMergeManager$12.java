package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

class KandianMergeManager$12
  implements Runnable
{
  KandianMergeManager$12(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = RIJSPUtils.a(KandianMergeManager.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("kandian_follow_data_length", this.a);
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.12
 * JD-Core Version:    0.7.0.1
 */