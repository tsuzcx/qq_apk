package com.tencent.mobileqq.nearby.now.protocol;

import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.internal.http.HttpMethod;

public class NowRequest$Builder
{
  private Headers.Builder jdField_a_of_type_ComSquareupOkhttpHeaders$Builder = new Headers.Builder();
  private HttpUrl jdField_a_of_type_ComSquareupOkhttpHttpUrl;
  private RequestBody jdField_a_of_type_ComSquareupOkhttpRequestBody;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "GET";
  
  public Request a()
  {
    if (this.jdField_a_of_type_ComSquareupOkhttpHttpUrl == null) {
      throw new IllegalStateException("url == null");
    }
    String str = this.jdField_a_of_type_ComSquareupOkhttpHttpUrl.toString();
    return new Request.Builder().url(str).tag(this.jdField_a_of_type_JavaLangObject).method(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComSquareupOkhttpRequestBody).headers(this.jdField_a_of_type_ComSquareupOkhttpHeaders$Builder.build()).build();
  }
  
  public Builder a(HttpUrl paramHttpUrl)
  {
    if (paramHttpUrl == null) {
      throw new NullPointerException("url == null");
    }
    this.jdField_a_of_type_ComSquareupOkhttpHttpUrl = paramHttpUrl;
    return this;
  }
  
  public Builder a(RequestBody paramRequestBody)
  {
    return a("POST", paramRequestBody);
  }
  
  public Builder a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("url == null");
    }
    String str;
    if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
      str = "http:" + paramString.substring(3);
    }
    for (;;)
    {
      paramString = HttpUrl.parse(str);
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("unexpected url: " + str);
      str = paramString;
      if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
        str = "https:" + paramString.substring(4);
      }
    }
    return a(paramString);
  }
  
  public Builder a(String paramString, RequestBody paramRequestBody)
  {
    if (paramString == null) {
      throw new NullPointerException("method == null");
    }
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("method.length() == 0");
    }
    if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
    }
    if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString))) {
      throw new IllegalArgumentException("method " + paramString + " must have a request body.");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComSquareupOkhttpRequestBody = paramRequestBody;
    return this;
  }
  
  public Builder a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComSquareupOkhttpHeaders$Builder.add(paramString1, paramString2);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.NowRequest.Builder
 * JD-Core Version:    0.7.0.1
 */