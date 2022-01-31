import android.graphics.Rect;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.FakeFeedViewUpdateCompletedEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class nyv
  implements Runnable
{
  public nyv(FeedSegment paramFeedSegment, Rect paramRect) {}
  
  public void run()
  {
    FeedSegment.FakeFeedViewUpdateCompletedEvent localFakeFeedViewUpdateCompletedEvent = new FeedSegment.FakeFeedViewUpdateCompletedEvent(this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    Dispatchers.get().dispatch(localFakeFeedViewUpdateCompletedEvent);
    SLog.b("Q.qqstory.home:FeedSegment_animation", "发了动画时间过去了 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyv
 * JD-Core Version:    0.7.0.1
 */