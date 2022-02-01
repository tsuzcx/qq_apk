package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ConditionChecker<K, V>
{
  private Map a = new LinkedHashMap();
  
  public void a(V paramV, ConditionChecker.ConditionCallback paramConditionCallback)
  {
    this.a.put(paramConditionCallback, paramV);
  }
  
  public boolean a(K paramK, ConditionChecker.OnPassCallback paramOnPassCallback)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      ConditionChecker.ConditionCallback localConditionCallback = (ConditionChecker.ConditionCallback)localIterator.next();
      if ((localConditionCallback != null) && (!localConditionCallback.a(paramK)))
      {
        if ((paramOnPassCallback != null) && (this.a.get(localConditionCallback) != null)) {
          paramOnPassCallback.a(this.a.get(localConditionCallback));
        }
        return false;
      }
    }
    if (paramOnPassCallback != null) {
      paramOnPassCallback.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.ConditionChecker
 * JD-Core Version:    0.7.0.1
 */