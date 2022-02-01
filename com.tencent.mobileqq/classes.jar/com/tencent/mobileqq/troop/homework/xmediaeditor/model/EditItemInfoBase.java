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
  
  public void a(String paramString) {}
  
  public boolean a()
  {
    return this.b;
  }
  
  public abstract int b();
  
  public String toString()
  {
    if (this.a != null) {
      return this.a.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase
 * JD-Core Version:    0.7.0.1
 */