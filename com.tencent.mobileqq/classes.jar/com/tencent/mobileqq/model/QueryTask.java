package com.tencent.mobileqq.model;

import awzc;
import awzd;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public awzc<Result> a;
  public awzd<Param, Result> a;
  private Param a;
  
  public QueryTask(awzd<Param, Result> paramawzd, awzc<Result> paramawzc)
  {
    this.jdField_a_of_type_Awzd = paramawzd;
    this.jdField_a_of_type_Awzc = paramawzc;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Awzd.query(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */