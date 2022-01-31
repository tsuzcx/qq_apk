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
    return "[" + paramString.substring(this.sharedPrefix.length(), paramString.length() - this.sharedSuffix.length()) + "]";
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
    return "..." + this.sharedPrefix.substring(this.sharedPrefix.length() - ComparisonFailure.ComparisonCompactor.access$500(this.this$0));
  }
  
  public String compactSuffix()
  {
    if (this.sharedSuffix.length() <= ComparisonFailure.ComparisonCompactor.access$500(this.this$0)) {
      return this.sharedSuffix;
    }
    return this.sharedSuffix.substring(0, ComparisonFailure.ComparisonCompactor.access$500(this.this$0)) + "...";
  }
  
  public String expectedDiff()
  {
    return extractDiff(ComparisonFailure.ComparisonCompactor.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.ComparisonFailure.ComparisonCompactor.DiffExtractor
 * JD-Core Version:    0.7.0.1
 */