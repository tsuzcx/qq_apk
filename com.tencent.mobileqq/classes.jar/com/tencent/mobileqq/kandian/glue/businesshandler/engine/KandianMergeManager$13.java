package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

class KandianMergeManager$13
  implements Runnable
{
  KandianMergeManager$13(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(KandianMergeManager.a(this.this$0), true, false);
    if (localSharedPreferences != null) {
      KandianMergeManager.a(this.this$0, localSharedPreferences.getInt("kandian_follow_data_length", -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.13
 * JD-Core Version:    0.7.0.1
 */