package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public class TransProcessorHandler
  extends Handler
{
  private ArrayList a = new ArrayList();
  
  public TransProcessorHandler()
  {
    this.a.clear();
  }
  
  public TransProcessorHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.a.clear();
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(Class... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.a.add(paramVarArgs[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */