package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.quic.QuicResProcess;

class ShortVideoBusinessProcess
{
  static int a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.a() + " subVersion=" + "8.5.5" + " buildnum=" + "5105", null);
    String str;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      str = "new_qq_android_native_short_video_" + paramSVConfigItem.versionCode;
      if (paramSVConfigItem.name.equalsIgnoreCase(str))
      {
        if (!VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode))
        {
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode, null);
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
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInArt=" + 9, null);
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
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
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
          VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInOther=" + 1, null);
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
        return QuicResProcess.a(paramSVConfigItem);
      }
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
      {
        str = "new_qq_android_native_portrait_filter_" + paramSVConfigItem.versionCode;
        if (paramSVConfigItem.name.equalsIgnoreCase(str))
        {
          if (paramSVConfigItem.versionCode < 9)
          {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + paramSVConfigItem.versionCode + " buildInPortrait=" + 9, null);
            return -2;
          }
        }
        else {
          return -4;
        }
      }
      else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_"))
      {
        return ShortVideoTrackingResourceMgr.a(paramSVConfigItem);
      }
    }
    return 0;
  }
  
  static boolean a(AppInterface paramAppInterface, ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1 = true;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode);
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + bool2 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.supportShortVideoRecordAndPlay();
      }
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:needDownload=" + bool1 + ",itemConfig.name=" + paramSVConfigItem.name, null);
      return bool1;
      if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
        bool1 = ShortVideoArtResourceMgr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
        bool1 = ShortVideoOtherResourceMgr.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        bool1 = QuicResProcess.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        bool1 = ShortVideoPortraitResourceManager.a(paramAppInterface, paramSVConfigItem);
      } else if (paramSVConfigItem.name.startsWith("new_qq_android_native_object_tracking_")) {
        bool1 = ShortVideoTrackingResourceMgr.a(paramAppInterface, paramSVConfigItem);
      }
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.checkAndLoadAVCodec();
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return ShortVideoArtResourceMgr.a();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return ShortVideoOtherResourceMgr.a();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return QuicResProcess.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return ShortVideoPortraitResourceManager.a();
    }
    if (paramString.startsWith("new_qq_android_native_object_tracking_")) {
      return ShortVideoTrackingResourceMgr.a();
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
        return ShortVideoArtResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_short_other_")) {
        return ShortVideoOtherResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("msf_quic_lib")) {
        return QuicResProcess.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
      if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        return ShortVideoPortraitResourceManager.a(paramQQAppInterface, paramString2, paramString3, paramInt);
      }
    } while (!paramString1.startsWith("new_qq_android_native_object_tracking_"));
    return ShortVideoTrackingResourceMgr.a(paramQQAppInterface, paramString2, paramString3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBusinessProcess
 * JD-Core Version:    0.7.0.1
 */