package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.io.OutputStream;

public class SkinGifImageDownloader
  extends AbsDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new SkinGifImageDownloader.1(this, paramFile, false, false, 0, 0, 0.0F);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = paramDownloadParams.urlStr;
    if (paramDownloadParams.startsWith("readinjoy_skin_gif://"))
    {
      paramOutputStream = paramDownloadParams.replace("readinjoy_skin_gif://", "");
    }
    else
    {
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith("readinjoy_skin_gif:")) {
        paramOutputStream = paramDownloadParams.replace("readinjoy_skin_gif:", "");
      }
    }
    paramOutputStream = new File(paramOutputStream);
    if (paramOutputStream.exists()) {
      return paramOutputStream;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SkinGifImageDownloader
 * JD-Core Version:    0.7.0.1
 */