package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;

public class MiniAppLocalSearchManager
  implements Manager
{
  public static final String TAG = "MiniAppLocalSearchManager";
  private COMM.StCommonExt mBatchQueryExtInfo;
  private COMM.StCommonExt mExtInfo;
  
  public MiniAppLocalSearchManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLocalSearchManager", 2, "MiniAppLocalSearchManager init.");
    }
  }
  
  private static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  private boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = paramEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
      }
      else if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002))
      {
        bool1 = paramEntityManager.update(paramEntity);
      }
      paramEntityManager.close();
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("updateEntity em closed e=");
      paramEntityManager.append(paramEntity.getTableName());
      QLog.d("MiniAppLocalSearchManager", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  public List<MiniAppLocalSearchEntity> getLocalSearchData()
  {
    Object localObject = getAppInterface();
    List localList = null;
    if (localObject == null)
    {
      QLog.e("MiniAppLocalSearchManager", 2, "getLocalSearchData, app is null.");
      return null;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    boolean bool = false;
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    if (localMiniAppConfBean != null) {
      bool = localMiniAppConfBean.b();
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppLocalSearchManager", 2, "getLocalSearchData, close local search.");
      }
      return null;
    }
    if (localObject != null) {
      localList = ((EntityManager)localObject).query(MiniAppLocalSearchEntity.class, MiniAppLocalSearchEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    }
    return localList;
  }
  
  public void onDestroy() {}
  
  public void updateDataDbFromNetResult(MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity)
  {
    ThreadManager.excute(new MiniAppLocalSearchManager.2(this, paramMiniAppLocalSearchEntity), 32, null, true);
  }
  
  public void updateDataToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.excute(new MiniAppLocalSearchManager.1(this, paramMiniAppInfo), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager
 * JD-Core Version:    0.7.0.1
 */