package com.tencent.mobileqq.kandian.biz.ugc;

import java.util.List;

class PageLoadManager$1$1
  implements Runnable
{
  PageLoadManager$1$1(PageLoadManager.1 param1, List paramList) {}
  
  public void run()
  {
    PageLoadManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0, PageLoadManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0) + this.jdField_a_of_type_JavaUtilList.size());
    PageLoadManager localPageLoadManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0;
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    PageLoadManager.a(localPageLoadManager, bool);
    if (PageLoadManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0) != null) {
      PageLoadManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0).a(this.jdField_a_of_type_JavaUtilList, PageLoadManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0));
    }
    PageLoadManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$1.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager.1.1
 * JD-Core Version:    0.7.0.1
 */