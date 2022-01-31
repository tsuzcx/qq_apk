package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class OGEntityManager
  extends EntityManager
{
  public OGEntityManager(SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    super(paramSQLiteOpenHelper, paramString);
  }
  
  public static void a(List paramList, String paramString, Cursor paramCursor, Class paramClass)
  {
    paramClass = TableBuilder.a(paramClass);
    int j;
    Field localField;
    if (paramCursor.moveToFirst())
    {
      paramCursor = SecurityUtile.b(paramCursor.getString(0)).split(",");
      int k = paramClass.size();
      j = 0;
      if (j < k)
      {
        localField = (Field)paramClass.get(j);
        i = 1;
        label64:
        if (i >= paramCursor.length) {
          break label221;
        }
        String str = paramCursor[i].trim().split(" ")[0];
        if (!localField.getName().equals(str)) {}
      }
    }
    label178:
    label221:
    for (int i = 1;; i = 0)
    {
      boolean bool;
      if (i == 0)
      {
        if (!localField.isAnnotationPresent(defaultzero.class)) {
          break label178;
        }
        i = 0;
        bool = true;
      }
      for (;;)
      {
        paramList.add(TableBuilder.a(paramString, localField.getName(), (String)TableBuilder.a.get(localField.getType()), bool, i));
        j += 1;
        break;
        i += 1;
        break label64;
        if (localField.isAnnotationPresent(defaultValue.class))
        {
          i = ((defaultValue)localField.getAnnotation(defaultValue.class)).a();
          bool = true;
        }
        else
        {
          i = 0;
          bool = false;
        }
      }
    }
  }
  
  protected ContentValues a(Entity paramEntity)
  {
    System.nanoTime();
    OGAbstractDao localOGAbstractDao = OGEntityDaoManager.a().a(paramEntity.getClass());
    if (localOGAbstractDao != null)
    {
      ContentValues localContentValues = new ContentValues(localOGAbstractDao.jdField_a_of_type_Int);
      localOGAbstractDao.a(paramEntity, localContentValues);
      return localContentValues;
    }
    return super.a(paramEntity);
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return super.a(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public Entity a(Class paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    OGAbstractDao localOGAbstractDao = OGEntityDaoManager.a().a(paramClass);
    if (localOGAbstractDao != null) {
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {}
      Entity localEntity;
      for (l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));; l = -1L) {
        try
        {
          localEntity = (Entity)paramClass.newInstance();
          if (localEntity == null) {
            break;
          }
          localEntity._id = l;
          paramClass = localEntity;
          if (!localEntity.entityByCursor(paramCursor)) {
            paramClass = localOGAbstractDao.a(localEntity, paramCursor, localOGAbstractDao.jdField_a_of_type_Boolean, paramNoColumnErrorHandler);
          }
          if ((l != -1L) && (paramString != null)) {}
          for (paramClass._status = 1001;; paramClass._status = 1002)
          {
            paramClass.postRead();
            return paramClass;
          }
          return super.a(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
      }
      return localEntity;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = -1L;
      }
    }
  }
  
  protected void a(Entity paramEntity, boolean paramBoolean)
  {
    super.a(paramEntity, paramBoolean);
  }
  
  public boolean a(Entity paramEntity)
  {
    return super.a(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGEntityManager
 * JD-Core Version:    0.7.0.1
 */