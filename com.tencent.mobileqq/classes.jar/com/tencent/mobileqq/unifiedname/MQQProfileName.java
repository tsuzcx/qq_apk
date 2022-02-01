package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MQQProfileName
{
  public final MQQName a;
  public final List<MQQName> a;
  
  public MQQProfileName()
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName = new MQQName();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public Object clone()
  {
    MQQProfileName localMQQProfileName = new MQQProfileName();
    localMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.a(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      MQQName localMQQName = (MQQName)this.jdField_a_of_type_JavaUtilList.get(i);
      localMQQProfileName.jdField_a_of_type_JavaUtilList.add((MQQName)localMQQName.clone());
      i += 1;
    }
    return localMQQProfileName;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof MQQProfileName;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (MQQProfileName)paramObject;
      bool1 = bool2;
      if (Utils.a(paramObject.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName, this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName))
      {
        List localList = this.jdField_a_of_type_JavaUtilList;
        int i;
        if (localList == null) {
          i = 0;
        } else {
          i = localList.size();
        }
        localList = paramObject.jdField_a_of_type_JavaUtilList;
        int j;
        if (localList == null) {
          j = 0;
        } else {
          j = localList.size();
        }
        bool1 = bool2;
        if (i == j)
        {
          bool1 = true;
          j = 0;
          while ((bool1) && (j < i))
          {
            if (!Utils.a((MQQName)this.jdField_a_of_type_JavaUtilList.get(j), (MQQName)paramObject.jdField_a_of_type_JavaUtilList.get(j))) {
              bool1 = false;
            }
            j += 1;
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(String.format("[head] type=%s value=%s\n", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int), Utils.a(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString) }));
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        MQQName localMQQName = (MQQName)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localMQQName != null) {
          localStringBuilder.append(String.format("[more item] type=%s value=%s\n", new Object[] { Integer.valueOf(localMQQName.jdField_a_of_type_Int), Utils.a(localMQQName.jdField_a_of_type_JavaLangString) }));
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      QLog.e("MQQProfileName", 1, "toString fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQProfileName
 * JD-Core Version:    0.7.0.1
 */