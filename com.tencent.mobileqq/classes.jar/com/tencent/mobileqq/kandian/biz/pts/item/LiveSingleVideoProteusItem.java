package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LiveSingleVideoProteusItem
  implements ProteusItem
{
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("info_avator_uin", paramAbsBaseArticleInfo.mSubscribeID);
    String str;
    if ((paramAbsBaseArticleInfo.mSubscribeName != null) && (paramAbsBaseArticleInfo.mSubscribeName.length() > 0))
    {
      if (paramAbsBaseArticleInfo.mSubscribeName.length() > 10)
      {
        str = paramAbsBaseArticleInfo.mSubscribeName.substring(0, 10);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("...");
        str = localStringBuilder.toString();
      }
      else
      {
        str = paramAbsBaseArticleInfo.mSubscribeName;
      }
    }
    else {
      str = " ";
    }
    paramJSONObject.put("nickname_text", str);
    b(paramAbsBaseArticleInfo, paramJSONObject);
    paramJSONObject.put("user_info_text", paramAbsBaseArticleInfo.mTitle);
    Util.c(paramJSONObject, paramAbsBaseArticleInfo);
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.o == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!Util.c(paramAbsBaseArticleInfo)))
    {
      paramJSONObject.put("user_desc_follow_text", ReadInJoyUtils.b(2131915611));
      paramJSONObject.put("is_show_followed", 1);
      paramAbsBaseArticleInfo.showMyFollowText = 1;
      return;
    }
    paramJSONObject.put("is_show_followed", 0);
    paramAbsBaseArticleInfo.showMyFollowText = 0;
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mKdLiveInfo;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.b)) {
      paramJSONObject.put("live_status_bg_url", paramAbsBaseArticleInfo.b);
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.c)) {
      paramJSONObject.put("live_status_icon_url", paramAbsBaseArticleInfo.c);
    }
    paramJSONObject.put("live_status_text", paramAbsBaseArticleInfo.d);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.e)) {
      paramJSONObject.put("live_hot_icon_url", paramAbsBaseArticleInfo.e);
    }
    paramJSONObject.put("live_hot_text", paramAbsBaseArticleInfo.f);
    paramJSONObject.put("jump_report_info", paramAbsBaseArticleInfo.h);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mKdLiveInfo != null))
    {
      Object localObject = new ProteusItemDataBuilder();
      ((ProteusItemDataBuilder)localObject).a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo);
      try
      {
        ((ProteusItemDataBuilder)localObject).a(paramAbsBaseArticleInfo, Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("LiveSingleVideoProteusItem", 1, localNumberFormatException.toString());
      }
      localObject = ((ProteusItemDataBuilder)localObject).a();
      ((JSONObject)localObject).put("style_ID", "ReadInJoy_live_video_cell");
      a(paramAbsBaseArticleInfo, (JSONObject)localObject);
      ((JSONObject)localObject).put("article_large_imge_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
      ((JSONObject)localObject).put("play_icon_url", "rij_multi_video_column_play");
      c(paramAbsBaseArticleInfo, (JSONObject)localObject);
      paramInt = paramAbsBaseArticleInfo.mKdLiveInfo.a;
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          ((JSONObject)localObject).put("video_info_visibility", "1");
        } else {
          ((JSONObject)localObject).put("bottom_info_visibility", "1");
        }
      }
      else {
        ((JSONObject)localObject).put("avatar_info_visibility", "1");
      }
      ((JSONObject)localObject).put("video_jump_url", paramAbsBaseArticleInfo.mArticleContentUrl);
      ((JSONObject)localObject).put("video_jump_report_info", paramAbsBaseArticleInfo.mReportCommonData);
      QLog.d("LiveSingleVideoProteusItem", 1, ((JSONObject)localObject).toString());
      return localObject;
    }
    return new JSONObject();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.LiveSingleVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */