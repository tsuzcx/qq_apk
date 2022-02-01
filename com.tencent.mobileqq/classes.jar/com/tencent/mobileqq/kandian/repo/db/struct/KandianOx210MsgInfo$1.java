package com.tencent.mobileqq.kandian.repo.db.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

class KandianOx210MsgInfo$1
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(this.a, true, false).edit();
    localEditor.putString("kandian_push_ox210_msg", this.this$0.a());
    localEditor.putInt("kandian_push_ox210_c5_msg_count", this.this$0.a);
    localEditor.putLong("kandian_push_0x210_c5_msg_time", this.this$0.n);
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.1
 * JD-Core Version:    0.7.0.1
 */