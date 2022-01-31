package com.tencent.mobileqq.config;

import absl;
import absm;
import absn;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private List jdField_a_of_type_JavaUtilList;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new absm(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public AboutConfig(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  }
  
  private Hashtable a()
  {
    Hashtable localHashtable = new Hashtable();
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.aboutfunction";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435378);
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://fwd.3g.qq.com:8080/forward.jsp?bid=942";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.aboutimage";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435380);
    localResourcePluginInfo.strResURL = "";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "http://fwd.3g.qq.com:8080/forward.jsp?bid=943";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tencent.help_5_8";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433516);
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
    localResourcePluginInfo.strGotoUrl = "http://kf.qq.com/touch/product/mobileqq_platform_app.html?scene_id=kf180";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tencent.Feedback_5_8";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437476);
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
    localResourcePluginInfo.strGotoUrl = "http://mma.qq.com/feedback/index.html";
    localResourcePluginInfo.iPluginType = 32;
    localHashtable.put(localResourcePluginInfo.strPkgName, localResourcePluginInfo);
    return localHashtable;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ResourcePluginInfo paramResourcePluginInfo)
  {
    AboutConfig localAboutConfig = paramQQAppInterface.a();
    Object localObject2 = paramResourcePluginInfo.strGotoUrl;
    Object localObject1 = "version=7.6.3.3560&appid=" + AppSetting.a + "&QUA=" + QZoneHelper.a();
    Object localObject3;
    if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject3 = localObject1;
      if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {}
    }
    else
    {
      localObject3 = (String)localObject1 + "&adtag=3560";
    }
    if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
    {
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("#_rc=mqq_faq_feedback")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - "#_rc=mqq_faq_feedback".length());
      }
      localObject3 = "?" + (String)localObject3;
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = (String)localObject2 + (String)localObject1;
      if ((!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) && (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))) {
        break label998;
      }
      if (QLog.isColorLevel())
      {
        if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
          break label886;
        }
        QLog.i("About-Feedback", 2, "feedfack before: url = " + (String)localObject3);
      }
      label261:
      localObject1 = Build.MODEL;
      if (localObject1 == null) {
        break label929;
      }
      localObject1 = ((String)localObject1).replaceAll(" ", "_");
      label282:
      int i = StatisticCollector.a();
      localObject2 = localObject1;
      if (i > 0) {
        localObject2 = (String)localObject1 + "_qzpatch" + i;
      }
      localObject1 = Build.MANUFACTURER;
      if (localObject1 == null) {
        break label936;
      }
      localObject1 = ((String)localObject1).replaceAll(" ", "_");
      label341:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject3).append("&model=").append((String)localObject2).append("&manufacture=").append((String)localObject1).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.e() / 1024L / 1024L).append("&amem=").append(DeviceInfoUtil.f() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.h()).append("&h=").append(DeviceInfoUtil.i()).append("&pss=").append(MemoryManager.a(Process.myPid()) / 1024L / 1024L).append("&heapmax=").append(Runtime.getRuntime().maxMemory() / 1024L / 1024L).append("&heapsize=").append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L / 1024L).append("&sysver=").append(Build.VERSION.RELEASE).append("&user_tag=").append(QLog.getReportLevel(QLog.getUIN_REPORTLOG_LEVEL()));
      localObject2 = localStringBuilder.toString();
      localObject1 = localObject2;
      if (paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8"))
      {
        localObject2 = (String)localObject2 + "#_rc=mqq_faq_feedback";
        localObject1 = localObject2;
        if (4 != QLog.getUIN_REPORTLOG_LEVEL())
        {
          QLog.setUIN_REPORTLOG_LEVEL(4);
          localObject3 = MsfStore.getNativeConfigStore();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            ((NativeConfigStore)localObject3).setConfig("LOGLEVEL_", "4");
            ((NativeConfigStore)localObject3).setConfig("LOGLEVELTIME", "" + System.currentTimeMillis());
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.Feedback_5_8")) {
          break label943;
        }
        QLog.i("About-Feedback", 2, "feedfack after: url = " + (String)localObject1);
      }
    }
    label830:
    label998:
    for (localObject2 = localObject1;; localObject2 = localObject3) {
      for (;;)
      {
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
          if (paramResourcePluginInfo.isNew == 0)
          {
            paramResourcePluginInfo.isNew = 1;
            ThreadManager.post(new absn(localAboutConfig, paramResourcePluginInfo), 8, null, false);
          }
          return;
          localObject1 = "&" + (String)localObject3;
          break;
          label886:
          if (!paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8")) {
            break label261;
          }
          QLog.i("About-Help", 2, "help before: url = " + (String)localObject3);
          break label261;
          localObject1 = "";
          break label282;
          localObject1 = "";
          break label341;
          localObject2 = localObject1;
          if (paramResourcePluginInfo.strPkgName.equals("com.tencent.help_5_8"))
          {
            QLog.i("About-Help", 2, "help after: url = " + (String)localObject1);
            localObject2 = localObject1;
          }
        }
        catch (SecurityException paramQQAppInterface)
        {
          break label830;
        }
      }
    }
  }
  
  private void a(List paramList)
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
    if (this.jdField_a_of_type_JavaUtilHashtable != null) {
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public ResourcePluginInfo a(String paramString)
  {
    return (ResourcePluginInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
  }
  
  public void a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().widthPixels >= 480) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      a(false, true);
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ResourcePluginListener.a((ResourcePluginListener)this.jdField_a_of_type_JavaUtilList.get(i), (byte)1, 2);
        i += 1;
      }
    }
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (!this.b) {
      a(true, false);
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilHashtable != null)
    {
      Iterator localIterator = ((Hashtable)this.jdField_a_of_type_JavaUtilHashtable.clone()).values().iterator();
      while (localIterator.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
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
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "sendAboutConfig" + localArrayList.size() + ",hasLoadFromDB=" + this.b);
    }
    paramPluginConfigProxy.a(32, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramResourcePluginListener);
    }
  }
  
  /* Error */
  public void a(ResourcePluginInfo paramResourcePluginInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   4: ifnull +76 -> 80
    //   7: aload_1
    //   8: ifnull +72 -> 80
    //   11: aload_0
    //   12: getfield 37	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   15: aload_1
    //   16: getfield 49	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   19: invokevirtual 510	java/util/Hashtable:containsKey	(Ljava/lang/Object;)Z
    //   22: ifeq +58 -> 80
    //   25: aload_0
    //   26: getfield 37	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_JavaUtilHashtable	Ljava/util/Hashtable;
    //   29: aload_1
    //   30: getfield 49	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   33: invokevirtual 428	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 42	com/tencent/mobileqq/data/ResourcePluginInfo
    //   39: astore_2
    //   40: aload_2
    //   41: aload_1
    //   42: getfield 84	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   45: putfield 84	com/tencent/mobileqq/data/ResourcePluginInfo:cLocalState	B
    //   48: aload_2
    //   49: aload_1
    //   50: getfield 90	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   53: putfield 90	com/tencent/mobileqq/data/ResourcePluginInfo:isNew	B
    //   56: aload_0
    //   57: getfield 27	com/tencent/mobileqq/config/AboutConfig:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 514	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   63: invokevirtual 520	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   66: astore_1
    //   67: aload_1
    //   68: aload_2
    //   69: invokestatic 524	com/tencent/mobileqq/data/ResourcePluginInfo:persistOrReplace	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/data/ResourcePluginInfo;)V
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   80: return
    //   81: astore_2
    //   82: aload_1
    //   83: ifnull -3 -> 80
    //   86: aload_1
    //   87: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   90: return
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	AboutConfig
    //   0	102	1	paramResourcePluginInfo	ResourcePluginInfo
    //   39	30	2	localResourcePluginInfo	ResourcePluginInfo
    //   81	1	2	localException	java.lang.Exception
    //   91	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	72	81	java/lang/Exception
    //   67	72	91	finally
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AboutConfig", 2, "loadAboutConfig, isfore=" + paramBoolean1 + ",asynchronous=" + paramBoolean2);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
      if (QLog.isColorLevel()) {
        QLog.d("AboutConfig", 2, "error happens: loadAboutConfig while current account is null, which means there is no logined account now");
      }
    }
    do
    {
      return;
      if ((paramBoolean1) || (this.jdField_a_of_type_JavaUtilHashtable == null) || (this.jdField_a_of_type_JavaUtilHashtable.size() <= 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AboutConfig", 2, "there has about data in memory cache, do not need load from DB");
    return;
    this.jdField_a_of_type_JavaUtilHashtable = a();
    absl localabsl = new absl(this, paramBoolean2);
    if (paramBoolean2)
    {
      ThreadManager.post(localabsl, 5, null, false);
      return;
    }
    localabsl.run();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig
 * JD-Core Version:    0.7.0.1
 */