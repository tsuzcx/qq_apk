package com.tencent.qqprotect.qsec;

import alhv;
import alhw;
import alhx;
import alhy;
import alhz;
import alia;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqprotect.common.QPDirUtils;
import com.tencent.qqprotect.singleupdate.VerifyFileUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -1;
  private QSecCbMgr jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr;
  private QSecLibMgr jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr;
  private QSecPushServiceMgr jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr;
  private QSecRuntimeImpl jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl = new QSecRuntimeImpl();
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    new CrashProtector("QSec", 86400000L).a(new alhv());
    jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QSecMain", 10);
    jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl.a(CloudAVEngineImpl.a());
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl.a(RptImpl.a());
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl.a(CSProcessorImpl.a());
    new CrashProtector("QSec", 86400000L).a(new alhw(this));
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = new QSecCbMgr();
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr = new QSecLibMgr(this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr);
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr = new QSecPushServiceMgr(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr, this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr);
    this.jdField_b_of_type_AndroidOsHandler = new alhx(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    a(2, new alhy(this));
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
  
  public static HandlerThread a()
  {
    return jdField_a_of_type_AndroidOsHandlerThread;
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
  
  public static void a(int paramInt, QSecFramework.IGoingUpHandler paramIGoingUpHandler)
  {
    if (paramIGoingUpHandler != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramIGoingUpHandler);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    String str = QPDirUtils.b() + File.separator + "libQSec.so";
    File localFile = new File(str);
    if ((localFile.exists()) && (VerifyFileUtil.a(localFile, null))) {
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
    QSecFramework.IGoingUpHandler localIGoingUpHandler = (QSecFramework.IGoingUpHandler)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    if (localIGoingUpHandler != null) {
      return localIGoingUpHandler.a(paramInt2, paramInt3, paramInt4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
    }
    return 30;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.a(paramInt1, paramInt2, paramInt3, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public Boolean a(int paramInt)
  {
    Byte localByte = Byte.valueOf();
    if (this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr != null) {
      localByte = Byte.valueOf(this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(paramInt));
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
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(false);
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.a(new alhz(this));
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new alia(this), 0L);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr.a(paramArrayOfByte);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */