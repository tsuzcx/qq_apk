import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TVIDEO_TYPE_ONLINE_LIVE", "", "TVIDEO_TYPE_ONLINE_VOD", "VIDEO_LIVE_FORMAT_HLS", "VIDEO_LIVE_FORMAT_UNKNOWN", "VIDEO_TYPE_LOCAL_FILE_HLS", "VIDEO_TYPE_LOCAL_FILE_MP4", "VIDEO_TYPE_LOCAL_FILE_UNKNOW", "VIDEO_VOD_FORMAT_HLS", "VIDEO_VOD_FORMAT_MP4", "VIDEO_VOD_FORMAT_UNKNOWN", "generateSPVideoInfo", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "generateTVKUserInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_UserInfo;", "generateTVKVideoInfo", "Lcom/tencent/qqlive/mediaplayer/api/TVK_PlayerVideoInfo;", "transformFormatForSP", "transformPlayTypeForTVK", "transformSourceForSP", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class saf
{
  private static final int a(@NotNull sae paramsae)
  {
    switch (paramsae.a())
    {
    case 1: 
    case 101: 
    case 102: 
    case 103: 
    default: 
      return 2;
    case 2: 
    case 104: 
    case 105: 
      return 1;
    }
    return 4;
  }
  
  @NotNull
  public static final TVK_PlayerVideoInfo a(@NotNull sae paramsae)
  {
    Intrinsics.checkParameterIsNotNull(paramsae, "$this$generateTVKVideoInfo");
    int i = a(paramsae);
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if (i == 2)
    {
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(i, paramsae.a(), "");
      localTVK_PlayerVideoInfo.setPreLoad(paramsae.a());
      if (paramsae.b()) {
        localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      }
      if ((paramsae.c()) && (paramsae.a())) {
        localTVK_PlayerVideoInfo.setConfigMap("enable_cover_frame", "true");
      }
      Object localObject = (Map)new HashMap();
      ((Map)localObject).put("shouq_bus_type", "bus_type_kandian_feeds");
      localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
      localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rwe.a);
      localObject = paramsae.a();
      if (localObject == null) {
        break label294;
      }
      if (localObject.length != 0) {
        break label284;
      }
      i = 1;
      label136:
      if (i != 0) {
        break label289;
      }
      i = 1;
      label142:
      if (i != 1) {
        break label294;
      }
      if (paramsae.a() > 0L) {
        localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramsae.a()));
      }
      if (!paramsae.d()) {
        localTVK_PlayerVideoInfo.setConfigMap("software_play", "true");
      }
    }
    for (;;)
    {
      localTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bnrf.b()));
      localTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bnrf.q()));
      localTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bnrf.r()));
      if (paramsae.b() > 0) {
        localTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(paramsae.b()));
      }
      localTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bnrf.g()));
      localTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", bnrf.c().toString());
      return localTVK_PlayerVideoInfo;
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(i, paramsae.b(), "");
      break;
      label284:
      i = 0;
      break label136;
      label289:
      i = 0;
      break label142;
      label294:
      localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    }
  }
  
  @Nullable
  public static final TVK_UserInfo a(@NotNull sae paramsae)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramsae, "$this$generateTVKUserInfo");
    paramsae = paramsae.a();
    if (paramsae != null)
    {
      if (paramsae.length == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          j = 1;
        }
        if (j != 1) {
          break;
        }
        return new TVK_UserInfo("", "");
      }
    }
    return null;
  }
  
  @NotNull
  public static final SuperPlayerVideoInfo a(@NotNull sae paramsae)
  {
    Intrinsics.checkParameterIsNotNull(paramsae, "$this$generateSPVideoInfo");
    if (b(paramsae) == 1)
    {
      String str = paramsae.b();
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
      for (paramsae = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramsae.a(), paramsae.b());; paramsae = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramsae.a()))
      {
        Intrinsics.checkExpressionValueIsNotNull(paramsae, "if (pid?.isNotEmpty() ==…D_KANDIAN, vid)\n        }");
        return paramsae;
        i = 0;
        break;
      }
    }
    int i = c(paramsae);
    paramsae = SuperPlayerFactory.createVideoInfoForUrl(paramsae.a(), i, paramsae.a(), null);
    Intrinsics.checkExpressionValueIsNotNull(paramsae, "SuperPlayerFactory.creat…, format, duration, null)");
    return paramsae;
  }
  
  private static final int b(@NotNull sae paramsae)
  {
    switch (paramsae.a())
    {
    default: 
      return 3;
    }
    return 1;
  }
  
  private static final int c(@NotNull sae paramsae)
  {
    switch (paramsae.a())
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
 * Qualified Name:     saf
 * JD-Core Version:    0.7.0.1
 */