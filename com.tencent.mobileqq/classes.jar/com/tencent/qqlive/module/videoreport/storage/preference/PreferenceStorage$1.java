package com.tencent.qqlive.module.videoreport.storage.preference;

import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.List;

class PreferenceStorage$1
  implements Condition<T>
{
  PreferenceStorage$1(PreferenceStorage paramPreferenceStorage, List paramList) {}
  
  public boolean satisfy(T paramT)
  {
    paramT = PreferenceStorage.access$000(this.b).getObjectId(paramT);
    return this.a.contains(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.preference.PreferenceStorage.1
 * JD-Core Version:    0.7.0.1
 */