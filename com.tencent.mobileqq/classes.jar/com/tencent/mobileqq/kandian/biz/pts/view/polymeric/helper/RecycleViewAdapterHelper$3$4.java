package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyShareFragment;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class RecycleViewAdapterHelper$3$4
  implements ViewBase.OnClickListener
{
  RecycleViewAdapterHelper$3$4(RecycleViewAdapterHelper.3 param3) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ProteusSupportUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    paramViewBase = RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getData());
    if (paramViewBase == null)
    {
      QLog.e("RecycleViewAdapterHelper", 1, "daily share info is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("share_info_intent", paramViewBase.toString());
    PublicFragmentActivity.a(RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper).getContext(), localIntent, ReadInJoyDailyShareFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.3.4
 * JD-Core Version:    0.7.0.1
 */