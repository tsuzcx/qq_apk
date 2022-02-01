package com.tencent.mobileqq.nearby.now.protocol;

import okhttp3.HttpUrl;

public class NowRequest
{
  private final HttpUrl a;
  private final String b;
  private final Object c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request{method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tag=");
    Object localObject = this.c;
    if (localObject == this) {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.NowRequest
 * JD-Core Version:    0.7.0.1
 */