package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity.JsSdkVersionEntity;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsObjectHandler;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class JsSdkInfoHandler
  extends BaseJsHandler
  implements IJsObjectHandler
{
  public JsSdkInfoHandler(WeakReference<Object> paramWeakReference)
  {
    super(paramWeakReference);
  }
  
  private int getSdkVersion()
  {
    return 2200;
  }
  
  public void handle(String paramString, JSONObject paramJSONObject)
  {
    paramString = new JsSdkVersionEntity(getSdkVersion());
    paramJSONObject = getCallbackId(paramJSONObject);
    if (!TextUtils.isEmpty(paramJSONObject)) {
      callback(paramJSONObject, "0", "success", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.JsSdkInfoHandler
 * JD-Core Version:    0.7.0.1
 */