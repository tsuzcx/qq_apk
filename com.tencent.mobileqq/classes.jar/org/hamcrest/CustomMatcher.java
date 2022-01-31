package org.hamcrest;

public abstract class CustomMatcher<T>
  extends BaseMatcher<T>
{
  private final String fixedDescription;
  
  public CustomMatcher(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Description should be non null!");
    }
    this.fixedDescription = paramString;
  }
  
  public final void describeTo(Description paramDescription)
  {
    paramDescription.appendText(this.fixedDescription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.CustomMatcher
 * JD-Core Version:    0.7.0.1
 */