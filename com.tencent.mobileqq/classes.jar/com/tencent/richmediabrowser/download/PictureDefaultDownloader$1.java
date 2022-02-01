package com.tencent.richmediabrowser.download;

import android.graphics.Bitmap;
import com.android.volley.VolleyError;

class PictureDefaultDownloader$1
  implements IImageDownloadListener
{
  PictureDefaultDownloader$1(PictureDefaultDownloader paramPictureDefaultDownloader, IImageDownloadListener paramIImageDownloadListener) {}
  
  public void onError(VolleyError paramVolleyError)
  {
    if ((paramVolleyError != null) && (this.val$listener != null)) {
      this.val$listener.onError(paramVolleyError);
    }
  }
  
  public void onSuccess(String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.val$listener != null)) {
      this.val$listener.onSuccess(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.PictureDefaultDownloader.1
 * JD-Core Version:    0.7.0.1
 */