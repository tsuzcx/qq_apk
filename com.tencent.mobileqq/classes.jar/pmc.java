import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class pmc
  implements poa
{
  private BaseTemplateFactory a;
  
  public pmc(VafContext paramVafContext)
  {
    this.a = paramVafContext.getTemplateFactory();
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    if (this.a != null) {
      return this.a.getTemplateBean(paramJSONObject);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return new pjo().N(paramBaseArticleInfo).C(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_proteus_collection_view");
    if ((paramContainer instanceof ptw)) {
      ((ptw)paramContainer).a(parampgd);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmc
 * JD-Core Version:    0.7.0.1
 */