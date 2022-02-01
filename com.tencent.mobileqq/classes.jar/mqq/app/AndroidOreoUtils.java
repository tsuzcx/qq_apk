package mqq.app;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AndroidOreoUtils
{
  private Activity mActivity;
  private ActivityInfo mActivityInfo = null;
  
  public AndroidOreoUtils(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public boolean fixOrientation()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mActivityInfo");
      localField.setAccessible(true);
      ActivityInfo localActivityInfo = (ActivityInfo)localField.get(this.mActivity);
      if (isFixedOrientation(localActivityInfo, localActivityInfo.screenOrientation)) {
        localActivityInfo.screenOrientation = -1;
      }
      localField.setAccessible(false);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public ActivityInfo getCurrentActivityInfo()
  {
    if (this.mActivityInfo == null) {}
    try
    {
      Field localField = Activity.class.getDeclaredField("mActivityInfo");
      localField.setAccessible(true);
      this.mActivityInfo = ((ActivityInfo)localField.get(this.mActivity));
      localField.setAccessible(false);
      return this.mActivityInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean isFixedOrientation(ActivityInfo paramActivityInfo, int paramInt)
  {
    try
    {
      Method localMethod = ActivityInfo.class.getMethod("isFixedOrientation", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      bool = ((Boolean)localMethod.invoke(paramActivityInfo, new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      paramActivityInfo.printStackTrace();
    }
    catch (Exception paramActivityInfo)
    {
      try
      {
        localMethod.setAccessible(false);
        return bool;
      }
      catch (Exception paramActivityInfo)
      {
        boolean bool;
        break label60;
      }
      paramActivityInfo = paramActivityInfo;
      bool = false;
    }
    label60:
    return bool;
  }
  
  public boolean isTranslucentOrFloating()
  {
    try
    {
      Object localObject = (int[])Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
      localObject = this.mActivity.obtainStyledAttributes((int[])localObject);
      Method localMethod = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      localMethod.setAccessible(true);
      bool = ((Boolean)localMethod.invoke(null, new Object[] { localObject })).booleanValue();
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod.setAccessible(false);
        return bool;
      }
      catch (Exception localException2)
      {
        boolean bool;
        break label82;
      }
      localException1 = localException1;
      bool = false;
    }
    label82:
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AndroidOreoUtils
 * JD-Core Version:    0.7.0.1
 */