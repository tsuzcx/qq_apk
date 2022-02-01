package dov.com.qq.im.ae.album.data;

import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import dov.com.qq.im.ae.util.AEQLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AEPhotoCommonDataCreator
{
  public static PhotoCommonBaseData a()
  {
    try
    {
      Object localObject = PhotoCommonBaseData.class.getDeclaredConstructor(null);
      ((Constructor)localObject).setAccessible(true);
      localObject = (PhotoCommonBaseData)((Constructor)localObject).newInstance(null);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      AEQLog.d("AEPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
      return PhotoCommonBaseData.getInstance();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.data.AEPhotoCommonDataCreator
 * JD-Core Version:    0.7.0.1
 */