package com.tencent.thumbplayer.core.connection;

import java.util.HashMap;

public class TPNativePlayerConnectionNode
{
  private HashMap<Integer, HashMap<Integer, Long>> mLongMap = null;
  
  public boolean addAction(int paramInt)
  {
    if (this.mLongMap.containsKey(Integer.valueOf(paramInt))) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    this.mLongMap.put(Integer.valueOf(paramInt), localHashMap);
    return true;
  }
  
  public void removeAction(int paramInt)
  {
    if (this.mLongMap.containsKey(Integer.valueOf(paramInt))) {
      this.mLongMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public boolean setLongActionConfig(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.mLongMap.containsKey(Integer.valueOf(paramInt1))) {
      return false;
    }
    ((HashMap)this.mLongMap.get(Integer.valueOf(paramInt1))).put(Integer.valueOf(paramInt2), Long.valueOf(paramLong));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */