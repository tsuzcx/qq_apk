package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public abstract class Entity
{
  public static final int DETACHED = 1002;
  public static final int MANAGED = 1001;
  public static final int NEW = 1000;
  public static final int REMOVED = 1003;
  long _id = -1L;
  int _status = 1000;
  
  public Entity deepCopyByReflect()
  {
    try
    {
      Entity localEntity = (Entity)getClass().newInstance();
      if (localEntity != null)
      {
        Field[] arrayOfField = getClass().getFields();
        int j = arrayOfField.length;
        int i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          localField.set(localEntity, localField.get(this));
          i += 1;
        }
        localEntity._status = 1000;
        localEntity.postRead();
      }
      return localEntity;
    }
    catch (Exception localException)
    {
      QLog.d("Entity", 1, " deepCopyByReflect:failed" + getClass().getName() + " exception e: = " + localException.getMessage());
      localException.printStackTrace();
    }
    return null;
  }
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    return false;
  }
  
  public Class getClassForTable()
  {
    return getClass();
  }
  
  public long getId()
  {
    return this._id;
  }
  
  public int getStatus()
  {
    return this._status;
  }
  
  public String getTableName()
  {
    return getClass().getSimpleName();
  }
  
  public void postRead() {}
  
  public void postwrite() {}
  
  public void prewrite() {}
  
  public void setId(long paramLong)
  {
    this._id = paramLong;
  }
  
  public void setStatus(int paramInt)
  {
    this._status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Entity
 * JD-Core Version:    0.7.0.1
 */