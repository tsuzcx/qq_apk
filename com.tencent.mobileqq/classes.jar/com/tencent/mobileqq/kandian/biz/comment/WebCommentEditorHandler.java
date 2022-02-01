package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.mobileqq.kandian.biz.comment.msgboard.RIJMessageBoardNetHandler;
import com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebCommentEditorHandler
{
  public static String a(String paramString)
  {
    try
    {
      localObject = new String(Base64Util.decode(paramString, 0));
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label15:
      break label15;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#decode: msg=");
    ((StringBuilder)localObject).append(paramString);
    QLog.w("WebCommentEditorHandler", 1, ((StringBuilder)localObject).toString());
    return paramString;
  }
  
  private static List<BaseCommentData.CommentRptData> a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData.commentRptDataList != null) && (!paramBaseCommentData.commentRptDataList.isEmpty())) {
      return paramBaseCommentData.commentRptDataList;
    }
    if (TextUtils.isEmpty(paramBaseCommentData.commentContent)) {
      return Collections.emptyList();
    }
    BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
    localCommentRptData.b = paramBaseCommentData.commentContent;
    localCommentRptData.a = 0;
    paramBaseCommentData = new ArrayList(1);
    paramBaseCommentData.add(localCommentRptData);
    return paramBaseCommentData;
  }
  
  private static List<BaseCommentData.CommentLinkData> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      Type localType = new WebCommentEditorHandler.1().getType();
      return (List)new Gson().fromJson(paramJSONArray.toString(), localType);
    }
    return null;
  }
  
  public static void a(int paramInt, Intent paramIntent, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    if (paramIntent == null) {
      return;
    }
    JSONObject localJSONObject = b(paramIntent.getStringExtra("arg_result_json"));
    if (localJSONObject == null) {
      return;
    }
    String str = paramIntent.getStringExtra("arg_callback");
    if (paramInt == -1)
    {
      a(paramIntent, localJSONObject, str, paramEditorResultReceiver);
      return;
    }
    a(localJSONObject, str, paramEditorResultReceiver);
  }
  
  private static void a(Intent paramIntent, @NotNull JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("commentType", 0);
    int j = paramJSONObject.optInt("sourceType", 0);
    String str1 = paramJSONObject.optString("rowkey");
    String str2 = paramJSONObject.optString("articleId");
    int k = paramJSONObject.optInt("scene");
    int m = paramJSONObject.optInt("entry");
    String str5 = paramJSONObject.optString("businessInfo");
    String str3 = paramJSONObject.optString("firstCommentId");
    long l = paramJSONObject.optLong("repliedSubAuthorId");
    String str4 = paramJSONObject.optString("repliedSubCommentId");
    if (paramJSONObject.has("isPgcAuthor")) {
      paramIntent.putExtra("isPgcAuthor", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    paramIntent.putExtra("comment_type", false);
    paramIntent.putExtra("commentType", i);
    paramIntent.putExtra("sourceType", j);
    paramIntent.putExtra("public_fragment_window_feature", 1);
    if (str3.isEmpty())
    {
      paramJSONObject = new FirstCommentCreateData(m, str5);
      paramJSONObject.b(str1);
      paramJSONObject.c(str2);
      paramJSONObject.b(k);
      paramIntent.putExtra("comment_create_data", paramJSONObject);
      return;
    }
    paramJSONObject = new SubCommentCreateData(m, str5);
    paramJSONObject.a(str3);
    paramJSONObject.b(str1);
    paramJSONObject.c(str2);
    paramJSONObject.a(l);
    paramJSONObject.e(str4);
    paramJSONObject.b(k);
    paramIntent.putExtra("comment_create_data", paramJSONObject);
  }
  
  private static void a(@NonNull Intent paramIntent, @NonNull JSONObject paramJSONObject, @Nullable String paramString, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    int i = paramIntent.getIntExtra("comment_editor_scene", 0);
    if (i != 0)
    {
      if (i != 1)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("no action for scene ");
        paramIntent.append(i);
        ReadInJoyHelper.a("WebCommentEditorHandler", new IllegalStateException(paramIntent.toString()));
        return;
      }
      b(paramIntent, paramJSONObject, paramString, paramEditorResultReceiver);
      return;
    }
    c(paramIntent, paramJSONObject, paramString, paramEditorResultReceiver);
  }
  
  private static void a(Parcelable paramParcelable, @NonNull JSONObject paramJSONObject, @Nullable String paramString, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("linkList");
    List localList = a(localJSONArray);
    int i = paramJSONObject.optInt("biuAfterComment");
    CommentData localCommentData = new CommentData();
    RIJCommentRptDataUtil.a(paramJSONObject, localCommentData);
    int j = paramJSONObject.optInt("feedsType");
    paramString = new WebCommentEditorHandler.MyCreateCommentObserver(paramJSONObject, paramEditorResultReceiver, localJSONArray, localCommentData, paramString, null);
    boolean bool;
    if ((paramParcelable instanceof FirstCommentCreateData))
    {
      paramParcelable = (FirstCommentCreateData)paramParcelable;
      paramParcelable.a(localCommentData.commentContent);
      paramParcelable.a(localCommentData.commentRptDataList);
      paramParcelable.b(localList);
      paramEditorResultReceiver = RIJCommentNetworkWrapper.INSTANCE;
      paramJSONObject = paramJSONObject.toString();
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramEditorResultReceiver.createFirstComment(paramParcelable, paramString, paramJSONObject, j, false, bool);
      return;
    }
    if ((paramParcelable instanceof SubCommentCreateData))
    {
      paramParcelable = (SubCommentCreateData)paramParcelable;
      paramParcelable.d(localCommentData.commentContent);
      paramParcelable.a(localCommentData.commentRptDataList);
      paramParcelable.b(localList);
      paramEditorResultReceiver = RIJCommentNetworkWrapper.INSTANCE;
      paramJSONObject = paramJSONObject.toString();
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramEditorResultReceiver.createSubComment(paramParcelable, paramString, paramJSONObject, j, false, bool);
    }
  }
  
  public static void a(@NonNull WebCommentEditorHandler.OpenEditorParams paramOpenEditorParams)
  {
    Activity localActivity = paramOpenEditorParams.a;
    Object localObject1 = paramOpenEditorParams.b;
    Object localObject3 = paramOpenEditorParams.d;
    int i = paramOpenEditorParams.c;
    Bundle localBundle = paramOpenEditorParams.f;
    int j = ((JSONObject)localObject1).optInt("maxLength", -1);
    String str1 = a(((JSONObject)localObject1).optString("placeholder"));
    String str2 = a(((JSONObject)localObject1).optString("defaultTxt"));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("#openPublisher: placeholder=");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", defaultTxt=");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", maxLength=");
    ((StringBuilder)localObject2).append(j);
    QLog.d("WebCommentEditorHandler", 1, ((StringBuilder)localObject2).toString());
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("arg_callback", (String)localObject3);
    ((Intent)localObject2).putExtra("comment_editor_scene", i);
    ((Intent)localObject2).putExtra("placeholder", str1);
    ((Intent)localObject2).putExtra("defaultTxt", str2);
    ((Intent)localObject2).putExtra("maxLength", j);
    j = ((JSONObject)localObject1).optInt("firstAction", 0);
    boolean bool1 = a(((JSONObject)localObject1).optInt("forceHideTopic", 0));
    boolean bool2 = a(((JSONObject)localObject1).optInt("forceHideAt", 0));
    ((Intent)localObject2).putExtra("firstAction", j);
    ((Intent)localObject2).putExtra("forceHideTopic", bool1);
    ((Intent)localObject2).putExtra("forceHideAt", bool2);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("#openPublisher: firstAction=");
    ((StringBuilder)localObject3).append(j);
    ((StringBuilder)localObject3).append(", forceHideTopic=");
    ((StringBuilder)localObject3).append(bool1);
    ((StringBuilder)localObject3).append(", forceHideAt=");
    ((StringBuilder)localObject3).append(bool2);
    QLog.d("WebCommentEditorHandler", 1, ((StringBuilder)localObject3).toString());
    if (localBundle != null) {
      ((Intent)localObject2).putExtras(localBundle);
    }
    if (i != 0)
    {
      if (i != 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("no action for scene ");
        ((StringBuilder)localObject1).append(i);
        ReadInJoyHelper.a("WebCommentEditorHandler", new IllegalStateException(((StringBuilder)localObject1).toString()));
      }
      else
      {
        b((Intent)localObject2, (JSONObject)localObject1);
      }
    }
    else {
      a((Intent)localObject2, (JSONObject)localObject1);
    }
    ReadInJoyCommentEntrance.a(localActivity, (Intent)localObject2, paramOpenEditorParams.e);
  }
  
  private static void a(@NonNull JSONObject paramJSONObject, String paramString, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    try
    {
      paramJSONObject.put("retCode", -1);
      paramJSONObject.put("commentId", 0);
    }
    catch (JSONException localJSONException)
    {
      label21:
      break label21;
    }
    QLog.w("WebCommentEditorHandler", 1, "handleCommentEditorNativeResult put user cancel result error.");
    paramEditorResultReceiver.a(paramString, paramJSONObject);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static JSONObject b(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      label15:
      break label15;
    }
    QLog.d("WebCommentEditorHandler", 1, "handleCommentEditorNativeResult result parse error.");
    return null;
  }
  
  private static void b(Intent paramIntent, @NotNull JSONObject paramJSONObject)
  {
    paramJSONObject = RIJMessageBoardEditorParams.a(paramJSONObject);
    if ((paramJSONObject != null) && (paramJSONObject.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#prepareParams4MessageBoardScene: params=");
      localStringBuilder.append(paramJSONObject);
      QLog.d("WebCommentEditorHandler", 1, localStringBuilder.toString());
      paramIntent.putExtra("messageBoardParam", paramJSONObject);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("#prepareParams4MessageBoardScene: sourceObj is null, params=");
    paramIntent.append(paramJSONObject);
    QLog.w("WebCommentEditorHandler", 1, paramIntent.toString());
  }
  
  private static void b(@NonNull Intent paramIntent, @NonNull JSONObject paramJSONObject, @Nullable String paramString, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    paramIntent = (RIJMessageBoardEditorParams)paramIntent.getParcelableExtra("messageBoardParam");
    if (paramIntent == null) {
      return;
    }
    CommentData localCommentData = new CommentData();
    RIJCommentRptDataUtil.a(paramJSONObject, localCommentData);
    paramJSONObject = a(localCommentData);
    if (paramJSONObject.isEmpty()) {
      return;
    }
    RIJMessageBoardNetHandler.a.a(paramJSONObject, paramIntent, new WebCommentEditorHandler.MessageBoardNetCallback(paramString, paramIntent, paramJSONObject, paramEditorResultReceiver, null));
  }
  
  private static void c(@NonNull Intent paramIntent, @NonNull JSONObject paramJSONObject, @Nullable String paramString, @NonNull WebCommentEditorHandler.EditorResultReceiver paramEditorResultReceiver)
  {
    Parcelable localParcelable = paramIntent.getParcelableExtra("comment_create_data");
    if (paramEditorResultReceiver.a(paramIntent, paramJSONObject, paramString, localParcelable)) {
      return;
    }
    a(localParcelable, paramJSONObject, paramString, paramEditorResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler
 * JD-Core Version:    0.7.0.1
 */