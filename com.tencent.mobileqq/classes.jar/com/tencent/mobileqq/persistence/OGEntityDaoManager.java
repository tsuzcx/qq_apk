package com.tencent.mobileqq.persistence;

import java.lang.reflect.Method;

public class OGEntityDaoManager
{
  public static OGEntityDaoManager a;
  public static Method a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqPersistenceOGEntityDaoManager = new OGEntityDaoManager();
    jdField_a_of_type_JavaLangReflectMethod = null;
  }
  
  public static OGEntityDaoManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqPersistenceOGEntityDaoManager;
  }
  
  public OGAbstractDao a(Class paramClass)
  {
    return EntityDaoRegister.getEntityDao(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.OGEntityDaoManager
 * JD-Core Version:    0.7.0.1
 */