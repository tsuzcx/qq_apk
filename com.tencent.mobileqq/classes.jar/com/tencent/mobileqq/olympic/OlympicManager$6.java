package com.tencent.mobileqq.olympic;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.ByteArrayOutputStream;

class OlympicManager$6
  implements Runnable
{
  OlympicManager$6(OlympicManager paramOlympicManager, TorchInfo paramTorchInfo) {}
  
  public void run()
  {
    synchronized (OlympicManager.b(this.this$0))
    {
      new ByteArrayOutputStream();
      OlympicManager.a(this.this$0);
      boolean bool = this.this$0.a.getPreferences().getBoolean("olympic_setting_ever_fetch_flag_switch_here", false);
      if ((this.a.transfer_num != 1L) && (!bool)) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.OlympicManager.6
 * JD-Core Version:    0.7.0.1
 */