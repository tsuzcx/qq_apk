package com.tencent.mobileqq.utils;

import android.os.Handler;
import bblk;
import bbll;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  public VoicePlayer$1(bblk parambblk) {}
  
  public void run()
  {
    if ((bblk.a(this.this$0) == 4) || (bblk.a(this.this$0) == 5) || (bblk.a(this.this$0) == 6) || (bblk.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (bblk.a(this.this$0) == 3)
      {
        this.a = bblk.b(this.this$0);
        return;
      }
    } while (bblk.a(this.this$0) == null);
    int k = bblk.c(this.this$0);
    int i = bblk.b(this.this$0);
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
      Iterator localIterator = bblk.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((bbll)localIterator.next()).a(bblk.a(this.this$0), j, i);
      }
      if (bblk.a(this.this$0) == null) {
        break;
      }
      bblk.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */