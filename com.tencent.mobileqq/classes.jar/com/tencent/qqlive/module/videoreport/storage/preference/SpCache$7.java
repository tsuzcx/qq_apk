package com.tencent.qqlive.module.videoreport.storage.preference;

import android.util.Pair;
import java.util.List;
import java.util.concurrent.Callable;

class SpCache$7
  implements Callable<List<Pair<String, T>>>
{
  SpCache$7(SpCache paramSpCache, Class paramClass) {}
  
  public List<Pair<String, T>> a()
  {
    return SpCache.access$000(this.b).getAllObjects(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.preference.SpCache.7
 * JD-Core Version:    0.7.0.1
 */