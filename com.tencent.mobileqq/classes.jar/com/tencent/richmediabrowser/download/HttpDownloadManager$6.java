package com.tencent.richmediabrowser.download;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

class HttpDownloadManager$6
  implements Response.ErrorListener
{
  HttpDownloadManager$6(HttpDownloadManager paramHttpDownloadManager, IImageDownloadListener paramIImageDownloadListener) {}
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    if (this.val$listener != null) {
      this.val$listener.onError(paramVolleyError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.HttpDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */