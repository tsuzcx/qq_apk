package com.tencent.mobileqq.uftransfer.common.transfer.urlprovider;

class UFTUrlProvider$UrlRetryContent
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  boolean e = false;
  
  public UFTUrlProvider$UrlRetryContent(UFTUrlProvider paramUFTUrlProvider)
  {
    a();
  }
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.e = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" retryInfo[AutoR:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" EofR:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" SvrErrR:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" UrlErrR:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" DataConn:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTUrlProvider.UrlRetryContent
 * JD-Core Version:    0.7.0.1
 */