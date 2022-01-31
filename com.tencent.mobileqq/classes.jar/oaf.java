import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class oaf
  extends OnSimpleShareListener
{
  public oaf(DetailInteractSegment paramDetailInteractSegment, FeedItem paramFeedItem) {}
  
  public void a()
  {
    super.a();
    DetailInteractSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailInteractSegment, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("home_page", "suc_share", 2, paramInt, new String[] { StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem) + "", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem) + "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedItem.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oaf
 * JD-Core Version:    0.7.0.1
 */