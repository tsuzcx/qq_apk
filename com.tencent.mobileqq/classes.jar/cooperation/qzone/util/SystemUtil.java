package cooperation.qzone.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class SystemUtil
{
  public static final int a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = SystemUtil.class.getSimpleName();
    jdField_a_of_type_Int = a(27);
  }
  
  public static int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(localDisplayMetrics.density * f + 0.5F);
  }
  
  public static int a(Context paramContext)
  {
    if (b(paramContext)) {
      return jdField_a_of_type_Int;
    }
    if (a(paramContext)) {
      return 80;
    }
    if (c(paramContext)) {
      return a(paramContext)[1];
    }
    return 0;
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static int[] a(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "getNotchSize ClassNotFoundException");
      return arrayOfInt;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "getNotchSize NoSuchMethodException");
      return arrayOfInt;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "getNotchSize Exception");
      return arrayOfInt;
    }
    finally {}
    return arrayOfInt;
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = JarReflectUtil.a("android.util.FtFeature", "isFeatureSupport", false, XMPCoreUtil.a().a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(32) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(jdField_a_of_type_JavaLangString, 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "hasNotchInScreen ClassNotFoundException");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "hasNotchInScreen NoSuchMethodException");
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(jdField_a_of_type_JavaLangString, "hasNotchInScreen Exception");
      return false;
    }
    finally {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */