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
    StringBuilder localStringBuilder;
    for (String str1 = ""; localIterator.hasNext(); str1 = localStringBuilder.toString())
    {
      String str2 = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append("\n");
      localStringBuilder.append(((TimeCounter)allMap.get(str2)).print());
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
    float f1 = (float)(getCurrentTime() - this.beginTime) / 1000.0F;
    this.sum += f1;
    this.count += 1;
    float f2 = this.sum;
    int i = this.count;
    this.average = (f2 / i);
    if (i == 1)
    {
      this.min = f1;
      this.max = f1;
    }
    else
    {
      if (f1 < this.min) {
        this.min = f1;
      }
      if (f1 > this.max) {
        this.max = f1;
      }
    }
    this.last = f1;
    if (paramBoolean) {
      print();
    }
  }
  
  public String print()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.name);
    ((StringBuilder)localObject).append(" count:");
    ((StringBuilder)localObject).append(this.count);
    ((StringBuilder)localObject).append(" avg:");
    ((StringBuilder)localObject).append(this.average);
    ((StringBuilder)localObject).append("ms max:");
    ((StringBuilder)localObject).append(this.max);
    ((StringBuilder)localObject).append("ms min:");
    ((StringBuilder)localObject).append(this.min);
    ((StringBuilder)localObject).append("ms last:");
    ((StringBuilder)localObject).append(this.last);
    ((StringBuilder)localObject).append("ms");
    localObject = ((StringBuilder)localObject).toString();
    Log.i(TAG, (String)localObject);
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.TimeCounter
 * JD-Core Version:    0.7.0.1
 */