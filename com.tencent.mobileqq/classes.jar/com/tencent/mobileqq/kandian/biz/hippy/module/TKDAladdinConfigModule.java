package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@HippyNativeModule(name="TKDAladdinConfigModule")
public class TKDAladdinConfigModule
  extends HippyNativeModuleBase
{
  public TKDAladdinConfigModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getList")
  public <T> void getList(int paramInt, String paramString, Promise paramPromise)
  {
    Object localObject = Aladdin.getConfig(paramInt).getList(paramString);
    paramString = new HippyMap();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      HippyArray localHippyArray = new HippyArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHippyArray.pushString((String)((Iterator)localObject).next());
      }
      paramString.pushInt("retCode", 0);
      paramString.pushArray("array", localHippyArray);
    }
    else
    {
      paramString.pushInt("retCode", -1);
      paramString.pushString("array", null);
    }
    paramPromise.resolve(paramString);
  }
  
  @HippyMethod(name="getMap")
  public <T> void getMap(int paramInt, String paramString, Promise paramPromise)
  {
    Object localObject = Aladdin.getConfig(paramInt).getMap(paramString);
    paramString = new HippyMap();
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      HippyMap localHippyMap = new HippyMap();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localHippyMap.pushString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      paramString.pushInt("retCode", 0);
      paramString.pushMap("map", localHippyMap);
    }
    else
    {
      paramString.pushInt("retCode", -1);
      paramString.pushString("map", null);
    }
    paramPromise.resolve(paramString);
  }
  
  @HippyMethod(name="getString")
  public void getString(int paramInt, String paramString, Promise paramPromise)
  {
    paramString = Aladdin.getConfig(paramInt).getString(paramString, "");
    HippyMap localHippyMap = new HippyMap();
    if (!TextUtils.isEmpty(paramString))
    {
      localHippyMap.pushInt("retCode", 0);
      localHippyMap.pushString("value", paramString);
    }
    else
    {
      localHippyMap.pushInt("retCode", -1);
      localHippyMap.pushString("value", "");
    }
    paramPromise.resolve(localHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDAladdinConfigModule
 * JD-Core Version:    0.7.0.1
 */