package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager.H5DataCallback;
import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import org.json.JSONObject;

class JSAPIAdapter$H5Callback
  implements ReadInJoyWebDataManager.H5DataCallback
{
  IJSApiAdapter.OnInovkeCallback a;
  
  public JSAPIAdapter$H5Callback(IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback)
  {
    this.a = paramOnInovkeCallback;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    IJSApiAdapter.OnInovkeCallback localOnInovkeCallback = this.a;
    if (localOnInovkeCallback != null) {
      localOnInovkeCallback.callback(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.JSAPIAdapter.H5Callback
 * JD-Core Version:    0.7.0.1
 */