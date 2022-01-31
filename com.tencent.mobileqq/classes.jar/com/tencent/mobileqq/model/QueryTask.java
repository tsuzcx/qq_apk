package com.tencent.mobileqq.model;

import asko;
import askp;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public asko<Result> a;
  public askp<Param, Result> a;
  private Param a;
  
  public QueryTask(askp<Param, Result> paramaskp, asko<Result> paramasko)
  {
    this.jdField_a_of_type_Askp = paramaskp;
    this.jdField_a_of_type_Asko = paramasko;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Askp.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */