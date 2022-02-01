package com.tencent.mobileqq.data;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.entitymanager.FindTableNameInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.QQDBErrorHandler;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.OGEntityManager;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class QQEntityManagerFactory
  extends EntityManagerFactory
{
  public static final String CORRUPT_DATABASE_PATH = "/tencent/msflogs/corruptInfo";
  private static final String LOCAL_HASH_TABLE_PREFIX = "local_hash_table_";
  public static final String PACKAGE_NAME = "com.tencent.mobileqq.data";
  private static final String STAG = "QQEntityManagerFactory";
  private IAfterDBUpgradeListener mAfterDBUpgradeListener;
  private List<Interceptor<Void>> mCorruptionInterceptorList;
  private List<DBUpgradeEntity> mDBUpgradeEntityList;
  private OnDBTableVerifyFailListener mOnDBTableVerifyFailListener;
  private IOnDBUpgradeListener mOnDBUpgradeListener;
  private List<Interceptor<Class>> mTableColumnCheckInterceptorList;
  private List<Entity> mTableEntityProvider;
  private List<Class<? extends Entity>> mVerifyClassList;
  
  private QQEntityManagerFactory(QQEntityManagerFactory.Builder paramBuilder)
  {
    this(paramBuilder.mName, ((Integer)paramBuilder.mDBVersionProvider.get()).intValue());
    initBuilder(paramBuilder);
    this.tag = "QQEntityManagerFactory";
  }
  
  protected QQEntityManagerFactory(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private void checkColumnChange(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Object localObject = this.mTableColumnCheckInterceptorList;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
      ArrayList localArrayList = new ArrayList();
      if (localCursor1 != null)
      {
        localObject = new FindTableNameInterceptorChain(0, "", (List)localObject, paramInt1, paramInt2, paramSQLiteDatabase);
        while (localCursor1.moveToNext())
        {
          String str = SecurityUtile.decode(localCursor1.getString(0));
          Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
          if (localCursor2 != null)
          {
            Class localClass = ((FindTableNameInterceptorChain)localObject).proceed(str);
            if (localClass != null) {
              OGEntityManager.extractedStatementByReflect(localArrayList, str, localCursor2, localClass);
            }
            localCursor2.close();
          }
        }
        localCursor1.close();
      }
      updateColumnChange(paramSQLiteDatabase, localArrayList);
    }
  }
  
  private String createKey(Class paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local_hash_table_");
    localStringBuilder.append(paramClass.getName());
    return localStringBuilder.toString();
  }
  
  private boolean deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  private void executeUpgradeDBSql(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject1 = this.mDBUpgradeEntityList;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return;
      }
      localObject1 = this.mDBUpgradeEntityList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DBUpgradeEntity)((Iterator)localObject1).next();
        if ((localObject2 != null) && (paramInt < ((DBUpgradeEntity)localObject2).maxVersion()))
        {
          localObject2 = ((DBUpgradeEntity)localObject2).sqlStatement();
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            paramSQLiteDatabase.execSQL(localObject2[i]);
            i += 1;
          }
        }
      }
    }
  }
  
  private String getChangeTableName(Map<String, Integer> paramMap, SharedPreferences paramSharedPreferences)
  {
    Object localObject2 = getVerifyClassList();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = localObject2[i];
      Object localObject1 = createKey(localClass);
      int k = paramSharedPreferences.getInt((String)localObject1, 0);
      localObject1 = (Integer)paramMap.get(localObject1);
      if ((localObject1 != null) && (((Integer)localObject1).intValue() != k))
      {
        paramMap = localClass.getName();
        paramMap = paramMap.substring(paramMap.lastIndexOf(".") + 1);
        paramSharedPreferences = this.tag;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getChangeTableName : ");
        ((StringBuilder)localObject2).append(paramMap);
        ((StringBuilder)localObject2).append(", current hash : ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", origin hash : ");
        ((StringBuilder)localObject2).append(k);
        QLog.e(paramSharedPreferences, 1, ((StringBuilder)localObject2).toString());
        return paramMap;
      }
      i += 1;
    }
    return "";
  }
  
  private Class[] getVerifyClassList()
  {
    List localList = this.mVerifyClassList;
    if ((localList != null) && (localList.size() <= 0)) {
      return (Class[])this.mVerifyClassList.toArray();
    }
    return new Class[0];
  }
  
  private String getVerifyTableFieldString(Class[] paramArrayOfClass, Map<String, Integer> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int k = paramArrayOfClass.length;
    int i = 0;
    while (i < k)
    {
      Class localClass = paramArrayOfClass[i];
      Object localObject1 = localClass.getFields();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localClass.getName());
      localStringBuilder2.append("[");
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        if ((!Modifier.isStatic(localObject2.getModifiers())) && (localObject2.getAnnotation(notColumn.class) == null))
        {
          localStringBuilder2.append(localObject2.getName());
          localStringBuilder2.append("_");
          localStringBuilder2.append(localObject2.getType());
          localStringBuilder2.append("&");
        }
        j += 1;
      }
      localStringBuilder2.append("]");
      localObject1 = localStringBuilder2.toString();
      saveTableHashToMap((String)localObject1, paramMap, localClass);
      localStringBuilder1.append((String)localObject1);
      i += 1;
    }
    return localStringBuilder1.toString();
  }
  
  private void handleDBTableHash(Map<String, Integer> paramMap, int paramInt1, SharedPreferences paramSharedPreferences, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != paramInt2) && (paramInt3 >= this.mDBVersion))
    {
      paramMap = getChangeTableName(paramMap, paramSharedPreferences);
      paramSharedPreferences = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("db version config error for table ");
      localStringBuilder.append(paramMap);
      localStringBuilder.append(" changed, hash : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", localHash : ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", localVersion : ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", DB_VERSION: ");
      localStringBuilder.append(this.mDBVersion);
      QLog.e(paramSharedPreferences, 1, localStringBuilder.toString());
      paramSharedPreferences = this.mOnDBTableVerifyFailListener;
      if (paramSharedPreferences != null) {
        paramSharedPreferences.onDBTableVerifyFailed(paramMap);
      }
    }
    else
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      paramSharedPreferences.putInt("debug_local_hash", paramInt1);
      paramSharedPreferences.putInt("debug_dbversion", this.mDBVersion);
      saveTableHashToSp(paramMap, paramSharedPreferences);
      paramSharedPreferences.apply();
    }
  }
  
  private void saveTableHashToMap(String paramString, Map<String, Integer> paramMap, Class paramClass)
  {
    paramClass = createKey(paramClass);
    int i = paramString.hashCode();
    paramMap.put(paramClass, Integer.valueOf(i));
    paramString = this.tag;
    paramMap = new StringBuilder();
    paramMap.append("key = ");
    paramMap.append(paramClass);
    paramMap.append(", hash = ");
    paramMap.append(i);
    QLog.d(paramString, 1, paramMap.toString());
  }
  
  private void saveTableHashToSp(Map<String, Integer> paramMap, SharedPreferences.Editor paramEditor)
  {
    Class[] arrayOfClass = getVerifyClassList();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      String str = createKey(arrayOfClass[i]);
      Integer localInteger = (Integer)paramMap.get(str);
      if (localInteger != null) {
        paramEditor.putInt(str, localInteger.intValue());
      }
      i += 1;
    }
  }
  
  private void updateColumnChange(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, List<String> paramList)
  {
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramList.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void verifyDBVersion() {}
  
  public SQLiteOpenHelper build(String paramString)
  {
    verifyDBVersion();
    if (this.dbHelper == null)
    {
      if ((VersionUtils.e()) && (this.mCorruptionInterceptorList != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".db");
        this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, localStringBuilder.toString(), this.mDBVersion, new QQDBErrorHandler(this.mCorruptionInterceptorList));
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".db");
        this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, localStringBuilder.toString(), this.mDBVersion);
      }
      paramString = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("walFlag: ");
      localStringBuilder.append(SQLiteOpenHelper.WAL_ENABLE);
      QLog.d(paramString, 1, localStringBuilder.toString());
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
      QLog.d(this.tag, 1, new Object[] { "new SQLiteOpenHelper = : ", this.dbHelper });
    }
    return this.dbHelper;
  }
  
  protected void cleanOverDueCorruptDatabase()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject).append("/tencent/msflogs/corruptInfo");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).exists()) && (System.currentTimeMillis() - ((File)localObject).lastModified() > 604800000L)) {
      ((File)localObject).delete();
    }
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = this.mTableEntityProvider;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = this.mTableEntityProvider.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
        if (localEntity != null) {
          paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(localEntity));
        }
      }
    }
  }
  
  protected void doAfterUpgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    IAfterDBUpgradeListener localIAfterDBUpgradeListener = this.mAfterDBUpgradeListener;
    if (localIAfterDBUpgradeListener != null) {
      localIAfterDBUpgradeListener.afterDBUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }
  }
  
  public IOnDBUpgradeListener getOnDBUpgradeListener()
  {
    return this.mOnDBUpgradeListener;
  }
  
  protected String getPackageName()
  {
    return "com.tencent.mobileqq.data";
  }
  
  protected void initBuilder(QQEntityManagerFactory.Builder paramBuilder)
  {
    this.name = paramBuilder.mName;
    this.mDBVersion = ((Integer)paramBuilder.mDBVersionProvider.get()).intValue();
    this.mTableEntityProvider = paramBuilder.mTableEntityList;
    this.mVerifyClassList = paramBuilder.mVerifyClassList;
    this.mTableColumnCheckInterceptorList = paramBuilder.mTableColumnCheckInterceptorList;
    this.mDBUpgradeEntityList = paramBuilder.mDBUpgradeEntityList;
    this.mCorruptionInterceptorList = paramBuilder.mCorruptionInterceptorList;
    this.mOnDBTableVerifyFailListener = paramBuilder.mOnDBTableVerifyFailListener;
    this.mAfterDBUpgradeListener = paramBuilder.mAfterDBUpgradeListener;
    this.mOnDBUpgradeListener = paramBuilder.mOnDBUpgradeListener;
    this.dbHelper = build(this.name);
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20)
    {
      this.mInnerDbHelper.a();
      return;
    }
    IOnDBUpgradeListener localIOnDBUpgradeListener = this.mOnDBUpgradeListener;
    if (localIOnDBUpgradeListener != null) {
      localIOnDBUpgradeListener.onDBUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }
    executeUpgradeDBSql(paramSQLiteDatabase, paramInt1);
    checkColumnChange(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */