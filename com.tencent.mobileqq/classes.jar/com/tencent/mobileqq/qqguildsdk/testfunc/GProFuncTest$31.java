package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$31
  implements ISearchSink<IGProGuildInfo>
{
  public void onSearchResult(int paramInt, String paramString, List<ISearchResultModel<IGProGuildInfo>> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      QLog.d(GProFuncTest.a(), 2, "testSearchSrvGuildByShowNumber modelList is null");
      return;
    }
    paramInt = paramList.size();
    paramString = GProFuncTest.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("modelList size: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      return;
    }
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ISearchResultModel)paramString.next();
      localObject = GProFuncTest.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("model keyWord: ");
      localStringBuilder.append(paramList.a());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramList = paramList.b();
      localObject = GProFuncTest.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("infoList size: ");
      localStringBuilder.append(paramList.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (IGProGuildInfo)paramList.next();
        GProFuncTest.a(this.a, (IGProGuildInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.31
 * JD-Core Version:    0.7.0.1
 */