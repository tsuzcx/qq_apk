import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;
import com.tencent.widget.ActionSheet.WatchDismissActions;

public class mfp
  implements ActionSheet.WatchDismissActions
{
  public mfp(VideoShareHelper paramVideoShareHelper) {}
  
  public void a()
  {
    if (VideoShareHelper.c(this.a))
    {
      VideoShareHelper.c(this.a, false);
      VideoShareHelper.a(this.a).a(VideoShareHelper.a(this.a), VideoShareHelper.b(this.a), true, false);
      return;
    }
    VideoShareHelper.a(this.a).a(VideoShareHelper.a(this.a), VideoShareHelper.b(this.a), true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfp
 * JD-Core Version:    0.7.0.1
 */