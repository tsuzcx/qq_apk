package junit.framework;

public class ComparisonCompactor
{
  private static final String DELTA_END = "]";
  private static final String DELTA_START = "[";
  private static final String ELLIPSIS = "...";
  private String fActual;
  private int fContextLength;
  private String fExpected;
  private int fPrefix;
  private int fSuffix;
  
  public ComparisonCompactor(int paramInt, String paramString1, String paramString2)
  {
    this.fContextLength = paramInt;
    this.fExpected = paramString1;
    this.fActual = paramString2;
  }
  
  private boolean areStringsEqual()
  {
    return this.fExpected.equals(this.fActual);
  }
  
  private String compactString(String paramString)
  {
    String str = "[" + paramString.substring(this.fPrefix, paramString.length() - this.fSuffix + 1) + "]";
    paramString = str;
    if (this.fPrefix > 0) {
      paramString = computeCommonPrefix() + str;
    }
    str = paramString;
    if (this.fSuffix > 0) {
      str = paramString + computeCommonSuffix();
    }
    return str;
  }
  
  private String computeCommonPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.fPrefix > this.fContextLength) {}
    for (String str = "...";; str = "") {
      return str + this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix);
    }
  }
  
  private String computeCommonSuffix()
  {
    int i = Math.min(this.fExpected.length() - this.fSuffix + 1 + this.fContextLength, this.fExpected.length());
    StringBuilder localStringBuilder = new StringBuilder().append(this.fExpected.substring(this.fExpected.length() - this.fSuffix + 1, i));
    if (this.fExpected.length() - this.fSuffix + 1 < this.fExpected.length() - this.fContextLength) {}
    for (String str = "...";; str = "") {
      return str;
    }
  }
  
  private void findCommonPrefix()
  {
    this.fPrefix = 0;
    int i = Math.min(this.fExpected.length(), this.fActual.length());
    for (;;)
    {
      if ((this.fPrefix >= i) || (this.fExpected.charAt(this.fPrefix) != this.fActual.charAt(this.fPrefix))) {
        return;
      }
      this.fPrefix += 1;
    }
  }
  
  private void findCommonSuffix()
  {
    int i = this.fExpected.length() - 1;
    int j = this.fActual.length() - 1;
    for (;;)
    {
      if ((j < this.fPrefix) || (i < this.fPrefix) || (this.fExpected.charAt(i) != this.fActual.charAt(j)))
      {
        this.fSuffix = (this.fExpected.length() - i);
        return;
      }
      j -= 1;
      i -= 1;
    }
  }
  
  public String compact(String paramString)
  {
    if ((this.fExpected == null) || (this.fActual == null) || (areStringsEqual())) {
      return Assert.format(paramString, this.fExpected, this.fActual);
    }
    findCommonPrefix();
    findCommonSuffix();
    return Assert.format(paramString, compactString(this.fExpected), compactString(this.fActual));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.framework.ComparisonCompactor
 * JD-Core Version:    0.7.0.1
 */