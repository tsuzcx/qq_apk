package com.tencent.mobileqq.nearby.api;

import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class NearbyProcessMonitor
{
  static int jdField_a_of_type_Int;
  static PreloadProcHitSession[] jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession[3];
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "nearby_leba", "nearby_msgbox", "nearby_guide" };
  
  protected static void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("preloadNearbyProcess", new Object[0]);
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), NearbyReceiver.class);
    localIntent.putExtra("nearby_preload_from", 1);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      try
      {
        if (jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] == null) {
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] = new PreloadProcHitSession(jdField_a_of_type_ArrayOfJavaLangString[paramInt], "com.tencent.mobileqq:tool");
        } else {
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].d();
        }
        jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].a();
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("NearbyProcessMonitor", "preloadHitSession", new Object[] { localThrowable.toString() });
        }
      }
    }
  }
  
  static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("NearbyProcessMonitor", new Object[] { "dataUpgrade" });
    }
    if (((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramString, "nearby_sp_upgrade_flag", Boolean.valueOf(false))).booleanValue()) {
      return;
    }
    Object localObject7 = null;
    try
    {
      Object localObject2 = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
      localObject1 = localObject7;
      Object localObject5 = localObject2;
      try
      {
        if (!(localObject2 instanceof QQAppInterface)) {
          break label123;
        }
        localObject1 = (QQAppInterface)localObject2;
        localObject5 = localObject2;
      }
      catch (AccountNotMatchException localAccountNotMatchException2)
      {
        localObject1 = localObject2;
        localObject2 = localAccountNotMatchException2;
      }
      localAccountNotMatchException1.printStackTrace();
    }
    catch (AccountNotMatchException localAccountNotMatchException1)
    {
      localObject1 = null;
    }
    Object localObject6 = localObject1;
    Object localObject1 = localObject7;
    label123:
    if (localObject1 == null) {
      return;
    }
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "self_gender"))
    {
      localObject3 = ((FriendsManager)((QQAppInterface)localObject6).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
      if (localObject3 != null)
      {
        localObject6 = (INearbyCardManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        if (QLog.isColorLevel()) {
          NearbyUtils.a("NearbyProcessMonitor", new Object[] { "gender", Short.valueOf(((Card)localObject3).shGender) });
        }
        if (localObject6 != null) {
          ((INearbyCardManager)localObject6).b(((Card)localObject3).shGender);
        }
      }
    }
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "hotchat_tab_switch")) {}
    try
    {
      i = ((QQAppInterface)localObject1).getPreferences().getInt("hotchat_tab_switch", 0);
    }
    catch (Exception localException2)
    {
      int i;
      label270:
      boolean bool;
      Object localObject4;
      long l;
      break label270;
    }
    i = 0;
    if (QLog.isColorLevel())
    {
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      NearbyUtils.a("NearbyProcessMonitor", new Object[] { "hotchat_tab_swtich", Boolean.valueOf(bool) });
    }
    Object localObject3 = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((INearbySPUtil)localObject3).setValue(paramString, "hotchat_tab_switch", Boolean.valueOf(bool));
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "supportHotChatDemo"))
    {
      try
      {
        i = ((QQAppInterface)localObject1).getPreferences().getInt("supportHotChatDemo", 0);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        if (i == 1) {
          bool = true;
        } else {
          bool = false;
        }
        NearbyUtils.a("NearbyProcessMonitor", new Object[] { "hotchat_demo_switch", Boolean.valueOf(bool) });
      }
      localObject4 = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((INearbySPUtil)localObject4).setValue(paramString, "supportHotChatDemo", Boolean.valueOf(bool));
    }
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "ShowFreshNews"))
    {
      localObject4 = BaseApplicationImpl.getApplication().getSharedPreferences("FRESHNEWS_SP", 0);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramString);
      ((StringBuilder)localObject6).append("ShowFreshNews");
      bool = ((SharedPreferences)localObject4).getBoolean(((StringBuilder)localObject6).toString(), true);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyProcessMonitor", new Object[] { "freshnews_tab_switch", Boolean.valueOf(bool) });
      }
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "ShowFreshNews", Boolean.valueOf(bool));
    }
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "nearby_enter_time"))
    {
      localObject4 = BaseApplicationImpl.getApplication();
      localObject6 = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
      localObject4 = ((BaseApplicationImpl)localObject4).getSharedPreferences("sp_nearbyrecommender", 0);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramString);
      ((StringBuilder)localObject6).append("_key_enter_nearby_time");
      l = ((SharedPreferences)localObject4).getLong(((StringBuilder)localObject6).toString(), 0L);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyProcessMonitor", new Object[] { "entry_time", Long.valueOf(l) });
      }
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "nearby_enter_time", Long.valueOf(l));
    }
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "self_god_flag"))
    {
      localObject4 = ((QQAppInterface)localObject1).getApp();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("dating_pref");
      ((StringBuilder)localObject6).append(paramString);
      bool = ((BaseApplication)localObject4).getSharedPreferences(((StringBuilder)localObject6).toString(), 0).getBoolean("toplist_self_is_god", false);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyProcessMonitor", new Object[] { "god", Boolean.valueOf(bool) });
      }
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "self_god_flag", Boolean.valueOf(bool));
    }
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "nearby_people_disclaimer_ok_5.8.0"))
    {
      bool = ((QQAppInterface)localObject1).getPreferences().getBoolean("nearby_people_disclaimer_ok_5.8.0", false);
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(bool));
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "nearby_sp_upgrade_flag", Boolean.valueOf(true));
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("startNearbyProcess", new Object[] { Integer.valueOf(paramInt) });
    }
    a(paramInt);
    if (PreloadProcHitSession.a("com.tencent.mobileqq:tool"))
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyProcess is exist", new Object[0]);
      }
      return;
    }
    if ((paramInt >= 0) && (paramInt < 3))
    {
      if ("1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.disable_preload_nearby_process.name(), "0")))
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("dpc disable preload nearby process", new Object[0]);
        }
        return;
      }
      if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).checkPreload(paramString)) {
        return;
      }
      if (jdField_a_of_type_Int > 10)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("cation: preload  to much times, ", new Object[] { Integer.valueOf(jdField_a_of_type_Int) });
        }
        return;
      }
    }
    ThreadManager.post(new NearbyProcessMonitor.1(paramString), 10, null, false);
  }
  
  public static void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      try
      {
        if (jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] != null)
        {
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].b();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("NearbyProcessMonitor", "reportSessionHit", new Object[] { localThrowable.toString() });
        }
      }
    }
  }
  
  public static void b(String paramString)
  {
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).contains(paramString, "self_school_name"))
    {
      Object localObject1 = null;
      String str = null;
      try
      {
        Object localObject2 = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        if ((localObject2 instanceof QQAppInterface))
        {
          localObject1 = (QQAppInterface)localObject2;
          localObject2 = ((FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
          if (localObject2 != null)
          {
            str = ((Card)localObject2).strSchool;
          }
          else
          {
            localObject1 = (NearbyPeopleCard)((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager().find(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
            if (localObject1 != null) {
              str = ((NearbyPeopleCard)localObject1).college;
            }
          }
          localObject1 = str;
          if (str != null)
          {
            ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "self_school_name", str);
            localObject1 = str;
          }
        }
        if (NearbyUtils.b())
        {
          NearbyUtils.a("NearbyProcessMonitor", new Object[] { "checkSchoolName", localObject1 });
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void b(String paramString, int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(paramString, "actCheckHasUnreadMsg", bool, paramInt, 0L, null, "");
  }
  
  public static void c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 3)) {
      try
      {
        if (jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt] != null)
        {
          jdField_a_of_type_ArrayOfComTencentMobileqqHitratePreloadProcHitSession[paramInt].d();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("NearbyProcessMonitor", "reportSessionEnd", new Object[] { localThrowable.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProcessMonitor
 * JD-Core Version:    0.7.0.1
 */