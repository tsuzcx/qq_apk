package com.tencent.mtt.hippy.modules.nativemodules;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import java.util.HashMap;

public class HippyNativeModuleBase
{
  protected final HippyEngineContext mContext;
  private HashMap<String, Integer> mEventMaps;
  
  public HippyNativeModuleBase(HippyEngineContext paramHippyEngineContext)
  {
    this.mContext = paramHippyEngineContext;
  }
  
  @HippyMethod(name="addListener")
  public void addListener(String paramString)
  {
    if (this.mEventMaps == null) {
      this.mEventMaps = new HashMap();
    }
    int i = 0;
    if (this.mEventMaps.containsKey(paramString)) {
      i = ((Integer)this.mEventMaps.get(paramString)).intValue();
    }
    i += 1;
    if (i == 1) {
      handleAddListener(paramString);
    }
    this.mEventMaps.remove(paramString);
    this.mEventMaps.put(paramString, Integer.valueOf(i));
  }
  
  public void destroy() {}
  
  public void handleAddListener(String paramString) {}
  
  public void handleRemoveListener(String paramString) {}
  
  public void initialize() {}
  
  @HippyMethod(name="removeListener")
  public void removeListener(String paramString)
  {
    HashMap localHashMap = this.mEventMaps;
    if (localHashMap != null)
    {
      if (!localHashMap.containsKey(paramString)) {
        return;
      }
      int i = ((Integer)this.mEventMaps.get(paramString)).intValue();
      if (i == 1)
      {
        handleRemoveListener(paramString);
        this.mEventMaps.remove(paramString);
        return;
      }
      this.mEventMaps.remove(paramString);
      this.mEventMaps.put(paramString, Integer.valueOf(i - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
 * JD-Core Version:    0.7.0.1
 */