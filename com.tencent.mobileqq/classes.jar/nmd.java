import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.child.VidListPlayMode;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.ArrayList;

public class nmd
  extends IPlayVideoStatusChangeListener
{
  public nmd(VidListPlayMode paramVidListPlayMode) {}
  
  public void c(int paramInt)
  {
    if (paramInt < this.a.a.a.size() - 1) {
      StoryReportor.a("content_flow", "switch_play", 0, 0, new String[] { VidListPlayMode.a(this.a), "", "", "" });
    }
  }
  
  public void d(int paramInt)
  {
    StoryReportor.a("content_flow", "switch_play", 0, 0, new String[] { VidListPlayMode.a(this.a), "", "", "" });
  }
  
  public void e(int paramInt)
  {
    StoryReportor.a("content_flow", "switch_play", 0, 0, new String[] { VidListPlayMode.a(this.a), "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmd
 * JD-Core Version:    0.7.0.1
 */