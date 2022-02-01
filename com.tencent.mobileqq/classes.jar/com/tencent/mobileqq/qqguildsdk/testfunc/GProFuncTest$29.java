package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GProFuncTest$29
  implements ISearchSink<IGProGuildInfo>
{
  public void onSearchResult(int paramInt, String paramString, List<ISearchResultModel<IGProGuildInfo>> paramList, boolean paramBoolean)
  {
    paramInt = paramList.size();
    paramString = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("modelList size: ");
    localStringBuilder.append(paramInt);
    QLog.d(paramString, 2, localStringBuilder.toString());
    if (paramInt == 0) {
      return;
    }
    paramString = (ISearchResultModel)paramList.get(0);
    paramList = GProFuncTest.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("model keyWord: ");
    localStringBuilder.append(paramString.a());
    QLog.d(paramList, 2, localStringBuilder.toString());
    paramString = paramString.b();
    paramList = GProFuncTest.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("infoList size: ");
    localStringBuilder.append(paramString.size());
    QLog.d(paramList, 2, localStringBuilder.toString());
    paramString = (IGProGuildInfo)paramString.get(0);
    if (paramString == null) {
      return;
    }
    paramList = GProFuncTest.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("infoList name: ");
    localStringBuilder.append(paramString.getGuildName());
    QLog.d(paramList, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.29
 * JD-Core Version:    0.7.0.1
 */