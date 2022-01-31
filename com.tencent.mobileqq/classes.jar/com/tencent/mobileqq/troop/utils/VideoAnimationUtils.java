package com.tencent.mobileqq.troop.utils;

import ajri;
import ajrj;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private static final String a = AppConstants.aJ + ".troop/hw_anim_video/";
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SpriteVideoView paramSpriteVideoView, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAnimationUtilsQ.nearby.video_chat.gift", 2, "startDownloadAnimRes");
    }
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      return;
      paramSpriteVideoView = new WeakReference(paramSpriteVideoView);
      paramString1 = new File(a + paramString1);
      if (paramString1.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAnimationUtilsQ.nearby.video_chat.gift", 2, "res exists, return:" + paramString1.getAbsolutePath());
        }
        b(paramSpriteVideoView, paramString1.getAbsolutePath(), paramOnFrameEndListener);
        return;
      }
      paramQQAppInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString2 = new DownloadTask(paramString2, paramString1);
      paramString2.b = 2;
      localObject = new Bundle();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramString2, new ajri(paramSpriteVideoView, paramString1, paramOnFrameEndListener), (Bundle)localObject);
  }
  
  private static void b(WeakReference paramWeakReference, String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (paramWeakReference != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAnimationUtils", 2, "playVideoAnim");
      }
      if ((SpriteVideoView)paramWeakReference.get() != null) {
        ThreadManager.getUIHandler().post(new ajrj(paramWeakReference, paramString, paramOnFrameEndListener));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils
 * JD-Core Version:    0.7.0.1
 */