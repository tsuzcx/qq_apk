package com.tencent.qmsp.sdk.g.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class d$a
  extends Binder
  implements d
{
  public static d a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.heytap.openid.IOpenID");
    if ((localIInterface != null) && ((localIInterface instanceof d))) {
      return (d)localIInterface;
    }
    return new d.a.a(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.g.d.a
 * JD-Core Version:    0.7.0.1
 */