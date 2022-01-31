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

public class qyz
{
  private static SparseArray<qzb> a = new SparseArray();
  
  private static Map<String, String> a(qub paramqub)
  {
    HashMap localHashMap = new HashMap();
    if (paramqub != null)
    {
      localHashMap.put("param_url", paramqub.b());
      localHashMap.put("param_bitrate", String.valueOf(paramqub.jdField_a_of_type_Long));
      localHashMap.put("param_duration", String.valueOf(paramqub.b()));
      localHashMap.put("param_file", String.valueOf(paramqub.d()));
      localHashMap.put("param_is265", String.valueOf(paramqub.jdField_a_of_type_Int));
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
      rwa.a(paramActivity, null, "http://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=" + (vpp.a(BaseApplicationImpl.context, vpp.b(BaseApplicationImpl.context)) - 385), localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, qub paramqub, int paramInt1, int paramInt2)
  {
    paramBaseArticleInfo = new qza(paramBaseArticleInfo, paramInt1, paramInt2, a(paramqub));
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
      noo.a(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      noo.a(null, "", "0X800AA75", "0X800AA75", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      qzb localqzb = (qzb)a.get(i);
      if (localqzb != null) {
        localqzb.a(paramJSONObject);
      }
      a(i);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void a(qzb paramqzb)
  {
    a.put(paramqzb.hashCode(), paramqzb);
  }
  
  public static void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      noo.a(null, "", "0X800AA76", "0X800AA76", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      noo.a(null, "", "0X800AA77", "0X800AA77", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
  
  private static void b(qzb paramqzb, JSONObject paramJSONObject)
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
    HashMap localHashMap = paramqzb.jdField_a_of_type_JavaUtilHashMap;
    localHashMap.put("param_video_scene", String.valueOf(paramqzb.jdField_a_of_type_Int));
    localHashMap.put("param_feedback_entry", String.valueOf(paramqzb.b));
    localHashMap.put("param_feedback_type_list", str);
    localHashMap.put("param_feedbackText", localObject);
    localHashMap.put("param_busiType", String.valueOf(paramqzb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.busiType));
    localHashMap.put("param_rowkey", String.valueOf(paramqzb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
    localHashMap.put("param_title", paramqzb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    localHashMap.put("param_vid", paramqzb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
    localHashMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
    localHashMap.put("param_platform", String.valueOf(1));
    localHashMap.put("param_sdk_version", TVK_SDKMgr.SDK_Ver);
    localHashMap.put("param_version", "8.2.8.4440");
    localHashMap.put("param_subversion", "8.2.8");
    a(localHashMap);
    if (paramJSONObject.optInt("close_type") > 0)
    {
      b(paramqzb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramqzb.jdField_a_of_type_Int, paramqzb.b);
      return;
    }
    c(paramqzb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramqzb.jdField_a_of_type_Int, paramqzb.b);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      noo.a(null, "", "0X800AA78", "0X800AA78", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
 * Qualified Name:     qyz
 * JD-Core Version:    0.7.0.1
 */