package dov.com.qq.im.ae.download.old;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class AEOldShortVideoBusinessProcess
{
  static int a(AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:APPID=" + AppSetting.a() + " subVersion=" + "8.5.5" + " buildnum=" + "5105", null);
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (!VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode))
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_"))
    {
      str = "new_qq_android_native_art_filter_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 9)
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 9, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_new_other_"))
    {
      str = "new_qq_android_native_short_new_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_"))
    {
      str = "new_qq_android_native_short_other_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (paramSVConfigItem.versionCode < 1)
        {
          VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
          return -2;
        }
      }
      else {
        return -4;
      }
    }
    else
    {
      if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        return AEOldQuicResProcess.a(paramSVConfigItem);
      }
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
      {
        str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
        if (paramSVConfigItem.name.equalsIgnoreCase(str))
        {
          if (paramSVConfigItem.versionCode < 9)
          {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPortrait=" + 9, null);
            return -2;
          }
        }
        else {
          return -4;
        }
      }
      else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_"))
      {
        return AEOldShortVideoTrackingResourceMgr.a(paramSVConfigItem);
      }
    }
    return 0;
  }
  
  static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1 = true;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + bool2 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.supportShortVideoRecordAndPlay();
      }
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:needDownload=" + bool1 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      return bool1;
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = AEOldShortVideoArtResourceMgr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = AEOldShortVideoOtherResourceMgr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = AEOldQuicResProcess.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = AEOldShortVideoPortraitResourceManager.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = AEOldShortVideoTrackingResourceMgr.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.checkAndLoadAVCodec();
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return AEOldShortVideoArtResourceMgr.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return AEOldShortVideoOtherResourceMgr.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return AEOldQuicResProcess.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return AEOldShortVideoPortraitResourceManager.a();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return AEOldShortVideoTrackingResourceMgr.a();
    }
    return false;
  }
  
  protected static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 == null) {}
    do
    {
      return false;
      if (paramString1.startsWith("new_qq_android_native_short_video_")) {
        return ShortVideoSoCompressUtil.a(paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        return AEOldShortVideoArtResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return AEOldShortVideoOtherResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("msf_quic_lib")) {
        return AEOldQuicResProcess.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        return AEOldShortVideoPortraitResourceManager.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
    } while (!paramString1.startsWith("new_qq_android_native_object_tracking_"));
    return AEOldShortVideoTrackingResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoBusinessProcess
 * JD-Core Version:    0.7.0.1
 */