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
    if ((VoicePlayer.a(this.this$0) != 4) && (VoicePlayer.a(this.this$0) != 5) && (VoicePlayer.a(this.this$0) != 6) && (VoicePlayer.a(this.this$0) != 8))
    {
      if (VoicePlayer.a(this.this$0) == 3)
      {
        this.a = VoicePlayer.b(this.this$0);
        return;
      }
      if (VoicePlayer.a(this.this$0) == null) {
        return;
      }
      int k = VoicePlayer.c(this.this$0);
      int j = VoicePlayer.b(this.this$0);
      int m = this.a;
      int i = j;
      if (j < m) {
        i = m;
      }
      m = this.a;
      j = k;
      if (m != 0)
      {
        j = k;
        if (m == i)
        {
          j = k;
          if (m > k - 200)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("change duration from ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" to ");
            ((StringBuilder)localObject).append(i);
            QLog.d("Q.profilecard.VoicePlayer", 2, ((StringBuilder)localObject).toString());
            j = i;
          }
        }
      }
      if (i > this.a) {
        this.a = i;
      }
      Object localObject = VoicePlayer.a(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VoicePlayer.VoicePlayerListener)((Iterator)localObject).next()).a(VoicePlayer.a(this.this$0), j, i);
      }
      if (VoicePlayer.a(this.this$0) != null) {
        VoicePlayer.a(this.this$0).postDelayed(this, 50L);
      }
      return;
    }
    this.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */