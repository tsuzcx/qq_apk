package com.tencent.mobileqq.kandian.repo.db.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import mqq.app.AppRuntime;

class KandianOx210MsgInfo$8
  implements Runnable
{
  KandianOx210MsgInfo$8(KandianOx210MsgInfo paramKandianOx210MsgInfo, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(this.a, true, false).edit();
    localEditor.remove("kandian_push_ox210_msg");
    localEditor.remove("kandian_push_ox210_c5_msg_count");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.8
 * JD-Core Version:    0.7.0.1
 */