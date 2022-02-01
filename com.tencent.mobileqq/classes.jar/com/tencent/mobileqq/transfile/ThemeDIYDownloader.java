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
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.vas.util.VasUtil;
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
  public static final String HEADER_ID = "my_id";
  public static final String HEADER_PAGEINDEX = "page_index";
  public static final String HEADER_TYPE = "my_type";
  public static final String HEADER_UIN = "my_uin";
  public static final String PROTOCAL_THEME_DIY_PIC = "themediydownloader";
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return null;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramDownloadParams.useApngImage) && (ChatBackgroundManager.a(paramFile)))
    {
      paramDownloadParams = new Bundle();
      paramDownloadParams.putBoolean("key_use_rect", true);
      paramDownloadParams.putBoolean("key_double_bitmap", true);
      paramDownloadParams.putIntArray("key_tagId_arr", new int[] { 0 });
      paramDownloadParams = new ApngImage(paramFile, true, paramDownloadParams);
      if (paramDownloadParams.firstFrame == null) {
        ChatBackgroundManager.a(paramFile.getAbsolutePath());
      }
      return paramDownloadParams;
    }
    paramDownloadParams.useApngImage = false;
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url.getFile();
    String str = paramDownloadParams.url.getHost();
    Object localObject1 = paramOutputStream;
    if (paramOutputStream.startsWith(File.separator)) {
      localObject1 = paramOutputStream.substring(1);
    }
    paramURLDrawableHandler = new File(str);
    boolean bool = paramURLDrawableHandler.exists();
    Object localObject2 = null;
    int j = 0;
    if (bool) {}
    Object localObject3;
    for (;;)
    {
      i = 1;
      break label567;
      paramOutputStream = new File(QQSharpPUtil.b(paramURLDrawableHandler));
      bool = paramDownloadParams.useSharpPImage;
      if ((bool) && (paramOutputStream.exists()))
      {
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("downloadImage shpFile.exists url=");
          paramDownloadParams.append((String)localObject1);
          paramDownloadParams.append(", path=");
          paramDownloadParams.append(str);
          QLog.d("themediydownloader", 2, paramDownloadParams.toString());
        }
        return paramOutputStream;
      }
      if (QLog.isColorLevel())
      {
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage download url=");
        paramOutputStream.append((String)localObject1);
        paramOutputStream.append(", path=");
        paramOutputStream.append(str);
        paramOutputStream.append(", isSharpPAv=");
        paramOutputStream.append(bool);
        QLog.d("themediydownloader", 2, paramOutputStream.toString());
      }
      paramOutputStream = new DownloadTask((String)localObject1, paramURLDrawableHandler);
      paramOutputStream.E = bool;
      if (DownloaderFactory.a(paramOutputStream, BaseApplicationImpl.sApplication.getRuntime()) != 0) {
        break;
      }
      if ((paramURLDrawableHandler.exists()) && (!SignatureManager.c(paramURLDrawableHandler.getAbsolutePath())))
      {
        paramURLDrawableHandler.delete();
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage file Error url=");
        paramOutputStream.append((String)localObject1);
        paramOutputStream.append(", path=");
        paramOutputStream.append(str);
        QLog.e("themediydownloader", 1, paramOutputStream.toString());
        paramOutputStream = null;
      }
      else
      {
        paramOutputStream = paramURLDrawableHandler;
        if (SharpPUtil.isSharpPFile(paramURLDrawableHandler)) {
          paramOutputStream = QQSharpPUtil.a(paramURLDrawableHandler);
        }
      }
      if ((paramDownloadParams.mExtraInfo instanceof Integer)) {
        try
        {
          i = Integer.parseInt(String.valueOf(paramDownloadParams.mExtraInfo));
        }
        catch (Exception paramURLDrawableHandler)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("downloadImage parseInt Error:");
          ((StringBuilder)localObject3).append(paramURLDrawableHandler.getMessage());
          QLog.e("themediydownloader", 1, ((StringBuilder)localObject3).toString());
        }
      } else {
        i = 0;
      }
      paramURLDrawableHandler = new StringBuilder();
      paramURLDrawableHandler.append("downloadImage onPostThemeChanged pageIndex: ");
      paramURLDrawableHandler.append(i);
      paramURLDrawableHandler.append(", needUpdateThemeForBg=");
      paramURLDrawableHandler.append(ThemeBackground.f);
      QLog.i("themediydownloader", 1, paramURLDrawableHandler.toString());
      paramURLDrawableHandler = paramOutputStream;
      if (ThemeBackground.f)
      {
        paramURLDrawableHandler = paramOutputStream;
        if (100 == i)
        {
          ThemeBackground.f = false;
          paramURLDrawableHandler = new Intent("com.tencent.qplus.THEME_INVALIDATE");
          paramURLDrawableHandler.putExtra("pid", Process.myPid());
          BaseApplicationImpl.sApplication.sendBroadcast(paramURLDrawableHandler, "com.tencent.msg.permission.pushnotify");
          paramURLDrawableHandler = paramOutputStream;
        }
      }
    }
    paramURLDrawableHandler = new File(AppConstants.SDCARD_PATH);
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("downloadImage Error url=");
    paramOutputStream.append((String)localObject1);
    paramOutputStream.append(", path=");
    paramOutputStream.append(str);
    QLog.e("themediydownloader", 1, paramOutputStream.toString());
    int i = 0;
    label567:
    paramOutputStream = paramDownloadParams.getHeader("my_uin");
    if (paramOutputStream != null) {}
    for (;;)
    {
      try
      {
        paramOutputStream = paramOutputStream.getValue();
        paramOutputStream = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramOutputStream);
        IThemeSwitchManager localIThemeSwitchManager = VasUtil.a().getThemeSwitchManager();
        if (localIThemeSwitchManager.getstyleCallBack() != null)
        {
          Header localHeader = paramDownloadParams.getHeader("my_id");
          localObject3 = new ResData();
          paramOutputStream = localObject2;
          if (localHeader != null) {
            paramOutputStream = localHeader.getValue();
          }
          ((ResData)localObject3).b = paramOutputStream;
          ((ResData)localObject3).d = str;
          ((ResData)localObject3).e = ((String)localObject1);
          paramOutputStream = paramDownloadParams.getHeader("my_type");
          if (paramOutputStream != null) {
            j = Integer.parseInt(paramOutputStream.getValue());
          }
          ((ResData)localObject3).g = j;
          paramOutputStream = new Bundle();
          paramDownloadParams = paramDownloadParams.getHeader("page_index");
          if (paramDownloadParams == null) {
            break label812;
          }
          j = Integer.parseInt(paramDownloadParams.getValue());
          paramOutputStream.putInt("page_index", j);
          paramDownloadParams = localIThemeSwitchManager.getstyleCallBack();
          if (i == 0) {
            break label818;
          }
          i = 4;
          paramDownloadParams.a(18, i, paramOutputStream, (ResData)localObject3);
          return paramURLDrawableHandler;
        }
      }
      catch (Exception paramOutputStream)
      {
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("downloadImage Error:");
        paramDownloadParams.append(paramOutputStream.getMessage());
        QLog.e("themediydownloader", 1, paramDownloadParams.toString());
      }
      return paramURLDrawableHandler;
      label812:
      j = -1;
      continue;
      label818:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ThemeDIYDownloader
 * JD-Core Version:    0.7.0.1
 */