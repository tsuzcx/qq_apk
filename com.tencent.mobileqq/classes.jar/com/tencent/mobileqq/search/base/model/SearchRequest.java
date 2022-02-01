package com.tencent.mobileqq.search.base.model;

import android.os.Bundle;

public class SearchRequest
{
  public String a;
  public Bundle b;
  public byte[] c;
  
  public SearchRequest(String paramString)
  {
    this.a = paramString;
  }
  
  public SearchRequest(String paramString, Bundle paramBundle)
  {
    this.a = paramString;
    this.b = paramBundle;
  }
  
  public SearchRequest(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.c = paramArrayOfByte;
  }
  
  public SearchRequest(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a = paramString;
    this.c = paramArrayOfByte;
    this.b = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.model.SearchRequest
 * JD-Core Version:    0.7.0.1
 */