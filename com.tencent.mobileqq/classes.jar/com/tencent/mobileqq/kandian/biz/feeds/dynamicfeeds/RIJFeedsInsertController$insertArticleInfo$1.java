package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJFeedsInsertController$insertArticleInfo$1
  implements Runnable
{
  public final void run()
  {
    List localList = RIJFeedsInsertController.a(RIJFeedsInsertController.a, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_JavaUtilList, null, 4, null);
    if (localList.size() != this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(localList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.notifyDataSetChanged();
      return;
    }
    QLog.i("RIJFeedsInsertController", 1, "[insertArticleInfo] no need to insert.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertController.insertArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */