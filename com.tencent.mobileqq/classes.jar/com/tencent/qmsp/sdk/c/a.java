package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;

public class a
{
  private static final byte[] d = { 6, 98, -78, 83, 38, 11, 101, -14, 22, 96 };
  private String a;
  private long b;
  private boolean c;
  
  public a(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
  }
  
  private boolean a()
  {
    Object localObject1 = QmspSDK.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b.a);
    ((StringBuilder)localObject2).append(a(d));
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = false;
    localObject1 = ((Context)localObject1).getSharedPreferences((String)localObject2, 0);
    this.c = true;
    try
    {
      long l3 = ((SharedPreferences)localObject1).getLong(this.a, 0L);
      long l1 = System.currentTimeMillis();
      long l2 = l1 - l3;
      if (l3 != 0L)
      {
        l3 = this.b;
        if ((l2 < l3) && (l2 > 0L)) {
          try
          {
            this.c = false;
            return true;
          }
          catch (Exception localException1)
          {
            bool = true;
          }
        }
      }
      SharedPreferences.Editor localEditor = localException1.edit();
      localEditor.putLong(this.a, l1);
      localEditor.commit();
      return false;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    return bool;
  }
  
  private void b()
  {
    if (!this.c) {
      return;
    }
    Object localObject = QmspSDK.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.a);
    localStringBuilder.append(a(d));
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.a);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  public void a(a.a parama)
  {
    if (parama != null)
    {
      if (!a()) {
        parama.run();
      } else {
        parama.a();
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.a
 * JD-Core Version:    0.7.0.1
 */