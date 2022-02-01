package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FeedItemCell$8
  implements Runnable
{
  FeedItemCell$8(FeedItemCell paramFeedItemCell, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((IReadInJoyModel)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a());
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headerUninterestConfirm,");
      Object localObject = this.b;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = ((ArrayList)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("FeedItemCell", 2, localStringBuilder.toString());
    }
    this.this$0.a.b(this.jdField_a_of_type_Int, localArrayList, this.b, this.jdField_a_of_type_JavaLangObject, false, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.8
 * JD-Core Version:    0.7.0.1
 */