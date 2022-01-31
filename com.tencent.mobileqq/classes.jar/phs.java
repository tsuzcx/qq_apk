import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public abstract interface phs
{
  public abstract TemplateBean a(int paramInt, JSONObject paramJSONObject);
  
  public abstract JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo);
  
  public abstract void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2);
  
  public abstract boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phs
 * JD-Core Version:    0.7.0.1
 */