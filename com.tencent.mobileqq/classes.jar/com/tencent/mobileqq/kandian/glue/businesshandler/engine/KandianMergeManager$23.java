package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;

class KandianMergeManager$23
  implements Runnable
{
  KandianMergeManager$23(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.a);
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.23
 * JD-Core Version:    0.7.0.1
 */