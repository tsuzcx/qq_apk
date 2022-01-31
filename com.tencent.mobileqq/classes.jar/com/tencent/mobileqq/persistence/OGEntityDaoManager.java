package com.tencent.mobileqq.persistence;

public class OGEntityDaoManager
{
  public static OGEntityDaoManager a = new OGEntityDaoManager();
  
  public static OGEntityDaoManager a()
  {
    return a;
  }
  
  public OGAbstractDao a(Class paramClass)
  {
    return EntityDaoRegister.a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGEntityDaoManager
 * JD-Core Version:    0.7.0.1
 */