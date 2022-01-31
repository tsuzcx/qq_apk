import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class otm
  implements owa
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
    return new osn().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).e(paramBaseArticleInfo).f(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).B(paramBaseArticleInfo).p(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).z(paramBaseArticleInfo).A(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).D(paramBaseArticleInfo).G(paramBaseArticleInfo).H(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject = (oyf)paramContainer.findViewBaseByName("id_info_avator");
    if (localObject != null) {
      ((oyf)localObject).a(paramopw);
    }
    localObject = (oyd)paramContainer.findViewBaseByName("id_article_comment");
    if (localObject != null) {
      ((oyd)localObject).a(paramopw);
    }
    paz.a(paramContainer, paramopw.a());
    otl.a(paramContainer, paramopw);
    paz.b(paramContainer, paramopw);
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otm
 * JD-Core Version:    0.7.0.1
 */