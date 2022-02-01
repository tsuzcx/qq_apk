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
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private FileIPv6Detecter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter = new FileIPv6Detecter();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  
  private int a(BaseQQAppInterface paramBaseQQAppInterface)
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
  
  private BaseQQAppInterface a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    BaseQQAppInterface localBaseQQAppInterface = paramBaseQQAppInterface;
    if (paramBaseQQAppInterface == null) {
      localBaseQQAppInterface = QQFileManagerUtilImpl.a();
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
        i = paramString.indexOf("[");
        int j = paramString.indexOf("]");
        if (j > i) {
          return new FileIPv6StrateyController.IPInfo(paramString.substring(i, j + 1), paramInt);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[IPv6-File] innerDnsIpPortStr2IPInfo err. ipPortStr:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        return null;
      }
      int i = paramString.lastIndexOf(":");
      if (i >= 0) {
        return new FileIPv6StrateyController.IPInfo(paramString.substring(0, i), paramInt);
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
    List localList = a(paramBaseQQAppInterface, paramDomainInfo.jdField_a_of_type_JavaLangString, paramDomainInfo.jdField_a_of_type_Int, paramInt, paramBoolean);
    FileIPv6StrateyController.IPListInfo localIPListInfo = new FileIPv6StrateyController.IPListInfo();
    if ((localList != null) && (localList.size() != 0))
    {
      if ((!paramBoolean) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a(paramDomainInfo)))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a(paramBaseQQAppInterface, paramDomainInfo, (FileIPv6StrateyController.IPInfo)localList.get(0));
        return null;
      }
      localIPListInfo.jdField_a_of_type_Int = 2;
      localIPListInfo.jdField_a_of_type_JavaUtilList = localList;
      return localIPListInfo;
    }
    b();
    localIPListInfo.jdField_a_of_type_Int = 1;
    localIPListInfo.jdField_a_of_type_JavaUtilList.add(new FileIPv6StrateyController.IPInfo(paramDomainInfo.jdField_a_of_type_JavaLangString, paramDomainInfo.jdField_a_of_type_Int));
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
        int i;
        if (paramBoolean == true) {
          i = ((ArrayList)localObject).size();
        } else {
          i = 1;
        }
        a(localArrayList, (List)localObject, paramInt1, i);
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
    boolean bool = a();
    int i = 2;
    int j;
    if (bool) {
      j = 2;
    } else {
      j = 1;
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
    localHashMap.put("param_domain", String.valueOf(paramString));
    localHashMap.put("param_result", String.valueOf(paramBoolean ^ true));
    localHashMap.put("param_stackType", String.valueOf(i));
    localHashMap.put("param_loginType", String.valueOf(j));
    localHashMap.put("param_bizType", String.valueOf(paramInt));
    paramString = this.jdField_a_of_type_JavaLangString;
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
      int i = 0;
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        Object localObject = (String)paramList1.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = a((String)localObject, paramInt1);
          if (localObject != null)
          {
            if (i >= paramInt2) {
              return;
            }
            paramList.add(localObject);
            i += 1;
          }
        }
      }
    }
  }
  
  private boolean[] a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (1 == QQFileUtilsImpl.a()) {}
    int i;
    label9:
    int j;
    do
    {
      i = 0;
      j = 0;
      break;
      if (3 == QQFileUtilsImpl.a())
      {
        i = 1;
        j = 1;
        break;
      }
    } while ((2 != QQFileUtilsImpl.a()) || (a(paramBaseQQAppInterface) == 0));
    if (a(paramBaseQQAppInterface) == 1) {}
    for (;;)
    {
      i = 1;
      break label9;
      if ((a(paramBaseQQAppInterface) != 2) || (!a())) {
        break;
      }
    }
    return new boolean[] { i, j };
  }
  
  private FileIPv6StrateyController.IPListInfo b(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt)
  {
    int i = a(paramBaseQQAppInterface);
    if (i == 0) {
      return null;
    }
    if (i == 1) {
      return a(paramBaseQQAppInterface, paramDomainInfo, paramInt, false);
    }
    if ((i == 2) && (a())) {
      return a(paramBaseQQAppInterface, paramDomainInfo, paramInt, false);
    }
    return null;
  }
  
  private void b() {}
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FileIPv6StrateyController.IPListInfo a(BaseQQAppInterface paramBaseQQAppInterface, FileIPv6StrateyController.DomainInfo paramDomainInfo, int paramInt)
  {
    if (paramDomainInfo == null) {
      return null;
    }
    paramBaseQQAppInterface = a(paramBaseQQAppInterface);
    if (!a(paramBaseQQAppInterface, paramInt)) {
      return null;
    }
    if (paramBaseQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = paramBaseQQAppInterface.getCurrentUin();
    } else {
      QLog.w("FileIPv6StrateyController<FileAssistant>", 1, "[IPv6-File] getIPv6ListByInnerDns err. app=null");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[IPv6-File] getIPlistForV6Domain on enable IPV6. busType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ipv6Domain:");
    localStringBuilder.append(paramDomainInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" port:");
    localStringBuilder.append(paramDomainInfo.jdField_a_of_type_Int);
    localStringBuilder.append(" stacktype:");
    localStringBuilder.append(QQFileUtilsImpl.a());
    localStringBuilder.append(" isV6Login:");
    localStringBuilder.append(a());
    localStringBuilder.append(" stratey:");
    localStringBuilder.append(a(paramBaseQQAppInterface));
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
    if (!a((BaseQQAppInterface)localObject1, paramInt)) {
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[IPv6-File] getIPV6listForExcitingUpload on enable IPV6. busType:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" stacktype:");
    ((StringBuilder)localObject2).append(QQFileUtilsImpl.a());
    ((StringBuilder)localObject2).append(" isV6Login:");
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append(" stratey:");
    ((StringBuilder)localObject2).append(a((BaseQQAppInterface)localObject1));
    QLog.i("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    localObject1 = a((BaseQQAppInterface)localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    if (i != 0)
    {
      localObject1 = ((IExcitingTransferAdapter)paramBaseQQAppInterface.getRuntimeService(IExcitingTransferAdapter.class, "")).getBigDataHostList(true);
      if (localObject1 != null)
      {
        if (((List)localObject1).size() == 0) {
          return null;
        }
        if (j != 0) {
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
      if (!a(paramBaseQQAppInterface, paramInt)) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[IPv6-File] getIPV6listForMediaPlatfrom on enable IPV6. busType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" stacktype:");
      ((StringBuilder)localObject).append(QQFileUtilsImpl.a());
      ((StringBuilder)localObject).append(" isV6Login:");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(" stratey:");
      ((StringBuilder)localObject).append(a(paramBaseQQAppInterface));
      QLog.i("FileIPv6StrateyController<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      paramBaseQQAppInterface = a(paramBaseQQAppInterface);
      int i = paramBaseQQAppInterface[0];
      int j = paramBaseQQAppInterface[1];
      if (i != 0)
      {
        paramBaseQQAppInterface = new ArrayList();
        if (j != 0)
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
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return MsfServiceSdk.get().getConnectedIPFamily() == 2;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
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
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public void onNetMobile2None()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a();
  }
  
  public void onNetWifi2None()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileIPv6Detecter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QQFileIPv6StrateyController
 * JD-Core Version:    0.7.0.1
 */