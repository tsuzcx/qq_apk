package com.tencent.mobileqq.jsp;

import atfs;
import bczk;
import becq;
import org.json.JSONObject;

public class UiApiPlugin$8
  implements Runnable
{
  UiApiPlugin$8(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.this$0.i = this.a.optString("callback");
    bczk.a(this.this$0.mRuntime.a(), new atfs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.8
 * JD-Core Version:    0.7.0.1
 */