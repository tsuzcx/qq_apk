package org.junit.internal.runners;

import java.util.Arrays;
import java.util.List;

@Deprecated
public class InitializationError
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private final List<Throwable> fErrors;
  
  public InitializationError(String paramString)
  {
    this(new Throwable[] { new Exception(paramString) });
  }
  
  public InitializationError(List<Throwable> paramList)
  {
    this.fErrors = paramList;
  }
  
  public InitializationError(Throwable... paramVarArgs)
  {
    this(Arrays.asList(paramVarArgs));
  }
  
  public List<Throwable> getCauses()
  {
    return this.fErrors;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.internal.runners.InitializationError
 * JD-Core Version:    0.7.0.1
 */