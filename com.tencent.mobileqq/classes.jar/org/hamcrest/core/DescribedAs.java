package org.hamcrest.core;

import java.util.regex.Pattern;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

public class DescribedAs<T>
  extends BaseMatcher<T>
{
  private static final Pattern ARG_PATTERN = Pattern.compile("%([0-9]+)");
  private final String descriptionTemplate;
  private final org.hamcrest.Matcher<T> matcher;
  private final Object[] values;
  
  public DescribedAs(String paramString, org.hamcrest.Matcher<T> paramMatcher, Object[] paramArrayOfObject)
  {
    this.descriptionTemplate = paramString;
    this.matcher = paramMatcher;
    this.values = ((Object[])paramArrayOfObject.clone());
  }
  
  @Factory
  public static <T> org.hamcrest.Matcher<T> describedAs(String paramString, org.hamcrest.Matcher<T> paramMatcher, Object... paramVarArgs)
  {
    return new DescribedAs(paramString, paramMatcher, paramVarArgs);
  }
  
  public void describeMismatch(Object paramObject, Description paramDescription)
  {
    this.matcher.describeMismatch(paramObject, paramDescription);
  }
  
  public void describeTo(Description paramDescription)
  {
    java.util.regex.Matcher localMatcher = ARG_PATTERN.matcher(this.descriptionTemplate);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      paramDescription.appendText(this.descriptionTemplate.substring(i, localMatcher.start()));
      paramDescription.appendValue(this.values[java.lang.Integer.parseInt(localMatcher.group(1))]);
    }
    if (i < this.descriptionTemplate.length()) {
      paramDescription.appendText(this.descriptionTemplate.substring(i));
    }
  }
  
  public boolean matches(Object paramObject)
  {
    return this.matcher.matches(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.DescribedAs
 * JD-Core Version:    0.7.0.1
 */