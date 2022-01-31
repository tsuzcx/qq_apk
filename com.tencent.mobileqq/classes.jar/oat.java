import android.view.View;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class oat
  extends ChildViewClickListener
{
  public oat(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public void a(int paramInt, View paramView, Object paramObject, BaseViewHolder paramBaseViewHolder)
  {
    if (paramView == paramBaseViewHolder.a())
    {
      StoryReportor.a("home_page", "clk_album", 0, 0, new String[0]);
      this.a.a.b("last_click_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      LocalVideoPushSegment.a(this.a).a(NetConnInfoCenter.getServerTimeMillis());
      LocalVideoPushSegment.a(this.a);
      this.a.a_(null);
    }
    do
    {
      return;
      if (paramView == paramBaseViewHolder.a(2131371851))
      {
        StoryReportor.a("home_page", "close_album", 0, 0, new String[0]);
        this.a.a.b("last_cancel_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        this.a.a_(null);
        this.a.c(true);
        return;
      }
    } while (paramView != paramBaseViewHolder.a(2131371853));
    StoryReportor.a("home_page", "clk_album", 0, 0, new String[0]);
    this.a.a.b("last_click_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    LocalVideoPushSegment.a(this.a).a(NetConnInfoCenter.getServerTimeMillis());
    LocalVideoPushSegment.a(this.a);
    this.a.a_(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oat
 * JD-Core Version:    0.7.0.1
 */