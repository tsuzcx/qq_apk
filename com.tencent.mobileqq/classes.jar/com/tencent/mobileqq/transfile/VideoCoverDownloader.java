package com.tencent.mobileqq.transfile;

import aisb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.io.OutputStream;

public class VideoCoverDownloader
  extends AbsDownloader
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.aI);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return AlbumThumbManager.a(BaseApplicationImpl.getContext()).a(paramDownloadParams.url, new aisb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VideoCoverDownloader
 * JD-Core Version:    0.7.0.1
 */