import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class ope
  implements qft
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return qbv.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((parampxk != null) && (parampxk.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampxk.a())))
    {
      paramContainer = paramContainer.findViewBaseByName("id_article_triple_image_interact");
      if ((paramContainer != null) && ((paramContainer instanceof ots))) {
        ((ots)paramContainer).a(parampxk);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ope
 * JD-Core Version:    0.7.0.1
 */