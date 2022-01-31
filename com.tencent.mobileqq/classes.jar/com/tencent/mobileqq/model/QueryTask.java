package com.tencent.mobileqq.model;

import aufy;
import aufz;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public aufy<Result> a;
  public aufz<Param, Result> a;
  private Param a;
  
  public QueryTask(aufz<Param, Result> paramaufz, aufy<Result> paramaufy)
  {
    this.jdField_a_of_type_Aufz = paramaufz;
    this.jdField_a_of_type_Aufy = paramaufy;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Aufz.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */