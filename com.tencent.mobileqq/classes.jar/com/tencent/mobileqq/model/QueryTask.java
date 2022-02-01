package com.tencent.mobileqq.model;

import axfu;
import axfv;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public axfu<Result> a;
  public axfv<Param, Result> a;
  private Param a;
  
  public QueryTask(axfv<Param, Result> paramaxfv, axfu<Result> paramaxfu)
  {
    this.jdField_a_of_type_Axfv = paramaxfv;
    this.jdField_a_of_type_Axfu = paramaxfu;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Axfv.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */