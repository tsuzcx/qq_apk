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
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("alter table ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" add ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" default ");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alter table ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" add ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static String createIndexSQLStatement(Entity paramEntity)
  {
    return TableBuilderProxy.createIndexSQLStatement(paramEntity);
  }
  
  public static String createSQLStatement(Entity paramEntity)
  {
    String str = paramEntity.getTableName();
    if (CREATE_TABLE_CACHE.containsKey(str)) {
      return (String)CREATE_TABLE_CACHE.get(str);
    }
    Object localObject1 = OGEntityDaoManagerProxy.getEntityDao(paramEntity.getClass());
    if (localObject1 != null)
    {
      localObject2 = ((OGAbstractDao)localObject1).getCreateTableSql(str);
      if (localObject2 != null)
      {
        CREATE_TABLE_CACHE.put(str, localObject2);
        ((OGAbstractDao)localObject1).useIndex = true;
        return localObject2;
      }
    }
    localObject1 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT");
    paramEntity = paramEntity.getClassForTable();
    Object localObject2 = getValidField(paramEntity);
    int i = 0;
    int j = ((List)localObject2).size();
    Object localObject3;
    while (i < j)
    {
      localObject3 = (Field)((List)localObject2).get(i);
      Object localObject4 = ((Field)localObject3).getName();
      Object localObject5 = ((Field)localObject3).getType();
      localObject5 = (String)TYPES.get(localObject5);
      if (localObject5 != null)
      {
        ((StringBuilder)localObject1).append(',');
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localObject5);
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        if (((Field)localObject3).isAnnotationPresent(unique.class))
        {
          ((StringBuilder)localObject1).append(" UNIQUE");
        }
        else if (((Field)localObject3).isAnnotationPresent(defaultzero.class))
        {
          ((StringBuilder)localObject1).append(" default 0");
        }
        else if (((Field)localObject3).isAnnotationPresent(defaultValue.class))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(" default ");
          ((StringBuilder)localObject4).append(((defaultValue)((Field)localObject3).getAnnotation(defaultValue.class)).defaultInteger());
          ((StringBuilder)localObject1).append(((StringBuilder)localObject4).toString());
        }
      }
      i += 1;
    }
    if (paramEntity.isAnnotationPresent(uniqueConstraints.class))
    {
      paramEntity = (uniqueConstraints)paramEntity.getAnnotation(uniqueConstraints.class);
      localObject2 = paramEntity.columnNames();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(",UNIQUE(");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(")");
      ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
      paramEntity = paramEntity.clause().toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" ON CONFLICT ");
      ((StringBuilder)localObject2).append(paramEntity);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    }
    ((StringBuilder)localObject1).append(')');
    paramEntity = ((StringBuilder)localObject1).toString();
    CREATE_TABLE_CACHE.put(str, paramEntity);
    return paramEntity;
  }
  
  public static String dropSQLStatement(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DROP TABLE IF EXISTS ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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
    try
    {
      paramClass = getTableConfig(paramClass).getClassForTable();
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
    Object localObject2 = (List)FIELD_CACHE.get(paramClass);
    Object localObject1 = localObject2;
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
      handlePrivateColumnFields(paramClass, (List)localObject1);
      FIELD_CACHE.put(paramClass, localObject1);
    }
    return localObject1;
  }
  
  private static void handlePrivateColumnFields(Class<? extends Entity> paramClass, List<Field> paramList)
  {
    if (sNeedPrivateFieldsClass.length == 0) {
      sNeedPrivateFieldsClass = TableBuilderProxy.getNeedPrivateFieldsClass();
    }
    Class[] arrayOfClass = sNeedPrivateFieldsClass;
    int i = arrayOfClass.length;
    int j = 0;
    int k;
    if (i != 0)
    {
      k = arrayOfClass.length;
      i = 0;
      while (i < k)
      {
        if (arrayOfClass[i] == paramClass) {
          break label64;
        }
        i += 1;
      }
      i = 0;
    }
    else
    {
      label64:
      i = 1;
    }
    if (i != 0)
    {
      paramClass = paramClass.getDeclaredFields();
      k = paramClass.length;
      i = j;
      while (i < k)
      {
        arrayOfClass = paramClass[i];
        if ((!Modifier.isStatic(arrayOfClass.getModifiers())) && (arrayOfClass.isAnnotationPresent(forceColumn.class)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add forceColumn field ");
          localStringBuilder.append(arrayOfClass);
          QLog.i("DB", 1, localStringBuilder.toString());
          paramList.add(arrayOfClass);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TableBuilder
 * JD-Core Version:    0.7.0.1
 */