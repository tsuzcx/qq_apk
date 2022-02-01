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
    int j = Math.min(this.expected.length() - paramString.length(), this.actual.length() - paramString.length());
    int i = 0;
    while (i <= j - 1)
    {
      paramString = this.expected;
      int k = paramString.charAt(paramString.length() - 1 - i);
      paramString = this.actual;
      if (k != paramString.charAt(paramString.length() - 1 - i)) {
        break;
      }
      i += 1;
    }
    paramString = this.expected;
    return paramString.substring(paramString.length() - i);
  }
  
  public String compact(String paramString)
  {
    Object localObject1 = this.expected;
    if (localObject1 != null)
    {
      String str1 = this.actual;
      if ((str1 != null) && (!((String)localObject1).equals(str1)))
      {
        localObject1 = new ComparisonFailure.ComparisonCompactor.DiffExtractor(this, null);
        str1 = ((ComparisonFailure.ComparisonCompactor.DiffExtractor)localObject1).compactPrefix();
        String str2 = ((ComparisonFailure.ComparisonCompactor.DiffExtractor)localObject1).compactSuffix();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(((ComparisonFailure.ComparisonCompactor.DiffExtractor)localObject1).expectedDiff());
        ((StringBuilder)localObject2).append(str2);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(((ComparisonFailure.ComparisonCompactor.DiffExtractor)localObject1).actualDiff());
        localStringBuilder.append(str2);
        return Assert.format(paramString, localObject2, localStringBuilder.toString());
      }
    }
    return Assert.format(paramString, this.expected, this.actual);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.ComparisonFailure.ComparisonCompactor
 * JD-Core Version:    0.7.0.1
 */