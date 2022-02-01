import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class otf
  implements TopGestureLayout.OnGestureListener
{
  public otf(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void flingLToR()
  {
    ReadInJoyChannelActivity.a(this.a, true);
    this.a.finish();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otf
 * JD-Core Version:    0.7.0.1
 */