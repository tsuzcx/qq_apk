import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class pkn
  implements poa
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
    return new pjo().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).q(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").F(paramBaseArticleInfo).E(paramBaseArticleInfo).H(paramBaseArticleInfo).I(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject = (pqg)paramContainer.findViewBaseByName("id_info_avator");
    if (localObject != null) {
      ((pqg)localObject).a(parampgd);
    }
    localObject = (pqe)paramContainer.findViewBaseByName("id_article_comment");
    if (localObject != null) {
      ((pqe)localObject).a(parampgd);
    }
    psw.a(paramContainer, parampgd.a());
    pkm.a(paramContainer, parampgd);
    psw.b(paramContainer, parampgd);
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkn
 * JD-Core Version:    0.7.0.1
 */