package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public QueryCallback<Result> callback;
  private Param param;
  public QueryTask.Query<Param, Result> query;
  
  public QueryTask(QueryTask.Query<Param, Result> paramQuery, QueryCallback<Result> paramQueryCallback)
  {
    this.query = paramQuery;
    this.callback = paramQueryCallback;
  }
  
  public void execute(Param paramParam)
  {
    this.param = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.query.query(this.param);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QueryTask
 * JD-Core Version:    0.7.0.1
 */