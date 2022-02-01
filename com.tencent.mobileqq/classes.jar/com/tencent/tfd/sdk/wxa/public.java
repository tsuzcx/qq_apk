package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class public
{
  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return false;
    }
    int i = paramString2.indexOf('/');
    if (i == -1) {
      return false;
    }
    String str = paramString2.substring(i).trim();
    if (!str.startsWith("/data/")) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/data/data/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    if (str.startsWith(localStringBuilder.toString())) {
      return false;
    }
    boolean bool = str.endsWith(".so");
    if ((!bool) && (str.endsWith(".jar"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!bool) && (i == 0)) {
      return false;
    }
    return paramString2.contains(const.get(const.Aa));
  }
  
  public static boolean o(Context paramContext)
  {
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    localAtomicReference.set(Boolean.valueOf(false));
    new Handler(paramContext.getMainLooper()).post(new native(localAtomicBoolean, localAtomicReference, System.currentTimeMillis(), localObject));
    try
    {
      try
      {
        localObject.wait(100L);
      }
      finally
      {
        break label95;
      }
    }
    catch (InterruptedException paramContext)
    {
      label77:
      break label77;
    }
    localAtomicBoolean.set(true);
    return ((Boolean)localAtomicReference.get()).booleanValue();
    label95:
    throw paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.public
 * JD-Core Version:    0.7.0.1
 */