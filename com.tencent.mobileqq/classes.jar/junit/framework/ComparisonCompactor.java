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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString.substring(this.fPrefix, paramString.length() - this.fSuffix + 1));
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.fPrefix > 0)
    {
      paramString = new StringBuilder();
      paramString.append(computeCommonPrefix());
      paramString.append((String)localObject);
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (this.fSuffix > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(computeCommonSuffix());
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private String computeCommonPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (this.fPrefix > this.fContextLength) {
      str = "...";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix));
    return localStringBuilder.toString();
  }
  
  private String computeCommonSuffix()
  {
    int i = Math.min(this.fExpected.length() - this.fSuffix + 1 + this.fContextLength, this.fExpected.length());
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.fExpected;
    localStringBuilder.append(str.substring(str.length() - this.fSuffix + 1, i));
    if (this.fExpected.length() - this.fSuffix + 1 < this.fExpected.length() - this.fContextLength) {
      str = "...";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  private void findCommonPrefix()
  {
    this.fPrefix = 0;
    int i = Math.min(this.fExpected.length(), this.fActual.length());
    for (;;)
    {
      int j = this.fPrefix;
      if (j >= i) {
        break;
      }
      if (this.fExpected.charAt(j) != this.fActual.charAt(this.fPrefix)) {
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
      int k = this.fPrefix;
      if ((j < k) || (i < k) || (this.fExpected.charAt(i) != this.fActual.charAt(j))) {
        break;
      }
      j -= 1;
      i -= 1;
    }
    this.fSuffix = (this.fExpected.length() - i);
  }
  
  public String compact(String paramString)
  {
    if ((this.fExpected != null) && (this.fActual != null) && (!areStringsEqual()))
    {
      findCommonPrefix();
      findCommonSuffix();
      return Assert.format(paramString, compactString(this.fExpected), compactString(this.fActual));
    }
    return Assert.format(paramString, this.fExpected, this.fActual);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.framework.ComparisonCompactor
 * JD-Core Version:    0.7.0.1
 */