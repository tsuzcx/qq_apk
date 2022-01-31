package org.hamcrest;

public class MatcherAssert
{
  public static <T> void assertThat(T paramT, Matcher<? super T> paramMatcher)
  {
    assertThat("", paramT, paramMatcher);
  }
  
  public static <T> void assertThat(String paramString, T paramT, Matcher<? super T> paramMatcher)
  {
    if (!paramMatcher.matches(paramT))
    {
      StringDescription localStringDescription = new StringDescription();
      localStringDescription.appendText(paramString).appendText("\nExpected: ").appendDescriptionOf(paramMatcher).appendText("\n     but: ");
      paramMatcher.describeMismatch(paramT, localStringDescription);
      throw new AssertionError(localStringDescription.toString());
    }
  }
  
  public static void assertThat(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.MatcherAssert
 * JD-Core Version:    0.7.0.1
 */