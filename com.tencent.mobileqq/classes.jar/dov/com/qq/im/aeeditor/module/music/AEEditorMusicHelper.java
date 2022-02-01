package dov.com.qq.im.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.data.MusicData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.CACHE;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class AEEditorMusicHelper
{
  @Nullable
  public static VsMusicItemInfo a(@NonNull Intent paramIntent)
  {
    AEQLog.b("AEEditorMusicHelper", "[parseMusicWebData]");
    String str = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    AEQLog.b("AEEditorMusicHelper", "[parseMusicWebData], eventValue=" + paramIntent);
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic"))) {
      return null;
    }
    AEQLog.b("AEEditorMusicHelper", "[parseMusicWebData], dataValue=" + str);
    try
    {
      paramIntent = new VsMusicItemInfo(new JSONObject(str));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      AEQLog.a("AEEditorMusicHelper", "[parseMusicWebData], error=", paramIntent);
    }
    return null;
  }
  
  public static MusicData a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    MusicData localMusicData = new MusicData();
    if ((paramInt1 > 0) && (paramInt1 < paramInt2)) {}
    for (;;)
    {
      localMusicData.setPath(paramString);
      localMusicData.setStartTime(paramInt1);
      localMusicData.setTotalTime(paramInt2);
      localMusicData.setSegDuration(paramInt2 - paramInt1);
      return localMusicData;
      paramInt1 = 0;
    }
  }
  
  @NonNull
  public static String a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    AEQLog.b("AEEditorMusicHelper", "[getLocalMusicPath], editorMusicInfo=" + paramAEEditorMusicInfo);
    if ((paramAEEditorMusicInfo == null) || (paramAEEditorMusicInfo.a())) {
      return "";
    }
    return AEEditorPath.EDITOR.CACHE.c + File.separator + paramAEEditorMusicInfo.a() + ".m4a";
  }
  
  private static List<Long> a(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    long l1 = paramLong;
    if (paramLong > 60000L) {
      l1 = 60000L;
    }
    long l3 = ((Long)VSConfigManager.a().a("SmartCutPicCount", Long.valueOf(10L))).longValue();
    long l2 = l1 / l3;
    paramLong = l2;
    if (l2 > 1000L) {
      paramLong = (l1 - 1000L) / l3;
    }
    l2 = 0L;
    int i = 0;
    while ((i < l3) && (l2 < l1))
    {
      l2 += paramLong;
      localLinkedList.add(Long.valueOf(l2));
      i += 1;
    }
    return localLinkedList;
  }
  
  @NonNull
  public static List<VsMusicItemInfo> a(@Nullable List<META.StMusic> paramList)
  {
    AEQLog.b("AEEditorMusicHelper", "[convertToMusicItemList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < paramList.size())
    {
      META.StMusic localStMusic = (META.StMusic)paramList.get(i);
      if (localStMusic == null) {}
      for (;;)
      {
        i += 1;
        break;
        localLinkedList.add(new VsMusicItemInfo(localStMusic));
      }
    }
    return localLinkedList;
  }
  
  public static void a(@NonNull Context paramContext)
  {
    AEQLog.b("AEEditorMusicHelper", "[preLoadWebView]");
    Intent localIntent = new Intent(paramContext, PreloadWebService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      AEQLog.a("AEEditorMusicHelper", "[preLoadWebView], error=", paramContext);
    }
  }
  
  public static void a(@NonNull Context paramContext, @NonNull String paramString)
  {
    AEQLog.b("AEEditorMusicHelper", "[startMusicWebView]");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s&sessionId=%s&source=%s", new Object[] { UserAction.getQIMEI(), "", Integer.valueOf(6), paramString, "qcirclePublish" }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, @NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @Nullable AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    AEQLog.b("AEEditorMusicHelper", "[downloadMusic], url=" + paramString1 + ", localPath=" + paramString2);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mCallback = new AEEditorMusicHelper.5(paramMusicDownloadCallback, paramAEEditorMusicInfo, paramString2);
    try
    {
      ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      return;
    }
    catch (Exception paramAppInterface)
    {
      AEQLog.d("AEEditorMusicHelper", "[downloadMusic], error=" + paramAppInterface);
    }
  }
  
  public static void a(@Nullable TAVCutVideoSession paramTAVCutVideoSession, @Nullable FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener)
  {
    long l2 = 0L;
    if (((paramTAVCutVideoSession == null) || (paramTAVCutVideoSession.getDuration() == null) || (paramTAVCutVideoSession.getDuration().getTimeUs() == 0L)) && (paramGetFrameByteArrayListener != null)) {
      paramGetFrameByteArrayListener.a(false, null, -1L);
    }
    long l1 = l2;
    if (paramTAVCutVideoSession != null)
    {
      l1 = l2;
      if (paramTAVCutVideoSession.getDuration() != null) {
        l1 = paramTAVCutVideoSession.getDuration().getTimeUs() / 1000L;
      }
    }
    ThreadManager.executeOnFileThread(new AEEditorMusicHelper.2(paramTAVCutVideoSession, a(l1), ((Long)VSConfigManager.a().a("SmartCutPicWidth", Long.valueOf(224L))).longValue(), ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue(), ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue(), paramGetFrameByteArrayListener));
  }
  
  public static void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @Nullable FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener)
  {
    AEQLog.b("AEEditorMusicHelper", "[extractFrameForSmartMusic], videoPath=" + paramString + ", videoWidth=" + paramInt1 + ", videoHeight=" + paramInt2 + ", videoClipStart=" + paramLong1 + ", videoClipEnd=" + paramLong2);
    paramString = new FrameVideoHelper(paramString, paramInt1, paramInt2, paramLong2);
    paramString.a(paramLong1, new AEEditorMusicHelper.1(paramString, paramGetFrameByteArrayListener));
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp> paramonVSRspCallBack)
  {
    AEQLog.b("AEEditorMusicHelper", "[requestDetailedMusicInfo]");
    long l = System.currentTimeMillis();
    VSNetworkHelper.getInstance().sendRequest(new BatchGetMusicInfoRequest(paramArrayList), new AEEditorMusicHelper.4(paramonVSRspCallBack, l));
  }
  
  public static void a(@NonNull ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, @Nullable SosoLocation paramSosoLocation, boolean paramBoolean, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp> paramonVSRspCallBack)
  {
    AEQLog.b("AEEditorMusicHelper", "[requestRecommendMusicList]");
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, paramSosoLocation, paramBoolean, paramInt, paramLocalMediaInfo);
    long l = System.currentTimeMillis();
    VSNetworkHelper.getInstance().sendRequest(paramArrayList, new AEEditorMusicHelper.3(paramonVSRspCallBack, l));
  }
  
  public static boolean a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    return (!TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)) && (paramVsMusicItemInfo.musicDuration != 0);
  }
  
  public static boolean a(@Nullable String paramString)
  {
    AEQLog.b("AEEditorMusicHelper", "[localMusicExists], localMusicPath=" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static List<AEEditorMusicAdapter.AEEditorMusicInfo> b(@Nullable List<VsMusicItemInfo> paramList)
  {
    AEQLog.b("AEEditorMusicHelper", "[assembleEditorMusicInfoList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < paramList.size())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)paramList.get(i);
      if (localVsMusicItemInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        localLinkedList.add(new AEEditorMusicAdapter.AEEditorMusicInfo(localVsMusicItemInfo, false, 2, true, i + 1));
      }
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper
 * JD-Core Version:    0.7.0.1
 */