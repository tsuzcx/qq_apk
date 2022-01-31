package com.tencent.mobileqq.model;

import arok;
import arol;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public arok<Result> a;
  public arol<Param, Result> a;
  private Param a;
  
  public QueryTask(arol<Param, Result> paramarol, arok<Result> paramarok)
  {
    this.jdField_a_of_type_Arol = paramarol;
    this.jdField_a_of_type_Arok = paramarok;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Arol.a(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */