package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public abstract class Entity
{
  public static final int DETACHED = 1002;
  public static final int MANAGED = 1001;
  public static final int NEW = 1000;
  public static final int REMOVED = 1003;
  @notColumn
  long _id = -1L;
  @notColumn
  int _status = 1000;
  
  protected ContentValues createContentValues()
  {
    return null;
  }
  
  public Entity deepCopyByReflect()
  {
    try
    {
      localObject2 = (Entity)getClass().newInstance();
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = getClass().getFields();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject1[i];
          if (!localObject3.isAccessible()) {
            localObject3.setAccessible(true);
          }
          localObject3.set(localObject2, localObject3.get(this));
          i += 1;
        }
        ((Entity)localObject2)._status = 1000;
        ((Entity)localObject2).postRead();
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" deepCopyByReflect:failed");
      ((StringBuilder)localObject2).append(getClass().getName());
      ((StringBuilder)localObject2).append(" exception e: = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("Entity", 1, ((StringBuilder)localObject2).toString());
      localException.printStackTrace();
      Entity localEntity = null;
      return localEntity;
    }
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    return false;
  }
  
  protected Class<? extends Entity> getClassForTable()
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
  
  protected void postRead() {}
  
  protected void postwrite() {}
  
  protected void prewrite() {}
  
  public void setId(long paramLong)
  {
    this._id = paramLong;
  }
  
  public void setStatus(int paramInt)
  {
    this._status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Entity
 * JD-Core Version:    0.7.0.1
 */