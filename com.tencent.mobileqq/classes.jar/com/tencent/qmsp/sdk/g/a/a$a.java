package com.tencent.qmsp.sdk.g.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class a$a
  extends Binder
  implements a
{
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.a.a.a
 * JD-Core Version:    0.7.0.1
 */