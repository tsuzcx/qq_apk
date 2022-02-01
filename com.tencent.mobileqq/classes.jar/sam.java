import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;

public class sam
  extends pmn
{
  private sam(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (VideoFeedsPlayActivity.a(this.a).getVisibility() == 0))
    {
      VideoFeedsPlayActivity.b(this.a, true);
      localrar = new rar(this.a);
      localrar.a(paramString);
      localrar.a(RIJRedPacketManager.a().d());
      localrar.showAsDropDown(VideoFeedsPlayActivity.a(this.a), 0, -bgtn.a(10.0F));
    }
    while (!paramBoolean)
    {
      rar localrar;
      return;
    }
    VideoFeedsPlayActivity.a(this.a).setVisibilityChangedListener(new san(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sam
 * JD-Core Version:    0.7.0.1
 */