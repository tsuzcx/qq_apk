package com.tencent.qqprotect.qsec;

import android.os.Handler;
import bfha;
import bfhh;
import bfhm;
import bfhy;
import bfir;
import bfiw;
import bfix;
import bfiy;
import bfiz;
import bfja;
import bfjb;
import bfjc;
import bfjl;
import bfjo;
import bfjq;
import bfkf;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Long, bfjb> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private bfir jdField_a_of_type_Bfir;
  private bfjc jdField_a_of_type_Bfjc;
  private bfjl jdField_a_of_type_Bfjl;
  private bfjo jdField_a_of_type_Bfjo = new bfjo();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new bfhy("QSec", 86400000L).a(new bfiw());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Bfjo.a(bfhm.a());
    this.jdField_a_of_type_Bfjo.a(bfjq.a());
    this.jdField_a_of_type_Bfjo.a(bfhh.a());
    new bfhy("QSec", 86400000L).a(new bfix(this));
    this.jdField_a_of_type_Bfir = new bfir();
    this.jdField_a_of_type_Bfjc = new bfjc(this.jdField_a_of_type_Bfir);
    this.jdField_a_of_type_Bfjl = new bfjl(this.jdField_a_of_type_Bfjc, this.jdField_a_of_type_Bfir);
    this.jdField_b_of_type_AndroidOsHandler = new bfiy(this, ThreadManager.getFileThreadLooper());
    a(2L, new bfiz(this));
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
  
  public static void a(long paramLong, bfjb parambfjb)
  {
    if (parambfjb != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambfjb);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = bfha.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (bfkf.a(localFile, null))) {
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
    bfjb localbfjb = (bfjb)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localbfjb != null) {
      return localbfjb.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bfjc.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Bfir != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Bfir.a(paramInt));
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
    this.jdField_a_of_type_Bfir.a(false);
    this.jdField_a_of_type_Bfjc.a(new bfja(this));
    this.jdField_a_of_type_Bfjc.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bfjl.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bfjc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */