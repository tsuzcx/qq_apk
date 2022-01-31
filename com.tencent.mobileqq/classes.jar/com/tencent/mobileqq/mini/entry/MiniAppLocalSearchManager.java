package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import aool;
import aoom;
import awge;
import awgf;
import awgg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
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
  
  private boolean updateEntity(awgf paramawgf, awge paramawge)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramawgf.a()) {
      if (paramawge.getStatus() == 1000)
      {
        paramawgf.b(paramawge);
        if (paramawge.getStatus() == 1001) {
          bool1 = true;
        }
        paramawgf.a();
      }
    }
    do
    {
      return bool1;
      if ((paramawge.getStatus() != 1001) && (paramawge.getStatus() != 1002)) {
        break;
      }
      bool1 = paramawgf.a(paramawge);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppLocalSearchManager", 2, "updateEntity em closed e=" + paramawge.getTableName());
    return false;
  }
  
  public List<MiniAppLocalSearchEntity> getLocalSearchData()
  {
    Object localObject = getAppInterface();
    if (localObject == null)
    {
      QLog.e("MiniAppLocalSearchManager", 2, "getLocalSearchData, app is null.");
      return null;
    }
    localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
    aool localaool = aoom.a();
    if (localaool != null) {}
    for (boolean bool = localaool.b();; bool = false)
    {
      if (!bool)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MiniAppLocalSearchManager", 2, "getLocalSearchData, close local search.");
        return null;
      }
      if (localObject == null) {
        break;
      }
      return ((awgf)localObject).a(MiniAppLocalSearchEntity.class, MiniAppLocalSearchEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager
 * JD-Core Version:    0.7.0.1
 */