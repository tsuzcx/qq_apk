import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;

public class naz
  implements Runnable
{
  public naz(StoryInputBarView paramStoryInputBarView) {}
  
  public void run()
  {
    if (StoryInputBarView.a(this.a) != null) {
      StoryInputBarView.a(this.a).e();
    }
    StoryInputBarView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     naz
 * JD-Core Version:    0.7.0.1
 */