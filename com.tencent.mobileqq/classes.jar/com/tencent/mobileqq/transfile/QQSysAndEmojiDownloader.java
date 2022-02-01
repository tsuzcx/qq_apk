package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class QQSysAndEmojiDownloader
  extends AbsDownloader
{
  public static final String HOST_EMOJI = "host_emoji";
  public static final String HOST_QQSYS_GIF = "host_qqsys_gif";
  public static final String HOST_QQSYS_STATIC = "host_qqsys_static";
  public static final String PROTOCOL_QQSYS_EMOJI = "qqsys_emoji";
  protected static File oldEmotionDir;
  
  protected boolean checkIsStatic(int paramInt)
  {
    return QQSysFaceUtil.isStaticFace(paramInt);
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
    return decodeBitmap(paramFile.getAbsolutePath());
  }
  
  protected Object decodeGifFile(File paramFile)
  {
    return NativeGifFactory.getNativeGifObject(paramFile, false);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url.getHost();
    String str = paramDownloadParams.url.getFile();
    paramURLDrawableHandler = new File(genResFilePath(paramOutputStream, str));
    if (paramURLDrawableHandler.exists())
    {
      paramOutputStream = paramURLDrawableHandler;
      if (QLog.isColorLevel())
      {
        QLog.d("AbsDownloader", 2, new Object[] { "found file:", str });
        paramOutputStream = paramURLDrawableHandler;
      }
    }
    int i;
    do
    {
      do
      {
        return paramOutputStream;
        paramDownloadParams = paramDownloadParams.getHeader("emoId");
        if (paramDownloadParams == null) {
          break label224;
        }
        paramDownloadParams = paramDownloadParams.getValue();
        QLog.d("AbsDownloader", 1, String.format("file[%s] not found, loading[%s], host[%s]", new Object[] { str, paramDownloadParams, paramOutputStream }));
        i = Integer.parseInt(paramDownloadParams);
        if (!"host_qqsys_gif".equals(paramOutputStream)) {
          break label226;
        }
        if (!checkIsStatic(i)) {
          break;
        }
        paramDownloadParams = new File(genResFilePath("host_qqsys_static", str.replace(".gif", ".png")));
        if (!paramDownloadParams.exists()) {
          break label217;
        }
        paramOutputStream = paramDownloadParams;
      } while (!QLog.isColorLevel());
      QLog.d("AbsDownloader", 2, new Object[] { "static file exist:", Integer.valueOf(i) });
      return paramDownloadParams;
      paramDownloadParams = getGifFileFromOldDir(i);
      paramOutputStream = paramDownloadParams;
    } while (paramDownloadParams != null);
    label217:
    needToReload(1, i);
    for (;;)
    {
      label224:
      return null;
      label226:
      if ("host_qqsys_static".equals(paramOutputStream)) {
        needToReload(1, i);
      } else if ("host_emoji".equals(paramOutputStream)) {
        needToReload(2, i);
      }
    }
  }
  
  protected String genResFilePath(String paramString1, String paramString2)
  {
    int i = 2;
    if ("host_qqsys_gif".equals(paramString1)) {
      i = 1;
    }
    for (;;)
    {
      return QQSysAndEmojiResMgr.getFullResPath(i, paramString2);
      if ("host_emoji".equals(paramString1)) {
        i = 3;
      }
    }
  }
  
  protected File getGifFileFromOldDir(int paramInt)
  {
    Object localObject = null;
    NullPointerException localNullPointerException1 = null;
    if ((paramInt >= EmotcationConstants.STATIC_SYS_EMO_GIF_RES.length) || (oldEmotionDir == null)) {}
    try
    {
      oldEmotionDir = BaseApplication.getContext().getDir("systemface", 0);
      String str = BaseApplication.getContext().getResources().getResourceEntryName(EmotcationConstants.STATIC_SYS_EMO_GIF_RES[paramInt]);
      localObject = new File(oldEmotionDir + File.separator + str);
      if (!((File)localObject).exists())
      {
        localObject = localNullPointerException1;
        if (QLog.isColorLevel())
        {
          if (localNullPointerException1 != null)
          {
            bool = true;
            QLog.d("AbsDownloader", 2, new Object[] { "getGifFileFromOldDir:", Integer.valueOf(paramInt), " ,name:", str, " ,exist:", Boolean.valueOf(bool) });
            localObject = localNullPointerException1;
          }
        }
        else {
          return localObject;
        }
      }
    }
    catch (NullPointerException localNullPointerException2)
    {
      for (;;)
      {
        QLog.e("AbsDownloader", 1, "npe while getGifFileFromOldDir!");
        continue;
        boolean bool = false;
        continue;
        localNullPointerException1 = localNullPointerException2;
      }
    }
  }
  
  protected void needToReload(int paramInt1, int paramInt2)
  {
    QQSysAndEmojiResMgr.getInstance().getResImpl(paramInt1).addReloadDrawable(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QQSysAndEmojiDownloader
 * JD-Core Version:    0.7.0.1
 */