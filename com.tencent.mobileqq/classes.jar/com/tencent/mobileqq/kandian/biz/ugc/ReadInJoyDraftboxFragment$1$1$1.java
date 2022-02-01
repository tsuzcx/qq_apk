package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import java.util.List;

class ReadInJoyDraftboxFragment$1$1$1
  implements Runnable
{
  ReadInJoyDraftboxFragment$1$1$1(ReadInJoyDraftboxFragment.1.1 param1, List paramList) {}
  
  public void run()
  {
    ReadInJoyDraftboxFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxFragment$1$1.a.this$0).clear();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        localObject = (ReadInJoyDraftboxItem)this.jdField_a_of_type_JavaUtilList.get(i);
        if (ReadInJoyDraftboxFragment.a((ReadInJoyDraftboxItem)localObject)) {
          ReadInJoyDraftboxFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxFragment$1$1.a.this$0).add(localObject);
        }
        i -= 1;
      }
    }
    ReadInJoyDraftboxFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDraftboxFragment$1$1.a.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */