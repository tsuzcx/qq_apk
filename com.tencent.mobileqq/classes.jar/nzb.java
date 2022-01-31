import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListRequest;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

public class nzb
  extends ParallelJobSegment
{
  public int a;
  
  public nzb(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    DetailLikeListLoader.GetLikeListRequest localGetLikeListRequest = new DetailLikeListLoader.GetLikeListRequest();
    localGetLikeListRequest.jdField_a_of_type_JavaLangString = paramString;
    localGetLikeListRequest.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != -1) {
      localGetLikeListRequest.c = this.jdField_a_of_type_Int;
    }
    CmdTaskManger.a().a(localGetLikeListRequest, new nzc(this, paramJobContext, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzb
 * JD-Core Version:    0.7.0.1
 */