package com.tencent.richmediabrowser.download;

import com.android.volley.VolleyError;
import org.json.JSONObject;

public abstract interface IJsonDownloadListener
{
  public abstract void onError(VolleyError paramVolleyError);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.IJsonDownloadListener
 * JD-Core Version:    0.7.0.1
 */