package com.tencent.mobileqq.model;

import awnc;
import awnd;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public awnc<Result> a;
  public awnd<Param, Result> a;
  private Param a;
  
  public QueryTask(awnd<Param, Result> paramawnd, awnc<Result> paramawnc)
  {
    this.jdField_a_of_type_Awnd = paramawnd;
    this.jdField_a_of_type_Awnc = paramawnc;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Awnd.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */