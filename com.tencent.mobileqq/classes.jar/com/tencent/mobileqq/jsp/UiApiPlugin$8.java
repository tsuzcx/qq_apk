package com.tencent.mobileqq.jsp;

import awci;
import bhao;
import bifw;
import org.json.JSONObject;

public class UiApiPlugin$8
  implements Runnable
{
  UiApiPlugin$8(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.this$0.i = this.a.optString("callback");
    bhao.a(this.this$0.mRuntime.a(), new awci(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.8
 * JD-Core Version:    0.7.0.1
 */