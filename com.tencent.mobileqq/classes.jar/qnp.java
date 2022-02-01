import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;

public class qnp
  implements qqa
{
  private void a(View paramView, Activity paramActivity, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramView == null) || (paramActivity == null)) {
      return;
    }
    paramView.setAlpha(1.0F);
    QLog.d("CommentBiuProteusItem", 2, "bindView | start CommentBiu Header Anim");
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, 2130772310);
    Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, 2130772311);
    localAnimation1.setFillAfter(true);
    localAnimation1.setAnimationListener(new qnq(this, paramView, localAnimation2));
    localAnimation2.setAnimationListener(new qnr(this, paramView, paramBoolean, paramActivity, paramArticleInfo));
    paramView.startAnimation(localAnimation1);
    pvj.a().a(paramArticleInfo);
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mFirstPagePicUrl)) {
        paramJSONObject.put("middle_content_cover_img_url", paramBaseArticleInfo.mFirstPagePicUrl);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) {
          paramJSONObject.put("middle_content_txt", paramBaseArticleInfo.mTitle);
        }
        QLog.d("CommentBiuProteusItem", 1, "coverImgUrl=" + paramBaseArticleInfo.mFirstPagePicUrl + ", middle_content_txt=" + paramBaseArticleInfo.mTitle);
        return;
        paramJSONObject.put("middle_content_cover_default_img", "article_no_img");
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("CommentBiuProteusItem", 1, "getImageDatmiddle_content_cover_img_urlaJson error, msg=" + paramBaseArticleInfo);
    }
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    if (pqw.y(paramBaseArticleInfo)) {
      b(paramBaseArticleInfo, paramJSONObject, paramMobileQQ);
    }
    for (;;)
    {
      QLog.d("CommentBiuProteusItem", 2, "getVideoDataJson | isSmallVideoType " + pqw.y(paramBaseArticleInfo) + " ; " + paramJSONObject.toString());
      return;
      c(paramBaseArticleInfo, paramJSONObject, paramMobileQQ);
    }
  }
  
  private void a(Container paramContainer, qfw paramqfw)
  {
    ViewBase localViewBase2 = paramContainer.getVirtualView();
    ViewBase localViewBase1 = localViewBase2.findViewBaseByName("id_middle_body_wrapper");
    localViewBase2 = localViewBase2.findViewBaseByName("id_middle_body_container");
    if (localViewBase1 != null) {
      localViewBase1.setOnClickListener(new qns(this, paramqfw, paramContainer));
    }
    if (localViewBase2 != null) {
      localViewBase2.setOnClickListener(new qnt(this, paramqfw, paramContainer));
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
        if (localObject == null) {
          break label274;
        }
        str = ((URL)localObject).getPath();
        paramJSONObject.put("id_small_video_container", new JSONObject());
        paramJSONObject.put("small_video_image_url", str);
        paramJSONObject.put("comment_small_video_duration", pjr.a(paramBaseArticleInfo.mVideoDuration));
        paramJSONObject.put("small_video_title", paramBaseArticleInfo.mTitle);
        paramJSONObject.put("comment_small_original_label", "原视频");
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131717637));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          QLog.d("CommentBiuProteusItem", 1, "columnTitle =" + (String)localObject + ",imgUrl=" + str + ",duration=" + paramBaseArticleInfo.mVideoDuration);
          return;
        }
        if ((paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
        {
          localObject = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
          if (((VideoColumnInfo)localObject).a != 0)
          {
            localObject = ((VideoColumnInfo)localObject).b;
            continue;
          }
        }
        localObject = null;
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
        return;
      }
      continue;
      label274:
      String str = null;
    }
  }
  
  private static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label279;
        }
        str = ((URL)localObject).getPath();
        paramJSONObject.put("id_big_video_container", new JSONObject());
        paramJSONObject.put("big_video_image_url", str);
        paramJSONObject.put("comment_big_video_duration", pjr.a(paramBaseArticleInfo.mVideoDuration));
        paramJSONObject.put("big_video_title", paramBaseArticleInfo.mTitle);
        paramJSONObject.put("comment_big_original_label", "原视频");
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131717637));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          QLog.d("CommentBiuProteusItem", 1, "columnTitle =" + (String)localObject + ",imgUrl=" + str + ",duration=" + paramBaseArticleInfo.mVideoDuration);
          return;
        }
        if ((paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
        {
          localObject = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
          if (((VideoColumnInfo)localObject).a != 0)
          {
            localObject = ((VideoColumnInfo)localObject).b;
            continue;
          }
        }
        localObject = null;
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
        return;
      }
      continue;
      label279:
      String str = null;
    }
  }
  
  private static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    int j = 0;
    try
    {
      int i;
      if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null)) {
        i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size();
      }
      for (;;)
      {
        if ((i > 0) && (paramMobileQQ != null)) {
          paramJSONObject.put("count_text", i + paramMobileQQ.getString(2131717649));
        }
        QLog.d("CommentBiuProteusItem", 1, "getShortContentDataJson,count=" + i);
        return;
        i = j;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null)
        {
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a != null) {
            i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.a.size();
          }
        }
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null))
    {
      QLog.d("CommentBiuProteusItem", 1, "getDataJson error!");
      return localJSONObject;
    }
    Object localObject2 = pkh.a();
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((AppRuntime)localObject2).getApplication();
    }
    localObject2 = new qlk();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a;
      }
    }
    ((qlk)localObject2).v(paramBaseArticleInfo).a("RIJ_biucomment_with_social_header").n(paramBaseArticleInfo).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).b(paramBaseArticleInfo).h(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).w(paramBaseArticleInfo).u(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).a(paramBaseArticleInfo, anvx.a(2131717638));
    qmm.a(paramBaseArticleInfo, localJSONObject);
    qmm.x(paramBaseArticleInfo, localJSONObject);
    if ("RIJ_biucomment_without_social_header".equals("RIJ_biucomment_with_social_header")) {
      ((qlk)localObject2).b(paramBaseArticleInfo, "id_bottom_dislike_button");
    }
    while ((paramBaseArticleInfo.isPGCShortContent()) || (pqw.x(paramBaseArticleInfo)))
    {
      localJSONObject = ((qlk)localObject2).o(paramBaseArticleInfo).a();
      d(paramBaseArticleInfo, localJSONObject, (MobileQQ)localObject1);
      return localJSONObject;
      ((qlk)localObject2).j(paramBaseArticleInfo);
    }
    if (pqw.z(paramBaseArticleInfo))
    {
      localJSONObject = ((qlk)localObject2).o(paramBaseArticleInfo).a();
      a(paramBaseArticleInfo, localJSONObject, (MobileQQ)localObject1);
      return localJSONObject;
    }
    if (pqw.w(paramBaseArticleInfo))
    {
      localObject1 = ((qlk)localObject2).a();
      a(paramBaseArticleInfo, (JSONObject)localObject1);
      return localObject1;
    }
    localObject1 = new JSONObject();
    QLog.d("CommentBiuProteusItem", 1, "error! no type find!,info=" + paramBaseArticleInfo);
    return localObject1;
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    try
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      Object localObject = (ImageBase)localViewBase.findViewBaseByName("id_background_imageView");
      if ((paramqfw != null) && (paramqfw.a() != null) && (paramqfw.a().showBreathAnimation) && (paramqfw.a() != null) && (paramqfw.a().getCurActivity() != null)) {
        a(((ImageBase)localObject).getNativeView(), paramqfw.a().getCurActivity(), paramqfw.a(), true);
      }
      localObject = (qsu)localViewBase.findViewBaseByName("id_biu_comment");
      if ((localObject != null) && (paramqfw != null)) {
        ((qsu)localObject).a(paramqfw);
      }
      qvn.f(localViewBase, paramqfw);
      if (paramqfw != null) {
        qvn.a(localViewBase, paramqfw.a());
      }
      qvn.a(localViewBase, paramqfw);
      qmm.a(localViewBase, paramqfw);
      a(paramContainer, paramqfw);
      if (paramqfw != null)
      {
        paramContainer = paramqfw.a();
        if ((paramContainer != null) && (!paramContainer.isPGCShortContent()) && (!pqw.z(paramContainer)))
        {
          boolean bool = pqw.x(paramContainer);
          if (!bool) {}
        }
      }
      return;
    }
    catch (Exception paramContainer)
    {
      QLog.d("CommentBiuProteusItem", 1, "bindView error!,msg= " + paramContainer);
    }
  }
  
  public void a(qfw paramqfw, Container paramContainer)
  {
    QLog.d("CommentBiuProteusItem", 1, "middlewrapper click");
    if ((paramqfw != null) && (paramqfw.a() != null) && (paramContainer != null) && (paramqfw.a() != null))
    {
      pqx.b(paramqfw.a().a(), paramqfw.a());
      pqx.a(paramqfw.a().a(), paramqfw.a(), paramqfw.a(), paramqfw.e());
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnp
 * JD-Core Version:    0.7.0.1
 */