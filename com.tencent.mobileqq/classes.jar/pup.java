import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class pup
  implements pye
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
    return new ptl().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).B(paramBaseArticleInfo).p(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).z(paramBaseArticleInfo).A(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).D(paramBaseArticleInfo).G(paramBaseArticleInfo).H(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    qdk.e(paramContainer, paramppu);
    qat localqat = (qat)paramContainer.findViewBaseByName("id_article_comment");
    if (localqat != null) {
      localqat.a(paramppu);
    }
    qdk.a(paramContainer, paramppu.a());
    puo.a(paramContainer, paramppu);
    qdk.b(paramContainer, paramppu);
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pup
 * JD-Core Version:    0.7.0.1
 */