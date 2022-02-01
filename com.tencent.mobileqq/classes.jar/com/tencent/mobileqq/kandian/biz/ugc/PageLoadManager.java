package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class PageLoadManager<T>
{
  private int jdField_a_of_type_Int = 0;
  private PageLoadManager.QueryProvider<T> jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$QueryProvider = null;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 100;
  private boolean jdField_b_of_type_Boolean = false;
  
  public void a()
  {
    PageLoadManager.QueryProvider localQueryProvider = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$QueryProvider;
    if (localQueryProvider == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PageLoadManager", 2, "mQueryProvider is not registered, can't query data...");
      }
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "requestNextPage cancel for mHasMore is false");
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestNextPage mOffset:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" mPageSize:$mPageSize");
      QLog.i("PageLoadManager", 2, localStringBuilder.toString());
    }
    ThreadManager.executeOnSubThread(new PageLoadManager.1(this, localQueryProvider));
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "onPositionShow return for mHasMore is false");
      }
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "query is doing...");
      }
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (paramInt >= (i - this.jdField_b_of_type_Int + i) / 2) {
      a();
    }
  }
  
  public void a(PageLoadManager.QueryProvider<T> paramQueryProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager$QueryProvider = paramQueryProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager
 * JD-Core Version:    0.7.0.1
 */