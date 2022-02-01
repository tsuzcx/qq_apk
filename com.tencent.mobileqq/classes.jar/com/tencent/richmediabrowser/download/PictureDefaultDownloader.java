package com.tencent.richmediabrowser.download;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import java.io.File;

public class PictureDefaultDownloader
  extends ProtocolDownloader.Adapter
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return super.hasDiskFile(paramDownloadParams);
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      String str = paramDownloadParams.urlStr;
      IImageDownloadListener localIImageDownloadListener = HttpDownloadManager.getInstance().getImageDownloadListener(str);
      HttpDownloadManager.getInstance().downloadImage(str, new PictureDefaultDownloader.1(this, localIImageDownloadListener));
    }
    return super.loadImageFile(paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.PictureDefaultDownloader
 * JD-Core Version:    0.7.0.1
 */