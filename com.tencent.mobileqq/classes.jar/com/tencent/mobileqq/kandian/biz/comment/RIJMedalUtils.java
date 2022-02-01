package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RIJMedalUtils
{
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramContext != null) && (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null)) {
      try
      {
        ReadInJoyMedalInfo localReadInJoyMedalInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
        b(localReadInJoyMedalInfo, paramAbsBaseArticleInfo);
        a(paramContext, localReadInJoyMedalInfo);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("RIJMedalUtils", 2, paramContext.getMessage());
      }
    }
  }
  
  public static void a(Context paramContext, ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if ((paramContext != null) && (paramReadInJoyMedalInfo != null) && (!TextUtils.isEmpty(paramReadInJoyMedalInfo.jdField_c_of_type_JavaLangString)))
    {
      if (1 == paramReadInJoyMedalInfo.jdField_b_of_type_Int) {
        RIJJumpUtils.a(paramContext, paramReadInJoyMedalInfo.jdField_c_of_type_JavaLangString);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BD5", "0X8009BD5", 0, 0, "", "", "", paramReadInJoyMedalInfo.a(), false);
    }
  }
  
  public static void a(ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if (paramReadInJoyMedalInfo == null) {
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009BD4", "0X8009BD4", 0, 0, "", "", "", paramReadInJoyMedalInfo.a(), false);
  }
  
  public static void a(ReadInJoyMedalInfo paramReadInJoyMedalInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramReadInJoyMedalInfo != null) && (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      b(paramReadInJoyMedalInfo, paramAbsBaseArticleInfo);
      a(paramReadInJoyMedalInfo);
    }
  }
  
  public static void a(JSONObject paramJSONObject, ReadInJoyMedalInfo paramReadInJoyMedalInfo)
  {
    if (paramJSONObject != null)
    {
      if (paramReadInJoyMedalInfo == null) {
        return;
      }
      try
      {
        if ((!TextUtils.isEmpty(paramReadInJoyMedalInfo.jdField_b_of_type_JavaLangString)) && (paramReadInJoyMedalInfo.jdField_c_of_type_Int > 0) && (paramReadInJoyMedalInfo.jdField_d_of_type_Int > 0))
        {
          paramJSONObject.put("header_medal_jump_url", paramReadInJoyMedalInfo.jdField_c_of_type_JavaLangString);
          double d1 = Double.valueOf(paramReadInJoyMedalInfo.jdField_c_of_type_Int).doubleValue();
          int i = paramReadInJoyMedalInfo.jdField_d_of_type_Int;
          double d2 = i;
          Double.isNaN(d2);
          d1 /= d2;
          paramJSONObject.put("header_medal_wh_rate", d1);
          paramJSONObject.put("header_medal_image_url", paramReadInJoyMedalInfo.jdField_b_of_type_JavaLangString);
        }
        paramReadInJoyMedalInfo = new StringBuilder();
        paramReadInJoyMedalInfo.append("bindMedalData : ");
        paramReadInJoyMedalInfo.append(paramJSONObject.toString());
        QLog.d("RIJMedalUtils", 1, paramReadInJoyMedalInfo.toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("RIJMedalUtils", 2, paramJSONObject.getMessage());
      }
    }
  }
  
  public static void b(ReadInJoyMedalInfo paramReadInJoyMedalInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramReadInJoyMedalInfo != null) {
      try
      {
        paramReadInJoyMedalInfo.jdField_d_of_type_JavaLangString = String.valueOf(paramAbsBaseArticleInfo.mChannelID);
        paramReadInJoyMedalInfo.g = String.valueOf(paramAbsBaseArticleInfo.mFeedId);
        paramReadInJoyMedalInfo.h = String.valueOf(paramAbsBaseArticleInfo.mSubscribeID);
        if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)))
        {
          if (RIJItemViewTypeUtils.d(paramAbsBaseArticleInfo)) {
            paramReadInJoyMedalInfo.f = "4";
          } else {
            paramReadInJoyMedalInfo.f = "0";
          }
        }
        else {
          paramReadInJoyMedalInfo.f = "5";
        }
        paramReadInJoyMedalInfo.e = "2";
        return;
      }
      catch (Exception paramReadInJoyMedalInfo)
      {
        QLog.e("RIJMedalUtils", 2, paramReadInJoyMedalInfo.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.RIJMedalUtils
 * JD-Core Version:    0.7.0.1
 */