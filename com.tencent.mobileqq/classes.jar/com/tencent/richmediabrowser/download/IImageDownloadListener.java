package com.tencent.richmediabrowser.download;

import android.graphics.Bitmap;
import com.android.volley.VolleyError;

public abstract interface IImageDownloadListener
{
  public abstract void onError(VolleyError paramVolleyError);
  
  public abstract void onSuccess(String paramString, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.IImageDownloadListener
 * JD-Core Version:    0.7.0.1
 */