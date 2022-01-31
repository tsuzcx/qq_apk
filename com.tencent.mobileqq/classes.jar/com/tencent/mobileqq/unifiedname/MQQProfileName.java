package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class MQQProfileName
{
  public MQQName a;
  public List a;
  
  public MQQProfileName()
  {
    this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName = new MQQName();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a(MQQProfileName paramMQQProfileName)
  {
    int j;
    int i;
    label22:
    int k;
    if (paramMQQProfileName != null) {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        j = 0;
        if (paramMQQProfileName.jdField_a_of_type_JavaUtilList != null) {
          break label100;
        }
        i = 0;
        if (j != i) {
          break label144;
        }
        k = 0;
        i = 1;
        label32:
        if ((i == 0) || (k >= j)) {
          break label113;
        }
        if (Utils.a((MQQName)this.jdField_a_of_type_JavaUtilList.get(k), (MQQName)paramMQQProfileName.jdField_a_of_type_JavaUtilList.get(k))) {
          break label161;
        }
        i = 0;
      }
    }
    label144:
    label161:
    for (;;)
    {
      k += 1;
      break label32;
      j = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label100:
      i = paramMQQProfileName.jdField_a_of_type_JavaUtilList.size();
      break label22;
      label113:
      if (i != 0) {
        i = 0;
      }
      while (Utils.a(paramMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName, this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName)) {
        if (i == 0)
        {
          return 0;
          i = 3;
          continue;
          i = 3;
        }
        else
        {
          return 1;
        }
      }
      if (i == 0) {
        return 2;
      }
      return 3;
      return 3;
    }
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if ((paramObject instanceof MQQProfileName))
    {
      paramObject = (MQQProfileName)paramObject;
      bool1 = bool2;
      if (Utils.a(paramObject.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName, this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName)) {
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          if (paramObject.jdField_a_of_type_JavaUtilList != null) {
            break label134;
          }
          j = 0;
          label55:
          bool1 = bool2;
          if (i != j) {
            break label147;
          }
          bool1 = true;
          j = 0;
          label69:
          if ((!bool1) || (j >= i)) {
            break label147;
          }
          if (Utils.a((MQQName)this.jdField_a_of_type_JavaUtilList.get(j), (MQQName)paramObject.jdField_a_of_type_JavaUtilList.get(j))) {
            break label150;
          }
          bool1 = false;
        }
      }
    }
    label134:
    label147:
    label150:
    for (;;)
    {
      j += 1;
      break label69;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      j = paramObject.jdField_a_of_type_JavaUtilList.size();
      break label55;
      return bool1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[head]").append("type = ").append(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_Int).append(", value = ").append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString)).append("\r\n");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()))
    {
      int j = ((Integer)localObject).intValue();
      int i = 0;
      while (i < j)
      {
        localObject = (MQQName)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject != null) {
          localStringBuilder.append("[more item]").append("type = ").append(((MQQName)localObject).jdField_a_of_type_Int).append(", value = ").append(Utils.b(((MQQName)localObject).jdField_a_of_type_JavaLangString)).append("\r\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQProfileName
 * JD-Core Version:    0.7.0.1
 */