package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.AppVideoDecoder;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.ThumbDecoder;
import com.tencent.mobileqq.activity.photo.VideoDecoder;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.MobileQQ;

public class AlbumPreviewThumbDownloader
  extends AbsDownloader
{
  public static final String ALBUM_THUMB_APP_VIDEO = "APP_VIDEO";
  public static final String ALBUM_THUMB_DEFAULT = "DEFAULT";
  public static final String ALBUM_THUMB_FLOW_THUMB = "FLOW_THUMB";
  public static final String ALBUM_THUMB_VIDEO = "VIDEO";
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (LocalMediaInfo.class.isInstance(paramDownloadParams.tag)) {
      paramURLDrawableHandler = (LocalMediaInfo)paramDownloadParams.tag;
    }
    try
    {
      paramFile = paramDownloadParams.url.getRef();
      if ("VIDEO".equals(paramFile)) {
        paramFile = new VideoDecoder(localBaseApplication, paramURLDrawableHandler);
      } else if ("FLOW_THUMB".equals(paramFile)) {
        paramFile = new FlowThumbDecoder(localBaseApplication, paramURLDrawableHandler);
      } else if ("APP_VIDEO".equals(paramFile)) {
        paramFile = new AppVideoDecoder(localBaseApplication, paramURLDrawableHandler);
      } else {
        paramFile = new ThumbDecoder(localBaseApplication, paramURLDrawableHandler);
      }
      paramFile = AlbumThumbManager.getInstance(localBaseApplication).getThumb(paramDownloadParams.url, paramFile, paramDownloadParams);
      if ((paramFile != null) && (paramURLDrawableHandler != null)) {
        paramURLDrawableHandler.thumbSize = paramFile.getByteCount();
      }
      return paramFile;
    }
    catch (NumberFormatException paramFile)
    {
      label146:
      break label146;
    }
    throw new RuntimeException("Decode type is invalid");
    throw new RuntimeException("Decode info is invalide");
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AlbumPreviewThumbDownloader
 * JD-Core Version:    0.7.0.1
 */