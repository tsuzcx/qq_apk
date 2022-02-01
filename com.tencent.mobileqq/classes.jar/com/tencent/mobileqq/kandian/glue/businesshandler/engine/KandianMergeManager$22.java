package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;

class KandianMergeManager$22
  implements Runnable
{
  KandianMergeManager$22(KandianMergeManager paramKandianMergeManager, long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.c(this.this$0), 1).edit();
    localEditor.putLong("subscribe_push_msg_time", this.a);
    localEditor.putString("subscribe_push_msg_uin", this.b);
    localEditor.putInt("subscribe_push_msg_status", this.c);
    localEditor.putString("subscribe_push_msg_xml", this.d);
    localEditor.putInt("subscribe_push_msg_msgtype", this.e);
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.22
 * JD-Core Version:    0.7.0.1
 */