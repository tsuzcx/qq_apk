package com.tencent.mobileqq.utils;

import android.os.Handler;
import bhud;
import bhue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  public VoicePlayer$1(bhud parambhud) {}
  
  public void run()
  {
    if ((bhud.a(this.this$0) == 4) || (bhud.a(this.this$0) == 5) || (bhud.a(this.this$0) == 6) || (bhud.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (bhud.a(this.this$0) == 3)
      {
        this.a = bhud.b(this.this$0);
        return;
      }
    } while (bhud.a(this.this$0) == null);
    int k = bhud.c(this.this$0);
    int i = bhud.b(this.this$0);
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
      Iterator localIterator = bhud.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((bhue)localIterator.next()).a(bhud.a(this.this$0), j, i);
      }
      if (bhud.a(this.this$0) == null) {
        break;
      }
      bhud.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */