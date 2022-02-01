package org.light.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.SizeF;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.light.bean.ViewPointData;
import org.light.device.FileOfflineUtil;

public class ViewPointUtil
{
  private static final String TAG = "ViewPointUtil";
  private static Context appContext;
  private static CameraCharacteristics characteristics;
  private static CameraManager manager;
  
  @RequiresApi(api=21)
  public static float[] getPhoneCameraInfo()
  {
    try
    {
      if (appContext == null) {
        appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      }
      if (manager == null) {
        manager = (CameraManager)appContext.getSystemService("camera");
      }
      Object localObject = String.valueOf(1);
      if (characteristics == null) {
        characteristics = manager.getCameraCharacteristics((String)localObject);
      }
      float[] arrayOfFloat = (float[])characteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
      SizeF localSizeF = (SizeF)characteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
      float f1 = localSizeF.getWidth() / 2.0F;
      float f2 = localSizeF.getHeight() / 2.0F;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Camera ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" sensorInfo: ");
      localStringBuilder.append(f1 * 2.0F);
      localStringBuilder.append(", ");
      localStringBuilder.append(2.0F * f2);
      LightLogUtil.d("ViewPointUtil", localStringBuilder.toString());
      if ((arrayOfFloat != null) && (arrayOfFloat.length != 0))
      {
        if (localSizeF == null) {
          return null;
        }
        float f3 = arrayOfFloat[0];
        f1 = (float)(Math.atan(f1 / f3) * 2.0D);
        f2 = (float)(Math.atan(f2 / f3) * 2.0D);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" HFOV: ");
        ((StringBuilder)localObject).append(Math.toDegrees(f1));
        LightLogUtil.d("ViewPointUtil", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" WFOV: ");
        ((StringBuilder)localObject).append(Math.toDegrees(f2));
        LightLogUtil.d("ViewPointUtil", ((StringBuilder)localObject).toString());
        localObject = (Size)characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        f3 = ((Size)localObject).getHeight();
        float f4 = ((Size)localObject).getWidth();
        return new float[] { f2, f1, f3, f4 };
      }
      return null;
    }
    catch (Exception localException)
    {
      LightLogUtil.e(localException);
    }
    return null;
  }
  
  public static float getPhoneHeightPixels()
  {
    try
    {
      if (appContext == null) {
        appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      }
      int i = appContext.getResources().getDisplayMetrics().heightPixels;
      return i;
    }
    catch (Exception localException)
    {
      LightLogUtil.e(localException);
    }
    return 1920.0F;
  }
  
  public static float[] getPhoneInfoFromJson()
  {
    try
    {
      if (appContext == null) {
        appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      }
      String str = FileOfflineUtil.readStringFromAssets(appContext, "phone_info.json");
      if (str == null) {
        return null;
      }
      Object localObject2 = GsonUtils.json2ObjList(str, ViewPointData.class);
      str = Build.MODEL.toLowerCase();
      Object localObject1 = new float[6];
      localObject2 = ((List)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ViewPointData localViewPointData = (ViewPointData)((Iterator)localObject2).next();
        if (localViewPointData.model.contains(str))
        {
          localObject1[0] = localViewPointData.ppi;
          localObject1[1] = localViewPointData.pixel_x;
          localObject1[2] = localViewPointData.pixel_y;
          localObject1[3] = localViewPointData.cam_x;
          localObject1[4] = localViewPointData.cam_y;
          localObject1[5] = localViewPointData.camera_position;
          i = 1;
        }
      }
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPhoneInfoFromJson -> model: ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" contains model from json data");
        LightLogUtil.i("ViewPointUtil", ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPhoneInfoFromJson -> model: ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" does not contain model from json data");
      LightLogUtil.i("ViewPointUtil", ((StringBuilder)localObject1).toString());
      return null;
    }
    catch (Exception localException)
    {
      LightLogUtil.e(localException);
    }
    return null;
  }
  
  public static float getPhonePPILevel()
  {
    try
    {
      if (appContext == null) {
        appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      }
      int i = appContext.getResources().getDisplayMetrics().densityDpi;
      return i;
    }
    catch (Exception localException)
    {
      LightLogUtil.e(localException);
    }
    return 160.0F;
  }
  
  public static float getPhoneWidthPixels()
  {
    try
    {
      if (appContext == null) {
        appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      }
      int i = appContext.getResources().getDisplayMetrics().widthPixels;
      return i;
    }
    catch (Exception localException)
    {
      LightLogUtil.e(localException);
    }
    return 1080.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.utils.ViewPointUtil
 * JD-Core Version:    0.7.0.1
 */