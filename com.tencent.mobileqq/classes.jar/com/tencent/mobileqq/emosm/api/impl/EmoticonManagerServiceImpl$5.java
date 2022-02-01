package com.tencent.mobileqq.emosm.api.impl;

import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;

class EmoticonManagerServiceImpl$5
  implements QueryTask.Query<Pair<String, Integer>, EmoticonPackage>
{
  EmoticonManagerServiceImpl$5(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl) {}
  
  public EmoticonPackage a(Pair<String, Integer> paramPair)
  {
    return this.a.syncFindEmoticonPackageById((String)paramPair.first, ((Integer)paramPair.second).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */