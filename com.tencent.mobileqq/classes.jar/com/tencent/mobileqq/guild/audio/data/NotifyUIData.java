package com.tencent.mobileqq.guild.audio.data;

import java.util.HashMap;
import java.util.Map;

public class NotifyUIData
{
  private Map<Integer, Object> a = new HashMap();
  
  public Object a(int paramInt)
  {
    return this.a.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.a.put(Integer.valueOf(paramInt), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.NotifyUIData
 * JD-Core Version:    0.7.0.1
 */