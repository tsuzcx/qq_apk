package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class SchoolInfo
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public int h;
  public int i;
  public int j;
  public boolean k = false;
  public boolean l = false;
  
  private String b()
  {
    switch (this.g)
    {
    default: 
      return "";
    case 9: 
      return HardCodeUtil.a(2131911036);
    case 8: 
      return HardCodeUtil.a(2131911038);
    case 7: 
      return HardCodeUtil.a(2131911034);
    case 6: 
      return HardCodeUtil.a(2131911033);
    case 5: 
      return HardCodeUtil.a(2131911035);
    }
    return HardCodeUtil.a(2131911037);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (this.b == 3)
    {
      if (this.h > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.h);
        ((StringBuilder)localObject).append("级");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(this.f))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("   ");
        }
        localStringBuilder.append(this.f);
      }
      if (this.g > 0)
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
    else if (this.h > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append("级");
      localStringBuilder.append(((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uint32_idx:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" uint32_category:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" str_school_id:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" str_school_name:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" str_department_id:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" str_department_name:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" uint32_degree:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" uint32_enrollment_year:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" uint32_graduation_year:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" uint32_allow_recommend:");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */