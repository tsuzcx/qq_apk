package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QQTheme
{
  public static final int a;
  public static final ColorFilter a;
  public static String a = "";
  public static List<String> a;
  public static final String[] a;
  
  static
  {
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
    paramString = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_theme");
    return paramString.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static String a()
  {
    if (BaseApplication.getContext() == null) {
      return "1000";
    }
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("theme", 4);
    Object localObject2 = null;
    Object localObject3 = ((SharedPreferences)localObject1).getString("theme_root", null);
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      return "1000";
    }
    localObject1 = localObject3;
    if (((String)localObject3).endsWith(File.separator)) {
      localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
    }
    if (((String)localObject1).contains("theme_810"))
    {
      localObject3 = ((String)localObject1).split(File.separator);
      localObject1 = localObject2;
      if (localObject3.length >= 3) {
        localObject1 = localObject3[(localObject3.length - 3)];
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return localObject1;
      }
    }
    else
    {
      localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("_");
        if (localObject1.length == 2) {
          return localObject1[0];
        }
      }
    }
    return "1000";
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
  
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (a())
      {
        paramDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        return;
      }
      paramDrawable.clearColorFilter();
    }
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
    double d1 = Color.red(paramInt);
    Double.isNaN(d1);
    double d2 = Color.green(paramInt);
    Double.isNaN(d2);
    double d3 = Color.blue(paramInt);
    Double.isNaN(d3);
    return 1.0D - (d1 * 0.299D + d2 * 0.587D + d3 * 0.114D) / 255.0D >= 0.5D;
  }
  
  public static boolean a(String paramString)
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString = a(paramString);
    } else {
      paramString = a();
    }
    return a(paramString);
  }
  
  public static boolean b()
  {
    String str = a();
    return ("1000".equals(str)) || ("999".equals(str));
  }
  
  public static boolean b(String paramString)
  {
    return ("3064".equals(paramString)) || ("2971".equals(paramString)) || ("2921".equals(paramString));
  }
  
  public static boolean c()
  {
    return ("1103".equals(jdField_a_of_type_JavaLangString)) || ("2920".equals(jdField_a_of_type_JavaLangString));
  }
  
  public static final boolean c(String paramString)
  {
    return ("2920".equals(paramString)) || (d(paramString));
  }
  
  public static boolean d()
  {
    return a();
  }
  
  public static boolean d(String paramString)
  {
    boolean bool2 = "2920".equals(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (("2971".equals(paramString)) || ("2921".equals(paramString)) || ("3064".equals(paramString)) || ("3063".equals(paramString)) || ("3066".equals(paramString)) || ("3065".equals(paramString)) || ("3067".equals(paramString)) || ("3491".equals(paramString)) || (jdField_a_of_type_JavaUtilList.contains(paramString))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean e()
  {
    return "1000".equals(a());
  }
  
  public static final boolean f()
  {
    return c(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQTheme
 * JD-Core Version:    0.7.0.1
 */