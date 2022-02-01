package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.jetbrains.annotations.NotNull;

public class QQSysAndEmojiDownloader
  extends AbsDownloader
{
  public static final String HOST_EMOJI = "host_emoji";
  public static final String HOST_QQSYS_APNG = "host_qqsys_apng";
  public static final String HOST_QQSYS_GIF = "host_qqsys_gif";
  public static final String HOST_QQSYS_STATIC = "host_qqsys_static";
  public static final String PROTOCOL_QQSYS_EMOJI = "qqsys_emoji";
  public static final String REPORT_APNG_EMOTICON = "EmoticonApngReport";
  protected static File oldEmotionDir;
  
  @NotNull
  private File getResFile(String paramString1, String paramString2)
  {
    if ((paramString2.endsWith(".gif")) && ("host_qqsys_gif".equals(paramString1)))
    {
      File localFile = new File(genResFilePath("host_qqsys_apng", paramString2.replace(".gif", ".png")));
      if (!localFile.exists()) {
        return new File(genResFilePath(paramString1, paramString2));
      }
      paramString1 = localFile;
      if (QLog.isColorLevel())
      {
        QLog.d("AbsDownloader", 2, new Object[] { "found apng file: ", paramString2 });
        return localFile;
      }
    }
    else
    {
      paramString1 = new File(genResFilePath(paramString1, paramString2));
    }
    return paramString1;
  }
  
  protected boolean checkIsStatic(int paramInt)
  {
    return QQSysFaceUtil.isStaticFace(paramInt);
  }
  
  protected Object decodeApngImage(File paramFile)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeFile isAPNGFile, path = ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      QLog.d("AbsDownloader", 2, localStringBuilder.toString());
    }
    paramFile = new ApngImage(paramFile, true, null);
    paramFile.setDensity(320);
    return paramFile;
  }
  
  protected Object decodeBitmap(String paramString)
  {
    return BitmapFactory.decodeFile(paramString);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramFile == null) {
      return null;
    }
    if (GifDrawable.isGifFile(paramFile)) {
      return decodeGifFile(paramFile);
    }
    if ((paramDownloadParams != null) && (("host_qqsys_gif".equals(paramDownloadParams.url.getHost())) || ("host_qqsys_apng".equals(paramDownloadParams.url.getHost()))) && (isApngFile(paramFile))) {
      try
      {
        paramDownloadParams = decodeApngImage(paramFile);
        return paramDownloadParams;
      }
      catch (Throwable paramDownloadParams)
      {
        QLog.e("AbsDownloader", 2, paramDownloadParams, new Object[0]);
        reportEmoticonApngFailEvent(paramDownloadParams.toString(), paramFile.getName());
        return decodeBitmap(paramFile.getAbsolutePath());
      }
    }
    return decodeBitmap(paramFile.getAbsolutePath());
  }
  
  protected Object decodeGifFile(File paramFile)
  {
    return NativeGifFactory.getNativeGifObject(paramFile, false);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url.getHost();
    paramURLDrawableHandler = paramDownloadParams.url.getFile();
    File localFile = getResFile(paramOutputStream, paramURLDrawableHandler);
    if (localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsDownloader", 2, new Object[] { "found file:", paramURLDrawableHandler });
      }
      return localFile;
    }
    paramDownloadParams = paramDownloadParams.getHeader("emoId");
    if (paramDownloadParams != null)
    {
      paramDownloadParams = paramDownloadParams.getValue();
      QLog.d("AbsDownloader", 1, String.format("file[%s] not found, loading[%s], host[%s]", new Object[] { paramURLDrawableHandler, paramDownloadParams, paramOutputStream }));
      int i = Integer.parseInt(paramDownloadParams);
      if ("host_qqsys_gif".equals(paramOutputStream))
      {
        if (checkIsStatic(i))
        {
          paramOutputStream = new File(genResFilePath("host_qqsys_static", paramURLDrawableHandler.replace(".gif", ".png")));
          if (paramOutputStream.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("AbsDownloader", 2, new Object[] { "static file exist:", Integer.valueOf(i) });
            }
            return paramOutputStream;
          }
        }
        else
        {
          paramOutputStream = getGifFileFromOldDir(i);
          if (paramOutputStream != null) {
            return paramOutputStream;
          }
        }
        needToReload(1, i);
      }
      else if ("host_qqsys_static".equals(paramOutputStream))
      {
        needToReload(1, i);
      }
      else if ("host_emoji".equals(paramOutputStream))
      {
        needToReload(2, i);
      }
    }
    return null;
  }
  
  protected String genResFilePath(String paramString1, String paramString2)
  {
    int i;
    if ("host_qqsys_gif".equals(paramString1)) {
      i = 1;
    } else if ("host_emoji".equals(paramString1)) {
      i = 3;
    } else if ("host_qqsys_apng".equals(paramString1)) {
      i = 4;
    } else {
      i = 2;
    }
    return QQSysAndEmojiResMgr.getFullResPath(i, paramString2);
  }
  
  protected File getGifFileFromOldDir(int paramInt)
  {
    int i = EmotcationConstants.STATIC_SYS_EMO_GIF_RES.length;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool;
    if (paramInt < i)
    {
      localObject2 = oldEmotionDir;
      bool = true;
      if (localObject2 != null) {}
    }
    try
    {
      oldEmotionDir = BaseApplication.getContext().getDir("systemface", 0);
    }
    catch (NullPointerException localNullPointerException)
    {
      label43:
      String str;
      break label43;
    }
    QLog.e("AbsDownloader", 1, "npe while getGifFileFromOldDir!");
    str = BaseApplication.getContext().getResources().getResourceEntryName(EmotcationConstants.STATIC_SYS_EMO_GIF_RES[paramInt]);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(oldEmotionDir);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(str);
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject2).exists()) {
      localObject1 = localObject2;
    }
    localObject2 = localObject1;
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        bool = false;
      }
      QLog.d("AbsDownloader", 2, new Object[] { "getGifFileFromOldDir:", Integer.valueOf(paramInt), " ,name:", str, " ,exist:", Boolean.valueOf(bool) });
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  protected boolean isApngFile(File paramFile)
  {
    return ApngDrawable.isApngFile(paramFile);
  }
  
  protected void needToReload(int paramInt1, int paramInt2)
  {
    QQSysAndEmojiResMgr.getInstance().getResImpl(paramInt1).addReloadDrawable(paramInt2);
  }
  
  protected void reportEmoticonApngFailEvent(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("error_msg", paramString1);
    localHashMap.put("error_res_file", paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "EmoticonApngReport", false, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QQSysAndEmojiDownloader
 * JD-Core Version:    0.7.0.1
 */