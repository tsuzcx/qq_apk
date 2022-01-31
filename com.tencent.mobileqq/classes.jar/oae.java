import android.widget.ListAdapter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;

public class oae
  implements HorizontalListView.OnItemScrollEventListener
{
  public oae(StoryHomeHorizontalListView paramStoryHomeHorizontalListView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (StoryHomeHorizontalListView.a(this.a) != null) {
      StoryHomeHorizontalListView.a(this.a).a(paramInt, paramBoolean);
    }
    SLog.a("HorizontalListView", "on item scroll mHasMore=%b, mIsLoadingMore:%b", Boolean.valueOf(StoryHomeHorizontalListView.a(this.a)), Boolean.valueOf(StoryHomeHorizontalListView.b(this.a)));
    if (!StoryHomeHorizontalListView.a(this.a)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (StoryHomeHorizontalListView.b(this.a));
      paramInt = this.a.getLastVisiblePosition();
      i = this.a.a().getCount();
      SLog.a("HorizontalListView", "on item scroll last:%d, count:%d", Integer.valueOf(paramInt), Integer.valueOf(i));
    } while ((i - paramInt >= this.a.a) || (StoryHomeHorizontalListView.a(this.a) == null) || (!StoryHomeHorizontalListView.a(this.a).a(false)));
    StoryHomeHorizontalListView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oae
 * JD-Core Version:    0.7.0.1
 */