package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class QZoneRecentPhotoDownloader
  extends AbsDownloader
{
  public static final String PROTOCOL_TROOP_PHOTO_QZONE = "troop_photo_qzone";
  public static final String TAG = "Q.QZoneRecentPhotoDownloader";
  
  private String dealHost(String paramString)
  {
    int j = paramString.length();
    int i = paramString.indexOf('[');
    if (i == 0) {
      i += 1;
    } else {
      i = 0;
    }
    int k = paramString.lastIndexOf(']');
    if (k == paramString.length() - 1) {
      j = k;
    }
    paramString = paramString.substring(i, j);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealHost|host = ");
      localStringBuilder.append(paramString);
      QLog.i("Q.QZoneRecentPhotoDownloader", 2, localStringBuilder.toString());
    }
    return paramString;
  }
  
  private static Bitmap imageCrop(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      int i;
      if (k > m) {
        i = m;
      } else {
        i = k;
      }
      int j;
      if (k > m) {
        j = (k - m) / 2;
      } else {
        j = 0;
      }
      if (k > m) {
        k = 0;
      } else {
        k = (m - k) / 2;
      }
      return Bitmap.createBitmap(paramBitmap, j, k, i, i, null, false);
    }
    return null;
  }
  
  private void realDownload(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadPhoto|filePath = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", url = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.i("Q.QZoneRecentPhotoDownloader", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("_temp");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new File((String)localObject2);
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    File localFile = ((File)localObject1).getParentFile();
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    if (HttpDownloadUtil.download(null, MsfSdkUtils.insertMtype("qzone", paramString2), (File)localObject1))
    {
      try
      {
        paramString2 = BitmapFactory.decodeFile((String)localObject2);
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      catch (OutOfMemoryError paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString2 = null;
      paramString2 = imageCrop(paramString2);
      if (paramString2 != null)
      {
        paramString1 = new File(paramString1);
        if (paramString1.exists()) {
          paramString1.delete();
        }
        localObject2 = paramString1.getParentFile();
        if ((localObject2 != null) && (!((File)localObject2).exists())) {
          ((File)localObject2).mkdirs();
        }
        try
        {
          paramString1 = new FileOutputStream(paramString1);
        }
        catch (FileNotFoundException paramString1)
        {
          paramString1.printStackTrace();
          paramString1 = null;
        }
        if (paramString1 != null)
        {
          paramString2.compress(Bitmap.CompressFormat.JPEG, 70, paramString1);
          try
          {
            paramString1.flush();
            paramString1.close();
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
          }
        }
      }
      ((File)localObject1).delete();
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawableHandler = new StringBuilder();
      paramURLDrawableHandler.append("decodeFile| f = ");
      paramURLDrawableHandler.append(paramFile);
      QLog.i("Q.QZoneRecentPhotoDownloader", 2, paramURLDrawableHandler.toString());
    }
    if (paramFile == null) {
      paramFile = null;
    } else {
      paramFile = paramFile.getPath();
    }
    paramURLDrawableHandler = paramFile;
    if (TextUtils.isEmpty(paramFile))
    {
      paramURLDrawableHandler = paramFile;
      if (paramDownloadParams != null)
      {
        paramURLDrawableHandler = paramFile;
        if (paramDownloadParams.url != null) {
          paramURLDrawableHandler = paramDownloadParams.url.getPath();
        }
      }
    }
    if (!TextUtils.isEmpty(paramURLDrawableHandler)) {
      try
      {
        paramFile = BitmapFactory.decodeFile(paramURLDrawableHandler);
        return paramFile;
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      catch (OutOfMemoryError paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url;
    if ((paramOutputStream != null) && (Utils.a(paramOutputStream.getProtocol(), "troop_photo_qzone")))
    {
      paramURLDrawableHandler = paramOutputStream.getFile();
      paramDownloadParams = new File(paramURLDrawableHandler);
      String str = paramOutputStream.getHost();
      if (QLog.isColorLevel())
      {
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage| path = ");
        paramOutputStream.append(paramURLDrawableHandler);
        paramOutputStream.append(", host = ");
        paramOutputStream.append(str);
        QLog.i("Q.QZoneRecentPhotoDownloader", 2, paramOutputStream.toString());
      }
      if (paramDownloadParams.exists())
      {
        paramOutputStream = paramDownloadParams;
        if (paramDownloadParams.length() > 0L) {}
      }
      else
      {
        paramOutputStream = paramDownloadParams;
        if (str != null)
        {
          realDownload(paramURLDrawableHandler, dealHost(str));
          return paramDownloadParams;
        }
      }
    }
    else
    {
      paramOutputStream = null;
    }
    return paramOutputStream;
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QZoneRecentPhotoDownloader
 * JD-Core Version:    0.7.0.1
 */