package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class DynamicProteusItem
  implements ProteusItem
{
  private BaseTemplateFactory a;
  
  public DynamicProteusItem(VafContext paramVafContext)
  {
    this.a = paramVafContext.getTemplateFactory();
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    BaseTemplateFactory localBaseTemplateFactory = this.a;
    if (localBaseTemplateFactory != null) {
      return localBaseTemplateFactory.getTemplateBean(paramJSONObject);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return new ProteusItemDataBuilder().N(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    ViewBase localViewBase = paramContainer.findViewBaseByName("id_proteus_collection_view");
    if ((localViewBase instanceof RvPolymericContainer)) {
      ((RvPolymericContainer)localViewBase).a(paramIReadInJoyModel);
    }
    BindViewHelper.f(paramContainer, paramIReadInJoyModel);
    BindViewHelper.e(paramContainer, paramIReadInJoyModel);
    BindViewHelper.a(paramContainer, paramIReadInJoyModel.k());
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DynamicProteusItem
 * JD-Core Version:    0.7.0.1
 */