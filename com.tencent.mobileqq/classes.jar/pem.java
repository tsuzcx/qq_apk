import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class pem
  implements php
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pdp.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    if ((parampau != null) && (parampau.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampau.a())))
    {
      Object localObject = paramContainer.findViewBaseByName("id_view_AdDownloadView");
      if ((localObject != null) && ((localObject instanceof ocb)))
      {
        localObject = (ocb)localObject;
        ((ocb)localObject).a(paramInt1);
        ((ocb)localObject).a(parampau, true);
      }
      paramContainer = paramContainer.findViewBaseByName("id_article_double_image");
      if ((paramContainer != null) && ((paramContainer instanceof ocw))) {
        ((ocw)paramContainer).a(parampau);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pem
 * JD-Core Version:    0.7.0.1
 */