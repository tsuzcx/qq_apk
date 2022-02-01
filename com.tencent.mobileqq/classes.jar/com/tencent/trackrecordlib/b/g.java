package com.tencent.trackrecordlib.b;

import com.tencent.trackrecordlib.enums.UiActionScreenRotation;
import org.json.JSONObject;

public class g
  extends a
{
  private UiActionScreenRotation b;
  
  public g(UiActionScreenRotation paramUiActionScreenRotation)
  {
    this.b = paramUiActionScreenRotation;
  }
  
  public JSONObject a()
  {
    try
    {
      if (this.b != null) {
        this.a.put("orention", this.b.getSeq());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.b.g
 * JD-Core Version:    0.7.0.1
 */