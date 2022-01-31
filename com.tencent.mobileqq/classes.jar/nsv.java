import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class nsv
  implements Runnable
{
  nsv(nsu paramnsu, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Nsu.getFunctionResult(0);
      if (localObject != null) {
        DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a()) {}
      int m;
      int n;
      for (int j = 2;; j = 1)
      {
        int k = 0;
        int i = 1;
        for (;;)
        {
          m = i;
          n = i1;
          if (k >= j) {
            break;
          }
          localObject = (nst)this.jdField_a_of_type_Nsu.getFunctionResult(i);
          if (localObject != null)
          {
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).b(((nst)localObject).jdField_a_of_type_JavaUtilList, true, ((nst)localObject).jdField_a_of_type_Boolean);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).b(((nst)localObject).jdField_a_of_type_Boolean, ((nst)localObject).jdField_a_of_type_Int);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a.mHadLike = ((nst)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (nss)this.jdField_a_of_type_Nsu.getFunctionResult(m);
        if (localObject != null)
        {
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a(((nss)localObject).jdField_a_of_type_JavaUtilList, true, ((nss)localObject).jdField_a_of_type_Boolean);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a(((nss)localObject).jdField_a_of_type_Boolean, ((nss)localObject).jdField_a_of_type_Int);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a(((nss)localObject).jdField_a_of_type_Boolean, ((nss)localObject).b);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a).a(((nss)localObject).jdField_a_of_type_Boolean, ((nss)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a, DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a));
      return;
    }
    DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nsu.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsv
 * JD-Core Version:    0.7.0.1
 */