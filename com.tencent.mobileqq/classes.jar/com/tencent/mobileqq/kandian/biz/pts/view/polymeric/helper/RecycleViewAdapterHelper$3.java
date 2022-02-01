package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSmallGameCardClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class RecycleViewAdapterHelper$3
  implements ViewFactory.FoundClickableViewListener
{
  RecycleViewAdapterHelper$3(RecycleViewAdapterHelper paramRecycleViewAdapterHelper, int paramInt, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper) != null)
    {
      paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.1(this));
      return;
    }
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    if (i != 1039)
    {
      if (i != 1041)
      {
        if (i != 1116)
        {
          if (i != 1135)
          {
            switch (i)
            {
            default: 
              return;
            case 1205: 
              RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper, 3, paramViewBase, this.jdField_a_of_type_Int);
              return;
            case 1204: 
              RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper, 2, paramViewBase, this.jdField_a_of_type_Int);
              return;
            }
            RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper, 1, paramViewBase, this.jdField_a_of_type_Int);
            return;
          }
          paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.4(this));
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a.a() != null)) {
          paramViewBase.setOnClickListener(new OnSmallGameCardClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a, RecycleViewAdapterHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper).getContext(), 1116, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a.c(), this.jdField_a_of_type_Int));
        }
      }
      else
      {
        paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.2(this));
      }
    }
    else {
      paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.3.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.3
 * JD-Core Version:    0.7.0.1
 */