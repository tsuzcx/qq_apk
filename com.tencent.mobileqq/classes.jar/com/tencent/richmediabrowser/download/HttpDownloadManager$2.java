package com.tencent.richmediabrowser.download;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

class HttpDownloadManager$2
  implements Response.ErrorListener
{
  HttpDownloadManager$2(HttpDownloadManager paramHttpDownloadManager, IStringDownloadListener paramIStringDownloadListener) {}
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    if (this.val$listener != null) {
      this.val$listener.onError(paramVolleyError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.HttpDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */