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
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.OGEntityManager;
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
import mqq.app.MobileQQ;

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
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
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
  
  private String createKey(Class paramClass)
  {
    return "local_hash_table_" + paramClass.getName();
  }
  
  private boolean deleteFile(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    do
    {
      return bool;
      bool = true;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.delete();
  }
  
  private void executeUpgradeDBSql(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    label19:
    Iterator localIterator;
    if ((this.mDBUpgradeEntityList == null) || (this.mDBUpgradeEntityList.size() <= 0)) {
      return;
    } else {
      localIterator = this.mDBUpgradeEntityList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label19;
      }
      Object localObject = (DBUpgradeEntity)localIterator.next();
      if ((localObject == null) || (paramInt >= ((DBUpgradeEntity)localObject).maxVersion())) {
        break;
      }
      localObject = ((DBUpgradeEntity)localObject).sqlStatement();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramSQLiteDatabase.execSQL(localObject[i]);
        i += 1;
      }
    }
  }
  
  private String getChangeTableName(Map<String, Integer> paramMap, SharedPreferences paramSharedPreferences)
  {
    Class[] arrayOfClass = getVerifyClassList();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      Object localObject = createKey(localClass);
      int k = paramSharedPreferences.getInt((String)localObject, 0);
      localObject = (Integer)paramMap.get(localObject);
      if ((localObject != null) && (((Integer)localObject).intValue() != k))
      {
        paramMap = localClass.getName();
        paramMap = paramMap.substring(paramMap.lastIndexOf(".") + 1);
        QLog.e(this.tag, 1, "getChangeTableName : " + paramMap + ", current hash : " + localObject + ", origin hash : " + k);
        return paramMap;
      }
      i += 1;
    }
    return "";
  }
  
  private Class[] getVerifyClassList()
  {
    if ((this.mVerifyClassList != null) && (this.mVerifyClassList.size() <= 0)) {
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
      localStringBuilder2.append(localClass.getName()).append("[");
      int m = localObject1.length;
      int j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        if ((!Modifier.isStatic(localObject2.getModifiers())) && (localObject2.getAnnotation(notColumn.class) == null)) {
          localStringBuilder2.append(localObject2.getName()).append("_").append(localObject2.getType()).append("&");
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
      QLog.e(this.tag, 1, "db version config error for table " + paramMap + " changed, hash : " + paramInt1 + ", localHash : " + paramInt2 + ", localVersion : " + paramInt3 + ", DB_VERSION: " + this.mDBVersion);
      if (this.mOnDBTableVerifyFailListener != null) {
        this.mOnDBTableVerifyFailListener.onDBTableVerifyFailed(paramMap);
      }
      return;
    }
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putInt("debug_local_hash", paramInt1);
    paramSharedPreferences.putInt("debug_dbversion", this.mDBVersion);
    saveTableHashToSp(paramMap, paramSharedPreferences);
    paramSharedPreferences.apply();
  }
  
  private void saveTableHashToMap(String paramString, Map<String, Integer> paramMap, Class paramClass)
  {
    paramClass = createKey(paramClass);
    int i = paramString.hashCode();
    paramMap.put(paramClass, Integer.valueOf(i));
    QLog.d(this.tag, 1, "key = " + paramClass + ", hash = " + i);
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
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
  }
  
  private void verifyDBVersion() {}
  
  public SQLiteOpenHelper build(String paramString)
  {
    verifyDBVersion();
    if (this.dbHelper == null)
    {
      if ((!VersionUtils.e()) || (this.mCorruptionInterceptorList == null)) {
        break label184;
      }
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, this.mDBVersion, new QQDBErrorHandler(this.mCorruptionInterceptorList));
    }
    for (;;)
    {
      if (1 == MobileQQ.sProcessId) {
        paramString = new File(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
      }
      try
      {
        if (paramString.exists())
        {
          SQLiteOpenHelper.WAL_ENABLE = true;
          deleteFile(SQLiteOpenHelper.WAL_FLAG_FILE_PATH);
        }
        QLog.d(this.tag, 1, "walFlag: " + SQLiteOpenHelper.WAL_ENABLE);
        this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        QLog.d(this.tag, 1, new Object[] { "new SQLiteOpenHelper = : ", this.dbHelper });
        return this.dbHelper;
        label184:
        this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, this.mDBVersion);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e(this.tag, 1, "build error", paramString);
        }
      }
    }
  }
  
  public void cleanOverDueCorruptDatabase()
  {
    File localFile = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
    if ((localFile.exists()) && (System.currentTimeMillis() - localFile.lastModified() > 604800000L)) {
      localFile.delete();
    }
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    if ((this.mTableEntityProvider == null) || (this.mTableEntityProvider.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mTableEntityProvider.iterator();
      while (localIterator.hasNext())
      {
        Entity localEntity = (Entity)localIterator.next();
        if (localEntity != null) {
          paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(localEntity));
        }
      }
    }
  }
  
  public void doAfterUpgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (this.mAfterDBUpgradeListener != null) {
      this.mAfterDBUpgradeListener.afterDBUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }
  }
  
  public IOnDBUpgradeListener getOnDBUpgradeListener()
  {
    return this.mOnDBUpgradeListener;
  }
  
  public String getPackageName()
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
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 20)
    {
      this.mInnerDbHelper.dropAllTable();
      return;
    }
    if (this.mOnDBUpgradeListener != null) {
      this.mOnDBUpgradeListener.onDBUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }
    executeUpgradeDBSql(paramSQLiteDatabase, paramInt1);
    checkColumnChange(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */