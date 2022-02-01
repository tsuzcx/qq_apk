import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sas
{
  private static SparseArray<sav> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static saw jdField_a_of_type_Saw = new saw();
  
  private static HashMap<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str1 = String.valueOf(localIterator.next());
      String str2 = String.valueOf(paramJSONObject.opt(str1));
      if (!TextUtils.isEmpty(str1)) {
        localHashMap.put(str1, str2);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> a(rwf paramrwf)
  {
    HashMap localHashMap = new HashMap();
    if (paramrwf != null)
    {
      localHashMap.put("param_url", paramrwf.b());
      localHashMap.put("param_bitrate", String.valueOf(paramrwf.a));
      localHashMap.put("param_duration", String.valueOf(paramrwf.b()));
      localHashMap.put("param_file_size", String.valueOf(paramrwf.d()));
      localHashMap.put("param_is265", String.valueOf(paramrwf.b));
    }
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  private static void a(Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("callAddress", paramInt);
      localBundle.putString("param", localJSONObject.toString());
      tbz.a(paramActivity, null, "https://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=" + (zft.a(BaseApplicationImpl.context, zft.b(BaseApplicationImpl.context)) - 385) + "&v_present_auto_top=0", localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, rwf paramrwf, int paramInt1, int paramInt2)
  {
    paramBaseArticleInfo = new sat(paramBaseArticleInfo, paramInt1, paramInt2, a(paramrwf), paramActivity);
    paramInt1 = paramBaseArticleInfo.hashCode();
    a(paramBaseArticleInfo);
    a(paramActivity, paramInt1);
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    jdField_a_of_type_Saw.a(paramActivity, true, 0.5F, new sau(paramHashMap));
  }
  
  public static void a(Activity paramActivity, HashMap<String, String> paramHashMap, int paramInt)
  {
    paramHashMap.put("agree_capture", String.valueOf(paramInt));
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      a(paramActivity, paramHashMap);
      return;
    }
    b(paramHashMap);
  }
  
  public static void a(Activity paramActivity, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        int j = new JSONObject(paramJSONObject.optString("extral")).optInt("callAddress", -1);
        if (j == -1)
        {
          i = 1;
          if (i != 0)
          {
            b(paramActivity, paramJSONObject);
            return;
          }
          a(paramJSONObject, j);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      ocd.a(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      ocd.a(null, "", "0X800AA75", "0X800AA75", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
  
  public static void a(Map<String, String> paramMap)
  {
    paramMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
    paramMap.put("param_platform", String.valueOf(1));
    paramMap.put("param_sdk_version", TVK_SDKMgr.SDK_Ver);
    paramMap.put("param_version", "8.4.5.4745");
    paramMap.put("param_subversion", "8.4.5");
    paramMap.put("param_videoCodecEnable", String.valueOf(rle.a.c()));
    paramMap.put("param_isSuperPlayer", String.valueOf(sac.a.a()));
    paramMap.put("param_app_package", "com.tencent.mobileqq");
  }
  
  public static void a(Map<String, String> paramMap, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("feedback_type_list");
    String str = "";
    if (localJSONArray != null) {
      str = localJSONArray.toString();
    }
    paramJSONObject = paramJSONObject.optString("feedback_text");
    paramMap.put("param_video_scene", String.valueOf(paramInt1));
    paramMap.put("param_feedback_entry", String.valueOf(paramInt2));
    paramMap.put("param_feedback_type_list", str);
    paramMap.put("param_feedbackText", paramJSONObject);
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt)
  {
    sav localsav = (sav)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localsav != null) {
      localsav.a(paramJSONObject);
    }
    a(paramInt);
  }
  
  public static void a(sav paramsav)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(paramsav.hashCode(), paramsav);
  }
  
  private static void b(Activity paramActivity, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optInt("close_type") > 0) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("extral");
    a(localHashMap);
    if (localJSONObject != null) {
      localHashMap.putAll(a(localJSONObject));
    }
    if (paramActivity != null)
    {
      a(paramActivity, localHashMap, paramJSONObject.optInt("agree_capture"));
      return;
    }
    QLog.w("PlayFeedbackHelper", 1, "feedbackOnViolaScene but shareEntryActivity is null, don't captureView");
    b(localHashMap);
  }
  
  private static void b(Activity paramActivity, sav paramsav, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayFeedbackHelper", 2, "feedbackCallback jsonObject:" + paramJSONObject);
    }
    HashMap localHashMap = paramsav.jdField_a_of_type_JavaUtilHashMap;
    a(localHashMap);
    a(localHashMap, paramsav.jdField_a_of_type_Int, paramsav.b, paramJSONObject);
    localHashMap.put("param_busiType", String.valueOf(paramsav.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.busiType));
    localHashMap.put("param_rowkey", String.valueOf(paramsav.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
    localHashMap.put("param_title", paramsav.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    localHashMap.put("param_vid", paramsav.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
    if (paramJSONObject.optInt("close_type") > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(paramActivity, localHashMap, paramJSONObject.optInt("agree_capture"));
      b(paramsav.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramsav.jdField_a_of_type_Int, paramsav.b);
      return;
    }
    c(paramsav.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramsav.jdField_a_of_type_Int, paramsav.b);
  }
  
  public static void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      ocd.a(null, "", "0X800AA76", "0X800AA76", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
      ocd.a(null, "", "0X800AA77", "0X800AA77", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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
  
  private static void b(HashMap<String, String> paramHashMap)
  {
    ThreadManager.post(new PlayFeedbackHelper.3(paramHashMap), 5, null, true);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      ocd.a(null, "", "0X800AA78", "0X800AA78", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c(), paramString, "", localJSONObject.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sas
 * JD-Core Version:    0.7.0.1
 */