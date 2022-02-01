package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$41
  implements ISearchSink<IGProUserInfo>
{
  public void onSearchResult(int paramInt, String paramString, List<ISearchResultModel<IGProUserInfo>> paramList, boolean paramBoolean)
  {
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = ((ISearchResultModel)paramString.next()).b().iterator();
      while (paramList.hasNext())
      {
        IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
        GProFuncTest.a(this.a, localIGProUserInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.41
 * JD-Core Version:    0.7.0.1
 */