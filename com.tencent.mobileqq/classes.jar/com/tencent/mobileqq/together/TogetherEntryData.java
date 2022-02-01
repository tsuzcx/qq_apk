package com.tencent.mobileqq.together;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class TogetherEntryData
{
  static int jdField_a_of_type_Int = 2131699330;
  static int[] jdField_a_of_type_ArrayOfInt = { 1001, 1003, 1002, 1005, 1004 };
  static int[] b;
  static int[] c;
  static int[] d;
  static int[] e;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public int e;
  public int f = 0;
  
  static
  {
    jdField_b_of_type_ArrayOfInt = new int[] { -8293377, -35897, -42646, -3243777, -16725252 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131693688, 2131719433, 2131720632, 2131699311, 2131699313 };
    jdField_d_of_type_ArrayOfInt = new int[] { 2130846483, 2130846485, 2130846486, 2130844962, 2130846484 };
    jdField_e_of_type_ArrayOfInt = new int[] { 2131699310, 2131699326, 2131699344, 2131699312, 2131699314 };
  }
  
  public TogetherEntryData()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static Drawable a(Context paramContext, TogetherEntryData paramTogetherEntryData)
  {
    switch (paramTogetherEntryData.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 1001: 
      return paramContext.getResources().getDrawable(2130846483);
    case 1004: 
      return paramContext.getResources().getDrawable(2130846484);
    case 1003: 
      return paramContext.getResources().getDrawable(2130846485);
    case 1002: 
      return paramContext.getResources().getDrawable(2130846486);
    }
    return paramContext.getResources().getDrawable(2130844962);
  }
  
  public static ArrayList<TogetherEntryData> a()
  {
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    while (i < 4)
    {
      TogetherEntryData localTogetherEntryData = new TogetherEntryData();
      localTogetherEntryData.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localTogetherEntryData.jdField_c_of_type_Int = i;
      localTogetherEntryData.jdField_d_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localTogetherEntryData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(jdField_c_of_type_ArrayOfInt[i]);
      localTogetherEntryData.jdField_e_of_type_Int = jdField_d_of_type_ArrayOfInt[i];
      localTogetherEntryData.jdField_b_of_type_JavaLangString = HardCodeUtil.a(jdField_e_of_type_ArrayOfInt[i]);
      localArrayList.add(localTogetherEntryData);
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.f + HardCodeUtil.a(jdField_a_of_type_Int);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(@Nullable TogetherEntryData paramTogetherEntryData)
  {
    if (paramTogetherEntryData == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramTogetherEntryData.jdField_a_of_type_Boolean;
    this.f = paramTogetherEntryData.f;
    this.jdField_a_of_type_JavaUtilArrayList = paramTogetherEntryData.jdField_a_of_type_JavaUtilArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherEntryData
 * JD-Core Version:    0.7.0.1
 */