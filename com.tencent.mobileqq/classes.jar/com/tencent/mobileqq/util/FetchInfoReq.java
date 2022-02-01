package com.tencent.mobileqq.util;

import android.os.Bundle;

public class FetchInfoReq
{
  public int a;
  public long a;
  public Bundle a;
  public Object a;
  public String a;
  public String b;
  
  public FetchInfoReq() {}
  
  public FetchInfoReq(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i >= 1)
    {
      if (i > 4) {
        return false;
      }
      Object localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null)
      {
        if ("".equals(((String)localObject).trim())) {
          return false;
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          localObject = this.b;
          if ((localObject == null) || ("".equals(localObject)))
          {
            localObject = this.jdField_a_of_type_JavaLangObject;
            if ((localObject == null) || ("".equals(localObject))) {
              return false;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof FetchInfoReq;
    boolean bool1 = true;
    if (bool2)
    {
      paramObject = (FetchInfoReq)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (Utils.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)))
      {
        if (3 != this.jdField_a_of_type_Int) {
          return bool1;
        }
        if ((Utils.a(this.b, paramObject.b)) && (Utils.a(this.jdField_a_of_type_JavaLangObject, paramObject.jdField_a_of_type_JavaLangObject)) && (Utils.a(this.jdField_a_of_type_AndroidOsBundle, paramObject.jdField_a_of_type_AndroidOsBundle))) {
          return true;
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public int hashCode()
  {
    int n = this.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = this.b;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = this.jdField_a_of_type_JavaLangObject;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = localObject.hashCode();
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return n + i + j + k + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[iType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", strKey = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", strSubKey = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", obj = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangObject);
    localStringBuilder.append(", extraUpdateTargetParams = ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidOsBundle);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchInfoReq
 * JD-Core Version:    0.7.0.1
 */