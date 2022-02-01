package com.tencent.mobileqq.qqguildsdk.search.model;

import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserSearchResultModel
  extends SearchResultModel<IGProUserInfo>
{
  public UserSearchResultModel(ISearchResultModel<GProUser> paramISearchResultModel)
  {
    super(paramISearchResultModel.a());
    a(GProConvert.c(paramISearchResultModel.b()));
  }
  
  public static List<ISearchResultModel<IGProUserInfo>> a(String paramString, List<IGProUserInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new UserSearchResultModel.1(paramString, paramList));
    return localArrayList;
  }
  
  public static List<ISearchResultModel<IGProUserInfo>> b(List<ISearchResultModel<GProUser>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new UserSearchResultModel((ISearchResultModel)paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.model.UserSearchResultModel
 * JD-Core Version:    0.7.0.1
 */