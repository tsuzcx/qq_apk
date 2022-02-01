package com.tencent.richmediabrowser.download;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import java.io.File;

public class PictureDefaultDownloader
  extends ProtocolDownloader.Adapter
{
  Bitmap mBitmap;
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return this.mBitmap;
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return super.hasDiskFile(paramDownloadParams);
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      Object localObject = paramDownloadParams.urlStr;
      localObject = HttpDownloadManager.getInstance().downloadImageSync((String)localObject);
      if (localObject != null) {
        this.mBitmap = ((Bitmap)localObject);
      }
    }
    return super.loadImageFile(paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.PictureDefaultDownloader
 * JD-Core Version:    0.7.0.1
 */