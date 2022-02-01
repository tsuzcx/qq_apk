package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class PAOfflineSearchManager
{
  static PAOfflineSearchManager jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager = null;
  String jdField_a_of_type_JavaLangString = "0";
  ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList = null;
  HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  public boolean b = true;
  boolean c = false;
  
  PAOfflineSearchManager()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static PAOfflineSearchManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager == null) {
        jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager = new PAOfflineSearchManager();
      }
      PAOfflineSearchManager localPAOfflineSearchManager = jdField_a_of_type_ComTencentMobileqqSearchUtilPAOfflineSearchManager;
      return localPAOfflineSearchManager;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.PAOfflineSearchManager
 * JD-Core Version:    0.7.0.1
 */