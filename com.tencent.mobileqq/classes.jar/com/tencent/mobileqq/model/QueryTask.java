package com.tencent.mobileqq.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public QueryTask.Query<Param, Result> a;
  public QueryCallback<Result> b;
  private Param c;
  
  public QueryTask(QueryTask.Query<Param, Result> paramQuery, QueryCallback<Result> paramQueryCallback)
  {
    this.a = paramQuery;
    this.b = paramQueryCallback;
  }
  
  public void a(Param paramParam)
  {
    this.c = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.a.a(this.c);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */