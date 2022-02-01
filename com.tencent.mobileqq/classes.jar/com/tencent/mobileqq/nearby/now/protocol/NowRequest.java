package com.tencent.mobileqq.nearby.now.protocol;

import okhttp3.HttpUrl;

public class NowRequest
{
  private final Object jdField_a_of_type_JavaLangObject;
  private final String jdField_a_of_type_JavaLangString;
  private final HttpUrl jdField_a_of_type_Okhttp3HttpUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request{method=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.jdField_a_of_type_Okhttp3HttpUrl);
    localStringBuilder.append(", tag=");
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (localObject == this) {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.NowRequest
 * JD-Core Version:    0.7.0.1
 */