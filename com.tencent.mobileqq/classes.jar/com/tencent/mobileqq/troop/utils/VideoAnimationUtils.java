package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class VideoAnimationUtils
{
  private static final String a = AppConstants.SDCARD_PATH + ".troop/anim_video/";
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY), paramString1, paramString2, paramSpriteVideoView, paramOnFrameEndListener);
  }
  
  public static void a(DownloaderFactory paramDownloaderFactory, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (paramDownloaderFactory == null) {}
    Object localObject;
    do
    {
      return;
      paramSpriteVideoView = new WeakReference(paramSpriteVideoView);
      paramString1 = new File(a + paramString1);
      if (paramString1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAnimationUtils", 2, "res exists, return:" + paramString1.getAbsolutePath());
        }
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), paramOnFrameEndListener);
        return;
      }
      paramDownloaderFactory = paramDownloaderFactory.a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new DownloadTask(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (paramDownloaderFactory == null);
    paramDownloaderFactory.a(paramString2, new VideoAnimationUtils.1(paramSpriteVideoView, paramString1, paramOnFrameEndListener), (Bundle)localObject);
  }
  
  private static void b(WeakReference<SpriteVideoView> paramWeakReference, String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new VideoAnimationUtils.2(paramWeakReference, paramString, paramOnFrameEndListener));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils
 * JD-Core Version:    0.7.0.1
 */