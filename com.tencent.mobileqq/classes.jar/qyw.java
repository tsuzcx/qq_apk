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

public class qyw
{
  private static SparseArray<qyy> a = new SparseArray();
  
  private static Map<String, String> a(qty paramqty)
  {
    HashMap localHashMap = new HashMap();
    if (paramqty != null)
    {
      localHashMap.put("param_url", paramqty.b());
      localHashMap.put("param_bitrate", String.valueOf(paramqty.jdField_a_of_type_Long));
      localHashMap.put("param_duration", String.valueOf(paramqty.b()));
      localHashMap.put("param_file", String.valueOf(paramqty.d()));
      localHashMap.put("param_is265", String.valueOf(paramqty.jdField_a_of_type_Int));
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
      rvx.a(paramActivity, null, "http://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=" + (vpm.a(BaseApplicationImpl.context, vpm.b(BaseApplicationImpl.context)) - 385), localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, qty paramqty, int paramInt1, int paramInt2)
  {
    paramBaseArticleInfo = new qyx(paramBaseArticleInfo, paramInt1, paramInt2, a(paramqty));
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
      nol.a(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      nol.a(null, "", "0X800AA75", "0X800AA75", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      qyy localqyy = (qyy)a.get(i);
      if (localqyy != null) {
        localqyy.a(paramJSONObject);
      }
      a(i);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void a(qyy paramqyy)
  {
    a.put(paramqyy.hashCode(), paramqyy);
  }
  
  public static void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      nol.a(null, "", "0X800AA76", "0X800AA76", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      nol.a(null, "", "0X800AA77", "0X800AA77", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
  
  private static void b(qyy paramqyy, JSONObject paramJSONObject)
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
    HashMap localHashMap = paramqyy.jdField_a_of_type_JavaUtilHashMap;
    localHashMap.put("param_video_scene", String.valueOf(paramqyy.jdField_a_of_type_Int));
    localHashMap.put("param_feedback_entry", String.valueOf(paramqyy.b));
    localHashMap.put("param_feedback_type_list", str);
    localHashMap.put("param_feedbackText", localObject);
    localHashMap.put("param_busiType", String.valueOf(paramqyy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.busiType));
    localHashMap.put("param_rowkey", String.valueOf(paramqyy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
    localHashMap.put("param_title", paramqyy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    localHashMap.put("param_vid", paramqyy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
    localHashMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
    localHashMap.put("param_platform", String.valueOf(1));
    localHashMap.put("param_sdk_version", TVK_SDKMgr.SDK_Ver);
    localHashMap.put("param_version", "8.3.0.4480");
    localHashMap.put("param_subversion", "8.3.0");
    a(localHashMap);
    if (paramJSONObject.optInt("close_type") > 0)
    {
      b(paramqyy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramqyy.jdField_a_of_type_Int, paramqyy.b);
      return;
    }
    c(paramqyy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramqyy.jdField_a_of_type_Int, paramqyy.b);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      nol.a(null, "", "0X800AA78", "0X800AA78", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyw
 * JD-Core Version:    0.7.0.1
 */