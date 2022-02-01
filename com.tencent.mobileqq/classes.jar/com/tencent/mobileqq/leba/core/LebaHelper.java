package com.tencent.mobileqq.leba.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.leba.entity.GroupInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReq;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceReqInfo;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceResp;
import com.tencent.mobileqq.leba.pb.PluginConfig.GetResourceRespInfo;
import com.tencent.mobileqq.leba.pb.PluginConfig.PluginGroup;
import com.tencent.mobileqq.leba.pb.PluginConfig.PluginLayout;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaHelper
{
  int jdField_a_of_type_Int = 0;
  public ILebaBasisApi a;
  public IStudyModeManager a;
  List<LebaPluginInfo> jdField_a_of_type_JavaUtilList;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  int jdField_b_of_type_Int = 0;
  List<LebaPluginInfo> jdField_b_of_type_JavaUtilList;
  public boolean b;
  public List<ResourcePluginListener> c;
  boolean c;
  
  public LebaHelper(AppRuntime paramAppRuntime)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
  }
  
  public static LebaPluginInfo a(PluginConfig.GetResourceRespInfo paramGetResourceRespInfo)
  {
    int j = 0;
    if (paramGetResourceRespInfo == null) {
      return null;
    }
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    long l;
    int i;
    label62:
    label86:
    label111:
    short s;
    if (paramGetResourceRespInfo.res_id.has())
    {
      l = paramGetResourceRespInfo.res_id.get();
      localLebaPluginInfo.uiResId = l;
      if (!paramGetResourceRespInfo.state.has()) {
        break label375;
      }
      i = paramGetResourceRespInfo.state.get();
      localLebaPluginInfo.state = i;
      if (!paramGetResourceRespInfo.res_seq.has()) {
        break label380;
      }
      i = paramGetResourceRespInfo.res_seq.get();
      localLebaPluginInfo.sResSeq = i;
      if (!paramGetResourceRespInfo.pkg_name.has()) {
        break label385;
      }
      str = paramGetResourceRespInfo.pkg_name.get();
      localLebaPluginInfo.strPkgName = str;
      if (!paramGetResourceRespInfo.res_name.has()) {
        break label392;
      }
      str = paramGetResourceRespInfo.res_name.get();
      label137:
      localLebaPluginInfo.strResName = str;
      if (!paramGetResourceRespInfo.icon_url.has()) {
        break label399;
      }
      str = paramGetResourceRespInfo.icon_url.get();
      label163:
      localLebaPluginInfo.strResURL = str;
      if (!paramGetResourceRespInfo.sub_type.has()) {
        break label406;
      }
      s = (short)paramGetResourceRespInfo.sub_type.get();
      label189:
      localLebaPluginInfo.sResSubType = s;
      if (!paramGetResourceRespInfo.jump_url.has()) {
        break label411;
      }
      str = paramGetResourceRespInfo.jump_url.get();
      label214:
      localLebaPluginInfo.strGotoUrl = str;
      if (!paramGetResourceRespInfo.can_change_state.has()) {
        break label418;
      }
      i = paramGetResourceRespInfo.can_change_state.get();
      label239:
      localLebaPluginInfo.cCanChangeState = i;
      if (!paramGetResourceRespInfo.res_conf.has()) {
        break label423;
      }
      str = paramGetResourceRespInfo.res_conf.get();
      label264:
      localLebaPluginInfo.resConf = str;
      localLebaPluginInfo.cDataType = 0;
      i = j;
      if (paramGetResourceRespInfo.simple_mode.has()) {
        i = paramGetResourceRespInfo.simple_mode.get();
      }
      localLebaPluginInfo.showInSimpleMode = i;
      if (!paramGetResourceRespInfo.grid_icon_url.has()) {
        break label430;
      }
    }
    label385:
    label392:
    label399:
    label406:
    label411:
    label418:
    label423:
    label430:
    for (String str = paramGetResourceRespInfo.grid_icon_url.get();; str = "")
    {
      localLebaPluginInfo.strGridIconUrl = str;
      if (QLog.isColorLevel()) {
        QLog.i("ConfigManager", 2, "plugin config xml:" + paramGetResourceRespInfo.res_conf.get());
      }
      return localLebaPluginInfo;
      l = 0L;
      break;
      label375:
      i = 0;
      break label62;
      label380:
      i = 0;
      break label86;
      str = "";
      break label111;
      str = "";
      break label137;
      str = "";
      break label163;
      s = -1;
      break label189;
      str = "";
      break label214;
      i = 1;
      break label239;
      str = "";
      break label264;
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 8, null, true);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (!this.jdField_a_of_type_MqqAppAppRuntime.isLogin())) {}
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences();
    } while (!localSharedPreferences.getBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), true));
    if (QLog.isDevelopLevel()) {
      QLog.d("LebaHelper", 4, "clearLocalDBPlugin.local plugin.");
    }
    localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    try
    {
      List localList = LebaPluginInfo.getAll((EntityManager)localObject1);
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          if ((localLebaPluginInfo != null) && (localLebaPluginInfo.cDataType == 1)) {
            LebaPluginInfo.remove((EntityManager)localObject1, localLebaPluginInfo.uiResId);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ((EntityManager)localObject1).close();
      }
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
    localObject1 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putBoolean("lebaplugin_clear_local" + this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), false);
    ((SharedPreferences.Editor)localObject1).commit();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Map localMap = LebaUtil.a(LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime));
    if (localMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "loadServerPlugins, groupMap is null");
      }
      return;
    }
    ??? = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    List localList = LebaPluginInfo.getAll((EntityManager)???);
    ((EntityManager)???).close();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localList != null) && (localList.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)localList.get(i);
          GroupInfo localGroupInfo = (GroupInfo)localMap.get(Long.valueOf(localLebaPluginInfo.uiResId));
          if (localGroupInfo == null)
          {
            localStringBuilder.append(",remove ").append(localLebaPluginInfo);
            localList.remove(localLebaPluginInfo);
          }
          else
          {
            localStringBuilder.append(",add ").append(localLebaPluginInfo);
            localLebaPluginInfo.sPriority = LebaUtil.a(localGroupInfo);
          }
        }
      }
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
      QLog.i("LebaHelper", 1, "loadServerPlugins data =  " + localStringBuilder);
      return;
      i -= 1;
    }
  }
  
  public PluginConfig.GetResourceReq a()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "getLebaPluginInfoReq");
    }
    if (LebaUtil.b(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isAppUpgrade");
      LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, 0);
      LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi.isLocaleUpdatedByUser()))
    {
      i = 1;
      if (i != 0)
      {
        QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isLocaleUpdated");
        LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, 0);
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
      }
    }
    try
    {
      ((EntityManager)localObject).drop(LebaPluginInfo.class);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ArrayList localArrayList;
        LebaPluginInfo localLebaPluginInfo2;
        QLog.e("LebaHelper", 1, "getLebaPluginInfoReq exception", localThrowable);
        if (localObject != null) {
          ((EntityManager)localObject).close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label350;
      }
      ((EntityManager)localObject).close();
    }
    if (a(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QLog.i("LebaHelper", 1, "getLebaPluginInfoReq ，isChangeModel");
      LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, 0);
    }
    int m = LebaUtil.b(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject = LebaPluginInfo.getAll(this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager());
    localArrayList = new ArrayList();
    if (localObject != null)
    {
      i = 0;
      label191:
      if (i < ((List)localObject).size())
      {
        LebaPluginInfo localLebaPluginInfo1 = (LebaPluginInfo)((List)localObject).get(i);
        if ((localLebaPluginInfo1 != null) && (localLebaPluginInfo1.cDataType == 0))
        {
          localLebaPluginInfo2 = new LebaPluginInfo();
          if (m > 0) {
            break label353;
          }
        }
        label350:
        label353:
        for (int j = 0;; j = localLebaPluginInfo1.sResSeq)
        {
          localLebaPluginInfo2.sResSeq = j;
          localLebaPluginInfo2.uiResId = localLebaPluginInfo1.uiResId;
          localArrayList.add(localLebaPluginInfo2);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "" + localLebaPluginInfo1);
          }
          i += 1;
          break label191;
          i = 0;
          break;
        }
      }
    }
    if (localList.isEmpty()) {}
    for (int i = k;; i = m)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "getLebaPluginInfoReq, layoutSeq=" + i + ", lebaPluginInfos.size" + localList.size() + ", tempLebaList.size()=" + ((List)localObject).size());
      }
      return a(i, localList);
    }
  }
  
  public PluginConfig.GetResourceReq a(int paramInt, List<LebaPluginInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)paramList.next();
        if (localLebaPluginInfo != null)
        {
          PluginConfig.GetResourceReqInfo localGetResourceReqInfo = new PluginConfig.GetResourceReqInfo();
          localGetResourceReqInfo.res_id.set((int)localLebaPluginInfo.uiResId);
          localGetResourceReqInfo.res_seq.set(localLebaPluginInfo.sResSeq);
          localArrayList.add(localGetResourceReqInfo);
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager != null) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager.getStudyModeSwitch())) {}
    for (int i = 4026;; i = 4000)
    {
      QLog.i("LebaHelper", 1, "getLebaPluginListReq pluginType = " + i);
      paramList = new PluginConfig.GetResourceReq();
      paramList.plugin_type.set(i);
      paramList.plugin_layout_seq.set(paramInt);
      paramList.reqinfo_list.set(localArrayList);
      return paramList;
    }
  }
  
  public List<LebaPluginInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessILebaBasisApi = ((ILebaBasisApi)QRoute.api(ILebaBasisApi.class));
    this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager = ((IStudyModeManager)QRoute.api(IStudyModeManager.class));
  }
  
  public void a(int paramInt1, List<GroupInfo> paramList, int paramInt2, int paramInt3)
  {
    int j = LebaUtil.b(this.jdField_a_of_type_MqqAppAppRuntime);
    if (paramList == null) {}
    for (int i = -1;; i = paramList.size())
    {
      QLog.i("LebaHelper", 1, String.format("saveLebaGroupInfo, localSeq=%d, seq=%d , groupListSize=%d, layoutType=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) }));
      if ((paramInt1 > 0) && (paramInt1 != j) && (paramList != null))
      {
        LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt1);
        LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramList);
        LebaUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      if (!this.jdField_c_of_type_JavaUtilList.contains(paramResourcePluginListener)) {
        this.jdField_c_of_type_JavaUtilList.add(paramResourcePluginListener);
      }
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.excute(paramRunnable, 128, null, true);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    QLog.i("leba_study", 1, "tryCloseShowAllPluginAsyn");
    a(new LebaHelper.4(this, paramAppRuntime));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = false;
      i();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean, int paramInt1, List<GroupInfo> arg3, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    b(paramBoolean, paramInt1, ???, paramList1, paramInt2, paramInt3);
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    StringBuffer localStringBuffer;
    boolean bool3;
    boolean bool4;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      localEntityManager = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
      bool2 = false;
      bool1 = false;
      bool5 = false;
      paramBoolean = false;
      localStringBuffer = new StringBuffer();
      bool3 = bool5;
      bool4 = bool2;
    }
    for (;;)
    {
      boolean bool6;
      boolean bool7;
      try
      {
        localStringBuffer.append("onGetPluginConfig saveDb start");
        bool3 = bool5;
        bool4 = bool2;
        localEntityTransaction.begin();
        bool3 = bool5;
        bool4 = bool2;
        paramList1 = paramList1.iterator();
        bool3 = paramBoolean;
        bool4 = bool1;
        if (paramList1.hasNext())
        {
          bool3 = paramBoolean;
          bool4 = bool1;
          localLebaPluginInfo = (LebaPluginInfo)paramList1.next();
          if (localLebaPluginInfo == null) {
            continue;
          }
          bool3 = paramBoolean;
          bool4 = bool1;
          localStringBuffer.append(localLebaPluginInfo);
          bool3 = paramBoolean;
          bool4 = bool1;
          if (localLebaPluginInfo.sResSubType != 0)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            bool6 = paramBoolean;
            bool7 = bool1;
            if (localLebaPluginInfo.sResSubType != 2) {
              break label702;
            }
          }
          bool2 = paramBoolean;
          bool5 = bool1;
          bool3 = paramBoolean;
          bool4 = bool1;
          if (localLebaPluginInfo.state == 3)
          {
            bool3 = paramBoolean;
            bool4 = bool1;
            LebaPluginInfo.persistOrReplace(localEntityManager, localLebaPluginInfo);
            bool5 = true;
            bool2 = true;
          }
          bool3 = bool2;
          bool4 = bool5;
          bool6 = bool2;
          bool7 = bool5;
          if (localLebaPluginInfo.state != 1) {
            break label702;
          }
          bool3 = bool2;
          bool4 = bool5;
          LebaPluginInfo.persistOrReplace(localEntityManager, localLebaPluginInfo);
          bool1 = true;
          paramBoolean = bool2;
        }
      }
      catch (Exception paramList1)
      {
        LebaPluginInfo localLebaPluginInfo;
        QLog.i("LebaHelper", 1, "onGetPluginConfig", paramList1);
        paramBoolean = false;
        paramList1.printStackTrace();
        localEntityTransaction.end();
        localEntityManager.close();
        bool1 = bool4;
        continue;
      }
      finally
      {
        localEntityTransaction.end();
        localEntityManager.close();
      }
      try
      {
        if (localLebaPluginInfo.state != 2) {
          break label699;
        }
        LebaPluginInfo.remove(localEntityManager, localLebaPluginInfo.uiResId);
        bool1 = true;
      }
      catch (Exception paramList1)
      {
        bool3 = paramBoolean;
        bool4 = bool1;
        continue;
        continue;
      }
      bool2 = true;
      bool3 = paramBoolean;
      bool4 = bool1;
      localEntityTransaction.commit();
      localEntityTransaction.end();
      localEntityManager.close();
      bool3 = paramBoolean;
      paramBoolean = bool2;
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(String.format("onGetPluginConfig saveDb end, saveDbSuc=%b, isAddNew=%b, isChange=%b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
        QLog.i("LebaHelper", 2, localStringBuffer.toString());
      }
      if (paramBoolean) {
        a(paramInt1, ???, paramInt2, paramInt3);
      }
      h();
      i();
      if (bool3) {
        ((IRedTouchServer)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchServer.class, "")).forceSendReq(1);
      }
      if (bool1)
      {
        ??? = new ArrayList(this.jdField_c_of_type_JavaUtilList).iterator();
        if (!???.hasNext()) {
          break;
        }
        paramList1 = (ResourcePluginListener)???.next();
        if (bool3)
        {
          ResourcePluginListener.a(paramList1, (byte)3, 1);
          continue;
        }
        ResourcePluginListener.a(paramList1, (byte)2, 1);
        continue;
      }
      ??? = this.jdField_c_of_type_JavaUtilList;
      paramInt1 = 0;
      try
      {
        while (paramInt1 < this.jdField_c_of_type_JavaUtilList.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.jdField_c_of_type_JavaUtilList.get(paramInt1), (byte)1, 1);
          paramInt1 += 1;
        }
        return;
      }
      finally {}
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_Boolean = true;
        paramInt1 = 0;
        while (paramInt1 < this.jdField_c_of_type_JavaUtilList.size())
        {
          ResourcePluginListener.a((ResourcePluginListener)this.jdField_c_of_type_JavaUtilList.get(paramInt1), (byte)-1, 1);
          paramInt1 += 1;
        }
        return;
      }
      label699:
      label702:
      bool1 = bool7;
      paramBoolean = bool6;
    }
  }
  
  public void a(boolean paramBoolean, PluginConfig.GetResourceResp paramGetResourceResp)
  {
    int i = -1;
    Object localObject1 = Collections.emptyList();
    Object localObject3 = Collections.emptyList();
    int k = -1;
    int j = -1;
    label82:
    label103:
    label124:
    int m;
    if (paramBoolean)
    {
      if (paramGetResourceResp != null) {}
      for (;;)
      {
        try
        {
          i = paramGetResourceResp.plugin_type.get();
        }
        catch (Exception localException2)
        {
          Object localObject4;
          List localList;
          int i1;
          label144:
          int n;
          label301:
          label348:
          m = -1;
          label423:
          paramGetResourceResp = localObject2;
          localObject2 = localException2;
          i = j;
          j = m;
          continue;
        }
        for (;;)
        {
          try
          {
            if (paramGetResourceResp.plugin_layout.has())
            {
              localObject4 = (PluginConfig.PluginLayout)paramGetResourceResp.plugin_layout.get();
              if (localObject4 == null) {
                continue;
              }
              if (!((PluginConfig.PluginLayout)localObject4).layout_type.has()) {
                break label301;
              }
              j = ((PluginConfig.PluginLayout)localObject4).layout_type.get();
            }
          }
          catch (Exception localException3)
          {
            j = -1;
            paramGetResourceResp = localObject2;
            localObject2 = localException3;
            break label423;
            j = -1;
            break label348;
          }
          try
          {
            if (((PluginConfig.PluginLayout)localObject4).plugin_layout_seq.has()) {
              k = ((PluginConfig.PluginLayout)localObject4).plugin_layout_seq.get();
            }
          }
          catch (Exception localException4)
          {
            m = -1;
            paramGetResourceResp = localObject2;
            localObject2 = localException4;
            k = j;
            j = m;
            break label423;
          }
        }
        for (;;)
        {
          try
          {
            if (((PluginConfig.PluginLayout)localObject4).group_list.has())
            {
              localList = ((PluginConfig.PluginLayout)localObject4).group_list.get();
              if (localList == null) {
                continue;
              }
              localObject4 = new ArrayList();
              m = 0;
              i1 = 0;
            }
          }
          catch (Exception localException5)
          {
            paramGetResourceResp = localObject2;
            localObject2 = localException5;
            m = k;
            k = j;
            j = m;
            break label423;
            m = k;
            k = j;
            j = m;
            break label348;
          }
          try
          {
            if (i1 < localList.size())
            {
              localObject3 = (PluginConfig.PluginGroup)localList.get(i1);
              n = m;
              if (((PluginConfig.PluginGroup)localObject3).has())
              {
                n = m;
                if (((PluginConfig.PluginGroup)localObject3).res_id.has())
                {
                  localObject3 = ((PluginConfig.PluginGroup)localObject3).res_id.get();
                  int i2 = 0;
                  for (;;)
                  {
                    n = m;
                    if (i2 >= ((List)localObject3).size()) {
                      break;
                    }
                    GroupInfo localGroupInfo = new GroupInfo();
                    localGroupInfo.jdField_a_of_type_Long = ((Integer)((List)localObject3).get(i2)).intValue();
                    localGroupInfo.jdField_a_of_type_Int = i1;
                    m += 1;
                    localGroupInfo.jdField_b_of_type_Int = m;
                    ((List)localObject4).add(localGroupInfo);
                    i2 += 1;
                  }
                  localObject4 = null;
                  break;
                  j = -1;
                  break label82;
                  k = -1;
                  break label103;
                  localList = null;
                  break label124;
                }
              }
              i1 += 1;
              m = n;
              break label144;
            }
            m = j;
            localObject3 = localObject4;
            j = k;
            k = m;
          }
          catch (Exception localException7)
          {
            localObject3 = localException5;
            paramGetResourceResp = localObject2;
            localObject2 = localException7;
            m = k;
            k = j;
            j = m;
            break label423;
          }
        }
      }
      try
      {
        localObject4 = paramGetResourceResp.respinfo_list.get();
        paramGetResourceResp = new ArrayList();
        if (localObject4 == null) {
          break label550;
        }
        try
        {
          localObject1 = ((List)localObject4).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = a((PluginConfig.GetResourceRespInfo)((Iterator)localObject1).next());
            if (localObject4 != null) {
              paramGetResourceResp.add(localObject4);
            }
          }
          QLog.i("LebaHelper", 1, "handleGetLebaPluginList", localException1);
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException6)
      {
        paramGetResourceResp = localObject2;
        localObject2 = localException6;
        break label423;
      }
      m = k;
      paramBoolean = false;
      k = i;
      i = m;
    }
    for (;;)
    {
      if (paramGetResourceResp != null)
      {
        m = paramGetResourceResp.size();
        label458:
        if (localObject3 == null) {
          break label612;
        }
      }
      label550:
      Object localObject2;
      label612:
      for (n = ((List)localObject3).size();; n = 0)
      {
        QLog.d("LebaHelper", 1, new Object[] { "handleGetLebaPluginList isSuc:", Boolean.valueOf(paramBoolean), ", resultInfos.size=", Integer.valueOf(m), ", groupList.size=", Integer.valueOf(n) });
        a(paramBoolean, j, (List)localObject3, paramGetResourceResp, i, k);
        a(this.jdField_a_of_type_MqqAppAppRuntime, paramBoolean, k);
        return;
        m = i;
        localObject2 = localObject3;
        i = j;
        j = m;
        for (;;)
        {
          m = j;
          j = i;
          localObject3 = localObject2;
          i = k;
          k = m;
          break;
          paramBoolean = false;
          QLog.i("LebaHelper", 1, "handleGetLebaPluginList respInfo is null");
          paramGetResourceResp = localObject2;
          localObject2 = localObject3;
        }
        m = 0;
        break label458;
      }
      k = -1;
      j = -1;
      paramGetResourceResp = localObject2;
      i = -1;
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager != null) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeApiIStudyModeManager.getStudyModeSwitch())) {}
    for (int i = 4026; i != LebaUtil.d(paramAppRuntime); i = 4000) {
      return true;
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!LebaUtil.a(paramInt)))
    {
      QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin failed isSuc = " + paramBoolean + ",pluginType=" + paramInt);
      return false;
    }
    if (LebaUtil.c(paramAppRuntime) == 2)
    {
      QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin failed has Close");
      return false;
    }
    QLog.i("leba_study", 1, "tryClosePluginWhenLoadPlugin");
    CommPluginHandlerApi.b(paramAppRuntime);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    b(new LebaHelper.1(this));
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramResourcePluginListener);
      return;
    }
  }
  
  protected void b(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder("closeShowAllPlugin->");
    Object localObject2 = LebaShowListManager.a().b(paramAppRuntime);
    Object localObject1 = LebaShowListManager.a().a();
    long l = NetConnInfoCenter.getServerTimeMillis();
    localStringBuilder.append(l);
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    if (localObject2 != null)
    {
      localStringBuilder.append("close->");
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LebaViewItem)((Iterator)localObject2).next();
        if ((localObject3 == null) || (((LebaViewItem)localObject3).a == null))
        {
          localStringBuilder.append("null;");
        }
        else
        {
          localStringBuilder.append(((LebaViewItem)localObject3).a.uiResId).append(";");
          if ((4030L != ((LebaViewItem)localObject3).a.uiResId) && (3504L != ((LebaViewItem)localObject3).a.uiResId))
          {
            LebaShowListManager.a().a(paramAppRuntime, ((LebaViewItem)localObject3).a.uiResId, false, l, -9223372036854775808L, true);
            BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
            localAppSetting.appid.set((int)((LebaViewItem)localObject3).a.uiResId);
            localAppSetting.setting.set(false);
            localAppSetting.modify_ts.set(l);
            localArrayList.add(localAppSetting);
          }
        }
      }
    }
    if (localObject1 != null)
    {
      localStringBuilder.append("open->");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((LebaViewItem)localObject2).a == null))
        {
          localStringBuilder.append("null;");
        }
        else if ((4030L == ((LebaViewItem)localObject2).a.uiResId) || (3504L == ((LebaViewItem)localObject2).a.uiResId))
        {
          LebaShowListManager.a().a(paramAppRuntime, ((LebaViewItem)localObject2).a.uiResId, true, l, -9223372036854775808L, true);
          localObject3 = new BusinessInfoCheckUpdate.AppSetting();
          ((BusinessInfoCheckUpdate.AppSetting)localObject3).appid.set((int)((LebaViewItem)localObject2).a.uiResId);
          ((BusinessInfoCheckUpdate.AppSetting)localObject3).setting.set(true);
          ((BusinessInfoCheckUpdate.AppSetting)localObject3).modify_ts.set(l);
          localArrayList.add(localObject3);
        }
      }
    }
    QLog.i("leba_study", 1, localStringBuilder.toString());
    if (localArrayList.isEmpty()) {
      c(paramAppRuntime);
    }
    for (;;)
    {
      i();
      return;
      CommPluginHandlerApi.a(paramAppRuntime, localArrayList);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt1, List<GroupInfo> paramList, List<LebaPluginInfo> paramList1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(" onGetPluginConfig, isSucc= ").append(paramBoolean).append(",layoutSeq=").append(paramInt1).append(",layoutType=").append(paramInt2).append(",pluginType=").append(paramInt3);
    localStringBuilder.append(",groupList=");
    if (paramList != null)
    {
      localStringBuilder.append(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GroupInfo localGroupInfo = (GroupInfo)paramList.next();
        if (localGroupInfo != null) {
          localStringBuilder.append(localGroupInfo.toString());
        }
      }
    }
    localStringBuilder.append(",resultInfos=");
    if (paramList1 != null)
    {
      localStringBuilder.append(paramList1.size());
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (LebaPluginInfo)paramList.next();
        if (paramList1 != null) {
          localStringBuilder.append(paramList1.toString());
        }
      }
    }
    QLog.i("LebaHelper", 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      CommPluginHandlerApi.c(this.jdField_a_of_type_MqqAppAppRuntime);
      this.jdField_a_of_type_Int += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "checkPluginConfig, mGetPluginConfigFail=" + this.jdField_a_of_type_Boolean + ", mPluginRetryTime=" + this.jdField_a_of_type_Int);
    }
  }
  
  public void c(AppRuntime paramAppRuntime)
  {
    QLog.i("leba_study", 1, "setHasClosePluginFlagYes");
    LebaUtil.b(paramAppRuntime, 2);
    LebaUtil.a(paramAppRuntime, true);
    a(new LebaHelper.5(this, paramAppRuntime));
  }
  
  public void d()
  {
    if (a(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QLog.i("LebaHelper", 1, "checkModleAndRefesh getAllPluginList");
      ThreadManager.excute(new LebaHelper.2(this), 160, null, true);
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void f()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int += 1;
      ThreadManager.excute(new LebaHelper.3(this), 128, null, true);
      QLog.i("leba_sort", 1, "checkPluginSort, mGetUserSortFail=" + this.jdField_c_of_type_Boolean + ", mPluginRetryTime=" + this.jdField_b_of_type_Int);
    }
  }
  
  protected void g()
  {
    LebaPluginInfo localLebaPluginInfo = new LebaPluginInfo();
    localLebaPluginInfo.strPkgName = "qzone_feedlist";
    localLebaPluginInfo.strResName = HardCodeUtil.a(2131693642);
    localLebaPluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localLebaPluginInfo.sResSubType = 2;
    localLebaPluginInfo.cCanChangeState = 0;
    localLebaPluginInfo.cDataType = 1;
    localLebaPluginInfo.uiResId = 0L;
    localLebaPluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.mobileqq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "tab_qzone" });
    localLebaPluginInfo.showInSimpleMode = 1;
    this.jdField_b_of_type_JavaUtilList.add(localLebaPluginInfo);
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 35	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   11: invokevirtual 190	mqq/app/AppRuntime:isLogin	()Z
    //   14: ifne +19 -> 33
    //   17: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 210
    //   25: iconst_2
    //   26: ldc_w 772
    //   29: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_0
    //   34: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   44: invokeinterface 747 1 0
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: invokevirtual 774	com/tencent/mobileqq/leba/core/LebaHelper:g	()V
    //   55: aload_0
    //   56: invokespecial 776	com/tencent/mobileqq/leba/core/LebaHelper:k	()V
    //   59: aload_0
    //   60: getfield 23	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_ArrayOfByte	[B
    //   63: astore_1
    //   64: aload_1
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 40	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   70: invokeinterface 747 1 0
    //   75: aload_0
    //   76: getfield 40	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   79: aload_0
    //   80: getfield 42	com/tencent/mobileqq/leba/core/LebaHelper:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   83: invokeinterface 308 2 0
    //   88: pop
    //   89: aload_1
    //   90: monitorexit
    //   91: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +37 -> 131
    //   97: ldc 210
    //   99: iconst_2
    //   100: new 156	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 778
    //   110: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 40	com/tencent/mobileqq/leba/core/LebaHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   117: invokeinterface 234 1 0
    //   122: invokevirtual 362	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 29	com/tencent/mobileqq/leba/core/LebaHelper:jdField_b_of_type_Boolean	Z
    //   136: return
    //   137: astore_2
    //   138: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -92 -> 49
    //   144: ldc 210
    //   146: iconst_2
    //   147: aload_2
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 781	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: goto -106 -> 49
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   168: goto -113 -> 55
    //   171: astore_2
    //   172: aload_1
    //   173: monitorexit
    //   174: aload_2
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	LebaHelper
    //   163	10	1	localException1	Exception
    //   137	11	2	localException2	Exception
    //   158	4	2	localObject2	Object
    //   171	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	137	java/lang/Exception
    //   40	49	158	finally
    //   49	51	158	finally
    //   138	155	158	finally
    //   159	161	158	finally
    //   51	55	163	java/lang/Exception
    //   66	91	171	finally
    //   172	174	171	finally
  }
  
  public void i()
  {
    Iterator localIterator = new ArrayList(this.jdField_c_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaHelper
 * JD-Core Version:    0.7.0.1
 */