package mqq.util;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AndroidOUIWrapperUtil
{
  public static void fixOrientation(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return;
    }
    try
    {
      Field localField = Activity.class.getDeclaredField("mActivityInfo");
      localField.setAccessible(true);
      ((ActivityInfo)localField.get(paramActivity)).screenOrientation = -1;
      localField.setAccessible(false);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static boolean isTranslucentOrFloating(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return false;
    }
    try
    {
      Object localObject = paramActivity.obtainStyledAttributes((int[])Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
      paramActivity = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      paramActivity.setAccessible(true);
      localObject = paramActivity.invoke(null, new Object[] { localObject });
      if ((localObject instanceof Boolean))
      {
        bool = ((Boolean)localObject).booleanValue();
        try
        {
          paramActivity.setAccessible(false);
          return bool;
        }
        catch (Exception paramActivity) {}
        paramActivity.printStackTrace();
        return bool;
      }
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.util.AndroidOUIWrapperUtil
 * JD-Core Version:    0.7.0.1
 */