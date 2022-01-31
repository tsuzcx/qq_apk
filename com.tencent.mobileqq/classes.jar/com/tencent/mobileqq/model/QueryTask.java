package com.tencent.mobileqq.model;

import aubp;
import aubq;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public aubp<Result> a;
  public aubq<Param, Result> a;
  private Param a;
  
  public QueryTask(aubq<Param, Result> paramaubq, aubp<Result> paramaubp)
  {
    this.jdField_a_of_type_Aubq = paramaubq;
    this.jdField_a_of_type_Aubp = paramaubp;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Aubq.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */