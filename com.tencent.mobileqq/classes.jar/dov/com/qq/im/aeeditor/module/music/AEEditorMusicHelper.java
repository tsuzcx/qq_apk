package dov.com.qq.im.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import NS_QQ_STORY_META.META.StMusic;
import aaav;
import abbj;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import beum;
import beuo;
import bevn;
import bhnv;
import bpam;
import bpbp;
import bpis;
import bpiv;
import bpiw;
import bpix;
import bpiy;
import bpiz;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.richframework.network.request.SmartMusicMatchRequest;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.weseevideo.model.data.MusicData;
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
    bpam.b("AEEditorMusicHelper", "[parseMusicWebData]");
    String str = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    bpam.b("AEEditorMusicHelper", "[parseMusicWebData], eventValue=" + paramIntent);
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic"))) {
      return null;
    }
    bpam.b("AEEditorMusicHelper", "[parseMusicWebData], dataValue=" + str);
    try
    {
      paramIntent = new VsMusicItemInfo(new JSONObject(str));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      bpam.a("AEEditorMusicHelper", "[parseMusicWebData], error=", paramIntent);
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
  public static String a(@Nullable bpis parambpis)
  {
    bpam.b("AEEditorMusicHelper", "[getLocalMusicPath], editorMusicInfo=" + parambpis);
    if ((parambpis == null) || (parambpis.a())) {
      return "";
    }
    return bpbp.jdField_c_of_type_JavaLangString + File.separator + parambpis.a() + ".m4a";
  }
  
  @NonNull
  public static List<VsMusicItemInfo> a(@Nullable List<META.StMusic> paramList)
  {
    bpam.b("AEEditorMusicHelper", "[convertToMusicItemList]");
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
    bpam.b("AEEditorMusicHelper", "[preLoadWebView]");
    Intent localIntent = new Intent(paramContext, PreloadWebService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      bpam.a("AEEditorMusicHelper", "[preLoadWebView], error=", paramContext);
    }
  }
  
  public static void a(@NonNull Context paramContext, @NonNull String paramString)
  {
    bpam.b("AEEditorMusicHelper", "[startMusicWebView]");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s&sessionId=%s&source=%s", new Object[] { UserAction.getQIMEI(), "", Integer.valueOf(6), paramString, "qcirclePublish" }));
    paramContext.startActivity(localIntent);
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, @NonNull bpis parambpis, @NonNull String paramString1, @NonNull String paramString2, @Nullable bpiz parambpiz)
  {
    bpam.b("AEEditorMusicHelper", "[downloadMusic], url=" + paramString1 + ", localPath=" + paramString2);
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_JavaLangString = paramString1;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_c_of_type_JavaLangString = paramString2;
    localbeum.b = bhnv.a(bevn.a().a());
    localbeum.jdField_c_of_type_Long = 30000L;
    localbeum.jdField_a_of_type_Beuq = new bpiy(parambpiz, parambpis, paramString2);
    try
    {
      paramAppInterface.getNetEngine(0).a(localbeum);
      return;
    }
    catch (Exception paramAppInterface)
    {
      bpam.d("AEEditorMusicHelper", "[downloadMusic], error=" + paramAppInterface);
    }
  }
  
  public static void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @Nullable abbj paramabbj)
  {
    bpam.b("AEEditorMusicHelper", "[extractFrameForSmartMusic], videoPath=" + paramString + ", videoWidth=" + paramInt1 + ", videoHeight=" + paramInt2 + ", videoClipStart=" + paramLong1 + ", videoClipEnd=" + paramLong2);
    paramString = new FrameVideoHelper(paramString, paramInt1, paramInt2, paramLong2);
    paramString.a(paramLong1, new bpiv(paramString, paramabbj));
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable aaav<CLIENT.StBatchGetMusicInfoRsp> paramaaav)
  {
    bpam.b("AEEditorMusicHelper", "[requestDetailedMusicInfo]");
    long l = System.currentTimeMillis();
    VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(paramArrayList), new bpix(paramaaav, l));
  }
  
  public static void a(@NonNull ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, @Nullable SosoInterface.SosoLocation paramSosoLocation, boolean paramBoolean, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable aaav<CLIENT.StSmartMatchMusicRsp> paramaaav)
  {
    bpam.b("AEEditorMusicHelper", "[requestRecommendMusicList]");
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, paramSosoLocation, paramBoolean, paramInt, paramLocalMediaInfo);
    long l = System.currentTimeMillis();
    VSNetworkHelper.a().a(paramArrayList, new bpiw(paramaaav, l));
  }
  
  public static boolean a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    return (!TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)) && (paramVsMusicItemInfo.musicDuration != 0);
  }
  
  public static boolean a(@Nullable String paramString)
  {
    bpam.b("AEEditorMusicHelper", "[localMusicExists], localMusicPath=" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static List<bpis> b(@Nullable List<VsMusicItemInfo> paramList)
  {
    bpam.b("AEEditorMusicHelper", "[assembleEditorMusicInfoList]");
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
        localLinkedList.add(new bpis(localVsMusicItemInfo, false, 2, true, i + 1));
      }
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper
 * JD-Core Version:    0.7.0.1
 */