package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import androidx.annotation.Keep;
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
    QLog.i("UpdateCallbackSelector", 1, "getInjectArray size = " + mInjectBusinessCallback.size());
    if (mInjectBusinessCallback.isEmpty()) {
      return new BaseUpdateCallback[] { ThemeUpdateCallback.sInstance, RingUpdateCallback.sInstance, PobingUpdateCallback.sInstance, MusicPlayerCallback.sInstance, MusicThemeCallback.sInstance, QQLevelIconCallback.sInstance, VipIconCallback.sInstance };
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = mInjectBusinessCallback.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (localClass != null)
      {
        Object localObject = JarReflectUtil.getStaticField(localClass.getName(), "sInstance");
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("UpdateCallbackSelector", 2, "inject class name = " + localClass.getName());
          }
          localArrayList.add((BaseUpdateCallback)localObject);
        }
        else
        {
          QLog.e("UpdateCallbackSelector", 1, "current inject clsss get static field fail ， object = null");
        }
      }
    }
    return (BaseUpdateCallback[])localArrayList.toArray(new BaseUpdateCallback[localArrayList.size()]);
  }
  
  private static void initBaseUpdateCallback()
  {
    BaseUpdateCallback[] arrayOfBaseUpdateCallback = getInjectArray();
    if (arrayOfBaseUpdateCallback != null) {
      QLog.i("UpdateCallbackSelector", 1, "getInjectArray size = " + arrayOfBaseUpdateCallback.length);
    }
    int j = arrayOfBaseUpdateCallback.length;
    int i = 0;
    if (i < j)
    {
      BaseUpdateCallback localBaseUpdateCallback = arrayOfBaseUpdateCallback[i];
      if (localBaseUpdateCallback == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((sBusinessRegister.containsKey(Long.valueOf(localBaseUpdateCallback.getBID()))) && (sBusinessRegister.get(Long.valueOf(localBaseUpdateCallback.getBID())) != null)) {}
        sBusinessRegister.put(Long.valueOf(localBaseUpdateCallback.getBID()), localBaseUpdateCallback);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector
 * JD-Core Version:    0.7.0.1
 */