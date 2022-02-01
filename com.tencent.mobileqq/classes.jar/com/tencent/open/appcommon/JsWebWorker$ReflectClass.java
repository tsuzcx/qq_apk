package com.tencent.open.appcommon;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsWebWorker$ReflectClass
{
  public String a;
  public Class b;
  public Map<Integer, Object> c = new HashMap();
  public Map<String, Method> d = new HashMap();
  
  protected JsWebWorker$ReflectClass(JsWebWorker paramJsWebWorker) {}
  
  public void a()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    this.c = null;
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.JsWebWorker.ReflectClass
 * JD-Core Version:    0.7.0.1
 */