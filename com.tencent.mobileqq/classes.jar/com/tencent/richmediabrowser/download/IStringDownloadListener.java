package com.tencent.richmediabrowser.download;

import com.android.volley.VolleyError;

public abstract interface IStringDownloadListener
{
  public abstract void onError(VolleyError paramVolleyError);
  
  public abstract void onSuccess(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.IStringDownloadListener
 * JD-Core Version:    0.7.0.1
 */