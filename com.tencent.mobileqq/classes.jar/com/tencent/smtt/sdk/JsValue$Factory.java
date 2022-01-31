package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;

class JsValue$Factory
  implements IX5JsValue.JsValueFactory
{
  public String getJsValueClassName()
  {
    return JsValue.class.getName();
  }
  
  public IX5JsValue unwrap(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof JsValue))) {
      return JsValue.access$000((JsValue)paramObject);
    }
    return null;
  }
  
  public Object wrap(IX5JsValue paramIX5JsValue)
  {
    if (paramIX5JsValue != null)
    {
      JsContext localJsContext = JsContext.current();
      if (localJsContext != null) {
        return new JsValue(localJsContext, paramIX5JsValue);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsValue.Factory
 * JD-Core Version:    0.7.0.1
 */