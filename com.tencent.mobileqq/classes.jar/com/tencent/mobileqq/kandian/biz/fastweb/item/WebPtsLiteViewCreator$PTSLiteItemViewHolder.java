package com.tencent.mobileqq.kandian.biz.fastweb.item;

import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;

class WebPtsLiteViewCreator$PTSLiteItemViewHolder
  extends BaseItemViewHolder
{
  private boolean jdField_a_of_type_Boolean = false;
  
  private WebPtsLiteViewCreator$PTSLiteItemViewHolder(WebPtsLiteViewCreator paramWebPtsLiteViewCreator, PTSItemView paramPTSItemView, BaseData paramBaseData)
  {
    super(paramPTSItemView, paramBaseData);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = WebPtsLiteViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebPtsLiteViewCreator, paramBaseData2);
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView instanceof PTSItemView))) {
      ((ProteusItemData)paramBaseData2).a.layoutToView((PTSItemView)this.jdField_a_of_type_AndroidViewView, WebPtsLiteViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebPtsLiteViewCreator), true);
    }
    this.jdField_a_of_type_Boolean = true;
    WebPtsLiteViewCreator.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebPtsLiteViewCreator, paramBaseData1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebPtsLiteViewCreator.PTSLiteItemViewHolder
 * JD-Core Version:    0.7.0.1
 */