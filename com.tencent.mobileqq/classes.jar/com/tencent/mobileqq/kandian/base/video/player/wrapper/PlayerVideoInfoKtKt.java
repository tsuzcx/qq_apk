package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TVIDEO_TYPE_ONLINE_LIVE", "", "TVIDEO_TYPE_ONLINE_VOD", "VIDEO_LIVE_FORMAT_HLS", "VIDEO_LIVE_FORMAT_UNKNOWN", "VIDEO_TYPE_LOCAL_FILE_HLS", "VIDEO_TYPE_LOCAL_FILE_MP4", "VIDEO_TYPE_LOCAL_FILE_UNKNOW", "VIDEO_VOD_FORMAT_HLS", "VIDEO_VOD_FORMAT_MP4", "VIDEO_VOD_FORMAT_UNKNOWN", "generateSPVideoInfo", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "transformFormatForSP", "transformSourceForSP", "kandian-api_release"}, k=2, mv={1, 1, 16})
public final class PlayerVideoInfoKtKt
{
  @NotNull
  public static final SuperPlayerVideoInfo a(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerVideoInfo, "$this$generateSPVideoInfo");
    int k = b(paramPlayerVideoInfo);
    int j = 0;
    int i = 0;
    if (k == 1)
    {
      localObject1 = paramPlayerVideoInfo.d();
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() > 0) {
          i = 1;
        }
        if (i == 1)
        {
          paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramPlayerVideoInfo.b(), paramPlayerVideoInfo.d());
          break label78;
        }
      }
      paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramPlayerVideoInfo.b());
      label78:
      Intrinsics.checkExpressionValueIsNotNull(paramPlayerVideoInfo, "if (pid?.isNotEmpty() ==…D_KANDIAN, vid)\n        }");
      return paramPlayerVideoInfo;
    }
    k = c(paramPlayerVideoInfo);
    String str = (String)null;
    Object localObject1 = paramPlayerVideoInfo.c();
    if (localObject1 != null) {
      i = localObject1.length;
    } else {
      i = 0;
    }
    localObject1 = str;
    Object localObject2;
    if (i > 0)
    {
      localObject1 = paramPlayerVideoInfo.c();
      if (localObject1 != null) {
        localObject2 = localObject1[0];
      } else {
        localObject2 = null;
      }
      localObject1 = str;
      if (localObject2 != null)
      {
        CharSequence localCharSequence = (CharSequence)localObject2;
        localObject1 = str;
        if (StringsKt.contains$default(localCharSequence, (CharSequence)"com/", false, 2, null))
        {
          localObject1 = str;
          if (StringsKt.contains$default(localCharSequence, (CharSequence)"?", false, 2, null))
          {
            localObject1 = ((String)localObject2).substring(StringsKt.indexOf$default(localCharSequence, "com/", 0, false, 6, null) + 4, StringsKt.indexOf$default(localCharSequence, "?", 0, false, 6, null));
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          }
        }
      }
    }
    if (paramPlayerVideoInfo.c() != null)
    {
      localObject2 = paramPlayerVideoInfo.c();
      int m = localObject2.length;
      i = j;
      while (i < m)
      {
        str = localObject2[i];
        str = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).modifyVideoUrlForKingCard(str);
        if (str != null) {
          paramPlayerVideoInfo.c()[i] = str;
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("generateSPVideoInfo: vid=");
      ((StringBuilder)localObject2).append(paramPlayerVideoInfo.b());
      ((StringBuilder)localObject2).append(", fileId=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("PlayerVideoInfo", 2, ((StringBuilder)localObject2).toString());
    }
    paramPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramPlayerVideoInfo.c(), k, paramPlayerVideoInfo.e(), (String)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(paramPlayerVideoInfo, "SuperPlayerFactory.creat…format, duration, fileId)");
    return paramPlayerVideoInfo;
  }
  
  private static final int b(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
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
  
  private static final int c(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfoKtKt
 * JD-Core Version:    0.7.0.1
 */