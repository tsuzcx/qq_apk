package com.tencent.mobileqq.utils;

import android.os.Handler;
import bgas;
import bgat;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  public VoicePlayer$1(bgas parambgas) {}
  
  public void run()
  {
    if ((bgas.a(this.this$0) == 4) || (bgas.a(this.this$0) == 5) || (bgas.a(this.this$0) == 6) || (bgas.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (bgas.a(this.this$0) == 3)
      {
        this.a = bgas.b(this.this$0);
        return;
      }
    } while (bgas.a(this.this$0) == null);
    int k = bgas.c(this.this$0);
    int i = bgas.b(this.this$0);
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
      Iterator localIterator = bgas.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((bgat)localIterator.next()).a(bgas.a(this.this$0), j, i);
      }
      if (bgas.a(this.this$0) == null) {
        break;
      }
      bgas.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */