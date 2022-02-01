package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import org.json.JSONObject;

public abstract class EditItemInfoBase
{
  protected JSONObject a;
  protected boolean b = true;
  public int c;
  
  public abstract int a();
  
  public JSONObject a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public abstract int b();
  
  public void c(String paramString) {}
  
  public String toString()
  {
    JSONObject localJSONObject = this.a;
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase
 * JD-Core Version:    0.7.0.1
 */