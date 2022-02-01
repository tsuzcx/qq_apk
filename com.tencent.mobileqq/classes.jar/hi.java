import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

public class hi
{
  private static Method a;
  private static Method b;
  
  static {}
  
  public static int a(List<Integer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Integer)paramList.next()).intValue() == 17) {
        return 17;
      }
    }
    return -1;
  }
  
  public static Camera.Size a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    if (paramList == null) {
      return null;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      if ((((Camera.Size)localObject2).width == paramInt1) && (((Camera.Size)localObject2).height == paramInt2)) {
        return localObject2;
      }
    }
    double d3 = paramInt1 / paramInt2;
    localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    double d2;
    if (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (((paramInt1 > paramInt2) && (((Camera.Size)localObject2).width > ((Camera.Size)localObject2).height)) || ((paramInt1 < paramInt2) && (((Camera.Size)localObject2).width < ((Camera.Size)localObject2).height)))
      {
        d2 = ((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height;
        label152:
        if (Math.abs(d2 - d3) > 0.05D) {
          break label218;
        }
        if (Math.abs(((Camera.Size)localObject2).height - paramInt2) >= d1) {
          break label307;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt2);
        localObject1 = localObject2;
      }
    }
    label301:
    label307:
    for (;;)
    {
      break;
      d2 = ((Camera.Size)localObject2).height / ((Camera.Size)localObject2).width;
      break label152;
      label218:
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        d1 = 1.7976931348623157E+308D;
        localIterator = paramList.iterator();
        localObject2 = localObject1;
        if (localIterator.hasNext())
        {
          paramList = (Camera.Size)localIterator.next();
          if (Math.abs(paramList.height - paramInt2) >= d1) {
            break label301;
          }
          d1 = Math.abs(paramList.height - paramInt2);
        }
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        return localObject2;
        paramList = (List<Camera.Size>)localObject1;
      }
    }
  }
  
  private static void a()
  {
    try
    {
      b = Camera.Parameters.class.getMethod("getSupportedPreviewSizes", (Class[])null);
      try
      {
        label14:
        a = Camera.Parameters.class.getMethod("getSupportedPreviewFormats", (Class[])null);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      break label14;
    }
  }
  
  public static void a(Camera.Parameters paramParameters)
  {
    String str = null;
    try
    {
      List localList = paramParameters.getSupportedFocusModes();
      if ((localList.contains("continuous-video")) && (aoxi.a().b)) {
        str = "continuous-video";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraParameters", 2, String.format("setDefaultFocusMode focusMode=%s", new Object[] { str }));
        }
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramParameters.setFocusMode(str);
        return;
        if (localList.contains("auto")) {
          str = "auto";
        }
      }
      return;
    }
    catch (RuntimeException paramParameters)
    {
      paramParameters.printStackTrace();
    }
  }
  
  private static void a(Camera.Parameters paramParameters, int paramInt)
  {
    try
    {
      paramInt = Math.max(paramInt, 0);
      if (paramParameters.isZoomSupported()) {
        paramParameters.setZoom(Math.min(paramInt, paramParameters.getMaxZoom()));
      }
      return;
    }
    catch (Exception paramParameters) {}
  }
  
  public static void a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    a(paramCamera, paramInt1, paramInt2, 2);
  }
  
  public static void a(Camera paramCamera, int paramInt1, int paramInt2, int paramInt3)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if (b != null) {}
    try
    {
      Object localObject1 = b.invoke(localParameters, (Object[])null);
      List localList;
      Object localObject3;
      if ((localObject1 instanceof List))
      {
        localList = (List)localObject1;
        localObject1 = new ArrayList();
        localObject3 = localList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Camera.Size localSize2 = (Camera.Size)((Iterator)localObject3).next();
          if (((localSize2.width != 980) || (localSize2.height != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((localSize2.width == 1184) && (localSize2.height == 666)) || (((localSize2.width != 704) || (localSize2.height != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL))) && ((localSize2.width != 800) || (localSize2.height != 450) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9100".equalsIgnoreCase(Build.MODEL)))))) {
            ((List)localObject1).add(localSize2);
          }
        }
      }
      Object localObject2;
      Camera.Size localSize1;
      label515:
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      localIllegalArgumentException1.printStackTrace();
      for (;;)
      {
        if (a == null) {
          break label515;
        }
        try
        {
          localObject2 = (List)a.invoke(localParameters, (Object[])null);
          if (localObject2 != null)
          {
            paramInt1 = a((List)localObject2);
            if (paramInt1 != -1) {
              localParameters.setPreviewFormat(paramInt1);
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          for (;;)
          {
            localIllegalArgumentException2.printStackTrace();
          }
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          for (;;)
          {
            localIllegalAccessException2.printStackTrace();
          }
        }
        catch (InvocationTargetException localInvocationTargetException2)
        {
          for (;;)
          {
            localInvocationTargetException2.printStackTrace();
          }
        }
        try
        {
          a(localParameters, paramInt3);
          a(localParameters);
          paramCamera.setParameters(localParameters);
          return;
        }
        catch (RuntimeException paramCamera)
        {
          paramCamera.printStackTrace();
          return;
        }
        localObject3 = localParameters.getPreviewSize();
        if ((!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9008L".equalsIgnoreCase(Build.MODEL))) {
          break;
        }
        localObject2 = localObject3;
        if ((localObject2 != null) && ((((Camera.Size)localObject2).height != ((Camera.Size)localObject3).height) || (((Camera.Size)localObject2).width != ((Camera.Size)localObject3).width))) {
          localParameters.setPreviewSize(((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height);
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      for (;;)
      {
        localIllegalAccessException1.printStackTrace();
        continue;
        if ((paramInt1 != 0) && (paramInt2 != 0))
        {
          localSize1 = a(localList, paramInt1, paramInt2);
          if (localSize1 != null) {
            break;
          }
          localSize1 = a(localList, 640, 480);
        }
        else
        {
          localSize1 = a(localSize1, 1280, 720);
        }
      }
    }
    catch (InvocationTargetException localInvocationTargetException1)
    {
      for (;;)
      {
        localInvocationTargetException1.printStackTrace();
        continue;
        if (localParameters.getPreviewFormat() != 17) {
          localParameters.setPreviewFormat(17);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     hi
 * JD-Core Version:    0.7.0.1
 */