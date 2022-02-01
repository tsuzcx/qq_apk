package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;
import java.util.List;

class EmoticonManagerServiceImpl$11
  implements QueryTask.Query<Integer, List<EmoticonPackage>>
{
  EmoticonManagerServiceImpl$11(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl) {}
  
  public List<EmoticonPackage> a(Integer paramInteger)
  {
    return this.a.syncGetTabEmoticonPackages(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.11
 * JD-Core Version:    0.7.0.1
 */