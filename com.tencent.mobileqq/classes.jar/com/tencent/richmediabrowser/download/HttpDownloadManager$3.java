package com.tencent.richmediabrowser.download;

import com.android.volley.Response.Listener;
import org.json.JSONObject;

class HttpDownloadManager$3
  implements Response.Listener<JSONObject>
{
  HttpDownloadManager$3(HttpDownloadManager paramHttpDownloadManager, IJsonDownloadListener paramIJsonDownloadListener) {}
  
  public void onResponse(JSONObject paramJSONObject)
  {
    if (this.val$listener != null) {
      this.val$listener.onSuccess(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.HttpDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */