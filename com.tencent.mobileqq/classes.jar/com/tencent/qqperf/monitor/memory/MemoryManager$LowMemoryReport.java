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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  long c;
  long d;
  long e;
  
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
        this.jdField_a_of_type_Long = ((DataInputStream)localObject).readLong();
        this.jdField_b_of_type_Long = ((DataInputStream)localObject).readLong();
        this.jdField_a_of_type_Int = ((DataInputStream)localObject).readInt();
        this.c = ((DataInputStream)localObject).readLong();
        this.d = ((DataInputStream)localObject).readLong();
        this.jdField_b_of_type_Int = ((DataInputStream)localObject).readInt();
        this.e = ((DataInputStream)localObject).readLong();
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
    if ((l < this.jdField_a_of_type_Long) || (l < this.jdField_b_of_type_Long) || (l < this.c) || (l < this.d)) {
      b();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.c = 0L;
    this.d = 0L;
    this.jdField_b_of_type_Int = 0;
    this.e = 0L;
  }
  
  public void c()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(this.jdField_a_of_type_Long);
      localDataOutputStream.writeLong(this.jdField_b_of_type_Long);
      localDataOutputStream.writeInt(this.jdField_a_of_type_Int);
      localDataOutputStream.writeLong(this.c);
      localDataOutputStream.writeLong(this.d);
      localDataOutputStream.writeInt(this.jdField_b_of_type_Int);
      localDataOutputStream.writeLong(this.e);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString("LowMemoryStat", Base64Util.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.MemoryManager.LowMemoryReport
 * JD-Core Version:    0.7.0.1
 */