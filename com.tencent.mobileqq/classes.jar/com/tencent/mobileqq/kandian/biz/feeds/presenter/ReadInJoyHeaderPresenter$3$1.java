package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ReadInJoyHeaderPresenter$3$1
  implements Runnable
{
  ReadInJoyHeaderPresenter$3$1(ReadInJoyHeaderPresenter.3 param3) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((IReadInJoyModel)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headerUninterestConfirm,");
      String str;
      if (this.a.b == null) {
        str = "null";
      } else {
        str = this.a.b.toString();
      }
      localStringBuilder.append(str);
      QLog.d("ReadInJoyHeaderPresenter", 2, localStringBuilder.toString());
    }
    ReadInJoyHeaderPresenter.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterReadInJoyHeaderPresenter).a(this.a.jdField_a_of_type_Int, localArrayList, this.a.b, this.a.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter.3.1
 * JD-Core Version:    0.7.0.1
 */