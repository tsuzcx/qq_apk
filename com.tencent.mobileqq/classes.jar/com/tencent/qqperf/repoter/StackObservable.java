package com.tencent.qqperf.repoter;

import java.util.HashMap;
import java.util.Observable;

public class StackObservable
  extends Observable
{
  private static StackObservable b;
  public HashMap<String, String> a;
  
  public static StackObservable a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new StackObservable();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("key_type", "t_held_thread");
    this.a = paramHashMap;
    setChanged();
    notifyObservers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.StackObservable
 * JD-Core Version:    0.7.0.1
 */