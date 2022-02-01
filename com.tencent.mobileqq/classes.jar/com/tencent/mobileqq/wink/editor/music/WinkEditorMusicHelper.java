package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.base.AEEditorPath.EDITOR.CACHE;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.request.QQWinkBatchGetMusicInfoRequest;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq.CameraType;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq.DataType;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq.VideoType;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

public class WinkEditorMusicHelper
{
  private String a = "none";
  
  @android.support.annotation.Nullable
  public static VsMusicItemInfo a(@NonNull Intent paramIntent)
  {
    AEQLog.b("AEEditorMusicHelper", "[parseMusicWebData]");
    String str = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[parseMusicWebData], eventValue=");
    localStringBuilder.append(paramIntent);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if ((!"kTribeSelectMusic".equals(paramIntent)) && (!"kTribeClipsMusic".equals(paramIntent))) {
      return null;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("[parseMusicWebData], dataValue=");
    paramIntent.append(str);
    AEQLog.b("AEEditorMusicHelper", paramIntent.toString());
    try
    {
      paramIntent = a(new JSONObject(str));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      AEQLog.a("AEEditorMusicHelper", "[parseMusicWebData], error=", paramIntent);
    }
    return null;
  }
  
  public static VsMusicItemInfo a(JSONObject paramJSONObject)
  {
    VsMusicItemInfo localVsMusicItemInfo = new VsMusicItemInfo();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject("albumInfo");
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("singerInfo");
        JSONObject localJSONObject3 = paramJSONObject.getJSONObject("songInfo");
        JSONObject localJSONObject4 = paramJSONObject.getJSONObject("confInfo");
        paramJSONObject = paramJSONObject.getJSONObject("lyricInfo");
        localVsMusicItemInfo.mType = 5;
        localVsMusicItemInfo.mMusicName = localJSONObject3.optString("name");
        localVsMusicItemInfo.mSingername = localJSONObject2.optString("name");
        localVsMusicItemInfo.mItemId = localJSONObject3.optInt("ID");
        localVsMusicItemInfo.mAlbumUrl = localJSONObject1.optString("thumbURL");
        localVsMusicItemInfo.mSongMid = localJSONObject3.optString("MID");
        int i = localJSONObject3.optInt("Copyright");
        bool = true;
        if (i == 1)
        {
          localVsMusicItemInfo.mHasCopyright = bool;
          localVsMusicItemInfo.d = 2;
          localVsMusicItemInfo.mUrl = localJSONObject3.optString("PlayUrl");
          localVsMusicItemInfo.musicDuration = (localJSONObject3.optInt("IPlayTime") * 1000);
          localVsMusicItemInfo.musicStart = localJSONObject4.optInt("startPos");
          localVsMusicItemInfo.b = paramJSONObject.optString("strLyric");
          localVsMusicItemInfo.musicEnd = 0;
          localVsMusicItemInfo.a = paramJSONObject.optString("strFormat");
          return localVsMusicItemInfo;
        }
      }
      catch (JSONException paramJSONObject)
      {
        AEQLog.a("AEEditorMusicHelper", "[convertJsonToVsMusicInfo], error=", paramJSONObject);
        return localVsMusicItemInfo;
      }
      boolean bool = false;
    }
  }
  
  @NonNull
  public static String a(@android.support.annotation.Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getLocalMusicPath], editorMusicInfo=");
    localStringBuilder.append(paramWinkEditorMusicInfo);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if ((paramWinkEditorMusicInfo != null) && (!paramWinkEditorMusicInfo.a()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AEEditorPath.EDITOR.CACHE.c);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramWinkEditorMusicInfo.c());
      localStringBuilder.append(".m4a");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(String paramString, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://qcircle/openwebview?url=");
    String str = paramString;
    if ("photo".equals(paramIntent.getStringExtra("type"))) {
      str = a(paramString, "type", "photo");
    }
    localStringBuilder.append(URLEncoder.encode(str));
    localStringBuilder.append("?");
    a(localStringBuilder, "videoclipduration", String.valueOf(paramIntent.getIntExtra("videoclipduration", 0)));
    a(localStringBuilder, "videofrom", paramIntent.getStringExtra("videofrom"));
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  @NonNull
  public static List<VsMusicItemInfo> a(@android.support.annotation.Nullable List<QQCircleSmartMatchMusic.MusicInfo> paramList)
  {
    AEQLog.b("AEEditorMusicHelper", "[convertToMusicItemList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      QQCircleSmartMatchMusic.MusicInfo localMusicInfo = (QQCircleSmartMatchMusic.MusicInfo)paramList.get(i);
      if (localMusicInfo != null) {
        localLinkedList.add(new VsMusicItemInfo(localMusicInfo));
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public static List<WinkEditorMusicInfo> a(@android.support.annotation.Nullable List<WinkEditorMusicInfo> paramList1, @android.support.annotation.Nullable List<WinkEditorMusicInfo> paramList2)
  {
    WinkQLog.b("AEEditorMusicHelper", "[mergeTongKuanEditorMusicInfoList]");
    ArrayList localArrayList = new ArrayList();
    if (paramList2 != null) {
      localArrayList.addAll(paramList2);
    }
    if (paramList1 != null) {
      localArrayList.addAll(paramList1);
    }
    return localArrayList;
  }
  
  public static void a(@NonNull Context paramContext, @NonNull String paramString, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    AEQLog.b("AEEditorMusicHelper", "[startMusicWebView]");
    paramString = "https://h5.qzone.qq.com/v2/qflash/music/select?_wv=2";
    if (QzoneConfig.isQQWinkVideoMusicUseWNSUrl()) {
      paramString = QzoneConfig.getWinkEditorEditedMusicUrl("https://h5.qzone.qq.com/v2/qflash/music/select?_wv=2");
    }
    paramString = a(paramString, paramIntent);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMusicWebView, url = ");
    localStringBuilder.append(paramString);
    WinkQLog.a("AEEditorMusicHelper", localStringBuilder.toString());
    paramIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(@androidx.annotation.Nullable WinkEditorMusicInfo paramWinkEditorMusicInfo, WinkEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    String str1 = a(paramWinkEditorMusicInfo);
    if (a(str1)) {
      return;
    }
    if (MobileQQ.sMobileQQ.peekAppRuntime() == null)
    {
      AEQLog.b("AEEditorMusicHelper", "[startCacheDownloadMusic], activity=null OR appInterface=null");
      return;
    }
    if (paramWinkEditorMusicInfo.d == 1)
    {
      paramMusicDownloadCallback = new StringBuilder();
      paramMusicDownloadCallback.append("[startCacheDownloadMusic], editorMusicInfo=");
      paramMusicDownloadCallback.append(paramWinkEditorMusicInfo);
      paramMusicDownloadCallback.append(", downloadStatus=STATUS_DOWNLOADING");
      AEQLog.b("AEEditorMusicHelper", paramMusicDownloadCallback.toString());
      return;
    }
    paramWinkEditorMusicInfo.d = 1;
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    String str2 = paramWinkEditorMusicInfo.f();
    if (paramMusicDownloadCallback == null) {
      paramMusicDownloadCallback = new WinkEditorMusicHelper.3();
    }
    ThreadManager.excute(new WinkEditorMusicHelper.MusicDownloadRunnable(localAppRuntime, paramWinkEditorMusicInfo, str2, str1, paramMusicDownloadCallback), 128, null, true);
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (paramStringBuilder == null) {
      return;
    }
    paramStringBuilder.append("&");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("=");
    paramStringBuilder.append(paramString2);
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @android.support.annotation.Nullable VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.MusicInfoRsp> paramonVSRspCallBack)
  {
    WinkQLog.b("AEEditorMusicHelper", "[requestDetailedMusicInfo]");
    VSNetworkHelper.getInstance().sendRequest(new QQWinkBatchGetMusicInfoRequest(paramArrayList), new WinkEditorMusicHelper.2(paramonVSRspCallBack));
  }
  
  public static void a(@NonNull List<byte[]> paramList, @android.support.annotation.Nullable SosoLocation paramSosoLocation, QQWinkSmartMatchMusicReq.VideoType paramVideoType, @android.support.annotation.Nullable LocalMediaInfo paramLocalMediaInfo, QQWinkSmartMatchMusicReq.CameraType paramCameraType, String paramString, QQWinkSmartMatchMusicReq.DataType paramDataType, @android.support.annotation.Nullable VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp> paramonVSRspCallBack)
  {
    paramList = new QQWinkSmartMatchMusicReq(paramList, paramSosoLocation, paramVideoType, paramCameraType, paramLocalMediaInfo, paramString, paramDataType);
    VSNetworkHelper.getInstance().sendRequest(paramList, new WinkEditorMusicHelper.1(paramonVSRspCallBack, paramList));
  }
  
  public static void a(@NonNull AppRuntime paramAppRuntime, @NonNull WinkEditorMusicInfo paramWinkEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @android.support.annotation.Nullable WinkEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadMusic], url=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", localPath=");
    ((StringBuilder)localObject).append(paramString2);
    AEQLog.b("AEEditorMusicHelper", ((StringBuilder)localObject).toString());
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mReqUrl = paramString1;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = paramString2;
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject).mExcuteTimeLimit = 30000L;
    ((HttpNetReq)localObject).mCallback = new WinkEditorMusicHelper.4(paramMusicDownloadCallback, paramWinkEditorMusicInfo, paramString2);
    try
    {
      ((IHttpEngineService)paramAppRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      paramWinkEditorMusicInfo = new StringBuilder();
      paramWinkEditorMusicInfo.append("[downloadMusic], error=");
      paramWinkEditorMusicInfo.append(paramAppRuntime);
      AEQLog.d("AEEditorMusicHelper", paramWinkEditorMusicInfo.toString());
    }
  }
  
  public static boolean a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    return (!TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)) && (paramVsMusicItemInfo.musicDuration != 0);
  }
  
  public static boolean a(@android.support.annotation.Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[localMusicExists], localMusicPath=");
    localStringBuilder.append(paramString);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static List<WinkEditorMusicInfo> b(@android.support.annotation.Nullable List<VsMusicItemInfo> paramList)
  {
    AEQLog.b("AEEditorMusicHelper", "[assembleEditorMusicInfoList]");
    if (paramList == null) {
      return new LinkedList();
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)paramList.get(i);
      if (localVsMusicItemInfo != null) {
        localLinkedList.add(new WinkEditorMusicInfo(localVsMusicItemInfo, false, 2, true, i + 1));
      }
      i += 1;
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper
 * JD-Core Version:    0.7.0.1
 */