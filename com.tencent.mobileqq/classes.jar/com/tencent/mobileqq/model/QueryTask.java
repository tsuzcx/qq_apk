package com.tencent.mobileqq.model;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public QueryCallback<Result> a;
  public QueryTask.Query<Param, Result> a;
  private Param a;
  
  public QueryTask(QueryTask.Query<Param, Result> paramQuery, QueryCallback<Result> paramQueryCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqModelQueryTask$Query = paramQuery;
    this.jdField_a_of_type_ComTencentMobileqqModelQueryCallback = paramQueryCallback;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqModelQueryTask$Query.query(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */