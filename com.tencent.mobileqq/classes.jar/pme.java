import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class pme
  implements poa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    paramBaseArticleInfo = new pjo().M(paramBaseArticleInfo).C(paramBaseArticleInfo);
    switch (paramInt)
    {
    default: 
      paramBaseArticleInfo.a("ReadInjoy_small_cell");
    }
    for (;;)
    {
      return paramBaseArticleInfo.a();
      paramBaseArticleInfo.a("ReadInjoy_large_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pme
 * JD-Core Version:    0.7.0.1
 */