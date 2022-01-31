package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.b.j;
import com.tencent.tvkbeacon.core.c.b;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;
import com.tencent.tvkbeacon.event.UserAction;

public final class e
{
  public static RequestPackage a(Context paramContext, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    c.b("[event] origin events byte size: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramContext = j.a(paramInt, com.tencent.tvkbeacon.core.info.e.b(paramContext), paramArrayOfByte, 2, 3, paramString);
      if (paramContext != null) {
        paramContext.reserved = b.a(UserAction.getAdditionalInfo(paramString));
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      c.c("[event] encode request package error:%s", new Object[] { paramContext.toString() });
      c.a(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.e
 * JD-Core Version:    0.7.0.1
 */