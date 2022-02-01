package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import org.json.JSONObject;

class UiApiPlugin$13
  implements CallCommentJs
{
  UiApiPlugin$13(UiApiPlugin paramUiApiPlugin) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.13
 * JD-Core Version:    0.7.0.1
 */