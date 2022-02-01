package com.tencent.ttpic.openapi.plugin;

import com.tencent.aekit.plugin.core.AEDetectorType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AICtrl
{
  private Map<String, Integer> aiModuleFreq = new HashMap();
  private Map<String, Boolean> aiModuleSwitch = new HashMap();
  
  public void clearModule()
  {
    this.aiModuleSwitch.clear();
  }
  
  public int getModuleFreq(String paramString)
  {
    if (this.aiModuleFreq.get(paramString) != null) {
      return ((Integer)this.aiModuleFreq.get(paramString)).intValue();
    }
    return 1;
  }
  
  public boolean hasModuleOn()
  {
    Iterator localIterator = this.aiModuleSwitch.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((Boolean)((Map.Entry)localIterator.next()).getValue()).booleanValue()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isModuleOn(String paramString)
  {
    if (this.aiModuleSwitch.get(paramString) != null) {
      return ((Boolean)this.aiModuleSwitch.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public void setModuleFreq(String paramString, int paramInt)
  {
    this.aiModuleFreq.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void switchModule(AEDetectorType paramAEDetectorType, boolean paramBoolean)
  {
    this.aiModuleSwitch.put(paramAEDetectorType.value, Boolean.valueOf(paramBoolean));
  }
  
  public void switchModule(String paramString, boolean paramBoolean)
  {
    this.aiModuleSwitch.put(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.plugin.AICtrl
 * JD-Core Version:    0.7.0.1
 */