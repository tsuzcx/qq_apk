package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyDraftboxAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDraftboxAdapter$1(ReadInJoyDraftboxAdapter paramReadInJoyDraftboxAdapter, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter), ReadInJoyDeliverUGCActivity.class);
    paramView.putExtra("readinjoy_draftbox_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxItem.getId());
    paramView.putExtra("is_from_kan_dian", true);
    paramView.putExtra("support_topic", true);
    if ((ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter) instanceof BaseActivity))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxItem.type == 0) {
        ((BaseActivity)ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter)).startActivityForResult(paramView, 1000);
      }
      paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxItem));
      localStringBuilder.append("");
      paramView.publicAccountReportClickEvent(null, "", "0X80096DF", "0X80096DF", 0, 0, localStringBuilder.toString(), "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter.1
 * JD-Core Version:    0.7.0.1
 */