package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class FileIPv6Detecter
{
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "";
  private Map<String, FileIPv6Detecter.DomainDetectResult> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  
  private FileIPv6Detecter.DomainDetectResult a(FileIPv6StrateyController.DomainInfo paramDomainInfo)
  {
    if ((paramDomainInfo == null) || (paramDomainInfo.jdField_a_of_type_JavaLangString == null)) {
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramDomainInfo = (FileIPv6Detecter.DomainDetectResult)this.jdField_a_of_type_JavaUtilMap.get(paramDomainInfo.jdField_a_of_type_JavaLangString);
      return paramDomainInfo;
    }
  }
  
  private void a(FileIPv6StrateyController.DomainInfo paramDomainInfo, FileIPv6Detecter.DomainDetectResult paramDomainDetectResult)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramDomainInfo.jdField_a_of_type_JavaLangString, paramDomainDetectResult);
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int k = 0;
    int i = 2;
    int j;
    label51:
    HashMap localHashMap;
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2)
    {
      j = 2;
      switch (QFileUtils.a())
      {
      default: 
        i = 0;
      case 3: 
        localHashMap = new HashMap();
        localHashMap.put("param_domain", String.valueOf(paramString1));
        localHashMap.put("param_ipAddr", String.valueOf(paramString2));
        localHashMap.put("param_port", String.valueOf(paramInt));
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (paramInt = k;; paramInt = 1)
    {
      localHashMap.put("param_result", String.valueOf(paramInt));
      localHashMap.put("param_stackType", String.valueOf(i));
      localHashMap.put("param_loginType", String.valueOf(j));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_JavaLangString, "actFAIPConnect", true, 0L, 0L, localHashMap, null);
      QLog.d("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] >> reportDetectConnResult:" + localHashMap.toString());
      return;
      j = 1;
      break;
      i = 1;
      break label51;
      i = 3;
      break label51;
    }
  }
  
  private boolean a(FileIPv6StrateyController.DomainInfo paramDomainInfo, FileIPv6StrateyController.IPInfo paramIPInfo)
  {
    if ((paramDomainInfo == null) || (TextUtils.isEmpty(paramDomainInfo.jdField_a_of_type_JavaLangString)) || (paramIPInfo == null) || (TextUtils.isEmpty(paramIPInfo.jdField_a_of_type_JavaLangString))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectDomainConn err. param=null");
    }
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start delectIP [" + paramDomainInfo.jdField_a_of_type_JavaLangString + ":" + paramDomainInfo.jdField_a_of_type_Int + "] ipInfo[" + paramIPInfo.jdField_a_of_type_JavaLangString + ":" + paramIPInfo.jdField_a_of_type_Int + "]");
      c();
    } while (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null);
    this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new FileIPv6Detecter.1(this, paramIPInfo, l, paramDomainInfo));
    return true;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 169	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter:jdField_a_of_type_JavaUtilConcurrentExecutor	Ljava/util/concurrent/Executor;
    //   6: ifnonnull +38 -> 44
    //   9: ldc 105
    //   11: iconst_1
    //   12: ldc 188
    //   14: invokestatic 164	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: new 190	com/tencent/mobileqq/app/ThreadPoolParams
    //   20: dup
    //   21: invokespecial 191	com/tencent/mobileqq/app/ThreadPoolParams:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: iconst_5
    //   27: putfield 194	com/tencent/mobileqq/app/ThreadPoolParams:priority	I
    //   30: aload_1
    //   31: ldc 196
    //   33: putfield 199	com/tencent/mobileqq/app/ThreadPoolParams:poolThreadName	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 205	com/tencent/mobileqq/app/ThreadManager:newFreeThreadPool	(Lcom/tencent/mobileqq/app/ThreadPoolParams;)Ljava/util/concurrent/Executor;
    //   41: putfield 169	com/tencent/mobileqq/filemanager/core/FileIPv6Detecter:jdField_a_of_type_JavaUtilConcurrentExecutor	Ljava/util/concurrent/Executor;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 105
    //   50: iconst_1
    //   51: new 107	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   58: ldc 207
    //   60: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 208	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 140	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: goto -32 -> 44
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	FileIPv6Detecter
    //   24	14	1	localThreadPoolParams	com.tencent.mobileqq.app.ThreadPoolParams
    //   47	17	1	localException	java.lang.Exception
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	44	47	java/lang/Exception
    //   2	17	79	finally
    //   17	44	79	finally
    //   48	76	79	finally
  }
  
  public void a()
  {
    b();
  }
  
  public void a(QQAppInterface paramQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, FileIPv6StrateyController.IPInfo paramIPInfo)
  {
    if ((paramDomainInfo == null) || (TextUtils.isEmpty(paramDomainInfo.jdField_a_of_type_JavaLangString)) || (paramIPInfo == null) || (TextUtils.isEmpty(paramIPInfo.jdField_a_of_type_JavaLangString))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] detectV6Domain err. param=null");
    }
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    }
    long l = System.currentTimeMillis();
    paramQQAppInterface = a(paramDomainInfo);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.jdField_a_of_type_Boolean) || (paramQQAppInterface.b)) {}
      while (l - paramQQAppInterface.jdField_a_of_type_Long <= 600000L) {
        return;
      }
    }
    if (a(paramDomainInfo, paramIPInfo))
    {
      paramQQAppInterface = new FileIPv6Detecter.DomainDetectResult(this);
      paramQQAppInterface.b = true;
      paramQQAppInterface.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6StrateyController$IPInfo = paramIPInfo;
      paramQQAppInterface.jdField_a_of_type_Long = l;
      a(paramDomainInfo, paramQQAppInterface);
      return;
    }
    QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectIP err");
  }
  
  public boolean a(FileIPv6StrateyController.DomainInfo paramDomainInfo)
  {
    paramDomainInfo = a(paramDomainInfo);
    if (paramDomainInfo != null) {
      return paramDomainInfo.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6Detecter
 * JD-Core Version:    0.7.0.1
 */