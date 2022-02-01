package com.tencent.mobileqq.kandian.biz.pts.item;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.ArticleCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;

public class CommentBiuProteusItem
  implements ProteusItem
{
  private void a(View paramView, Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramActivity == null) {
        return;
      }
      paramView.setAlpha(1.0F);
      QLog.d("CommentBiuProteusItem", 2, "bindView | start CommentBiu Header Anim");
      Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, 2130772445);
      Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, 2130772446);
      localAnimation1.setFillAfter(true);
      localAnimation1.setAnimationListener(new CommentBiuProteusItem.1(this, paramView, localAnimation2));
      localAnimation2.setAnimationListener(new CommentBiuProteusItem.2(this, paramView, paramBoolean, paramActivity, paramAbsBaseArticleInfo));
      paramView.startAnimation(localAnimation1);
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo);
    }
  }
  
  private void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel)
  {
    ViewBase localViewBase2 = paramContainer.getVirtualView();
    ViewBase localViewBase1 = localViewBase2.findViewBaseByName("id_middle_body_wrapper");
    localViewBase2 = localViewBase2.findViewBaseByName("id_middle_body_container");
    if (localViewBase1 != null) {
      localViewBase1.setOnClickListener(new CommentBiuProteusItem.3(this, paramIReadInJoyModel, paramContainer));
    }
    if (localViewBase2 != null) {
      localViewBase2.setOnClickListener(new CommentBiuProteusItem.4(this, paramIReadInJoyModel, paramContainer));
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mFirstPagePicUrl)) {
        paramJSONObject.put("middle_content_cover_img_url", paramAbsBaseArticleInfo.mFirstPagePicUrl);
      } else {
        paramJSONObject.put("middle_content_cover_default_img", "article_no_img");
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) {
        paramJSONObject.put("middle_content_txt", paramAbsBaseArticleInfo.mTitle);
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("coverImgUrl=");
      paramJSONObject.append(paramAbsBaseArticleInfo.mFirstPagePicUrl);
      paramJSONObject.append(", middle_content_txt=");
      paramJSONObject.append(paramAbsBaseArticleInfo.mTitle);
      QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
      return;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("getImageDatmiddle_content_cover_img_urlaJson error, msg=");
      paramJSONObject.append(paramAbsBaseArticleInfo);
      QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    if (RIJFeedsType.X(paramAbsBaseArticleInfo)) {
      b(paramAbsBaseArticleInfo, paramJSONObject, paramMobileQQ);
    } else {
      c(paramAbsBaseArticleInfo, paramJSONObject, paramMobileQQ);
    }
    paramMobileQQ = new StringBuilder();
    paramMobileQQ.append("getVideoDataJson | isSmallVideoType ");
    paramMobileQQ.append(RIJFeedsType.X(paramAbsBaseArticleInfo));
    paramMobileQQ.append(" ; ");
    paramMobileQQ.append(paramJSONObject.toString());
    QLog.d("CommentBiuProteusItem", 2, paramMobileQQ.toString());
  }
  
  private static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
        Object localObject2 = null;
        if (localObject1 != null)
        {
          str = ((URL)localObject1).getPath();
          paramJSONObject.put("id_small_video_container", new JSONObject());
          paramJSONObject.put("small_video_image_url", str);
          paramJSONObject.put("comment_small_video_duration", ReadInJoyDisplayUtils.a(paramAbsBaseArticleInfo.mVideoDuration));
          paramJSONObject.put("small_video_title", paramAbsBaseArticleInfo.mTitle);
          paramJSONObject.put("comment_small_original_label", "原视频");
          if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.M != null))
          {
            localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.M.str_title.get();
          }
          else
          {
            localObject1 = localObject2;
            if (paramAbsBaseArticleInfo.columnEntrances != null)
            {
              localObject1 = localObject2;
              if (paramAbsBaseArticleInfo.columnEntrances.size() > 0)
              {
                VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)paramAbsBaseArticleInfo.columnEntrances.get(0);
                localObject1 = localObject2;
                if (localVideoColumnInfo.b != 0) {
                  localObject1 = localVideoColumnInfo.c;
                }
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramJSONObject.put("column_title", localObject1);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131915267));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("columnTitle =");
          paramJSONObject.append((String)localObject1);
          paramJSONObject.append(",imgUrl=");
          paramJSONObject.append(str);
          paramJSONObject.append(",duration=");
          paramJSONObject.append(paramAbsBaseArticleInfo.mVideoDuration);
          QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("getImageDataJson error, msg=");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
        return;
      }
      String str = null;
    }
  }
  
  private static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
        Object localObject2 = null;
        if (localObject1 != null)
        {
          str = ((URL)localObject1).getPath();
          paramJSONObject.put("id_big_video_container", new JSONObject());
          paramJSONObject.put("big_video_image_url", str);
          paramJSONObject.put("comment_big_video_duration", ReadInJoyDisplayUtils.a(paramAbsBaseArticleInfo.mVideoDuration));
          paramJSONObject.put("big_video_title", paramAbsBaseArticleInfo.mTitle);
          paramJSONObject.put("comment_big_original_label", "原视频");
          if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.M != null))
          {
            localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.M.str_title.get();
          }
          else
          {
            localObject1 = localObject2;
            if (paramAbsBaseArticleInfo.columnEntrances != null)
            {
              localObject1 = localObject2;
              if (paramAbsBaseArticleInfo.columnEntrances.size() > 0)
              {
                VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)paramAbsBaseArticleInfo.columnEntrances.get(0);
                localObject1 = localObject2;
                if (localVideoColumnInfo.b != 0) {
                  localObject1 = localVideoColumnInfo.c;
                }
              }
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramJSONObject.put("column_title", localObject1);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131915267));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("columnTitle =");
          paramJSONObject.append((String)localObject1);
          paramJSONObject.append(",imgUrl=");
          paramJSONObject.append(str);
          paramJSONObject.append(",duration=");
          paramJSONObject.append(paramAbsBaseArticleInfo.mVideoDuration);
          QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("getImageDataJson error, msg=");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
        return;
      }
      String str = null;
    }
  }
  
  private static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    int j = 0;
    try
    {
      int i;
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null))
      {
        i = paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size();
      }
      else
      {
        i = j;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)
        {
          i = j;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b != null) {
            i = paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size();
          }
        }
      }
      if ((i > 0) && (paramMobileQQ != null))
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(i);
        paramAbsBaseArticleInfo.append(paramMobileQQ.getString(2131915286));
        paramJSONObject.put("count_text", paramAbsBaseArticleInfo.toString());
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("getShortContentDataJson,count=");
      paramAbsBaseArticleInfo.append(i);
      QLog.d("CommentBiuProteusItem", 1, paramAbsBaseArticleInfo.toString());
      return;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("getImageDataJson error, msg=");
      paramJSONObject.append(paramAbsBaseArticleInfo);
      QLog.d("CommentBiuProteusItem", 1, paramJSONObject.toString());
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject2 = new JSONObject();
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      Object localObject3 = ReadInJoyUtils.b();
      Object localObject1 = null;
      if (localObject3 != null) {
        localObject1 = ((AppRuntime)localObject3).getApplication();
      }
      localObject3 = new ProteusItemDataBuilder();
      long l2 = 0L;
      long l1 = l2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
          l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
        }
      }
      ((ProteusItemDataBuilder)localObject3).v(paramAbsBaseArticleInfo).a("RIJ_biucomment_with_social_header").n(paramAbsBaseArticleInfo).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).h(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).u(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l1).a(paramAbsBaseArticleInfo, HardCodeUtil.a(2131915268));
      Util.a(paramAbsBaseArticleInfo, (JSONObject)localObject2);
      Util.y(paramAbsBaseArticleInfo, (JSONObject)localObject2);
      ((ProteusItemDataBuilder)localObject3).j(paramAbsBaseArticleInfo);
      if ((!paramAbsBaseArticleInfo.isPGCShortContent()) && (!RIJFeedsType.W(paramAbsBaseArticleInfo)))
      {
        if (RIJFeedsType.Y(paramAbsBaseArticleInfo))
        {
          localObject2 = ((ProteusItemDataBuilder)localObject3).o(paramAbsBaseArticleInfo).a();
          a(paramAbsBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
          return localObject2;
        }
        if (RIJFeedsType.V(paramAbsBaseArticleInfo))
        {
          localObject1 = ((ProteusItemDataBuilder)localObject3).a();
          a(paramAbsBaseArticleInfo, (JSONObject)localObject1);
          return localObject1;
        }
        localObject1 = new JSONObject();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("error! no type find!,info=");
        ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
        QLog.d("CommentBiuProteusItem", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      localObject2 = ((ProteusItemDataBuilder)localObject3).o(paramAbsBaseArticleInfo).a();
      d(paramAbsBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
    }
    QLog.d("CommentBiuProteusItem", 1, "getDataJson error!");
    return localObject2;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    try
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      Object localObject = (ImageBase)localViewBase.findViewBaseByName("id_background_imageView");
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.k() != null) && (paramIReadInJoyModel.k().showBreathAnimation) && (paramIReadInJoyModel.t() != null) && (paramIReadInJoyModel.t().getCurActivity() != null)) {
        a(((ImageBase)localObject).getNativeView(), paramIReadInJoyModel.t().getCurActivity(), paramIReadInJoyModel.k(), true);
      }
      localObject = (ArticleCommentView)localViewBase.findViewBaseByName("id_biu_comment");
      if ((localObject != null) && (paramIReadInJoyModel != null)) {
        ((ArticleCommentView)localObject).a(paramIReadInJoyModel);
      }
      BindViewHelper.f(localViewBase, paramIReadInJoyModel);
      if (paramIReadInJoyModel != null) {
        BindViewHelper.a(localViewBase, paramIReadInJoyModel.k());
      }
      BindViewHelper.a(localViewBase, paramIReadInJoyModel);
      Util.a(localViewBase, paramIReadInJoyModel);
      a(paramContainer, paramIReadInJoyModel);
      if (paramIReadInJoyModel != null)
      {
        paramContainer = paramIReadInJoyModel.k();
        if ((paramContainer != null) && (!paramContainer.isPGCShortContent()) && (!RIJFeedsType.Y(paramContainer)))
        {
          RIJFeedsType.W(paramContainer);
          return;
        }
      }
    }
    catch (Exception paramContainer)
    {
      paramIReadInJoyModel = new StringBuilder();
      paramIReadInJoyModel.append("bindView error!,msg= ");
      paramIReadInJoyModel.append(paramContainer);
      QLog.d("CommentBiuProteusItem", 1, paramIReadInJoyModel.toString());
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, Container paramContainer)
  {
    QLog.d("CommentBiuProteusItem", 1, "middlewrapper click");
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.k() != null) && (paramContainer != null) && (paramIReadInJoyModel.u() != null))
    {
      RIJJumpUtils.b(paramIReadInJoyModel.u().a(), paramIReadInJoyModel.k());
      RIJJumpUtils.a(paramIReadInJoyModel.u().a(), paramIReadInJoyModel.k(), (ReadInJoyBaseAdapter)paramIReadInJoyModel.u(), paramIReadInJoyModel.m());
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.CommentBiuProteusItem
 * JD-Core Version:    0.7.0.1
 */