import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class rna
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = rna.class.getSimpleName();
  }
  
  public static int a(Activity paramActivity, VideoInfo paramVideoInfo)
  {
    int i = rdm.b(paramActivity)[0];
    int j = (int)(paramVideoInfo.c() / paramVideoInfo.b() * i);
    if (j > i) {
      return i;
    }
    return j;
  }
  
  public static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = a(paramIntent);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("stickySpeed", otp.a());
      localJSONObject3.put("maskLighteness", otp.a());
      localJSONObject3.put("topBarTitle", otp.a());
      localJSONObject3.put("autoPlayForLockScreen", Aladdin.getConfig(271).getIntegerFromString("auto_play", 1));
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject4.put("from", paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1));
      localJSONObject4.put("kandian_mode_new", ntd.a());
      localJSONObject4.put("kandian_mode", ors.e());
      localJSONObject4.put("source", paramIntent.getIntExtra("key_source", -1));
      localJSONObject4.put("senceType", paramIntent.getIntExtra("RETURN_SCENE", 0));
      paramIntent = a();
      localJSONObject1.put("configModel", localJSONObject2);
      localJSONObject1.put("aladingConfig", localJSONObject3);
      localJSONObject1.put("reportConfig", localJSONObject4);
      localJSONObject1.put("dynamicAladdinConfig", oty.a());
      localJSONObject1.put("protocolExtralParam", paramIntent);
      localJSONObject1.put("autoPlayDisable", bkbq.h());
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
      rdm.a(localVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
      }
      paramBundle.putString("VIDEO_ARTICLE_ID", localVideoInfo.g);
      paramBundle = localVideoInfo;
    }
    do
    {
      return paramBundle;
      localVideoInfo = rdm.a(paramBundle);
      rdm.a(localVideoInfo);
      paramBundle = localVideoInfo;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "innerGenerateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
    return localVideoInfo;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 0) {
      return rdm.c(paramInt) + "播放";
    }
    return "";
  }
  
  private static String a(Intent paramIntent, VideoInfo paramVideoInfo)
  {
    String str = paramIntent.getStringExtra("VIDEO_COVER");
    int i = paramIntent.getIntExtra("item_width", 0);
    int j = paramIntent.getIntExtra("item_height", 0);
    if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
      return a(str, i, j);
    }
    paramIntent = paramVideoInfo.a();
    if (paramIntent != null) {
      return paramIntent.toString();
    }
    return null;
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = "?";
    if (!paramString.contains("?")) {}
    for (;;)
    {
      return paramString + str + "item_width" + "=" + paramInt1 + "&" + "item_height" + "=" + paramInt2;
      str = "&";
    }
  }
  
  private static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uint32_youngster_status", bkbq.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0)));
    localJSONObject.put("uint32_req_recommend_flag", ntb.a());
    return localJSONObject;
  }
  
  private static JSONObject a(Intent paramIntent)
  {
    VideoInfo localVideoInfo = a(paramIntent.getExtras());
    boolean bool = paramIntent.getBooleanExtra("VIDEO_SHOW_COMMENT", false);
    int k = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    int i;
    Object localObject2;
    Object localObject1;
    label123:
    JSONObject localJSONObject1;
    int j;
    if (k == 11)
    {
      i = 1;
      int m = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int n = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", -1);
      localObject2 = paramIntent.getStringExtra("ARGS_SESSION_ID");
      String str = paramIntent.getStringExtra("ARGS_VIDEO_CHANNEL_SESSION_ID");
      long l = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", 0L);
      localObject1 = paramIntent.getStringExtra("VIDEO_H5_URL");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label634;
      }
      localObject1 = Uri.parse((String)localObject1).getQueryParameter("redpackid");
      localJSONObject1 = new JSONObject();
      if (!bool) {
        break label641;
      }
      j = 1;
      label139:
      JSONObject localJSONObject2 = localJSONObject1.put("autoShowComment", j);
      if (i == 0) {
        break label646;
      }
      i = 1;
      label156:
      localObject2 = localJSONObject2.put("circleEntrance", i).put("entranceChannel", m).put("feedsType", n).put("reportSource", i1).put("sessionID", localObject2).put("sourceType", k).put("videoFromType", k).put("videoSessionID", str);
      if (k < 100) {
        break label651;
      }
      i = k;
      label229:
      ((JSONObject)localObject2).put("webVideoFromType", i).put("startPlayTime", l / 1000L).put("redPackedId", localObject1);
      label391:
      label421:
      if (localVideoInfo != null)
      {
        localJSONObject1.put("videoType", otp.a(localVideoInfo.jdField_b_of_type_Int, localVideoInfo.jdField_c_of_type_Int, localVideoInfo.d));
        if ((TextUtils.isEmpty(localVideoInfo.jdField_a_of_type_JavaLangString)) || (localVideoInfo.c() == 0) || (localVideoInfo.b() == 0)) {
          break label656;
        }
        i = 1;
        label320:
        if (i != 0)
        {
          localObject1 = new JSONObject();
          paramIntent = ((JSONObject)localObject1).put("article_title", localVideoInfo.jdField_c_of_type_JavaLangString).put("busiType", localVideoInfo.jdField_a_of_type_Int).put("first_page_url", a(paramIntent, localVideoInfo)).put("innerUniqueID", localVideoInfo.g);
          if (!localVideoInfo.jdField_b_of_type_Boolean) {
            break label661;
          }
          i = 1;
          paramIntent = paramIntent.put("is_ugc", i).put("like_count", localVideoInfo.q);
          if (!localVideoInfo.jdField_p_of_type_Boolean) {
            break label666;
          }
          i = 1;
          localObject2 = paramIntent.put("myself_like_status", i).put("thirdIcon", localVideoInfo.n).put("thirdName", localVideoInfo.o).put("third_uin", localVideoInfo.j).put("third_uin_name", localVideoInfo.k);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null) {
            break label671;
          }
        }
      }
    }
    label641:
    label646:
    label651:
    label656:
    label661:
    label666:
    label671:
    for (paramIntent = Integer.valueOf(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);; paramIntent = null)
    {
      ((JSONObject)localObject2).put("topic_id", paramIntent).put("videoInfo_duration", localVideoInfo.a()).put("videoInfo_fileSize", localVideoInfo.jdField_b_of_type_Long).put("videoInfo_height", localVideoInfo.c()).put("videoInfo_vid", localVideoInfo.jdField_a_of_type_JavaLangString).put("videoInfo_width", localVideoInfo.b()).put("video_comment_count", localVideoInfo.e).put("video_json", localVideoInfo.l).put("video_logo_url", localVideoInfo.s).put("video_play_count", localVideoInfo.jdField_p_of_type_Int).put("video_report_info", localVideoInfo.y);
      localJSONObject1.put("videoArticleModel", localObject1);
      return localJSONObject1;
      i = 0;
      break;
      label634:
      localObject1 = "";
      break label123;
      j = 0;
      break label139;
      i = 0;
      break label156;
      i = 0;
      break label229;
      i = 0;
      break label320;
      i = 0;
      break label391;
      i = 0;
      break label421;
    }
  }
  
  public static void a(Activity paramActivity, View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (bnle.b()) {
        paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + bnle.b(paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
      }
    }
    else {
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramActivity == null)) {
      return;
    }
    ors.a(paramActivity, oqu.k + bdfr.encodeToString(String.valueOf(paramString).getBytes(), 2));
  }
  
  public static void a(RecyclerView paramRecyclerView, rnb<RecyclerView.ViewHolder> paramrnb)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramRecyclerView.getChildAt(i);
      if (localObject != null)
      {
        localObject = paramRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null) {
          paramrnb.a(localObject);
        }
      }
      i += 1;
    }
  }
  
  public static int[] a(Activity paramActivity, VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int n = rdm.b(paramActivity)[0];
    int k;
    if (!paramBoolean)
    {
      int m = aepi.a(10.0F, paramActivity.getResources());
      k = aepi.a(10.0F, paramActivity.getResources());
      i = m;
      j = k;
      if (paramVideoInfo.b() < paramVideoInfo.c())
      {
        i = m + (n - (int)(paramVideoInfo.b() / paramVideoInfo.c() * n)) / 2;
        j = k;
      }
      return new int[] { j, i };
    }
    if (paramVideoInfo.b() > paramVideoInfo.c())
    {
      i = rdm.b(paramActivity)[1];
      j = rdm.b(paramActivity)[0];
      f = paramVideoInfo.b() / paramVideoInfo.c();
      j = (int)(j * f);
      if (j <= i) {}
      for (i = (i - j) / 2 + aepi.a(16.0F, paramActivity.getResources());; i = aepi.a(16.0F, paramActivity.getResources()))
      {
        j = aepi.a(16.0F, paramActivity.getResources());
        break;
      }
    }
    int j = rdm.b(paramActivity)[0];
    int i = rdm.b(paramActivity)[1];
    float f = paramVideoInfo.c() / paramVideoInfo.b();
    j = (int)(j * f);
    if (j < i) {}
    for (i = (i - j) / 2 + aepi.a(32.0F, paramActivity.getResources());; i = aepi.a(32.0F, paramActivity.getResources()))
    {
      k = aepi.a(10.0F, paramActivity.getResources());
      j = i;
      i = k;
      break;
    }
  }
  
  public static void b(Activity paramActivity, View paramView)
  {
    paramView.setPadding(paramView.getPaddingLeft() + bnle.b(paramActivity), paramView.getPaddingTop(), paramView.getPaddingRight() + bnle.b(paramActivity), paramView.getPaddingBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rna
 * JD-Core Version:    0.7.0.1
 */