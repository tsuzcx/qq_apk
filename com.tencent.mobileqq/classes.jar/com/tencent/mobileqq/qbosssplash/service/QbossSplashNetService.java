package com.tencent.mobileqq.qbosssplash.service;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qbosssplash.common.QbossPreDownloadManager;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashCacheManager;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashDownloadManager;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.IQbossCallback;
import cooperation.qzone.qboss.QzoneQbossHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.vip.ad.TianshuSplashUtils;
import cooperation.vip.qqbanner.QbossADBannerCountDownImmersionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class QbossSplashNetService
  implements IQbossCallback
{
  private static volatile QbossSplashNetService a = null;
  
  public static QbossSplashNetService a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QbossSplashNetService();
      }
      return a;
    }
    finally {}
  }
  
  private void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.i("QzoneQbossHelper", 1, "coversation getQbossSuccess requestType = " + paramString);
    if (paramMobileQbossAdvRsp != null)
    {
      paramString = paramMobileQbossAdvRsp.map_next_query_ts;
      if (paramString != null)
      {
        paramString = (Long)paramString.get(Integer.valueOf(2741));
        if (paramString != null) {
          QbossADBannerConfigManager.a().a(paramString.longValue(), 2741);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if (paramMobileQbossAdvRsp != null)
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2741));
        if ((paramMobileQbossAdvRsp != null) && (paramMobileQbossAdvRsp.size() > 0)) {
          a(paramMobileQbossAdvRsp);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramQQAppInterface != null) && (!a(paramQQAppInterface))) {
        BannerManager.a().b(23, 3001);
      }
      return;
    }
  }
  
  private void a(QbossADBannerConfigInfo paramQbossADBannerConfigInfo)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = QbossADBannerConfigManager.a().a(((QQAppInterface)localObject).getAccount());
      if ((paramQbossADBannerConfigInfo != null) && (localObject != null))
      {
        int j = 0;
        int i;
        if ((paramQbossADBannerConfigInfo.a != null) && (((QbossADBannerConfigInfo)localObject).a != null) && (paramQbossADBannerConfigInfo.a.pattern_id != ((QbossADBannerConfigInfo)localObject).a.pattern_id)) {
          i = 1;
        }
        while (i != 0)
        {
          QLog.e("QzoneQbossHelper", 1, "checkIfNeedRemoveBanner remove");
          BannerManager.a().b(23, 3001);
          return;
          i = j;
          if (!TextUtils.isEmpty(paramQbossADBannerConfigInfo.c))
          {
            i = j;
            if (!paramQbossADBannerConfigInfo.c.equals(((QbossADBannerConfigInfo)localObject).c)) {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList;
    Object localObject1;
    try
    {
      Object localObject2 = QbossSplashUtil.a(BaseApplicationImpl.getContext(), paramLong);
      localArrayList = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = QbossSplashUtil.a(BaseApplicationImpl.getContext(), paramLong + "");
        localObject3 = TianshuSplashUtils.a(BaseApplicationImpl.getContext(), paramLong + "");
        Set localSet1 = QbossSplashUtil.a(BaseApplicationImpl.getContext(), paramLong + "");
        Set localSet2 = TianshuSplashUtils.a(BaseApplicationImpl.getContext(), paramLong + "");
        localObject3 = QbossSplashUtil.a(paramLong + "", (SharedPreferences)localObject3, localSet2);
        if ((QbossSplashUtil.a == null) || (QbossSplashUtil.a.size() == 0))
        {
          localObject1 = QbossSplashUtil.a(paramLong + "", (SharedPreferences)localObject1, localSet1);
          ((HashMap)localObject1).putAll((Map)localObject3);
          localObject2 = ((List)localObject2).iterator();
        }
      }
      else
      {
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((HashMap)localObject1).containsKey(localObject3))
          {
            localObject3 = (SplashItem)((HashMap)localObject1).get(localObject3);
            if (((SplashItem)localObject3).b())
            {
              localArrayList.add(localObject3);
              QLog.i("QSplash@QbossSplashNetService", 1, "checkNeedDowloadAndDowload aid =" + ((SplashItem)localObject3).jdField_b_of_type_JavaLangString + "UIN" + paramLong % 10000L);
            }
            if ((((SplashItem)localObject3).jdField_b_of_type_Int == 3) || (((SplashItem)localObject3).jdField_b_of_type_Int == 2))
            {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(((SplashItem)localObject3).f, false, null);
              continue;
              return;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, paramQQAppInterface, new Object[0]);
    }
    do
    {
      localObject1 = QbossSplashUtil.a;
      break;
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    QbossSplashDownloadManager.a(paramQQAppInterface, localArrayList);
  }
  
  private void a(ArrayList<tAdvDesc> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (tAdvDesc)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        QLog.i("QzoneQbossHelper", 4, "handleQbossBannerData data = " + paramArrayList.res_data);
        paramArrayList = QbossADBannerConfigInfo.a(paramArrayList);
        a(paramArrayList);
        QbossADBannerConfigManager.a().a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramArrayList);
      }
    }
    else
    {
      return;
    }
    QLog.e("QzoneQbossHelper", 1, "handleQbossBannerData data = null");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = QbossADBannerConfigManager.a().a(paramQQAppInterface.getAccount());
      bool1 = bool2;
      if (paramQQAppInterface != null) {
        if (!"1".equals(paramQQAppInterface.c))
        {
          bool1 = bool2;
          if (!"2".equals(paramQQAppInterface.c)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    try
    {
      Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
      if (localObject != null)
      {
        localObject = (Long)((Map)localObject).get(Integer.valueOf(2783));
        if (localObject != null) {
          QbossADBannerConfigManager.a().a(((Long)localObject).longValue(), 2783);
        }
      }
      paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
      if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
      {
        paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2783));
        QbossPreDownloadManager.a().a(paramMobileQbossAdvRsp, paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramMobileQbossAdvRsp)
    {
      QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossPreDownloadRsp exception", paramMobileQbossAdvRsp);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = QbossADBannerConfigManager.a().a(paramQQAppInterface.getAccount());
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof QbossADBannerCountDownImmersionInfo)) && (((QbossADBannerCountDownImmersionInfo)paramQQAppInterface).a)) {
        return true;
      }
    }
    return false;
  }
  
  public void a(MobileQbossAdvRsp paramMobileQbossAdvRsp, QQAppInterface paramQQAppInterface)
  {
    if (paramMobileQbossAdvRsp != null) {}
    for (;;)
    {
      try
      {
        Object localObject = paramMobileQbossAdvRsp.map_next_query_ts;
        if (localObject != null)
        {
          localObject = (Long)((Map)localObject).get(Integer.valueOf(2742));
          if (localObject != null) {
            QbossADBannerConfigManager.a().a(((Long)localObject).longValue(), 2742);
          }
        }
        paramMobileQbossAdvRsp = paramMobileQbossAdvRsp.mapAdv;
        if ((paramMobileQbossAdvRsp != null) && (paramQQAppInterface != null))
        {
          paramMobileQbossAdvRsp = (ArrayList)paramMobileQbossAdvRsp.get(Integer.valueOf(2742));
          localObject = paramQQAppInterface.getAccount();
          if ((paramMobileQbossAdvRsp != null) && (paramMobileQbossAdvRsp.size() > 0))
          {
            QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp appid =2742");
            QbossSplashCacheManager.a(paramMobileQbossAdvRsp, paramQQAppInterface, (String)localObject);
            i = 1;
            if ((i == 0) && (paramQQAppInterface != null))
            {
              paramMobileQbossAdvRsp = paramQQAppInterface.getAccount();
              QLog.i("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp cleardata");
              QbossSplashUtil.a(BaseApplicationImpl.getContext(), QbossSplashUtil.a(paramMobileQbossAdvRsp), false);
              QbossSplashUtil.b(BaseApplicationImpl.getContext(), QbossSplashUtil.a(paramMobileQbossAdvRsp));
            }
            return;
          }
        }
      }
      catch (Exception paramMobileQbossAdvRsp)
      {
        QLog.e("QSplash@QbossSplashNetService", 1, "handleQbossSplashRsp exception" + paramMobileQbossAdvRsp.toString());
        return;
      }
      int i = 0;
    }
  }
  
  public void a(String paramString, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null) {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendRequestQboss requestType = " + paramString + " contain id = " + paramArrayList.toString());
    }
    QzoneQbossHelper.getInstance().getQbossData(paramArrayList, this, paramString);
  }
  
  public void a(String paramString, MqqHandler paramMqqHandler)
  {
    try
    {
      QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest  minigame preload ");
      paramMqqHandler = new ArrayList();
      boolean bool2 = QbossADBannerConfigManager.a().a(2741);
      if ((bool2) && (!"qboss_banner_net_change".equals(paramString))) {
        paramMqqHandler.add(Integer.valueOf(2741));
      }
      boolean bool1;
      if (ReadInJoyHelper.o(BaseApplicationImpl.getApplication().getRuntime()))
      {
        bool1 = QbossADBannerConfigManager.a().a(2742);
        if (!bool1) {
          break label272;
        }
        paramMqqHandler.add(Integer.valueOf(2742));
      }
      for (;;)
      {
        boolean bool3 = QbossADBannerConfigManager.a().a(2783);
        if (bool3) {
          paramMqqHandler.add(Integer.valueOf(2783));
        }
        if (paramMqqHandler.size() != 0) {
          a(paramString, paramMqqHandler);
        }
        paramMqqHandler = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (("qboss_banner_login".equals(paramString)) && (paramMqqHandler != null))
        {
          if (!bool1)
          {
            QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest checkNeedDowloadAndDowload ");
            a(paramMqqHandler, QbossSplashUtil.a(paramMqqHandler.getAccount()));
          }
          if (!bool3)
          {
            QLog.i("QSplash@QbossSplashNetService", 1, "sendQbossRequest QbossPreDownloadManager.checkPreDownloadResStatus ");
            QbossPreDownloadManager.a().a(paramMqqHandler);
          }
        }
        if ((bool2) || (!"qboss_banner_pull_refresh".equals(paramString)) || (b(paramMqqHandler))) {
          break;
        }
        BannerManager.a().b(23, 3001);
        return;
        QLog.i("QSplash@QbossSplashNetService", 1, "关闭了频控");
        paramMqqHandler.add(Integer.valueOf(2742));
        bool1 = false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QzoneQbossHelper", 1, paramString, new Object[0]);
      return;
    }
    label272:
  }
  
  public void getQbossFail(int paramInt, String paramString1, String paramString2, ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramArrayList.contains(Integer.valueOf(2741)));
      QLog.i("QzoneQbossHelper", 1, "getQbossFail msg = " + paramString1 + " requestType = " + paramString2);
    } while ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime() == null);
    BannerManager.a().b(23, 3001);
  }
  
  public void getQbossSuccess(Bundle paramBundle, String paramString, QQAppInterface paramQQAppInterface)
  {
    QLog.i("QSplash@QbossSplashNetService", 1, "getQbossSuccess requestType = " + paramString);
    try
    {
      ArrayList localArrayList = paramBundle.getIntegerArrayList("appid");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramBundle = paramBundle.getSerializable("data");
        if ((paramBundle != null) && ((paramBundle instanceof MobileQbossAdvRsp)))
        {
          paramBundle = (MobileQbossAdvRsp)paramBundle;
          if (localArrayList.contains(Integer.valueOf(2741))) {
            a(paramBundle, paramString, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2742))) {
            a(paramBundle, paramQQAppInterface);
          }
          if (localArrayList.contains(Integer.valueOf(2783))) {
            b(paramBundle, paramQQAppInterface);
          }
        }
        else
        {
          getQbossFail(-1, "rsp is not MobileQbossAdvRsp", paramString, localArrayList);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("QzoneQbossHelper", 1, paramBundle, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.service.QbossSplashNetService
 * JD-Core Version:    0.7.0.1
 */