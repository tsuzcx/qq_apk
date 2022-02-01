package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.api.INearPeopleFilters;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class NearPeopleFilters
  implements INearPeopleFilters
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c;
  private int a;
  public String a;
  public boolean a;
  private int b;
  public String b;
  private int c;
  public String c;
  private int jdField_d_of_type_Int = 0;
  public String d;
  private String[] jdField_d_of_type_ArrayOfJavaLangString = { "0", "0", "0", "0" };
  private int e = 0;
  private int f = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131707440), "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131707448), HardCodeUtil.a(2131707435), HardCodeUtil.a(2131707444), HardCodeUtil.a(2131707446), HardCodeUtil.a(2131707451), HardCodeUtil.a(2131707437), HardCodeUtil.a(2131707455), HardCodeUtil.a(2131707439) };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131707452), HardCodeUtil.a(2131707457), HardCodeUtil.a(2131707454), HardCodeUtil.a(2131707441), HardCodeUtil.a(2131707442), HardCodeUtil.a(2131707447), HardCodeUtil.a(2131707456), HardCodeUtil.a(2131707445), HardCodeUtil.a(2131707438), HardCodeUtil.a(2131707443), HardCodeUtil.a(2131707453), HardCodeUtil.a(2131707436), HardCodeUtil.a(2131707450) };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 2130845736, 2130845732, 2130845731, 2130845737, 2130845734, 2130845735, 2130845733 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
  }
  
  public NearPeopleFilters()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "不限";
    this.jdField_b_of_type_JavaLangString = "不限";
    this.jdField_c_of_type_JavaLangString = "不限";
    this.jdField_d_of_type_JavaLangString = "不限";
  }
  
  public static NearPeopleFilters a(String paramString)
  {
    return a(paramString, "nearpeople_filters");
  }
  
  public static NearPeopleFilters a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    paramString1 = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4);
    if (paramString1 != null)
    {
      paramString2 = new NearPeopleFilters();
      paramString2.a(paramString1.getInt("gender", -1));
      if (paramString2.a() == -1) {
        return null;
      }
      paramString2.jdField_a_of_type_Boolean = paramString1.getBoolean("byuser", false);
      paramString2.c(paramString1.getInt("age", 0));
      paramString2.d(paramString1.getInt("interest", 0));
      paramString2.b(paramString1.getInt("time", 3));
      paramString2.e(paramString1.getInt("xingzuo", 0));
      paramString2.f(paramString1.getInt("key_career", 0));
      paramString2.a()[0] = paramString1.getString("key_hometown_country", "0");
      paramString2.a()[1] = paramString1.getString("key_hometown_province", "0");
      paramString2.a()[2] = paramString1.getString("key_hometown_city", "0");
      paramString2.jdField_a_of_type_JavaLangString = paramString1.getString("key_hometown_string", "不限");
      paramString2.jdField_b_of_type_JavaLangString = paramString1.getString("str_country", "不限");
      paramString2.jdField_c_of_type_JavaLangString = paramString1.getString("str_province", "不限");
      paramString2.jdField_d_of_type_JavaLangString = paramString1.getString("str_city", "不限");
      if ("-1".equals(paramString2.a()[0])) {
        paramString2.a()[0] = "0";
      }
      if ("-1".equals(paramString2.a()[1])) {
        paramString2.a()[1] = "0";
      }
      if ("-1".equals(paramString2.a()[2])) {
        paramString2.a()[2] = "0";
      }
      return paramString2;
    }
    return null;
  }
  
  public static void a(String paramString, NearPeopleFilters paramNearPeopleFilters)
  {
    a(paramString, paramNearPeopleFilters, "nearpeople_filters");
  }
  
  public static void a(String paramString1, NearPeopleFilters paramNearPeopleFilters, String paramString2)
  {
    if (paramNearPeopleFilters != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      paramString1 = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4);
      if (paramString1 != null) {
        paramString1.edit().putBoolean("byuser", paramNearPeopleFilters.jdField_a_of_type_Boolean).putInt("gender", paramNearPeopleFilters.a()).putInt("time", paramNearPeopleFilters.b()).putInt("age", paramNearPeopleFilters.c()).putInt("xingzuo", paramNearPeopleFilters.e()).putInt("key_career", paramNearPeopleFilters.f()).putString("key_hometown_country", paramNearPeopleFilters.a()[0]).putString("key_hometown_province", paramNearPeopleFilters.a()[1]).putString("key_hometown_city", paramNearPeopleFilters.a()[2]).putString("key_hometown_string", paramNearPeopleFilters.jdField_a_of_type_JavaLangString).putString("str_country", paramNearPeopleFilters.jdField_b_of_type_JavaLangString).putString("str_province", paramNearPeopleFilters.jdField_c_of_type_JavaLangString).putString("str_city", paramNearPeopleFilters.jdField_d_of_type_JavaLangString).putInt("interest", paramNearPeopleFilters.d()).commit();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String[] a()
  {
    return this.jdField_d_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    int i = 0;
    boolean bool2;
    if ((paramObject != null) && ((paramObject instanceof NearPeopleFilters)))
    {
      paramObject = (NearPeopleFilters)paramObject;
      boolean bool1;
      if ((a() == paramObject.a()) && ((b() == paramObject.b()) || (((b() == 4) || (b() == 3)) && ((paramObject.b() == 4) || (paramObject.b() == 3)))) && (c() == paramObject.c()) && (e() == paramObject.e()) && (f() == paramObject.f()) && (d() == paramObject.d())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1) {
        for (;;)
        {
          bool2 = bool1;
          if (i >= 3) {
            break;
          }
          bool1 &= a()[i].equalsIgnoreCase(paramObject.a()[i]);
          if (!bool1) {
            return bool1;
          }
          i += 1;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public void f(int paramInt)
  {
    this.f = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    int i = a();
    if (i != 0) {
      if (i != 1)
      {
        if (i == 2) {
          localStringBuilder.append("女,");
        }
      }
      else {
        localStringBuilder.append("男,");
      }
    }
    if (c() != 0)
    {
      i = c();
      localObject = jdField_a_of_type_ArrayOfJavaLangString;
      if (i < localObject.length)
      {
        localStringBuilder.append(localObject[c()]);
        localStringBuilder.append(',');
      }
    }
    if (d() != 0)
    {
      i = d();
      localObject = jdField_b_of_type_ArrayOfJavaLangString;
      if (i < localObject.length)
      {
        localStringBuilder.append(localObject[d()]);
        localStringBuilder.append(',');
      }
    }
    if ((f() != 0) && (f() < NearbyProfileUtil.e.length))
    {
      String str = NearbyProfileUtil.e[f()];
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = HardCodeUtil.a(2131707449);
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(',');
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals("不限")))
    {
      i = this.jdField_a_of_type_JavaLangString.lastIndexOf("-");
      if (i > 0) {
        localObject = this.jdField_a_of_type_JavaLangString.substring(i + 1);
      } else {
        localObject = this.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(',');
    }
    if (e() != 0)
    {
      i = e();
      localObject = jdField_c_of_type_ArrayOfJavaLangString;
      if (i < localObject.length)
      {
        localStringBuilder.append(localObject[e()]);
        localStringBuilder.append(',');
      }
    }
    i = b();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i == 4)) {
            localStringBuilder.append("8小时内,");
          }
        }
        else {
          localStringBuilder.append("4小时内,");
        }
      }
      else {
        localStringBuilder.append("1个小时内,");
      }
    }
    else {
      localStringBuilder.append("30分钟内,");
    }
    Object localObject = localStringBuilder.toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = localStringBuilder.lastIndexOf(",");
      if (i > 0) {
        return ((String)localObject).substring(0, i);
      }
    }
    localStringBuilder.append("全部");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearPeopleFilters
 * JD-Core Version:    0.7.0.1
 */