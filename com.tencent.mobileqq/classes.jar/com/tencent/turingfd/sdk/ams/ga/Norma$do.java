package com.tencent.turingfd.sdk.ams.ga;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class Norma$do
  extends Binder
  implements Norma
{
  public static final String j = const.get(const.Xb);
  
  public static Norma a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface(j);
    if ((localIInterface != null) && ((localIInterface instanceof Norma))) {
      return (Norma)localIInterface;
    }
    return new Norma.do.do(paramIBinder);
  }
  
  public static Norma i()
  {
    return Norma.do.do.ae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Norma.do
 * JD-Core Version:    0.7.0.1
 */