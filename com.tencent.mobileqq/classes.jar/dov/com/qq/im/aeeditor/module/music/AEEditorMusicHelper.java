package dov.com.qq.im.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import baps;
import bapv;
import baqx;
import bdee;
import blfg;
import blfw;
import bljv;
import bljy;
import bljz;
import blka;
import blkb;
import blkc;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.network.request.SmartMusicMatchRequest;
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
import yvn;
import yvz;

public class AEEditorMusicHelper
{
  @Nullable
  public static VsMusicItemInfo a(@NonNull Intent paramIntent)
  {
    blfg.b("AEEditorMusicHelper", "[parseMusicWebData]");
    String str = paramIntent.getStringExtra("data");
    paramIntent = paramIntent.getStringExtra("event");
    blfg.b("AEEditorMusicHelper", "[parseMusicWebData], eventValue=" + paramIntent);
    if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("kTribeSelectMusic"))) {
      return null;
    }
    blfg.b("AEEditorMusicHelper", "[parseMusicWebData], dataValue=" + str);
    try
    {
      paramIntent = new VsMusicItemInfo(new JSONObject(str));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      blfg.a("AEEditorMusicHelper", "[parseMusicWebData], error=", paramIntent);
    }
    return null;
  }
  
  public static MusicData a(@NonNull String paramString, int paramInt)
  {
    MusicData localMusicData = new MusicData();
    localMusicData.setPath(paramString);
    localMusicData.setStartTime(0);
    localMusicData.setTotalTime(paramInt);
    localMusicData.setSegDuration(paramInt);
    return localMusicData;
  }
  
  @NonNull
  public static String a(@Nullable bljv parambljv)
  {
    blfg.b("AEEditorMusicHelper", "[getLocalMusicPath], editorMusicInfo=" + parambljv);
    if ((parambljv == null) || (parambljv.a())) {
      return "";
    }
    return blfw.b + File.separator + parambljv.a() + ".m4a";
  }
  
  @NonNull
  public static List<VsMusicItemInfo> a(@Nullable List<META.StMusic> paramList)
  {
    blfg.b("AEEditorMusicHelper", "[convertToMusicItemList]");
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
    blfg.b("AEEditorMusicHelper", "[preLoadWebView]");
    Intent localIntent = new Intent(paramContext, PreloadWebService.class);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      blfg.a("AEEditorMusicHelper", "[preLoadWebView], error=", paramContext);
    }
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, @NonNull bljv parambljv, @NonNull String paramString1, @NonNull String paramString2, @Nullable blkc paramblkc)
  {
    blfg.b("AEEditorMusicHelper", "[downloadMusic], url=" + paramString1 + ", localPath=" + paramString2);
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_JavaLangString = paramString1;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = paramString2;
    localbaps.jdField_c_of_type_Int = bdee.a(baqx.a().a());
    localbaps.jdField_c_of_type_Long = 30000L;
    localbaps.jdField_a_of_type_Bapx = new blkb(paramblkc, parambljv, paramString2);
    try
    {
      paramAppInterface.getNetEngine(0).a(localbaps);
      return;
    }
    catch (Exception paramAppInterface)
    {
      blfg.d("AEEditorMusicHelper", "[downloadMusic], error=" + paramAppInterface);
    }
  }
  
  public static void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, @Nullable yvz paramyvz)
  {
    blfg.b("AEEditorMusicHelper", "[extractFrameForSmartMusic], videoPath=" + paramString + ", videoWidth=" + paramInt1 + ", videoHeight=" + paramInt2 + ", videoDuration=" + paramLong1 + ", videoStartOffset=" + paramLong2);
    paramString = new FrameVideoHelper(paramString, paramInt1, paramInt2, paramLong1);
    paramString.a(paramLong2, new bljy(paramString, paramyvz));
  }
  
  public static void a(@NonNull ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, @Nullable SosoInterface.SosoLocation paramSosoLocation, boolean paramBoolean, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable yvn<CLIENT.StSmartMatchMusicRsp> paramyvn)
  {
    blfg.b("AEEditorMusicHelper", "[requestRecommendMusicList]");
    paramArrayList = new SmartMusicMatchRequest(paramArrayList, paramSosoLocation, paramBoolean, paramInt, paramLocalMediaInfo);
    long l = System.currentTimeMillis();
    VSNetworkHelper.a().a(paramArrayList, new bljz(paramyvn, l));
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable yvn<CLIENT.StBatchGetMusicInfoRsp> paramyvn)
  {
    blfg.b("AEEditorMusicHelper", "[requestDetailedMusicInfo]");
    long l = System.currentTimeMillis();
    VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(paramArrayList), new blka(paramyvn, l));
  }
  
  public static boolean a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    return (!TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(paramVsMusicItemInfo.mUrl)) && (paramVsMusicItemInfo.musicDuration != 0);
  }
  
  public static boolean a(@Nullable String paramString)
  {
    blfg.b("AEEditorMusicHelper", "[localMusicExists], localMusicPath=" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static List<bljv> b(@Nullable List<VsMusicItemInfo> paramList)
  {
    blfg.b("AEEditorMusicHelper", "[assembleEditorMusicInfoList]");
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
        localLinkedList.add(new bljv(localVsMusicItemInfo, false));
      }
    }
    return localLinkedList;
  }
  
  public static void b(@NonNull Context paramContext)
  {
    blfg.b("AEEditorMusicHelper", "[startMusicWebView]");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { UserAction.getQIMEI(), "", Integer.valueOf(6) }));
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper
 * JD-Core Version:    0.7.0.1
 */