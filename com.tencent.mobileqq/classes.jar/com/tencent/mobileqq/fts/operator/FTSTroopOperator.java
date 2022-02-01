package com.tencent.mobileqq.fts.operator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.data.troop.FTSTroop;
import com.tencent.mobileqq.fts.data.troop.FTSTroopSync;
import com.tencent.mobileqq.fts.data.troop.FTSTroopTime;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.fts.interfaces.IFTSTroopInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.FTSOptSync;
import com.tencent.mobileqq.fts.v2.FTSDatabaseHelper;
import com.tencent.mobileqq.fts.v2.FTSQueryArgsV2;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.TroopMemberUpdateObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSTroopOperator
  extends FTSIndexOperator
  implements IFTSTroopInterface, ITroopMemberInfoService.TroopMemberUpdateObserver
{
  public static boolean d = true;
  private IFriendDataService jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService;
  private ITroopInfoService jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private int d = 0;
  private int e;
  protected boolean e;
  private boolean f = false;
  private boolean g = false;
  
  public FTSTroopOperator(AppRuntime paramAppRuntime, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramAppRuntime, paramFTSSyncHandler);
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, ""));
    paramFTSSyncHandler = (ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    if (paramFTSSyncHandler != null) {
      paramFTSSyncHandler.addTroopMemberUpdateObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService = ((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, ""));
  }
  
  private int a(ArrayList<FTSEntity> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext()) {
      i += ((FTSEntity)paramArrayList.next()).mSegmentCount;
    }
    return i;
  }
  
  private FTSTroop a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    paramString1 = new FTSTroop(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString1.preWrite();
    if (paramInt2 == 1)
    {
      paramString1.insertOpt();
      return paramString1;
    }
    if (paramInt2 == 16)
    {
      paramString1.deleteOpt();
      return paramString1;
    }
    if (paramInt2 == 17) {
      paramString1.upgradeOpt();
    }
    return paramString1;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2) {}
  
  private void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((QLog.isColorLevel()) || (paramLong1 > 60000L))
    {
      int i = this.jdField_e_of_type_Int;
      long l = i;
      if (i == 0) {
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
      }
      Object localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" cost:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" indexCnt:");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append(" preIndexCnt:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" segmentTotal:");
      ((StringBuilder)localObject).append(paramInt1);
      l = b(this.jdField_a_of_type_MqqAppAppRuntime);
      if ((paramLong1 > 30000L) && (System.currentTimeMillis() - l > 86400000L))
      {
        QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject).toString());
        localObject = new HashMap();
        ((HashMap)localObject).put("param_count", String.valueOf(paramLong2));
        ((HashMap)localObject).put("param_del", String.valueOf(paramInt2));
        ((HashMap)localObject).put("param_insert", String.valueOf(paramInt3));
        ((HashMap)localObject).put("param_stotal", String.valueOf(paramInt1));
        StatisticCollector.getInstance(this.jdField_a_of_type_MqqAppAppRuntime.getApp()).collectPerformance(null, "actFTSTroopCost", true, paramLong1, 0L, (HashMap)localObject, null, false);
        b(this.jdField_a_of_type_MqqAppAppRuntime, System.currentTimeMillis());
        return;
      }
      QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(FTSTroopSync paramFTSTroopSync)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToDatabase unknown opt:");
      localStringBuilder.append(paramFTSTroopSync.toString());
      QLog.d("Q.fts.troop.operator", 2, localStringBuilder.toString());
    }
  }
  
  private void a(EntityManager paramEntityManager, FTSTroopSync paramFTSTroopSync)
  {
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService.getTroopInfo(String.valueOf(paramFTSTroopSync.mTroopUin));
    if (localTroopInfo != null)
    {
      List localList = paramEntityManager.query(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, "mTroopUin=? ", new String[] { String.valueOf(paramFTSTroopSync.mTroopUin) }, null, null, null, null);
      FTSTroopTime localFTSTroopTime2 = new FTSTroopTime();
      FTSTroopTime localFTSTroopTime1 = localFTSTroopTime2;
      if (localList != null)
      {
        localFTSTroopTime1 = localFTSTroopTime2;
        if (localList.size() > 0) {
          localFTSTroopTime1 = (FTSTroopTime)localList.get(0);
        }
      }
      localFTSTroopTime1.mTroopUin = String.valueOf(paramFTSTroopSync.mTroopUin);
      localFTSTroopTime1.mTimeStamp = localTroopInfo.mMemberNumSeq;
      paramEntityManager.persistOrReplace(localFTSTroopTime1);
      if (QLog.isColorLevel())
      {
        paramEntityManager = new StringBuilder();
        paramEntityManager.append("FTSTroopTime  ");
        paramEntityManager.append(localFTSTroopTime1.toString());
        QLog.d("Q.fts.troop.operator", 2, paramEntityManager.toString());
      }
    }
  }
  
  private void a(ArrayList<FTSOptSync> paramArrayList, List<FTSTroopTime> paramList, HashMap<String, TroopInfo> paramHashMap)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (FTSTroopTime)paramList.next();
        String str = ((FTSTroopTime)localObject).mTroopUin;
        if (paramHashMap.containsKey(str))
        {
          TroopInfo localTroopInfo = (TroopInfo)paramHashMap.get(str);
          if ((localTroopInfo.wMemberNum != 0) && (localTroopInfo.mMemberNumSeq != 0L))
          {
            if (((FTSTroopTime)localObject).mTimeStamp < localTroopInfo.mMemberNumSeq) {
              try
              {
                paramArrayList.add(new FTSTroopSync(5, Long.parseLong(localTroopInfo.troopuin)));
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("checkTroopTimeStamp add troop:");
                localStringBuilder2.append(localTroopInfo.troopname);
                localStringBuilder2.append(" mMemberNumSeq:");
                localStringBuilder2.append(localTroopInfo.mMemberNumSeq);
                localStringBuilder2.append(" troopTime:");
                localStringBuilder2.append(((FTSTroopTime)localObject).toString());
                Utils.a("Q.fts.troop.operator", new Object[] { localStringBuilder2.toString() });
              }
              catch (Exception localException2)
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("checkTroopTimeStamp e:");
                  ((StringBuilder)localObject).append(localException2.toString());
                  QLog.e("Q.fts.troop.operator", 2, ((StringBuilder)localObject).toString());
                }
              }
            }
            paramHashMap.remove(str);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkTroopTimeStamp troop ignore troopuin:");
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(" wMemberNum:");
            ((StringBuilder)localObject).append(localException2.wMemberNum);
            ((StringBuilder)localObject).append(" mMemberNumSeq:");
            ((StringBuilder)localObject).append(localException2.mMemberNumSeq);
            Utils.a("Q.fts.troop.operator", new Object[] { ((StringBuilder)localObject).toString() });
            paramHashMap.remove(str);
          }
        }
        else
        {
          StringBuilder localStringBuilder1;
          try
          {
            paramArrayList.add(new FTSTroopSync(4, Long.parseLong(str)));
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("checkTroopTimeStamp delete troop=");
            localStringBuilder1.append(str);
            Utils.a("Q.fts.troop.operator", new Object[] { localStringBuilder1.toString() });
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("checkTroopTimeStamp e:");
            localStringBuilder1.append(localException1.toString());
            QLog.e("Q.fts.troop.operator", 2, localStringBuilder1.toString());
          }
        }
      }
    }
  }
  
  private void a(List<Entity> paramList, List<FTSTroopTime> paramList1)
  {
    if (paramList != null)
    {
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      Object localObject;
      while (paramList.hasNext())
      {
        localObject = (TroopInfo)paramList.next();
        localHashMap.put(((TroopInfo)localObject).troopuin, localObject);
      }
      paramList = new ArrayList();
      a(paramList, paramList1, localHashMap);
      paramList1 = MessageCache.a;
      int j = 0;
      if ((paramList1 != null) && (MessageCache.a.a != null) && (MessageCache.a.a.size() > 0))
      {
        paramList1 = MessageCache.a.a.entrySet().iterator();
        while (paramList1.hasNext())
        {
          localObject = (Map.Entry)paramList1.next();
          String str1 = (String)((Map.Entry)localObject).getKey();
          i = 0;
          while (i < ((ArrayList)((Map.Entry)localObject).getValue()).size())
          {
            try
            {
              String str2 = (String)((ArrayList)((Map.Entry)localObject).getValue()).get(i);
              paramList.add(new FTSTroopSync(3, Long.parseLong(str1), Long.parseLong(str2)));
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkTroopMemberCache modify troop=");
              localStringBuilder.append(str1);
              localStringBuilder.append(" member=");
              localStringBuilder.append(str2);
              Utils.a("Q.fts.troop.operator", new Object[] { localStringBuilder.toString() });
            }
            catch (Exception localException2)
            {
              StringBuilder localStringBuilder;
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("checkTroopMemberCache e:");
                localStringBuilder.append(localException2.toString());
                QLog.e("Q.fts.troop.operator", 2, localStringBuilder.toString());
              }
            }
            i += 1;
          }
        }
        MessageCache.a.a.clear();
      }
      int i = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
      paramList1 = new StringBuilder();
      paramList1.append("FTSDatabaseHelper.queryItemCount = ");
      paramList1.append(i);
      Utils.a("Q.fts.troop.operator", new Object[] { paramList1.toString() });
      if (i > 0)
      {
        paramList1 = localHashMap.entrySet().iterator();
        i = j;
        while (paramList1.hasNext())
        {
          try
          {
            paramList.add(new FTSTroopSync(5, Long.parseLong((String)((Map.Entry)paramList1.next()).getKey())));
          }
          catch (Exception localException1)
          {
            label453:
            break label453;
          }
          i += 1;
        }
        if ((QLog.isColorLevel()) && (i > 0))
        {
          paramList1 = new StringBuilder();
          paramList1.append("checkTroopTimeStamp add syncData fail ");
          paramList1.append(i);
          QLog.e("Q.fts.troop.operator", 2, paramList1.toString());
        }
      }
      b(paramList);
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("checkTroopTimeStamp optList.size:");
        paramList1.append(paramList.size());
        QLog.d("Q.fts.troop.operator", 2, paramList1.toString());
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_check_stamp");
    localStringBuilder.append(paramAppRuntime.getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localEditor.remove(localStringBuilder.toString()).commit();
  }
  
  private static void a(AppRuntime paramAppRuntime, String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_check_stamp");
    localStringBuilder.append(paramAppRuntime.getAccount());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  private long b(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_troop_time_");
    localStringBuilder.append(paramAppRuntime.getAccount());
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  private void b(AppRuntime paramAppRuntime, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_troop_time_");
    localStringBuilder.append(paramAppRuntime.getAccount());
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("TroopIndex");
    }
    return this.jdField_e_of_type_Int;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, EntityManager paramEntityManager)
  {
    try
    {
      if (this.jdField_a_of_type_Int > 0)
      {
        int i = paramSQLiteDatabase.delete(FTSTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
        if ((QLog.isColorLevel()) && (i > 0))
        {
          paramSQLiteDatabase = new StringBuilder();
          paramSQLiteDatabase.append("delete ");
          paramSQLiteDatabase.append(FTSTroopSync.class.getSimpleName());
          paramSQLiteDatabase.append(" row=");
          paramSQLiteDatabase.append(i);
          QLog.d("Q.fts.troop.operator", 2, paramSQLiteDatabase.toString());
        }
      }
      paramSQLiteDatabase = paramEntityManager.query(FTSTroopSync.class, FTSTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, "300");
      return paramSQLiteDatabase;
    }
    catch (Throwable paramSQLiteDatabase)
    {
      QLog.e("Q.fts.troop.operator", 1, paramSQLiteDatabase, new Object[0]);
      paramSQLiteDatabase = new HashMap();
      paramSQLiteDatabase.put("type", "1");
      StatisticCollector.getInstance(MobileQQ.getMobileQQ().getApplicationContext()).collectPerformance(null, "actGetOptFailed", true, 0L, 0L, paramSQLiteDatabase, null);
    }
    return null;
  }
  
  public List<FTSEntityV2> a(FTSQueryArgsV2 paramFTSQueryArgsV2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) && (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.d()))
    {
      if (paramFTSQueryArgsV2 == null) {
        return null;
      }
      return this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(paramFTSQueryArgsV2);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.post(new FTSTroopOperator.1(this));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService.getTroopInfo(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onQuitTroop troopUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.fts.troop.operator", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(a(4, Long.parseLong(paramString), 0L));
    a(this.jdField_a_of_type_MqqAppAppRuntime, paramString);
    b((ArrayList)localObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService.getTroopInfo(paramString1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeTroopMember troopUin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" memberUin=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.fts.troop.operator", 2, localStringBuilder.toString());
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_e_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_e_of_type_Boolean)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(3, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService.getTroopInfo((String)paramArrayList.get(i));
      if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_e_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_e_of_type_Boolean)))
      {
        localArrayList.add(a(1, Long.parseLong((String)paramArrayList.get(i)), 0L));
        a(this.jdField_a_of_type_MqqAppAppRuntime, (String)paramArrayList.get(i), l);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onTroopMembersUpdate troopuin = ");
          ((StringBuilder)localObject).append((String)paramArrayList.get(i));
          QLog.d("Q.fts.troop.operator", 2, ((StringBuilder)localObject).toString());
        }
      }
      i += 1;
    }
    b(localArrayList);
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    if (!this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(TroopIndex.class)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSUpgrader = new FTSTroopUpgrader(this.jdField_a_of_type_MqqAppAppRuntime, this);
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "init success");
    }
    this.jdField_e_of_type_Int = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, "TroopIndex");
    return true;
  }
  
  /* Error */
  protected boolean a(ArrayList<FTSOptSync> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   4: invokevirtual 572	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   7: invokevirtual 578	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 5
    //   18: invokevirtual 582	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: invokevirtual 587	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   34: aload 4
    //   36: astore_2
    //   37: aload 4
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   44: astore_1
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: astore_3
    //   51: aload_1
    //   52: invokeinterface 77 1 0
    //   57: ifeq +26 -> 83
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: aload_1
    //   69: invokeinterface 81 1 0
    //   74: checkcast 589	com/tencent/mobileqq/fts/v1/FTSOptSync
    //   77: invokevirtual 291	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   80: goto -35 -> 45
    //   83: aload 4
    //   85: astore_2
    //   86: aload 4
    //   88: astore_3
    //   89: aload 4
    //   91: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   94: aload 4
    //   96: ifnull +8 -> 104
    //   99: aload 4
    //   101: invokevirtual 594	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore_1
    //   107: goto +69 -> 176
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +50 -> 166
    //   119: aload_3
    //   120: astore_2
    //   121: new 131	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   128: astore 4
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: ldc_w 596
    //   137: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: astore_2
    //   143: aload 4
    //   145: aload_1
    //   146: invokevirtual 599	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   149: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_3
    //   154: astore_2
    //   155: ldc 242
    //   157: iconst_2
    //   158: aload 4
    //   160: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 602	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 594	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 594	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   184: goto +5 -> 189
    //   187: aload_1
    //   188: athrow
    //   189: goto -2 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	FTSTroopOperator
    //   0	192	1	paramArrayList	ArrayList<FTSOptSync>
    //   15	166	2	localObject1	Object
    //   13	158	3	localObject2	Object
    //   21	138	4	localObject3	Object
    //   10	57	5	localEntityManager	EntityManager
    // Exception table:
    //   from	to	target	type
    //   16	23	106	finally
    //   29	34	106	finally
    //   40	45	106	finally
    //   51	60	106	finally
    //   66	80	106	finally
    //   89	94	106	finally
    //   113	119	106	finally
    //   121	130	106	finally
    //   132	141	106	finally
    //   143	153	106	finally
    //   155	166	106	finally
    //   16	23	110	java/lang/Exception
    //   29	34	110	java/lang/Exception
    //   40	45	110	java/lang/Exception
    //   51	60	110	java/lang/Exception
    //   66	80	110	java/lang/Exception
    //   89	94	110	java/lang/Exception
  }
  
  public String b()
  {
    return "TroopIndex";
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopMembersFailed troopUin:");
      localStringBuilder.append(paramString);
      QLog.d("Q.fts.troop.operator", 2, localStringBuilder.toString());
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService.getTroopInfo(paramString1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKickoutTroopMember troopUin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" memberUin=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.fts.troop.operator", 2, localStringBuilder.toString());
    }
    if (((((TroopInfo)localObject).isNewTroop()) && (this.jdField_e_of_type_Boolean)) || ((!((TroopInfo)localObject).isNewTroop()) && (!this.jdField_e_of_type_Boolean)))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a(2, Long.parseLong(paramString1), Long.parseLong(paramString2)));
      b((ArrayList)localObject);
    }
  }
  
  protected void b(ArrayList<FTSOptSync> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.post(new FTSTroopOperator.2(this, paramArrayList));
  }
  
  protected String c()
  {
    return "TroopCursor";
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        bool1 = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, c());
        bool2 = bool1;
        try
        {
          if (!QLog.isColorLevel()) {
            break label98;
          }
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("FTSDatabaseHelper.isTableExist = ");
          localStringBuilder1.append(bool1);
          QLog.d("Q.fts.troop.operator", 2, localStringBuilder1.toString());
          bool2 = bool1;
        }
        catch (Throwable localThrowable1) {}
        bool2 = bool1;
      }
      catch (Throwable localThrowable2)
      {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("Q.fts.troop.operator", 2, "isCursorTableExist: failure ", localThrowable2);
        bool2 = bool1;
      }
      label98:
      StringBuilder localStringBuilder2;
      if (!bool2)
      {
        bool1 = FTSDatabaseHelper.b(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, c());
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("FTSDatabaseHelper.createCursorTable = ");
          localStringBuilder2.append(bool1);
          QLog.d("Q.fts.troop.operator", 2, localStringBuilder2.toString());
        }
        if (!bool1) {
          return false;
        }
      }
      int i = FTSDatabaseHelper.a(this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase, c());
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("FTSDatabaseHelper.queryCursorTable = ");
        localStringBuilder2.append(i);
        QLog.d("Q.fts.troop.operator", 2, localStringBuilder2.toString());
      }
      if (i == -1) {
        return false;
      }
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("readSyncedCursor: syncCursor = ");
        localStringBuilder2.append(i);
        QLog.d("Q.fts.troop.operator", 2, localStringBuilder2.toString());
      }
    }
    return true;
  }
  
  public void d()
  {
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    if (localITroopMemberInfoService != null) {
      localITroopMemberInfoService.removeTroopMemberUpdateObserver(this);
    }
  }
  
  protected boolean e()
  {
    return true;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 399	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   4: ifnull +1271 -> 1275
    //   7: aload_0
    //   8: getfield 399	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   11: invokevirtual 512	com/tencent/mobileqq/fts/FTSDatabase:d	()Z
    //   14: ifeq +1261 -> 1275
    //   17: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   20: lstore 9
    //   22: aload_0
    //   23: getfield 53	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   26: invokevirtual 650	mqq/app/AppRuntime:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   29: astore 17
    //   31: aload_0
    //   32: getfield 53	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   35: invokevirtual 572	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   38: invokevirtual 578	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   41: astore 22
    //   43: aload_0
    //   44: aload 17
    //   46: aload 22
    //   48: invokevirtual 652	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(Lcom/tencent/mobileqq/app/SQLiteDatabase;Lcom/tencent/mobileqq/persistence/EntityManager;)Ljava/util/List;
    //   51: astore 17
    //   53: new 131	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   60: astore 18
    //   62: aload 18
    //   64: ldc_w 654
    //   67: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 17
    //   73: ifnull +14 -> 87
    //   76: aload 17
    //   78: invokeinterface 272 1 0
    //   83: istore_1
    //   84: goto +5 -> 89
    //   87: iconst_0
    //   88: istore_1
    //   89: aload 18
    //   91: iload_1
    //   92: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 242
    //   98: iconst_1
    //   99: anewarray 136	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload 18
    //   106: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aastore
    //   110: invokestatic 337	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload 17
    //   115: ifnull +1155 -> 1270
    //   118: aload 17
    //   120: invokeinterface 298 1 0
    //   125: astore 23
    //   127: iconst_0
    //   128: istore_2
    //   129: iconst_0
    //   130: istore 4
    //   132: iconst_0
    //   133: istore_1
    //   134: iconst_0
    //   135: istore_3
    //   136: aload 23
    //   138: invokeinterface 77 1 0
    //   143: ifeq +1085 -> 1228
    //   146: aload 23
    //   148: invokeinterface 81 1 0
    //   153: checkcast 589	com/tencent/mobileqq/fts/v1/FTSOptSync
    //   156: astore 17
    //   158: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   161: lstore 11
    //   163: aload 17
    //   165: checkcast 239	com/tencent/mobileqq/fts/data/troop/FTSTroopSync
    //   168: astore 17
    //   170: aload_0
    //   171: getfield 50	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService	Lcom/tencent/mobileqq/troop/api/ITroopInfoService;
    //   174: aload 17
    //   176: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   179: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   182: invokeinterface 658 2 0
    //   187: ifeq +52 -> 239
    //   190: new 131	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   197: astore 18
    //   199: aload 18
    //   201: ldc_w 660
    //   204: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 18
    //   210: aload 17
    //   212: invokevirtual 240	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:toString	()Ljava/lang/String;
    //   215: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 242
    //   221: iconst_1
    //   222: anewarray 136	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 18
    //   229: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 337	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto +1040 -> 1276
    //   239: new 67	java/util/ArrayList
    //   242: dup
    //   243: invokespecial 353	java/util/ArrayList:<init>	()V
    //   246: astore 18
    //   248: aload 17
    //   250: getfield 663	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mOpt	I
    //   253: iconst_3
    //   254: if_icmpne +268 -> 522
    //   257: aload 17
    //   259: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   262: lstore 13
    //   264: aload 17
    //   266: getfield 666	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mMemberUin	J
    //   269: lstore 15
    //   271: aload 18
    //   273: astore 21
    //   275: aload 17
    //   277: astore 20
    //   279: aload 21
    //   281: aload_0
    //   282: iconst_2
    //   283: lload 13
    //   285: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   288: lload 15
    //   290: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   293: ldc 42
    //   295: ldc 42
    //   297: ldc 42
    //   299: bipush 16
    //   301: invokespecial 668	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/fts/data/troop/FTSTroop;
    //   304: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   307: pop
    //   308: iload_2
    //   309: iconst_1
    //   310: iadd
    //   311: istore_2
    //   312: aload_0
    //   313: getfield 53	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   316: ldc 55
    //   318: ldc 42
    //   320: invokevirtual 48	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   323: checkcast 55	com/tencent/mobileqq/troop/api/ITroopMemberInfoService
    //   326: aload 20
    //   328: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   331: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   334: aload 20
    //   336: getfield 666	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mMemberUin	J
    //   339: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   342: invokeinterface 672 3 0
    //   347: astore 24
    //   349: aload_0
    //   350: getfield 63	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   353: aload 20
    //   355: getfield 666	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mMemberUin	J
    //   358: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   361: iconst_1
    //   362: invokeinterface 676 3 0
    //   367: astore 25
    //   369: aload 25
    //   371: ifnull +13 -> 384
    //   374: aload 25
    //   376: getfield 681	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   379: astore 19
    //   381: goto +7 -> 388
    //   384: ldc 42
    //   386: astore 19
    //   388: aload 24
    //   390: ifnull +63 -> 453
    //   393: aload 25
    //   395: ifnull +13 -> 408
    //   398: aload 25
    //   400: getfield 684	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   403: astore 20
    //   405: goto +10 -> 415
    //   408: aload 24
    //   410: getfield 689	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   413: astore 20
    //   415: aload 21
    //   417: aload_0
    //   418: iconst_2
    //   419: aload 24
    //   421: getfield 690	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   424: aload 24
    //   426: getfield 693	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   429: aload 20
    //   431: aload 24
    //   433: getfield 696	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   436: aload 19
    //   438: iconst_1
    //   439: invokespecial 668	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/fts/data/troop/FTSTroop;
    //   442: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   445: pop
    //   446: iload_1
    //   447: iconst_1
    //   448: iadd
    //   449: istore_1
    //   450: goto +122 -> 572
    //   453: new 131	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   460: astore 19
    //   462: aload 19
    //   464: ldc_w 698
    //   467: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 19
    //   473: aload 20
    //   475: getfield 666	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mMemberUin	J
    //   478: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 19
    //   484: ldc_w 700
    //   487: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 19
    //   493: aload 20
    //   495: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   498: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: ldc 242
    //   504: iconst_1
    //   505: anewarray 136	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: aload 19
    //   512: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: aastore
    //   516: invokestatic 337	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   519: goto +53 -> 572
    //   522: aload 18
    //   524: astore 21
    //   526: aload 17
    //   528: astore 19
    //   530: aload 19
    //   532: getfield 663	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mOpt	I
    //   535: iconst_4
    //   536: if_icmpne +39 -> 575
    //   539: aload 21
    //   541: aload_0
    //   542: iconst_2
    //   543: aload 19
    //   545: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   548: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   551: ldc 42
    //   553: ldc 42
    //   555: ldc 42
    //   557: ldc 42
    //   559: bipush 16
    //   561: invokespecial 668	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/fts/data/troop/FTSTroop;
    //   564: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   567: pop
    //   568: iload_2
    //   569: iconst_1
    //   570: iadd
    //   571: istore_2
    //   572: goto +427 -> 999
    //   575: aload 19
    //   577: getfield 663	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mOpt	I
    //   580: iconst_1
    //   581: if_icmpeq +71 -> 652
    //   584: aload 19
    //   586: getfield 663	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mOpt	I
    //   589: iconst_5
    //   590: if_icmpne +6 -> 596
    //   593: goto +59 -> 652
    //   596: aload 19
    //   598: getfield 663	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mOpt	I
    //   601: iconst_2
    //   602: if_icmpne +41 -> 643
    //   605: aload 21
    //   607: aload_0
    //   608: iconst_2
    //   609: aload 19
    //   611: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   614: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   617: aload 19
    //   619: getfield 666	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mMemberUin	J
    //   622: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   625: ldc 42
    //   627: ldc 42
    //   629: ldc 42
    //   631: bipush 16
    //   633: invokespecial 668	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/fts/data/troop/FTSTroop;
    //   636: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   639: pop
    //   640: goto -72 -> 568
    //   643: aload_0
    //   644: aload 19
    //   646: invokespecial 702	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(Lcom/tencent/mobileqq/fts/data/troop/FTSTroopSync;)V
    //   649: goto -77 -> 572
    //   652: aload_0
    //   653: getfield 53	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   656: ldc 55
    //   658: ldc 42
    //   660: invokevirtual 48	mqq/app/AppRuntime:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   663: checkcast 55	com/tencent/mobileqq/troop/api/ITroopMemberInfoService
    //   666: aload 19
    //   668: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   671: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   674: invokeinterface 706 2 0
    //   679: astore 20
    //   681: aload 20
    //   683: ifnonnull +21 -> 704
    //   686: ldc 242
    //   688: iconst_1
    //   689: anewarray 136	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: ldc_w 708
    //   697: aastore
    //   698: invokestatic 337	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   701: goto +575 -> 1276
    //   704: aload 19
    //   706: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   709: lstore 13
    //   711: iload_2
    //   712: istore 6
    //   714: iload_1
    //   715: istore 5
    //   717: aload 21
    //   719: aload_0
    //   720: iconst_2
    //   721: lload 13
    //   723: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   726: ldc 42
    //   728: ldc 42
    //   730: ldc 42
    //   732: ldc 42
    //   734: bipush 16
    //   736: invokespecial 668	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/fts/data/troop/FTSTroop;
    //   739: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   742: pop
    //   743: iload_2
    //   744: iconst_1
    //   745: iadd
    //   746: istore 8
    //   748: iload 8
    //   750: istore 6
    //   752: iload_1
    //   753: istore 5
    //   755: aload 20
    //   757: invokeinterface 298 1 0
    //   762: astore 24
    //   764: iload 8
    //   766: istore 6
    //   768: iload_1
    //   769: istore 5
    //   771: iload 8
    //   773: istore_2
    //   774: iload_1
    //   775: istore 7
    //   777: aload 24
    //   779: invokeinterface 77 1 0
    //   784: ifeq +212 -> 996
    //   787: iload 8
    //   789: istore 6
    //   791: iload_1
    //   792: istore 5
    //   794: aload 24
    //   796: invokeinterface 81 1 0
    //   801: checkcast 686	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   804: astore 25
    //   806: iload 8
    //   808: istore 6
    //   810: iload_1
    //   811: istore 5
    //   813: aload 25
    //   815: getfield 693	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   818: invokestatic 710	com/tencent/mobileqq/util/Utils:d	(Ljava/lang/String;)Z
    //   821: ifeq -57 -> 764
    //   824: iload 8
    //   826: istore 6
    //   828: iload_1
    //   829: istore 5
    //   831: aload_0
    //   832: getfield 63	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService	Lcom/tencent/mobileqq/friend/api/IFriendDataService;
    //   835: aload 25
    //   837: getfield 693	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   840: invokestatic 713	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   843: iconst_1
    //   844: invokeinterface 676 3 0
    //   849: astore 20
    //   851: aload 20
    //   853: ifnull +426 -> 1279
    //   856: iload 8
    //   858: istore 6
    //   860: iload_1
    //   861: istore 5
    //   863: aload 20
    //   865: getfield 681	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   868: astore 19
    //   870: goto +3 -> 873
    //   873: aload 20
    //   875: ifnull +20 -> 895
    //   878: iload 8
    //   880: istore 6
    //   882: iload_1
    //   883: istore 5
    //   885: aload 20
    //   887: getfield 684	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   890: astore 20
    //   892: goto +17 -> 909
    //   895: iload 8
    //   897: istore 6
    //   899: iload_1
    //   900: istore 5
    //   902: aload 25
    //   904: getfield 689	com/tencent/mobileqq/data/troop/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   907: astore 20
    //   909: iload 8
    //   911: istore 6
    //   913: iload_1
    //   914: istore 5
    //   916: aload 21
    //   918: aload_0
    //   919: iconst_2
    //   920: aload 25
    //   922: getfield 690	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   925: aload 25
    //   927: getfield 693	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   930: aload 20
    //   932: aload 25
    //   934: getfield 696	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   937: aload 19
    //   939: iconst_1
    //   940: invokespecial 668	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/fts/data/troop/FTSTroop;
    //   943: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   946: pop
    //   947: iload_1
    //   948: iconst_1
    //   949: iadd
    //   950: istore_1
    //   951: goto -187 -> 764
    //   954: astore 19
    //   956: iload 5
    //   958: istore_1
    //   959: goto +8 -> 967
    //   962: astore 19
    //   964: iload_2
    //   965: istore 6
    //   967: iload 6
    //   969: istore_2
    //   970: iload_1
    //   971: istore 7
    //   973: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   976: ifeq +20 -> 996
    //   979: ldc 242
    //   981: iconst_2
    //   982: ldc_w 715
    //   985: aload 19
    //   987: invokestatic 633	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   990: iload_1
    //   991: istore 7
    //   993: iload 6
    //   995: istore_2
    //   996: iload 7
    //   998: istore_1
    //   999: new 131	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   1006: astore 19
    //   1008: aload 19
    //   1010: ldc_w 717
    //   1013: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 19
    //   1019: aload 17
    //   1021: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   1024: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload 19
    //   1030: ldc_w 719
    //   1033: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload 19
    //   1039: aload 18
    //   1041: invokevirtual 384	java/util/ArrayList:size	()I
    //   1044: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload 19
    //   1050: ldc_w 721
    //   1053: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 19
    //   1059: aload 17
    //   1061: getfield 663	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mOpt	I
    //   1064: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: ldc 242
    //   1070: iconst_1
    //   1071: anewarray 136	java/lang/Object
    //   1074: dup
    //   1075: iconst_0
    //   1076: aload 19
    //   1078: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: aastore
    //   1082: invokestatic 337	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1085: aload_0
    //   1086: getfield 399	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   1089: aload 18
    //   1091: aload_0
    //   1092: invokevirtual 620	com/tencent/mobileqq/fts/operator/FTSTroopOperator:c	()Ljava/lang/String;
    //   1095: iconst_1
    //   1096: invokestatic 724	com/tencent/mobileqq/fts/v2/FTSDatabaseHelper:a	(Lcom/tencent/mobileqq/fts/FTSDatabase;Ljava/util/ArrayList;Ljava/lang/String;I)I
    //   1099: istore 5
    //   1101: iload 5
    //   1103: iconst_m1
    //   1104: if_icmpeq +9 -> 1113
    //   1107: aload_0
    //   1108: iload 5
    //   1110: putfield 471	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_Int	I
    //   1113: aload_0
    //   1114: aload 22
    //   1116: aload 17
    //   1118: invokespecial 726	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/fts/data/troop/FTSTroopSync;)V
    //   1121: aload_0
    //   1122: aload 18
    //   1124: invokespecial 728	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(Ljava/util/ArrayList;)I
    //   1127: istore 5
    //   1129: iload_3
    //   1130: iload 5
    //   1132: iadd
    //   1133: istore_3
    //   1134: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   1137: lstore 13
    //   1139: ldc 242
    //   1141: iconst_4
    //   1142: anewarray 136	java/lang/Object
    //   1145: dup
    //   1146: iconst_0
    //   1147: ldc_w 730
    //   1150: aastore
    //   1151: dup
    //   1152: iconst_1
    //   1153: aload 17
    //   1155: getfield 251	com/tencent/mobileqq/fts/data/troop/FTSTroopSync:mTroopUin	J
    //   1158: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1161: aastore
    //   1162: dup
    //   1163: iconst_2
    //   1164: lload 13
    //   1166: lload 11
    //   1168: lsub
    //   1169: invokestatic 199	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1172: aastore
    //   1173: dup
    //   1174: iconst_3
    //   1175: iload 5
    //   1177: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1180: aastore
    //   1181: invokestatic 337	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1184: iload 4
    //   1186: aload 18
    //   1188: invokevirtual 384	java/util/ArrayList:size	()I
    //   1191: iadd
    //   1192: istore 4
    //   1194: iload 4
    //   1196: sipush 300
    //   1199: if_icmpgt +16 -> 1215
    //   1202: aload_0
    //   1203: invokevirtual 731	com/tencent/mobileqq/fts/operator/FTSTroopOperator:d	()Z
    //   1206: ifne +6 -> 1212
    //   1209: goto +6 -> 1215
    //   1212: goto +64 -> 1276
    //   1215: aload_0
    //   1216: iload 4
    //   1218: lload 13
    //   1220: lload 9
    //   1222: invokespecial 733	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(IJJ)V
    //   1225: goto +3 -> 1228
    //   1228: invokestatic 177	java/lang/System:currentTimeMillis	()J
    //   1231: lload 9
    //   1233: lsub
    //   1234: lstore 9
    //   1236: aload_0
    //   1237: aload_0
    //   1238: getfield 735	com/tencent/mobileqq/fts/operator/FTSTroopOperator:c	I
    //   1241: iload 4
    //   1243: iadd
    //   1244: putfield 735	com/tencent/mobileqq/fts/operator/FTSTroopOperator:c	I
    //   1247: aload_0
    //   1248: aload_0
    //   1249: getfield 737	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_Long	J
    //   1252: lload 9
    //   1254: ladd
    //   1255: putfield 737	com/tencent/mobileqq/fts/operator/FTSTroopOperator:jdField_a_of_type_Long	J
    //   1258: aload_0
    //   1259: lload 9
    //   1261: iload 4
    //   1263: i2l
    //   1264: iload_3
    //   1265: iload_2
    //   1266: iload_1
    //   1267: invokespecial 739	com/tencent/mobileqq/fts/operator/FTSTroopOperator:a	(JJIII)V
    //   1270: aload 22
    //   1272: invokevirtual 742	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1275: return
    //   1276: goto -1140 -> 136
    //   1279: ldc 42
    //   1281: astore 19
    //   1283: goto -410 -> 873
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	this	FTSTroopOperator
    //   83	1184	1	i	int
    //   128	1138	2	j	int
    //   135	1130	3	k	int
    //   130	1132	4	m	int
    //   715	461	5	n	int
    //   712	282	6	i1	int
    //   775	222	7	i2	int
    //   746	164	8	i3	int
    //   20	1240	9	l1	long
    //   161	1006	11	l2	long
    //   262	957	13	l3	long
    //   269	20	15	l4	long
    //   29	1125	17	localObject1	Object
    //   60	1127	18	localObject2	Object
    //   379	559	19	localObject3	Object
    //   954	1	19	localThrowable1	Throwable
    //   962	24	19	localThrowable2	Throwable
    //   1006	276	19	localObject4	Object
    //   277	654	20	localObject5	Object
    //   273	644	21	localObject6	Object
    //   41	1230	22	localEntityManager	EntityManager
    //   125	22	23	localIterator	Iterator
    //   347	448	24	localObject7	Object
    //   367	566	25	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   717	743	954	java/lang/Throwable
    //   755	764	954	java/lang/Throwable
    //   777	787	954	java/lang/Throwable
    //   794	806	954	java/lang/Throwable
    //   813	824	954	java/lang/Throwable
    //   831	851	954	java/lang/Throwable
    //   863	870	954	java/lang/Throwable
    //   885	892	954	java/lang/Throwable
    //   902	909	954	java/lang/Throwable
    //   916	947	954	java/lang/Throwable
    //   652	681	962	java/lang/Throwable
    //   686	701	962	java/lang/Throwable
    //   704	711	962	java/lang/Throwable
  }
  
  public boolean f()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSTroopOperator
 * JD-Core Version:    0.7.0.1
 */