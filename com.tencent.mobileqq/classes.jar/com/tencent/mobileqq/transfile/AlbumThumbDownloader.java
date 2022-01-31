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
import java.io.File;
import java.net.URL;

public class AlbumThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public static final String ALBUM_THUMB_APP_VIDEO = "APP_VIDEO";
  public static final String ALBUM_THUMB_DEFAULT = "DEFAULT";
  public static final String ALBUM_THUMB_FLOW_THUMB = "FLOW_THUMB";
  public static final String ALBUM_THUMB_PROTOCAL = "AlbumThumb";
  public static final String ALBUM_THUMB_VIDEO = "VIDEO";
  public static int THUMB_WIDHT = 200;
  
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
          paramFile = AlbumThumbManager.getInstance(localBaseApplicationImpl).getThumb(paramDownloadParams.url, paramFile, paramDownloadParams);
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
          break label153;
        }
      }
      catch (NumberFormatException paramFile)
      {
        throw new RuntimeException("Decode type is invalid");
      }
      paramFile = new AppVideoDecoder(localBaseApplicationImpl, paramURLDrawableHandler);
      continue;
      label153:
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
    return new File("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AlbumThumbDownloader
 * JD-Core Version:    0.7.0.1
 */