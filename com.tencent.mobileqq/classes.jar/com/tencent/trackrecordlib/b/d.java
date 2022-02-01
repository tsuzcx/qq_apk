package com.tencent.trackrecordlib.b;

import com.tencent.trackrecordlib.enums.UiActionKey;
import org.json.JSONObject;

public class d
  extends a
{
  private UiActionKey b;
  
  public d(UiActionKey paramUiActionKey)
  {
    this.b = paramUiActionKey;
  }
  
  public JSONObject a()
  {
    try
    {
      if (this.b != null) {
        this.a.put("code", this.b.getSeq());
      }
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.b.d
 * JD-Core Version:    0.7.0.1
 */