import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class pkq
  implements poa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pjq.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject;
    if ((parampgd != null) && (parampgd.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampgd.a())))
    {
      localObject = paramContainer.findViewBaseByName("id_article_brand_optimization");
      TemplateBean localTemplateBean = parampgd.a().mProteusTemplateBean;
      paramContainer = null;
      if (localTemplateBean != null) {
        paramContainer = localTemplateBean.findViewById("id_top_left_mask");
      }
      if ((localObject instanceof ofn))
      {
        localObject = (ofn)localObject;
        ((ofn)localObject).a(parampgd);
        if (paramContainer == null) {
          break label96;
        }
        ((ofn)localObject).a(true);
      }
    }
    return;
    label96:
    ((ofn)localObject).a(false);
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkq
 * JD-Core Version:    0.7.0.1
 */