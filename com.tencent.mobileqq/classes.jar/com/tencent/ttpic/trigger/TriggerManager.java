package com.tencent.ttpic.trigger;

import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.manager.TriggerStateManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TriggerManager
{
  private static final String TAG = "TriggerManager";
  private List<AETriggerI> triggers = new ArrayList();
  private List<HashMap<String, ? extends AETriggerI>> triggersMaps = new ArrayList();
  private List<HashMap<Integer, ? extends AETriggerI>> triggersMvMaps = new ArrayList();
  
  public void addTriggers(AETriggerI paramAETriggerI)
  {
    this.triggers.add(paramAETriggerI);
  }
  
  public void addTriggersMap(HashMap<String, ? extends AETriggerI> paramHashMap)
  {
    this.triggersMaps.add(paramHashMap);
  }
  
  public void addTriggersMvMap(HashMap<Integer, ? extends AETriggerI> paramHashMap)
  {
    this.triggersMvMaps.add(paramHashMap);
  }
  
  public List<AETriggerI> getTriggers()
  {
    return this.triggers;
  }
  
  public List<HashMap<String, ? extends AETriggerI>> getTriggersMaps()
  {
    return this.triggersMaps;
  }
  
  public void reset()
  {
    TriggerStateManager.getInstance().reset();
    Iterator localIterator1 = this.triggers.iterator();
    while (localIterator1.hasNext()) {
      ((AETriggerI)localIterator1.next()).reset();
    }
    localIterator1 = this.triggersMaps.iterator();
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext()) {
        ((AETriggerI)localIterator2.next()).reset();
      }
    }
    localIterator1 = this.triggersMvMaps.iterator();
    while (localIterator1.hasNext())
    {
      localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext()) {
        ((AETriggerI)localIterator2.next()).reset();
      }
    }
  }
  
  public void setIsRenderForBitmap(boolean paramBoolean)
  {
    Iterator localIterator = this.triggers.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (AETriggerI)localIterator.next();
      if ((localObject instanceof TriggerCtrlItem)) {
        ((TriggerCtrlItem)localObject).setRenderForBitmap(paramBoolean);
      }
    }
    localIterator = this.triggersMaps.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((HashMap)localIterator.next()).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerCtrlItem)((Iterator)localObject).next()).setRenderForBitmap(paramBoolean);
      }
    }
    localIterator = this.triggersMvMaps.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((HashMap)localIterator.next()).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerCtrlItem)((Iterator)localObject).next()).setRenderForBitmap(paramBoolean);
      }
    }
  }
  
  public void setTriggerWords(String paramString)
  {
    Iterator localIterator = this.triggers.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (AETriggerI)localIterator.next();
      if ((localObject instanceof TriggerCtrlItem)) {
        ((TriggerCtrlItem)localObject).setTriggerWords(paramString);
      }
    }
    localIterator = this.triggersMaps.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((HashMap)localIterator.next()).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerCtrlItem)((Iterator)localObject).next()).setTriggerWords(paramString);
      }
    }
    localIterator = this.triggersMvMaps.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((HashMap)localIterator.next()).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TriggerCtrlItem)((Iterator)localObject).next()).setTriggerWords(paramString);
      }
    }
  }
  
  public void updateTriggerStatus(PTDetectInfo paramPTDetectInfo)
  {
    if (TriggerStateManager.getInstance() != null)
    {
      TriggerStateManager.getInstance().setPTDetectInfo(paramPTDetectInfo);
      TriggerStateManager.getInstance().updateAllTriggerState();
    }
    Iterator localIterator1 = this.triggers.iterator();
    while (localIterator1.hasNext()) {
      ((AETriggerI)localIterator1.next()).updateTriggerStatus(paramPTDetectInfo);
    }
    localIterator1 = this.triggersMaps.iterator();
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext()) {
        ((AETriggerI)localIterator2.next()).updateTriggerStatus(paramPTDetectInfo);
      }
    }
    localIterator1 = this.triggersMvMaps.iterator();
    while (localIterator1.hasNext())
    {
      localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
      while (localIterator2.hasNext()) {
        ((AETriggerI)localIterator2.next()).updateTriggerStatus(paramPTDetectInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.TriggerManager
 * JD-Core Version:    0.7.0.1
 */