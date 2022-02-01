package com.tencent.mobileqq.persistence;

import java.lang.reflect.Method;

public class OGEntityDaoManager
{
  public static OGEntityDaoManager a = new OGEntityDaoManager();
  public static Method b = null;
  
  public static OGEntityDaoManager a()
  {
    return a;
  }
  
  public OGAbstractDao a(Class paramClass)
  {
    return EntityDaoRegister.getEntityDao(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGEntityDaoManager
 * JD-Core Version:    0.7.0.1
 */