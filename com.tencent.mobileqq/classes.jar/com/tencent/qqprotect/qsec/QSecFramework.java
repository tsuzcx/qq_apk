package com.tencent.qqprotect.qsec;

import android.os.Handler;
import bhil;
import bhis;
import bhix;
import bhjj;
import bhkc;
import bhkh;
import bhki;
import bhkj;
import bhkk;
import bhkl;
import bhkm;
import bhkn;
import bhkw;
import bhkz;
import bhlb;
import bhlq;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Long, bhkm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private bhkc jdField_a_of_type_Bhkc;
  private bhkn jdField_a_of_type_Bhkn;
  private bhkw jdField_a_of_type_Bhkw;
  private bhkz jdField_a_of_type_Bhkz = new bhkz();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new bhjj("QSec", 86400000L).a(new bhkh());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Bhkz.a(bhix.a());
    this.jdField_a_of_type_Bhkz.a(bhlb.a());
    this.jdField_a_of_type_Bhkz.a(bhis.a());
    new bhjj("QSec", 86400000L).a(new bhki(this));
    this.jdField_a_of_type_Bhkc = new bhkc();
    this.jdField_a_of_type_Bhkn = new bhkn(this.jdField_a_of_type_Bhkc);
    this.jdField_a_of_type_Bhkw = new bhkw(this.jdField_a_of_type_Bhkn, this.jdField_a_of_type_Bhkc);
    this.jdField_b_of_type_AndroidOsHandler = new bhkj(this, ThreadManager.getFileThreadLooper());
    a(2L, new bhkk(this));
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
  
  public static void a(long paramLong, bhkm parambhkm)
  {
    if (parambhkm != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambhkm);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = bhil.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (bhlq.a(localFile, null))) {
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
    bhkm localbhkm = (bhkm)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localbhkm != null) {
      return localbhkm.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bhkn.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Bhkc != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Bhkc.a(paramInt));
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
    this.jdField_a_of_type_Bhkc.a(false);
    this.jdField_a_of_type_Bhkn.a(new bhkl(this));
    this.jdField_a_of_type_Bhkn.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bhkw.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhkn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */