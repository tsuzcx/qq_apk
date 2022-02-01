package com.tencent.mobileqq.qqguildsdk.search.selector;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.search.model.ISearchResultModel;
import java.util.List;

class GuildUserSearchUseCase$ResultModel
  implements ISearchResultModel<IGProUserInfo>
{
  private final String a;
  private final List<IGProUserInfo> b;
  
  GuildUserSearchUseCase$ResultModel(String paramString, List<IGProUserInfo> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List<IGProUserInfo> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase.ResultModel
 * JD-Core Version:    0.7.0.1
 */