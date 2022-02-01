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
  extends ChatImageDownloader
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
    if ((paramDownloadParams.tag instanceof MessageForPic)) {}
    for (paramDownloadParams = ((MessageForPic)paramDownloadParams.tag).path;; paramDownloadParams = null)
    {
      if (TextUtils.isEmpty(paramDownloadParams)) {}
      File localFile1;
      do
      {
        return null;
        localFile1 = new File(paramDownloadParams);
      } while (!localFile1.exists());
      File localFile2;
      if (localFile1.length() >= 1048576L)
      {
        String str = compressImage(this.application.getApplicationContext(), paramDownloadParams);
        if (!FileUtils.a(str)) {
          break label203;
        }
        localFile2 = new File(str);
        QLog.i("DataLineFaceDownloader", 1, "DatalineChat downloadImage compress, orgFilePath:" + paramDownloadParams + " orgFileSize:" + localFile1.length() + " compressPath:" + str + " compressFileSize:" + localFile2.length());
      }
      label203:
      for (paramDownloadParams = localFile2;; paramDownloadParams = localFile1)
      {
        ChatImageDownloader.copyFromFile(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        return null;
        QLog.i("DataLineFaceDownloader", 1, "DatalineChat downloadImage uncompress, orgFilePath:" + paramDownloadParams + " orgFileSize:" + localFile1.length());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DataLineFaceDownloader
 * JD-Core Version:    0.7.0.1
 */