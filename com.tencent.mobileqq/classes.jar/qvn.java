import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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

public class qvn
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
        localObject = pkg.a(l1, true);
        str2 = "";
        if ((!qmm.b(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo == null)) {
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
      return prg.a((String)localObject, 36);
      localObject = anvx.a(2131700648);
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
        String str = qmm.a(paramArticleInfo);
        paramViewBase.setText(str);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.proteus", 2, " " + paramArticleInfo + " time : " + str);
        return;
      }
    }
  }
  
  public static void a(ViewBase paramViewBase, qfw paramqfw)
  {
    if ((paramViewBase == null) || (paramqfw == null)) {}
    do
    {
      return;
      paramqfw = paramqfw.a();
    } while ((paramqfw == null) || (paramqfw.mSocialFeedInfo == null) || (paramqfw.mSocialFeedInfo.a == null));
    long l = paramqfw.mSocialFeedInfo.a.a;
    if ((paramqfw.mProteusTemplateBean != null) && (paramqfw.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {}
    for (paramViewBase = paramViewBase.findViewBaseByName("id_feeds_extra_info");; paramViewBase = paramViewBase.findViewBaseByName("id_extra_info"))
    {
      paramqfw = Aladdin.getConfig(393).getString("comment_social_header_description", "");
      if (!(paramViewBase instanceof qve)) {
        break;
      }
      ((qve)paramViewBase).a(l, paramqfw);
      return;
    }
  }
  
  public static void b(ViewBase paramViewBase, qfw paramqfw)
  {
    String str = "";
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_jump_channel_bar");
    paramViewBase = str;
    boolean bool;
    if (paramqfw != null)
    {
      paramViewBase = str;
      if (localViewBase != null)
      {
        bool = pqu.b();
        if ((!bool) || (!pqw.k(paramqfw.a()))) {
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
  
  public static void c(ViewBase paramViewBase, qfw paramqfw)
  {
    paramViewBase = (quh)paramViewBase.findViewBaseByName("id_socialize_recommend_follow");
    if (paramViewBase != null) {
      paramViewBase.a(paramqfw);
    }
  }
  
  public static void d(ViewBase paramViewBase, qfw paramqfw)
  {
    paramqfw = paramqfw.a();
    paramViewBase = paramViewBase.findViewBaseByName("id_flow_guide_separator");
    if (paramViewBase != null)
    {
      try
      {
        if (qmm.a(paramqfw))
        {
          if ((paramqfw != null) && (paramqfw.isPGCShortContent()))
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
  
  public static void e(ViewBase paramViewBase, qfw paramqfw)
  {
    ArticleInfo localArticleInfo = paramqfw.a();
    if (localArticleInfo == null) {
      return;
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(localArticleInfo.mSubscribeID);
        paramqfw = ReadInJoyUserInfoModule.a(l, null);
        if (paramqfw == null) {
          break;
        }
        if ((localArticleInfo.mProteusTemplateBean != null) && (localArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper")))
        {
          paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_feeds_nickname");
          if (paramViewBase == null) {
            break;
          }
          paramViewBase.setText(paramqfw.nick);
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
  
  public static void f(ViewBase paramViewBase, qfw paramqfw)
  {
    if ((paramqfw == null) || (paramqfw.a() == null)) {}
    for (;;)
    {
      return;
      ArticleInfo localArticleInfo = paramqfw.a();
      if ((localArticleInfo.mProteusTemplateBean != null) && (localArticleInfo.mProteusTemplateBean.getViewDataBinding().containsKey("id_feeds_social_header_wrapper"))) {}
      for (paramViewBase = (qsw)paramViewBase.findViewBaseByName("id_feeds_info_avator"); paramViewBase != null; paramViewBase = (qsw)paramViewBase.findViewBaseByName("id_info_avator"))
      {
        paramViewBase.a(paramqfw);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvn
 * JD-Core Version:    0.7.0.1
 */