package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class SchoolInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  
  public SchoolInfo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private String b()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return "";
    case 9: 
      return HardCodeUtil.a(2131713485);
    case 8: 
      return HardCodeUtil.a(2131713487);
    case 7: 
      return HardCodeUtil.a(2131713483);
    case 6: 
      return HardCodeUtil.a(2131713482);
    case 5: 
      return HardCodeUtil.a(2131713484);
    }
    return HardCodeUtil.a(2131713486);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (this.jdField_b_of_type_Int == 3)
    {
      if (this.jdField_d_of_type_Int > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
        ((StringBuilder)localObject).append("级");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("   ");
        }
        localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_c_of_type_Int > 0)
      {
        localObject = b();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("   ");
          }
          localStringBuilder.append((String)localObject);
        }
      }
    }
    else if (this.jdField_d_of_type_Int > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject).append("级");
      localStringBuilder.append(((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uint32_idx:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" uint32_category:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" str_school_id:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" str_school_name:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" str_department_id:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" str_department_name:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" uint32_degree:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" uint32_enrollment_year:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" uint32_graduation_year:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" uint32_allow_recommend:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */