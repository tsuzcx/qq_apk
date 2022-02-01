package com.tencent.qqprotect.qsec;

import android.os.Handler;
import blbe;
import blbl;
import blbq;
import blcc;
import blcv;
import blda;
import bldb;
import bldc;
import bldd;
import blde;
import bldf;
import bldg;
import bldp;
import blds;
import bldu;
import blej;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Long, bldf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private blcv jdField_a_of_type_Blcv;
  private bldg jdField_a_of_type_Bldg;
  private bldp jdField_a_of_type_Bldp;
  private blds jdField_a_of_type_Blds = new blds();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new blcc("QSec", 86400000L).a(new blda());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Blds.a(blbq.a());
    this.jdField_a_of_type_Blds.a(bldu.a());
    this.jdField_a_of_type_Blds.a(blbl.a());
    new blcc("QSec", 86400000L).a(new bldb(this));
    this.jdField_a_of_type_Blcv = new blcv();
    this.jdField_a_of_type_Bldg = new bldg(this.jdField_a_of_type_Blcv);
    this.jdField_a_of_type_Bldp = new bldp(this.jdField_a_of_type_Bldg, this.jdField_a_of_type_Blcv);
    this.jdField_b_of_type_AndroidOsHandler = new bldc(this, ThreadManager.getFileThreadLooper());
    a(2L, new bldd(this));
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
  
  public static void a(long paramLong, bldf parambldf)
  {
    if (parambldf != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambldf);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = blbe.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (blej.a(localFile, null))) {
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
    bldf localbldf = (bldf)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localbldf != null) {
      return localbldf.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bldg.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Blcv != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Blcv.a(paramInt));
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
    this.jdField_a_of_type_Blcv.a(false);
    this.jdField_a_of_type_Bldg.a(new blde(this));
    this.jdField_a_of_type_Bldg.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bldp.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bldg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */