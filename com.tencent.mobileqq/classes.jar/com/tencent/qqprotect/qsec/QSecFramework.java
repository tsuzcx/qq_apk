package com.tencent.qqprotect.qsec;

import android.os.Handler;
import bkst;
import bkta;
import bktf;
import bktr;
import bkuk;
import bkup;
import bkuq;
import bkur;
import bkus;
import bkut;
import bkuu;
import bkuv;
import bkve;
import bkvh;
import bkvj;
import bkvy;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Long, bkuu> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private bkuk jdField_a_of_type_Bkuk;
  private bkuv jdField_a_of_type_Bkuv;
  private bkve jdField_a_of_type_Bkve;
  private bkvh jdField_a_of_type_Bkvh = new bkvh();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new bktr("QSec", 86400000L).a(new bkup());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Bkvh.a(bktf.a());
    this.jdField_a_of_type_Bkvh.a(bkvj.a());
    this.jdField_a_of_type_Bkvh.a(bkta.a());
    new bktr("QSec", 86400000L).a(new bkuq(this));
    this.jdField_a_of_type_Bkuk = new bkuk();
    this.jdField_a_of_type_Bkuv = new bkuv(this.jdField_a_of_type_Bkuk);
    this.jdField_a_of_type_Bkve = new bkve(this.jdField_a_of_type_Bkuv, this.jdField_a_of_type_Bkuk);
    this.jdField_b_of_type_AndroidOsHandler = new bkur(this, ThreadManager.getFileThreadLooper());
    a(2L, new bkus(this));
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
  
  public static void a(long paramLong, bkuu parambkuu)
  {
    if (parambkuu != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambkuu);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = bkst.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (bkvy.a(localFile, null))) {
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
    bkuu localbkuu = (bkuu)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localbkuu != null) {
      return localbkuu.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bkuv.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Bkuk != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Bkuk.a(paramInt));
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
    this.jdField_a_of_type_Bkuk.a(false);
    this.jdField_a_of_type_Bkuv.a(new bkut(this));
    this.jdField_a_of_type_Bkuv.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bkve.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bkuv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */