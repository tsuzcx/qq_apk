package com.tencent.mobileqq.wink.pick.album.data;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class WinkPhotoCommonDataCreator
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
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    AEQLog.d("WinkPhotoCommonDataCreator", "createCommonDataByReflection--reflection failed, use singleton instead");
    return PhotoCommonBaseData.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.data.WinkPhotoCommonDataCreator
 * JD-Core Version:    0.7.0.1
 */