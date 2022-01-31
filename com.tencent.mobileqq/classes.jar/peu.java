import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class peu
  implements phs
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pdx.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((parampax != null) && (parampax.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampax.a())))
    {
      paramContainer = paramContainer.findViewBaseByName("id_article_triple_image_interact");
      if ((paramContainer != null) && ((paramContainer instanceof ode))) {
        ((ode)paramContainer).a(parampax);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peu
 * JD-Core Version:    0.7.0.1
 */