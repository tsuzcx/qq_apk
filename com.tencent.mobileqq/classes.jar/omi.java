import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

public class omi
  implements HorizontalListView.OnScrollStateChangedListener
{
  public omi(ScrollFrameSelectBar paramScrollFrameSelectBar) {}
  
  public void a(int paramInt)
  {
    SLog.a("Q.qqstory.frameWidget.ScrollFrameSelectBar", "onScrollStateChanged:%s", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
    case 4098: 
    case 4099: 
      do
      {
        return;
      } while (!ScrollFrameSelectBar.a(this.a).isPlaying());
      ScrollFrameSelectBar.a(this.a).b();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omi
 * JD-Core Version:    0.7.0.1
 */