package com.tencent.mobileqq.msf.core.d;

import android.os.Environment;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  public static final String a = "MsfAvReport";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 9;
  public static final int l = 10;
  public static final int m = 11;
  public static final int n = 12;
  public static final int o = 13;
  public static final int p = 14;
  public static final int q = 15;
  public static final int r = 16;
  public static final int s = 17;
  public static final int t = 18;
  public static final int u = 100;
  static e v;
  static String w = "";
  Thread A = new Thread(new f(this));
  final int x = 100;
  Object y = new Object();
  ConcurrentHashMap z = new ConcurrentHashMap();
  
  public static e a()
  {
    if (v == null)
    {
      v = new e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/audio/");
      w = localStringBuilder.toString();
    }
    return v;
  }
  
  public void a(e.a arg1, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(???);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(String.valueOf(SystemClock.elapsedRealtime()));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".msf");
    localObject = ((StringBuilder)localObject).toString();
    synchronized (this.y)
    {
      this.z.put(localObject, paramArrayOfByte);
      if (!this.A.isAlive()) {
        this.A.start();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.e
 * JD-Core Version:    0.7.0.1
 */