package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaItemFilterProxy;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class LebaShowListManager
{
  public static volatile int a;
  protected static volatile LebaShowListManager a;
  private static final Object a;
  public LebaItemFilterProxy a;
  public HashMap<String, LebaViewItem> a;
  public List<LebaViewItem> a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private LebaShowListManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaItemFilterProxy = new LebaItemFilterProxy();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Int = 0;
    b();
  }
  
  public static LebaShowListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLebaCoreLebaShowListManager == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqLebaCoreLebaShowListManager == null) {
          jdField_a_of_type_ComTencentMobileqqLebaCoreLebaShowListManager = new LebaShowListManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqLebaCoreLebaShowListManager;
  }
  
  public LebaViewItem a(long paramLong)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == paramLong) {
        return localLebaViewItem;
      }
    }
    return null;
  }
  
  public List<LebaViewItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaItemFilterProxy.a(localLebaViewItem)) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.cDataType != 1)) {
          localArrayList.add(localLebaViewItem);
        }
      }
      LebaUtil.a(localArrayList);
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<LebaViewItem> a(AppRuntime paramAppRuntime)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = a();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      StringBuffer localStringBuffer = new StringBuffer("getLebaShowList,");
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaItemFilterProxy.a(paramAppRuntime, localStringBuffer, localLebaViewItem))) {
          a(bool, localLebaViewItem, localArrayList);
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("alldatasize=");
        localStringBuffer.append(this.jdField_a_of_type_JavaUtilList.size());
        localStringBuffer.append(", result");
        localStringBuffer.append(LebaViewItem.a(localArrayList));
        QLog.i("Q.lebatab.mgr", 2, localStringBuffer.toString());
      }
      LebaUtil.a(localArrayList);
      return localArrayList;
    }
    for (;;)
    {
      throw paramAppRuntime;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(List<BusinessInfoCheckUpdate.AppSetting> paramList)
  {
    if (paramList != null) {
      if (paramList.size() == 0) {
        return;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
          if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null)) {
            continue;
          }
          long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
          if (l == 0L) {
            continue;
          }
          Object localObject = paramList.iterator();
          if (!((Iterator)localObject).hasNext()) {
            continue;
          }
          BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject).next();
          if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
            continue;
          }
          if (!localAppSetting.setting.get()) {
            break label258;
          }
          b = 0;
          localLebaViewItem.jdField_a_of_type_Byte = b;
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateAllLebaListFlag, name = ");
            ((StringBuilder)localObject).append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
            ((StringBuilder)localObject).append(" cCurFlag:");
            ((StringBuilder)localObject).append(localLebaViewItem.jdField_a_of_type_Byte);
            QLog.i("Q.lebatab.mgr", 4, ((StringBuilder)localObject).toString());
          }
          localLebaViewItem.b = localAppSetting.modify_ts.get();
          continue;
        }
        return;
      }
      return;
      label258:
      byte b = 1;
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      if (localLebaViewItem != null) {
        if (localLebaViewItem.jdField_a_of_type_Byte == 0)
        {
          if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) {
            ReportController.b(paramAppRuntime, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), "", "");
          }
        }
        else if ((localLebaViewItem.jdField_a_of_type_Byte == 1) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null)) {
          ReportController.b(paramAppRuntime, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), "", "");
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    a(paramAppRuntime, paramLong1, paramBoolean, paramLong2, paramLong3, false);
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, boolean paramBoolean2)
  {
    int i;
    label291:
    label297:
    label304:
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      LebaViewItem localLebaViewItem;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      } while ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != paramLong1));
      if (paramBoolean1)
      {
        i = 0;
        localLebaViewItem.jdField_a_of_type_Byte = ((byte)i);
        if (paramLong3 == -9223372036854775808L)
        {
          localLebaViewItem.b = paramLong2;
          break label291;
        }
        if (paramLong2 != localLebaViewItem.b) {
          break label297;
        }
        localLebaViewItem.b = paramLong3;
        break label291;
        if (!QLog.isDevelopLevel()) {
          break label304;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateAppSetting, name = ");
        ((StringBuilder)localObject).append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        ((StringBuilder)localObject).append(" status:");
        ((StringBuilder)localObject).append(paramBoolean1);
        QLog.i("Q.lebatab.mgr", 4, ((StringBuilder)localObject).toString());
        break label304;
        if ((paramAppRuntime != null) && (i == 1)) {
          ThreadManager.post(new LebaShowListManager.1(this, paramAppRuntime, paramLong1, paramBoolean1, paramLong3, paramLong2, paramBoolean2), 5, null, true);
        }
        if (QLog.isDevelopLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("updateAppSetting, ret = ");
          paramAppRuntime.append(i);
          QLog.i("Q.lebatab.mgr", 4, paramAppRuntime.toString());
        }
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, List<LebaViewItem> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
  {
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("setAllLebaList, ");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)???).append(i);
      QLog.i("Q.lebatab.mgr", 4, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      a(paramList1);
      LebaSettingHandlerApi.a(paramAppRuntime, 1, true, null);
      return;
    }
  }
  
  public void a(boolean paramBoolean, LebaViewItem paramLebaViewItem, List<LebaViewItem> paramList)
  {
    if (paramBoolean)
    {
      if ((paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.showInSimpleMode != 0) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 0L)) {
        paramList.add(paramLebaViewItem);
      }
    }
    else if ((paramLebaViewItem.jdField_a_of_type_Byte == 0) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 0L)) {
      paramList.add(paramLebaViewItem);
    }
  }
  
  public boolean a()
  {
    return QQTheme.f();
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      LebaViewItem localLebaViewItem;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      } while ((localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != paramLong));
      bool1 = bool2;
      if (localLebaViewItem.jdField_a_of_type_Byte == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public List<LebaViewItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != 905L) && ((localLebaViewItem.jdField_a_of_type_Byte == 0) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId == 0L))) {
          localArrayList.add(localLebaViewItem);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<LebaViewItem> b(AppRuntime paramAppRuntime)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), paramAppRuntime }));
    }
    ArrayList localArrayList = new ArrayList();
    List localList = null;
    Object localObject1 = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
    if (localObject1 != null) {
      localList = ((ILebaHelperService)localObject1).getLebaConfigList();
    } else {
      QLog.d("LebaShowListManager", 1, "reloadLebaItems lebaHelperService == null");
    }
    if (localList != null)
    {
      Object localObject2 = new ArrayList(localList);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((Iterator)localObject2).next();
        if (localLebaPluginInfo != null)
        {
          LebaViewItem localLebaViewItem = new LebaViewItem();
          try
          {
            localLebaViewItem.jdField_a_of_type_Long = localLebaPluginInfo.uiResId;
            localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo = localLebaPluginInfo;
            if (LebaUtil.a(localLebaViewItem))
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName, localLebaViewItem);
              continue;
            }
            ((List)localObject1).add(localLebaViewItem);
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.mgr", 2, localException.toString());
          }
        }
      }
      Collections.sort((List)localObject1, new LebaUtil.LebaItemComparator());
      a(paramAppRuntime, (List)localObject1, ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).requestSettingInfoList());
      paramAppRuntime = a(paramAppRuntime);
      LebaUtil.a(localArrayList, paramAppRuntime);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reloadLebaItems, info.size=");
        ((StringBuilder)localObject1).append(localList.size());
        ((StringBuilder)localObject1).append(", alldatasize=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.size());
        ((StringBuilder)localObject1).append(", pluginShowList=");
        ((StringBuilder)localObject1).append(paramAppRuntime.size());
        QLog.i("Q.lebatab.mgr", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaItemFilterProxy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaShowListManager
 * JD-Core Version:    0.7.0.1
 */