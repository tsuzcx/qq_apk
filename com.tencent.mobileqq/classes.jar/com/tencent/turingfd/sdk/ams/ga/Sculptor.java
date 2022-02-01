package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.util.concurrent.atomic.AtomicReference;

public class Sculptor
{
  public static final String Ie = const.get(const.Sb);
  
  public static Orion X(Context paramContext)
  {
    long l = System.currentTimeMillis();
    Intent localIntent = new Intent();
    localIntent.setAction(const.get(const.Xb));
    localIntent.setPackage(const.get(const.Yb));
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference();
    localAtomicReference.set(Orion.n(-2001));
    if (paramContext.getApplicationContext().bindService(localIntent, new Scorpius(localAtomicReference, l, localObject), 1)) {}
    try
    {
      try
      {
        localObject.wait(5000L);
      }
      finally
      {
        break label110;
      }
    }
    catch (InterruptedException paramContext)
    {
      label105:
      break label105;
    }
    break label125;
    label110:
    throw paramContext;
    localAtomicReference.set(Orion.n(-2002));
    label125:
    return (Orion)localAtomicReference.get();
  }
  
  public static Sculptor.do f(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new Sculptor.do(-3001, null, null);
    }
    if (paramArrayOfByte.length < 4) {
      return new Sculptor.do(-3001, null, null);
    }
    Object localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
    int j = 0;
    int i = 0;
    while (j < localObject.length)
    {
      i += ((localObject[j] & 0xFF) << j * 8);
      j += 1;
    }
    if (i > 1048576) {
      return new Sculptor.do(-3003, null, null);
    }
    localObject = new byte[i];
    int k = paramArrayOfByte.length;
    j = i + 4;
    if (k < j) {
      return new Sculptor.do(-3004, null, null);
    }
    System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
    localObject = new Pyxis(new String((byte[])localObject), "");
    i = paramArrayOfByte.length - j;
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
      Base64.encodeToString(arrayOfByte, 2);
      return new Sculptor.do(0, (Pyxis)localObject, null);
    }
    return new Sculptor.do(-3005, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Sculptor
 * JD-Core Version:    0.7.0.1
 */