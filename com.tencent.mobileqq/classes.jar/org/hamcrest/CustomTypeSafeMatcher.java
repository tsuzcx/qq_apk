package org.hamcrest;

public abstract class CustomTypeSafeMatcher<T>
  extends TypeSafeMatcher<T>
{
  private final String fixedDescription;
  
  public CustomTypeSafeMatcher(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Description must be non null!");
    }
    this.fixedDescription = paramString;
  }
  
  public final void describeTo(Description paramDescription)
  {
    paramDescription.appendText(this.fixedDescription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.CustomTypeSafeMatcher
 * JD-Core Version:    0.7.0.1
 */