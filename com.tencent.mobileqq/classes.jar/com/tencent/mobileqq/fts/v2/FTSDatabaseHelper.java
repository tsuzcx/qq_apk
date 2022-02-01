package com.tencent.mobileqq.fts.v2;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.data.troop.FTSTroop;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FTSDatabaseHelper
{
  public static int a(FTSDatabase paramFTSDatabase, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT cursor FROM ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" WHERE id=1;");
    paramString = localStringBuilder.toString();
    try
    {
      int i = c(paramFTSDatabase, paramString);
      return i;
    }
    catch (SQLiteException paramFTSDatabase)
    {
      label41:
      break label41;
    }
    return -1;
  }
  
  public static int a(FTSDatabase paramFTSDatabase, ArrayList<FTSEntity> paramArrayList, String paramString, int paramInt)
  {
    String str = "Q.fts.FTSDatabaseHelper";
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      long l1 = System.currentTimeMillis();
      int j = a(paramFTSDatabase, paramString);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FTSDatabaseHelper.queryCursorTable = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" cost:");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
        QLog.d("Q.fts.FTSDatabaseHelper", 2, ((StringBuilder)localObject).toString());
      }
      if (j == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.fts.FTSDatabaseHelper", 2, "batchTransToDatabase: syncCursor == -1");
        }
        return -1;
      }
      if (!paramFTSDatabase.b())
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.fts.FTSDatabaseHelper", 2, "batchTransToDatabase: beginTransaction failed");
        }
        return -1;
      }
      long l3 = 0L;
      l1 = l3;
      long l2 = l1;
      int k = 0;
      int i = 0;
      boolean bool1 = true;
      while (k < paramArrayList.size())
      {
        long l4 = System.currentTimeMillis();
        localObject = (FTSTroop)paramArrayList.get(k);
        TroopIndex localTroopIndex = new TroopIndex(((FTSTroop)localObject).mType, ((FTSTroop)localObject).mTroopUin, ((FTSTroop)localObject).mMemberUin, ((FTSTroop)localObject).mMemberName, ((FTSTroop)localObject).mMemberCard, ((FTSTroop)localObject).mMemberNick);
        localTroopIndex.preWrite();
        int m = ((FTSTroop)localObject).mOpt;
        if (m != 1)
        {
          if (m != 16)
          {
            if (m == 17)
            {
              bool2 = a(paramFTSDatabase, localTroopIndex);
              bool1 = bool2;
              if (bool2) {
                bool1 = paramFTSDatabase.a(localTroopIndex);
              }
              l2 += System.currentTimeMillis() - l4;
            }
          }
          else
          {
            bool1 = a(paramFTSDatabase, localTroopIndex);
            l1 += System.currentTimeMillis() - l4;
          }
        }
        else
        {
          bool1 = paramFTSDatabase.a(localTroopIndex);
          i += 1;
          l3 += System.currentTimeMillis() - l4;
        }
        if (!bool1) {
          break;
        }
        k += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d(str, 2, String.format("batchTransToDatabase: insert count = %d, insertCost=%d, delCost=%d, updateCost=%d", new Object[] { Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2) }));
      }
      i = paramInt;
      if (paramInt == -1) {
        i = paramArrayList.size();
      }
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramArrayList.size() != 0)
        {
          bool2 = bool1;
          if (i != 0)
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("UPDATE ");
            paramArrayList.append(paramString);
            paramArrayList.append(" SET cursor=");
            paramArrayList.append(j + i);
            paramArrayList.append(" WHERE id=1;");
            bool2 = paramFTSDatabase.a(paramArrayList.toString());
          }
        }
      }
      if (bool2)
      {
        l1 = System.currentTimeMillis();
        bool2 = paramFTSDatabase.c();
        l1 = System.currentTimeMillis() - l1;
        if (!QLog.isColorLevel())
        {
          bool1 = bool2;
          if (l1 <= 30000L) {}
        }
        else
        {
          paramFTSDatabase = new StringBuilder();
          paramFTSDatabase.append("commitTransaction cost=");
          paramFTSDatabase.append(l1);
          paramFTSDatabase.append(" success=");
          paramFTSDatabase.append(bool2);
          QLog.d(str, 1, paramFTSDatabase.toString());
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = bool2;
      }
      if (bool1) {
        return j + i;
      }
      return j;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.fts.FTSDatabaseHelper", 2, "batchTransToDatabase: entities == null");
    }
    return -1;
  }
  
  public static boolean a(FTSDatabase paramFTSDatabase, TroopIndex paramTroopIndex)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("DELETE FROM ");
    localStringBuilder2.append(paramTroopIndex.getTableName());
    localStringBuilder2.append(" WHERE ");
    localStringBuilder2.append(paramTroopIndex.getTableName());
    localStringBuilder2.append(" MATCH 'type:");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(paramTroopIndex.type);
    localStringBuilder1.append(" ext1:");
    localStringBuilder1.append(paramTroopIndex.ext1);
    if (!TextUtils.isEmpty(paramTroopIndex.ext6))
    {
      localStringBuilder1.append(" ext6:");
      localStringBuilder1.append(paramTroopIndex.ext6);
    }
    localStringBuilder1.append("';");
    return paramFTSDatabase.a(localStringBuilder1.toString());
  }
  
  public static boolean a(FTSDatabase paramFTSDatabase, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT name FROM sqlite_master WHERE type='table' AND name='");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    paramFTSDatabase = paramFTSDatabase.a(localStringBuilder.toString(), new int[] { 3 });
    return (paramFTSDatabase != null) && (paramFTSDatabase.size() > 0);
  }
  
  public static int b(FTSDatabase paramFTSDatabase, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM ");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    try
    {
      int i = c(paramFTSDatabase, paramString);
      return i;
    }
    catch (SQLiteException paramFTSDatabase)
    {
      label34:
      break label34;
    }
    return -1;
  }
  
  public static boolean b(FTSDatabase paramFTSDatabase, String paramString)
  {
    if (!paramFTSDatabase.b()) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(id INTEGER PRIMARY KEY AUTOINCREMENT, cursor INTEGER);");
    paramFTSDatabase.a(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT INTO ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("(cursor) VALUES(0);");
    paramFTSDatabase.a(localStringBuilder.toString());
    return paramFTSDatabase.c();
  }
  
  public static int c(FTSDatabase paramFTSDatabase, String paramString)
  {
    paramFTSDatabase = paramFTSDatabase.a(paramString, new int[] { 1 });
    if ((paramFTSDatabase != null) && (paramFTSDatabase.size() == 1))
    {
      paramFTSDatabase = (Map)paramFTSDatabase.get(0);
      if ((paramFTSDatabase == null) || (paramFTSDatabase.size() != 1)) {}
    }
    try
    {
      int i = ((Long)paramFTSDatabase.values().toArray()[0]).intValue();
      return i;
    }
    catch (Exception paramFTSDatabase)
    {
      label74:
      break label74;
    }
    throw new SQLiteException("No column or column count != 1");
    throw new SQLiteException("No column or column count != 1");
    throw new SQLiteException("No result or result size != 1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.FTSDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */