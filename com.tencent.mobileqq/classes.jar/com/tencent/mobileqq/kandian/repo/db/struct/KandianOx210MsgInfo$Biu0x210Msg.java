package com.tencent.mobileqq.kandian.repo.db.struct;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;

public class KandianOx210MsgInfo$Biu0x210Msg
{
  public long a = -1L;
  public long b = -1L;
  public int c = -1;
  
  public static Biu0x210Msg a()
  {
    Biu0x210Msg localBiu0x210Msg = new Biu0x210Msg();
    SharedPreferences localSharedPreferences = RIJSPUtils.a(true, false);
    localBiu0x210Msg.a = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
    localBiu0x210Msg.b = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
    localBiu0x210Msg.c = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
    return localBiu0x210Msg;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new KandianOx210MsgInfo.Biu0x210Msg.1(this, paramQQAppInterface), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo.Biu0x210Msg
 * JD-Core Version:    0.7.0.1
 */