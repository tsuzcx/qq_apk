package org.junit;

class ComparisonFailure$ComparisonCompactor
{
  private static final String DIFF_END = "]";
  private static final String DIFF_START = "[";
  private static final String ELLIPSIS = "...";
  private final String actual;
  private final int contextLength;
  private final String expected;
  
  public ComparisonFailure$ComparisonCompactor(int paramInt, String paramString1, String paramString2)
  {
    this.contextLength = paramInt;
    this.expected = paramString1;
    this.actual = paramString2;
  }
  
  private String sharedPrefix()
  {
    int j = Math.min(this.expected.length(), this.actual.length());
    int i = 0;
    while (i < j)
    {
      if (this.expected.charAt(i) != this.actual.charAt(i)) {
        return this.expected.substring(0, i);
      }
      i += 1;
    }
    return this.expected.substring(0, j);
  }
  
  private String sharedSuffix(String paramString)
  {
    int i = 0;
    int j = Math.min(this.expected.length() - paramString.length(), this.actual.length() - paramString.length());
    for (;;)
    {
      if ((i > j - 1) || (this.expected.charAt(this.expected.length() - 1 - i) != this.actual.charAt(this.actual.length() - 1 - i))) {
        return this.expected.substring(this.expected.length() - i);
      }
      i += 1;
    }
  }
  
  public String compact(String paramString)
  {
    if ((this.expected == null) || (this.actual == null) || (this.expected.equals(this.actual))) {
      return Assert.format(paramString, this.expected, this.actual);
    }
    ComparisonFailure.ComparisonCompactor.DiffExtractor localDiffExtractor = new ComparisonFailure.ComparisonCompactor.DiffExtractor(this, null);
    String str1 = localDiffExtractor.compactPrefix();
    String str2 = localDiffExtractor.compactSuffix();
    return Assert.format(paramString, str1 + localDiffExtractor.expectedDiff() + str2, str1 + localDiffExtractor.actualDiff() + str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.ComparisonFailure.ComparisonCompactor
 * JD-Core Version:    0.7.0.1
 */