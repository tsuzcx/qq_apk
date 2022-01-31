package com.tencent.tvkbeacon.g;

import com.tencent.tvkbeacon.core.b.f;
import com.tencent.tvkbeacon.core.c.c;

final class b$3
  implements f
{
  b$3(b paramb) {}
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramBoolean = true;
    if (paramInt != 103)
    {
      c.c("[qimei] qimei req unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      c.b("[qimei] query qimei finish, result: ".concat(String.valueOf(paramBoolean)), new Object[0]);
      if (!paramBoolean) {
        break;
      }
      c.a("[qimei] process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
      this.a.a(paramArrayOfByte);
      com.tencent.tvkbeacon.core.a.b.d().a(112, false);
      d.c(b.a(this.a));
      return;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.g.b.3
 * JD-Core Version:    0.7.0.1
 */