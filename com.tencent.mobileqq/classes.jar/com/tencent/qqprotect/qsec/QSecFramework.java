package com.tencent.qqprotect.qsec;

import android.os.Handler;
import bhms;
import bhmz;
import bhne;
import bhnq;
import bhoj;
import bhoo;
import bhop;
import bhoq;
import bhor;
import bhos;
import bhot;
import bhou;
import bhpd;
import bhpg;
import bhpi;
import bhpx;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Long, bhot> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private bhoj jdField_a_of_type_Bhoj;
  private bhou jdField_a_of_type_Bhou;
  private bhpd jdField_a_of_type_Bhpd;
  private bhpg jdField_a_of_type_Bhpg = new bhpg();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new bhnq("QSec", 86400000L).a(new bhoo());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Bhpg.a(bhne.a());
    this.jdField_a_of_type_Bhpg.a(bhpi.a());
    this.jdField_a_of_type_Bhpg.a(bhmz.a());
    new bhnq("QSec", 86400000L).a(new bhop(this));
    this.jdField_a_of_type_Bhoj = new bhoj();
    this.jdField_a_of_type_Bhou = new bhou(this.jdField_a_of_type_Bhoj);
    this.jdField_a_of_type_Bhpd = new bhpd(this.jdField_a_of_type_Bhou, this.jdField_a_of_type_Bhoj);
    this.jdField_b_of_type_AndroidOsHandler = new bhoq(this, ThreadManager.getFileThreadLooper());
    a(2L, new bhor(this));
  }
  
  public static int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!jdField_a_of_type_Boolean) {
      return 27;
    }
    try
    {
      int i = goingDownInternal(paramLong1, paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
      return i;
    }
    catch (UnsatisfiedLinkError paramObject1)
    {
      paramObject1.printStackTrace();
    }
    return 29;
  }
  
  public static Handler a()
  {
    return jdField_a_of_type_AndroidOsHandler;
  }
  
  public static QSecFramework a()
  {
    if (jdField_a_of_type_ComTencentQqprotectQsecQSecFramework == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqprotectQsecQSecFramework == null) {
        jdField_a_of_type_ComTencentQqprotectQsecQSecFramework = new QSecFramework();
      }
      return jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
    }
    finally {}
  }
  
  public static void a(long paramLong, bhot parambhot)
  {
    if (parambhot != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambhot);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = bhms.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (bhpx.a(localFile, null))) {
      try
      {
        System.load(str);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return false;
  }
  
  private static native int goingDownInternal(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
  
  private static int goingUp(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    bhot localbhot = (bhot)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localbhot != null) {
      return localbhot.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bhou.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Bhoj != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Bhoj.a(paramInt));
    }
    if (1 == localByte.byteValue()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public void a()
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Bhoj.a(false);
    this.jdField_a_of_type_Bhou.a(new bhos(this));
    this.jdField_a_of_type_Bhou.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bhpd.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhou.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */