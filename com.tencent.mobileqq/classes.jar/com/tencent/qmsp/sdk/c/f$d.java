package com.tencent.qmsp.sdk.c;

import android.os.Handler;
import com.tencent.qmsp.sdk.f.g;

class f$d
  implements f.f
{
  f$d(f paramf) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramLong1 != 0L)
    {
      g.a("Qp.QFW", 1, String.format("Native msg, cookie: %08X, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      paramObject1 = String.valueOf(paramLong1);
      if (paramLong2 != 0L)
      {
        f.d(this.a).sendMessageDelayed(f.d(this.a).obtainMessage(1, paramObject1), paramLong2 * 1000L);
        return 0;
      }
      f.d(this.a).sendMessage(f.d(this.a).obtainMessage(1, paramObject1));
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.f.d
 * JD-Core Version:    0.7.0.1
 */