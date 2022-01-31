import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class qxo
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = qxo.class.getSimpleName();
  }
  
  public static int a(Activity paramActivity, VideoInfo paramVideoInfo)
  {
    int i = qol.b(paramActivity)[0];
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
      localJSONObject3.put("stickySpeed", oph.a());
      localJSONObject3.put("maskLighteness", oph.a());
      localJSONObject3.put("topBarTitle", oph.a());
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject4.put("from", paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1));
      localJSONObject4.put("kandian_mode_new", npx.a());
      localJSONObject4.put("kandian_mode", onk.e());
      localJSONObject4.put("source", paramIntent.getIntExtra("key_source", -1));
      localJSONObject1.put("configModel", localJSONObject2);
      localJSONObject1.put("aladingConfig", localJSONObject3);
      localJSONObject1.put("reportConfig", localJSONObject4);
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
      qol.a(localVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
      }
      paramBundle.putString("VIDEO_ARTICLE_ID", localVideoInfo.g);
      paramBundle = localVideoInfo;
    }
    do
    {
      return paramBundle;
      localVideoInfo = qol.a(paramBundle);
      qol.a(localVideoInfo);
      paramBundle = localVideoInfo;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "innerGenerateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
    return localVideoInfo;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 0) {
      return qol.c(paramInt) + "播放";
    }
    return "";
  }
  
  private static JSONObject a(Intent paramIntent)
  {
    int k = 1;
    VideoInfo localVideoInfo = a(paramIntent.getExtras());
    boolean bool = paramIntent.getBooleanExtra("VIDEO_SHOW_COMMENT", false);
    int m = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    int i;
    Object localObject;
    JSONObject localJSONObject1;
    int j;
    label96:
    JSONObject localJSONObject2;
    if (m == 11)
    {
      i = 1;
      int n = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int i1 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int i2 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", -1);
      localObject = paramIntent.getStringExtra("ARGS_SESSION_ID");
      paramIntent = paramIntent.getStringExtra("ARGS_VIDEO_CHANNEL_SESSION_ID");
      localJSONObject1 = new JSONObject();
      if (!bool) {
        break label520;
      }
      j = 1;
      localJSONObject2 = localJSONObject1.put("autoShowComment", j);
      if (i == 0) {
        break label525;
      }
      i = 1;
      label112:
      paramIntent = localJSONObject2.put("circleEntrance", i).put("entranceChannel", n).put("feedsType", i1).put("reportSource", i2).put("sessionID", localObject).put("sourceType", m).put("videoFromType", m).put("videoSessionID", paramIntent);
      if (m < 100) {
        break label530;
      }
      i = m;
      label179:
      paramIntent.put("webVideoFromType", i);
      if (localVideoInfo != null)
      {
        localJSONObject1.put("videoType", oph.a(localVideoInfo.jdField_b_of_type_Int, localVideoInfo.jdField_c_of_type_Int, localVideoInfo.d));
        localObject = new JSONObject();
        paramIntent = ((JSONObject)localObject).put("article_title", localVideoInfo.jdField_c_of_type_JavaLangString).put("busiType", localVideoInfo.jdField_a_of_type_Int).put("first_page_url", localVideoInfo.a()).put("innerUniqueID", localVideoInfo.g);
        if (!localVideoInfo.jdField_b_of_type_Boolean) {
          break label535;
        }
        i = 1;
        label280:
        paramIntent = paramIntent.put("is_ugc", i).put("like_count", localVideoInfo.t);
        if (!localVideoInfo.jdField_l_of_type_Boolean) {
          break label540;
        }
        i = k;
        label308:
        localJSONObject2 = paramIntent.put("myself_like_status", i).put("thirdIcon", localVideoInfo.E).put("thirdName", localVideoInfo.F).put("third_uin", localVideoInfo.j).put("third_uin_name", localVideoInfo.k);
        if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null) {
          break label545;
        }
      }
    }
    label520:
    label525:
    label530:
    label535:
    label540:
    label545:
    for (paramIntent = Integer.valueOf(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);; paramIntent = null)
    {
      localJSONObject2.put("topic_id", paramIntent).put("videoInfo_duration", localVideoInfo.a()).put("videoInfo_fileSize", localVideoInfo.jdField_b_of_type_Long).put("videoInfo_height", localVideoInfo.c()).put("videoInfo_vid", localVideoInfo.jdField_a_of_type_JavaLangString).put("videoInfo_width", localVideoInfo.b()).put("video_comment_count", localVideoInfo.e).put("video_json", localVideoInfo.jdField_l_of_type_JavaLangString).put("video_logo_url", localVideoInfo.J).put("video_play_count", localVideoInfo.s).put("video_report_info", localVideoInfo.N);
      localJSONObject1.put("videoArticleModel", localObject);
      return localJSONObject1;
      i = 0;
      break;
      j = 0;
      break label96;
      i = 0;
      break label112;
      i = 0;
      break label179;
      i = 0;
      break label280;
      i = 0;
      break label308;
    }
  }
  
  public static void a(Activity paramActivity, View paramView)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (bkur.b()) {
        paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop() + bkur.b(paramActivity), paramView.getPaddingRight(), paramView.getPaddingBottom());
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
    onk.a(paramActivity, omm.k + bbca.encodeToString(String.valueOf(paramString).getBytes(), 2));
  }
  
  public static void a(RecyclerView paramRecyclerView, qxp<RecyclerView.ViewHolder> paramqxp)
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
          paramqxp.a(localObject);
        }
      }
      i += 1;
    }
  }
  
  public static int[] a(Activity paramActivity, VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int n = qol.b(paramActivity)[0];
    int k;
    if (!paramBoolean)
    {
      int m = actn.a(10.0F, paramActivity.getResources());
      k = actn.a(10.0F, paramActivity.getResources());
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
      i = qol.b(paramActivity)[1];
      j = qol.b(paramActivity)[0];
      f = paramVideoInfo.b() / paramVideoInfo.c();
      j = (int)(j * f);
      if (j <= i) {}
      for (i = (i - j) / 2 + actn.a(16.0F, paramActivity.getResources());; i = actn.a(16.0F, paramActivity.getResources()))
      {
        j = actn.a(16.0F, paramActivity.getResources());
        break;
      }
    }
    int j = qol.b(paramActivity)[0];
    int i = qol.b(paramActivity)[1];
    float f = paramVideoInfo.c() / paramVideoInfo.b();
    j = (int)(j * f);
    if (j < i) {}
    for (i = (i - j) / 2 + actn.a(32.0F, paramActivity.getResources());; i = actn.a(32.0F, paramActivity.getResources()))
    {
      k = actn.a(10.0F, paramActivity.getResources());
      j = i;
      i = k;
      break;
    }
  }
  
  public static void b(Activity paramActivity, View paramView)
  {
    paramView.setPadding(paramView.getPaddingLeft() + bkur.b(paramActivity), paramView.getPaddingTop(), paramView.getPaddingRight() + bkur.b(paramActivity), paramView.getPaddingBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxo
 * JD-Core Version:    0.7.0.1
 */