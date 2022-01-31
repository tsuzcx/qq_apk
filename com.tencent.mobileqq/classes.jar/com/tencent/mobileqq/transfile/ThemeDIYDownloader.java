package com.tencent.mobileqq.transfile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class ThemeDIYDownloader
  extends AbsDownloader
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject2 = null;
    int j = 0;
    paramURLDrawableHandler = paramDownloadParams.url.getFile();
    String str = paramDownloadParams.url.getHost();
    if (paramURLDrawableHandler.startsWith(File.separator))
    {
      paramURLDrawableHandler = paramURLDrawableHandler.substring(1);
      for (;;)
      {
        Object localObject1 = new File(str);
        int i;
        Object localObject3;
        if (((File)localObject1).exists())
        {
          i = 1;
          paramOutputStream = (OutputStream)localObject1;
          localObject3 = paramDownloadParams.getHeader("my_uin");
          localObject1 = paramOutputStream;
          if (localObject3 == null) {}
        }
        try
        {
          localObject1 = ((Header)localObject3).getValue();
          localObject3 = (ThemeSwitchManager)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime((String)localObject1)).getManager(184);
          localObject1 = paramOutputStream;
          ResData localResData;
          if (((ThemeSwitchManager)localObject3).a != null)
          {
            Header localHeader = paramDownloadParams.getHeader("my_id");
            localResData = new ResData();
            localObject1 = localObject2;
            if (localHeader != null) {
              localObject1 = localHeader.getValue();
            }
            localResData.id = ((String)localObject1);
            localResData.path = str;
            localResData.url = paramURLDrawableHandler;
            paramURLDrawableHandler = paramDownloadParams.getHeader("my_type");
            if (paramURLDrawableHandler != null) {
              j = Integer.parseInt(paramURLDrawableHandler.getValue());
            }
            localResData.type = j;
            paramURLDrawableHandler = new Bundle();
            paramDownloadParams = paramDownloadParams.getHeader("page_index");
            if (paramDownloadParams == null) {
              break label733;
            }
            j = Integer.parseInt(paramDownloadParams.getValue());
            label236:
            paramURLDrawableHandler.putInt("page_index", j);
            paramDownloadParams = ((ThemeSwitchManager)localObject3).a;
            if (i == 0) {
              break label739;
            }
          }
          label674:
          label733:
          label739:
          for (i = 4;; i = 8)
          {
            paramDownloadParams.callback(18, i, paramURLDrawableHandler, localResData);
            localObject1 = paramOutputStream;
            boolean bool;
            do
            {
              return localObject1;
              paramOutputStream = new File(QQSharpPUtil.a((File)localObject1));
              bool = paramDownloadParams.useSharpPImage;
              if ((!bool) || (!paramOutputStream.exists())) {
                break;
              }
              localObject1 = paramOutputStream;
            } while (!QLog.isColorLevel());
            QLog.d("themediydownloader", 2, "downloadImage shpFile.exists url=" + paramURLDrawableHandler + ", path=" + str);
            return paramOutputStream;
            if (QLog.isColorLevel()) {
              QLog.d("themediydownloader", 2, "downloadImage download url=" + paramURLDrawableHandler + ", path=" + str + ", isSharpPAv=" + bool);
            }
            paramOutputStream = new DownloadTask(paramURLDrawableHandler, (File)localObject1);
            paramOutputStream.i = bool;
            paramOutputStream.n = false;
            if (DownloaderFactory.a(paramOutputStream, BaseApplicationImpl.sApplication.getRuntime()) == 0)
            {
              if ((((File)localObject1).exists()) && (!SignatureManager.a(((File)localObject1).getAbsolutePath())))
              {
                ((File)localObject1).delete();
                QLog.e("themediydownloader", 1, "downloadImage file Error url=" + paramURLDrawableHandler + ", path=" + str);
                paramOutputStream = null;
                label503:
                if (!(paramDownloadParams.mExtraInfo instanceof Integer)) {
                  break label674;
                }
              }
              for (;;)
              {
                try
                {
                  i = Integer.parseInt(String.valueOf(paramDownloadParams.mExtraInfo));
                  if (QLog.isColorLevel()) {
                    QLog.i("themediydownloader", 2, "downloadImage onPostThemeChanged pageIndex: " + i + ", needUpdateThemeForBg=" + ThemeBackground.needUpdateThemeForBg);
                  }
                  if ((ThemeBackground.needUpdateThemeForBg) && (100 == i))
                  {
                    ThemeBackground.needUpdateThemeForBg = false;
                    localObject1 = new Intent("com.tencent.qplus.THEME_INVALIDATE");
                    ((Intent)localObject1).putExtra("pid", Process.myPid());
                    BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
                  }
                  i = 1;
                }
                catch (Exception localException)
                {
                  QLog.e("themediydownloader", 1, "downloadImage parseInt Error:" + localException.getMessage());
                }
                paramOutputStream = (OutputStream)localObject1;
                if (!SharpPUtil.isSharpPFile((File)localObject1)) {
                  break label503;
                }
                paramOutputStream = QQSharpPUtil.a((File)localObject1);
                break label503;
                i = 0;
              }
            }
            paramOutputStream = new File(AppConstants.aJ);
            QLog.e("themediydownloader", 1, "downloadImage Error url=" + paramURLDrawableHandler + ", path=" + str);
            i = 0;
            break;
            j = -1;
            break label236;
          }
        }
        catch (Exception paramDownloadParams)
        {
          QLog.e("themediydownloader", 1, "downloadImage Error:" + paramDownloadParams.getMessage());
          return paramOutputStream;
        }
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    if (paramDownloadParams == null) {
      paramDownloadParams = paramURLDrawableHandler;
    }
    do
    {
      return paramDownloadParams;
      if ((paramFile == null) || (!paramFile.exists()) || (!paramDownloadParams.useApngImage) || (!ChatBackgroundManager.a(paramFile))) {
        break;
      }
      paramDownloadParams = new Bundle();
      paramDownloadParams.putBoolean("key_use_rect", true);
      paramDownloadParams.putBoolean("key_double_bitmap", true);
      paramDownloadParams.putIntArray("key_tagId_arr", new int[] { 0 });
      paramURLDrawableHandler = new ApngImage(paramFile, true, paramDownloadParams);
      paramDownloadParams = paramURLDrawableHandler;
    } while (paramURLDrawableHandler.firstFrame != null);
    ChatBackgroundManager.a(paramFile.getAbsolutePath());
    return paramURLDrawableHandler;
    paramDownloadParams.useApngImage = false;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ThemeDIYDownloader
 * JD-Core Version:    0.7.0.1
 */