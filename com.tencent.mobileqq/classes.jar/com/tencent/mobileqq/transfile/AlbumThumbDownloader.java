package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.AppVideoDecoder;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.ThumbDecoder;
import com.tencent.mobileqq.activity.photo.VideoDecoder;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.net.URL;

public class AlbumThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public static int a = 200;
  
  public AlbumThumbDownloader(Application paramApplication) {}
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (!LocalMediaInfo.class.isInstance(paramDownloadParams.tag)) {
      throw new RuntimeException("Decode info is invalide");
    }
    paramURLDrawableHandler = (LocalMediaInfo)paramDownloadParams.tag;
    for (;;)
    {
      try
      {
        paramFile = paramDownloadParams.url.getRef();
        if ("VIDEO".equals(paramFile))
        {
          paramFile = new VideoDecoder(localBaseApplicationImpl, paramURLDrawableHandler);
          paramFile = AlbumThumbManager.a(localBaseApplicationImpl).a(paramDownloadParams.url, paramFile);
          if ((paramFile == null) || (paramURLDrawableHandler == null)) {
            break;
          }
          paramURLDrawableHandler.thumbSize = paramFile.getByteCount();
          return paramFile;
        }
        if ("FLOW_THUMB".equals(paramFile))
        {
          paramFile = new FlowThumbDecoder(localBaseApplicationImpl, paramURLDrawableHandler);
          continue;
        }
        if (!"APP_VIDEO".equals(paramFile)) {
          break label152;
        }
      }
      catch (NumberFormatException paramFile)
      {
        throw new RuntimeException("Decode type is invalid");
      }
      paramFile = new AppVideoDecoder(localBaseApplicationImpl, paramURLDrawableHandler);
      continue;
      label152:
      paramFile = new ThumbDecoder(localBaseApplicationImpl, paramURLDrawableHandler);
    }
    return paramFile;
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return true;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.aI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AlbumThumbDownloader
 * JD-Core Version:    0.7.0.1
 */