import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/tvk/TVKPreloader;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "Lcom/tencent/qqlive/mediaplayer/api/TVK_ICacheMgr$IPreloadCallback;", "cacheMgr", "Lcom/tencent/qqlive/mediaplayer/api/TVK_ICacheMgr;", "(Lcom/tencent/qqlive/mediaplayer/api/TVK_ICacheMgr;)V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "onPreLoadFailed", "p0", "", "p1", "p2", "onPreLoadSucess", "setPreDownloadListener", "startPreDownload", "videoDurationMs", "", "preloadDurationMs", "stopPreDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sap
  implements TVK_ICacheMgr.IPreloadCallback, rzw
{
  private final TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private rzy jdField_a_of_type_Rzy;
  
  public sap(@Nullable TVK_ICacheMgr paramTVK_ICacheMgr)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = paramTVK_ICacheMgr;
  }
  
  public int a(@NotNull sae paramsae)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Intrinsics.checkParameterIsNotNull(paramsae, "videoInfo");
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr != null)
    {
      Context localContext = (Context)BaseApplicationImpl.getContext();
      String[] arrayOfString = paramsae.a();
      localObject1 = localObject2;
      if (arrayOfString != null) {
        localObject1 = arrayOfString[0];
      }
      localObject1 = Integer.valueOf(localTVK_ICacheMgr.isVideoCached(localContext, (String)localObject1, saf.a(paramsae), saf.a(paramsae), ""));
    }
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label94;
      }
      label79:
      if (localObject1 != null) {
        break label104;
      }
    }
    label94:
    label104:
    while (((Integer)localObject1).intValue() != 2)
    {
      return 0;
      if (((Integer)localObject1).intValue() != 0) {
        break;
      }
      return 0;
      if (((Integer)localObject1).intValue() != 1) {
        break label79;
      }
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr != null) {
      localTVK_ICacheMgr.stopCacheData(20160519);
    }
  }
  
  public void a(@Nullable rzy paramrzy)
  {
    this.jdField_a_of_type_Rzy = paramrzy;
    paramrzy = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (paramrzy != null) {
      paramrzy.setPreloadCallback((TVK_ICacheMgr.IPreloadCallback)this);
    }
  }
  
  public void a(@NotNull sae paramsae, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramsae, "videoInfo");
    TVK_UserInfo localTVK_UserInfo = saf.a(paramsae);
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = saf.a(paramsae);
    if (paramsae.a() > 0L) {
      localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramsae.a()));
    }
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(paramLong2 / 1000));
    Object localObject = paramsae.a();
    int i;
    if (localObject != null) {
      if (localObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label133;
        }
        i = 1;
        label86:
        if (i != 1) {
          break label139;
        }
        localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
        if (localObject != null) {
          ((TVK_ICacheMgr)localObject).preLoadVideoByUrl((Context)BaseApplicationImpl.getContext(), paramsae.a()[0], localTVK_UserInfo, localTVK_PlayerVideoInfo);
        }
      }
    }
    label133:
    label139:
    do
    {
      return;
      i = 0;
      break;
      i = 0;
      break label86;
      paramsae = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    } while (paramsae == null);
    paramsae.preLoadVideoById((Context)BaseApplicationImpl.getContext(), localTVK_UserInfo, localTVK_PlayerVideoInfo, "");
  }
  
  public void b()
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr != null) {
      localTVK_ICacheMgr.releasePreload(20160519);
    }
  }
  
  public void onPreLoadFailed(@Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    paramString1 = this.jdField_a_of_type_Rzy;
    if (paramString1 != null) {
      paramString1.a();
    }
  }
  
  public void onPreLoadSucess(@Nullable String paramString1, @Nullable String paramString2)
  {
    paramString1 = this.jdField_a_of_type_Rzy;
    if (paramString1 != null) {
      paramString1.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sap
 * JD-Core Version:    0.7.0.1
 */