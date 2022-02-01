package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;
import org.json.JSONObject;

class UiApiPlugin$16
  implements BridgeModule.CallCommentJs
{
  UiApiPlugin$16(UiApiPlugin paramUiApiPlugin) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.16
 * JD-Core Version:    0.7.0.1
 */