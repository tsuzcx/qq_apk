import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class qmn
  implements qqa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    if (paramBaseArticleInfo == null) {
      return null;
    }
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.a.a;
      }
    }
    return new qlk().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).q(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").F(paramBaseArticleInfo).E(paramBaseArticleInfo).H(paramBaseArticleInfo).I(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    qvn.f(paramContainer, paramqfw);
    qsu localqsu = (qsu)paramContainer.findViewBaseByName("id_article_comment");
    if (localqsu != null) {
      localqsu.a(paramqfw);
    }
    qvn.a(paramContainer, paramqfw.a());
    qmm.a(paramContainer, paramqfw);
    qvn.c(paramContainer, paramqfw);
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmn
 * JD-Core Version:    0.7.0.1
 */