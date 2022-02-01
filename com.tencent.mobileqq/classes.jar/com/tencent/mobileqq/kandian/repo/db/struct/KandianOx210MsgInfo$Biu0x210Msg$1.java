package com.tencent.mobileqq.kandian.repo.db.struct;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

class KandianOx210MsgInfo$Biu0x210Msg$1
  implements Runnable
{
  KandianOx210MsgInfo$Biu0x210Msg$1(KandianOx210MsgInfo.Biu0x210Msg paramBiu0x210Msg, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(this.a, true, false).edit();
    localEditor.putLong("kandian_biu_0x210_seq", this.this$0.a);
    localEditor.putLong("kandian_biu_0x210_uin", this.this$0.b);
    localEditor.putInt("kandian_biu_0x210_status", this.this$0.c);
    RIJSPUtils.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.Biu0x210Msg.1
 * JD-Core Version:    0.7.0.1
 */