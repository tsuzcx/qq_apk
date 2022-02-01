package org.junit.internal;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

public class AssumptionViolatedException
  extends RuntimeException
  implements SelfDescribing
{
  private static final long serialVersionUID = 2L;
  private final String fAssumption;
  private final Matcher<?> fMatcher;
  private final Object fValue;
  private final boolean fValueMatcher;
  
  @Deprecated
  public AssumptionViolatedException(Object paramObject, Matcher<?> paramMatcher)
  {
    this(null, true, paramObject, paramMatcher);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString)
  {
    this(paramString, false, null, null);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString, Object paramObject, Matcher<?> paramMatcher)
  {
    this(paramString, true, paramObject, paramMatcher);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString, Throwable paramThrowable)
  {
    this(paramString, false, null, null);
    initCause(paramThrowable);
  }
  
  @Deprecated
  public AssumptionViolatedException(String paramString, boolean paramBoolean, Object paramObject, Matcher<?> paramMatcher)
  {
    this.fAssumption = paramString;
    this.fValue = paramObject;
    this.fMatcher = paramMatcher;
    this.fValueMatcher = paramBoolean;
    if ((paramObject instanceof Throwable)) {
      initCause((Throwable)paramObject);
    }
  }
  
  public void describeTo(Description paramDescription)
  {
    if (this.fAssumption != null) {
      paramDescription.appendText(this.fAssumption);
    }
    if (this.fValueMatcher)
    {
      if (this.fAssumption != null) {
        paramDescription.appendText(": ");
      }
      paramDescription.appendText("got: ");
      paramDescription.appendValue(this.fValue);
      if (this.fMatcher != null)
      {
        paramDescription.appendText(", expected: ");
        paramDescription.appendDescriptionOf(this.fMatcher);
      }
    }
  }
  
  public String getMessage()
  {
    return StringDescription.asString(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.AssumptionViolatedException
 * JD-Core Version:    0.7.0.1
 */