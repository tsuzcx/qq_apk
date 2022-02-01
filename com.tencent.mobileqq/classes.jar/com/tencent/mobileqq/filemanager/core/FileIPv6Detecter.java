package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class FileIPv6Detecter
{
  private Map<String, FileIPv6Detecter.DomainDetectResult> a = new HashMap();
  private Executor b;
  private String c = "";
  private long d = 0L;
  
  private void a(FileIPv6StrateyController.DomainInfo paramDomainInfo, FileIPv6Detecter.DomainDetectResult paramDomainDetectResult)
  {
    synchronized (this.a)
    {
      this.a.put(paramDomainInfo.a, paramDomainDetectResult);
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int j = MsfServiceSdk.get().getConnectedIPFamily();
    int i = 2;
    if (j == 2) {
      j = 2;
    } else {
      j = 1;
    }
    int k = QQFileUtilsImpl.a();
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3) {
          i = 0;
        }
      }
      else {
        i = 3;
      }
    }
    else {
      i = 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_domain", String.valueOf(paramString1));
    localHashMap.put("param_ipAddr", String.valueOf(paramString2));
    localHashMap.put("param_port", String.valueOf(paramInt));
    localHashMap.put("param_result", String.valueOf(paramBoolean ^ true));
    localHashMap.put("param_stackType", String.valueOf(i));
    localHashMap.put("param_loginType", String.valueOf(j));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.c, "actFAIPConnect", true, 0L, 0L, localHashMap, null);
    paramString1 = new StringBuilder();
    paramString1.append("[IPv6-File] >> reportDetectConnResult:");
    paramString1.append(localHashMap.toString());
    QLog.d("FileIPv6Detecter<FileAssistant>", 1, paramString1.toString());
  }
  
  private boolean a(FileIPv6StrateyController.DomainInfo paramDomainInfo, FileIPv6StrateyController.IPInfo paramIPInfo)
  {
    if ((paramDomainInfo != null) && (!TextUtils.isEmpty(paramDomainInfo.a)) && (paramIPInfo != null) && (!TextUtils.isEmpty(paramIPInfo.a)))
    {
      long l = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[IPv6-File] start delectIP [");
      ((StringBuilder)localObject).append(paramDomainInfo.a);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramDomainInfo.b);
      ((StringBuilder)localObject).append("] ipInfo[");
      ((StringBuilder)localObject).append(paramIPInfo.a);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramIPInfo.b);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      c();
      localObject = this.b;
      if (localObject == null) {
        return false;
      }
      ((Executor)localObject).execute(new FileIPv6Detecter.1(this, paramIPInfo, l, paramDomainInfo));
      return true;
    }
    QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectDomainConn err. param=null");
    return false;
  }
  
  private FileIPv6Detecter.DomainDetectResult b(FileIPv6StrateyController.DomainInfo paramDomainInfo)
  {
    if ((paramDomainInfo != null) && (paramDomainInfo.a != null)) {
      synchronized (this.a)
      {
        paramDomainInfo = (FileIPv6Detecter.DomainDetectResult)this.a.get(paramDomainInfo.a);
        return paramDomainInfo;
      }
    }
    return null;
  }
  
  private void b()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
  
  private void c()
  {
    try
    {
      if (this.b == null)
      {
        QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start conn pool");
        try
        {
          ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
          localThreadPoolParams.priority = 5;
          localThreadPoolParams.poolThreadName = "IPv6ConnDelectPool";
          this.b = ThreadManager.newFreeThreadPool(localThreadPoolParams);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[IPv6-File] start conn pool exception:");
          localStringBuilder.append(localException.toString());
          QLog.e("FileIPv6Detecter<FileAssistant>", 1, localStringBuilder.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    b();
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, FileIPv6StrateyController.IPInfo paramIPInfo)
  {
    if ((paramDomainInfo == null) || (TextUtils.isEmpty(paramDomainInfo.a)) || (paramIPInfo == null) || (TextUtils.isEmpty(paramIPInfo.a))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] detectV6Domain err. param=null");
    }
    if (paramBaseQQAppInterface != null) {
      this.c = paramBaseQQAppInterface.getCurrentUin();
    }
    long l = System.currentTimeMillis();
    paramBaseQQAppInterface = b(paramDomainInfo);
    if (paramBaseQQAppInterface != null) {
      if (!paramBaseQQAppInterface.a)
      {
        if (paramBaseQQAppInterface.b) {
          return;
        }
        if (l - paramBaseQQAppInterface.d > 600000L) {}
      }
      else
      {
        return;
      }
    }
    if (a(paramDomainInfo, paramIPInfo))
    {
      paramBaseQQAppInterface = new FileIPv6Detecter.DomainDetectResult(this);
      paramBaseQQAppInterface.b = true;
      paramBaseQQAppInterface.c = paramIPInfo;
      paramBaseQQAppInterface.d = l;
      a(paramDomainInfo, paramBaseQQAppInterface);
      return;
    }
    QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectIP err");
  }
  
  public boolean a(FileIPv6StrateyController.DomainInfo paramDomainInfo)
  {
    paramDomainInfo = b(paramDomainInfo);
    if (paramDomainInfo != null) {
      return paramDomainInfo.a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6Detecter
 * JD-Core Version:    0.7.0.1
 */