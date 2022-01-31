import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class peo
  implements php
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pdo.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    Object localObject;
    if ((parampau != null) && (parampau.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampau.a())))
    {
      localObject = paramContainer.findViewBaseByName("id_article_brand_optimization");
      TemplateBean localTemplateBean = parampau.a().mProteusTemplateBean;
      paramContainer = null;
      if (localTemplateBean != null) {
        paramContainer = localTemplateBean.findViewById("id_top_left_mask");
      }
      if ((localObject instanceof obv))
      {
        localObject = (obv)localObject;
        ((obv)localObject).a(parampau);
        if (paramContainer == null) {
          break label96;
        }
        ((obv)localObject).a(true);
      }
    }
    return;
    label96:
    ((obv)localObject).a(false);
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peo
 * JD-Core Version:    0.7.0.1
 */