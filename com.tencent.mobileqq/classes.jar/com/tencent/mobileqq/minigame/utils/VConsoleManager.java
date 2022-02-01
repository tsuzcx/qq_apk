package com.tencent.mobileqq.minigame.utils;

import java.util.HashMap;

public class VConsoleManager
{
  private static final String TAG = "VConsoleManager";
  private static VConsoleManager instance;
  private HashMap<Integer, VConsoleLogManager> vConsoleLogManagerMap = new HashMap();
  
  public static VConsoleManager getInstance()
  {
    if (instance == null) {
      instance = new VConsoleManager();
    }
    return instance;
  }
  
  public VConsoleLogManager getLogManager(int paramInt)
  {
    HashMap localHashMap = this.vConsoleLogManagerMap;
    if ((localHashMap != null) && (localHashMap.size() != 0)) {
      return (VConsoleLogManager)this.vConsoleLogManagerMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public void registerLogManager(int paramInt, VConsoleLogManager paramVConsoleLogManager)
  {
    if (this.vConsoleLogManagerMap == null) {
      this.vConsoleLogManagerMap = new HashMap();
    }
    this.vConsoleLogManagerMap.put(Integer.valueOf(paramInt), paramVConsoleLogManager);
  }
  
  public void unRegisterLogManager(int paramInt)
  {
    HashMap localHashMap = this.vConsoleLogManagerMap;
    if (localHashMap == null) {
      return;
    }
    localHashMap.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.VConsoleManager
 * JD-Core Version:    0.7.0.1
 */