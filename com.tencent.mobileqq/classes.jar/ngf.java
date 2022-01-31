import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;

public class ngf
  implements Runnable
{
  public ngf(StoryInputBarView paramStoryInputBarView) {}
  
  public void run()
  {
    if (StoryInputBarView.a(this.a) != null) {
      StoryInputBarView.a(this.a).e();
    }
    StoryInputBarView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngf
 * JD-Core Version:    0.7.0.1
 */