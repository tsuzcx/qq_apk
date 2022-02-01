package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

public class LiveDoubleVideoProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mKdLiveInfo != null) && (paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.get(0) != null) && (((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0)).mKdLiveInfo != null))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("style_ID", "ReadInJoy_live_double_video_cell");
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
      KandianLiveInfo localKandianLiveInfo2 = paramAbsBaseArticleInfo.mKdLiveInfo;
      KandianLiveInfo localKandianLiveInfo1 = localAbsBaseArticleInfo.mKdLiveInfo;
      Object localObject1 = paramAbsBaseArticleInfo.mSubscribeName;
      Object localObject2 = " ";
      if ((localObject1 != null) && (paramAbsBaseArticleInfo.mSubscribeName.length() > 0))
      {
        if (paramAbsBaseArticleInfo.mSubscribeName.length() > 10)
        {
          localObject1 = paramAbsBaseArticleInfo.mSubscribeName.substring(0, 10);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("...");
          localObject1 = localStringBuilder.toString();
        }
        else
        {
          localObject1 = paramAbsBaseArticleInfo.mSubscribeName;
        }
      }
      else {
        localObject1 = " ";
      }
      localJSONObject.put("left_user_name_text", localObject1);
      localJSONObject.put("left_video_title_text", paramAbsBaseArticleInfo.mTitle);
      localJSONObject.put("left_video_bg_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("left_jump_url", paramAbsBaseArticleInfo.mArticleContentUrl);
      localJSONObject.put("left_live_status_bg_url", localKandianLiveInfo2.a);
      if (!TextUtils.isEmpty(localKandianLiveInfo2.b)) {
        localJSONObject.put("left_live_status_icon_url", localKandianLiveInfo2.b);
      }
      localJSONObject.put("left_live_status_text", localKandianLiveInfo2.c);
      if (!TextUtils.isEmpty(localKandianLiveInfo2.d)) {
        localJSONObject.put("left_live_hot_icon_url", localKandianLiveInfo2.d);
      }
      localJSONObject.put("left_live_hot_text", localKandianLiveInfo2.e);
      localObject1 = localObject2;
      if (localAbsBaseArticleInfo.mSubscribeName != null)
      {
        localObject1 = localObject2;
        if (localAbsBaseArticleInfo.mSubscribeName.length() > 0) {
          if (localAbsBaseArticleInfo.mSubscribeName.length() > 10)
          {
            localObject1 = localAbsBaseArticleInfo.mSubscribeName.substring(0, 10);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("...");
            localObject1 = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject1 = localAbsBaseArticleInfo.mSubscribeName;
          }
        }
      }
      localJSONObject.put("right_user_name_text", localObject1);
      localJSONObject.put("right_video_title_text", localAbsBaseArticleInfo.mTitle);
      localJSONObject.put("right_video_bg_url", localAbsBaseArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("right_jump_url", localAbsBaseArticleInfo.mArticleContentUrl);
      localJSONObject.put("right_live_status_bg_url", localKandianLiveInfo1.a);
      if (!TextUtils.isEmpty(localKandianLiveInfo1.b)) {
        localJSONObject.put("right_live_status_icon_url", localKandianLiveInfo1.b);
      }
      localJSONObject.put("right_live_status_text", localKandianLiveInfo1.c);
      if (!TextUtils.isEmpty(localKandianLiveInfo1.d)) {
        localJSONObject.put("right_live_hot_icon_url", localKandianLiveInfo1.d);
      }
      localJSONObject.put("right_live_hot_text", localKandianLiveInfo1.e);
      localJSONObject.put("left_jump_report_info", paramAbsBaseArticleInfo.mReportCommonData);
      localJSONObject.put("right_jump_report_info", localAbsBaseArticleInfo.mReportCommonData);
      QLog.d("LiveDoubleVideoProteusItem", 1, localJSONObject.toString());
      return localJSONObject;
    }
    return new JSONObject();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.LiveDoubleVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */