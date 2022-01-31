import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class nyy
  implements Runnable
{
  nyy(nyx paramnyx, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Nyx.getFunctionResult(0);
      if (localObject != null) {
        DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a()) {}
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
          localObject = (nyw)this.jdField_a_of_type_Nyx.getFunctionResult(i);
          if (localObject != null)
          {
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).b(((nyw)localObject).jdField_a_of_type_JavaUtilList, true, ((nyw)localObject).jdField_a_of_type_Boolean);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).b(((nyw)localObject).jdField_a_of_type_Boolean, ((nyw)localObject).jdField_a_of_type_Int);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a.mHadLike = ((nyw)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (nyv)this.jdField_a_of_type_Nyx.getFunctionResult(m);
        if (localObject != null)
        {
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a(((nyv)localObject).jdField_a_of_type_JavaUtilList, true, ((nyv)localObject).jdField_a_of_type_Boolean);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a(((nyv)localObject).jdField_a_of_type_Boolean, ((nyv)localObject).jdField_a_of_type_Int);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a(((nyv)localObject).jdField_a_of_type_Boolean, ((nyv)localObject).b);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a).a(((nyv)localObject).jdField_a_of_type_Boolean, ((nyv)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a, DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a));
      return;
    }
    DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nyx.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyy
 * JD-Core Version:    0.7.0.1
 */