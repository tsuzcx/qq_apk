package com.tencent.richmediabrowser.download;

import com.android.volley.Response.Listener;

class HttpDownloadManager$1
  implements Response.Listener<String>
{
  HttpDownloadManager$1(HttpDownloadManager paramHttpDownloadManager, IStringDownloadListener paramIStringDownloadListener) {}
  
  public void onResponse(String paramString)
  {
    if (this.val$listener != null) {
      this.val$listener.onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.HttpDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */