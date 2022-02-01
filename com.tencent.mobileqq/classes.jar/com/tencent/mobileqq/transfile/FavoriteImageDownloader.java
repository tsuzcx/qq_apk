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
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
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
  public static final String PROTOCAL_FAVORITE_IMAGE = "favimage";
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
      paramURL = ((String)localObject).substring("file/".length());
    }
    do
    {
      do
      {
        return paramURL;
        if (((String)localObject).startsWith("file://")) {
          return ((String)localObject).substring(7);
        }
        paramURL = (URL)localObject;
      } while (!((String)localObject).startsWith("http"));
      paramURL = (URL)localObject;
      if (((String)localObject).startsWith("http/")) {
        paramURL = ((String)localObject).substring("http/".length());
      }
      localObject = paramURL.split("\\|");
    } while (localObject.length < 2);
    paramArrayOfString[0] = localObject[0];
    return localObject[1];
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject;
    if (paramFile == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      if (GifDrawable.isGifFile(paramFile)) {
        return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      }
      if (5 == FileManagerUtil.a(paramFile.getName()))
      {
        localObject = FileCategoryUtil.a(this.application, paramFile.getPath());
        if (localObject != null)
        {
          if ((localObject instanceof BitmapDrawable)) {
            return ((BitmapDrawable)localObject).getBitmap();
          }
          paramFile = Bitmap.createBitmap(((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight(), Bitmap.Config.RGB_565);
          paramDownloadParams = new Canvas(paramFile);
          ((Drawable)localObject).setBounds(0, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight());
          ((Drawable)localObject).draw(paramDownloadParams);
          return paramFile;
        }
      }
      localObject = paramFile.getPath();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = BitmapFactory.decodeFile((String)localObject);
        }
        catch (OutOfMemoryError paramFile)
        {
          try
          {
            int i = ((Bitmap)localObject).getByteCount();
            if (i <= 20971520) {
              continue;
            }
            paramFile = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
            return paramFile;
          }
          catch (Exception paramFile)
          {
            break label180;
          }
          catch (OutOfMemoryError paramFile)
          {
            break label169;
          }
          paramFile = paramFile;
          localObject = null;
          paramFile.printStackTrace();
          return localObject;
        }
        catch (Exception paramFile)
        {
          label169:
          localObject = null;
          label180:
          paramFile.printStackTrace();
          return localObject;
        }
      }
    }
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = new String[1];
    paramOutputStream[0] = null;
    String str1 = splitFile(paramDownloadParams.url, paramOutputStream);
    int i;
    Object localObject;
    if (paramOutputStream[0] != null)
    {
      if (new File(str1).exists()) {
        break label405;
      }
      i = 1;
      j = i;
      if (i == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
    }
    label100:
    String str3;
    try
    {
      BitmapFactory.decodeFile(str1, (BitmapFactory.Options)localObject);
      i = ((BitmapFactory.Options)localObject).outHeight;
      j = ((BitmapFactory.Options)localObject).outWidth;
      if (j + i != 0) {
        break label411;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2;
        label405:
        label411:
        i = 1;
      }
    }
    int j = i;
    if (i != 0)
    {
      new File(str1).delete();
      j = i;
    }
    if ((j != 0) && (NetworkUtil.g(this.application.getApplicationContext())))
    {
      localObject = paramDownloadParams.url;
      str2 = paramDownloadParams.urlStr;
      paramDownloadParams.url = new URL(paramOutputStream[0]);
      paramDownloadParams.urlStr = paramOutputStream[0];
      if (QLog.isDevelopLevel()) {
        QLog.d("qqfav", 4, "favimage download: " + paramOutputStream[0] + " -> " + str1);
      }
      str3 = str1 + ".tmp";
      paramOutputStream = new File(str3);
      if (paramOutputStream.exists()) {
        paramOutputStream.delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    for (;;)
    {
      try
      {
        paramOutputStream = new FileOutputStream(str3);
      }
      catch (Exception paramOutputStream)
      {
        File localFile;
        paramOutputStream = null;
      }
      try
      {
        new HttpDownloader().downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        paramOutputStream.close();
        paramURLDrawableHandler = new File(str3);
        localFile = new File(str1);
        if (!paramURLDrawableHandler.renameTo(localFile))
        {
          FileUtils.a(paramURLDrawableHandler, localFile);
          paramURLDrawableHandler.delete();
        }
        QfavReport.a(this.application.waitAppRuntime(null), false, new File(str1).length());
        paramDownloadParams.url = ((URL)localObject);
        paramDownloadParams.urlStr = str2;
        paramOutputStream = new File(str1);
        if ((!paramOutputStream.exists()) || (paramOutputStream.length() <= 0L)) {
          break label452;
        }
        return paramOutputStream;
      }
      catch (Exception paramURLDrawableHandler)
      {
        break label428;
      }
      i = 0;
      break;
      i = 0;
      break label100;
      label428:
      if (paramOutputStream != null) {
        paramOutputStream.close();
      }
      new File(str3).delete();
    }
    label452:
    paramOutputStream.delete();
    QLog.e("qqfav.FavoriteImageDownloader", 1, "downloadImage|file not exist or empty. filepath=" + str1);
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FavoriteImageDownloader
 * JD-Core Version:    0.7.0.1
 */