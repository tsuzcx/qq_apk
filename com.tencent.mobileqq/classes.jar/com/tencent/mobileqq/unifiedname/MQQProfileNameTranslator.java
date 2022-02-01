package com.tencent.mobileqq.unifiedname;

import android.text.TextUtils;
import java.util.List;

public class MQQProfileNameTranslator
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    switch (paramInt1)
    {
    default: 
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      return;
    case 10: 
      h(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    }
    a(paramArrayOfString, paramMQQProfileName);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2)
    {
      MQQName localMQQName;
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 1;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 4;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
      else if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
      else
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
    }
    else if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 1;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[1];
        return;
      }
      if (!TextUtils.isEmpty(paramArrayOfString[6]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 6;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
        return;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    }
  }
  
  public static void a(String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    MQQName localMQQName;
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 3;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      }
    }
    else
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 3;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      }
    }
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      if (!TextUtils.isEmpty(paramArrayOfString[6]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 6;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[6];
        return;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    }
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    if (paramInt == 2)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        return;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      if (!TextUtils.isEmpty(paramArrayOfString[2]))
      {
        MQQName localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 2;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
      }
    }
    else if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[2]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 2;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[2];
        return;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    }
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    MQQName localMQQName;
    if (paramInt == 2)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 4;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
      else
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.jdField_a_of_type_Int = 3;
          localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        }
      }
    }
    else
    {
      if (paramInt == 1)
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 0;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        return;
      }
      if (paramInt == 3)
      {
        localMQQName = new MQQName();
        localMQQName.jdField_a_of_type_Int = 7;
        localMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        paramMQQProfileName.jdField_a_of_type_JavaUtilList.add(localMQQName);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
          paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
          return;
        }
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      }
    }
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      if (!TextUtils.isEmpty(paramArrayOfString[5]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 5;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[5];
        return;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    }
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 3;
        paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[3];
        return;
      }
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
    }
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int = 0;
      paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
      paramMQQProfileName.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator
 * JD-Core Version:    0.7.0.1
 */