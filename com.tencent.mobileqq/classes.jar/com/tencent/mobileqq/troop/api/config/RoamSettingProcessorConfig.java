package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class RoamSettingProcessorConfig
{
  private static RoamSettingProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigRoamSettingProcessorConfig;
  private static ArrayList<AbsRoamSettingProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private RoamSettingProcessorConfig()
  {
    a();
  }
  
  public static RoamSettingProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigRoamSettingProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigRoamSettingProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigRoamSettingProcessorConfig = new RoamSettingProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigRoamSettingProcessorConfig;
  }
  
  public int a(String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((AbsRoamSettingProcessor)localIterator.next()).a(paramString);
      if (i != -1) {
        return i;
      }
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((AbsRoamSettingProcessor)localIterator.next()).a(paramInt);
      if (str != null) {
        return str;
      }
    }
    return "";
  }
  
  public void a()
  {
    if (BizTroopCustomizedProcessorRegister.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsRoamSettingProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("RoamSettingProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsRoamSettingProcessor)localIterator.next()).a(paramString1, paramString2);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsRoamSettingProcessor)localIterator.next()).a(paramArrayList);
    }
  }
  
  public String b(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((AbsRoamSettingProcessor)localIterator.next()).b(paramInt);
      if (str != null) {
        return str;
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.RoamSettingProcessorConfig
 * JD-Core Version:    0.7.0.1
 */