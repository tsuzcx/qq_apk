package com.tencent.qqprotect.qsec;

import android.os.Handler;
import bfhr;
import bfhy;
import bfid;
import bfip;
import bfji;
import bfjn;
import bfjo;
import bfjp;
import bfjq;
import bfjr;
import bfjs;
import bfjt;
import bfkc;
import bfkf;
import bfkh;
import bfkw;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Long, bfjs> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private bfji jdField_a_of_type_Bfji;
  private bfjt jdField_a_of_type_Bfjt;
  private bfkc jdField_a_of_type_Bfkc;
  private bfkf jdField_a_of_type_Bfkf = new bfkf();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new bfip("QSec", 86400000L).a(new bfjn());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Bfkf.a(bfid.a());
    this.jdField_a_of_type_Bfkf.a(bfkh.a());
    this.jdField_a_of_type_Bfkf.a(bfhy.a());
    new bfip("QSec", 86400000L).a(new bfjo(this));
    this.jdField_a_of_type_Bfji = new bfji();
    this.jdField_a_of_type_Bfjt = new bfjt(this.jdField_a_of_type_Bfji);
    this.jdField_a_of_type_Bfkc = new bfkc(this.jdField_a_of_type_Bfjt, this.jdField_a_of_type_Bfji);
    this.jdField_b_of_type_AndroidOsHandler = new bfjp(this, ThreadManager.getFileThreadLooper());
    a(2L, new bfjq(this));
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
  
  public static void a(long paramLong, bfjs parambfjs)
  {
    if (parambfjs != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambfjs);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = bfhr.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (bfkw.a(localFile, null))) {
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
    bfjs localbfjs = (bfjs)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localbfjs != null) {
      return localbfjs.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bfjt.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Bfji != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Bfji.a(paramInt));
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
    this.jdField_a_of_type_Bfji.a(false);
    this.jdField_a_of_type_Bfjt.a(new bfjr(this));
    this.jdField_a_of_type_Bfjt.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bfkc.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bfjt.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */