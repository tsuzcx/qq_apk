package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import org.json.JSONException;
import org.json.JSONObject;

public class JsSdkVersionEntity
  implements IJsEntityFormatter
{
  private static final String TAG = "JsSdkVersionEntity";
  private int mSdkVersion;
  
  private JsSdkVersionEntity() {}
  
  public JsSdkVersionEntity(int paramInt)
  {
    this.mSdkVersion = paramInt;
  }
  
  public JSONObject format()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sdkVersion", this.mSdkVersion);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("format ");
      localStringBuilder.append(localJSONException);
      Log.e("JsSdkVersionEntity", localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.entity.JsSdkVersionEntity
 * JD-Core Version:    0.7.0.1
 */