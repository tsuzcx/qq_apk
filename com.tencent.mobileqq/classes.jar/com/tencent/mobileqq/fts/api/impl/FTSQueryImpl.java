package com.tencent.mobileqq.fts.api.impl;

import com.tencent.mobileqq.fts.api.IFTSQuery;
import com.tencent.mobileqq.fts.query.IQuery;
import com.tencent.mobileqq.fts.query.QueryArgs;
import com.tencent.mobileqq.fts.query.QueryFactory;
import java.util.List;
import mqq.app.AppRuntime;

public class FTSQueryImpl
  implements IFTSQuery
{
  AppRuntime mAppRuntime;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public <T> List<T> query(QueryArgs paramQueryArgs)
  {
    return QueryFactory.a(paramQueryArgs.b).a(paramQueryArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.api.impl.FTSQueryImpl
 * JD-Core Version:    0.7.0.1
 */