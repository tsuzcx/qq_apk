package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import org.json.JSONObject;

public abstract class EditItemInfoBase
{
  public int g;
  protected JSONObject h;
  protected boolean i = true;
  
  public abstract int a();
  
  public abstract int b();
  
  public void c(String paramString) {}
  
  public boolean c()
  {
    return this.i;
  }
  
  public JSONObject d()
  {
    return this.h;
  }
  
  public String toString()
  {
    JSONObject localJSONObject = this.h;
    if (localJSONObject != null) {
      return localJSONObject.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase
 * JD-Core Version:    0.7.0.1
 */