import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;

public class obc
  extends ChildViewClickListener
{
  public obc(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (UIUtils.b()) {}
    while (paramView.getId() != 2131371786) {
      return;
    }
    StoryReportor.a("mystory", "clk_all_story", 0, 0, new String[0]);
    paramView = QQStoryContext.a().b();
    StoryApi.a(NewMyStorySegment.c(this.a), 1, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obc
 * JD-Core Version:    0.7.0.1
 */