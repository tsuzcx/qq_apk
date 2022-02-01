package com.tencent.mobileqq.fts.operator;

import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.fts.data.troop.FTSNewTroopSync;
import com.tencent.mobileqq.fts.v1.FTSOptSync;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSNewTroopOperator
  extends FTSTroopOperator
{
  public FTSNewTroopOperator(AppRuntime paramAppRuntime, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramAppRuntime, paramFTSSyncHandler);
    this.e = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, EntityManager paramEntityManager)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (this.a > 0)
        {
          localObject1 = localObject2;
          i = paramSQLiteDatabase.delete(FTSNewTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.a) });
          localObject1 = localObject2;
          if ((QLog.isColorLevel()) && (i > 0))
          {
            localObject1 = localObject2;
            paramSQLiteDatabase = new StringBuilder();
            localObject1 = localObject2;
            paramSQLiteDatabase.append("delete ");
            localObject1 = localObject2;
            paramSQLiteDatabase.append(FTSNewTroopSync.class.getSimpleName());
            localObject1 = localObject2;
            paramSQLiteDatabase.append(" row=");
            localObject1 = localObject2;
            paramSQLiteDatabase.append(i);
            localObject1 = localObject2;
            QLog.d("Q.fts.troop.operator.new", 2, paramSQLiteDatabase.toString());
          }
        }
        localObject1 = localObject2;
        paramEntityManager = paramEntityManager.query(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.a) }, null, null, null, "300");
        paramSQLiteDatabase = localObject3;
        if (paramEntityManager != null)
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = new ArrayList(paramEntityManager.size());
          try
          {
            paramEntityManager = paramEntityManager.iterator();
            if (paramEntityManager.hasNext())
            {
              paramSQLiteDatabase.add(((FTSNewTroopSync)paramEntityManager.next()).transTroopSync());
              continue;
            }
          }
          catch (Throwable paramEntityManager)
          {
            localObject1 = paramSQLiteDatabase;
            continue;
          }
        }
        localObject1 = paramSQLiteDatabase;
        paramEntityManager = paramSQLiteDatabase;
        if (QLog.isColorLevel())
        {
          localObject1 = paramSQLiteDatabase;
          paramEntityManager = new StringBuilder();
          localObject1 = paramSQLiteDatabase;
          paramEntityManager.append("getOptSyncList size:");
          if (paramSQLiteDatabase == null) {
            break label371;
          }
          localObject1 = paramSQLiteDatabase;
          i = paramSQLiteDatabase.size();
          localObject1 = paramSQLiteDatabase;
          paramEntityManager.append(i);
          localObject1 = paramSQLiteDatabase;
          QLog.d("Q.fts.troop.operator.new", 2, paramEntityManager.toString());
          return paramSQLiteDatabase;
        }
      }
      catch (Throwable paramEntityManager)
      {
        QLog.e("Q.fts.troop.operator.new", 1, paramEntityManager, new Object[0]);
        paramSQLiteDatabase = new HashMap();
        paramSQLiteDatabase.put("type", "2");
        StatisticCollector.getInstance(MobileQQ.getMobileQQ().getApplicationContext()).collectPerformance(null, "actGetOptFailed", true, 0L, 0L, paramSQLiteDatabase, null);
        paramEntityManager = (EntityManager)localObject1;
      }
      return paramEntityManager;
      label371:
      int i = 0;
    }
  }
  
  protected String c()
  {
    return "NewTroopCursor";
  }
  
  public void g() {}
  
  public boolean g()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSNewTroopOperator
 * JD-Core Version:    0.7.0.1
 */