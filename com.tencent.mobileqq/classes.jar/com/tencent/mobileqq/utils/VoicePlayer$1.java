package com.tencent.mobileqq.utils;

import android.os.Handler;
import bdpb;
import bdpc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class VoicePlayer$1
  implements Runnable
{
  int a = 0;
  
  public VoicePlayer$1(bdpb parambdpb) {}
  
  public void run()
  {
    if ((bdpb.a(this.this$0) == 4) || (bdpb.a(this.this$0) == 5) || (bdpb.a(this.this$0) == 6) || (bdpb.a(this.this$0) == 8)) {
      this.a = 0;
    }
    do
    {
      return;
      if (bdpb.a(this.this$0) == 3)
      {
        this.a = bdpb.b(this.this$0);
        return;
      }
    } while (bdpb.a(this.this$0) == null);
    int k = bdpb.c(this.this$0);
    int i = bdpb.b(this.this$0);
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
      Iterator localIterator = bdpb.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((bdpc)localIterator.next()).a(bdpb.a(this.this$0), j, i);
      }
      if (bdpb.a(this.this$0) == null) {
        break;
      }
      bdpb.a(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */