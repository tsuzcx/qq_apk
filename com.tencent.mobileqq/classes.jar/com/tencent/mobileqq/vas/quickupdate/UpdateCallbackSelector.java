package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.comic.quickupdate.QQComicUpdateBusiness;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.vas.FontUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.JarReflectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@Keep
public class UpdateCallbackSelector
{
  private static final String TAG = "UpdateCallbackSelector";
  private static BaseUpdateCallback defaultCallback = new EmptyCallback();
  @ConfigInject(configPath="Business/vas-temp-api/src/main/resources/Inject_VasQuickUpdateBusiness.yml", version=3)
  public static ArrayList<Class<? extends BaseUpdateCallback>> mInjectBusinessCallback = new ArrayList();
  private static HashMap<Long, BaseUpdateCallback> sBusinessRegister;
  
  static
  {
    mInjectBusinessCallback.add(ThemeUpdateCallback.class);
    mInjectBusinessCallback.add(RingUpdateCallback.class);
    mInjectBusinessCallback.add(PobingUpdateCallback.class);
    mInjectBusinessCallback.add(MusicPlayerCallback.class);
    mInjectBusinessCallback.add(MusicThemeCallback.class);
    mInjectBusinessCallback.add(QQLevelIconCallback.class);
    mInjectBusinessCallback.add(VipIconCallback.class);
    mInjectBusinessCallback.add(FontUpdateBusiness.class);
    mInjectBusinessCallback.add(QQComicUpdateBusiness.class);
    sBusinessRegister = new HashMap();
    initBaseUpdateCallback();
  }
  
  public static void cleanCache(Context paramContext)
  {
    Iterator localIterator = sBusinessRegister.values().iterator();
    while (localIterator.hasNext()) {
      ((BaseUpdateCallback)localIterator.next()).cleanCache(paramContext);
    }
  }
  
  public static void clearCallback()
  {
    sBusinessRegister.clear();
  }
  
  public static BaseUpdateCallback getCallback(long paramLong)
  {
    BaseUpdateCallback localBaseUpdateCallback2 = (BaseUpdateCallback)sBusinessRegister.get(Long.valueOf(paramLong));
    BaseUpdateCallback localBaseUpdateCallback1 = localBaseUpdateCallback2;
    if (localBaseUpdateCallback2 == null) {
      localBaseUpdateCallback1 = defaultCallback;
    }
    return localBaseUpdateCallback1;
  }
  
  private static BaseUpdateCallback[] getInjectArray()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getInjectArray size = ");
    ((StringBuilder)localObject1).append(mInjectBusinessCallback.size());
    QLog.i("UpdateCallbackSelector", 1, ((StringBuilder)localObject1).toString());
    if (mInjectBusinessCallback.isEmpty()) {
      return new BaseUpdateCallback[] { ThemeUpdateCallback.sInstance, RingUpdateCallback.sInstance, PobingUpdateCallback.sInstance, MusicPlayerCallback.sInstance, MusicThemeCallback.sInstance, QQLevelIconCallback.sInstance, VipIconCallback.sInstance };
    }
    localObject1 = new ArrayList();
    Iterator localIterator = mInjectBusinessCallback.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (localClass != null)
      {
        Object localObject2 = JarReflectUtil.getStaticField(localClass.getName(), "sInstance");
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("inject class name = ");
            localStringBuilder.append(localClass.getName());
            QLog.i("UpdateCallbackSelector", 2, localStringBuilder.toString());
          }
          ((ArrayList)localObject1).add((BaseUpdateCallback)localObject2);
        }
        else
        {
          QLog.e("UpdateCallbackSelector", 1, "current inject clsss get static field fail ， object = null");
        }
      }
    }
    return (BaseUpdateCallback[])((ArrayList)localObject1).toArray(new BaseUpdateCallback[((ArrayList)localObject1).size()]);
  }
  
  private static void initBaseUpdateCallback()
  {
    BaseUpdateCallback[] arrayOfBaseUpdateCallback = getInjectArray();
    Object localObject;
    if (arrayOfBaseUpdateCallback != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getInjectArray size = ");
      ((StringBuilder)localObject).append(arrayOfBaseUpdateCallback.length);
      QLog.i("UpdateCallbackSelector", 1, ((StringBuilder)localObject).toString());
    }
    int j = arrayOfBaseUpdateCallback.length;
    int i = 0;
    while (i < j)
    {
      localObject = arrayOfBaseUpdateCallback[i];
      if (localObject != null)
      {
        if (sBusinessRegister.containsKey(Long.valueOf(((BaseUpdateCallback)localObject).getBID()))) {
          sBusinessRegister.get(Long.valueOf(((BaseUpdateCallback)localObject).getBID()));
        }
        sBusinessRegister.put(Long.valueOf(((BaseUpdateCallback)localObject).getBID()), localObject);
      }
      i += 1;
    }
  }
  
  public static void setDefaultCallback(BaseUpdateCallback paramBaseUpdateCallback)
  {
    try
    {
      defaultCallback = paramBaseUpdateCallback;
      return;
    }
    finally
    {
      paramBaseUpdateCallback = finally;
      throw paramBaseUpdateCallback;
    }
  }
  
  public static void unsetDefaultCallback(BaseUpdateCallback paramBaseUpdateCallback)
  {
    try
    {
      if (defaultCallback == paramBaseUpdateCallback) {
        defaultCallback = new EmptyCallback();
      }
      return;
    }
    finally
    {
      paramBaseUpdateCallback = finally;
      throw paramBaseUpdateCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector
 * JD-Core Version:    0.7.0.1
 */