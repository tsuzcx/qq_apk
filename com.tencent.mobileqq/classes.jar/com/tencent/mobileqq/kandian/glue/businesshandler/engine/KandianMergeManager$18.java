package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class KandianMergeManager$18
  implements Runnable
{
  KandianMergeManager$18(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.this$0), 1).edit();
    localEditor.putString("kandian_red_touch_pnt_article_id", KandianMergeManager.a(this.this$0)).putLong("kandian_push_msg_time", NetConnInfoCenter.getServerTime());
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.18
 * JD-Core Version:    0.7.0.1
 */