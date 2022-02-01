import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class sgi
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = sgi.class.getSimpleName();
  }
  
  public static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = a(paramIntent);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("stickySpeed", pcv.a());
      localJSONObject3.put("maskLighteness", pcv.a());
      localJSONObject3.put("topBarTitle", pcv.a());
      localJSONObject3.put("autoPlayForLockScreen", Aladdin.getConfig(271).getIntegerFromString("auto_play", 1));
      localJSONObject3.put("videoRewardConfig", a(372));
      localJSONObject3.put("barrageConfig", bkwm.c());
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject4.put("from", paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1));
      localJSONObject4.put("kandian_mode_new", ofe.a());
      localJSONObject4.put("kandian_mode", pay.e());
      localJSONObject4.put("source", paramIntent.getIntExtra("key_source", -1));
      localJSONObject4.put("senceType", paramIntent.getIntExtra("RETURN_SCENE", 0));
      paramIntent = a();
      localJSONObject1.put("configModel", localJSONObject2);
      localJSONObject1.put("aladingConfig", localJSONObject3);
      localJSONObject1.put("reportConfig", localJSONObject4);
      localJSONObject1.put("dynamicAladdinConfig", pdg.b());
      localJSONObject1.put("xgAladdinConfig", pdg.a());
      localJSONObject1.put("protocolExtralParam", paramIntent);
      localJSONObject1.put("autoPlayDisable", bkwm.i());
      localJSONObject1.put("userHeadUrl", a());
      localBundle.putString("param", localJSONObject1.toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "generateParamsForViola: " + localJSONObject1.toString());
      }
      return localBundle;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "generateParamsForViola: json error ", paramIntent);
        }
      }
    }
  }
  
  public static VideoInfo a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo;
    if (paramBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localVideoInfo = (VideoInfo)paramBundle.getParcelable("VIDEO_OBJ");
      rwv.a(localVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
      }
      paramBundle.putString("VIDEO_ARTICLE_ID", localVideoInfo.g);
      paramBundle = localVideoInfo;
    }
    do
    {
      return paramBundle;
      localVideoInfo = rwv.a(paramBundle);
      rwv.a(localVideoInfo);
      paramBundle = localVideoInfo;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "innerGenerateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
    return localVideoInfo;
  }
  
  private static String a()
  {
    try
    {
      String str = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(pay.a(), null));
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getUserHeadUrl]: " + localThrowable.getMessage());
    }
    return null;
  }
  
  private static String a(int paramInt, String paramString)
  {
    if (pdp.a(paramInt)) {}
    for (String str1 = tgc.a();; str1 = "https://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1&_ckey=rij_video_feeds_cache_key")
    {
      String str2 = str1;
      if (!TextUtils.isEmpty(paramString)) {
        str2 = str1 + "&video_rowkey=" + paramString;
      }
      return str2;
    }
  }
  
  private static String a(Intent paramIntent, VideoInfo paramVideoInfo)
  {
    Object localObject = null;
    paramVideoInfo = paramVideoInfo.a();
    if (paramIntent == null)
    {
      paramIntent = localObject;
      if (paramVideoInfo != null) {
        paramIntent = paramVideoInfo.toString();
      }
    }
    do
    {
      return paramIntent;
      String str = a(paramIntent.getStringExtra("VIDEO_COVER"));
      int i = paramIntent.getIntExtra("item_image_width", 0);
      int j = paramIntent.getIntExtra("item_image_height", 0);
      if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
        return a(str, i, j);
      }
      paramIntent = localObject;
    } while (paramVideoInfo == null);
    return paramVideoInfo.toString();
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    for (;;)
    {
      return str;
      str = paramString;
      try
      {
        if (paramString.startsWith("pubaccountimage:"))
        {
          str = paramString.substring(paramString.indexOf(":") + 1);
          return str;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[tryCutPubAccountImageProtocol]: " + localException.getMessage());
      }
    }
    return paramString;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = "?";
    if (!paramString.contains("?")) {}
    for (;;)
    {
      return paramString + str + "item_image_width" + "=" + paramInt1 + "&" + "item_image_height" + "=" + paramInt2;
      str = "&";
    }
  }
  
  private static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uint32_youngster_status", bkwm.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0)));
    localJSONObject.put("uint32_req_recommend_flag", ofc.a());
    localJSONObject.put("bytes_req_recommend_json", pay.l());
    return localJSONObject;
  }
  
  private static JSONObject a(int paramInt)
  {
    Object localObject = Aladdin.getConfig(paramInt).getAll();
    JSONObject localJSONObject = new JSONObject();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject;
  }
  
  private static JSONObject a(Intent paramIntent)
  {
    VideoInfo localVideoInfo = a(paramIntent.getExtras());
    boolean bool = paramIntent.getBooleanExtra("VIDEO_SHOW_COMMENT", false);
    int k = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    String str1;
    label123:
    JSONObject localJSONObject1;
    int j;
    if (k == 11)
    {
      i = 1;
      int m = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int n = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", -1);
      Object localObject = paramIntent.getStringExtra("ARGS_SESSION_ID");
      String str2 = paramIntent.getStringExtra("ARGS_VIDEO_CHANNEL_SESSION_ID");
      long l = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", 0L);
      str1 = paramIntent.getStringExtra("VIDEO_H5_URL");
      if (TextUtils.isEmpty(str1)) {
        break label373;
      }
      str1 = Uri.parse(str1).getQueryParameter("redpackid");
      localJSONObject1 = new JSONObject();
      if (!bool) {
        break label381;
      }
      j = 1;
      label139:
      JSONObject localJSONObject2 = localJSONObject1.put("autoShowComment", j);
      if (i == 0) {
        break label386;
      }
      i = 1;
      label156:
      localObject = localJSONObject2.put("circleEntrance", i).put("entranceChannel", m).put("feedsType", n).put("reportSource", i1).put("sessionID", localObject).put("sourceType", k).put("videoFromType", k).put("videoSessionID", str2);
      if (k < 100) {
        break label391;
      }
      i = k;
      label229:
      ((JSONObject)localObject).put("webVideoFromType", i).put("startPlayTime", l / 1000L).put("redPackedId", str1);
      if (localVideoInfo != null)
      {
        localJSONObject1.put("videoType", pcv.a(localVideoInfo.jdField_b_of_type_Int, localVideoInfo.jdField_c_of_type_Int, localVideoInfo.jdField_d_of_type_Int));
        if ((TextUtils.isEmpty(localVideoInfo.jdField_a_of_type_JavaLangString)) || (localVideoInfo.c() == 0) || (localVideoInfo.b() == 0)) {
          break label396;
        }
      }
    }
    label386:
    label391:
    label396:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(localVideoInfo.jdField_r_of_type_JavaLangString)) {
        i = 1;
      }
      if (i != 0) {
        localJSONObject1.put("videoArticleModel", a(localVideoInfo, paramIntent));
      }
      paramIntent.putExtra("video_rowkey", localVideoInfo.g);
      return localJSONObject1;
      i = 0;
      break;
      label373:
      str1 = "";
      break label123;
      label381:
      j = 0;
      break label139;
      i = 0;
      break label156;
      i = 0;
      break label229;
    }
  }
  
  public static JSONObject a(VideoInfo paramVideoInfo, Intent paramIntent)
  {
    int j = 0;
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = localJSONObject1.put("article_title", paramVideoInfo.jdField_c_of_type_JavaLangString).put("busiType", paramVideoInfo.jdField_a_of_type_Int).put("first_page_url", a(paramIntent, paramVideoInfo)).put("innerUniqueID", paramVideoInfo.g);
    int i;
    if (paramVideoInfo.jdField_b_of_type_Boolean)
    {
      i = 1;
      localObject = ((JSONObject)localObject).put("is_ugc", i).put("like_count", paramVideoInfo.s);
      if (!paramVideoInfo.jdField_r_of_type_Boolean) {
        break label417;
      }
      i = 1;
      label95:
      JSONObject localJSONObject2 = ((JSONObject)localObject).put("myself_like_status", i).put("thirdIcon", paramVideoInfo.p).put("thirdName", paramVideoInfo.jdField_q_of_type_JavaLangString).put("third_uin", paramVideoInfo.j).put("third_uin_name", paramVideoInfo.k);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null) {
        break label422;
      }
      localObject = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
      label165:
      localJSONObject2 = localJSONObject2.put("topic_id", localObject).put("videoInfo_duration", paramVideoInfo.a()).put("videoInfo_fileSize", paramVideoInfo.jdField_b_of_type_Long).put("videoInfo_height", paramVideoInfo.c()).put("videoInfo_vid", paramVideoInfo.jdField_a_of_type_JavaLangString).put("videoInfo_width", paramVideoInfo.b()).put("video_comment_count", paramVideoInfo.e).put("video_json", paramVideoInfo.l).put("video_logo_url", paramVideoInfo.u).put("video_play_count", paramVideoInfo.jdField_r_of_type_Int).put("algorithm_id", paramVideoInfo.f).put("strategy_id", paramVideoInfo.jdField_q_of_type_Int).put("video_report_info", paramVideoInfo.y).put("video_url", paramVideoInfo.jdField_r_of_type_JavaLangString);
      if (paramVideoInfo.jdField_d_of_type_Long == 0L) {
        break label428;
      }
      localObject = String.valueOf(paramVideoInfo.jdField_d_of_type_Long);
      label325:
      localObject = localJSONObject2.put("feedsID", localObject).put("feedsType", paramVideoInfo.h);
      if (paramIntent == null) {
        break label436;
      }
    }
    label417:
    label422:
    label428:
    label436:
    for (paramIntent = paramIntent.getStringExtra("VIDEO_COMMON_DATA");; paramIntent = "")
    {
      ((JSONObject)localObject).put("commonData", paramIntent);
      if (!TextUtils.isEmpty(paramVideoInfo.j)) {
        i = j;
      }
      try
      {
        if (rwv.a(pay.a(), Long.parseLong(paramVideoInfo.j))) {
          i = 1;
        }
        localJSONObject1.put("isAttentionThirdUin", i);
        return localJSONObject1;
      }
      catch (Exception paramVideoInfo)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramVideoInfo.getMessage());
      }
      i = 0;
      break;
      i = 0;
      break label95;
      localObject = null;
      break label165;
      localObject = "";
      break label325;
    }
    return localJSONObject1;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    localBundle.putInt("requestCode", paramInt);
    String str = a(localIntent.getIntExtra("VIDEO_FROM_TYPE", -1), localIntent.getStringExtra("video_rowkey"));
    paramIntent = str;
    if (localIntent.getExtras() != null)
    {
      paramIntent = str;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = str + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    tgc.a(paramActivity, null, paramIntent, localBundle, true);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    String str = a(localIntent.getIntExtra("VIDEO_FROM_TYPE", -1), localIntent.getStringExtra("video_rowkey"));
    paramIntent = str;
    if (localIntent.getExtras() != null)
    {
      paramIntent = str;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = str + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    tgc.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    paramIntent = paramString;
    if (localIntent.getExtras() != null)
    {
      paramIntent = paramString;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = paramString + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    tgc.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    if (a(paramContext, paramBaseArticleInfo)) {}
    try
    {
      paramContext = rwv.a((Activity)paramContext, paramBaseArticleInfo.mVideoJsonWidth, paramBaseArticleInfo.mVideoJsonHeight);
      paramBaseArticleInfo.setFirstFrameWidth(((Integer)paramContext.first).intValue());
      paramBaseArticleInfo.setFirstFrameHeight(((Integer)paramContext.second).intValue());
      paramContext = new URL(a(paramBaseArticleInfo.getFirstFrameUrl().toString()));
      syo localsyo = new syo();
      localsyo.jdField_a_of_type_JavaNetURL = paramContext;
      localsyo.jdField_b_of_type_Int = paramBaseArticleInfo.getFirstFrameHeight();
      localsyo.jdField_a_of_type_Int = paramBaseArticleInfo.getFirstFrameWidth();
      localsyo.jdField_b_of_type_Boolean = true;
      syn.a().a(localsyo, new sgj(paramBaseArticleInfo, paramContext));
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramBaseArticleInfo.getMessage());
    }
  }
  
  private static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = true;
    if ((paramBaseArticleInfo == null) || (!(paramContext instanceof Activity))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (Aladdin.getConfig(312).getIntegerFromString("first_frame_preload_disable", 0) == 0) {}
      for (int i = 1; (paramBaseArticleInfo.getFirstFrameUrl() == null) || (paramBaseArticleInfo.mChannelID != 0L) || (i == 0); i = 0) {
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgi
 * JD-Core Version:    0.7.0.1
 */