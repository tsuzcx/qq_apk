package com.tencent.mobileqq.kandian.repo.db.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

class KandianOx210MsgInfo$Biu0x210Msg$2
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(this.a, true, false).edit();
    localEditor.remove("kandian_biu_0x210_seq");
    localEditor.remove("kandian_biu_0x210_uin");
    localEditor.remove("kandian_biu_0x210_status");
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.Biu0x210Msg.2
 * JD-Core Version:    0.7.0.1
 */