import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;

public class qdk
{
  public static CharSequence a(ArticleInfo paramArticleInfo)
  {
    Object localObject;
    String str2;
    String str1;
    if (paramArticleInfo != null)
    {
      long l2 = paramArticleInfo.mTime;
      long l1 = l2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        if (paramArticleInfo.mSocialFeedInfo.e > 0) {
          l1 = paramArticleInfo.mSocialFeedInfo.e;
        }
      }
      if (l1 > 0L)
      {
        localObject = ozr.a(l1, true);
        str2 = "";
        if ((!puo.b(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo == null)) {
          break label105;
        }
        str1 = paramArticleInfo.mSocialFeedInfo.d;
        label79:
        if (!TextUtils.isEmpty(str1)) {
          break label171;
        }
      }
    }
    for (;;)
    {
      return ozs.a((String)localObject, 36);
      localObject = anzj.a(2131700062);
      break;
      label105:
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label79;
      }
      str1 = str2;
      if (TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.d)) {
        break label79;
      }
      str1 = (String)localObject + " · " + paramArticleInfo.mSocialFeedInfo.d;
      break label79;
      return "";
      label171:
      localObject = str1;
    }
  }
  
  public static void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    label105:
    for (;;)
    {
      return;
      if ((paramArticleInfo.mProteusTemplateBean != null) && (paramArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {}
      for (paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_feeds_biu_time");; paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_biu_time"))
      {
        if (paramViewBase == null) {
          break label105;
        }
        String str = puo.a(paramArticleInfo);
        paramViewBase.setText(str);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.proteus", 2, " " + paramArticleInfo + " time : " + str);
        return;
      }
    }
  }
  
  public static void a(ViewBase paramViewBase, ppu paramppu)
  {
    String str = "";
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_jump_channel_bar");
    paramViewBase = str;
    boolean bool;
    if (paramppu != null)
    {
      paramViewBase = str;
      if (localViewBase != null)
      {
        bool = ozs.c();
        if ((!bool) || (!ozs.k(paramppu.a()))) {
          break label93;
        }
        localViewBase.setVisibility(0);
      }
    }
    for (paramViewBase = str;; paramViewBase = "no data bind, isintab:" + bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.proteus", 2, "bindJumpChannel,flag" + false + " resong : " + paramViewBase);
      }
      return;
      label93:
      localViewBase.setVisibility(8);
    }
  }
  
  public static void b(ViewBase paramViewBase, ppu paramppu)
  {
    paramViewBase = (qcf)paramViewBase.findViewBaseByName("id_socialize_recommend_follow");
    if (paramViewBase != null) {
      paramViewBase.a(paramppu);
    }
  }
  
  public static void c(ViewBase paramViewBase, ppu paramppu)
  {
    paramppu = paramppu.a();
    paramViewBase = paramViewBase.findViewBaseByName("id_flow_guide_separator");
    if (paramViewBase != null)
    {
      try
      {
        if (puo.a(paramppu))
        {
          if ((paramppu != null) && (paramppu.isPGCShortContent()))
          {
            paramViewBase.setVisibility(0);
            return;
          }
          paramViewBase.setVisibility(8);
          return;
        }
      }
      catch (JSONException paramViewBase)
      {
        QLog.e("BindViewHelper", 2, paramViewBase.getMessage());
        return;
      }
      paramViewBase.setVisibility(8);
    }
  }
  
  public static void d(ViewBase paramViewBase, ppu paramppu)
  {
    ArticleInfo localArticleInfo = paramppu.a();
    if (localArticleInfo == null) {
      return;
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(localArticleInfo.mSubscribeID);
        paramppu = ReadInJoyUserInfoModule.a(l, null);
        if (paramppu == null) {
          break;
        }
        if ((localArticleInfo.mProteusTemplateBean != null) && (localArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper")))
        {
          paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_feeds_nickname");
          if (paramViewBase == null) {
            break;
          }
          paramViewBase.setText(paramppu.nick);
          return;
        }
      }
      catch (NumberFormatException paramViewBase)
      {
        paramViewBase.printStackTrace();
        return;
      }
      paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_nickname");
    }
  }
  
  public static void e(ViewBase paramViewBase, ppu paramppu)
  {
    if ((paramppu == null) || (paramppu.a() == null)) {}
    for (;;)
    {
      return;
      ArticleInfo localArticleInfo = paramppu.a();
      if ((localArticleInfo.mProteusTemplateBean != null) && (localArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {}
      for (paramViewBase = (qav)paramViewBase.findViewBaseByName("id_feeds_info_avator"); paramViewBase != null; paramViewBase = (qav)paramViewBase.findViewBaseByName("id_info_avator"))
      {
        paramViewBase.a(paramppu);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdk
 * JD-Core Version:    0.7.0.1
 */