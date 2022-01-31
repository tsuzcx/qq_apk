import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.widget.ActionSheet.OnDismissListener;
import java.util.List;

public class nyy
  implements ActionSheet.OnDismissListener
{
  public nyy(FeedSegment paramFeedSegment, int paramInt) {}
  
  public void onDismiss()
  {
    StoryHomeFeed localStoryHomeFeed = (StoryHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.a.a().get(this.jdField_a_of_type_Int);
    FeedSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, localStoryHomeFeed, "clk_hide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyy
 * JD-Core Version:    0.7.0.1
 */