package com.tencent.mobileqq.kandian.biz.fastweb.item;

import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;

class WebPtsLiteViewCreator$PTSLiteItemViewHolder
  extends BaseItemViewHolder
{
  private boolean b = false;
  
  private WebPtsLiteViewCreator$PTSLiteItemViewHolder(WebPtsLiteViewCreator paramWebPtsLiteViewCreator, PTSItemView paramPTSItemView, BaseData paramBaseData)
  {
    super(paramPTSItemView, paramBaseData);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = WebPtsLiteViewCreator.a(this.a, paramBaseData2);
    if ((this.b) && ((this.f instanceof PTSItemView))) {
      ((ProteusItemData)paramBaseData2).bk.layoutToView((PTSItemView)this.f, WebPtsLiteViewCreator.b(this.a), true);
    }
    this.b = true;
    WebPtsLiteViewCreator.a(this.a, paramBaseData1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebPtsLiteViewCreator.PTSLiteItemViewHolder
 * JD-Core Version:    0.7.0.1
 */