package com.tencent.mobileqq.utils;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  VoicePlayer$1(VoicePlayer paramVoicePlayer) {}
  
  public void run()
  {
    if ((VoicePlayer.a(this.this$0) == 4) || (VoicePlayer.a(this.this$0) == 5) || (VoicePlayer.a(this.this$0) == 6) || (VoicePlayer.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (VoicePlayer.a(this.this$0) == 3)
      {
        this.a = VoicePlayer.b(this.this$0);
        return;
      }
    } while (VoicePlayer.a(this.this$0) == null);
    int k = VoicePlayer.c(this.this$0);
    int i = VoicePlayer.b(this.this$0);
    if (i < this.a) {
      i = this.a;
    }
    for (;;)
    {
      int j = k;
      if (this.a != 0)
      {
        j = k;
        if (this.a == i)
        {
          j = k;
          if (this.a > k - 200)
          {
            QLog.d("Q.profilecard.VoicePlayer", 2, "change duration from " + i + " to " + i);
            j = i;
          }
        }
      }
      if (i > this.a) {
        this.a = i;
      }
      Iterator localIterator = VoicePlayer.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).a(VoicePlayer.a(this.this$0), j, i);
      }
      if (VoicePlayer.a(this.this$0) == null) {
        break;
      }
      VoicePlayer.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */