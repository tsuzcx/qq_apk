package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJUGJsonUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@HippyNativeModule(name="TKDStatisticModule")
public class TKDSearchStatModule
  extends HippyNativeModuleBase
{
  private static final String EVENT_NAME = "eventName";
  private static final String TAG = "StatisticModule";
  
  public TKDSearchStatModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @NonNull
  HashMap<String, String> hippyMapToStringMap(@NonNull HippyMap paramHippyMap)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramHippyMap.keySet();
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject1).next();
        Object localObject2 = paramHippyMap.get((String)localObject3);
        if (localObject2 == null)
        {
          localHashMap.put(localObject3, "");
        }
        else if ((localObject2 instanceof String))
        {
          localHashMap.put(localObject3, (String)localObject2);
        }
        else
        {
          StringBuilder localStringBuilder;
          if ((localObject2 instanceof Number))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localObject2);
            localHashMap.put(localObject3, localStringBuilder.toString());
          }
          else if ((localObject2 instanceof Boolean))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((Boolean)localObject2).booleanValue());
            localStringBuilder.append("");
            localHashMap.put(localObject3, localStringBuilder.toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("hippyMapToStringMap meets invalid type!!!");
            ((StringBuilder)localObject3).append(localObject2.getClass());
            LogUtils.e("StatisticModule", ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    return localHashMap;
  }
  
  @HippyMethod(name="statBeaconCommonEvent")
  public void statBeaconCommonEvent(String paramString1, HippyMap paramHippyMap, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramHippyMap == null) {
        return;
      }
      paramHippyMap = hippyMapToStringMap(paramHippyMap);
      if (paramHippyMap.size() <= 0) {
        return;
      }
      if (paramBoolean)
      {
        TKDSearchStatManager.getInstance().statBeaconCommonEvent(paramString1, paramHippyMap, paramString2, false);
        return;
      }
      TKDSearchStatManager.getInstance().statBeaconCommonEvent(paramString1, paramHippyMap, paramString2, true);
    }
  }
  
  @HippyMethod(name="statBeaconEvent")
  public void statBeaconEvent(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    Object localObject = paramHippyMap.get("eventName");
    if (!(localObject instanceof String))
    {
      LogUtils.e("StatisticModule", "statBeaconEvent: invliad eventName!!!!");
      return;
    }
    paramHippyMap = hippyMapToStringMap(paramHippyMap);
    paramHippyMap.remove("eventName");
    if (paramHippyMap.size() <= 0) {
      return;
    }
    paramHippyMap.put("qua", RIJUGJsonUtils.c());
    paramHippyMap.put("qq", TKDAccountModule.getCurAccountInfo().qqNum);
    boolean bool1 = false;
    try
    {
      boolean bool2 = Boolean.parseBoolean((String)paramHippyMap.get("isRealTime"));
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    TKDSearchStatManager.getInstance().statWithBeacon((String)localObject, paramHippyMap, bool1);
  }
  
  @HippyMethod(name="userBehaviorStatistics")
  public void userBehaviorStatistics(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    TKDSearchStatManager.getInstance().userBehaviorStat(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDSearchStatModule
 * JD-Core Version:    0.7.0.1
 */