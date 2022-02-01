package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.activity.aio.photo.PhotoDecoder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PicFileGalleryOrigDecoder
  extends PhotoDecoder
{
  public PicFileGalleryOrigDecoder(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramBaseApplicationImpl);
  }
  
  public File getFile(DownloadParams paramDownloadParams)
  {
    URL localURL = paramDownloadParams.url;
    for (;;)
    {
      try
      {
        paramDownloadParams = localURL.getFile();
        if (!FileUtils.a(paramDownloadParams))
        {
          paramDownloadParams = localURL.toURI().getPath();
          paramDownloadParams = new File(paramDownloadParams);
          return paramDownloadParams;
        }
      }
      catch (URISyntaxException paramDownloadParams)
      {
        try
        {
          paramDownloadParams = new File(localURL.toString().replaceFirst("filegalleryorigimage:", ""));
          return paramDownloadParams;
        }
        catch (Exception paramDownloadParams)
        {
          if (QLog.isColorLevel()) {
            QLog.e("URLDrawable_", 2, "LocaleFileDownloader getFile error url:" + localURL, paramDownloadParams);
          }
          return null;
        }
      }
      catch (NullPointerException paramDownloadParams)
      {
        paramDownloadParams.printStackTrace();
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicFileGalleryOrigDecoder
 * JD-Core Version:    0.7.0.1
 */