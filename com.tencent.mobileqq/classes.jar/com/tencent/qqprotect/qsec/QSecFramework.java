package com.tencent.qqprotect.qsec;

import android.os.Handler;
import bdzk;
import bdzr;
import bdzw;
import beai;
import bebb;
import bebg;
import bebh;
import bebi;
import bebj;
import bebk;
import bebl;
import bebm;
import bebv;
import beby;
import beca;
import becp;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap<Integer, bebl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private bebb jdField_a_of_type_Bebb;
  private bebm jdField_a_of_type_Bebm;
  private bebv jdField_a_of_type_Bebv;
  private beby jdField_a_of_type_Beby = new beby();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new beai("QSec", 86400000L).a(new bebg());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_Beby.a(bdzw.a());
    this.jdField_a_of_type_Beby.a(beca.a());
    this.jdField_a_of_type_Beby.a(bdzr.a());
    new beai("QSec", 86400000L).a(new bebh(this));
    this.jdField_a_of_type_Bebb = new bebb();
    this.jdField_a_of_type_Bebm = new bebm(this.jdField_a_of_type_Bebb);
    this.jdField_a_of_type_Bebv = new bebv(this.jdField_a_of_type_Bebm, this.jdField_a_of_type_Bebb);
    this.jdField_b_of_type_AndroidOsHandler = new bebi(this, ThreadManager.getFileThreadLooper());
    a(2, new bebj(this));
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (!jdField_a_of_type_Boolean) {
      return 27;
    }
    try
    {
      paramInt1 = goingDownInternal(paramInt1, paramInt2, paramInt3, paramInt4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
      return paramInt1;
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
  
  public static void a(int paramInt, bebl parambebl)
  {
    if (parambebl != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), parambebl);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = bdzk.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (becp.a(localFile, null))) {
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
  
  private static native int goingDownInternal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2);
  
  private static int goingUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    bebl localbebl = (bebl)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    if (localbebl != null) {
      return localbebl.a(paramInt2, paramInt3, paramInt4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_Bebm.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_Bebb != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_Bebb.a(paramInt));
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
    this.jdField_a_of_type_Bebb.a(false);
    this.jdField_a_of_type_Bebm.a(new bebk(this));
    this.jdField_a_of_type_Bebm.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Bebv.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bebm.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */