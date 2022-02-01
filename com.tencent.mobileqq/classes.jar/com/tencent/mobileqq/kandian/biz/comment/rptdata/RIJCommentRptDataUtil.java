package com.tencent.mobileqq.kandian.biz.comment.rptdata;

import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil;
import com.tencent.mobileqq.kandian.biz.comment.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData.RepliedCommentData;
import com.tencent.mobileqq.kandian.biz.comment.helper.StringUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtSpan;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJCommentRptDataUtil
{
  public static List<BaseCommentData.CommentRptData> a(Spanned paramSpanned)
  {
    int i = paramSpanned.length();
    Object localObject = (IRIJCommentSpan[])paramSpanned.getSpans(0, i, IRIJCommentSpan.class);
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = new LinkedList(Arrays.asList((Object[])localObject));
      Collections.sort((List)localObject, new RIJCommentSpanComparator(paramSpanned));
      return a(paramSpanned, (Iterable)localObject, i);
    }
    return null;
  }
  
  private static List<BaseCommentData.CommentRptData> a(Spanned paramSpanned, Iterable<IRIJCommentSpan> paramIterable, int paramInt)
  {
    String str = paramSpanned.toString();
    LinkedList localLinkedList = new LinkedList();
    paramIterable = paramIterable.iterator();
    int j;
    for (int i = 0; paramIterable.hasNext(); i = j)
    {
      IRIJCommentSpan localIRIJCommentSpan = (IRIJCommentSpan)paramIterable.next();
      int k = paramSpanned.getSpanStart(localIRIJCommentSpan);
      j = paramSpanned.getSpanEnd(localIRIJCommentSpan);
      if (k > i) {
        a(localLinkedList, 0, str.substring(i, k));
      }
      a(localLinkedList, localIRIJCommentSpan.a(), str.substring(k, j), localIRIJCommentSpan);
    }
    if (i < paramInt) {
      a(localLinkedList, 0, str.substring(i, paramInt));
    }
    return localLinkedList;
  }
  
  @NonNull
  private static List<BaseCommentData.CommentRptData> a(JSONObject paramJSONObject)
  {
    List localList = Collections.emptyList();
    Object localObject = localList;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("commentRptDataInfo");
      localObject = localList;
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        localObject = new RIJCommentRptDataUtil.1().getType();
        localObject = (List)new Gson().fromJson(paramJSONObject, (Type)localObject);
        b((Iterable)localObject);
      }
    }
    return localObject;
  }
  
  public static JSONArray a(Collection<BaseCommentData.CommentRptData> paramCollection)
  {
    localJSONArray = new JSONArray();
    if ((paramCollection != null) && (!paramCollection.isEmpty())) {
      try
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramCollection.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data_type", localCommentRptData.a);
          a(localCommentRptData, localJSONObject);
          localJSONArray.put(localJSONObject);
        }
        return localJSONArray;
      }
      catch (JSONException paramCollection)
      {
        QLog.w("RIJCommentRptDataUtil", 4, "", paramCollection);
      }
    }
  }
  
  private static void a(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    int i = paramCommentRptData.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("未处理的case: ");
          paramJSONObject.append(paramCommentRptData.a);
          ReadInJoyHelper.a("RIJCommentRptDataUtil", new IllegalArgumentException(paramJSONObject.toString()));
          return;
        }
        c(paramCommentRptData, paramJSONObject);
        return;
      }
      d(paramCommentRptData, paramJSONObject);
      return;
    }
    b(paramCommentRptData, paramJSONObject);
  }
  
  public static void a(BaseCommentData paramBaseCommentData, JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramBoolean) {
      a(localJSONArray, " : ");
    }
    String str = paramBaseCommentData.commentContent;
    if (!TextUtils.isEmpty(str)) {
      a(localJSONArray, str);
    }
    if ((paramBaseCommentData.commentRptDataList != null) && (!paramBaseCommentData.commentRptDataList.isEmpty())) {
      a(localJSONArray, paramBaseCommentData.commentRptDataList);
    }
    try
    {
      paramJSONObject.put(paramString, localJSONArray);
      return;
    }
    catch (JSONException paramBaseCommentData)
    {
      QLog.w("RIJCommentRptDataUtil", 4, "", paramBaseCommentData);
    }
  }
  
  public static void a(SubCommentData paramSubCommentData1, SubCommentData paramSubCommentData2)
  {
    if (paramSubCommentData1 != null)
    {
      if (paramSubCommentData2 == null) {
        return;
      }
      SubCommentData.RepliedCommentData localRepliedCommentData = new SubCommentData.RepliedCommentData();
      localRepliedCommentData.e = paramSubCommentData2.nickName;
      localRepliedCommentData.a = CommentProteusUtil.a(paramSubCommentData2);
      localRepliedCommentData.d = paramSubCommentData2.homepage;
      localRepliedCommentData.f = paramSubCommentData2.uin;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramSubCommentData2.commentContent);
      if ((paramSubCommentData2.commentRptDataList != null) && (!paramSubCommentData2.commentRptDataList.isEmpty()))
      {
        paramSubCommentData2 = paramSubCommentData2.commentRptDataList.iterator();
        while (paramSubCommentData2.hasNext())
        {
          BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramSubCommentData2.next();
          if ((localCommentRptData != null) && (!TextUtils.isEmpty(localCommentRptData.b))) {
            localStringBuilder.append(localCommentRptData.b);
          }
        }
      }
      localRepliedCommentData.b = localStringBuilder.toString();
      paramSubCommentData1.repliedCommentData = localRepliedCommentData;
    }
  }
  
  public static void a(SubCommentData paramSubCommentData, JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    paramSubCommentData = paramSubCommentData.repliedCommentData;
    if (paramSubCommentData == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramSubCommentData.e))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('@');
      localStringBuilder.append(paramSubCommentData.e);
      localStringBuilder.append(':');
      a(localJSONArray, localStringBuilder.toString(), "#99262626");
    }
    if (!TextUtils.isEmpty(paramSubCommentData.b)) {
      a(localJSONArray, paramSubCommentData.b, "#99262626");
    }
    try
    {
      paramJSONObject.put(paramString, localJSONArray);
      return;
    }
    catch (JSONException paramSubCommentData)
    {
      QLog.w("RIJCommentRptDataUtil", 4, "", paramSubCommentData);
    }
  }
  
  public static void a(RIJCommentRptDataUtil.PTSCommentModel paramPTSCommentModel, BaseCommentData.CommentRptData paramCommentRptData, String paramString)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramPTSCommentModel.b;
    paramPTSCommentModel = new CommentReportR5Builder(localAbsBaseArticleInfo, paramPTSCommentModel.a).a().e();
    try
    {
      JSONObject localJSONObject = paramPTSCommentModel.c();
      localJSONObject.put("subject_id", paramCommentRptData.e);
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("os", 1);
    }
    catch (JSONException paramCommentRptData)
    {
      QLog.w("RIJCommentRptDataUtil", 4, paramCommentRptData.getMessage());
    }
    paramCommentRptData = new StringBuilder();
    paramCommentRptData.append("reportClickRptData: actionCode=");
    paramCommentRptData.append(paramString);
    QLog.d("RIJCommentRptDataUtil", 1, paramCommentRptData.toString());
    paramPTSCommentModel = paramPTSCommentModel.b();
    PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(localAbsBaseArticleInfo), paramString, paramString, 0, 0, String.valueOf(localAbsBaseArticleInfo.mArticleID), String.valueOf(localAbsBaseArticleInfo.mAlgorithmID), localAbsBaseArticleInfo.innerUniqueID, paramPTSCommentModel, false);
  }
  
  private static void a(Iterable<BaseCommentData.CommentRptData> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramIterable.next();
      localCommentRptData.b = new String(Base64Util.encode(ReadInJoyCommentUtils.a(localCommentRptData.b, false).getBytes(), 0));
    }
  }
  
  private static void a(Collection<BaseCommentData.CommentRptData> paramCollection, int paramInt, String paramString)
  {
    a(paramCollection, paramInt, paramString, null);
  }
  
  private static void a(Collection<BaseCommentData.CommentRptData> paramCollection, int paramInt, String paramString, IRIJCommentSpan paramIRIJCommentSpan)
  {
    BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
    localCommentRptData.a = paramInt;
    localCommentRptData.b = paramString;
    if (paramInt == 1) {
      localCommentRptData.c = ((RIJCommentAtSpan)paramIRIJCommentSpan).a;
    }
    paramCollection.add(localCommentRptData);
  }
  
  private static void a(List<BaseCommentData.CommentRptData> paramList)
  {
    String str = UUID.randomUUID().toString();
    BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramList.get(0);
    localCommentRptData.b = Utils.a(localCommentRptData.b, str);
    localCommentRptData.b = StringUtil.a(localCommentRptData.b);
    localCommentRptData.b = Utils.b(localCommentRptData.b, str);
    paramList = (BaseCommentData.CommentRptData)paramList.get(paramList.size() - 1);
    paramList.b = Utils.a(paramList.b, str);
    paramList.b = StringUtil.b(paramList.b);
    paramList.b = Utils.b(paramList.b, str);
  }
  
  private static void a(JSONArray paramJSONArray)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "img");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("style", "width:16px; height:16px;");
      localJSONObject2.put("src", "rij_comment_topic_icon");
      localJSONObject1.put("attrs", localJSONObject2);
      paramJSONArray.put(localJSONObject1);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      QLog.w("RIJCommentRptDataUtil", 4, "", paramJSONArray);
    }
  }
  
  private static void a(JSONArray paramJSONArray, BaseCommentData.CommentRptData paramCommentRptData)
  {
    if (paramCommentRptData.b != null)
    {
      if (paramCommentRptData.b.length() < 2) {
        return;
      }
      if (!RIJCommentTopicUtil.a())
      {
        a(paramJSONArray, paramCommentRptData.b);
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("name", "a");
        Object localObject = new JSONObject();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCommentRptData.d);
        localStringBuilder.append("#comment_topic");
        ((JSONObject)localObject).put("href", localStringBuilder.toString());
        ((JSONObject)localObject).put("style", "color: #40A0FF;");
        localJSONObject.put("attrs", localObject);
        localObject = new JSONArray();
        a((JSONArray)localObject);
        a((JSONArray)localObject, paramCommentRptData.b.substring(1), "#40A0FF");
        localJSONObject.put("children", localObject);
        paramJSONArray.put(localJSONObject);
        return;
      }
      catch (JSONException paramJSONArray)
      {
        QLog.w("RIJCommentRptDataUtil", 4, "", paramJSONArray);
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, Iterable<BaseCommentData.CommentRptData> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramIterable.next();
      int i = localCommentRptData.a;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              a(paramJSONArray, localCommentRptData);
            }
          }
          else {
            a(paramJSONArray, localCommentRptData.b);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("未处理的case: ");
          localStringBuilder.append(localCommentRptData.a);
          ReadInJoyHelper.a("RIJCommentRptDataUtil", new IllegalArgumentException(localStringBuilder.toString()));
        }
        else
        {
          b(paramJSONArray, localCommentRptData);
        }
      }
      else {
        a(paramJSONArray, localCommentRptData.b);
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, String paramString)
  {
    a(paramJSONArray, paramString, "#000000");
  }
  
  private static void a(JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "text");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("class", "div_class");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("color: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(';');
      localJSONObject2.put("style", localStringBuilder.toString());
      localJSONObject1.put("attrs", localJSONObject2);
      paramString2 = new JSONArray();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", "text");
      localJSONObject2.put("text", paramString1);
      paramString2.put(localJSONObject2);
      localJSONObject1.put("children", paramString2);
      paramJSONArray.put(localJSONObject1);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      QLog.w("RIJCommentRptDataUtil", 4, "", paramJSONArray);
    }
  }
  
  public static void a(JSONObject paramJSONObject, Spanned paramSpanned)
  {
    paramSpanned = a(paramSpanned);
    if ((paramSpanned != null) && (!paramSpanned.isEmpty())) {
      a(paramJSONObject, paramSpanned);
    }
  }
  
  public static void a(JSONObject paramJSONObject, BaseCommentData paramBaseCommentData)
  {
    List localList = a(paramJSONObject);
    if (localList.isEmpty())
    {
      paramBaseCommentData.commentContent = new String(Base64Util.decode(paramJSONObject.optString("comment"), 0));
      return;
    }
    paramJSONObject = localList.iterator();
    while (paramJSONObject.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)paramJSONObject.next();
      if (!TextUtils.isEmpty(localCommentRptData.b)) {
        localCommentRptData.b = new String(Base64Util.decode(localCommentRptData.b, 0));
      }
    }
    paramBaseCommentData.commentRptDataList = localList;
    paramBaseCommentData.commentContent = "";
  }
  
  private static void a(JSONObject paramJSONObject, List<BaseCommentData.CommentRptData> paramList)
  {
    a(paramList);
    a(paramList);
    paramList = new Gson().toJson(paramList);
    try
    {
      paramJSONObject.put("commentRptDataInfo", paramList);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ReadInJoyHelper.a("RIJCommentRptDataUtil", paramJSONObject);
    }
  }
  
  private static void b(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("content", paramCommentRptData.b);
    paramJSONObject.put("text_data", localJSONObject);
  }
  
  private static void b(Iterable<BaseCommentData.CommentRptData> paramIterable) {}
  
  private static void b(JSONArray paramJSONArray, BaseCommentData.CommentRptData paramCommentRptData)
  {
    if (paramCommentRptData.b == null) {
      return;
    }
    if (!RIJCommentAtUtil.a())
    {
      a(paramJSONArray, paramCommentRptData.b);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", "a");
      Object localObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCommentRptData.c);
      localStringBuilder.append("#comment_at");
      ((JSONObject)localObject).put("href", localStringBuilder.toString());
      ((JSONObject)localObject).put("style", "color: #40A0FF;");
      localJSONObject.put("attrs", localObject);
      localObject = new JSONArray();
      a((JSONArray)localObject, paramCommentRptData.b, "#40A0FF");
      localJSONObject.put("children", localObject);
      paramJSONArray.put(localJSONObject);
      return;
    }
    catch (JSONException paramJSONArray)
    {
      QLog.w("RIJCommentRptDataUtil", 4, "", paramJSONArray);
    }
  }
  
  private static void c(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("content", paramCommentRptData.b);
    localJSONObject.put("url", paramCommentRptData.d);
    localJSONObject.put("topic_id", paramCommentRptData.e);
    paramJSONObject.put("herf_data", localJSONObject);
  }
  
  private static void d(BaseCommentData.CommentRptData paramCommentRptData, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("content", paramCommentRptData.b);
    localJSONObject.put("uid", paramCommentRptData.c);
    paramJSONObject.put("at_data", localJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil
 * JD-Core Version:    0.7.0.1
 */