package com.tencent.mobileqq.kandian.repo.feeds;

import android.os.Handler;
import java.util.List;

class RIJArticleInfoRepo$23
  implements Runnable
{
  RIJArticleInfoRepo$23(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt1, List paramList, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void run()
  {
    RIJArticleInfoRepo.a(this.this$0, this.jdField_a_of_type_Int);
    List localList2 = this.jdField_a_of_type_JavaUtilList;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = this.this$0.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    }
    if (RIJArticleInfoRepo.a(this.this$0) == null) {
      return;
    }
    RIJArticleInfoRepo.a(this.this$0).post(new RIJArticleInfoRepo.23.1(this, localList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.23
 * JD-Core Version:    0.7.0.1
 */