package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class OGEntityManager
  extends EntityManager
{
  private static final String SQL = "EntityManager";
  
  public OGEntityManager(SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    super(paramSQLiteOpenHelper, paramString);
  }
  
  public static void extractedStatementByReflect(List<String> paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = TableBuilder.getValidField(paramClass);
    if (paramCursor.moveToFirst())
    {
      paramCursor = SecurityUtile.decode(paramCursor.getString(0)).split(",");
      int k = paramClass.size();
      int i = 0;
      while (i < k)
      {
        Field localField = (Field)paramClass.get(i);
        boolean bool2 = true;
        boolean bool1 = true;
        int j = 1;
        while (j < paramCursor.length)
        {
          String str = paramCursor[j].trim().split(" ")[0];
          if (localField.getName().equals(str))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("extractedStatementByReflect -> new field name: ");
              localStringBuilder.append(localField.getName());
              localStringBuilder.append(", old field name: ");
              localStringBuilder.append(str);
              QLog.e("EntityManager", 2, localStringBuilder.toString());
            }
            j = 1;
            break label185;
          }
          j += 1;
        }
        j = 0;
        label185:
        if (j == 0)
        {
          if (!localField.isAnnotationPresent(defaultzero.class))
          {
            if (localField.isAnnotationPresent(defaultValue.class))
            {
              j = ((defaultValue)localField.getAnnotation(defaultValue.class)).defaultInteger();
              bool1 = bool2;
            }
            else
            {
              bool1 = false;
            }
          }
          else {
            j = 0;
          }
          paramList.add(TableBuilder.addColumn(paramString, localField.getName(), (String)TableBuilder.TYPES.get(localField.getType()), bool1, j));
        }
        i += 1;
      }
    }
  }
  
  protected ContentValues createContentValue(Entity paramEntity)
  {
    System.nanoTime();
    OGAbstractDao localOGAbstractDao = OGEntityDaoManagerProxy.getEntityDao(paramEntity.getClass());
    if (localOGAbstractDao != null)
    {
      ContentValues localContentValues = new ContentValues(localOGAbstractDao.columnLen);
      localOGAbstractDao.entity2ContentValues(paramEntity, localContentValues);
      return localContentValues;
    }
    return super.createContentValue(paramEntity);
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    OGAbstractDao localOGAbstractDao = OGEntityDaoManagerProxy.getEntityDao(paramClass);
    if (localOGAbstractDao != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
    }
    catch (Exception localException)
    {
      long l;
      label57:
      Object localObject;
      break label57;
    }
    l = -1L;
    try
    {
      paramClass = (Entity)paramClass.newInstance();
      localObject = paramClass;
      if (paramClass != null)
      {
        paramClass._id = l;
        localObject = paramClass;
        if (!paramClass.entityByCursor(paramCursor)) {
          localObject = localOGAbstractDao.cursor2Entity(paramClass, paramCursor, localOGAbstractDao.useIndex, paramNoColumnErrorHandler);
        }
        if ((l != -1L) && (paramString != null)) {
          ((Entity)localObject)._status = 1001;
        } else {
          ((Entity)localObject)._status = 1002;
        }
        ((Entity)localObject).postRead();
        return localObject;
      }
    }
    catch (Exception paramClass)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
      }
      localObject = null;
    }
    return localObject;
    return super.cursor2Entity(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
  }
  
  protected void insertOrReplace(Entity paramEntity, boolean paramBoolean)
  {
    super.insertOrReplace(paramEntity, paramBoolean);
  }
  
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean update(Entity paramEntity)
  {
    return super.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGEntityManager
 * JD-Core Version:    0.7.0.1
 */