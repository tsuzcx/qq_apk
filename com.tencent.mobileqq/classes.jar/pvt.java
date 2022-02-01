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

public class pvt
  implements pye
{
  private void a(View paramView, Activity paramActivity, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramView == null) || (paramActivity == null)) {
      return;
    }
    paramView.setAlpha(1.0F);
    QLog.d("CommentBiuProteusItem", 2, "bindView | start CommentBiu Header Anim");
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, 2130772313);
    Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, 2130772314);
    localAnimation1.setFillAfter(true);
    localAnimation1.setAnimationListener(new pvu(this, paramView, localAnimation2));
    localAnimation2.setAnimationListener(new pvv(this, paramView, paramBoolean, paramActivity, paramArticleInfo));
    paramView.startAnimation(localAnimation1);
    pfa.a().a(paramArticleInfo);
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
    for (;;)
    {
      try
      {
        Object localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label239;
        }
        str = ((URL)localObject).getPath();
        paramJSONObject.put("video_image_url", str);
        paramJSONObject.put("video_duration", ozc.a(paramBaseArticleInfo.mVideoDuration));
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131717038));
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
      label239:
      String str = null;
    }
  }
  
  private void a(Container paramContainer, ppu paramppu)
  {
    ViewBase localViewBase2 = paramContainer.getVirtualView();
    ViewBase localViewBase1 = localViewBase2.findViewBaseByName("id_middle_body_wrapper");
    localViewBase2 = localViewBase2.findViewBaseByName("id_middle_body_container");
    if (localViewBase1 != null) {
      localViewBase1.setOnClickListener(new pvw(this, paramppu, paramContainer));
    }
    if (localViewBase2 != null) {
      localViewBase2.setOnClickListener(new pvx(this, paramppu, paramContainer));
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    int j = 0;
    try
    {
      int i;
      if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a != null)) {
        i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a.size();
      }
      for (;;)
      {
        if ((i > 0) && (paramMobileQQ != null)) {
          paramJSONObject.put("count_text", i + paramMobileQQ.getString(2131717048));
        }
        QLog.d("CommentBiuProteusItem", 1, "getShortContentDataJson,count=" + i);
        return;
        i = j;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null)
        {
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.a != null) {
            i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.a.size();
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
    Object localObject1 = new JSONObject();
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null))
    {
      QLog.d("CommentBiuProteusItem", 1, "getDataJson error!");
      return localObject1;
    }
    Object localObject2 = ozs.a();
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((AppRuntime)localObject2).getApplication();
    }
    localObject2 = new ptl();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.a;
      }
    }
    ((ptl)localObject2).u(paramBaseArticleInfo).a("RIJ_biucomment_with_social_header").m(paramBaseArticleInfo).f(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo).b(paramBaseArticleInfo).j(paramBaseArticleInfo).B(paramBaseArticleInfo).q(paramBaseArticleInfo).v(paramBaseArticleInfo).t(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).a(paramBaseArticleInfo, anzj.a(2131717039));
    if ("RIJ_biucomment_without_social_header".equals("RIJ_biucomment_with_social_header")) {
      ((ptl)localObject2).b(paramBaseArticleInfo, "id_bottom_dislike_button");
    }
    while ((paramBaseArticleInfo.isPGCShortContent()) || (ozs.z(paramBaseArticleInfo)))
    {
      localObject2 = ((ptl)localObject2).n(paramBaseArticleInfo).a();
      b(paramBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
      ((ptl)localObject2).i(paramBaseArticleInfo);
    }
    if (ozs.A(paramBaseArticleInfo))
    {
      localObject2 = ((ptl)localObject2).n(paramBaseArticleInfo).a();
      a(paramBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
    }
    if (ozs.y(paramBaseArticleInfo))
    {
      localObject1 = ((ptl)localObject2).a();
      a(paramBaseArticleInfo, (JSONObject)localObject1);
      return localObject1;
    }
    localObject1 = new JSONObject();
    QLog.d("CommentBiuProteusItem", 1, "error! no type find!,info=" + paramBaseArticleInfo);
    return localObject1;
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    for (;;)
    {
      try
      {
        ViewBase localViewBase = paramContainer.getVirtualView();
        Object localObject = (ImageBase)localViewBase.findViewBaseByName("id_background_imageView");
        if ((paramppu != null) && (paramppu.a() != null) && (paramppu.a().showBreathAnimation) && (paramppu.a() != null) && (paramppu.a().getCurActivity() != null)) {
          a(((ImageBase)localObject).getNativeView(), paramppu.a().getCurActivity(), paramppu.a(), true);
        }
        localObject = (qat)localViewBase.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((qat)localObject).a(paramppu);
        }
        qdk.e(localViewBase, paramppu);
        if (paramppu != null) {
          qdk.a(localViewBase, paramppu.a());
        }
        puo.a(localViewBase, paramppu);
        a(paramContainer, paramppu);
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (paramppu != null)
        {
          paramContainer = paramppu.a();
          paramInt1 = paramInt2;
          if (paramContainer != null)
          {
            if ((paramContainer.isPGCShortContent()) || (ozs.A(paramContainer))) {
              break label262;
            }
            paramInt1 = paramInt2;
            if (ozs.z(paramContainer)) {
              break label262;
            }
          }
        }
        if (paramInt1 == 0) {
          break;
        }
        paramContainer = (qdg)localViewBase.findViewBaseByName("id_summary");
        if (paramContainer != null)
        {
          paramContainer.a(paramppu);
          return;
        }
        QLog.d("CommentBiuProteusItem", 1, "bindView error!,summaryView is null= ");
        return;
      }
      catch (Exception paramContainer)
      {
        QLog.d("CommentBiuProteusItem", 1, "bindView error!,msg= " + paramContainer);
        return;
      }
      label262:
      paramInt1 = 1;
    }
  }
  
  public void a(ppu paramppu, Container paramContainer)
  {
    QLog.d("CommentBiuProteusItem", 1, "middlewrapper click");
    if ((paramppu != null) && (paramppu.a() != null) && (paramContainer != null) && (paramppu.a() != null))
    {
      ozs.b(paramppu.a().a(), paramppu.a());
      ozs.a(paramppu.a().a(), paramppu.a(), paramppu.a(), paramppu.e());
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvt
 * JD-Core Version:    0.7.0.1
 */