package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError
{
  private final IX5JsError mError;
  
  protected JsError(IX5JsError paramIX5JsError)
  {
    this.mError = paramIX5JsError;
  }
  
  public String getMessage()
  {
    return this.mError.getMessage();
  }
  
  public String getStack()
  {
    return this.mError.getStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsError
 * JD-Core Version:    0.7.0.1
 */