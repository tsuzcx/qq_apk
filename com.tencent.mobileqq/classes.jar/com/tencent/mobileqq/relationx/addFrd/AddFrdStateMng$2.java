package com.tencent.mobileqq.relationx.addFrd;

import java.util.Comparator;
import java.util.Map.Entry;

class AddFrdStateMng$2
  implements Comparator<Map.Entry<String, Long>>
{
  AddFrdStateMng$2(AddFrdStateMng paramAddFrdStateMng) {}
  
  public int a(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return ((Long)paramEntry2.getValue()).compareTo((Long)paramEntry1.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng.2
 * JD-Core Version:    0.7.0.1
 */