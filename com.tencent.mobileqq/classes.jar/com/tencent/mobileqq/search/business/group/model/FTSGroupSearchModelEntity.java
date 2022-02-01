package com.tencent.mobileqq.search.business.group.model;

import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public abstract class FTSGroupSearchModelEntity
  extends ISearchResultGroupModel
{
  protected List<ISearchResultModel> a;
  protected String b;
  
  public FTSGroupSearchModelEntity(List<ISearchResultModel> paramList, String paramString)
  {
    this.a = paramList;
    this.b = paramString;
  }
  
  public List<ISearchResultModel> b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.group.model.FTSGroupSearchModelEntity
 * JD-Core Version:    0.7.0.1
 */