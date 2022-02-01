package com.tencent.qqperf.monitor.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;

class MemoryManager$StatMemory
{
  public int a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public int g;
  public int h;
  public long i;
  public long j;
  public long k;
  private String l;
  
  public void a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0;
    this.h = 0;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
    try
    {
      paramString = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0).getString(this.l, null);
      if ((paramString != null) && (paramString.length() != 0))
      {
        paramString = new DataInputStream(new ByteArrayInputStream(Base64Util.decode(paramString, 0)));
        this.a = paramString.readInt();
        this.b = paramString.readLong();
        this.c = paramString.readLong();
        this.d = paramString.readLong();
        this.e = paramString.readLong();
        this.f = paramString.readLong();
        this.g = paramString.readInt();
        this.h = paramString.readInt();
        this.i = paramString.readLong();
        this.j = paramString.readLong();
        this.k = paramString.readLong();
        return;
      }
      a();
      return;
    }
    catch (Exception paramString)
    {
      label153:
      break label153;
    }
    paramString = new HashMap(3);
    paramString.put("type", "wrong-value");
    paramString.put("file", "MemoryManagerMemoryStat");
    paramString.put("key", "MemoryInfomation");
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "evSpError", true, 0L, 0L, paramString, null);
    a();
  }
  
  public void b()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(this.a);
      localDataOutputStream.writeLong(this.b);
      localDataOutputStream.writeLong(this.c);
      localDataOutputStream.writeLong(this.d);
      localDataOutputStream.writeLong(this.e);
      localDataOutputStream.writeLong(this.f);
      localDataOutputStream.writeInt(this.g);
      localDataOutputStream.writeInt(this.h);
      localDataOutputStream.writeLong(this.i);
      localDataOutputStream.writeLong(this.j);
      localDataOutputStream.writeLong(this.k);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString(this.l, Base64Util.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "StatMemory.save exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.MemoryManager.StatMemory
 * JD-Core Version:    0.7.0.1
 */