package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;

class KandianMergeManager$27
  implements Runnable
{
  KandianMergeManager$27(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.c(this.this$0), 1).edit();
    localEditor.remove("kandian_push_msg_xml").remove("kandian_push_msg_time");
    RIJSPUtils.a(localEditor, true);
    RIJSPUtils.a("kandian_lock_screen_push_info", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.27
 * JD-Core Version:    0.7.0.1
 */