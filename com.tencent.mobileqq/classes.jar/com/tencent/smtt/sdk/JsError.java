package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

public class JsError
{
  private final IX5JsError a;
  
  protected JsError(IX5JsError paramIX5JsError)
  {
    this.a = paramIX5JsError;
  }
  
  public String getMessage()
  {
    return this.a.getMessage();
  }
  
  public String getStack()
  {
    return this.a.getStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsError
 * JD-Core Version:    0.7.0.1
 */