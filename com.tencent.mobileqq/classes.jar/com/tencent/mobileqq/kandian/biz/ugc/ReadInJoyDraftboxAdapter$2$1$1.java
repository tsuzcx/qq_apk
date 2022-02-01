package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ReadInJoyDraftboxAdapter$2$1$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1$1(ReadInJoyDraftboxAdapter.2.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter);
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2131712883;
    } else {
      i = 2131712750;
    }
    QQToast.a((Context)localObject, 2, HardCodeUtil.a(i), 1).a();
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxItem));
      localStringBuilder.append("");
      ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X80096E0", "0X80096E0", 0, 0, localStringBuilder.toString(), "", "", "", false);
      ReadInJoyDraftboxAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter).remove(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter$2$1.a.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */