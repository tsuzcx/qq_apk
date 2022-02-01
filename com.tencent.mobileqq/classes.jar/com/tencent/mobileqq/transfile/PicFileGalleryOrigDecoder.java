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
    try
    {
      localObject = localURL.getFile();
      paramDownloadParams = (DownloadParams)localObject;
      if (!FileUtils.fileExists((String)localObject)) {
        paramDownloadParams = localURL.toURI().getPath();
      }
      paramDownloadParams = new File(paramDownloadParams);
      return paramDownloadParams;
    }
    catch (NullPointerException paramDownloadParams)
    {
      Object localObject;
      paramDownloadParams.printStackTrace();
      return null;
      try
      {
        paramDownloadParams = new File(localURL.toString().replaceFirst("filegalleryorigimage:", ""));
        return paramDownloadParams;
      }
      catch (Exception paramDownloadParams)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("LocaleFileDownloader getFile error url:");
          ((StringBuilder)localObject).append(localURL);
          QLog.e("URLDrawable_", 2, ((StringBuilder)localObject).toString(), paramDownloadParams);
        }
        return null;
      }
    }
    catch (URISyntaxException paramDownloadParams)
    {
      label45:
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicFileGalleryOrigDecoder
 * JD-Core Version:    0.7.0.1
 */