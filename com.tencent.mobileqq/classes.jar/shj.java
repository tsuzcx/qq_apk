import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TVIDEO_TYPE_ONLINE_LIVE", "", "TVIDEO_TYPE_ONLINE_VOD", "VIDEO_LIVE_FORMAT_HLS", "VIDEO_LIVE_FORMAT_UNKNOWN", "VIDEO_TYPE_LOCAL_FILE_HLS", "VIDEO_TYPE_LOCAL_FILE_MP4", "VIDEO_TYPE_LOCAL_FILE_UNKNOW", "VIDEO_VOD_FORMAT_HLS", "VIDEO_VOD_FORMAT_MP4", "VIDEO_VOD_FORMAT_UNKNOWN", "generateSPVideoInfo", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "generateTVKUserInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;", "generateTVKVideoInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;", "transformFormatForSP", "transformPlayTypeForTVK", "transformSourceForSP", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class shj
{
  private static final int a(@NotNull shi paramshi)
  {
    switch (paramshi.a())
    {
    default: 
      return 3;
    }
    return 1;
  }
  
  @NotNull
  public static final SuperPlayerVideoInfo a(@NotNull shi paramshi)
  {
    Intrinsics.checkParameterIsNotNull(paramshi, "$this$generateSPVideoInfo");
    if (a(paramshi) == 1)
    {
      String str = paramshi.b();
      if (str != null) {
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          if (i != 1) {
            break label69;
          }
        }
      }
      label69:
      for (paramshi = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramshi.a(), paramshi.b());; paramshi = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramshi.a()))
      {
        Intrinsics.checkExpressionValueIsNotNull(paramshi, "if (pid?.isNotEmpty() ==…D_KANDIAN, vid)\n        }");
        return paramshi;
        i = 0;
        break;
      }
    }
    int i = b(paramshi);
    paramshi = SuperPlayerFactory.createVideoInfoForUrl(paramshi.a(), i, paramshi.a(), null);
    Intrinsics.checkExpressionValueIsNotNull(paramshi, "SuperPlayerFactory.creat…, format, duration, null)");
    return paramshi;
  }
  
  private static final int b(@NotNull shi paramshi)
  {
    switch (paramshi.a())
    {
    default: 
      return 103;
    case 3: 
    case 101: 
      return 101;
    case 4: 
    case 102: 
      return 102;
    case 5: 
    case 103: 
      return 104;
    case 104: 
      return 201;
    }
    return 203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shj
 * JD-Core Version:    0.7.0.1
 */