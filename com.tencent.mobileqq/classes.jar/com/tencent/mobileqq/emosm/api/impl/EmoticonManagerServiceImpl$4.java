package com.tencent.mobileqq.emosm.api.impl;

import android.util.Pair;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;

class EmoticonManagerServiceImpl$4
  implements QueryTask.Query<Pair<String, String>, Emoticon>
{
  EmoticonManagerServiceImpl$4(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl) {}
  
  public Emoticon a(Pair<String, String> paramPair)
  {
    return this.a.syncFindEmoticonById((String)paramPair.first, (String)paramPair.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */