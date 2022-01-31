import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class nui
  implements Runnable
{
  nui(nuh paramnuh, boolean paramBoolean) {}
  
  public void run()
  {
    int i1 = 0;
    if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "stream cancel on all function completed.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (Integer)this.jdField_a_of_type_Nuh.getFunctionResult(0);
      if (localObject != null) {
        DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a.mViewTotalTime = ((Integer)localObject).intValue();
      }
      if (DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a()) {}
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
          localObject = (nug)this.jdField_a_of_type_Nuh.getFunctionResult(i);
          if (localObject != null)
          {
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).b(((nug)localObject).jdField_a_of_type_JavaUtilList, true, ((nug)localObject).jdField_a_of_type_Boolean);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).b(((nug)localObject).jdField_a_of_type_Boolean, ((nug)localObject).jdField_a_of_type_Int);
            DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a.mHadLike = ((nug)localObject).b;
          }
          k += 1;
          i += 1;
        }
      }
      while (n < j)
      {
        localObject = (nuf)this.jdField_a_of_type_Nuh.getFunctionResult(m);
        if (localObject != null)
        {
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a(((nuf)localObject).jdField_a_of_type_JavaUtilList, true, ((nuf)localObject).jdField_a_of_type_Boolean);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a(((nuf)localObject).jdField_a_of_type_Boolean, ((nuf)localObject).jdField_a_of_type_Int);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a(((nuf)localObject).jdField_a_of_type_Boolean, ((nuf)localObject).b);
          DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a).a(((nuf)localObject).jdField_a_of_type_Boolean, ((nuf)localObject).jdField_a_of_type_JavaLangString);
        }
        n += 1;
        m += 1;
      }
      DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a, DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a));
      return;
    }
    DetailFeedAllInfoPullSegment.a(this.jdField_a_of_type_Nuh.a, new ErrorMessage(-1, "get feed interact data error."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */