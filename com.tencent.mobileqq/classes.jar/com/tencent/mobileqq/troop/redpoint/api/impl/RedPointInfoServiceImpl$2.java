package com.tencent.mobileqq.troop.redpoint.api.impl;

import com.tencent.mobileqq.troop.redpoint.RedPointInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class RedPointInfoServiceImpl$2
  implements Runnable
{
  RedPointInfoServiceImpl$2(RedPointInfoServiceImpl paramRedPointInfoServiceImpl, HashMap paramHashMap, String paramString1, String paramString2, RedPointInfo paramRedPointInfo) {}
  
  public void run()
  {
    RedPointInfoServiceImpl.2.1 local1 = new RedPointInfoServiceImpl.2.1(this);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      local1.add((Integer)((Map.Entry)localIterator.next()).getKey());
    }
    RedPointInfoServiceImpl.access$000(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqTroopRedpointRedPointInfo, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.api.impl.RedPointInfoServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */