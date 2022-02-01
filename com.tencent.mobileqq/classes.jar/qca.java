import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class qca
  implements qdy
{
  private BaseTemplateFactory a;
  
  public qca(VafContext paramVafContext)
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
    return new pzf().M(paramBaseArticleInfo).B(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_proteus_collection_view");
    if ((paramContainer instanceof qki)) {
      ((qki)paramContainer).a(parampvc);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qca
 * JD-Core Version:    0.7.0.1
 */