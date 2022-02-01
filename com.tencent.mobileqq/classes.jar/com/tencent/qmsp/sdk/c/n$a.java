package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.f.g;

class n$a
  implements f.f
{
  n$a(n paramn) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof String)))
    {
      paramObject1 = (String)paramObject1;
      g.a("QSec.Rpt", 1, String.format("Op: %d, Rid: %d, val: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramObject1 }));
      this.a.a(paramLong1, paramLong2, paramObject1);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.n.a
 * JD-Core Version:    0.7.0.1
 */