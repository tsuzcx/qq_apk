package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import amtb;
import amtc;
import aukm;
import aukn;
import auko;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
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
  
  /* Error */
  private void saveLocalSearchDataList(List<MiniAppLocalSearchEntity> paramList)
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/mobileqq/mini/entry/MiniAppLocalSearchManager:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +16 -> 21
    //   8: aload_1
    //   9: invokeinterface 76 1 0
    //   14: ifeq +7 -> 21
    //   17: aload_2
    //   18: ifnonnull +29 -> 47
    //   21: ldc 10
    //   23: iconst_2
    //   24: new 78	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   31: ldc 81
    //   33: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: aload_2
    //   48: invokevirtual 101	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lauko;
    //   51: invokevirtual 107	auko:createEntityManager	()Laukn;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -10 -> 46
    //   59: aload_3
    //   60: invokevirtual 113	aukn:a	()Laukp;
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 117	aukp:a	()V
    //   68: aload_1
    //   69: invokeinterface 121 1 0
    //   74: astore_1
    //   75: aload_1
    //   76: invokeinterface 126 1 0
    //   81: ifeq +42 -> 123
    //   84: aload_0
    //   85: aload_3
    //   86: aload_1
    //   87: invokeinterface 130 1 0
    //   92: checkcast 132	com/tencent/mobileqq/mini/entry/MiniAppLocalSearchEntity
    //   95: invokespecial 56	com/tencent/mobileqq/mini/entry/MiniAppLocalSearchManager:updateEntity	(Laukn;Laukm;)Z
    //   98: pop
    //   99: goto -24 -> 75
    //   102: astore_1
    //   103: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +12 -> 118
    //   109: ldc 10
    //   111: iconst_2
    //   112: ldc 134
    //   114: aload_1
    //   115: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_2
    //   119: invokevirtual 140	aukp:b	()V
    //   122: return
    //   123: aload_2
    //   124: invokevirtual 143	aukp:c	()V
    //   127: aload_2
    //   128: invokevirtual 140	aukp:b	()V
    //   131: return
    //   132: astore_1
    //   133: aload_2
    //   134: invokevirtual 140	aukp:b	()V
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	MiniAppLocalSearchManager
    //   0	139	1	paramList	List<MiniAppLocalSearchEntity>
    //   3	131	2	localObject	Object
    //   54	32	3	localaukn	aukn
    // Exception table:
    //   from	to	target	type
    //   68	75	102	java/lang/Exception
    //   75	99	102	java/lang/Exception
    //   123	127	102	java/lang/Exception
    //   68	75	132	finally
    //   75	99	132	finally
    //   103	118	132	finally
    //   123	127	132	finally
  }
  
  private boolean updateEntity(aukn paramaukn, aukm paramaukm)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramaukn.a()) {
      if (paramaukm.getStatus() == 1000)
      {
        paramaukn.b(paramaukm);
        if (paramaukm.getStatus() == 1001) {
          bool1 = true;
        }
        paramaukn.a();
      }
    }
    do
    {
      return bool1;
      if ((paramaukm.getStatus() != 1001) && (paramaukm.getStatus() != 1002)) {
        break;
      }
      bool1 = paramaukn.a(paramaukm);
      break;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppLocalSearchManager", 2, "updateEntity em closed e=" + paramaukm.getTableName());
    return false;
  }
  
  private void updateLocalSearchData(List<MiniAppLocalSearchEntity> paramList)
  {
    ThreadManager.excute(new MiniAppLocalSearchManager.1(this, paramList), 32, null, true);
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
    amtb localamtb = amtc.a();
    if (localamtb != null) {}
    for (boolean bool = localamtb.b();; bool = false)
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
      return ((aukn)localObject).a(MiniAppLocalSearchEntity.class, MiniAppLocalSearchEntity.class.getSimpleName(), false, null, null, null, null, null, null);
    }
  }
  
  public void onDestroy() {}
  
  public void sendLocalSearchDataRequest()
  {
    MiniAppCmdUtil.getInstance().getLocalSearchData(this.mExtInfo, new MiniAppLocalSearchManager.2(this));
  }
  
  public void updateDataToDB(MiniAppInfo paramMiniAppInfo)
  {
    ThreadManager.excute(new MiniAppLocalSearchManager.3(this, paramMiniAppInfo), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager
 * JD-Core Version:    0.7.0.1
 */