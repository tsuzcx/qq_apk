import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareListener;

public class lfl
  extends VideoShareListener
{
  public lfl(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!paramBoolean1) {
      ReadInJoyVideoSubChannelActivity.a(this.a, false);
    }
    while (!ReadInJoyVideoSubChannelActivity.a(this.a)) {
      return;
    }
    ReadInJoyVideoSubChannelActivity.a(this.a).b();
    ReadInJoyVideoSubChannelActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfl
 * JD-Core Version:    0.7.0.1
 */