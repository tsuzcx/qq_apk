package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QQTheme
{
  public static final int a;
  public static final ColorFilter a;
  public static String a;
  public static List<String> a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "999", "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067" };
    jdField_a_of_type_Int = Color.parseColor("#4d000000");
    jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static SharedPreferences a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "noLogin";
    }
    return BaseApplication.getContext().getSharedPreferences(str + "_theme", 4);
  }
  
  public static String a()
  {
    Object localObject2;
    if (BaseApplication.getContext() == null) {
      localObject2 = "1000";
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = BaseApplication.getContext().getSharedPreferences("theme", 4).getString("theme_root", null);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return "1000";
      }
      localObject1 = localObject2;
      if (((String)localObject2).endsWith(File.separator)) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
      if (!((String)localObject1).contains("theme_810")) {
        break label110;
      }
      localObject1 = ((String)localObject1).split(File.separator);
      if (localObject1.length < 3) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 3)];
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    label110:
    do
    {
      do
      {
        return "1000";
        localObject1 = null;
        break;
        localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject1 = ((String)localObject1).split("_");
    } while (localObject1.length != 2);
    return localObject1[0];
  }
  
  public static String a(String paramString)
  {
    String str = a(paramString).getString("currentThemeId_6.3.5", null);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "1000";
    }
    return paramString;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    String str = a();
    return ("1103".equals(str)) || ("2920".equals(str));
  }
  
  public static boolean a(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.5D;
  }
  
  public static boolean a(String paramString)
  {
    return ("3064".equals(paramString)) || ("2971".equals(paramString)) || ("2921".equals(paramString));
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    String[] arrayOfString;
    int j;
    int i;
    if (paramBoolean)
    {
      paramString = a(paramString);
      arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      if (paramString.equals(arrayOfString[i]))
      {
        return false;
        paramString = a();
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  public static boolean b()
  {
    String str = a();
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static final boolean b(String paramString)
  {
    return ("2920".equals(paramString)) || (c(paramString));
  }
  
  public static boolean c()
  {
    return ("1103".equals(jdField_a_of_type_JavaLangString)) || ("2920".equals(jdField_a_of_type_JavaLangString));
  }
  
  public static boolean c(String paramString)
  {
    if ("2920".equals(paramString)) {}
    while ((!"2971".equals(paramString)) && (!"2921".equals(paramString)) && (!"3064".equals(paramString)) && (!"3063".equals(paramString)) && (!"3066".equals(paramString)) && (!"3065".equals(paramString)) && (!"3067".equals(paramString)) && (!"3491".equals(paramString)) && (!jdField_a_of_type_JavaUtilList.contains(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean d()
  {
    return "1000".equals(a());
  }
  
  public static final boolean e()
  {
    return b(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQTheme
 * JD-Core Version:    0.7.0.1
 */