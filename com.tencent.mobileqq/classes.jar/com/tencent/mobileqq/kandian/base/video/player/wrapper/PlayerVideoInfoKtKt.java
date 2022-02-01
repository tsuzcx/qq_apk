package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TVIDEO_TYPE_ONLINE_LIVE", "", "TVIDEO_TYPE_ONLINE_VOD", "VIDEO_LIVE_FORMAT_HLS", "VIDEO_LIVE_FORMAT_UNKNOWN", "VIDEO_TYPE_LOCAL_FILE_HLS", "VIDEO_TYPE_LOCAL_FILE_MP4", "VIDEO_TYPE_LOCAL_FILE_UNKNOW", "VIDEO_VOD_FORMAT_HLS", "VIDEO_VOD_FORMAT_MP4", "VIDEO_VOD_FORMAT_UNKNOWN", "generateSPVideoInfo", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "generateTVKUserInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;", "generateTVKVideoInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;", "transformFormatForSP", "transformPlayTypeForTVK", "transformSourceForSP", "kandian-api_release"}, k=2, mv={1, 1, 16})
public final class PlayerVideoInfoKtKt
{
  private static final int a(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    int k = paramPlayerVideoInfo.a();
    int j = 1;
    int i = j;
    if (k != 1)
    {
      i = j;
      if (k != 2) {
        i = 3;
      }
    }
    return i;
  }
  
  @NotNull
  public static final SuperPlayerVideoInfo a(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerVideoInfo, "$this$generateSPVideoInfo");
    int k = a(paramPlayerVideoInfo);
    int i = 1;
    int j = 0;
    if (k == 1)
    {
      localObject = paramPlayerVideoInfo.b();
      if (localObject != null)
      {
        i = j;
        if (((CharSequence)localObject).length() > 0) {
          i = 1;
        }
        if (i == 1)
        {
          paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramPlayerVideoInfo.a(), paramPlayerVideoInfo.b());
          break label80;
        }
      }
      paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramPlayerVideoInfo.a());
      label80:
      Intrinsics.checkExpressionValueIsNotNull(paramPlayerVideoInfo, "if (pid?.isNotEmpty() ==…D_KANDIAN, vid)\n        }");
      return paramPlayerVideoInfo;
    }
    j = b(paramPlayerVideoInfo);
    String str = (String)null;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_p2p", 0) != 1) {
      i = 0;
    }
    Object localObject = str;
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      localObject = paramPlayerVideoInfo.a();
      if (localObject != null) {
        i = localObject.length;
      } else {
        i = 0;
      }
      localObject = str;
      if (i > 0)
      {
        localObject = paramPlayerVideoInfo.a();
        if (localObject != null) {
          localStringBuilder = localObject[0];
        } else {
          localStringBuilder = null;
        }
        localObject = str;
        if (localStringBuilder != null)
        {
          CharSequence localCharSequence = (CharSequence)localStringBuilder;
          localObject = str;
          if (StringsKt.contains$default(localCharSequence, (CharSequence)"com/", false, 2, null))
          {
            localObject = str;
            if (StringsKt.contains$default(localCharSequence, (CharSequence)"?", false, 2, null))
            {
              localObject = localStringBuilder.substring(StringsKt.indexOf$default(localCharSequence, "com/", 0, false, 6, null) + 4, StringsKt.indexOf$default(localCharSequence, "?", 0, false, 6, null));
              Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("generateSPVideoInfo: vid=");
      localStringBuilder.append(paramPlayerVideoInfo.a());
      localStringBuilder.append(", fileId=");
      localStringBuilder.append((String)localObject);
      QLog.d("PlayerVideoInfo", 2, localStringBuilder.toString());
    }
    paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramPlayerVideoInfo.a(), j, paramPlayerVideoInfo.a(), (String)localObject);
    Intrinsics.checkExpressionValueIsNotNull(paramPlayerVideoInfo, "SuperPlayerFactory.creat…format, duration, fileId)");
    return paramPlayerVideoInfo;
  }
  
  private static final int b(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    int i = paramPlayerVideoInfo.a();
    if (i != 3)
    {
      if (i != 4) {
        if (i == 5) {}
      }
      switch (i)
      {
      default: 
        return 103;
      case 105: 
        return 203;
      case 104: 
        return 201;
      case 103: 
        return 104;
      case 102: 
        return 102;
      }
    }
    return 101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfoKtKt
 * JD-Core Version:    0.7.0.1
 */