package com.tencent.mobileqq.model;

import avtb;
import avtc;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QueryTask<Param, Result>
  implements Runnable
{
  public avtb<Result> a;
  public avtc<Param, Result> a;
  private Param a;
  
  public QueryTask(avtc<Param, Result> paramavtc, avtb<Result> paramavtb)
  {
    this.jdField_a_of_type_Avtc = paramavtc;
    this.jdField_a_of_type_Avtb = paramavtb;
  }
  
  public void a(Param paramParam)
  {
    this.jdField_a_of_type_JavaLangObject = paramParam;
    ThreadManager.excute(this, 32, null, true);
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Avtc.query(this.jdField_a_of_type_JavaLangObject);
    ThreadManager.getUIHandler().post(new QueryTask.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.QueryTask
 * JD-Core Version:    0.7.0.1
 */