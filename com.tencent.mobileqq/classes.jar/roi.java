import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class roi
{
  private static SparseArray<rok> a = new SparseArray();
  
  private static Map<String, String> a(rjn paramrjn)
  {
    HashMap localHashMap = new HashMap();
    if (paramrjn != null)
    {
      localHashMap.put("param_url", paramrjn.b());
      localHashMap.put("param_bitrate", String.valueOf(paramrjn.a));
      localHashMap.put("param_duration", String.valueOf(paramrjn.b()));
      localHashMap.put("param_file", String.valueOf(paramrjn.d()));
      localHashMap.put("param_is265", String.valueOf(paramrjn.b));
    }
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    a.remove(paramInt);
  }
  
  private static void a(Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("callAddress", paramInt);
      localBundle.putString("param", localJSONObject.toString());
      smk.a(paramActivity, null, "http://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=" + (xin.a(BaseApplicationImpl.context, xin.b(BaseApplicationImpl.context)) - 385), localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, rjn paramrjn, int paramInt1, int paramInt2)
  {
    paramBaseArticleInfo = new roj(paramBaseArticleInfo, paramInt1, paramInt2, a(paramrjn));
    paramInt1 = paramBaseArticleInfo.hashCode();
    a(paramBaseArticleInfo);
    a(paramActivity, paramInt1);
  }
  
  public static void a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      nrt.a(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      nrt.a(null, "", "0X800AA75", "0X800AA75", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap)
  {
    ThreadManager.post(new PlayFeedbackHelper.2(paramHashMap), 5, null, true);
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    try
    {
      int i = new JSONObject(paramJSONObject.optString("extral")).optInt("callAddress", -1);
      rok localrok = (rok)a.get(i);
      if (localrok != null) {
        localrok.a(paramJSONObject);
      }
      a(i);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void a(rok paramrok)
  {
    a.put(paramrok.hashCode(), paramrok);
  }
  
  public static void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      nrt.a(null, "", "0X800AA76", "0X800AA76", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      nrt.a(null, "", "0X800AA77", "0X800AA77", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  private static void b(rok paramrok, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayFeedbackHelper", 2, "feedbackCallback jsonObject:" + paramJSONObject);
    }
    Object localObject = paramJSONObject.optJSONArray("feedback_type_list");
    String str = "";
    if (localObject != null) {
      str = ((JSONArray)localObject).toString();
    }
    localObject = paramJSONObject.optString("feedback_text");
    HashMap localHashMap = paramrok.jdField_a_of_type_JavaUtilHashMap;
    localHashMap.put("param_video_scene", String.valueOf(paramrok.jdField_a_of_type_Int));
    localHashMap.put("param_feedback_entry", String.valueOf(paramrok.b));
    localHashMap.put("param_feedback_type_list", str);
    localHashMap.put("param_feedbackText", localObject);
    localHashMap.put("param_busiType", String.valueOf(paramrok.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.busiType));
    localHashMap.put("param_rowkey", String.valueOf(paramrok.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
    localHashMap.put("param_title", paramrok.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    localHashMap.put("param_vid", paramrok.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
    localHashMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
    localHashMap.put("param_platform", String.valueOf(1));
    localHashMap.put("param_sdk_version", TVK_SDKMgr.SDK_Ver);
    localHashMap.put("param_version", "8.3.5.4555");
    localHashMap.put("param_subversion", "8.3.5");
    a(localHashMap);
    if (paramJSONObject.optInt("close_type") > 0)
    {
      b(paramrok.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramrok.jdField_a_of_type_Int, paramrok.b);
      return;
    }
    c(paramrok.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramrok.jdField_a_of_type_Int, paramrok.b);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      nrt.a(null, "", "0X800AA78", "0X800AA78", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     roi
 * JD-Core Version:    0.7.0.1
 */