package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.NearbyProfileUtil;

public class NearPeopleFilters
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c;
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String[] d;
  public int e;
  public int f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "18-22岁", "23-26岁", "27-35岁", "35岁以上" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "爱旅游", "爱美食", "爱时尚", "爱运动", "爱电影", "爱音乐", "爱游戏" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 2130842923, 2130842919, 2130842918, 2130842924, 2130842921, 2130842922, 2130842920 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
  }
  
  public NearPeopleFilters()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
    this.jdField_d_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0", "0" };
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
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return null;
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
      } while (paramString1 == null);
      paramString2 = new NearPeopleFilters();
      paramString2.jdField_a_of_type_Int = paramString1.getInt("gender", -1);
    } while (paramString2.jdField_a_of_type_Int == -1);
    paramString2.jdField_a_of_type_Boolean = paramString1.getBoolean("byuser", false);
    paramString2.jdField_c_of_type_Int = paramString1.getInt("age", 0);
    paramString2.jdField_d_of_type_Int = paramString1.getInt("interest", 0);
    paramString2.jdField_b_of_type_Int = paramString1.getInt("time", 3);
    paramString2.e = paramString1.getInt("xingzuo", 0);
    paramString2.f = paramString1.getInt("key_career", 0);
    paramString2.jdField_d_of_type_ArrayOfJavaLangString[0] = paramString1.getString("key_hometown_country", "0");
    paramString2.jdField_d_of_type_ArrayOfJavaLangString[1] = paramString1.getString("key_hometown_province", "0");
    paramString2.jdField_d_of_type_ArrayOfJavaLangString[2] = paramString1.getString("key_hometown_city", "0");
    paramString2.jdField_a_of_type_JavaLangString = paramString1.getString("key_hometown_string", "不限");
    paramString2.jdField_b_of_type_JavaLangString = paramString1.getString("str_country", "不限");
    paramString2.jdField_c_of_type_JavaLangString = paramString1.getString("str_province", "不限");
    paramString2.jdField_d_of_type_JavaLangString = paramString1.getString("str_city", "不限");
    if ("-1".equals(paramString2.jdField_d_of_type_ArrayOfJavaLangString[0])) {
      paramString2.jdField_d_of_type_ArrayOfJavaLangString[0] = "0";
    }
    if ("-1".equals(paramString2.jdField_d_of_type_ArrayOfJavaLangString[1])) {
      paramString2.jdField_d_of_type_ArrayOfJavaLangString[1] = "0";
    }
    if ("-1".equals(paramString2.jdField_d_of_type_ArrayOfJavaLangString[2])) {
      paramString2.jdField_d_of_type_ArrayOfJavaLangString[2] = "0";
    }
    return paramString2;
  }
  
  public static void a(String paramString, NearPeopleFilters paramNearPeopleFilters)
  {
    a(paramString, paramNearPeopleFilters, "nearpeople_filters");
  }
  
  public static void a(String paramString1, NearPeopleFilters paramNearPeopleFilters, String paramString2)
  {
    if ((paramNearPeopleFilters == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString2 + paramString1, 4);
    } while (paramString1 == null);
    paramString1.edit().putBoolean("byuser", paramNearPeopleFilters.jdField_a_of_type_Boolean).putInt("gender", paramNearPeopleFilters.jdField_a_of_type_Int).putInt("time", paramNearPeopleFilters.jdField_b_of_type_Int).putInt("age", paramNearPeopleFilters.jdField_c_of_type_Int).putInt("xingzuo", paramNearPeopleFilters.e).putInt("key_career", paramNearPeopleFilters.f).putString("key_hometown_country", paramNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[0]).putString("key_hometown_province", paramNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[1]).putString("key_hometown_city", paramNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[2]).putString("key_hometown_string", paramNearPeopleFilters.jdField_a_of_type_JavaLangString).putString("str_country", paramNearPeopleFilters.jdField_b_of_type_JavaLangString).putString("str_province", paramNearPeopleFilters.jdField_c_of_type_JavaLangString).putString("str_city", paramNearPeopleFilters.jdField_d_of_type_JavaLangString).putInt("interest", paramNearPeopleFilters.jdField_d_of_type_Int).commit();
  }
  
  public boolean equals(Object paramObject)
  {
    int i = 0;
    boolean bool1;
    if ((paramObject == null) || (!(paramObject instanceof NearPeopleFilters)))
    {
      bool1 = false;
      return bool1;
    }
    paramObject = (NearPeopleFilters)paramObject;
    if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && ((this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) || (((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 3)) && ((paramObject.jdField_b_of_type_Int == 4) || (paramObject.jdField_b_of_type_Int == 3)))) && (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.jdField_d_of_type_Int == paramObject.jdField_d_of_type_Int)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2) {
        break;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i >= 3) {
          break;
        }
        bool2 &= this.jdField_d_of_type_ArrayOfJavaLangString[i].equalsIgnoreCase(paramObject.jdField_d_of_type_ArrayOfJavaLangString[i]);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("筛选：");
    String str1;
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int < jdField_a_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]).append(',');
      }
      if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int < jdField_b_of_type_ArrayOfJavaLangString.length)) {
        localStringBuilder.append(jdField_b_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]).append(',');
      }
      if ((this.f != 0) && (this.f < NearbyProfileUtil.e.length))
      {
        String str2 = NearbyProfileUtil.e[this.f];
        str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "其他";
        }
        localStringBuilder.append(str1).append(',');
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals("不限")))
      {
        i = this.jdField_a_of_type_JavaLangString.lastIndexOf("-");
        if (i > 0)
        {
          str1 = this.jdField_a_of_type_JavaLangString.substring(i + 1);
          label220:
          localStringBuilder.append(str1).append(',');
        }
      }
      else
      {
        if ((this.e != 0) && (this.e < jdField_c_of_type_ArrayOfJavaLangString.length)) {
          localStringBuilder.append(jdField_c_of_type_ArrayOfJavaLangString[this.e]).append(',');
        }
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      break;
    }
    for (;;)
    {
      str1 = localStringBuilder.toString();
      if (TextUtils.isEmpty(str1)) {
        break label419;
      }
      i = localStringBuilder.lastIndexOf(",");
      if (i <= 0) {
        break label419;
      }
      return str1.substring(0, i);
      localStringBuilder.append("男,");
      break;
      localStringBuilder.append("女,");
      break;
      str1 = this.jdField_a_of_type_JavaLangString;
      break label220;
      localStringBuilder.append("30分钟内,");
      continue;
      localStringBuilder.append("1个小时内,");
      continue;
      localStringBuilder.append("4小时内,");
      continue;
      localStringBuilder.append("8小时内,");
    }
    label419:
    return "全部";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearPeopleFilters
 * JD-Core Version:    0.7.0.1
 */