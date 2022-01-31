import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;

public class rfm
  extends oxe
{
  private rfm(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (VideoFeedsPlayActivity.a(this.a).getVisibility() == 0))
    {
      VideoFeedsPlayActivity.b(this.a, true);
      localqhj = new qhj(this.a);
      localqhj.a(paramString);
      localqhj.a(RIJRedPacketManager.a().d());
      localqhj.showAsDropDown(VideoFeedsPlayActivity.a(this.a), 0, -bdoo.a(10.0F));
    }
    while (!paramBoolean)
    {
      qhj localqhj;
      return;
    }
    VideoFeedsPlayActivity.a(this.a).setVisibilityChangedListener(new rfn(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rfm
 * JD-Core Version:    0.7.0.1
 */