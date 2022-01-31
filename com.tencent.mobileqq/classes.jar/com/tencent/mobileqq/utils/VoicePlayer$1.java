package com.tencent.mobileqq.utils;

import android.os.Handler;
import baka;
import bakb;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  public VoicePlayer$1(baka parambaka) {}
  
  public void run()
  {
    if ((baka.a(this.this$0) == 4) || (baka.a(this.this$0) == 5) || (baka.a(this.this$0) == 6) || (baka.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (baka.a(this.this$0) == 3)
      {
        this.a = baka.b(this.this$0);
        return;
      }
    } while (baka.a(this.this$0) == null);
    int k = baka.c(this.this$0);
    int i = baka.b(this.this$0);
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
      Iterator localIterator = baka.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((bakb)localIterator.next()).a(baka.a(this.this$0), j, i);
      }
      if (baka.a(this.this$0) == null) {
        break;
      }
      baka.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */