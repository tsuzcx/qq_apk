import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
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

public class plq
  implements poa
{
  private String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mChannelID == 70L) || (a(paramBaseArticleInfo)) || (a())) {
      return "RIJ_biucomment_with_social_header";
    }
    return "RIJ_biucomment_without_social_header";
  }
  
  private void a(View paramView, Activity paramActivity, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramView == null) || (paramActivity == null)) {
      return;
    }
    paramView.setAlpha(1.0F);
    QLog.d("CommentBiuProteusItem", 2, "bindView | start CommentBiu Header Anim");
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, 2130772304);
    Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, 2130772305);
    localAnimation1.setFillAfter(true);
    localAnimation1.setAnimationListener(new plr(this, paramView, localAnimation2));
    localAnimation2.setAnimationListener(new pls(this, paramView, paramBoolean, paramActivity, paramArticleInfo));
    paramView.startAnimation(localAnimation1);
    owy.a().a(paramArticleInfo);
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
        paramJSONObject.put("video_duration", orc.a(paramBaseArticleInfo.mVideoDuration));
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131718781));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          QLog.d("CommentBiuProteusItem", 1, "columnTitle =" + (String)localObject + ",imgUrl=" + str + ",duration=" + paramBaseArticleInfo.mVideoDuration);
          return;
        }
        if ((paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
        {
          localObject = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
          if (((VideoColumnInfo)localObject).jdField_a_of_type_Int != 0)
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
  
  private void a(Container paramContainer, pgd parampgd)
  {
    ViewBase localViewBase2 = paramContainer.getVirtualView();
    ViewBase localViewBase1 = localViewBase2.findViewBaseByName("id_middle_body_wrapper");
    localViewBase2 = localViewBase2.findViewBaseByName("id_middle_body_container");
    if (localViewBase1 != null) {
      localViewBase1.setOnClickListener(new plt(this, parampgd, paramContainer));
    }
    if (localViewBase2 != null) {
      localViewBase2.setOnClickListener(new plu(this, parampgd, paramContainer));
    }
  }
  
  private boolean a()
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(ors.a(), null);
    if ((localReadInJoyUserInfo != null) && ((!TextUtils.isEmpty(localReadInJoyUserInfo.largeIconUrl)) || (!TextUtils.isEmpty(localReadInJoyUserInfo.smallIconUrl)))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("CommentBiuProteusItem", 1, "isSelfUserTypeV: " + bool);
      return bool;
    }
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null)
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Int == 1) {
            bool1 = true;
          }
        }
      }
    }
    QLog.d("CommentBiuProteusItem", 1, "isUserTypeV: " + bool1);
    return bool1;
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    int j = 0;
    try
    {
      int i;
      if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a != null)) {
        i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a.size();
      }
      for (;;)
      {
        if ((i > 0) && (paramMobileQQ != null)) {
          paramJSONObject.put("count_text", i + paramMobileQQ.getString(2131718789));
        }
        QLog.d("CommentBiuProteusItem", 1, "getShortContentDataJson,count=" + i);
        return;
        i = j;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null)
        {
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a != null) {
            i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.a.size();
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
    Object localObject2 = ors.a();
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((AppRuntime)localObject2).getApplication();
    }
    localObject2 = new pjo();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
      }
    }
    String str = a(paramBaseArticleInfo);
    ((pjo)localObject2).v(paramBaseArticleInfo).a(str).n(paramBaseArticleInfo).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).b(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).w(paramBaseArticleInfo).u(paramBaseArticleInfo).a(paramBaseArticleInfo, l1);
    if ("RIJ_biucomment_without_social_header".equals(str)) {
      ((pjo)localObject2).b(paramBaseArticleInfo, "id_bottom_dislike_button");
    }
    while ((paramBaseArticleInfo.isPGCShortContent()) || (ors.z(paramBaseArticleInfo)))
    {
      localObject2 = ((pjo)localObject2).o(paramBaseArticleInfo).a();
      b(paramBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
      ((pjo)localObject2).j(paramBaseArticleInfo);
    }
    if (ors.A(paramBaseArticleInfo))
    {
      localObject2 = ((pjo)localObject2).o(paramBaseArticleInfo).a();
      a(paramBaseArticleInfo, (JSONObject)localObject2, (MobileQQ)localObject1);
      return localObject2;
    }
    if (ors.y(paramBaseArticleInfo))
    {
      localObject1 = ((pjo)localObject2).a();
      a(paramBaseArticleInfo, (JSONObject)localObject1);
      return localObject1;
    }
    localObject1 = new JSONObject();
    QLog.d("CommentBiuProteusItem", 1, "error! no type find!,info=" + paramBaseArticleInfo);
    return localObject1;
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    for (;;)
    {
      try
      {
        ViewBase localViewBase = paramContainer.getVirtualView();
        Object localObject = (ImageBase)localViewBase.findViewBaseByName("id_background_imageView");
        if ((parampgd != null) && (parampgd.a() != null) && (parampgd.a().showBreathAnimation) && (parampgd.a() != null) && (parampgd.a().getCurActivity() != null)) {
          a(((ImageBase)localObject).getNativeView(), parampgd.a().getCurActivity(), parampgd.a(), true);
        }
        localObject = (pqe)localViewBase.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((pqe)localObject).a(parampgd);
        }
        localObject = (pqg)localViewBase.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((pqg)localObject).a(parampgd);
        }
        pkm.a(localViewBase, parampgd);
        a(paramContainer, parampgd);
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (parampgd != null)
        {
          paramContainer = parampgd.a();
          paramInt1 = paramInt2;
          if (paramContainer != null)
          {
            if ((paramContainer.isPGCShortContent()) || (ors.A(paramContainer))) {
              break label265;
            }
            paramInt1 = paramInt2;
            if (ors.z(paramContainer)) {
              break label265;
            }
          }
        }
        if (paramInt1 == 0) {
          break;
        }
        paramContainer = (pss)localViewBase.findViewBaseByName("id_summary");
        if (paramContainer != null)
        {
          paramContainer.a(parampgd);
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
      label265:
      paramInt1 = 1;
    }
  }
  
  public void a(pgd parampgd, Container paramContainer)
  {
    QLog.d("CommentBiuProteusItem", 1, "middlewrapper click");
    if ((parampgd != null) && (parampgd.a() != null) && (paramContainer != null) && (parampgd.a() != null))
    {
      ors.b(parampgd.a().a(), parampgd.a());
      ors.a(parampgd.a().a(), parampgd.a(), parampgd.a(), parampgd.e());
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     plq
 * JD-Core Version:    0.7.0.1
 */