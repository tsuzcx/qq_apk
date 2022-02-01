package com.tencent.mobileqq.config;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;

public class AboutConfig
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Hashtable<String, ResourcePluginInfo> jdField_a_of_type_JavaUtilHashtable;
  private List<ResourcePluginListener> jdField_a_of_type_JavaUtilList;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new AboutConfig.2(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  public AboutConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  }
  
  private Hashtable<String, ResourcePluginInfo> a()
  {
    Hashtable localHashtable = new Hashtable();
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tencent.help_5_8";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693138);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 0;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "https://kf.qq.com/touch/scene_product.html?scene_id=kf180";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tencent.Feedback_5_8";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692258);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 0;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "https://mma.qq.com/feedback/index.html";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    return localHashtable;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig localAboutConfig = paramQQAppInterface.getAboutConfig();
    Object localObject2 = paramResourcePluginInfo.strGotoUrl;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("version=8.7.0.5295&appid=");
    ((StringBuilder)localObject1).append(AppSetting.a());
    ((StringBuilder)localObject1).append("&QUA=");
    ((StringBuilder)localObject1).append(QZoneHelper.getQUA());
    localObject1 = ((StringBuilder)localObject1).toString();
    if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject3 = localObject1;
      if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {}
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("&adtag=5295");
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("#_rc=mqq_faq_feedback")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 21);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append((String)localObject3);
      localObject3 = ((StringBuilder)localObject1).toString();
      localObject1 = localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append((String)localObject3);
    Object localObject3 = ((StringBuilder)localObject2).toString();
    if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject2 = localObject3;
      if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("feedfack before: url = ");
          ((StringBuilder)localObject1).append((String)localObject3);
          QLog.i("About-Feedback", 2, ((StringBuilder)localObject1).toString());
        }
        else if (paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("help before: url = ");
          ((StringBuilder)localObject1).append((String)localObject3);
          QLog.i("About-Help", 2, ((StringBuilder)localObject1).toString());
        }
      }
      localObject1 = Build.MODEL;
      if (localObject1 != null) {
        localObject1 = ((String)localObject1).replaceAll(" ", "_");
      } else {
        localObject1 = "";
      }
      int i = StatisticCollector.getQzonePatchTag();
      localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("_qzpatch");
        ((StringBuilder)localObject2).append(i);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = Build.MANUFACTURER;
      if (localObject1 != null) {
        localObject1 = ((String)localObject1).replaceAll(" ", "_");
      } else {
        localObject1 = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("&model=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("&manufacture=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("&cpunum=");
      localStringBuilder.append(DeviceInfoUtil.b());
      localStringBuilder.append("&cpurate=");
      localStringBuilder.append(DeviceInfoUtil.b());
      localStringBuilder.append("&mem=");
      localStringBuilder.append(DeviceInfoUtil.a() / 1024L / 1024L);
      localStringBuilder.append("&amem=");
      localStringBuilder.append(DeviceInfoUtil.e() / 1024L / 1024L);
      localStringBuilder.append("&w=");
      localStringBuilder.append(DeviceInfoUtil.g());
      localStringBuilder.append("&h=");
      localStringBuilder.append(DeviceInfoUtil.h());
      localStringBuilder.append("&pss=");
      localStringBuilder.append(MemoryManager.a(Process.myPid()) / 1024L / 1024L);
      localStringBuilder.append("&heapmax=");
      localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
      localStringBuilder.append("&heapsize=");
      localStringBuilder.append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L / 1024L);
      localStringBuilder.append("&sysver=");
      localStringBuilder.append(Build.VERSION.RELEASE);
      localStringBuilder.append("&user_tag=");
      localStringBuilder.append(QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL()));
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("#_rc=mqq_faq_feedback");
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if (4 != QLog.getUIN_REPORTLOG_LEVEL())
        {
          QLog.setUIN_REPORTLOG_LEVEL(4);
          localObject3 = MsfStore.getNativeConfigStore();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            ((NativeConfigStore)localObject3).setConfig("LOGLEVEL_", "4");
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(System.currentTimeMillis());
            ((NativeConfigStore)localObject3).setConfig("LOGLEVELTIME", ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel()) {
        if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("feedfack after: url = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("About-Feedback", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if (paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("help after: url = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("About-Help", 2, ((StringBuilder)localObject2).toString());
            localObject2 = localObject1;
          }
        }
      }
    }
    localObject1 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("portraitOnly", true);
    ((Intent)localObject1).putExtra("url", (String)localObject2).putExtra("bFormatUrl", false);
    ((Intent)localObject1).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    if ((paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) || (paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))) {
      ((Intent)localObject1).putExtra("reportMsfLog", true);
    }
    try
    {
      paramContext.startActivity((Intent)localObject1);
      label1167:
      if (paramResourcePluginInfo.isNew == 0)
      {
        paramResourcePluginInfo.isNew = 1;
        ThreadManager.post(new AboutConfig.3(localAboutConfig, paramResourcePluginInfo), 8, null, false);
      }
      return;
    }
    catch (SecurityException paramQQAppInterface)
    {
      break label1167;
    }
  }
  
  private void a(List<ResourcePluginInfo> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilHashtable != null) && (paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramList.next();
        this.jdField_a_of_type_JavaUtilHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
      }
    }
  }
  
  private void c()
  {
    Hashtable localHashtable = this.jdField_a_of_type_JavaUtilHashtable;
    if (localHashtable != null) {
      localHashtable.clear();
    }
  }
  
  public ResourcePluginInfo a(String paramString)
  {
    return (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().widthPixels;
    int i = 0;
    boolean bool;
    if (j >= 480) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    a(false, true);
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ResourcePluginListener.a((ResourcePluginListener)this.jdField_a_of_type_JavaUtilList.get(i), (byte)1, 2);
      i += 1;
    }
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (!this.b) {
      a(true, false);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilHashtable;
    if (localObject != null)
    {
      localObject = ((Hashtable)((Hashtable)localObject).clone()).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)((Iterator)localObject).next();
        if (localResourcePluginInfo.cDataType == 0)
        {
          GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
          localGetResourceReqInfoV2.cState = 0;
          localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
          localGetResourceReqInfoV2.sResSubType = 0;
          localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
          localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
          localArrayList.add(localGetResourceReqInfoV2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendAboutConfig");
      ((StringBuilder)localObject).append(localArrayList.size());
      ((StringBuilder)localObject).append(",hasLoadFromDB=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramPluginConfigProxy.a(32, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
  }
  
  /* Error */
  public void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +92 -> 98
    //   9: aload_1
    //   10: ifnull +88 -> 98
    //   13: aload_2
    //   14: aload_1
    //   15: getfield 53	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   18: invokevirtual 503	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +77 -> 98
    //   24: aload_0
    //   25: getfield 41	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   28: aload_1
    //   29: getfield 53	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   32: invokevirtual 426	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 46	com/tencent/mobileqq/data/ResourcePluginInfo
    //   38: astore_2
    //   39: aload_2
    //   40: aload_1
    //   41: getfield 91	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   44: putfield 91	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   47: aload_2
    //   48: aload_1
    //   49: getfield 97	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   52: putfield 97	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   55: aload_0
    //   56: getfield 31	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   59: invokevirtual 507	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   62: invokevirtual 513	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   65: astore_1
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic 517	com/tencent/mobileqq/data/ResourcePluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/ResourcePluginInfo;)V
    //   71: aload_1
    //   72: ifnull +26 -> 98
    //   75: aload_1
    //   76: invokevirtual 522	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   79: return
    //   80: astore_2
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 522	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   89: aload_2
    //   90: athrow
    //   91: aload_1
    //   92: ifnull +6 -> 98
    //   95: goto -20 -> 75
    //   98: return
    //   99: astore_2
    //   100: goto -9 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	AboutConfig
    //   0	103	1	paramResourcePluginInfo	ResourcePluginInfo
    //   4	64	2	localObject1	Object
    //   80	10	2	localObject2	Object
    //   99	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   66	71	80	finally
    //   66	71	99	java/lang/Exception
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramResourcePluginListener);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAboutConfig, isfore=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",asynchronous=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("AboutConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "error happens: loadAboutConfig while current account is null, which means there is no logined account now");
      }
      return;
    }
    if (!paramBoolean1)
    {
      localObject = this.jdField_a_of_type_JavaUtilHashtable;
      if ((localObject != null) && (((Hashtable)localObject).size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AboutConfig", 2, "there has about data in memory cache, do not need load from DB");
        }
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilHashtable = a();
    Object localObject = new AboutConfig.1(this, paramBoolean2);
    if (paramBoolean2)
    {
      ThreadManager.post((Runnable)localObject, 5, null, false);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public void b()
  {
    Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 2);
    }
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramResourcePluginListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig
 * JD-Core Version:    0.7.0.1
 */