package com.tencent.mobileqq.kandian.glue.businesshandler;

import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;

public abstract class HandlerTask
{
  private String a;
  public Object g;
  
  public HandlerTask(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public abstract void a(IBaseHandler paramIBaseHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask
 * JD-Core Version:    0.7.0.1
 */