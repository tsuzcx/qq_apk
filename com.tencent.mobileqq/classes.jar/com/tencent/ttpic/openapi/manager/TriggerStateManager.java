package com.tencent.ttpic.openapi.manager;

import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.TriggerStateItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum TriggerStateManager
{
  INSTANCE;
  
  private static final String TAG = TriggerStateManager.class.getSimpleName();
  private static PTDetectInfo mDetectInfo;
  private Map<Integer, TriggerStateItem> mTriggerStateItemMap = new HashMap();
  
  private TriggerStateManager() {}
  
  public static TriggerStateManager getInstance()
  {
    return INSTANCE;
  }
  
  public void clear()
  {
    Object localObject = this.mTriggerStateItemMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerStateItem)((Iterator)localObject).next()).clear();
      }
      this.mTriggerStateItemMap.clear();
    }
  }
  
  public PTDetectInfo getPTDetectInfo()
  {
    return mDetectInfo;
  }
  
  public TriggerStateItem getTriggerStateItem(int paramInt)
  {
    Map localMap = this.mTriggerStateItemMap;
    if ((localMap != null) && (localMap.containsKey(Integer.valueOf(paramInt)))) {
      return (TriggerStateItem)this.mTriggerStateItemMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public Map<Integer, TriggerStateItem> getTriggerStateItemMap()
  {
    return this.mTriggerStateItemMap;
  }
  
  public void putTriggerStateItem(int paramInt, TriggerStateItem paramTriggerStateItem)
  {
    Map localMap = this.mTriggerStateItemMap;
    if (localMap != null) {
      localMap.put(Integer.valueOf(paramInt), paramTriggerStateItem);
    }
  }
  
  public void reset()
  {
    Object localObject = this.mTriggerStateItemMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerStateItem)((Iterator)localObject).next()).reset();
      }
    }
  }
  
  public void setPTDetectInfo(PTDetectInfo paramPTDetectInfo)
  {
    mDetectInfo = paramPTDetectInfo;
  }
  
  public void updateAllTriggerState()
  {
    Object localObject = this.mTriggerStateItemMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerStateItem)((Iterator)localObject).next()).updateState();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.TriggerStateManager
 * JD-Core Version:    0.7.0.1
 */