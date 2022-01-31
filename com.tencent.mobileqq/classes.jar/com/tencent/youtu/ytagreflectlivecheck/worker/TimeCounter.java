package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TimeCounter
{
  private static String TAG = "TimeCounter";
  private static HashMap<String, TimeCounter> allMap;
  private float average = 0.0F;
  private long beginTime = 0L;
  private int count = 0;
  private float last = 0.0F;
  private float max = 0.0F;
  private float min = 0.0F;
  private String name;
  private float sum = 0.0F;
  
  TimeCounter(String paramString)
  {
    this.name = paramString;
  }
  
  public static void clearIns()
  {
    allMap.clear();
    allMap = null;
  }
  
  private static long getCurrentTime()
  {
    return System.currentTimeMillis() * 1000L;
  }
  
  public static TimeCounter ins(String paramString)
  {
    if (allMap == null) {
      allMap = new HashMap();
    }
    if (allMap.get(paramString) == null) {
      allMap.put(paramString, new TimeCounter(paramString));
    }
    return (TimeCounter)allMap.get(paramString);
  }
  
  public static String printAll()
  {
    Iterator localIterator = allMap.keySet().iterator();
    String str2;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + "\n" + ((TimeCounter)allMap.get(str2)).print()) {
      str2 = (String)localIterator.next();
    }
    return str1;
  }
  
  public void begin()
  {
    this.beginTime = getCurrentTime();
  }
  
  public void end()
  {
    end(true);
  }
  
  public void end(boolean paramBoolean)
  {
    float f = (float)(getCurrentTime() - this.beginTime) / 1000.0F;
    this.sum += f;
    this.count += 1;
    this.average = (this.sum / this.count);
    if (this.count == 1)
    {
      this.min = f;
      this.max = f;
    }
    for (;;)
    {
      this.last = f;
      if (paramBoolean) {
        print();
      }
      return;
      if (f < this.min) {
        this.min = f;
      }
      if (f > this.max) {
        this.max = f;
      }
    }
  }
  
  public String print()
  {
    String str = this.name + " count:" + this.count + " avg:" + this.average + "ms max:" + this.max + "ms min:" + this.min + "ms last:" + this.last + "ms";
    Log.i(TAG, str);
    return str;
  }
  
  public void reset()
  {
    this.sum = 0.0F;
    this.average = 0.0F;
    this.min = 0.0F;
    this.max = 0.0F;
    this.last = 0.0F;
    this.beginTime = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.TimeCounter
 * JD-Core Version:    0.7.0.1
 */