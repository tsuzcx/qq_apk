import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;

public class ogl
  implements HorizontalListView.OnItemScrollEventListener
{
  public ogl(StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (StoryHomeHorizontalListView.a(this.a) != null) {
      StoryHomeHorizontalListView.a(this.a).a(paramInt, paramBoolean);
    }
    SLog.a("HorizontalListView", "on item scroll mHasMore=%b, mIsLoadingMore:%b", Boolean.valueOf(StoryHomeHorizontalListView.a(this.a)), Boolean.valueOf(StoryHomeHorizontalListView.b(this.a)));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogl
 * JD-Core Version:    0.7.0.1
 */