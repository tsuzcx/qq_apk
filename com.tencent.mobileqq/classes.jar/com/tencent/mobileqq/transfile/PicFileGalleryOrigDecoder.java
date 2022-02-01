package com.tencent.mobileqq.transfile;

import ahbc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PicFileGalleryOrigDecoder
  extends ahbc
{
  public PicFileGalleryOrigDecoder(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramBaseApplicationImpl);
  }
  
  public File getFile(DownloadParams paramDownloadParams)
  {
    paramDownloadParams = paramDownloadParams.url;
    try
    {
      File localFile1 = new File(paramDownloadParams.toURI().getPath());
      return localFile1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        File localFile2 = new File(paramDownloadParams.toString().replaceFirst("filegalleryorigimage:", ""));
        return localFile2;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("URLDrawable_", 2, "LocaleFileDownloader getFile error url:" + paramDownloadParams, localException);
        }
        return null;
      }
    }
    catch (NullPointerException paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicFileGalleryOrigDecoder
 * JD-Core Version:    0.7.0.1
 */