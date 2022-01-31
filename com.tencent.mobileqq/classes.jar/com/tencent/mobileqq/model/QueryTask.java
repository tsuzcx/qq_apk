package com.tencent.mobileqq.model;

import askq;
import askr;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public askq<Result> a;
  public askr<Param, Result> a;
  private Param a;
  
  public QueryTask(askr<Param, Result> paramaskr, askq<Result> paramaskq)
  {
    this.jdField_a_of_type_Askr = paramaskr;
    this.jdField_a_of_type_Askq = paramaskq;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Askr.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */