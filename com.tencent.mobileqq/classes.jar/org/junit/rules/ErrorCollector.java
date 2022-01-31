package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hamcrest.Matcher;
import org.junit.runners.model.MultipleFailureException;

public class ErrorCollector
  extends Verifier
{
  private List<Throwable> errors = new ArrayList();
  
  public void addError(Throwable paramThrowable)
  {
    this.errors.add(paramThrowable);
  }
  
  public <T> T checkSucceeds(Callable<T> paramCallable)
  {
    try
    {
      paramCallable = paramCallable.call();
      return paramCallable;
    }
    catch (Throwable paramCallable)
    {
      addError(paramCallable);
    }
    return null;
  }
  
  public <T> void checkThat(T paramT, Matcher<T> paramMatcher)
  {
    checkThat("", paramT, paramMatcher);
  }
  
  public <T> void checkThat(String paramString, T paramT, Matcher<T> paramMatcher)
  {
    checkSucceeds(new ErrorCollector.1(this, paramString, paramT, paramMatcher));
  }
  
  protected void verify()
  {
    MultipleFailureException.assertEmpty(this.errors);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.rules.ErrorCollector
 * JD-Core Version:    0.7.0.1
 */