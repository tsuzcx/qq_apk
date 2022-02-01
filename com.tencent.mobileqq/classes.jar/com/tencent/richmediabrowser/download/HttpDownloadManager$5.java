package com.tencent.richmediabrowser.download;

import android.graphics.Bitmap;
import com.android.volley.Response.Listener;

class HttpDownloadManager$5
  implements Response.Listener<Bitmap>
{
  HttpDownloadManager$5(HttpDownloadManager paramHttpDownloadManager, IImageDownloadListener paramIImageDownloadListener, String paramString) {}
  
  public void onResponse(Bitmap paramBitmap)
  {
    if (this.val$listener != null) {
      this.val$listener.onSuccess(this.val$url, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.HttpDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */