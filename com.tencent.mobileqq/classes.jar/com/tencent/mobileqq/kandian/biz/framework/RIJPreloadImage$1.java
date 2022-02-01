package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

class RIJPreloadImage$1
  implements Runnable
{
  RIJPreloadImage$1(RIJPreloadImage paramRIJPreloadImage, long paramLong1, List paramList, int paramInt1, int paramInt2, RIJDataManager paramRIJDataManager, long paramLong2) {}
  
  public void run()
  {
    if (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    localObject = new LinkedList();
    int j = this.jdField_a_of_type_Int;
    while (j < this.jdField_a_of_type_Int + this.jdField_b_of_type_Int)
    {
      if ((j < i) && (j >= 0))
      {
        if (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long) {
          return;
        }
        try
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          this.this$0.a((List)localObject, j, localAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long) {
            return;
          }
        }
      }
      j += 1;
    }
    if (RIJPreloadImage.a(this.this$0) != this.jdField_a_of_type_Long) {
      return;
    }
    RIJPreloadImage.a(this.this$0, (List)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadImg size:");
      localStringBuilder.append(((List)localObject).size());
      localStringBuilder.append(" cost:");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      QLog.d("RIJPreloadImage", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage.1
 * JD-Core Version:    0.7.0.1
 */