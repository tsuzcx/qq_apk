package com.tencent.mobileqq.gamecenter.data;

import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class BaseDataHelper
{
  public static final String a;
  protected EntityManager b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.b);
    localStringBuilder.append("BaseDataHelper");
    a = localStringBuilder.toString();
  }
  
  public BaseDataHelper(EntityManager paramEntityManager)
  {
    this.b = paramEntityManager;
  }
  
  protected boolean a(Entity paramEntity)
  {
    try
    {
      if (this.b.isOpen())
      {
        if (paramEntity.getStatus() == 1000)
        {
          this.b.persistOrReplace(paramEntity);
          if (paramEntity.getStatus() != 1001) {
            break label128;
          }
          return true;
        }
        if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
          return this.b.update(paramEntity);
        }
      }
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateEntity em closed e=");
        localStringBuilder.append(paramEntity.getTableName());
        QLog.e(str, 2, localStringBuilder.toString());
      }
      return false;
    }
    catch (Throwable paramEntity)
    {
      QLog.w(a, 1, paramEntity.getMessage());
      return false;
    }
    label128:
    return false;
  }
  
  protected boolean a(Entity paramEntity, String paramString, String[] paramArrayOfString)
  {
    try
    {
      if (this.b.isOpen()) {
        return this.b.remove(paramEntity, paramString, paramArrayOfString);
      }
      paramString = a;
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("removeEntity em closed e=");
      paramArrayOfString.append(paramEntity.getTableName());
      QLog.e(paramString, 2, paramArrayOfString.toString());
      return false;
    }
    catch (Throwable paramEntity)
    {
      QLog.w(a, 1, paramEntity.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.BaseDataHelper
 * JD-Core Version:    0.7.0.1
 */