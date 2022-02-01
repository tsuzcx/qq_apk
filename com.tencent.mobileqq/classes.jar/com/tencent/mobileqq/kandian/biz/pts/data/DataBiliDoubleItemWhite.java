package com.tencent.mobileqq.kandian.biz.pts.data;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.VideoFeedsUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/data/DataBiliDoubleItemWhite;", "Lcom/tencent/mobileqq/kandian/biz/pts/data/PTSLiteDataFactory$IPTSLiteDataJson;", "()V", "addR5ReportJson", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "r5", "Lorg/json/JSONObject;", "bindReadCount", "jsonData", "bindSubscriptInfo", "getItemJsonObject", "updateDataJson", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataBiliDoubleItemWhite
  implements PTSLiteDataFactory.IPTSLiteDataJson
{
  public static final DataBiliDoubleItemWhite.Companion a = new DataBiliDoubleItemWhite.Companion(null);
  
  private final JSONObject a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return new JSONObject();
    }
    Object localObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      localObject1 = localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getItemJsonObject] e = ");
      localStringBuilder.append(localJSONException);
      QLog.i("DataBiliDoubleItemWhite", 1, localStringBuilder.toString());
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject1).put("rowKey", paramAbsBaseArticleInfo.innerUniqueID);
        if ((paramAbsBaseArticleInfo.richTitleInfoList != null) && (paramAbsBaseArticleInfo.richTitleInfoList.size() > 0)) {
          Util.a(paramAbsBaseArticleInfo, (JSONObject)localObject1, "rich_text_line", "nodes", false);
        } else {
          ((JSONObject)localObject1).put("title", paramAbsBaseArticleInfo.mTitle);
        }
        ((JSONObject)localObject1).put("cover_image_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
        ((JSONObject)localObject1).put("author", paramAbsBaseArticleInfo.mSubscribeName);
        boolean bool = TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mJsonVideoList);
        if (!bool)
        {
          localObject2 = VideoFeedsHelper.a(paramAbsBaseArticleInfo.getVideoDuration() * 1000);
          if (localObject2 != null)
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            if (localObject2 != null)
            {
              ((JSONObject)localObject1).put("duration", localObject2);
              ((JSONObject)localObject1).put("comment", VideoFeedsUtil.b(paramAbsBaseArticleInfo.mVideoCommentCount));
              ((JSONObject)localObject1).put("count", VideoFeedsUtil.b(paramAbsBaseArticleInfo.mVideoPlayCount));
            }
          }
        }
        else
        {
          if (paramAbsBaseArticleInfo.mCommentCount > 0L) {
            ((JSONObject)localObject1).put("comment", VideoFeedsHelper.d((int)paramAbsBaseArticleInfo.mCommentCount));
          }
          ((JSONObject)localObject1).put("jump_url", paramAbsBaseArticleInfo.mArticleContentUrl);
          d(paramAbsBaseArticleInfo, (JSONObject)localObject1);
          Util.d(paramAbsBaseArticleInfo, (JSONObject)localObject1);
          return localObject1;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getItemJsonObject] e = ");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
        QLog.e("DataBiliDoubleItemWhite", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      Object localObject2 = "";
    }
  }
  
  private final void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject1 = paramAbsBaseArticleInfo.mSubArticleList;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (AbsBaseArticleInfo)((List)localObject1).get(0);
    } else {
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("left_mark_text", paramAbsBaseArticleInfo.subscriptWording);
        paramJSONObject.put("left_mark_color", PTSHelper.a(paramAbsBaseArticleInfo.subscriptWordingColor));
        paramJSONObject.put("left_mark_backgroundcolor", PTSHelper.a(paramAbsBaseArticleInfo.subscriptBgColor));
        paramJSONObject.put("left_corner_mark", paramAbsBaseArticleInfo.subscriptType);
        if (localObject1 != null)
        {
          paramAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1).subscriptWording;
          paramJSONObject.put("right_mark_text", paramAbsBaseArticleInfo);
          if (localObject1 == null) {
            break label206;
          }
          paramAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1).subscriptWordingColor;
          paramJSONObject.put("right_mark_color", PTSHelper.a(paramAbsBaseArticleInfo));
          if (localObject1 == null) {
            break label211;
          }
          paramAbsBaseArticleInfo = ((AbsBaseArticleInfo)localObject1).subscriptBgColor;
          paramJSONObject.put("right_mark_backgroundcolor", PTSHelper.a(paramAbsBaseArticleInfo));
          paramAbsBaseArticleInfo = localObject2;
          if (localObject1 != null) {
            paramAbsBaseArticleInfo = Integer.valueOf(((AbsBaseArticleInfo)localObject1).subscriptType);
          }
          paramJSONObject.put("right_corner_mark", paramAbsBaseArticleInfo);
          return;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[bindSubscriptInfo] e = ");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.e("DataBiliDoubleItemWhite", 1, paramJSONObject.toString());
        return;
      }
      paramAbsBaseArticleInfo = null;
      continue;
      label206:
      paramAbsBaseArticleInfo = null;
      continue;
      label211:
      paramAbsBaseArticleInfo = null;
    }
  }
  
  private final void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      int j = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optInt("read_count", 0);
      i = j;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[bindReadCount] e = ");
      localStringBuilder2.append(localJSONException);
      QLog.e("DataBiliDoubleItemWhite", 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[bindReadCount] readCount = ");
    localStringBuilder1.append(i);
    localStringBuilder1.append(", title = ");
    localStringBuilder1.append(paramAbsBaseArticleInfo.mTitle);
    QLog.i("DataBiliDoubleItemWhite", 1, localStringBuilder1.toString());
    if (i > 0) {
      paramJSONObject.put("read_count", VideoFeedsUtil.b(i));
    }
  }
  
  public void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonData");
    Object localObject = paramAbsBaseArticleInfo.mSubArticleList;
    int i;
    if (localObject != null) {
      i = ((List)localObject).size();
    } else {
      i = 0;
    }
    if (i <= 0) {
      return;
    }
    paramJSONObject.put("pts_page_name", RIJPreParseData.a(paramAbsBaseArticleInfo, "bili_double_items_white"));
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(0, a(paramAbsBaseArticleInfo));
    localObject = paramAbsBaseArticleInfo.mSubArticleList;
    if (localObject != null) {
      localObject = (AbsBaseArticleInfo)((List)localObject).get(0);
    } else {
      localObject = null;
    }
    localJSONArray.put(1, a((AbsBaseArticleInfo)localObject));
    paramJSONObject.put("datas", localJSONArray);
    c(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    for (;;)
    {
      String str2;
      try
      {
        paramJSONObject.put("feeds_type", 1056);
        boolean bool = TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mJsonVideoList);
        str2 = "1";
        String str1;
        if (bool) {
          str1 = "1";
        } else {
          str1 = "0";
        }
        paramJSONObject.put("double_card_type", str1);
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList;
        if (paramAbsBaseArticleInfo == null) {
          break label133;
        }
        i = paramAbsBaseArticleInfo.size();
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[addR5ReportJson], e = ");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.e("DataBiliDoubleItemWhite", 1, paramJSONObject.toString());
        return;
      }
      paramJSONObject.put("double_card_pos", paramAbsBaseArticleInfo);
      return;
      label133:
      int i = 0;
      paramAbsBaseArticleInfo = str2;
      if (i > 0) {
        paramAbsBaseArticleInfo = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.DataBiliDoubleItemWhite
 * JD-Core Version:    0.7.0.1
 */