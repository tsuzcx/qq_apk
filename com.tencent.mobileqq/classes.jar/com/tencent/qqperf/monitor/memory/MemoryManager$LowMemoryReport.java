package com.tencent.qqperf.monitor.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import mqq.app.MobileQQ;

class MemoryManager$LowMemoryReport
{
  long a;
  long b;
  int c;
  long d;
  long e;
  int f;
  long g;
  
  public void a()
  {
    long l = DeviceInfoUtil.a();
    try
    {
      Object localObject = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0).getString("LowMemoryStat", null);
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return;
        }
        localObject = new DataInputStream(new ByteArrayInputStream(Base64Util.decode((String)localObject, 0)));
        this.a = ((DataInputStream)localObject).readLong();
        this.b = ((DataInputStream)localObject).readLong();
        this.c = ((DataInputStream)localObject).readInt();
        this.d = ((DataInputStream)localObject).readLong();
        this.e = ((DataInputStream)localObject).readLong();
        this.f = ((DataInputStream)localObject).readInt();
        this.g = ((DataInputStream)localObject).readLong();
        break label118;
      }
      return;
    }
    catch (Exception localException)
    {
      label114:
      break label114;
    }
    b();
    label118:
    if ((l < this.a) || (l < this.b) || (l < this.d) || (l < this.e)) {
      b();
    }
  }
  
  public void b()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.g = 0L;
  }
  
  public void c()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(this.a);
      localDataOutputStream.writeLong(this.b);
      localDataOutputStream.writeInt(this.c);
      localDataOutputStream.writeLong(this.d);
      localDataOutputStream.writeLong(this.e);
      localDataOutputStream.writeInt(this.f);
      localDataOutputStream.writeLong(this.g);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString("LowMemoryStat", Base64Util.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.MemoryManager.LowMemoryReport
 * JD-Core Version:    0.7.0.1
 */