package com.tencent.timi.game.databasecore.impl;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiDatabaseTableHandler;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.timi.game.databasecore.impl.base.TimiGameEntityConstructor;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class YesEntityManagerFactory
  extends EntityManagerFactory
{
  public YesEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("timiyes_");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(ServerEnv.c());
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, localStringBuilder.toString(), 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = YesDataBaseHelper.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createDatabase - entityMap.size = ");
    localStringBuilder.append(((ConcurrentHashMap)localObject).size());
    Logger.a("YesEntityManagerFactory", localStringBuilder.toString());
    localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(((TimiGameEntityConstructor)((Map.Entry)((Iterator)localObject).next()).getValue()).a));
    }
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Object localObject1 = YesDataBaseHelper.d();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("upgradeDatabase --  oldVersion: ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("; newVersion : ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", entityMap.size = ");
    ((StringBuilder)localObject2).append(((ConcurrentHashMap)localObject1).size());
    Logger.a("YesEntityManagerFactory", ((StringBuilder)localObject2).toString());
    localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      BaseTimiDatabaseTableHandler localBaseTimiDatabaseTableHandler = ((TimiGameEntityConstructor)((Map.Entry)localObject2).getValue()).b;
      if (localBaseTimiDatabaseTableHandler != null) {
        localBaseTimiDatabaseTableHandler.a(paramSQLiteDatabase, ((TimiGameEntityConstructor)((Map.Entry)localObject2).getValue()).a.getTableName(), paramInt1, paramInt2);
      }
    }
    createDatabase(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.YesEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */