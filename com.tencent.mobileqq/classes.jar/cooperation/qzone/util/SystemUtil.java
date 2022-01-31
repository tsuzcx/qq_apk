package cooperation.qzone.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.BaseApplication;

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
    return 0;
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */