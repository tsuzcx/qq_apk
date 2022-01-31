package org.junit.rules;

import java.util.concurrent.Callable;
import org.hamcrest.Matcher;
import org.junit.Assert;

class ErrorCollector$1
  implements Callable<Object>
{
  ErrorCollector$1(ErrorCollector paramErrorCollector, String paramString, Object paramObject, Matcher paramMatcher) {}
  
  public Object call()
  {
    Assert.assertThat(this.val$reason, this.val$value, this.val$matcher);
    return this.val$value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.rules.ErrorCollector.1
 * JD-Core Version:    0.7.0.1
 */