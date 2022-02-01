package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonPlugin
  extends WebViewPlugin
{
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("emoticon".equals(paramString2))
    {
      if (("showEmoticon".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = new SearchEmoticonWebBean();
          paramString1.a = paramJsBridgeListener.optString("emt_name", "");
          paramString1.b = paramJsBridgeListener.optString("emt_oriUrl", "");
          paramString1.c = paramJsBridgeListener.optString("emt_oriMd5", "");
          paramString1.d = paramJsBridgeListener.optInt("emt_oriFileSize", 0);
          paramString1.e = paramJsBridgeListener.optInt("emt_oriWidth", 0);
          paramString1.f = paramJsBridgeListener.optInt("emt_oriHeight", 0);
          paramString1.g = paramJsBridgeListener.optInt("emt_type", 0);
          paramString1.h = paramJsBridgeListener.optString("emt_packCoverUrl", "");
          paramString1.i = paramJsBridgeListener.optString("emt_packId", "");
          paramString1.j = paramJsBridgeListener.optString("emt_packName", "");
          paramString1.k = paramJsBridgeListener.optString("emt_miniId", "");
          paramString1.l = paramJsBridgeListener.optString("emt_miniName", "");
          SearchEmoticonFragment.a(this.mRuntime.d(), paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("showEmoticon error : ");
            paramString1.append(ThrowablesUtils.a(paramJsBridgeListener));
            QLog.d("EmoticonPlugin", 2, paramString1.toString());
          }
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmoticonPlugin
 * JD-Core Version:    0.7.0.1
 */