package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import org.json.JSONObject;

class UiApiPlugin$11
  implements CallCommentJs
{
  UiApiPlugin$11(UiApiPlugin paramUiApiPlugin) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.11
 * JD-Core Version:    0.7.0.1
 */