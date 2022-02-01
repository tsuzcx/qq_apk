package com.tencent.qqprotect.qsec;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqprotect.common.QPDirUtils;
import com.tencent.qqprotect.singleupdate.VerifyFileUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class QSecFramework
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
  private static volatile QSecFramework jdField_a_of_type_ComTencentQqprotectQsecQSecFramework = null;
  private static ConcurrentHashMap<Long, QSecFramework.IGoingUpHandler> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = -1;
  private QSecCbMgr jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = null;
  private QSecLibMgr jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr = null;
  private QSecPushServiceMgr jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr = null;
  private QSecRuntimeImpl jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl = null;
  private Handler jdField_b_of_type_AndroidOsHandler = null;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = null;
    new CrashProtector("QSec", 86400000L).a(new QSecFramework.1());
  }
  
  private QSecFramework()
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl.a(CloudAVEngineImpl.a());
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl.a(RptImpl.a());
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecRuntimeImpl.a(CSProcessorImpl.a());
    new CrashProtector("QSec", 86400000L).a(new QSecFramework.2(this));
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = new QSecCbMgr();
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr = new QSecLibMgr(this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr);
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr = new QSecPushServiceMgr(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr, this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr);
    this.jdField_b_of_type_AndroidOsHandler = new QSecFramework.3(this, ThreadManager.getFileThreadLooper());
    a(2L, new QSecFramework.4(this));
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
    if (jdField_a_of_type_ComTencentQqprotectQsecQSecFramework == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqprotectQsecQSecFramework == null) {
          jdField_a_of_type_ComTencentQqprotectQsecQSecFramework = new QSecFramework();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqprotectQsecQSecFramework;
  }
  
  public static void a(long paramLong, QSecFramework.IGoingUpHandler paramIGoingUpHandler)
  {
    if (paramIGoingUpHandler != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramIGoingUpHandler);
    }
  }
  
  private static boolean c()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QPDirUtils.b());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("libQSec.so");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((localFile.exists()) && (VerifyFileUtil.a(localFile, null))) {
      try
      {
        System.load((String)localObject);
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
    QSecFramework.IGoingUpHandler localIGoingUpHandler = (QSecFramework.IGoingUpHandler)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (localIGoingUpHandler != null) {
      return localIGoingUpHandler.a(paramLong2, paramLong3, paramLong4, paramObject1, paramObject2, paramArrayOfObject1, paramArrayOfObject2);
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
    QSecCbMgr localQSecCbMgr = this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr;
    if (localQSecCbMgr != null) {
      localByte = Byte.valueOf(localQSecCbMgr.a(paramInt));
    }
    paramInt = localByte.byteValue();
    boolean bool = true;
    if (1 != paramInt) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public void a()
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(false);
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.a(new QSecFramework.5(this));
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.b();
    jdField_a_of_type_AndroidOsHandler.postDelayed(new QSecFramework.6(this), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecFramework
 * JD-Core Version:    0.7.0.1
 */