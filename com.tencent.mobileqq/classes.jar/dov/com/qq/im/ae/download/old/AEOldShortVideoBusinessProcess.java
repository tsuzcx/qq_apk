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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCheckNeedDownload:APPID=");
    ((StringBuilder)localObject).append(AppSetting.d());
    ((StringBuilder)localObject).append(" subVersion=");
    ((StringBuilder)localObject).append("8.8.17");
    ((StringBuilder)localObject).append(" buildnum=");
    ((StringBuilder)localObject).append("5770");
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new_qq_android_native_short_video_");
      ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
      localObject = ((StringBuilder)localObject).toString();
      if (paramSVConfigItem.name.equalsIgnoreCase((String)localObject))
      {
        if (VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode)) {
          break label624;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userCheckNeedDownload:item.versionCode=");
        ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
        return -2;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new_qq_android_native_art_filter_");
      ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
      localObject = ((StringBuilder)localObject).toString();
      if (paramSVConfigItem.name.equalsIgnoreCase((String)localObject))
      {
        if (paramSVConfigItem.versionCode >= 9) {
          break label624;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userCheckNeedDownload:item.versionCode=");
        ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
        ((StringBuilder)localObject).append(" buildInArt=");
        ((StringBuilder)localObject).append(9);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
        return -2;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_new_other_"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new_qq_android_native_short_new_other_");
      ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
      localObject = ((StringBuilder)localObject).toString();
      if (paramSVConfigItem.name.equalsIgnoreCase((String)localObject))
      {
        if (paramSVConfigItem.versionCode >= 1) {
          break label624;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userCheckNeedDownload:item.versionCode=");
        ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
        ((StringBuilder)localObject).append(" buildInOther=");
        ((StringBuilder)localObject).append(1);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
        return -2;
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new_qq_android_native_short_other_");
      ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
      localObject = ((StringBuilder)localObject).toString();
      if (paramSVConfigItem.name.equalsIgnoreCase((String)localObject))
      {
        if (paramSVConfigItem.versionCode >= 1) {
          break label624;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userCheckNeedDownload:item.versionCode=");
        ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
        ((StringBuilder)localObject).append(" buildInOther=");
        ((StringBuilder)localObject).append(1);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
        return -2;
      }
    }
    else
    {
      if (paramSVConfigItem.name.startsWith("msf_quic_lib")) {
        return AEOldQuicResProcess.a(paramSVConfigItem);
      }
      if (!paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
        break label624;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new_qq_android_native_portrait_filter_");
      ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
      localObject = ((StringBuilder)localObject).toString();
      if (paramSVConfigItem.name.equalsIgnoreCase((String)localObject))
      {
        if (paramSVConfigItem.versionCode >= 9) {
          break label624;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userCheckNeedDownload:item.versionCode=");
        ((StringBuilder)localObject).append(paramSVConfigItem.versionCode);
        ((StringBuilder)localObject).append(" buildInPortrait=");
        ((StringBuilder)localObject).append(9);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", ((StringBuilder)localObject).toString(), null);
        return -2;
      }
    }
    return -4;
    label624:
    return 0;
  }
  
  static boolean a(AppInterface paramAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    boolean bool1;
    if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_video_"))
    {
      boolean bool2 = VideoEnvironment.needDownloadCurrentServerVersion(paramSVConfigItem.versionCode);
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("userCheckNeedDownload[Builtin Mode]:needDownload=");
      paramAppInterface.append(bool2);
      paramAppInterface.append(",itemConfig.name=");
      paramAppInterface.append(paramSVConfigItem.name);
      VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramAppInterface.toString(), null);
      bool1 = bool2;
      if (bool2) {
        bool1 = VideoEnvironment.supportShortVideoRecordAndPlay();
      }
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_art_filter_"))
    {
      bool1 = AEOldShortVideoArtResourceMgr.a(paramAppInterface, paramSVConfigItem);
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_short_other_"))
    {
      bool1 = AEOldShortVideoOtherResourceMgr.a(paramAppInterface, paramSVConfigItem);
    }
    else if (paramSVConfigItem.name.startsWith("msf_quic_lib"))
    {
      bool1 = AEOldQuicResProcess.a(paramAppInterface, paramSVConfigItem);
    }
    else if (paramSVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_"))
    {
      bool1 = AEOldShortVideoPortraitResourceManager.a(paramAppInterface, paramSVConfigItem);
    }
    else
    {
      bool1 = true;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("userCheckNeedDownload:needDownload=");
    paramAppInterface.append(bool1);
    paramAppInterface.append(",itemConfig.name=");
    paramAppInterface.append(paramSVConfigItem.name);
    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", paramAppInterface.toString(), null);
    return bool1;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      return VideoEnvironment.checkAndLoadAVCodec();
    }
    if (paramString.startsWith("new_qq_android_native_art_filter_")) {
      return AEOldShortVideoArtResourceMgr.c();
    }
    if (paramString.startsWith("new_qq_android_native_short_other_")) {
      return AEOldShortVideoOtherResourceMgr.c();
    }
    if (paramString.startsWith("msf_quic_lib")) {
      return AEOldQuicResProcess.a(paramQQAppInterface);
    }
    if (paramString.startsWith("new_qq_android_native_portrait_filter_")) {
      return AEOldShortVideoPortraitResourceManager.c();
    }
    return false;
  }
  
  protected static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = false;
    if (paramString1 == null) {
      return false;
    }
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
      bool = AEOldShortVideoPortraitResourceManager.a(paramQQAppInterface, paramString2, paramString3, paramInt);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoBusinessProcess
 * JD-Core Version:    0.7.0.1
 */