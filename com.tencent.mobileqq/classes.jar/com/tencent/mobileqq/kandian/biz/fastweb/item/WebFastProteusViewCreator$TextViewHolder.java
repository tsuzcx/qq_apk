package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusBookData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import org.json.JSONObject;

class WebFastProteusViewCreator$TextViewHolder
  extends BaseItemViewHolder
{
  private Container a;
  
  public WebFastProteusViewCreator$TextViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.a = ((Container)paramView);
    }
  }
  
  private JSONObject a(ProteusBookData paramProteusBookData)
  {
    if (paramProteusBookData.aR != null) {
      return paramProteusBookData.aR.a(paramProteusBookData.c);
    }
    return null;
  }
  
  private void a()
  {
    ViewFactory.findClickableViewListener(this.a.getVirtualView(), new WebFastProteusViewCreator.TextViewHolder.1(this));
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP != 18) {
      return;
    }
    if (this.a == null) {
      return;
    }
    paramBaseData1 = (ProteusBookData)paramBaseData2;
    if (paramBaseData1.b != null)
    {
      paramBaseData1.b.putDynamicJson(a(paramBaseData1));
      ProteusSupportUtil.a(this.a.getVirtualView(), paramBaseData1.b.getViewBean());
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastProteusViewCreator.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */