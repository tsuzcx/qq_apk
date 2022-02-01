package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

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
    return 1746;
  }
  
  public void handle(String paramString, JSONObject paramJSONObject)
  {
    callback("getSdkVersion", "0", "success", new JsSdkVersionEntity(getSdkVersion()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.JsSdkInfoHandler
 * JD-Core Version:    0.7.0.1
 */