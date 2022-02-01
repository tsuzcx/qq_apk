package com.tencent.mobileqq.kandian.biz.video.playfeedback;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayFeedbackHelper
{
  private static SparseArray<PlayFeedbackHelper.FeedbackCallback> a = new SparseArray();
  private static ScreenCaptureHelper b = new ScreenCaptureHelper();
  
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
  
  public static void a(int paramInt)
  {
    a.remove(paramInt);
  }
  
  private static void a(Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("callAddress", paramInt);
      localBundle.putString("param", ((JSONObject)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=");
      ((StringBuilder)localObject).append(DisplayUtil.b(BaseApplicationImpl.context, UIUtils.e(BaseApplicationImpl.context)) - 385);
      ((StringBuilder)localObject).append("&v_present_auto_top=0");
      ViolaAccessHelper.a(paramActivity, null, ((StringBuilder)localObject).toString(), localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2)
  {
    paramAbsBaseArticleInfo = new PlayFeedbackHelper.1(paramAbsBaseArticleInfo, paramInt1, paramInt2, VideoPlayUtils.a((VideoPlayerWrapper)paramIVideoPlayerWrapper), paramActivity);
    paramInt1 = paramAbsBaseArticleInfo.hashCode();
    a(paramAbsBaseArticleInfo);
    a(paramActivity, paramInt1);
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    b.a(paramActivity, true, 0.5F, new PlayFeedbackHelper.2(paramHashMap));
  }
  
  public static void a(Activity paramActivity, HashMap<String, String> paramHashMap, int paramInt)
  {
    paramHashMap.put("agree_capture", String.valueOf(paramInt));
    if (paramInt != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
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
  
  public static void a(PlayFeedbackHelper.FeedbackCallback paramFeedbackCallback)
  {
    a.put(paramFeedbackCallback.hashCode(), paramFeedbackCallback);
  }
  
  public static void a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
    }
    PublicAccountReportUtils.a(null, "", "0X800AA74", "0X800AA74", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
    }
    PublicAccountReportUtils.a(null, "", "0X800AA75", "0X800AA75", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
  }
  
  public static void a(Map<String, String> paramMap)
  {
    paramMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
    paramMap.put("param_platform", String.valueOf(1));
    paramMap.put("param_sdk_version", SuperPlayerSDKMgr.getSDKVersion());
    paramMap.put("param_version", "8.8.17.5770");
    paramMap.put("param_subversion", "8.8.17");
    paramMap.put("param_isSuperPlayer", String.valueOf(PlayerHelper.a.a()));
    paramMap.put("param_app_package", "com.tencent.mobileqq");
  }
  
  public static void a(Map<String, String> paramMap, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optJSONArray("feedback_type_list");
    if (localObject != null) {
      localObject = ((JSONArray)localObject).toString();
    } else {
      localObject = "";
    }
    paramJSONObject = paramJSONObject.optString("feedback_text");
    paramMap.put("param_video_scene", String.valueOf(paramInt1));
    paramMap.put("param_feedback_entry", String.valueOf(paramInt2));
    paramMap.put("param_feedback_type_list", localObject);
    paramMap.put("param_feedbackText", paramJSONObject);
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt)
  {
    PlayFeedbackHelper.FeedbackCallback localFeedbackCallback = (PlayFeedbackHelper.FeedbackCallback)a.get(paramInt);
    if (localFeedbackCallback != null) {
      localFeedbackCallback.a(paramJSONObject);
    }
    a(paramInt);
  }
  
  private static void b(Activity paramActivity, PlayFeedbackHelper.FeedbackCallback paramFeedbackCallback, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("feedbackCallback jsonObject:");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("PlayFeedbackHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramFeedbackCallback.e;
    a((Map)localObject);
    a((Map)localObject, paramFeedbackCallback.c, paramFeedbackCallback.d, paramJSONObject);
    ((HashMap)localObject).put("param_busiType", String.valueOf(paramFeedbackCallback.b.busiType));
    ((HashMap)localObject).put("param_rowkey", String.valueOf(paramFeedbackCallback.b.getInnerUniqueID()));
    ((HashMap)localObject).put("param_title", paramFeedbackCallback.b.mTitle);
    ((HashMap)localObject).put("param_vid", paramFeedbackCallback.b.getVideoVid());
    int i;
    if (paramJSONObject.optInt("close_type") > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      a(paramActivity, (HashMap)localObject, paramJSONObject.optInt("agree_capture"));
      b(paramFeedbackCallback.b.getInnerUniqueID(), paramFeedbackCallback.c, paramFeedbackCallback.d);
      return;
    }
    c(paramFeedbackCallback.b.getInnerUniqueID(), paramFeedbackCallback.c, paramFeedbackCallback.d);
  }
  
  private static void b(Activity paramActivity, JSONObject paramJSONObject)
  {
    int i;
    if (paramJSONObject.optInt("close_type") > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
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
  
  public static void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
    }
    PublicAccountReportUtils.a(null, "", "0X800AA76", "0X800AA76", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
    }
    PublicAccountReportUtils.a(null, "", "0X800AA77", "0X800AA77", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
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
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
    }
    PublicAccountReportUtils.a(null, "", "0X800AA78", "0X800AA78", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin(), paramString, "", localJSONObject.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper
 * JD-Core Version:    0.7.0.1
 */