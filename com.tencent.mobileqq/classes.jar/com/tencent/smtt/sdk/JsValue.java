package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;
import java.nio.ByteBuffer;

public class JsValue
{
  private final JsContext mContext;
  private final IX5JsValue mValue;
  
  protected JsValue(JsContext paramJsContext, IX5JsValue paramIX5JsValue)
  {
    this.mContext = paramJsContext;
    this.mValue = paramIX5JsValue;
  }
  
  protected static IX5JsValue.JsValueFactory factory()
  {
    return new JsValue.Factory(null);
  }
  
  private JsValue wrap(IX5JsValue paramIX5JsValue)
  {
    if (paramIX5JsValue == null) {
      return null;
    }
    return new JsValue(this.mContext, paramIX5JsValue);
  }
  
  public JsValue call(Object... paramVarArgs)
  {
    return wrap(this.mValue.call(paramVarArgs));
  }
  
  public JsValue construct(Object... paramVarArgs)
  {
    return wrap(this.mValue.construct(paramVarArgs));
  }
  
  public JsContext context()
  {
    return this.mContext;
  }
  
  public boolean isArray()
  {
    return this.mValue.isArray();
  }
  
  public boolean isArrayBufferOrArrayBufferView()
  {
    return this.mValue.isArrayBufferOrArrayBufferView();
  }
  
  public boolean isBoolean()
  {
    return this.mValue.isBoolean();
  }
  
  public boolean isFunction()
  {
    return this.mValue.isFunction();
  }
  
  public boolean isInteger()
  {
    return this.mValue.isInteger();
  }
  
  public boolean isJavascriptInterface()
  {
    return this.mValue.isJavascriptInterface();
  }
  
  public boolean isNull()
  {
    return this.mValue.isNull();
  }
  
  public boolean isNumber()
  {
    return this.mValue.isNumber();
  }
  
  public boolean isObject()
  {
    return this.mValue.isObject();
  }
  
  public boolean isPromise()
  {
    return this.mValue.isPromise();
  }
  
  public boolean isString()
  {
    return this.mValue.isString();
  }
  
  public boolean isUndefined()
  {
    return this.mValue.isUndefined();
  }
  
  public void reject(Object paramObject)
  {
    this.mValue.resolveOrReject(paramObject, false);
  }
  
  public void resolve(Object paramObject)
  {
    this.mValue.resolveOrReject(paramObject, true);
  }
  
  public boolean toBoolean()
  {
    return this.mValue.toBoolean();
  }
  
  public ByteBuffer toByteBuffer()
  {
    return this.mValue.toByteBuffer();
  }
  
  public int toInteger()
  {
    return this.mValue.toInteger();
  }
  
  public Object toJavascriptInterface()
  {
    return this.mValue.toJavascriptInterface();
  }
  
  public Number toNumber()
  {
    return this.mValue.toNumber();
  }
  
  public <T> T toObject(Class<T> paramClass)
  {
    return this.mValue.toObject(paramClass);
  }
  
  public String toString()
  {
    return this.mValue.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsValue
 * JD-Core Version:    0.7.0.1
 */