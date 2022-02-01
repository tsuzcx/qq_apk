package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;

@Deprecated
public abstract interface HttpResponseInterceptorList
{
  public abstract void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor);
  
  public abstract void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt);
  
  public abstract void clearResponseInterceptors();
  
  public abstract HttpResponseInterceptor getResponseInterceptor(int paramInt);
  
  public abstract int getResponseInterceptorCount();
  
  public abstract void removeResponseInterceptorByClass(Class paramClass);
  
  public abstract void setInterceptors(List paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.protocol.HttpResponseInterceptorList
 * JD-Core Version:    0.7.0.1
 */