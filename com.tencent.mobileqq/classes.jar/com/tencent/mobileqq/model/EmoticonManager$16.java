package com.tencent.mobileqq.model;

import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;

class EmoticonManager$16
  implements QueryTask.Query<Pair<String, Integer>, EmoticonPackage>
{
  EmoticonManager$16(EmoticonManager paramEmoticonManager) {}
  
  public EmoticonPackage a(Pair<String, Integer> paramPair)
  {
    return this.a.c((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.16
 * JD-Core Version:    0.7.0.1
 */