package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class QQFileIPv6StrateyController
  implements INetInfoHandler
{
  private FileIPv6Detecter a = new FileIPv6Detecter();
  private String b = "";
  private boolean c = false;
  private long d = 0L;
  private boolean e = false;
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private int j = 1;
  
  private BaseQQAppInterface a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    BaseQQAppInterface localBaseQQAppInterface = paramBaseQQAppInterface;
    if (paramBaseQQAppInterface == null) {
      localBaseQQAppInterface = QQFileManagerUtilImpl.l();
    }
    return localBaseQQAppInterface;
  }
  
  private FileIPv6StrateyController.IPInfo a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if ((paramString.contains("[")) && (paramString.contains("]")))
      {
        k = paramString.indexOf("[");
        int m = paramString.indexOf("]");
        if (m > k) {
          return new FileIPv6StrateyController.IPInfo(paramString.substring(k, m + 1), paramInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[IPv6-File] innerDnsIpPortStr2IPInfo err. ipPortStr:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      int k = paramString.lastIndexOf(":");
      if (k >= 0) {
        return new FileIPv6StrateyController.IPInfo(paramString.substring(0, k), paramInt);
      }
      localObject = new FileIPv6StrateyController.IPInfo(paramString, paramInt);
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label143:
      break label143;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[IPv6-File] innerDnsIpPortStr2IPInfo exp. ipPortStr:");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private FileIPv6StrateyController.IPListInfo a(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt, boolean paramBoolean)
  {
    List localList = a(paramBaseQQAppInterface, paramDomainInfo.a, paramDomainInfo.b, paramInt, paramBoolean);
    FileIPv6StrateyController.IPListInfo localIPListInfo = new FileIPv6StrateyController.IPListInfo();
    if ((localList != null) && (localList.size() != 0))
    {
      if ((!paramBoolean) && (!this.a.a(paramDomainInfo)))
      {
        this.a.a(paramBaseQQAppInterface, paramDomainInfo, (FileIPv6StrateyController.IPInfo)localList.get(0));
        return null;
      }
      localIPListInfo.a = 2;
      localIPListInfo.b = localList;
      return localIPListInfo;
    }
    i();
    localIPListInfo.a = 1;
    localIPListInfo.b.add(new FileIPv6StrateyController.IPInfo(paramDomainInfo.a, paramDomainInfo.b));
    return localIPListInfo;
  }
  
  private List<FileIPv6StrateyController.IPInfo> a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      boolean bool = false;
      Object localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).reqDnsForIpList(paramString, true, 28);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localArrayList = new ArrayList();
        int k;
        if (paramBoolean == true) {
          k = ((ArrayList)localObject).size();
        } else {
          k = 1;
        }
        a(localArrayList, (List)localObject, paramInt1, k);
        localObject = localArrayList.toString();
        paramBoolean = true;
      }
      else
      {
        localObject = "";
        paramBoolean = bool;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[IPv6-File] getIPv6ListByInnerDns[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" IPv6List[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.i("FileIPv6StrateyController<FileAssistant>", 1, localStringBuilder.toString());
      a(paramBaseQQAppInterface, paramBoolean, paramString, paramInt2);
      return localArrayList;
    }
    QLog.e("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. domain=null");
    return null;
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = b();
    int k = 2;
    int m;
    if (bool) {
      m = 2;
    } else {
      m = 1;
    }
    if (paramInt != 1)
    {
      if (paramInt != 3)
      {
        if (paramInt != 5)
        {
          if (paramInt != 7) {
            paramInt = 0;
          } else {
            paramInt = 3;
          }
        }
        else {
          paramInt = 4;
        }
      }
      else {
        paramInt = 2;
      }
    }
    else {
      paramInt = 1;
    }
    int n = QQFileUtilsImpl.a();
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3) {
          k = 0;
        }
      }
      else {
        k = 3;
      }
    }
    else {
      k = 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_domain", String.valueOf(paramString));
    localHashMap.put("param_result", String.valueOf(paramBoolean ^ true));
    localHashMap.put("param_stackType", String.valueOf(k));
    localHashMap.put("param_loginType", String.valueOf(m));
    localHashMap.put("param_bizType", String.valueOf(paramInt));
    paramString = this.b;
    if (paramBaseQQAppInterface != null) {
      paramString = paramBaseQQAppInterface.getCurrentAccountUin();
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "actFAIPDerect", true, 0L, 0L, localHashMap, null);
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append("[IPv6-File] >> reportInnerDnsResult:");
    paramBaseQQAppInterface.append(localHashMap.toString());
    QLog.d("FileIPv6StrateyController<FileAssistant>", 1, paramBaseQQAppInterface.toString());
  }
  
  private void a(List<FileIPv6StrateyController.IPInfo> paramList, List<String> paramList1, int paramInt1, int paramInt2)
  {
    if ((paramList1 != null) && (paramList1.size() != 0) && (paramList != null))
    {
      if (paramInt2 == 0) {
        return;
      }
      int k = 0;
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        Object localObject = (String)paramList1.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = a((String)localObject, paramInt1);
          if (localObject != null)
          {
            if (k >= paramInt2) {
              return;
            }
            paramList.add(localObject);
            k += 1;
          }
        }
      }
    }
  }
  
  private FileIPv6StrateyController.IPListInfo b(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt)
  {
    int k = c(paramBaseQQAppInterface);
    if (k == 0) {
      return null;
    }
    if (k == 1) {
      return a(paramBaseQQAppInterface, paramDomainInfo, paramInt, false);
    }
    if ((k == 2) && (b())) {
      return a(paramBaseQQAppInterface, paramDomainInfo, paramInt, false);
    }
    return null;
  }
  
  private boolean[] b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (1 == QQFileUtilsImpl.a()) {}
    int k;
    label9:
    int m;
    do
    {
      k = 0;
      m = 0;
      break;
      if (3 == QQFileUtilsImpl.a())
      {
        k = 1;
        m = 1;
        break;
      }
    } while ((2 != QQFileUtilsImpl.a()) || (c(paramBaseQQAppInterface) == 0));
    if (c(paramBaseQQAppInterface) == 1) {}
    for (;;)
    {
      k = 1;
      break label9;
      if ((c(paramBaseQQAppInterface) != 2) || (!b())) {
        break;
      }
    }
    return new boolean[] { k, m };
  }
  
  private int c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null) {
      return 0;
    }
    paramBaseQQAppInterface = (IQFileConfigManager)paramBaseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (paramBaseQQAppInterface == null) {
      return 0;
    }
    return paramBaseQQAppInterface.getFileIPv6Strategy();
  }
  
  private void i() {}
  
  public FileIPv6StrateyController.IPListInfo a(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt)
  {
    if (paramDomainInfo == null) {
      return null;
    }
    paramBaseQQAppInterface = a(paramBaseQQAppInterface);
    if (!b(paramBaseQQAppInterface, paramInt)) {
      return null;
    }
    if (paramBaseQQAppInterface != null) {
      this.b = paramBaseQQAppInterface.getCurrentUin();
    } else {
      QLog.w("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. app=null");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[IPv6-File] getIPlistForV6Domain on enable IPV6. busType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ipv6Domain:");
    localStringBuilder.append(paramDomainInfo.a);
    localStringBuilder.append(" port:");
    localStringBuilder.append(paramDomainInfo.b);
    localStringBuilder.append(" stacktype:");
    localStringBuilder.append(QQFileUtilsImpl.a());
    localStringBuilder.append(" isV6Login:");
    localStringBuilder.append(b());
    localStringBuilder.append(" stratey:");
    localStringBuilder.append(c(paramBaseQQAppInterface));
    QLog.i("FileIPv6StrateyController<FileAssistant>", 1, localStringBuilder.toString());
    if (1 == QQFileUtilsImpl.a()) {
      return null;
    }
    if (3 == QQFileUtilsImpl.a()) {
      return a(paramBaseQQAppInterface, paramDomainInfo, paramInt, true);
    }
    if (2 == QQFileUtilsImpl.a()) {
      return b(paramBaseQQAppInterface, paramDomainInfo, paramInt);
    }
    return null;
  }
  
  public List<ExcitingTransferHostInfo> a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    Object localObject1 = a(paramBaseQQAppInterface);
    if (!b((BaseQQAppInterface)localObject1, paramInt)) {
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[IPv6-File] getIPV6listForExcitingUpload on enable IPV6. busType:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" stacktype:");
    ((StringBuilder)localObject2).append(QQFileUtilsImpl.a());
    ((StringBuilder)localObject2).append(" isV6Login:");
    ((StringBuilder)localObject2).append(b());
    ((StringBuilder)localObject2).append(" stratey:");
    ((StringBuilder)localObject2).append(c((BaseQQAppInterface)localObject1));
    QLog.i("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    localObject1 = b((BaseQQAppInterface)localObject1);
    int k = localObject1[0];
    int m = localObject1[1];
    if (k != 0)
    {
      localObject1 = ((IExcitingTransferAdapter)paramBaseQQAppInterface.getRuntimeService(IExcitingTransferAdapter.class, "")).getBigDataHostList(true);
      if (localObject1 != null)
      {
        if (((List)localObject1).size() == 0) {
          return null;
        }
        if (m != 0) {
          return localObject1;
        }
        paramBaseQQAppInterface = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ExcitingTransferHostInfo)((Iterator)localObject1).next();
          if (paramBaseQQAppInterface.size() >= 1) {
            return paramBaseQQAppInterface;
          }
          paramBaseQQAppInterface.add(localObject2);
        }
        return paramBaseQQAppInterface;
      }
    }
    return null;
  }
  
  public List<String> a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      paramBaseQQAppInterface = a(paramBaseQQAppInterface);
      if (!b(paramBaseQQAppInterface, paramInt)) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[IPv6-File] getIPV6listForMediaPlatfrom on enable IPV6. busType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" stacktype:");
      ((StringBuilder)localObject).append(QQFileUtilsImpl.a());
      ((StringBuilder)localObject).append(" isV6Login:");
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(" stratey:");
      ((StringBuilder)localObject).append(c(paramBaseQQAppInterface));
      QLog.i("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      paramBaseQQAppInterface = b(paramBaseQQAppInterface);
      int k = paramBaseQQAppInterface[0];
      int m = paramBaseQQAppInterface[1];
      if (k != 0)
      {
        paramBaseQQAppInterface = new ArrayList();
        if (m != 0)
        {
          paramBaseQQAppInterface.addAll(paramList);
          return paramBaseQQAppInterface;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          if (paramBaseQQAppInterface.size() >= 1) {
            return paramBaseQQAppInterface;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBaseQQAppInterface.add(localObject);
          }
        }
        return paramBaseQQAppInterface;
      }
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new QQFileIPv6StrateyController.1(this));
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean b()
  {
    return MsfServiceSdk.get().getConnectedIPFamily() == 2;
  }
  
  public boolean b(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    if (a(paramBaseQQAppInterface) == null) {
      return false;
    }
    paramBaseQQAppInterface = (IQFileConfigManager)paramBaseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
    if (paramBaseQQAppInterface == null) {
      return false;
    }
    if (paramInt == 1) {
      return paramBaseQQAppInterface.getC2CFileIPv6Switch();
    }
    if (paramInt == 3) {
      return paramBaseQQAppInterface.getGroupFileIPv6Switch();
    }
    if (paramInt == 5) {
      return false;
    }
    if (paramInt == 7) {
      return paramBaseQQAppInterface.getDatalineFileIPv6Switch();
    }
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public void e(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public boolean g()
  {
    return this.i;
  }
  
  public int h()
  {
    return this.j;
  }
  
  public void onNetMobile2None()
  {
    this.a.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.a.a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.a();
  }
  
  public void onNetWifi2None()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController
 * JD-Core Version:    0.7.0.1
 */