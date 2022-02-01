package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class FavoriteImageDownloader
  extends AbstractImageDownloader
{
  private static final int MAX_BITMAP_SIZE = 20971520;
  private static final String TAG = "qqfav.FavoriteImageDownloader";
  
  public FavoriteImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("favimage", paramBaseApplicationImpl);
  }
  
  public FavoriteImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  public static File getFile(URL paramURL)
  {
    paramURL = splitFile(paramURL, new String[] { null });
    if (paramURL == null) {
      return null;
    }
    return new File(paramURL);
  }
  
  private static String splitFile(URL paramURL, String[] paramArrayOfString)
  {
    Object localObject = paramURL.getFile();
    if (((String)localObject).startsWith("file/")) {
      return ((String)localObject).substring(5);
    }
    if (((String)localObject).startsWith("file://")) {
      return ((String)localObject).substring(7);
    }
    paramURL = (URL)localObject;
    if (((String)localObject).startsWith("http"))
    {
      paramURL = (URL)localObject;
      if (((String)localObject).startsWith("http/")) {
        paramURL = ((String)localObject).substring(5);
      }
      localObject = paramURL.split("\\|");
      if (localObject.length >= 2)
      {
        paramArrayOfString[0] = localObject[0];
        paramURL = localObject[1];
      }
    }
    return paramURL;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramFile == null) {
      return null;
    }
    if (GifDrawable.isGifFile(paramFile)) {
      return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
    }
    if (5 == FileManagerUtil.a(paramFile.getName()))
    {
      localObject4 = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(this.application, paramFile.getPath());
      if (localObject4 != null)
      {
        if ((localObject4 instanceof BitmapDrawable)) {
          return ((BitmapDrawable)localObject4).getBitmap();
        }
        paramFile = Bitmap.createBitmap(((Drawable)localObject4).getIntrinsicWidth(), ((Drawable)localObject4).getIntrinsicHeight(), Bitmap.Config.RGB_565);
        paramDownloadParams = new Canvas(paramFile);
        ((Drawable)localObject4).setBounds(0, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
        ((Drawable)localObject4).draw(paramDownloadParams);
        return paramFile;
      }
    }
    Object localObject4 = paramFile.getPath();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      try
      {
        localObject1 = BitmapFactory.decodeFile((String)localObject4);
        try
        {
          int i = ((Bitmap)localObject1).getByteCount();
          if (i > 20971520)
          {
            paramFile = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
            return paramFile;
          }
          return localObject1;
        }
        catch (Exception paramDownloadParams)
        {
          paramFile = (File)localObject1;
        }
        catch (OutOfMemoryError paramDownloadParams)
        {
          paramFile = (File)localObject1;
        }
        paramDownloadParams.printStackTrace();
      }
      catch (Exception paramDownloadParams)
      {
        paramFile = localObject2;
        paramDownloadParams.printStackTrace();
        return paramFile;
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        paramFile = localObject3;
      }
      localObject1 = paramFile;
    }
    return localObject1;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = new String[1];
    paramOutputStream[0] = null;
    String str1 = splitFile(paramDownloadParams.url, paramOutputStream);
    Object localObject1;
    if (paramOutputStream[0] != null)
    {
      boolean bool1 = new File(str1).exists() ^ true;
      boolean bool2 = bool1;
      if (!bool1)
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      }
    }
    try
    {
      BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject1);
      i = ((BitmapFactory.Options)localObject1).outHeight;
      j = ((BitmapFactory.Options)localObject1).outWidth;
      if (i + j != 0) {
        i = 0;
      }
    }
    catch (Exception localException)
    {
      int i;
      int j;
      label104:
      String str2;
      Object localObject2;
      break label104;
    }
    i = 1;
    j = i;
    if (i != 0)
    {
      new File(str1).delete();
      j = i;
    }
    if ((j != 0) && (NetworkUtil.isNetworkAvailable(this.application.getApplicationContext())))
    {
      localObject1 = paramDownloadParams.url;
      str2 = paramDownloadParams.urlStr;
      paramDownloadParams.url = new URL(paramOutputStream[0]);
      paramDownloadParams.urlStr = paramOutputStream[0];
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("favimage download: ");
        ((StringBuilder)localObject2).append(paramOutputStream[0]);
        ((StringBuilder)localObject2).append(" -> ");
        ((StringBuilder)localObject2).append(str1);
        QLog.d("qqfav", 4, ((StringBuilder)localObject2).toString());
      }
      paramOutputStream = new StringBuilder();
      paramOutputStream.append(str1);
      paramOutputStream.append(".tmp");
      localObject2 = paramOutputStream.toString();
      paramOutputStream = new File((String)localObject2);
      if (paramOutputStream.exists()) {
        paramOutputStream.delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    try
    {
      paramOutputStream = new FileOutputStream((String)localObject2);
    }
    catch (Exception paramOutputStream)
    {
      File localFile;
      label373:
      label376:
      break label376;
    }
    try
    {
      new HttpDownloader().downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
      paramOutputStream.close();
      paramURLDrawableHandler = new File((String)localObject2);
      localFile = new File(str1);
      if (paramURLDrawableHandler.renameTo(localFile)) {
        break label399;
      }
      FileUtils.copyFile(paramURLDrawableHandler, localFile);
      paramURLDrawableHandler.delete();
    }
    catch (Exception paramURLDrawableHandler)
    {
      break label373;
    }
    break label378;
    paramOutputStream = null;
    label378:
    if (paramOutputStream != null) {
      paramOutputStream.close();
    }
    new File((String)localObject2).delete();
    label399:
    QfavReport.a(this.application.waitAppRuntime(null), false, new File(str1).length());
    paramDownloadParams.url = ((URL)localObject1);
    paramDownloadParams.urlStr = str2;
    paramOutputStream = new File(str1);
    if ((paramOutputStream.exists()) && (paramOutputStream.length() > 0L)) {
      return paramOutputStream;
    }
    paramOutputStream.delete();
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("downloadImage|file not exist or empty. filepath=");
    paramOutputStream.append(str1);
    QLog.e("qqfav.FavoriteImageDownloader", 1, paramOutputStream.toString());
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("File not Found. url: ");
    paramOutputStream.append(paramDownloadParams.url);
    throw new IOException(paramOutputStream.toString());
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FavoriteImageDownloader
 * JD-Core Version:    0.7.0.1
 */