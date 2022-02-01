package com.tencent.mobileqq.kandian.biz.pts.view.helper;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.AvatarView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;

public class BindViewHelper
{
  public static void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if ((paramAbsBaseArticleInfo.mProteusTemplateBean != null) && (paramAbsBaseArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_feeds_biu_time");
    } else {
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_biu_time");
    }
    if (paramViewBase != null)
    {
      String str = Util.a(paramAbsBaseArticleInfo);
      paramViewBase.setText(str);
      if (QLog.isColorLevel())
      {
        paramViewBase = new StringBuilder();
        paramViewBase.append(" ");
        paramViewBase.append(paramAbsBaseArticleInfo);
        paramViewBase.append(" time : ");
        paramViewBase.append(str);
        QLog.d("Q.readinjoy.proteus", 2, paramViewBase.toString());
      }
    }
  }
  
  public static void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramViewBase != null)
    {
      if (paramIReadInJoyModel == null) {
        return;
      }
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null))
      {
        if (paramIReadInJoyModel.mSocialFeedInfo.a == null) {
          return;
        }
        long l = paramIReadInJoyModel.mSocialFeedInfo.a.a;
        if ((paramIReadInJoyModel.mProteusTemplateBean != null) && (paramIReadInJoyModel.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {
          paramViewBase = paramViewBase.findViewBaseByName("id_feeds_extra_info");
        } else {
          paramViewBase = paramViewBase.findViewBaseByName("id_extra_info");
        }
        paramIReadInJoyModel = Aladdin.getConfig(393).getString("comment_social_header_description", "");
        if ((paramViewBase instanceof ReadInjoyTextView)) {
          ((ReadInjoyTextView)paramViewBase).a(l, paramIReadInJoyModel);
        }
      }
    }
  }
  
  public static void b(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    paramViewBase = paramViewBase.findViewBaseByName("id_jump_channel_bar");
    if ((paramIReadInJoyModel != null) && (paramViewBase != null))
    {
      boolean bool = RIJAppSetting.b();
      if ((bool) && (RIJFeedsType.B(paramIReadInJoyModel.a())))
      {
        paramViewBase.setVisibility(0);
      }
      else
      {
        paramViewBase.setVisibility(8);
        paramViewBase = new StringBuilder();
        paramViewBase.append("no data bind, isintab:");
        paramViewBase.append(bool);
        paramViewBase = paramViewBase.toString();
        break label81;
      }
    }
    paramViewBase = "";
    label81:
    if (QLog.isColorLevel())
    {
      paramIReadInJoyModel = new StringBuilder();
      paramIReadInJoyModel.append("bindJumpChannel,flag");
      paramIReadInJoyModel.append(false);
      paramIReadInJoyModel.append(" resong : ");
      paramIReadInJoyModel.append(paramViewBase);
      QLog.d("Q.readinjoy.proteus", 2, paramIReadInJoyModel.toString());
    }
  }
  
  public static void c(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    paramViewBase = (ReadInJoySocializeRecommendFollowView)paramViewBase.findViewBaseByName("id_socialize_recommend_follow");
    if (paramViewBase != null) {
      paramViewBase.a(paramIReadInJoyModel);
    }
  }
  
  public static void d(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    paramViewBase = paramViewBase.findViewBaseByName("id_flow_guide_separator");
    if (paramViewBase != null) {
      try
      {
        if (Util.a(paramIReadInJoyModel))
        {
          if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.isPGCShortContent()))
          {
            paramViewBase.setVisibility(0);
            return;
          }
          paramViewBase.setVisibility(8);
          return;
        }
        paramViewBase.setVisibility(8);
        return;
      }
      catch (JSONException paramViewBase)
      {
        QLog.e("BindViewHelper", 2, paramViewBase.getMessage());
      }
    }
  }
  
  public static void e(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if (paramIReadInJoyModel == null) {
      return;
    }
    try
    {
      long l = Long.parseLong(paramIReadInJoyModel.mSubscribeID);
      if ((paramIReadInJoyModel.mProteusTemplateBean != null) && (paramIReadInJoyModel.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {
        paramViewBase = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_feeds_nickname");
      } else {
        paramViewBase = (ReadInjoyTextView)paramViewBase.findViewBaseByName("id_nickname");
      }
      if (paramViewBase != null) {
        paramViewBase.a(l);
      }
      if (QLog.isColorLevel())
      {
        paramIReadInJoyModel = new StringBuilder();
        paramIReadInJoyModel.append("[bindNickName] uin = ");
        paramIReadInJoyModel.append(l);
        paramIReadInJoyModel.append(", idNickName isNull = ");
        boolean bool;
        if (paramViewBase == null) {
          bool = true;
        } else {
          bool = false;
        }
        paramIReadInJoyModel.append(bool);
        QLog.i("BindViewHelper", 1, paramIReadInJoyModel.toString());
      }
      return;
    }
    catch (NumberFormatException paramViewBase)
    {
      paramViewBase.printStackTrace();
    }
  }
  
  public static void f(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
      if ((localAbsBaseArticleInfo.mProteusTemplateBean != null) && (localAbsBaseArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {
        paramViewBase = (AvatarView)paramViewBase.findViewBaseByName("id_feeds_info_avator");
      } else {
        paramViewBase = (AvatarView)paramViewBase.findViewBaseByName("id_info_avator");
      }
      if (paramViewBase != null) {
        paramViewBase.a(paramIReadInJoyModel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper
 * JD-Core Version:    0.7.0.1
 */