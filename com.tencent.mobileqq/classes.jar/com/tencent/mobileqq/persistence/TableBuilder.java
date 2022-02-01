package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy;
import com.tencent.mobileqq.imcore.proxy.db.TableBuilderProxy;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TableBuilder
{
  private static final Map<Class<? extends Entity>, List<Field>> ALL_FIELD_CACHE;
  private static final Map<String, String> CREATE_TABLE_CACHE;
  private static final Map<Class<? extends Entity>, List<Field>> FIELD_CACHE;
  public static final String PRIMARY_KEY = "_id";
  private static final Map<Class<? extends Entity>, Entity> TABLE_CACHE;
  public static final Map<Class<?>, String> TYPES = new HashMap();
  private static Class[] sNeedPrivateFieldsClass = new Class[0];
  
  static
  {
    FIELD_CACHE = new ConcurrentHashMap();
    ALL_FIELD_CACHE = new ConcurrentHashMap();
    CREATE_TABLE_CACHE = new ConcurrentHashMap();
    TABLE_CACHE = new ConcurrentHashMap();
    TYPES.put(Byte.TYPE, "INTEGER");
    TYPES.put(Boolean.TYPE, "INTEGER");
    TYPES.put(Short.TYPE, "INTEGER");
    TYPES.put(Integer.TYPE, "INTEGER");
    TYPES.put(Long.TYPE, "INTEGER");
    TYPES.put(String.class, "TEXT");
    TYPES.put([B.class, "BLOB");
    TYPES.put(Float.TYPE, "REAL");
    TYPES.put(Double.TYPE, "REAL");
  }
  
  public static String addColumn(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return addColumn(paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static String addColumn(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3 + " default " + paramInt;
    }
    return "alter table " + paramString1 + " add " + paramString2 + " " + paramString3;
  }
  
  public static String createIndexSQLStatement(Entity paramEntity)
  {
    return TableBuilderProxy.createIndexSQLStatement(paramEntity);
  }
  
  public static String createSQLStatement(Entity paramEntity)
  {
    String str1 = paramEntity.getTableName();
    if (CREATE_TABLE_CACHE.containsKey(str1)) {
      return (String)CREATE_TABLE_CACHE.get(str1);
    }
    Object localObject1 = OGEntityDaoManagerProxy.getEntityDao(paramEntity.getClass());
    if (localObject1 != null)
    {
      localObject2 = ((OGAbstractDao)localObject1).getCreateTableSql(str1);
      if (localObject2 != null)
      {
        CREATE_TABLE_CACHE.put(str1, localObject2);
        ((OGAbstractDao)localObject1).useIndex = true;
        return localObject2;
      }
    }
    localObject1 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
    paramEntity = paramEntity.getClassForTable();
    Object localObject2 = getValidField(paramEntity);
    int j = ((List)localObject2).size();
    int i = 0;
    if (i < j)
    {
      Field localField = (Field)((List)localObject2).get(i);
      String str2 = localField.getName();
      Object localObject3 = localField.getType();
      localObject3 = (String)TYPES.get(localObject3);
      if (localObject3 != null)
      {
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(str2 + " " + (String)localObject3);
        if (!localField.isAnnotationPresent(unique.class)) {
          break label241;
        }
        ((StringBuilder)localObject1).append(" UNIQUE");
      }
      for (;;)
      {
        i += 1;
        break;
        label241:
        if (localField.isAnnotationPresent(defaultzero.class)) {
          ((StringBuilder)localObject1).append(" default 0");
        } else if (localField.isAnnotationPresent(defaultValue.class)) {
          ((StringBuilder)localObject1).append(" default " + ((defaultValue)localField.getAnnotation(defaultValue.class)).defaultInteger());
        }
      }
    }
    if (paramEntity.isAnnotationPresent(uniqueConstraints.class))
    {
      paramEntity = (uniqueConstraints)paramEntity.getAnnotation(uniqueConstraints.class);
      localObject2 = paramEntity.columnNames();
      ((StringBuilder)localObject1).append(",UNIQUE(" + (String)localObject2 + ")");
      paramEntity = paramEntity.clause().toString();
      ((StringBuilder)localObject1).append(" ON CONFLICT " + paramEntity);
    }
    ((StringBuilder)localObject1).append(')');
    paramEntity = ((StringBuilder)localObject1).toString();
    CREATE_TABLE_CACHE.put(str1, paramEntity);
    return paramEntity;
  }
  
  public static String dropSQLStatement(String paramString)
  {
    return "DROP TABLE IF EXISTS " + paramString;
  }
  
  public static List<Field> getAllField(Entity paramEntity)
  {
    Class localClass = paramEntity.getClassForTable();
    Object localObject1 = (List)ALL_FIELD_CACHE.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramEntity = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!Modifier.isStatic(localObject2.getModifiers())) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      ALL_FIELD_CACHE.put(localClass, paramEntity);
    }
    return paramEntity;
  }
  
  public static Entity getTableConfig(Class<? extends Entity> paramClass)
  {
    Entity localEntity2 = (Entity)TABLE_CACHE.get(paramClass);
    Entity localEntity1 = localEntity2;
    if (localEntity2 == null)
    {
      localEntity1 = (Entity)paramClass.newInstance();
      TABLE_CACHE.put(paramClass, localEntity1);
    }
    return localEntity1;
  }
  
  public static String getTableName(Class<? extends Entity> paramClass)
  {
    return getTableConfig(paramClass).getTableName();
  }
  
  public static String getTableNameSafe(Class<? extends Entity> paramClass)
  {
    try
    {
      paramClass = getTableName(paramClass);
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
  
  public static List<Field> getValidField(Entity paramEntity)
  {
    Class localClass = paramEntity.getClassForTable();
    Object localObject1 = (List)FIELD_CACHE.get(localClass);
    paramEntity = (Entity)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localClass.getFields();
      paramEntity = new ArrayList(localObject1.length);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((!Modifier.isStatic(localObject2.getModifiers())) && (!localObject2.isAnnotationPresent(notColumn.class))) {
          paramEntity.add(localObject2);
        }
        i += 1;
      }
      handlePrivateColumnFields(localClass, paramEntity);
      FIELD_CACHE.put(localClass, paramEntity);
    }
    return paramEntity;
  }
  
  public static List<Field> getValidField(Class<? extends Entity> paramClass)
  {
    Object localObject1;
    try
    {
      paramClass = getTableConfig(paramClass).getClassForTable();
      Object localObject2 = (List)FIELD_CACHE.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = paramClass.getFields();
        localObject1 = new ArrayList(localObject2.length);
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject2[i];
          if ((!Modifier.isStatic(localObject3.getModifiers())) && (!localObject3.isAnnotationPresent(notColumn.class))) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
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
      handlePrivateColumnFields(paramClass, (List)localObject1);
      FIELD_CACHE.put(paramClass, localObject1);
    }
    return localObject1;
  }
  
  private static void handlePrivateColumnFields(Class<? extends Entity> paramClass, List<Field> paramList)
  {
    int j = 0;
    if (sNeedPrivateFieldsClass.length == 0) {
      sNeedPrivateFieldsClass = TableBuilderProxy.getNeedPrivateFieldsClass();
    }
    Class[] arrayOfClass;
    int k;
    int i;
    if (sNeedPrivateFieldsClass.length != 0)
    {
      arrayOfClass = sNeedPrivateFieldsClass;
      k = arrayOfClass.length;
      i = 0;
      if (i >= k) {
        break label155;
      }
      if (arrayOfClass[i] == paramClass) {
        i = 1;
      }
    }
    for (;;)
    {
      label50:
      if (i != 0)
      {
        paramClass = paramClass.getDeclaredFields();
        k = paramClass.length;
        i = j;
        for (;;)
        {
          if (i < k)
          {
            arrayOfClass = paramClass[i];
            if ((!Modifier.isStatic(arrayOfClass.getModifiers())) && (arrayOfClass.isAnnotationPresent(forceColumn.class)))
            {
              QLog.i("DB", 1, "add forceColumn field " + arrayOfClass);
              paramList.add(arrayOfClass);
            }
            i += 1;
            continue;
            i += 1;
            break;
            i = 1;
            break label50;
          }
        }
      }
      return;
      label155:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TableBuilder
 * JD-Core Version:    0.7.0.1
 */