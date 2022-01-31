import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import org.json.JSONObject;

public class peq
  implements php
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pds.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView().findViewBaseByName("id_artilce_title");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeTextImp)))
    {
      paramContainer = (NativeTextImp)paramContainer.getNativeView();
      paramContainer.setLines(2);
      paramContainer.setGravity(51);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peq
 * JD-Core Version:    0.7.0.1
 */