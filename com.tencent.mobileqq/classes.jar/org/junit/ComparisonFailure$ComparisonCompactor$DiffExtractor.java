package org.junit;

class ComparisonFailure$ComparisonCompactor$DiffExtractor
{
  private final String sharedPrefix;
  private final String sharedSuffix;
  
  private ComparisonFailure$ComparisonCompactor$DiffExtractor(ComparisonFailure.ComparisonCompactor paramComparisonCompactor)
  {
    this.sharedPrefix = ComparisonFailure.ComparisonCompactor.access$100(paramComparisonCompactor);
    this.sharedSuffix = ComparisonFailure.ComparisonCompactor.access$200(paramComparisonCompactor, this.sharedPrefix);
  }
  
  private String extractDiff(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString.substring(this.sharedPrefix.length(), paramString.length() - this.sharedSuffix.length()));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public String actualDiff()
  {
    return extractDiff(ComparisonFailure.ComparisonCompactor.access$400(this.this$0));
  }
  
  public String compactPrefix()
  {
    if (this.sharedPrefix.length() <= ComparisonFailure.ComparisonCompactor.access$500(this.this$0)) {
      return this.sharedPrefix;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("...");
    String str = this.sharedPrefix;
    localStringBuilder.append(str.substring(str.length() - ComparisonFailure.ComparisonCompactor.access$500(this.this$0)));
    return localStringBuilder.toString();
  }
  
  public String compactSuffix()
  {
    if (this.sharedSuffix.length() <= ComparisonFailure.ComparisonCompactor.access$500(this.this$0)) {
      return this.sharedSuffix;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.sharedSuffix.substring(0, ComparisonFailure.ComparisonCompactor.access$500(this.this$0)));
    localStringBuilder.append("...");
    return localStringBuilder.toString();
  }
  
  public String expectedDiff()
  {
    return extractDiff(ComparisonFailure.ComparisonCompactor.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.ComparisonFailure.ComparisonCompactor.DiffExtractor
 * JD-Core Version:    0.7.0.1
 */