package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;

public class DataLineFaceDownloader
  extends AbstractImageDownloader
{
  public static final String PROTOCOL_DATALINE_FACE = "datalineface";
  static final String TAG = "DataLineFaceDownloader";
  
  public DataLineFaceDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("DataLineFaceDownloader", paramBaseApplicationImpl);
  }
  
  public DataLineFaceDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private String compressImage(Context paramContext, String paramString)
  {
    String str = ImageUtil.b(paramContext, paramString, 0);
    ImageInfo localImageInfo = new ImageInfo();
    ImageUtil.a(4, paramContext, paramString, str, true, localImageInfo, 0);
    return localImageInfo.b;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams.tag instanceof MessageForPic)) {
      paramDownloadParams = ((MessageForPic)paramDownloadParams.tag).path;
    } else {
      paramDownloadParams = null;
    }
    if (TextUtils.isEmpty(paramDownloadParams)) {
      return null;
    }
    File localFile = new File(paramDownloadParams);
    if (localFile.exists())
    {
      Object localObject;
      if (localFile.length() >= 1048576L)
      {
        String str = compressImage(this.application.getApplicationContext(), paramDownloadParams);
        localObject = localFile;
        if (FileUtils.fileExists(str))
        {
          localObject = new File(str);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DatalineChat downloadImage compress, orgFilePath:");
          localStringBuilder.append(paramDownloadParams);
          localStringBuilder.append(" orgFileSize:");
          localStringBuilder.append(localFile.length());
          localStringBuilder.append(" compressPath:");
          localStringBuilder.append(str);
          localStringBuilder.append(" compressFileSize:");
          localStringBuilder.append(((File)localObject).length());
          QLog.i("DataLineFaceDownloader", 1, localStringBuilder.toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DatalineChat downloadImage uncompress, orgFilePath:");
        ((StringBuilder)localObject).append(paramDownloadParams);
        ((StringBuilder)localObject).append(" orgFileSize:");
        ((StringBuilder)localObject).append(localFile.length());
        QLog.i("DataLineFaceDownloader", 1, ((StringBuilder)localObject).toString());
        localObject = localFile;
      }
      copyFromFile(paramOutputStream, (File)localObject, paramURLDrawableHandler);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DataLineFaceDownloader
 * JD-Core Version:    0.7.0.1
 */