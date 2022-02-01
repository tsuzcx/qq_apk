package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
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
  
  private void assignCursorValueByField(Cursor paramCursor, Entity paramEntity, Field paramField, Class paramClass, int paramInt)
  {
    boolean bool2 = paramField.isAccessible();
    boolean bool1 = true;
    if (!bool2) {
      paramField.setAccessible(true);
    }
    if (paramClass == Long.TYPE)
    {
      paramField.set(paramEntity, Long.valueOf(paramCursor.getLong(paramInt)));
      return;
    }
    if (paramClass == Integer.TYPE)
    {
      paramField.set(paramEntity, Integer.valueOf(paramCursor.getInt(paramInt)));
      return;
    }
    if (paramClass == String.class)
    {
      paramField.set(paramEntity, paramCursor.getString(paramInt));
      return;
    }
    if (paramClass == Byte.TYPE)
    {
      paramField.set(paramEntity, Byte.valueOf((byte)paramCursor.getShort(paramInt)));
      return;
    }
    if (paramClass == [B.class)
    {
      paramField.set(paramEntity, paramCursor.getBlob(paramInt));
      return;
    }
    if (paramClass == Short.TYPE)
    {
      paramField.set(paramEntity, Short.valueOf(paramCursor.getShort(paramInt)));
      return;
    }
    if (paramClass == Boolean.TYPE)
    {
      if (paramCursor.getInt(paramInt) == 0) {
        bool1 = false;
      }
      paramField.set(paramEntity, Boolean.valueOf(bool1));
      return;
    }
    if (paramClass == Float.TYPE)
    {
      paramField.set(paramEntity, Float.valueOf(paramCursor.getFloat(paramInt)));
      return;
    }
    if (paramClass == Double.TYPE) {
      paramField.set(paramEntity, Double.valueOf(paramCursor.getDouble(paramInt)));
    }
  }
  
  private void assignEntityFieldsValue(Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler, Entity paramEntity)
  {
    List localList = TableBuilder.getValidField(paramEntity);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Field localField = (Field)localList.get(i);
      Class localClass = localField.getType();
      if (Entity.class.isAssignableFrom(localClass))
      {
        localObject = cursor2Entity(localClass, paramCursor);
        if (localObject != null)
        {
          ((Entity)localObject)._status = 1002;
          localField.set(paramEntity, localObject);
        }
      }
      Object localObject = localField.getName();
      int k = paramCursor.getColumnIndex((String)localObject);
      if (k != -1) {
        assignCursorValueByField(paramCursor, paramEntity, localField, localClass, k);
      } else if (paramNoColumnErrorHandler != null) {
        paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError((String)localObject, localClass));
      }
      i += 1;
    }
  }
  
  private boolean createTable(String paramString, Entity paramEntity, boolean paramBoolean)
  {
    String str = getCacheKeyFromTableName(paramString);
    boolean bool1;
    if ((!paramBoolean) && (createTableCache.containsKey(str))) {
      bool1 = ((Boolean)createTableCache.get(str)).booleanValue();
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      if (this.db == null) {
        this.db = this.dbHelper.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.db;
      if (localSQLiteDatabase == null) {
        return false;
      }
      bool1 = localSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(paramEntity));
      paramEntity = TableBuilder.createIndexSQLStatement(paramEntity);
      if (paramEntity != null) {
        this.db.execSQL(paramEntity);
      }
      createTableCache.put(str, Boolean.valueOf(bool1));
      if (QLog.isColorLevel())
      {
        paramEntity = new StringBuilder();
        paramEntity.append("createTable, tableName=");
        paramEntity.append(paramString);
        paramEntity.append(", isCreated=");
        paramEntity.append(bool1);
        paramEntity.append(", isForceCreate=");
        paramEntity.append(paramBoolean);
        QLog.d("EntityManager", 2, paramEntity.toString());
      }
      bool2 = bool1;
      if (bool1)
      {
        this.db.addToTableCache(paramString);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private void filterContentValueLoopInnerLog(Entity paramEntity, String paramString, Object paramObject)
  {
    if ((paramObject != null) && (paramEntity != null) && (TextUtils.equals("ExtensionInfo", paramEntity.getTableName())) && (!TextUtils.isEmpty(paramString)) && ((TextUtils.equals("intimate_type", paramString)) || (TextUtils.equals("hiddenChatSwitch", paramString)) || (TextUtils.equals("isSharingLocation", paramString)) || (TextUtils.equals("uin", paramString))))
    {
      paramEntity = new StringBuilder();
      paramEntity.append("entity.prewrite after, createContentValue， fieldName = ");
      paramEntity.append(paramString);
      paramEntity.append(", value = ");
      paramEntity.append(paramObject);
      QLog.i("EntityManager", 1, paramEntity.toString());
    }
  }
  
  private void filterContentValueLoopOuterLog(Entity paramEntity)
  {
    if ((paramEntity != null) && (TextUtils.equals("ExtensionInfo", paramEntity.getTableName())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("entity.prewrite after, filterContentValueLoopOuterLog，entity = ");
      localStringBuilder.append(paramEntity);
      QLog.i("EntityManager", 1, localStringBuilder.toString());
    }
  }
  
  private void filterExtensionInfoLog(Entity paramEntity, ContentValues paramContentValues)
  {
    if ((paramContentValues != null) && (paramEntity != null) && (TextUtils.equals("ExtensionInfo", paramEntity.getTableName())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContentValues);
      localStringBuilder.append("");
      paramContentValues = localStringBuilder.toString();
      if ((paramContentValues.contains("intimate_type=1")) || (paramContentValues.contains("hiddenChatSwitch=1")) || (paramContentValues.contains("isSharingLocation=1")))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("entity.prewrite after, ContentValues cv = ");
        localStringBuilder.append(paramContentValues);
        QLog.i("EntityManager", 1, localStringBuilder.toString());
      }
      paramContentValues = new StringBuilder();
      paramContentValues.append("entity.prewrite after, entity = ");
      paramContentValues.append(paramEntity);
      QLog.i("EntityManager", 1, paramContentValues.toString());
    }
  }
  
  private String getCacheKeyFromTableName(String paramString)
  {
    if (this.mName == null) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mName);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private long getEntityId(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0)
      {
        long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        return l;
      }
    }
    catch (Exception paramCursor)
    {
      QLog.d("EntityManager", 1, paramCursor, new Object[0]);
    }
    return -1L;
  }
  
  /* Error */
  private Cursor queryInner(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:tabbleIsExist	(Ljava/lang/String;)Z
    //   5: ifeq +47 -> 52
    //   8: aload_0
    //   9: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   12: invokevirtual 359	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   15: aload_2
    //   16: aload_3
    //   17: aload 4
    //   19: aload 5
    //   21: aload 8
    //   23: aload 9
    //   25: invokevirtual 363	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_2
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: goto +22 -> 54
    //   35: astore_2
    //   36: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +13 -> 52
    //   42: ldc 18
    //   44: iconst_2
    //   45: aload_2
    //   46: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   49: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: areturn
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	EntityManager
    //   0	56	1	paramBoolean	boolean
    //   0	56	2	paramString1	String
    //   0	56	3	paramArrayOfString1	String[]
    //   0	56	4	paramString2	String
    //   0	56	5	paramArrayOfString2	String[]
    //   0	56	6	paramString3	String
    //   0	56	7	paramString4	String
    //   0	56	8	paramString5	String
    //   0	56	9	paramString6	String
    //   0	56	10	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   0	29	31	finally
    //   36	52	31	finally
    //   0	29	35	java/lang/Exception
  }
  
  /* Error */
  private List<? extends Entity> queryInner(Class<? extends Entity> paramClass, String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, String paramString6, NoColumnErrorHandler paramNoColumnErrorHandler, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 14
    //   9: aload_0
    //   10: iload_3
    //   11: aload_2
    //   12: aconst_null
    //   13: aload 4
    //   15: aload 5
    //   17: aload 6
    //   19: aload 7
    //   21: aload 8
    //   23: aload 9
    //   25: invokevirtual 376	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +60 -> 92
    //   35: new 378	com/tencent/mobileqq/persistence/CursorOpt
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 381	com/tencent/mobileqq/persistence/CursorOpt:<init>	(Landroid/database/Cursor;)V
    //   44: astore 5
    //   46: aload_0
    //   47: aload_1
    //   48: aload_2
    //   49: aload 5
    //   51: aload 10
    //   53: invokevirtual 385	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;Lcom/tencent/mobileqq/persistence/NoColumnErrorHandler;)Ljava/util/List;
    //   56: astore_1
    //   57: aload 5
    //   59: astore 4
    //   61: goto +34 -> 95
    //   64: astore_1
    //   65: aload 5
    //   67: astore_2
    //   68: goto +94 -> 162
    //   71: astore_2
    //   72: aload 5
    //   74: astore_1
    //   75: goto +49 -> 124
    //   78: astore_1
    //   79: aload 4
    //   81: astore_2
    //   82: goto +80 -> 162
    //   85: astore_2
    //   86: aload 4
    //   88: astore_1
    //   89: goto +35 -> 124
    //   92: aload 14
    //   94: astore_1
    //   95: aload_1
    //   96: astore_2
    //   97: aload 4
    //   99: ifnull +54 -> 153
    //   102: aload_1
    //   103: astore_2
    //   104: aload 4
    //   106: astore_1
    //   107: aload_1
    //   108: invokeinterface 388 1 0
    //   113: aload_2
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_2
    //   118: goto +44 -> 162
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 18
    //   132: iconst_2
    //   133: aload_2
    //   134: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 13
    //   142: astore_2
    //   143: aload_1
    //   144: ifnull +9 -> 153
    //   147: aload 12
    //   149: astore_2
    //   150: goto -43 -> 107
    //   153: aload_2
    //   154: areturn
    //   155: astore 4
    //   157: aload_1
    //   158: astore_2
    //   159: aload 4
    //   161: astore_1
    //   162: aload_2
    //   163: ifnull +9 -> 172
    //   166: aload_2
    //   167: invokeinterface 388 1 0
    //   172: goto +5 -> 177
    //   175: aload_1
    //   176: athrow
    //   177: goto -2 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	EntityManager
    //   0	180	1	paramClass	Class<? extends Entity>
    //   0	180	2	paramString1	String
    //   0	180	3	paramBoolean	boolean
    //   0	180	4	paramString2	String
    //   0	180	5	paramArrayOfString	String[]
    //   0	180	6	paramString3	String
    //   0	180	7	paramString4	String
    //   0	180	8	paramString5	String
    //   0	180	9	paramString6	String
    //   0	180	10	paramNoColumnErrorHandler	NoColumnErrorHandler
    //   0	180	11	paramInt	int
    //   1	147	12	localObject1	Object
    //   4	137	13	localObject2	Object
    //   7	86	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	57	64	finally
    //   46	57	71	java/lang/Exception
    //   35	46	78	finally
    //   35	46	85	java/lang/Exception
    //   9	30	115	finally
    //   9	30	121	java/lang/Exception
    //   124	140	155	finally
  }
  
  public void close() {}
  
  protected ContentValues createContentValue(Entity paramEntity)
  {
    Object localObject1 = paramEntity.createContentValues();
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = TableBuilder.getValidField(paramEntity.getClassForTable());
    int j = ((List)localObject1).size();
    ContentValues localContentValues = new ContentValues(j);
    int i = 0;
    while (i < j)
    {
      Object localObject2 = (Field)((List)localObject1).get(i);
      String str = ((Field)localObject2).getName();
      if (!((Field)localObject2).isAccessible()) {
        ((Field)localObject2).setAccessible(true);
      }
      localObject2 = ((Field)localObject2).get(paramEntity);
      filterContentValueLoopInnerLog(paramEntity, str, localObject2);
      if ((localObject2 instanceof Integer))
      {
        localContentValues.put(str, (Integer)localObject2);
      }
      else if ((localObject2 instanceof Long))
      {
        localContentValues.put(str, (Long)localObject2);
      }
      else if ((localObject2 instanceof String))
      {
        localContentValues.put(str, (String)localObject2);
      }
      else if ((localObject2 instanceof byte[]))
      {
        localContentValues.put(str, (byte[])localObject2);
      }
      else if ((localObject2 instanceof Short))
      {
        localContentValues.put(str, (Short)localObject2);
      }
      else
      {
        boolean bool = localObject2 instanceof Boolean;
        if (bool) {
          localContentValues.put(str, (Boolean)localObject2);
        } else if ((localObject2 instanceof Double)) {
          localContentValues.put(str, (Double)localObject2);
        } else if ((localObject2 instanceof Float)) {
          localContentValues.put(str, (Float)localObject2);
        } else if ((localObject2 instanceof Byte)) {
          localContentValues.put(str, (Byte)localObject2);
        } else if (bool) {
          localContentValues.put(str, (Boolean)localObject2);
        }
      }
      i += 1;
    }
    filterContentValueLoopOuterLog(paramEntity);
    return localContentValues;
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, Cursor paramCursor)
  {
    try
    {
      paramClass = cursor2Entity(paramClass, TableBuilder.getTableName(paramClass), paramCursor);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      label13:
      break label13;
    }
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
    long l = getEntityId(paramCursor);
    try
    {
      paramClass = (Entity)paramClass.newInstance();
      if (paramClass != null)
      {
        paramClass._id = l;
        if (!paramClass.entityByCursor(paramCursor)) {
          assignEntityFieldsValue(paramCursor, paramNoColumnErrorHandler, paramClass);
        }
        if ((l != -1L) && (paramString != null)) {
          paramClass._status = 1001;
        } else {
          paramClass._status = 1002;
        }
        paramClass.postRead();
      }
      return paramClass;
    }
    catch (OutOfMemoryError paramClass)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
        return null;
      }
    }
    catch (Exception paramClass)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
      }
    }
    return null;
  }
  
  public List<? extends Entity> cursor2List(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor)
  {
    return cursor2List(paramClass, paramString, paramCursor, null);
  }
  
  public List<? extends Entity> cursor2List(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    Entity localEntity = null;
    Object localObject4 = null;
    localObject3 = null;
    localObject2 = localObject4;
    Object localObject1;
    if (paramCursor != null)
    {
      localObject1 = localEntity;
      localObject2 = localObject4;
      for (;;)
      {
        try
        {
          if (paramCursor.moveToFirst())
          {
            localObject1 = localEntity;
            i = paramCursor.getCount();
            localObject2 = localObject3;
            localObject1 = localObject2;
            localEntity = cursor2Entity(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
            localObject3 = localObject2;
            if (localEntity != null)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject1 = localObject2;
              }
            }
          }
        }
        catch (Exception paramClass)
        {
          int i;
          boolean bool;
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
            localObject2 = localObject1;
          }
        }
        try
        {
          localObject3 = new ArrayList(i);
          localObject1 = localObject3;
          ((List)localObject3).add(localEntity);
        }
        catch (Throwable localThrowable)
        {
          localObject3 = localObject2;
          continue;
        }
        localObject1 = localObject3;
        bool = paramCursor.moveToNext();
        localObject2 = localObject3;
        if (!bool) {
          return localObject3;
        }
      }
    }
    return localObject2;
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
      SQLiteDatabase localSQLiteDatabase = this.db;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DROP TABLE IF EXISTS ");
      localStringBuilder.append(paramClass);
      localSQLiteDatabase.execSQL(localStringBuilder.toString());
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
      SQLiteDatabase localSQLiteDatabase = this.db;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DROP TABLE IF EXISTS ");
      localStringBuilder.append(paramString);
      localSQLiteDatabase.execSQL(localStringBuilder.toString());
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
  
  /* Error */
  public boolean execSQL(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   4: invokevirtual 359	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: aload_1
    //   8: invokevirtual 243	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   11: pop
    //   12: iconst_1
    //   13: ireturn
    //   14: astore_1
    //   15: goto +22 -> 37
    //   18: astore_1
    //   19: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +13 -> 35
    //   25: ldc 18
    //   27: iconst_2
    //   28: aload_1
    //   29: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   32: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	EntityManager
    //   0	39	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   0	12	14	finally
    //   19	35	14	finally
    //   0	12	18	java/lang/Exception
  }
  
  public Entity find(Class<? extends Entity> paramClass, long paramLong)
  {
    try
    {
      paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, "_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, null, null, 3);
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
    }
    paramClass = null;
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public Entity find(Class<? extends Entity> paramClass, String paramString)
  {
    Object localObject1 = TableBuilder.getValidField(paramClass);
    int j = ((List)localObject1).size();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = (Field)((List)localObject1).get(i);
      if (((Field)localObject2).isAnnotationPresent(unique.class))
      {
        localObject1 = ((Field)localObject2).getName();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("=?");
        localObject1 = ((StringBuilder)localObject2).toString();
        try
        {
          paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, (String)localObject1, new String[] { paramString }, null, null, null, null, null, 3);
        }
        catch (IllegalAccessException paramClass)
        {
          paramClass.printStackTrace();
        }
        catch (InstantiationException paramClass)
        {
          paramClass.printStackTrace();
        }
        paramClass = null;
        if ((paramClass == null) || (paramClass.size() <= 0)) {
          break;
        }
        return (Entity)paramClass.get(0);
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
    if (paramClass.isAnnotationPresent(uniqueConstraints.class))
    {
      Object localObject1 = null;
      try
      {
        Object localObject2 = ((uniqueConstraints)paramClass.getAnnotation(uniqueConstraints.class)).columnNames();
        localObject2 = ((String)localObject2).split(",");
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < localObject2.length)
        {
          localStringBuffer.append(localObject2[i]);
          if (i == localObject2.length - 1) {
            localStringBuffer.append("=?");
          } else {
            localStringBuffer.append("=? and ");
          }
          i += 1;
        }
        try
        {
          paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, localStringBuffer.toString(), paramVarArgs, null, null, null, null, null, 3);
        }
        catch (IllegalAccessException paramClass)
        {
          paramClass.printStackTrace();
        }
        catch (InstantiationException paramClass)
        {
          paramClass.printStackTrace();
        }
        paramClass = null;
        paramVarArgs = localObject1;
        if (paramClass != null) {
          paramVarArgs = (Entity)paramClass.get(0);
        }
        return paramVarArgs;
      }
      catch (IncompatibleClassChangeError paramClass)
      {
        paramClass.printStackTrace();
        return null;
      }
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("No uniqueConstraints annotation in the Entity ");
    paramVarArgs.append(paramClass.getSimpleName());
    paramClass = new IllegalStateException(paramVarArgs.toString());
    for (;;)
    {
      throw paramClass;
    }
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
    if (paramEntity._status == 1000)
    {
      Object localObject = paramEntity.getTableName();
      createTable((String)localObject, paramEntity, false);
      paramEntity.prewrite();
      try
      {
        ContentValues localContentValues = createContentValue(paramEntity);
        long l1;
        if (paramBoolean) {
          l1 = this.db.replace((String)localObject, null, localContentValues);
        } else {
          l1 = this.db.insert((String)localObject, null, localContentValues);
        }
        long l2 = l1;
        if (l1 == -1L)
        {
          l2 = l1;
          if (createTable((String)localObject, paramEntity, true)) {
            if (paramBoolean) {
              l2 = this.db.replace((String)localObject, null, localContentValues);
            } else {
              l2 = this.db.insert((String)localObject, null, localContentValues);
            }
          }
        }
        if (l2 != -1L)
        {
          paramEntity._id = l2;
          paramEntity._status = 1001;
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("replace or insert error with -1 ");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.e("EntityManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
        }
      }
      paramEntity.postwrite();
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
      SQLiteDatabase localSQLiteDatabase = this.db;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete from ");
      localStringBuilder.append(str);
      localSQLiteDatabase.execSQL(localStringBuilder.toString());
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
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
      }
    }
    paramEntity.postwrite();
  }
  
  public void persist(Entity paramEntity)
  {
    try
    {
      insertOrReplace(paramEntity, false);
      return;
    }
    catch (Throwable paramEntity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, "persist error", paramEntity);
      }
    }
  }
  
  public void persistOrReplace(Entity paramEntity)
  {
    try
    {
      insertOrReplace(paramEntity, true);
      return;
    }
    catch (Throwable paramEntity)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, "persistOrReplace error", paramEntity);
      }
    }
  }
  
  /* Error */
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 356	com/tencent/mobileqq/persistence/EntityManager:tabbleIsExist	(Ljava/lang/String;)Z
    //   5: ifeq +47 -> 52
    //   8: aload_0
    //   9: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   12: invokevirtual 359	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   15: aload_2
    //   16: aload_3
    //   17: aload 4
    //   19: aload 5
    //   21: aload 8
    //   23: aload 9
    //   25: invokevirtual 363	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_2
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: goto +22 -> 54
    //   35: astore_2
    //   36: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +13 -> 52
    //   42: ldc 18
    //   44: iconst_2
    //   45: aload_2
    //   46: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   49: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: areturn
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	EntityManager
    //   0	56	1	paramBoolean	boolean
    //   0	56	2	paramString1	String
    //   0	56	3	paramArrayOfString1	String[]
    //   0	56	4	paramString2	String
    //   0	56	5	paramArrayOfString2	String[]
    //   0	56	6	paramString3	String
    //   0	56	7	paramString4	String
    //   0	56	8	paramString5	String
    //   0	56	9	paramString6	String
    // Exception table:
    //   from	to	target	type
    //   0	29	31	finally
    //   36	52	31	finally
    //   0	29	35	java/lang/Exception
  }
  
  public List<? extends Entity> query(Class<? extends Entity> paramClass)
  {
    try
    {
      paramClass = queryInner(paramClass, TableBuilder.getTableName(paramClass), false, null, null, null, null, null, null, null, 2);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
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
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("query Exception, table : ");
        paramArrayOfString.append(paramClass);
        QLog.d("EntityManager", 2, paramArrayOfString.toString());
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
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_0
    //   10: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   13: invokevirtual 359	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   16: aload_2
    //   17: aload_3
    //   18: aload 4
    //   20: aload 5
    //   22: invokevirtual 645	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload 8
    //   28: astore_2
    //   29: aload_3
    //   30: ifnull +25 -> 55
    //   33: aload_3
    //   34: astore_2
    //   35: aload_0
    //   36: aload_1
    //   37: aconst_null
    //   38: aload_3
    //   39: invokevirtual 647	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: goto +10 -> 55
    //   48: astore 4
    //   50: aload_3
    //   51: astore_1
    //   52: goto +30 -> 82
    //   55: aload_2
    //   56: astore 4
    //   58: aload_3
    //   59: ifnull +58 -> 117
    //   62: aload_3
    //   63: astore_1
    //   64: aload_1
    //   65: invokeinterface 388 1 0
    //   70: aload_2
    //   71: areturn
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_2
    //   75: goto +46 -> 121
    //   78: astore 4
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: astore_2
    //   84: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +16 -> 103
    //   90: aload_1
    //   91: astore_2
    //   92: ldc 18
    //   94: iconst_2
    //   95: aload 4
    //   97: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   100: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 7
    //   105: astore 4
    //   107: aload_1
    //   108: ifnull +9 -> 117
    //   111: aload 6
    //   113: astore_2
    //   114: goto -50 -> 64
    //   117: aload 4
    //   119: areturn
    //   120: astore_1
    //   121: aload_2
    //   122: ifnull +9 -> 131
    //   125: aload_2
    //   126: invokeinterface 388 1 0
    //   131: goto +5 -> 136
    //   134: aload_1
    //   135: athrow
    //   136: goto -2 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	EntityManager
    //   0	139	1	paramClass	Class<? extends Entity>
    //   0	139	2	paramString1	String
    //   0	139	3	paramString2	String
    //   0	139	4	paramString3	String
    //   0	139	5	paramArrayOfString	String[]
    //   1	111	6	localObject1	Object
    //   4	100	7	localObject2	Object
    //   7	20	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	43	48	java/lang/Exception
    //   9	26	72	finally
    //   9	26	78	java/lang/Exception
    //   35	43	120	finally
    //   84	90	120	finally
    //   92	103	120	finally
  }
  
  /* Error */
  public List<? extends Entity> rawQuery(Class<? extends Entity> paramClass, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 51	com/tencent/mobileqq/persistence/EntityManager:dbHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   13: invokevirtual 359	com/tencent/mobileqq/app/SQLiteOpenHelper:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   16: aload_2
    //   17: aload_3
    //   18: invokevirtual 652	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_2
    //   22: aload 6
    //   24: astore_3
    //   25: aload_2
    //   26: ifnull +26 -> 52
    //   29: aload_2
    //   30: astore_3
    //   31: aload_0
    //   32: aload_1
    //   33: aconst_null
    //   34: aload_2
    //   35: invokevirtual 647	com/tencent/mobileqq/persistence/EntityManager:cursor2List	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   38: astore_1
    //   39: aload_1
    //   40: astore_3
    //   41: goto +11 -> 52
    //   44: astore_1
    //   45: goto +30 -> 75
    //   48: astore_1
    //   49: goto +49 -> 98
    //   52: aload_3
    //   53: astore_1
    //   54: aload_2
    //   55: ifnull +76 -> 131
    //   58: aload_2
    //   59: invokeinterface 388 1 0
    //   64: aload_3
    //   65: areturn
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_3
    //   69: goto +65 -> 134
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_3
    //   77: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +72 -> 152
    //   83: aload_2
    //   84: astore_3
    //   85: ldc 18
    //   87: iconst_2
    //   88: aload_1
    //   89: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto +57 -> 152
    //   98: aload_2
    //   99: astore_3
    //   100: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +15 -> 118
    //   106: aload_2
    //   107: astore_3
    //   108: ldc 18
    //   110: iconst_2
    //   111: aload_1
    //   112: invokestatic 369	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   115: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload 5
    //   120: astore_1
    //   121: aload_2
    //   122: ifnull +9 -> 131
    //   125: aload 4
    //   127: astore_3
    //   128: goto -70 -> 58
    //   131: aload_1
    //   132: areturn
    //   133: astore_1
    //   134: aload_3
    //   135: ifnull +9 -> 144
    //   138: aload_3
    //   139: invokeinterface 388 1 0
    //   144: goto +5 -> 149
    //   147: aload_1
    //   148: athrow
    //   149: goto -2 -> 147
    //   152: aload 5
    //   154: astore_1
    //   155: aload_2
    //   156: ifnull -25 -> 131
    //   159: aload 4
    //   161: astore_3
    //   162: goto -104 -> 58
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: goto -70 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	EntityManager
    //   0	171	1	paramClass	Class<? extends Entity>
    //   0	171	2	paramString	String
    //   0	171	3	paramArrayOfString	String[]
    //   1	159	4	localObject1	Object
    //   4	149	5	localObject2	Object
    //   7	16	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	39	44	java/lang/OutOfMemoryError
    //   31	39	48	java/lang/Exception
    //   9	22	66	finally
    //   9	22	72	java/lang/OutOfMemoryError
    //   31	39	133	finally
    //   77	83	133	finally
    //   85	95	133	finally
    //   100	106	133	finally
    //   108	118	133	finally
    //   9	22	165	java/lang/Exception
  }
  
  public boolean remove(Entity paramEntity)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    paramEntity.prewrite();
    int i = paramEntity._status;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 1001)
    {
      bool1 = bool2;
      if (this.db.delete(paramEntity.getTableName(), "_id=?", new String[] { String.valueOf(paramEntity._id) }) > 0) {
        bool1 = true;
      }
      paramEntity._status = 1003;
    }
    paramEntity.postwrite();
    return bool1;
  }
  
  public boolean remove(Entity paramEntity, String paramString, String[] paramArrayOfString)
  {
    if (this.db == null) {
      this.db = this.dbHelper.getWritableDatabase();
    }
    paramEntity.prewrite();
    int i = paramEntity._status;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 1001)
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
    if (paramString == null) {
      return false;
    }
    if ("Sqlite_master".equalsIgnoreCase(paramString)) {
      return true;
    }
    SQLiteDatabase localSQLiteDatabase = this.dbHelper.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return false;
    }
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
    boolean bool = false;
    try
    {
      if ((paramEntity._status == 1001) || (paramEntity._status == 1002))
      {
        ContentValues localContentValues = createContentValue(paramEntity);
        filterExtensionInfoLog(paramEntity, localContentValues);
        int i = this.db.update(paramEntity.getTableName(), localContentValues, "_id=?", new String[] { String.valueOf(paramEntity._id) });
        if (i > 0) {
          bool = true;
        }
        return bool;
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
      return bool;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManager
 * JD-Core Version:    0.7.0.1
 */