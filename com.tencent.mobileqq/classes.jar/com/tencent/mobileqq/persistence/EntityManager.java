package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.constants.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EntityManager
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManager has been already closed";
  public static final int QUERY_CACHE_TYPE_MULTI_CONTDITION = 1;
  public static final int QUERY_CACHE_TYPE_SELECT_ALL = 2;
  public static final int QUERY_CACHE_TYPE_SELECT_WHEHRE_SELECTION = 3;
  private static final String SQL = "EntityManager";
  private static final Map<String, Boolean> createTableCache = new ConcurrentHashMap();
  private SQLiteDatabase db;
  private SQLiteOpenHelper dbHelper;
  private String mName;
  private ConcurrentHashMap<String, String> mQueryAllCache = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, String>> mTableMap = new ConcurrentHashMap();
  private EntityTransaction transaction;
  
  EntityManager(SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    this.dbHelper = paramSQLiteOpenHelper;
    this.mName = paramString;
  }
  
  private boolean createTable(String paramString, Entity paramEntity, boolean paramBoolean)
  {
    String str = getCacheKeyFromTableName(paramString);
    if ((!paramBoolean) && (createTableCache.containsKey(str))) {}
    for (boolean bool2 = ((Boolean)createTableCache.get(str)).booleanValue();; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        if (this.db == null) {
          this.db = this.dbHelper.getWritableDatabase();
        }
        if ((this.db != null) || (!AppSetting.isPublicVersion)) {
          break label88;
        }
        bool1 = false;
      }
      label88:
      do
      {
        return bool1;
        bool2 = this.db.execSQL(TableBuilder.createSQLStatement(paramEntity));
        paramEntity = TableBuilder.createIndexSQLStatement(paramEntity);
        if (paramEntity != null) {
          this.db.execSQL(paramEntity);
        }
        createTableCache.put(str, Boolean.valueOf(bool2));
        if (QLog.isColorLevel()) {
          QLog.d("EntityManager", 2, "createTable, tableName=" + paramString + ", isCreated=" + bool2 + ", isForceCreate=" + paramBoolean);
        }
        bool1 = bool2;
      } while (!bool2);
      this.db.addToTableCache(paramString);
      return bool2;
    }
  }
  
  private String getCacheKeyFromTableName(String paramString)
  {
    if (this.mName == null) {
      return paramString;
    }
    return this.mName + "_" + paramString;
  }
  
  private Cursor queryInner(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    try
    {
      if (tabbleIsExist(paramString1))
      {
        paramString1 = this.dbHelper.getReadableDatabase().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString5, paramString6);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
      }
      return null;
    }
    finally {}
  }
  
  /* Error */
  private List<? extends Entity> queryInner(Class<? extends Entity> paramClass, String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, String paramString6, NoColumnErrorHandler paramNoColumnErrorHandler, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: aload_2
    //   3: aconst_null
    //   4: aload 4
    //   6: aload 5
    //   8: aload 6
    //   10: aload 7
    //   12: aload 8
    //   14: aload 9
    //   16: invokevirtual 174	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 5
    //   21: aload 5
    //   23: ifnull +122 -> 145
    //   26: new 176	com/tencent/mobileqq/persistence/CursorOpt
    //   29: dup
    //   30: aload 5
    //   32: invokespecial 179	com/tencent/mobileqq/persistence/CursorOpt:<init>	(Landroid/database/Cursor;)V
    //   35: astore 4
    //   37: aload 4
    //   39: astore 5
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: aload 4
    //   46: aload 10
    //   48: invokevirtual 183	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;)Ljava/util/List;
    //   51: astore_1
    //   52: aload 4
    //   54: ifnull +10 -> 64
    //   57: aload 4
    //   59: invokeinterface 188 1 0
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: astore 5
    //   72: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +16 -> 91
    //   78: aload_1
    //   79: astore 5
    //   81: ldc 18
    //   83: iconst_2
    //   84: aload_2
    //   85: invokestatic 167	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   88: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_1
    //   92: ifnull +51 -> 143
    //   95: aload_1
    //   96: invokeinterface 188 1 0
    //   101: aconst_null
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore 5
    //   107: aload 5
    //   109: ifnull +10 -> 119
    //   112: aload 5
    //   114: invokeinterface 188 1 0
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: goto -15 -> 107
    //   125: astore_1
    //   126: goto -19 -> 107
    //   129: astore_2
    //   130: aload 5
    //   132: astore_1
    //   133: goto -64 -> 69
    //   136: astore_2
    //   137: aload 4
    //   139: astore_1
    //   140: goto -71 -> 69
    //   143: aconst_null
    //   144: areturn
    //   145: aload 5
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -99 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	EntityManager
    //   0	154	1	paramClass	Class<? extends Entity>
    //   0	154	2	paramString1	String
    //   0	154	3	paramBoolean	boolean
    //   0	154	4	paramString2	String
    //   0	154	5	paramArrayOfString	String[]
    //   0	154	6	paramString3	String
    //   0	154	7	paramString4	String
    //   0	154	8	paramString5	String
    //   0	154	9	paramString6	String
    //   0	154	10	paramNoColumnErrorHandler	NoColumnErrorHandler
    //   0	154	11	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   0	21	66	java/lang/Exception
    //   0	21	103	finally
    //   26	37	121	finally
    //   41	52	125	finally
    //   72	78	125	finally
    //   81	91	125	finally
    //   26	37	129	java/lang/Exception
    //   41	52	136	java/lang/Exception
  }
  
  public void close() {}
  
  protected ContentValues createContentValue(Entity paramEntity)
  {
    List localList = TableBuilder.getValidField(paramEntity.getClassForTable());
    int j = localList.size();
    ContentValues localContentValues = new ContentValues(j);
    int i = 0;
    if (i < j)
    {
      Object localObject = (Field)localList.get(i);
      String str = ((Field)localObject).getName();
      if (!((Field)localObject).isAccessible()) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = ((Field)localObject).get(paramEntity);
      if ((localObject instanceof Integer)) {
        localContentValues.put(str, (Integer)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Long)) {
          localContentValues.put(str, (Long)localObject);
        } else if ((localObject instanceof String)) {
          localContentValues.put(str, (String)localObject);
        } else if ((localObject instanceof byte[])) {
          localContentValues.put(str, (byte[])localObject);
        } else if ((localObject instanceof Short)) {
          localContentValues.put(str, (Short)localObject);
        } else if ((localObject instanceof Boolean)) {
          localContentValues.put(str, (Boolean)localObject);
        } else if ((localObject instanceof Double)) {
          localContentValues.put(str, (Double)localObject);
        } else if ((localObject instanceof Float)) {
          localContentValues.put(str, (Float)localObject);
        } else if ((localObject instanceof Byte)) {
          localContentValues.put(str, (Byte)localObject);
        } else if ((localObject instanceof Boolean)) {
          localContentValues.put(str, (Boolean)localObject);
        }
      }
    }
    return localContentValues;
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, Cursor paramCursor)
  {
    try
    {
      paramClass = cursor2Entity(paramClass, TableBuilder.getTableName(paramClass), paramCursor);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor)
  {
    return cursor2Entity(paramClass, paramString, paramCursor, null);
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    long l = -1L;
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
      for (;;)
      {
        Entity localEntity;
        int i;
        Field localField;
        Class localClass;
        Object localObject;
        int k;
        try
        {
          localEntity = (Entity)paramClass.newInstance();
          paramClass = localEntity;
          if (localEntity != null)
          {
            localEntity._id = l;
            if (localEntity.entityByCursor(paramCursor)) {
              break label528;
            }
            paramClass = TableBuilder.getValidField(localEntity);
            int j = paramClass.size();
            i = 0;
            if (i >= j) {
              break label528;
            }
            localField = (Field)paramClass.get(i);
            localClass = localField.getType();
            if (Entity.class.isAssignableFrom(localClass))
            {
              localObject = cursor2Entity(localClass, paramCursor);
              ((Entity)localObject)._status = 1002;
              localField.set(localEntity, localObject);
            }
            localObject = localField.getName();
            k = paramCursor.getColumnIndex((String)localObject);
            if (k == -1) {
              break label502;
            }
            if (!localField.isAccessible()) {
              localField.setAccessible(true);
            }
            if (localClass == Long.TYPE) {
              localField.set(localEntity, Long.valueOf(paramCursor.getLong(k)));
            } else if (localClass == Integer.TYPE) {
              localField.set(localEntity, Integer.valueOf(paramCursor.getInt(k)));
            }
          }
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          paramClass = null;
          return paramClass;
          if (localClass == String.class) {
            localField.set(localEntity, paramCursor.getString(k));
          }
        }
        catch (OutOfMemoryError paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
        if (localClass == Byte.TYPE)
        {
          localField.set(localEntity, Byte.valueOf((byte)paramCursor.getShort(k)));
        }
        else if (localClass == [B.class)
        {
          localField.set(localEntity, paramCursor.getBlob(k));
        }
        else if (localClass == Short.TYPE)
        {
          localField.set(localEntity, Short.valueOf(paramCursor.getShort(k)));
        }
        else if (localClass == Boolean.TYPE)
        {
          if (paramCursor.getInt(k) == 0) {
            break;
          }
          bool = true;
          localField.set(localEntity, Boolean.valueOf(bool));
        }
        else if (localClass == Float.TYPE)
        {
          localField.set(localEntity, Float.valueOf(paramCursor.getFloat(k)));
        }
        else
        {
          label528:
          if (localClass == Double.TYPE)
          {
            localField.set(localEntity, Double.valueOf(paramCursor.getDouble(k)));
            break label568;
            label502:
            if (paramNoColumnErrorHandler != null)
            {
              paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError((String)localObject, localClass));
              break label568;
              if ((l != -1L) && (paramString != null)) {}
              for (localEntity._status = 1001;; localEntity._status = 1002)
              {
                localEntity.postRead();
                return localEntity;
              }
            }
          }
        }
        label568:
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = -1L;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public List<? extends Entity> cursor2List(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor)
  {
    return cursor2List(paramClass, paramString, paramCursor, null);
  }
  
  public List<? extends Entity> cursor2List(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramCursor != null)
    {
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    try
    {
      int i;
      if (paramCursor.moveToFirst())
      {
        localObject2 = localObject4;
        i = paramCursor.getCount();
        localObject1 = null;
      }
      Entity localEntity;
      label112:
      boolean bool;
      Object localObject3;
      for (;;)
      {
        localObject4 = localObject1;
      }
    }
    catch (Exception paramClass)
    {
      do
      {
        try
        {
          localEntity = cursor2Entity(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
          localObject2 = localObject1;
          if (localEntity != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject4 = localObject1;
            }
          }
          try
          {
            localObject2 = new ArrayList(i);
            localObject4 = localObject2;
            ((List)localObject2).add(localEntity);
            localObject1 = localObject2;
          }
          catch (Throwable localThrowable)
          {
            break label112;
          }
          localObject2 = localObject1;
          bool = paramCursor.moveToNext();
          if (bool) {
            break label169;
          }
          return localObject1;
        }
        catch (Exception paramClass)
        {
          for (;;)
          {
            localObject3 = localObject4;
          }
        }
        paramClass = paramClass;
        localObject1 = localThrowable;
      } while (!QLog.isColorLevel());
      QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
      return localThrowable;
    }
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return this.dbHelper.getWritableDatabase().delete(paramString1, paramString2, paramArrayOfString);
  }
  
  public boolean drop(Class<? extends Entity> paramClass)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    try
    {
      paramClass = TableBuilder.getTableName(paramClass);
      this.db.execSQL("DROP TABLE IF EXISTS " + paramClass);
      createTableCache.remove(getCacheKeyFromTableName(paramClass));
      this.db.removeFromTableCache(paramClass);
      return true;
    }
    catch (Exception paramClass)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
      }
    }
    return false;
  }
  
  public boolean drop(String paramString)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    try
    {
      this.db.execSQL("DROP TABLE IF EXISTS " + paramString);
      createTableCache.remove(getCacheKeyFromTableName(paramString));
      this.db.removeFromTableCache(paramString);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public boolean execSQL(String paramString)
  {
    try
    {
      this.dbHelper.getReadableDatabase().execSQL(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString));
      }
      return false;
    }
    finally {}
  }
  
  public Entity find(Class<? extends Entity> paramClass, long paramLong)
  {
    try
    {
      paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, "_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, null, null, 3);
      if (paramClass != null) {
        return (Entity)paramClass.get(0);
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    return null;
  }
  
  public Entity find(Class<? extends Entity> paramClass, String paramString)
  {
    Object localObject = TableBuilder.getValidField(paramClass);
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      Field localField = (Field)((List)localObject).get(i);
      if (localField.isAnnotationPresent(unique.class))
      {
        localObject = localField.getName();
        localObject = (String)localObject + "=?";
        try
        {
          paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, (String)localObject, new String[] { paramString }, null, null, null, null, null, 3);
          if ((paramClass == null) || (paramClass.size() <= 0)) {
            break;
          }
          return (Entity)paramClass.get(0);
        }
        catch (InstantiationException paramClass)
        {
          for (;;)
          {
            paramClass.printStackTrace();
            paramClass = null;
          }
        }
        catch (IllegalAccessException paramClass)
        {
          for (;;)
          {
            paramClass.printStackTrace();
            paramClass = null;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  public Entity find(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    paramClass = query(paramClass, true, paramString, paramArrayOfString, null, null, null, "1");
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public Entity find(Class<? extends Entity> paramClass, String... paramVarArgs)
  {
    if (!paramClass.isAnnotationPresent(uniqueConstraints.class)) {
      throw new IllegalStateException("No uniqueConstraints annotation in the Entity " + paramClass.getSimpleName());
    }
    StringBuffer localStringBuffer;
    for (;;)
    {
      try
      {
        Object localObject = ((uniqueConstraints)paramClass.getAnnotation(uniqueConstraints.class)).columnNames();
        localObject = ((String)localObject).split(",");
        localStringBuffer = new StringBuffer();
        int i = 0;
        if (i >= localObject.length) {
          break;
        }
        localStringBuffer.append(localObject[i]);
        if (i == localObject.length - 1)
        {
          localStringBuffer.append("=?");
          i += 1;
        }
        else
        {
          localStringBuffer.append("=? and ");
        }
      }
      catch (IncompatibleClassChangeError paramClass)
      {
        paramClass.printStackTrace();
        return null;
      }
    }
    try
    {
      paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, localStringBuffer.toString(), paramVarArgs, null, null, null, null, null, 3);
      if (paramClass != null) {
        return (Entity)paramClass.get(0);
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
        paramClass = null;
      }
    }
    return null;
  }
  
  public EntityTransaction getTransaction()
  {
    if (this.transaction == null) {
      this.transaction = new EntityTransaction(this.dbHelper);
    }
    return this.transaction;
  }
  
  protected void insertOrReplace(Entity paramEntity, boolean paramBoolean)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    String str;
    if (paramEntity._status == 1000)
    {
      str = paramEntity.getTableName();
      createTable(str, paramEntity, false);
      paramEntity.prewrite();
    }
    for (;;)
    {
      try
      {
        localContentValues = createContentValue(paramEntity);
        if (!paramBoolean) {
          continue;
        }
        l1 = this.db.replace(str, null, localContentValues);
        l2 = l1;
        if (l1 == -1L)
        {
          l2 = l1;
          if (createTable(str, paramEntity, true))
          {
            if (!paramBoolean) {
              continue;
            }
            l2 = this.db.replace(str, null, localContentValues);
          }
        }
        if (l2 == -1L) {
          continue;
        }
        paramEntity._id = l2;
        paramEntity._status = 1001;
      }
      catch (Exception localException)
      {
        ContentValues localContentValues;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
        continue;
      }
      paramEntity.postwrite();
      return;
      l1 = this.db.insert(str, null, localContentValues);
      continue;
      l2 = this.db.insert(str, null, localContentValues);
      continue;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, "replace or insert error with -1 " + paramBoolean);
      }
    }
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public void keepOnlyOne(Entity paramEntity)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    String str = paramEntity.getTableName();
    createTable(str, paramEntity, false);
    paramEntity.prewrite();
    try
    {
      ContentValues localContentValues = createContentValue(paramEntity);
      this.db.execSQL("delete from " + str);
      long l2 = this.db.insert(str, null, localContentValues);
      long l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (createTable(str, paramEntity, true)) {
          l1 = this.db.insert(str, null, localContentValues);
        }
      }
      if (l1 != -1L)
      {
        paramEntity._id = l1;
        paramEntity._status = 1001;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
        }
      }
    }
    paramEntity.postwrite();
  }
  
  public void persist(Entity paramEntity)
  {
    if (AppSetting.isPublicVersion) {
      try
      {
        insertOrReplace(paramEntity, false);
        return;
      }
      catch (Throwable paramEntity)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("EntityManager", 2, "persist error", paramEntity);
        return;
      }
    }
    insertOrReplace(paramEntity, false);
  }
  
  public void persistOrReplace(Entity paramEntity)
  {
    if (AppSetting.isPublicVersion) {
      try
      {
        insertOrReplace(paramEntity, true);
        return;
      }
      catch (Throwable paramEntity)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("EntityManager", 2, "persistOrReplace error", paramEntity);
        return;
      }
    }
    insertOrReplace(paramEntity, true);
  }
  
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      if (tabbleIsExist(paramString1))
      {
        paramString1 = this.dbHelper.getReadableDatabase().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString5, paramString6);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
      }
      return null;
    }
    finally {}
  }
  
  public List<? extends Entity> query(Class<? extends Entity> paramClass)
  {
    try
    {
      paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, null, null, null, null, null, null, null, 2);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public List<? extends Entity> query(Class<? extends Entity> paramClass, String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return query(paramClass, paramString1, paramBoolean, paramString2, paramArrayOfString, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public List<? extends Entity> query(Class<? extends Entity> paramClass, String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, String paramString6, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    return queryInner(paramClass, paramString1, paramBoolean, paramString2, paramArrayOfString, paramString3, paramString4, paramString5, paramString6, paramNoColumnErrorHandler, 1);
  }
  
  public List<? extends Entity> query(Class<? extends Entity> paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = query(paramClass, TableBuilder.getTableName(paramClass), paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("EntityManager", 2, "query Exception, table : " + paramClass);
        QLog.d("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
      }
    }
    return null;
  }
  
  /* Error */
  public List<? extends Entity> rawQuery(Class<? extends Entity> paramClass, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   10: invokevirtual 157	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: aload_2
    //   14: aload_3
    //   15: aload 4
    //   17: aload 5
    //   19: invokevirtual 579	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_2
    //   23: aload 7
    //   25: astore_3
    //   26: aload_2
    //   27: ifnull +15 -> 42
    //   30: aload_2
    //   31: astore_3
    //   32: aload_0
    //   33: aload_1
    //   34: aconst_null
    //   35: aload_2
    //   36: invokevirtual 581	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_3
    //   42: aload_3
    //   43: astore_1
    //   44: aload_2
    //   45: ifnull +11 -> 56
    //   48: aload_2
    //   49: invokeinterface 188 1 0
    //   54: aload_3
    //   55: astore_1
    //   56: aload_1
    //   57: areturn
    //   58: astore_1
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_3
    //   63: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +15 -> 81
    //   69: aload_2
    //   70: astore_3
    //   71: ldc 18
    //   73: iconst_2
    //   74: aload_1
    //   75: invokestatic 167	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   78: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 6
    //   83: astore_1
    //   84: aload_2
    //   85: ifnull -29 -> 56
    //   88: aload_2
    //   89: invokeinterface 188 1 0
    //   94: aconst_null
    //   95: areturn
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_3
    //   99: aload_3
    //   100: ifnull +9 -> 109
    //   103: aload_3
    //   104: invokeinterface 188 1 0
    //   109: aload_1
    //   110: athrow
    //   111: astore_1
    //   112: goto -13 -> 99
    //   115: astore_1
    //   116: goto -55 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	EntityManager
    //   0	119	1	paramClass	Class<? extends Entity>
    //   0	119	2	paramString1	String
    //   0	119	3	paramString2	String
    //   0	119	4	paramString3	String
    //   0	119	5	paramArrayOfString	String[]
    //   1	81	6	localObject1	Object
    //   4	20	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	23	58	java/lang/Exception
    //   6	23	96	finally
    //   32	40	111	finally
    //   63	69	111	finally
    //   71	81	111	finally
    //   32	40	115	java/lang/Exception
  }
  
  /* Error */
  public List<? extends Entity> rawQuery(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   10: invokevirtual 157	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: aload_2
    //   14: aload_3
    //   15: invokevirtual 586	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_2
    //   19: aload 5
    //   21: astore_3
    //   22: aload_2
    //   23: ifnull +15 -> 38
    //   26: aload_2
    //   27: astore_3
    //   28: aload_0
    //   29: aload_1
    //   30: aconst_null
    //   31: aload_2
    //   32: invokevirtual 581	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   35: astore_1
    //   36: aload_1
    //   37: astore_3
    //   38: aload_3
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull +11 -> 52
    //   44: aload_2
    //   45: invokeinterface 188 1 0
    //   50: aload_3
    //   51: astore_1
    //   52: aload_1
    //   53: areturn
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_2
    //   58: astore_3
    //   59: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +15 -> 77
    //   65: aload_2
    //   66: astore_3
    //   67: ldc 18
    //   69: iconst_2
    //   70: aload_1
    //   71: invokestatic 167	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   74: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 4
    //   79: astore_1
    //   80: aload_2
    //   81: ifnull -29 -> 52
    //   84: aload_2
    //   85: invokeinterface 188 1 0
    //   90: aconst_null
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_3
    //   97: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +15 -> 115
    //   103: aload_2
    //   104: astore_3
    //   105: ldc 18
    //   107: iconst_2
    //   108: aload_1
    //   109: invokestatic 167	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   112: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload 4
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull -67 -> 52
    //   122: aload_2
    //   123: invokeinterface 188 1 0
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: ifnull +9 -> 143
    //   137: aload_3
    //   138: invokeinterface 188 1 0
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: goto -13 -> 133
    //   149: astore_1
    //   150: goto -55 -> 95
    //   153: astore_1
    //   154: goto -97 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	EntityManager
    //   0	157	1	paramClass	Class<? extends Entity>
    //   0	157	2	paramString	String
    //   0	157	3	paramArrayOfString	String[]
    //   1	115	4	localObject1	Object
    //   4	16	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	19	54	java/lang/Exception
    //   6	19	92	java/lang/OutOfMemoryError
    //   6	19	130	finally
    //   28	36	145	finally
    //   59	65	145	finally
    //   67	77	145	finally
    //   97	103	145	finally
    //   105	115	145	finally
    //   28	36	149	java/lang/OutOfMemoryError
    //   28	36	153	java/lang/Exception
  }
  
  public boolean remove(Entity paramEntity)
  {
    boolean bool = true;
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    paramEntity.prewrite();
    if (paramEntity._status == 1001) {
      if (this.db.delete(paramEntity.getTableName(), "_id=?", new String[] { String.valueOf(paramEntity._id) }) > 0) {
        paramEntity._status = 1003;
      }
    }
    for (;;)
    {
      paramEntity.postwrite();
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public boolean remove(Entity paramEntity, String paramString, String[] paramArrayOfString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    paramEntity.prewrite();
    if (paramEntity._status == 1001)
    {
      bool1 = bool2;
      if (this.db.delete(paramEntity.getTableName(), paramString, paramArrayOfString) > 0) {
        bool1 = true;
      }
      paramEntity._status = 1003;
    }
    paramEntity.postwrite();
    return bool1;
  }
  
  public boolean tabbleIsExist(String paramString)
  {
    if (paramString == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return false;
      if ("Sqlite_master".equalsIgnoreCase(paramString)) {
        return true;
      }
      localSQLiteDatabase = this.dbHelper.getReadableDatabase();
    } while (localSQLiteDatabase == null);
    boolean bool = localSQLiteDatabase.containsTable(paramString);
    if ((QLog.isDevelopLevel()) && (!bool)) {
      QLog.d("EntityManager", 2, new Object[] { " TABLECACHE tabbleIsExist : tableName:", paramString, " isExist:", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean update(Entity paramEntity)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    paramEntity.prewrite();
    try
    {
      if ((paramEntity._status == 1001) || (paramEntity._status == 1002))
      {
        ContentValues localContentValues = createContentValue(paramEntity);
        int i = this.db.update(paramEntity.getTableName(), localContentValues, "_id=?", new String[] { String.valueOf(paramEntity._id) });
        return i > 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
      }
      paramEntity.postwrite();
    }
    return false;
  }
  
  public boolean update(String paramString)
  {
    return update(paramString, null);
  }
  
  public boolean update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    boolean bool = false;
    try
    {
      this.db = this.dbHelper.getWritableDatabase();
      int i = this.db.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      if (i > 0) {
        bool = true;
      }
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
    }
    return bool;
    return false;
  }
  
  public boolean update(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      this.db = this.dbHelper.getWritableDatabase();
      if (paramArrayOfObject == null) {
        this.db.execSQL(paramString);
      } else {
        this.db.execSQL(paramString, paramArrayOfObject);
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManager
 * JD-Core Version:    0.7.0.1
 */