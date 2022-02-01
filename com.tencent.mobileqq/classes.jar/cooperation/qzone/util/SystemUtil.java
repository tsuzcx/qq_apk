package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class SystemUtil
{
  private static final String ISMIUI = "1";
  public static final int OPPO_NOTCH_HEIGHT = 80;
  public static final int SHARP_NOTCH_HEIGHT = 121;
  public static final String TAG = "[PhotoAlbum]" + SystemUtil.class.getSimpleName();
  public static final int VIVO_NOTCH_HEIGHT = dp2px(27);
  public static int notchHeight = -1;
  
  public static int dp2px(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    float f = paramInt;
    return (int)(localDisplayMetrics.density * f + 0.5F);
  }
  
  @NonNull
  public static Rect getDisplayCutoutSafeInsets(View paramView)
  {
    Rect localRect = new Rect();
    QZLog.d(TAG, 1, new Object[] { "Build.VERSION.SDK_INT:", Integer.valueOf(Build.VERSION.SDK_INT) });
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        paramView = JarReflectUtil.callSpecifiedMethod(paramView, "getRootWindowInsets", false, null, null);
        QZLog.d(TAG, 1, new Object[] { "insets:", paramView });
        Object localObject3 = JarReflectUtil.callSpecifiedMethod(paramView, "getDisplayCutout", false, null, null);
        if (localObject3 == null)
        {
          QZLog.d(TAG, 1, "displayCutout == null");
          return localRect;
        }
        paramView = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetTop", false, null, null);
        Object localObject1 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetBottom", false, null, null);
        Object localObject2 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetLeft", false, null, null);
        localObject3 = JarReflectUtil.callSpecifiedMethod(localObject3, "getSafeInsetRight", false, null, null);
        QZLog.d(TAG, 1, new Object[] { "safeInsetTop:", paramView, " safeInsetBottom:", localObject1, " safeInsetLeft:", localObject2, " safeInsetRight:", localObject3 });
        if ((localObject2 instanceof Integer)) {
          localRect.left = ((Integer)localObject2).intValue();
        }
        if ((localObject1 instanceof Integer)) {
          localRect.bottom = ((Integer)localObject1).intValue();
        }
        if ((localObject3 instanceof Integer)) {
          localRect.right = ((Integer)localObject3).intValue();
        }
        if ((paramView instanceof Integer))
        {
          localRect.top = ((Integer)paramView).intValue();
          return localRect;
        }
      }
      catch (Exception paramView)
      {
        QZLog.e(TAG, 1, paramView, new Object[0]);
      }
    }
    return localRect;
  }
  
  private static void getGoogleApi(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null)) {
      notchHeight = getDisplayCutoutSafeInsets(paramActivity.getWindow().getDecorView()).top;
    }
  }
  
  public static int getNotchHeight(Context paramContext, Activity paramActivity)
  {
    if (notchHeight != -1)
    {
      QZLog.d(TAG, 1, new Object[] { "has notchHeight:", Integer.valueOf(notchHeight) });
      return notchHeight;
    }
    QZLog.d(TAG, 1, new Object[] { "Build.MODEL:", Build.MODEL });
    if (hasNotchInVivo(paramContext)) {
      notchHeight = VIVO_NOTCH_HEIGHT;
    }
    for (;;)
    {
      return notchHeight;
      if (hasNotchInOppo(paramContext))
      {
        if (Build.VERSION.SDK_INT >= 28) {
          getGoogleApi(paramActivity);
        }
        if ((notchHeight == 0) || (notchHeight == -1)) {
          notchHeight = 80;
        }
      }
      else if (hasNotchInHuaWei(paramContext))
      {
        notchHeight = getNotchSizeInHuaWei(paramContext)[1];
      }
      else if ((hasNotchInXiaoMi(paramContext)) || (hasNotchInSmartisan(paramContext)) || (isSpecialDevices()))
      {
        notchHeight = getNotchSizeInStatusBar(paramContext);
      }
      else if (isSharpS2())
      {
        notchHeight = 121;
      }
      else if (isVivoSpecial())
      {
        notchHeight = getNotchSizeInStatusBar(paramContext) + dp2px(20);
      }
      else if (isSamsungSpecial())
      {
        notchHeight = getNotchSizeInStatusBar(paramContext) + dp2px(10);
      }
      else
      {
        getGoogleApi(paramActivity);
      }
    }
  }
  
  public static int[] getNotchSizeInHuaWei(Context paramContext)
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
      QZLog.e(TAG, "getNotchSize ClassNotFoundException");
      return arrayOfInt;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "getNotchSize NoSuchMethodException");
      return arrayOfInt;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "getNotchSize Exception");
      return arrayOfInt;
    }
    finally {}
    return arrayOfInt;
  }
  
  private static int getNotchSizeInStatusBar(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static String getReflectString(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class, String.class }).invoke(paramContext, new Object[] { new String(paramString1), new String(paramString2) });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return paramString2;
    }
    catch (IllegalArgumentException paramContext) {}
    return paramString2;
  }
  
  public static boolean hasNotchInHuaWei(Context paramContext)
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
      QZLog.e(TAG, "hasNotchInScreen ClassNotFoundException");
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "hasNotchInScreen NoSuchMethodException");
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      QZLog.e(TAG, "hasNotchInScreen Exception");
      return false;
    }
    finally {}
    return false;
  }
  
  public static boolean hasNotchInOppo(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static boolean hasNotchInSmartisan(Context paramContext)
  {
    try
    {
      paramContext = JarReflectUtil.callSpecifiedStaticMethod("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", false, XMPCoreUtil.getInstance().getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(1) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(TAG, 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  public static boolean hasNotchInVivo(Context paramContext)
  {
    try
    {
      paramContext = JarReflectUtil.callSpecifiedStaticMethod("android.util.FtFeature", "isFeatureSupport", false, XMPCoreUtil.getInstance().getParamsClass(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(32) });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      QZLog.e(TAG, 2, paramContext, new Object[0]);
    }
    return false;
  }
  
  public static boolean hasNotchInXiaoMi(Context paramContext)
  {
    paramContext = getReflectString(paramContext, "ro.miui.notch", "0");
    if (paramContext != null) {
      return paramContext.equals("1");
    }
    return false;
  }
  
  private static boolean isLenovo()
  {
    return Build.MODEL.endsWith("L78011");
  }
  
  private static boolean isOnePlus()
  {
    return "GM1910".equals(Build.MODEL);
  }
  
  private static boolean isSMF9000()
  {
    return "SM-F9000".equals(Build.MODEL);
  }
  
  private static boolean isSamsungSpecial()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.MODEL != null) {
      if (!Build.MODEL.equals("SM-G9750"))
      {
        bool1 = bool2;
        if (!Build.MODEL.equals("SM-G9810")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean isSharpS2()
  {
    return "FS8010".equals(Build.MODEL);
  }
  
  private static boolean isSpecialDevices()
  {
    return (isLenovo()) || (isOnePlus()) || (isSMF9000()) || ("Pixel 3 XL".equals(Build.MODEL)) || ("NX606J".equals(Build.MODEL));
  }
  
  private static boolean isVivoSpecial()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.MODEL != null) {
      if (!Build.MODEL.equals("V1938CT"))
      {
        bool1 = bool2;
        if (!Build.MODEL.equals("V2001A")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.SystemUtil
 * JD-Core Version:    0.7.0.1
 */