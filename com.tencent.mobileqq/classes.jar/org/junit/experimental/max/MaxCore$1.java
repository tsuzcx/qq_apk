package org.junit.experimental.max;

import java.util.List;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

class MaxCore$1
  extends Request
{
  MaxCore$1(MaxCore paramMaxCore, List paramList) {}
  
  public Runner getRunner()
  {
    try
    {
      MaxCore.1.1 local1 = new MaxCore.1.1(this, (Class)null, this.val$runners);
      return local1;
    }
    catch (InitializationError localInitializationError)
    {
      return new ErrorReportingRunner(null, localInitializationError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.max.MaxCore.1
 * JD-Core Version:    0.7.0.1
 */