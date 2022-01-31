import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.ArrayList;

public class oge
  extends ChildViewClickListener
{
  public oge(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    boolean bool;
    switch (paramView.getId())
    {
    default: 
      if (NewMyStorySegment.a(this.a).a().size() <= 0) {
        break label149;
      }
      paramView = this.a;
      if (!NewMyStorySegment.a(this.a))
      {
        bool = true;
        NewMyStorySegment.a(paramView, bool);
        NewMyStorySegment.a(this.a);
        if (!NewMyStorySegment.a(this.a)) {
          break label143;
        }
      }
      break;
    }
    label143:
    for (paramView = "1";; paramView = "2")
    {
      StoryReportor.a("mystory", "clk_fold", 0, 0, new String[] { paramView, "2" });
      StoryReportor.a("home_page", "exp_share_day", 0, 0, new String[0]);
      return;
      NewMyStorySegment.a(this.a, NewMyStorySegment.a(this.a), paramView);
      return;
      bool = false;
      break;
    }
    label149:
    NewMyStorySegment.a(this.a, NewMyStorySegment.a(this.a), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oge
 * JD-Core Version:    0.7.0.1
 */