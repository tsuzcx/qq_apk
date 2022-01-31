import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;

public class ocy
  extends JobSegment
{
  private int jdField_a_of_type_Int;
  private CommentListPageLoader jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  protected void a(JobContext paramJobContext, FeedCommentSync paramFeedCommentSync)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader = new CommentListPageLoader(paramFeedCommentSync, new ocz(this, paramJobContext, paramFeedCommentSync));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCommentListPageLoader.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocy
 * JD-Core Version:    0.7.0.1
 */