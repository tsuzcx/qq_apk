package com.tencent.mobileqq.utils;

import android.os.Handler;
import bdks;
import bdkt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  public VoicePlayer$1(bdks parambdks) {}
  
  public void run()
  {
    if ((bdks.a(this.this$0) == 4) || (bdks.a(this.this$0) == 5) || (bdks.a(this.this$0) == 6) || (bdks.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (bdks.a(this.this$0) == 3)
      {
        this.a = bdks.b(this.this$0);
        return;
      }
    } while (bdks.a(this.this$0) == null);
    int k = bdks.c(this.this$0);
    int i = bdks.b(this.this$0);
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
      Iterator localIterator = bdks.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((bdkt)localIterator.next()).a(bdks.a(this.this$0), j, i);
      }
      if (bdks.a(this.this$0) == null) {
        break;
      }
      bdks.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */